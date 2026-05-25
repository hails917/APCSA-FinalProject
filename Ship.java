public class Ship
{
    // Copy your ship class from Part 1.
    private int row;
    private int col;
    private int length;
    private int direction;
    
    private static final int UNSET = -1;
    private static final int HORIZONTAL = 0;
    private static final int VERTICAL = 1;
    
    public Ship(int length){
        this.length = length;
        direction = UNSET;
        row = UNSET;
        col = UNSET;
        
    }
    
    public boolean isLocationSet(){
        if (row == UNSET && col == UNSET){
            return false;
        }else{
            return true;
        }
    }
    
    public boolean isDirectionSet(){
        if (direction == UNSET){
            return false;
        }else{
            return true;
        }
    }
    
    public void setLocation(int row, int col){
        this.row = row;
        this.col = col;
    }
    
    public void setDirection(int direction){
        this.direction = direction;
    }
    
    public int getRow(){
        return row;
    }
    
    public int getCol(){
        return col;
    }
    
    public int getLength(){
        return length;
    }
    
    public int getDirection(){
        return direction;
    }
    
    private String directionToString(){
        if (direction == VERTICAL){
            return "vertical ship ";
        }else if (direction == HORIZONTAL){
            return "horizontal ship ";
        }else{
            return "unset direction ship ";
        }
    }
    
    private String locationToString(){
        if (row != UNSET && col != UNSET){
            return "(" + row + ", " + col + ")";
        }else{
            return "(unset location)";
        }
    }
    
    public String toString(){
        return directionToString() + "of length " + length + " at " + locationToString();
    }
}
