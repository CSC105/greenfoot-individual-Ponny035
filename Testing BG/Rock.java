import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    private int damage = 0;
    /**
     * Act - do whatever the Rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        moveLeft();
    } 
    
    private void moveLeft() {
        setLocation(getX()-speed, getY());
        if(onTop()) {
           count++; 
           System.out.println("p"+count);
        }
        if(damage()) {
            damage++;
            System.out.println("np"+damage);
        }
        if(count == 10) {
            speed++;
            count = 0 ;
        }
    }
    
    private void CheckSpawn(boolean edge) {
        if(edge) {
            
        }
    }
    
    private boolean onTop() {
        Actor up = getOneObjectAtOffset (0, -100, Flamigo.class);
        return up != null;
    }
    
    private boolean damage() {
        Actor up = getOneObjectAtOffset (30, -45, Flamigo.class);
        return up != null;
    }
}
