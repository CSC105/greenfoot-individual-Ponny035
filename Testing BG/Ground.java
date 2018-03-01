import greenfoot.*;

/**
 * Write a description of class Ground here.
 * 
 * @author Patipol Saechan 
 * @version 1.0
 */
public class Ground extends Actor
{
    static final boolean TEXTURE = true;
    int speed = 10;
    boolean world = false;
    
    public Ground () {
    
    }
    
    public Ground (boolean x) {
        world = x; 
    }
    
    public void act() 
    {
        if(world) {
            setSpeed(((MyWorld)getWorld()).getSpeed ());
        }
        moveLeft();
        checkSpawn();
    }
    
    private void moveLeft() {
        setLocation(getX()-speed, getY());
    }
    
    private void checkSpawn() {
        if(getX() <= -600) {
           setSpeed(((MyWorld)getWorld()).getSpeed ());
            super.setLocation(1200 + (getX() + 600),395);
        }
    } 
    
    public void setSpeed (int speed) {
        this.speed = speed;
    }
}
