import greenfoot.*; 
/**
 * Write a description of class Ground here.
 * 
 * @author Patipol Saechan 
 * @version 1.0
 */
public class PlayButton extends Actor
{
    private GreenfootImage image;
    private boolean isActive = true;
    
    public PlayButton(){
      image = new GreenfootImage("play.png");
      image.scale(150,150);
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
            getWorld().addObject( new Red_Algae(), 1500, 296 );
            getWorld().addObject( new Rock(), 1000, 307 );
            getWorld().removeObjects( getWorld().getObjects(SpaceToPlay.class));
            getWorld().addObject( new Rock(), 2000, 307 );
            getWorld().addObject( new Score(), 500, 39);
            getWorld().removeObject(this);
        }
    }    
}
