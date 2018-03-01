import greenfoot.*; 

/**
 * Write a description of class Ground here.
 * 
 * @author Patipol Saechan 
 * @version 1.0
 */
public class easy extends level
{
    public easy() {
        super("easy.png");
    }
    
    public void act() 
    {
       super.checkKeys();
       if(!isActive) {
            Greenfoot.start();
            Greenfoot.setWorld(new MyWorld(60,5));
            getWorld().removeObject(this);
        }
    }    
}
