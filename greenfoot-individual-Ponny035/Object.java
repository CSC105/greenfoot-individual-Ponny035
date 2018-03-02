import greenfoot.*;  

/**
 * Write a description of class Ground here.
 * 
 * @author Patipol Saechan 
 * @version 1.3
 */
public class Object extends Actor
{
    private int speed = 5;
    private int count = 0;
    
    public void moveLeft() {
        setSpeed(((MyWorld)getWorld()).getSpeed ());
        setLocation(getX()-speed, getY());
        if(count==10) {
            speed++;
            count = 0 ;
        }
    }
    
    public void setSpeed (int speed) {
        this.speed = speed;
    }
}
