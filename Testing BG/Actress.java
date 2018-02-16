import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Actress here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Actress extends Actor
{
    /**
     * Act - do whatever the Actress wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage image;
    private boolean isRight;
    public Actress(){
      image = new GreenfootImage("player.png");
      setImage( image );
      isRight = true;
    }
    public void act() 
    {
        checkKeys();
    }    
    private void checkKeys() {
        int x = getX();
        int y = getY();
        if(Greenfoot.isKeyDown("a")) {
            if( isRight ){
              isRight = false;
              image.mirrorHorizontally();
              setImage( image );
            }
            setLocation(x-2, y);
        }
        if(Greenfoot.isKeyDown("d")) {
            if( !isRight ){
              isRight = true;
              image.mirrorHorizontally();
              setImage( image );
            }
            setLocation(x+2, y);
        }
    }
}
