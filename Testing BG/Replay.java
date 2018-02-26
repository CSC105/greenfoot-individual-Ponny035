import greenfoot.*; 

/**
 * Write a description of class Ground here.
 * 
 * @author Patipol Saechan 
 * @version 1.0
 */
public class Replay extends Actor
{
    private GreenfootSound soundTrack;
    private GreenfootImage image;
    private boolean isActive = true;

     public Replay() {
         image = new GreenfootImage("replay.png");
         image.scale(100,100);
         setImage( image );
    }
    
    private void checkKeys() {
        if (Greenfoot.isKeyDown("Space") || Greenfoot.mouseClicked(this)) {
            isActive = false;
        }
    }
    
    public void act() 
    {
       checkKeys();
       if(!isActive) {
            Greenfoot.start();
            Greenfoot.setWorld(new Start());
            getWorld().removeObject(this);
        }
    }    
}
