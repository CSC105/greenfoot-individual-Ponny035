import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Alligator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alligator extends Actor
{
    /**
     * Act - do whatever the Alligator wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       if(super.getRotation()==180) {
           //sss
        }
       if(super.isAtEdge()) {
           turn(180);
           move(1);
        }
       else {
           move(1);
        } 
        //checkKeys();
    }    
    private void checkKeys() {
        int x = getX();
        int y = getY();
        if(Greenfoot.isKeyDown("left")) {
            setLocation(x-2, y);
        }
        if(Greenfoot.isKeyDown("right")) {
            setLocation(x+2, y);
        }
    }
        
}
