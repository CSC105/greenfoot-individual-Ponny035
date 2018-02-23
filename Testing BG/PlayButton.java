import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayButton extends Actor
{
    /**
     * Act - do whatever the PlayButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage image;
    private boolean isActive = true;
    
    public PlayButton(){
      image = new GreenfootImage("play.png");
      image.scale(150,150);
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
        // Add your action code here.
        checkKeys();
        if(!isActive) {
            Greenfoot.start();
            getWorld().addObject( new Red_Algae(), 1500, 296 );
            getWorld().addObject( new Rock(), 1000, 307 );
            getWorld().removeObject(this);
        }
    }    
}
