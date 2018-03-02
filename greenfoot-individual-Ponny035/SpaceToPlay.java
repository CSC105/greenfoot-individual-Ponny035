import greenfoot.*;  
/**
 * Write a description of class Ground here.
 * 
 * @author Patipol Saechan 
 * @version 1.3
 */
public class SpaceToPlay extends Button
{
    private GreenfootImage image;
    
    public SpaceToPlay() {
        super("SpaceToPlay.png");
        setImage("SpaceToPlay.png");
    }
    
    public void act() 
    {
        Greenfoot.delay(5);
        checkKeys();
        active(isActive);
    }
    
    private void active(boolean active) {
        if(active) {
            Greenfoot.start();
            getWorld().addObject( new RedAlgae(), 1500, 296 );
            getWorld().addObject( new Rock(), 1000, 307 );
            getWorld().addObject( new Rock(), 2000, 307 );
            getWorld().addObject( new HighScore(), 450, 39);
            getWorld().addObject( new Score(), 450, 69);
            getWorld().addObject( new Coin(), 2500, 300);
            getWorld().removeObject(this);
        }
    }
}
