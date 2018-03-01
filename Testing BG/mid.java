import greenfoot.*;  

/**
 * Write a description of class Ground here.
 * 
 * @author Patipol Saechan 
 * @version 1.0
 */
public class mid extends level
{
    public mid() {
        super("mid.png");
    }
    
    public void act() 
    {
       super.checkKeys();
       if(!isActive) {
            Greenfoot.start();
            Greenfoot.setWorld(new MyWorld(36,8));
            getWorld().removeObject(this);
        }
    }    
}
