import greenfoot.*; 
import java.util.*;
/**
 * Write a description of class Flamingo here.
 * 
 * @author Patipol Saechan
 * @version 1.0
 */
public class Flamingo extends Actor
{
    private GreenfootSound soundTrack;
    private Animation anime;
    private GreenfootImage image;
    private boolean isHitting = false;
    private int gravity = 1;
    private int vSpeed = 0;
    private int maxHealth = 60;
    private int Health = 60; // max 60
    private int count = 0;
    Score score = new Score();
    
    public Flamingo(){
      anime = new Animation( "Flamingo", 36, 50, 75 );
      setImage(anime.getFrame());
    }
    
    public Flamingo(int health){
      Health = health;
      maxHealth = health;
      anime = new Animation( "Flamingo", 36, 50, 75 );
      setImage(anime.getFrame());
      soundTrack = new GreenfootSound( "Soft Kitty.wav" );
      soundTrack.playLoop();
    }
    
    public void act() 
    {
        checkKeys();
        checkFall();
        checkPlay();
        checkDead(Health);
        score.countScore();
        if (count == 10) {
            ((MyWorld)getWorld()).setSpeed (1);
            count = 0;
        }
    }
    
    public int getHP() {
        return Health;
    }
    
    private void checkPlay() {
       List objectslookingfor = getWorld().getObjects(PlayButton.class);
       if (objectslookingfor.size() == 0) {
           checkEat(((Red_Algae) getWorld().getObjects(Red_Algae.class).get(0)).getX(), ((Red_Algae) getWorld().getObjects(Red_Algae.class).get(0)).getY());
           checkDamage(((Rock) getWorld().getObjects(Rock.class).get(0)).getX(), ((Rock) getWorld().getObjects(Rock.class).get(0)).getY());
       }
    }
    
    public void checkDead(int HP) {
        if(HP >= 12) {
            setImage(anime.getFrame());  
        }
        else {
            soundTrack.stop();
            Greenfoot.playSound("Dead.wav");
            Greenfoot.delay(100);
            System.out.println(score.getScore() );
            Greenfoot.setWorld( new End(score.getScore()));
        }
    }
    
    private void checkDamage(int x, int y) {
        int myX = getX();
        int myY = getY();
        isHitting = false ;
        List<Rock> rocks = this.getIntersectingObjects(Rock.class);
        Rock rock = rocks.size() > 0 ? rocks.get(0) : null;
        if((Math.abs(x-myX)<=29) && (Math.abs(y-myY)<=29) && rock != null && !rock.getHit()) {
            Health -= 12; 
            count++;
            isHitting = true ;
            rock.setHit(true);
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
        if((Math.abs(x-myX) <= 29) && (Math.abs(y-myY) <= 29)) {
            Greenfoot.playSound("Eat.wav");
            int newX = 0;
            while(newX < 5000) {
                newX = Greenfoot.getRandomNumber(20000);  
            }
            getWorld().removeObjects( (Collection)getWorld().getObjects(Red_Algae.class) );
            getWorld().addObject( new Red_Algae(), newX, 296 );
            if(Health != maxHealth) {
                Greenfoot.playSound("Eat.wav");
                Health += 12;
                setImage(anime.getEat());
                Greenfoot.delay(4);
                setImage(anime.getFrame());
                Greenfoot.delay(4);
                setImage(anime.getEat());
                Greenfoot.delay(4);
                setImage(anime.getFrame());
            }
           
            if(Health > 60) {
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
        if (Greenfoot.isKeyDown("Space") && onGround() && !(isHitting)) {
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
