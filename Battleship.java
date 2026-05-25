public class Battleship extends ConsoleProgram
{
    public void run()
    {
        boolean gameOver = false;
        boolean p1Turn = true;
        
        System.out.println("BATTLESHIP BEGINS");
        
        Player p1 = new Player();
        Player p2 = new Player();
        
        System.out.println("Player 1 layout ");
        p1.printMyShips();
        
        System.out.println("Player 2 layout");
        p2.printMyShips();
        
        while (!gameOver){
            if (p1Turn){
                System.out.println("PLAYER 1'S TURN");
                
                askForGuess(p1,p2);
                
                if (p2.allShipsSunk()){
                    System.out.println("PLAYER 1 WINS");
                    gameOver = true;
                }
            }else{
                System.out.println("PLAYER 2'S TURN");
                askForGuess(p2,p1);
                if (p1.allShipsSunk()){
                    System.out.println("PLAYER 2 WINS");
                    gameOver = true;
                }
                
            }
            p1Turn = !p1Turn;
        }
        
        System.out.println("GAME OVER");
    }
    
    private void askForGuess(Player current, Player opp){
        int row = readInt("Choose target row (0,9): ");
        int col = readInt("Choose target col (0,9): ");
        
        System.out.println("Firing at coordinates (" + row + ", " + col + ")...");
        
        boolean hit = opponent.recordOpponentGuess(row,col);
        
        if (hit){
            System.out.println("Direct hit!");
        }else{
            System.out.println("Missed! Good luck next time");
        }
        current.recordMyGuess(row,col,hit);
    }
}