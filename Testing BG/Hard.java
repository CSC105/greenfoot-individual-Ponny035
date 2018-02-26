import greenfoot.*; 

/**
 * Write a description of class Hard here.
 * 
 * @author Patipol Saechan 
 * @version 1.0
 */
public class Hard extends level
{
    public Hard() {
        super("hard.png");
    }
    
    public void act() 
    {
        super.checkKeys();
        if(!isActive) {
            Greenfoot.start();
            Greenfoot.setWorld(new MyWorld(12));
            getWorld().removeObject(this);
        }
    }    
}
