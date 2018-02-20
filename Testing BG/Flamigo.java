import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Flamigo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flamigo extends Actor
{
    /**
     * Act - do whatever the Flamigo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Animation anime;
    private GreenfootImage image;
    private boolean isRight;
    private int direct=1;
    private int gravity = 2;
    private int vSpeed = 0;
    private int Health = 60; // max 60
    private int count = 0;
    public int getHP () {
        return Health;
    }
    
    public Flamigo(){
      anime = new Animation( "Flamingo", 36, 50, 75 );
      setImage(anime.getFrame());
    }
    
    public void act() 
    {
        // Add your action code here.
        checkKeys();
        checkFall();
        checkEat(((Red_Algae) getWorld().getObjects(Red_Algae.class).get(0)).getX(), ((Red_Algae) getWorld().getObjects(Red_Algae.class).get(0)).getY());
        checkDamage(((Rock) getWorld().getObjects(Rock.class).get(0)).getX(), ((Rock) getWorld().getObjects(Rock.class).get(0)).getY());
        checkDead(Health);
        Greenfoot.delay(2);
        //setImage(anime.getDamage(5));
        //Greenfoot.playSound("Soft Kitty.wav");
    } 
    public void checkDead(int HP) {
        if(HP>12) {
          setImage(anime.getFrame());  
        }
        else {
            // dead pic
        }
    }
    
    private void checkDamage(int x, int y) {
        int myX = getX();
        int myY = getY();
        if((Math.abs(x-myX)<=29)&&(Math.abs(y-myY)<=29)) {
           Health--;
           count++;
        }
    }
    
    private void checkEat(int x, int y) {
        int myX = getX();
        int myY = getY();
        if((Math.abs(x-myX)<=29)&&(Math.abs(y-myY)<=29)) {
           getWorld().removeObjects( (Collection)getWorld().getObjects(Red_Algae.class) );
           getWorld().addObject( new Red_Algae(), 750, 296 );
           Health+=12;
           if(Health>60) {
               Health = 60;
           }
           count++;
        }
    }
    
    private void checkKeys() {
        int x = getX();
        int y = getY();
        GreenfootImage m = new GreenfootImage(anime.getFrame());
        if(Greenfoot.isKeyDown("Left")) {
            if( isRight ){
              //isRight = false;
              m.mirrorHorizontally();
              
            }
            setImage( m );
            if( x - 2 > 10 )
              setLocation(x-2, y);
        }
        else if(Greenfoot.isKeyDown("Right")) {
            if( !isRight ){
              isRight = true;
              //image.mirrorHorizontally();
              
            }
            setImage( m );
            setLocation(x+2, y);
        }
        else if (Greenfoot.isKeyDown("Space")&&onGround()) {
            Greenfoot.playSound("jump.wav");
            vSpeed = -25;
            fall();
        }
    }  
    
    private boolean onGround() {
        Actor under = getOneObjectAtOffset (0, 45, Ground.class);
        return under != null;
    }

    private void checkFall() {
        if(onGround()) {
            vSpeed = 0;
            setLocation(getX(), 294);
        }
        else {
            fall();
        }
    }
    private void fall() {
        setLocation(getX(), getY()+vSpeed);
        vSpeed = vSpeed + gravity;
    }
}
