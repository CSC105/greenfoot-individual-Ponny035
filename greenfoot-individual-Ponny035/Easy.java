import greenfoot.*; 

/**
 * Write a description of class Ground here.
 * 
 * @author Patipol Saechan 
 * @version 1.3
 */
public class Easy extends Button
{
    public Easy() {
        super("easy.png");
    }
    
    public void act() 
    {
       super.checkClick();
       active(isActive);
    } 
    
    private void active(boolean active) {
        if(active) {
            Greenfoot.start();
            Greenfoot.setWorld(new MyWorld(60,5));
            getWorld().removeObject(this);
        }
    }
}
