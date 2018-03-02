import greenfoot.*; 

/**
 * Write a description of class Ground here.
 * 
 * @author Patipol Saechan 
 * @version 1.3
 */
public class Replay extends Button
{
     public Replay() {
         super("replay.png");
    }
    
    public void act() 
    {
       checkClick();
       active(isActive);
    }  
    
    private void active(boolean active) {
        if(active) {
            Greenfoot.start();
            Greenfoot.setWorld(new Start());
            getWorld().removeObject(this);
        }
    }
}
