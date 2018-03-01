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
    private boolean isCheating = false;
    private boolean spacePressed = false;
    private int gravity = 1;
    private int vSpeed = 0;
    private int maxHealth = 60;
    private int Health = 60; // max 60
    private int count = 0;
    private int countJump = 2;
    
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
      soundTrack.setVolume(50);
    }
    
    public void act() 
    {
        checkKeys();
        checkFall();
        checkPlay();
        checkDead(Health);
        ((MyWorld)getWorld()).setScore ();
        setHigh();
        if (count == 10) {
            ((MyWorld)getWorld()).setSpeed (1);
            count = 0;
        }
        cheating(isCheating);
    }
    
    public void setHigh() {
        switch (MyWorld.MODE) {
            case 1: ;
                ((MyWorld)getWorld()).setHigh1(((MyWorld)getWorld()).getScore ());
                break;
            case 2: 
                ((MyWorld)getWorld()).setHigh2(((MyWorld)getWorld()).getScore ());
                break;
            case 3: 
                ((MyWorld)getWorld()).setHigh3(((MyWorld)getWorld()).getScore ());
                break;
        }
    }
    
    public int getHP() {
        return Health;
    }
    
    private void checkPlay() {
       List objectslookingfor = getWorld().getObjects(PlayButton.class);
       if (objectslookingfor.size() == 0) {
           checkEat(((Red_Algae) getWorld().getObjects(Red_Algae.class).get(0)).getX(), ((Red_Algae) getWorld().getObjects(Red_Algae.class).get(0)).getY());
           checkCoin(((Coin) getWorld().getObjects(Coin.class).get(0)).getX(), ((Coin) getWorld().getObjects(Coin.class).get(0)).getY());
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
            setHigh();
            Greenfoot.setWorld( new End(((MyWorld)getWorld()).getScore()));
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
            isHitting = true ;
            rock.setHit(true);
            GreenfootSound sound = new GreenfootSound("Damage.wav");
            sound.setVolume(25);
            sound.play();
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
            GreenfootSound sound = new GreenfootSound("Eat.wav");
            sound.setVolume(50);
            sound.play();
            int newX = 0;
            while(newX < 5000) {
                newX = Greenfoot.getRandomNumber(20000);  
            }
            getWorld().removeObjects( (Collection)getWorld().getObjects(Red_Algae.class) );
            getWorld().addObject( new Red_Algae(), newX, 296 );
            if(Health != maxHealth) {
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
            ((MyWorld)getWorld()).setScore (25);
        }
    }
    
    private void checkCoin(int x, int y) {
        int myX = getX();
        int myY = getY();
        if((Math.abs(x-myX) <= 29) && (Math.abs(y-myY) <= 29)) {
           GreenfootSound sound = new GreenfootSound("Coin.wav");
           sound.setVolume(80);
           sound.play();
           int newX = 0;
           while(newX < 5000) {
               newX = Greenfoot.getRandomNumber(10000);  
           }
           getWorld().removeObjects( (Collection)getWorld().getObjects(Coin.class) );
           getWorld().addObject( new Coin(), newX, 296 );
           ((MyWorld)getWorld()).setScore (50);
        }
    }
    
    private void countJump() {
            countJump--;
    }

    private void checkKeys() {
        int x = getX();
        int y = getY();
        GreenfootImage m = new GreenfootImage(anime.getFrame());
        if (Greenfoot.isKeyDown("Space") && !(isHitting) && (countJump>0)) {
            if (!spacePressed) {
                count++;
                GreenfootSound sound = new GreenfootSound("jump.wav");
                sound.setVolume(75);
                sound.play();
                if(countJump==2) {
                    vSpeed = -20;
                }
                else {
                    vSpeed = -15;
                }
                countJump();
                spacePressed = true;
            }
            fall();
        }
        else {
            spacePressed = false;
        }
    }  
    
    private void cheating (boolean x) {
        if (Greenfoot.isKeyDown("c")) {
            isCheating = true;
        }
        if (Greenfoot.isKeyDown("v")) {
            isCheating = false;
        }
        if(x) {
            ((MyWorld)getWorld()).setScore (50);
        }
    }
    
    private boolean onGround() {
        Actor under = getOneObjectAtOffset (0, 37, Ground.class);
        if(under != null) {
            countJump =2;
        }
        return under != null;
    }

    private void checkFall(   ) {
        if(onGround()) {
            vSpeed = 0;
            setLocation(getX(), 294);
        }
        else {
            fall();
        }
    }
    
    private void fall() {
        if(getY()<=48) {
            vSpeed=1;
        }
        setLocation(getX(), getY()+vSpeed);
        vSpeed = vSpeed + gravity;
    } 
}
