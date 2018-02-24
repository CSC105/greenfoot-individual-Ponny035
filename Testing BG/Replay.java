import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Replay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Replay extends Actor
{
    private GreenfootImage image;
    private boolean isActive = true;
    /**
     * Act - do whatever the Replay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     public Replay() {
         image = new GreenfootImage("replay.png");
         image.scale(100,100);
         setImage( image );
      //anime = new Animation( "heart", 2, 25, 25 );
      //setImage(anime.getFrame());
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
            Greenfoot.setWorld(new MyWorld());
            getWorld().removeObject(this);
        }
    }    
}
