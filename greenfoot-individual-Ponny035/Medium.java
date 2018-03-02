import greenfoot.*;  

/**
 * Write a description of class Ground here.
 * 
 * @author Patipol Saechan 
 * @version 1.3
 */
public class Medium extends Button
{
    public Medium() {
        super("mid.png");
    }
    
    public void act() 
    {
       super.checkClick();
       active(isActive);
    }
    
    private void active(boolean active) {
        if(active) {
            Greenfoot.start();
            Greenfoot.setWorld(new MyWorld(36,8));
            getWorld().removeObject(this);
        }
    }
}
