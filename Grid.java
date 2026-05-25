public class Grid
{
    // Write your Grid class here
    private Location[][] grid;
    
    public static final int NUM_ROWS = 10;
    public static final int NUM_COLS = 10;
    
    public Grid(){
        grid = new Location [NUM_ROWS][NUM_COLS];
        for (int r = 0; r < NUM_ROWS; r++){
            for (int c = 0; c < NUM_COLS; c++){
                grid[r][c] = new Location();
            }
        }
    }
    
    public void markHit(int row, int col){
        grid[row][col].markHit();
    }
    
    public void markMiss(int row, int col){
        grid[row][col].markMiss();
        
    }
    
    public void setStatus(int row, int col, int status){
        grid[row][col].setStatus(status);
    }
    
    public int getStatus(int row, int col){
        return grid[row][col].getStatus();
    }
    
    public boolean alreadyGuessed(int row, int col){
        if (grid[row][col].isUnguessed() == true){
            return false;
        }else{
            return true;
        }
    }
    public void setShip(int row, int col, boolean val){
        grid[row][col].setShip(val);
    }
    
    public boolean hasShip(int row, int col){
        return grid[row][col].hasShip();
    }
    
    public Location get(int row, int col){
        return grid[row][col];
    }
    
    public int numRows(){
        return grid.length;
    }
    
    public int numCols(){
        return grid[0].length;
    }
    
    public void printStatus(){
        for (int c = 1; c <= NUM_COLS; c++){
            System.out.print(" " + c);
        }
        System.out.println();
        
        String l = "ABCDEFGHIJ";
        
        for (int r = 0; r < NUM_ROWS; r++){
            System.out.print(l.substring(r, r + 1) + " ");
            for (int c = 0; c < NUM_COLS; c++){
                int status = getStatus(r,c);
                
                if (status == 1){
                    System.out.print("X ");
                }else if (status == 2){
                    System.out.print("O ");
                }else{
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
    
    public void printShips(){
                System.out.print(" ");
        for (int c = 1; c <= NUM_COLS; c++){
            System.out.print(c + " ");
        }
        System.out.println();
        
        String l = "ABCDEFGHIJ";
        
        for (int r = 0; r < NUM_ROWS; r++){
            System.out.print(l.substring(r, r + 1) + " ");
            for (int c = 0; c < NUM_COLS; c++){
                
                if (hasShip(r,c)){
                    System.out.print("X ");
                }else{
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
    
    public void addShip(Ship s){
        for (int i = 0; i < s.getLength(); i++){
            if (s.getDirection() == 1 ){ //if vertical
                get(s.getRow() + i, s.getCol()).setShip(true);
            }else if (s.getDirection() == 0){ //if horizontal
                get(s.getRow(), s.getCol() + i).setShip(true);
            }
        }
    }
}
