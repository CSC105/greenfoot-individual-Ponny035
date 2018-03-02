import greenfoot.*;

/**
 * Write a description of class Ground here.
 * 
 * @author Patipol Saechan 
 * @version 1.3
 */
public class Ground extends Object
{
    boolean move = false;
    
    public Ground () {
    
    }
    
    //set move check
    public Ground (boolean x) {
        move = x; 
    }
    
    public void act() 
    {
        if(move) {
            moveLeft();
        }
        checkSpawn();
    }
    
    private void checkSpawn() {
        if(getX() <= -600) {
           setSpeed(((MyWorld)getWorld()).getSpeed ());
           super.setLocation(1200 + (getX() + 600),395);
        }
    } 
}
