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
    private int count = 0;
    Flamigo nok = new Flamigo();
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
        x = ((Flamigo) getWorld().getObjects(Flamigo.class).get(0)).getX();
        y = ((Flamigo) getWorld().getObjects(Flamigo.class).get(0)).getY();
        checkSpawn(getX() < -25);
    } 
    
    private void moveLeft() {
        setLocation(getX()-speed, getY());
        /*if(damage()) {
            damage++;
            System.out.println("np"+damage);
        }*/
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
 
}
