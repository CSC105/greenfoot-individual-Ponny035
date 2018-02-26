import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends Actor
{
    private int speed = 5;
    private boolean hit = false;
    private int count = 0;
    Flamingo nok = new Flamingo();
    int x = 0;
    int y = 0;
    int i=0;
    /**
     * Act - do whatever the Rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        moveLeft();
        x = ((Flamingo) getWorld().getObjects(Flamingo.class).get(0)).getX();
        y = ((Flamingo) getWorld().getObjects(Flamingo.class).get(0)).getY();
        setSpeed(((MyWorld)getWorld()).getSpeed ());
        checkSpawn(getX() < -25);
    } 
    
    private void moveLeft() {
        setLocation(getX()-speed, getY());
        if(count == 10) {
            speed++;
            count = 0 ;
        }
    }
    
    private void checkSpawn(boolean edge) {
       if(edge) {
           getWorld().addObject( new Rock(), 600, 307 );
           getWorld().removeObject(this);
       }
       else {
           
       } 
    }
    
    public void setHit(boolean Hit) {
        hit = Hit;
    }
    
    public boolean getHit() {
        return hit;
    }
    
    public void setSpeed (int speed) {
        this.speed = speed;
    }
}
