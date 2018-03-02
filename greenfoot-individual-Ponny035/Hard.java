import greenfoot.*; 

/**
 * Write a description of class Hard here.
 * 
 * @author Patipol Saechan 
 * @version 1.3
 */
public class Hard extends Button
{
    public Hard() {
        super("hard.png");
    }
    
    public void act() 
    {
        super.checkClick();
        active(isActive);
    }
    
    private void active(boolean active) {
        if(active) {
            Greenfoot.start();
            Greenfoot.setWorld(new MyWorld(12,10));
            getWorld().removeObject(this);
        }
    }
}
