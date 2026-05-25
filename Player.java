public class Player
{
    // Write your Player class here
    private static final int[] SHIP_LENGTHS = {2,3,3,4,5};
    
    private Grid gridOne;
    private Grid gridTwo;
    private Ship[] ship;
    
    private int shipsPlaced;
    
    public Player(){
        ship = new Ship[SHIP_LENGTHS.length];
        gridOne = new Grid();
        gridTwo = new Grid();
        
        shipsPlaced = 0;
        
        for (int i = 0; i < SHIP_LENGTHS.length; i++){
            ship[i] = new Ship(SHIP_LENGTHS[i]);
        }
    }
    
    public void chooseShipLocation(Ship s, int row, int col, int direction){
        if (shipsPlaced < SHIP_LENGTHS.length){
            s.setLocation(row,col);
            s.setDirection(direction);
            
            gridOne.addShip(s);
            
            shipsPlaced++;
        }
    }
    
    public void printMyShips(){
        gridOne.printShips();
    }
    
    public void printOpponentGuesses(){
        gridOne.printStatus();
    }
    
    public void printMyGuesses(){
        gridTwo.printStatus();
    }
    
    public boolean recordOpponentGuess(int row, int col){
        if (gridOne.hasShip(row,col)){
            gridOne.markHit(row,col);
            return true;
        }else{
            gridOne.markMiss(row,col);
            return false;
        }
    }
    
    public void recordMyGuess(int row, int col, boolean hit){
        if (hit){
            gridTwo.markHit(row, col);
        }else{
            gridTwo.markMiss(row,col);
        }
    }
    
    public boolean allShipsSunk(){
        for (int r = 0; r < gridOne.numRows(); r++){
            for (int c = 0; c < gridOne.numCols(); c++){
                if (gridOne.hasShip(r,c) && gridOne.get(r,c).checkHit() == false){
                    return false;
                }
            }
        }
        return true;
    }
    
    public Ship[] getShips(){
        return ship;
    }
}
