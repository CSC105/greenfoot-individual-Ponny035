 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Patipol Saechan 
 * @version 1.3
 */
public class MyWorld extends World
{
    public static int MODE;
    public static int HIGHSCORE1 = 0;
    public static int HIGHSCORE2 = 0;
    public static int HIGHSCORE3 = 0;
    public int speed = 5;
    public int score = 0;
    private int count = 0;
    private int SCORE;
    
    public MyWorld( int health,int  speed) {
        super(600, 400, 1, false);
        int HEALTH=16;
        this.speed = speed;
        addObject( new BackGround(), 0, 130 );
        addObject( new BackGround(), 1006, 130 );
        addObject( new Flamingo(health), 84, 294 );
        for(int i=12; i<=health;i+=12 ) {
            addObject( new Health(i), (HEALTH+30), 39 );
            HEALTH = HEALTH+30;
        }
        addObject( new Ground(true), 0, 395 );
        addObject( new Ground(true), 600, 395 );
        addObject( new SpaceToPlay(), 300, 200);
        switch (health) {
            case 12: 
                SCORE = 40;
                MODE = 1;
                break;
            case 36: 
                SCORE = 50;
                MODE = 2;
                break;
            case 60: 
                SCORE = 100;
                MODE = 3;
                break;
        }
        Greenfoot.start();
    }
    
    public void setHigh3(int score) {
        if(score>=HIGHSCORE3) {
            HIGHSCORE3 = score;
        }
    }
    
    public void setHigh2(int score) {
        if(score>=HIGHSCORE2) {
            HIGHSCORE2 = score;
        }
    }
    
    public void setHigh1(int score) {
        if(score>=HIGHSCORE1) {
            HIGHSCORE1 = score;
        }
    }
    
    public int getScore() {
        return score;
    }
    
    public void setScore() {
        if(count == (SCORE-(speed%SCORE))) {
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
