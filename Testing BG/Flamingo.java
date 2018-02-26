import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Flamingo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flamingo extends Actor
{
    /**
     * Act - do whatever the Flamingo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Animation anime;
    private GreenfootImage image;
    private boolean isRight;
    private int direct=1;
    private int gravity = 1;
    private int vSpeed = 0;
    private int Health = 60; // max 60
    private int count = 0;
    private boolean isHitting = false;
    Score score = new Score();
    //GreenfootSound  soundDead = new GreenfootSound( "Dead" );
    public int getHP () {
        return Health;
    }
    
    public Flamingo(){
      anime = new Animation( "Flamingo", 36, 50, 75 );
      setImage(anime.getFrame());
    }
    
    public void act() 
    {
        // Add your action code here.
        checkKeys();
        checkFall();
        checkPlay();
        checkDead(Health);
        score.countScore();
        if (count == 10) {
            ((MyWorld)getWorld()).setSpeed (1);
            count = 0;
        }
        System.out.println(Health);
        //System.out.println(((MyWorld)getWorld()).getSpeed ());
        //setImage(anime.getDamage());
        //Greenfoot.delay(2);
        //setImage(anime.getDamage(5));
        //Greenfoot.playSound("Soft Kitty.wav");
    }
    
    private void checkPlay() {
       List objectslookingfor = getWorld().getObjects(PlayButton.class);
        if (objectslookingfor.size() == 0) {
        checkEat(((Red_Algae) getWorld().getObjects(Red_Algae.class).get(0)).getX(), ((Red_Algae) getWorld().getObjects(Red_Algae.class).get(0)).getY());
        checkDamage(((Rock) getWorld().getObjects(Rock.class).get(0)).getX(), ((Rock) getWorld().getObjects(Rock.class).get(0)).getY());
       }
    }
    public void checkDead(int HP) {
        if(HP>=12) {
          setImage(anime.getFrame());  
          //Greenfoot.playSound("Dead.wav");
        }
        else { //if((HP==0)&&) {
            Greenfoot.playSound("Dead.wav");
            Greenfoot.delay(100);
            System.out.println(score.getScore() );
            Greenfoot.setWorld(new End(score.getScore()));
            //Greenfoot.stop();
        }
    }
    
    private void checkDamage(int x, int y) {
        int myX = getX();
        int myY = getY();
        int oldHP = Health;
        isHitting = false ;
        List<Rock> rocks = this.getIntersectingObjects(Rock.class);
        Rock rock = rocks.size() > 0 ? rocks.get(0) : null;
        if((Math.abs(x-myX)<=29)&&(Math.abs(y-myY)<=29)&& rock != null && !rock.getHit()) {
           Health-= 12; 
           count++;
           isHitting = true ;
           rock.setHit(true);
           //setImage(anime.getDamage());
           //Greenfoot.delay(2);
           Greenfoot.playSound("Damage.wav");
           setImage(anime.getDamage());
           Greenfoot.delay(4);
           setImage(anime.getFrame());
           Greenfoot.delay(4);
           setImage(anime.getDamage());
           Greenfoot.delay(4);
           setImage(anime.getFrame());
        }
    }
    
    private void checkEat(int x, int y) {
        int myX = getX();
        int myY = getY();
        if((Math.abs(x-myX)<=29)&&(Math.abs(y-myY)<=29)) {
            Greenfoot.playSound("Eat.wav");
            int newX=0;
            while(newX<5000) {
               newX=Greenfoot.getRandomNumber(20000);  
            }
            getWorld().removeObjects( (Collection)getWorld().getObjects(Red_Algae.class) );
            getWorld().addObject( new Red_Algae(), newX, 296 );
           if(Health!=60) {
               Greenfoot.playSound("Eat.wav");
               Health+=12;
               setImage(anime.getEat());
               Greenfoot.delay(4);
               setImage(anime.getFrame());
               Greenfoot.delay(4);
               setImage(anime.getEat());
               Greenfoot.delay(4);
               setImage(anime.getFrame());
           }
           
           if(Health>60) {
               Health = 60;
           }
           score.setScore(100);
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
        else if (Greenfoot.isKeyDown("Space")&&onGround()&&!(isHitting)) {
            count++;
            Greenfoot.playSound("jump.wav");
            vSpeed = -20;
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
