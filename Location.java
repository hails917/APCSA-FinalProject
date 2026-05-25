public class Location
{
    //Implement the Location class here
    private boolean isShipAtLoc;
    private int status;
    
    public static final int UNGUESSED = 0;
    public static final int HIT = 1;
    public static final int MISSED = 2;
    
    public Location(){
        status = UNGUESSED;
        isShipAtLoc = false;
    }
    
    public boolean checkHit(){
        if (status == HIT){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean checkMiss(){
        if (status == MISSED){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean isUnguessed(){
        if (status == UNGUESSED){
            return true;
        }else{
            return false;
        }
    }
    
    public void markHit(){
        status = HIT;
    }
    
    public void markMiss(){
        status = MISSED;
    }
    
    public boolean hasShip(){
        if (isShipAtLoc == true){
            return true;
        }else{
            return false;
        }
    }
    
    public void setShip(boolean val){
        isShipAtLoc = val;
    }
    
    public void setStatus(int status){
        this.status = status;
    }
    
    public int getStatus(){
        return status;
    }
}
