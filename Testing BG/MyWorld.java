import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Patipol Saechan 
 * @version 1.0
 * add more
 *  watch
 *  black panther
 * Bug fix
 *  - sound track
 */
public class MyWorld extends World
{
    //private GreenfootSound soundTrack;
    int speed = 5;
    int score = 0;
    int CSCORE = 0;
    private int count = 0;
    
    public MyWorld( int health) {
        super(600, 400, 1, false);
        int x=16;
        addObject( new BackGroud(), 0, 130 );
        addObject( new BackGroud(), 1006, 130 );
        addObject( new Flamingo(health), 84, 294 );
        for(int i=12; i<=health;i+=12 ) {
            addObject( new Health(i), (x+30), 39 );
            x= x+30;
        }
        addObject( new Ground(true), 0, 395 );
        addObject( new Ground(true), 600, 395 );
        addObject( new PlayButton(), 300, 200);
        addObject( new SpaceToPlay(), 300, 365);
        Greenfoot.start();
        switch (health) {
            case 12: 
                CSCORE = 40;
                break;
            case 36: 
                CSCORE = 50;
                break;
            case 60: 
                CSCORE = 100;
                break;
        }
    }
    
    public int getScore () {
        return score;
    }
    
    public void setScore() {
        if(count == (CSCORE-speed)) {
            score++;
            count=0;
        }
        else {
            count++;
        }
    }
    
    public void setScore(int score) {
        this.score = this.score+score;
    }
    
    public void setSpeed(int speed) {
        this.speed = this.speed+speed;
    }
    
    public int getSpeed() {
        return speed;
    }
}
