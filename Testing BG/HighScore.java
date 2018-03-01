import greenfoot.*;  
import java.*;
/**
 * Write a description of class Ground here.
 * 
 * @author Patipol Saechan 
 * @version 1.0
 */
public class HighScore extends Actor
{
    public HighScore() {
    
    }
    
    public void act() 
    {
        printHigh();
    }

    public void printHigh() {
        switch (MyWorld.MODE) {
            case 1: ;
                setImage(new GreenfootImage("High Score : "+MyWorld.HIGHSCORE1, 24, Color.RED, new Color(0,0,0,0)));
                break;
            case 2: 
                setImage(new GreenfootImage("High Score : "+MyWorld.HIGHSCORE2, 24, Color.RED, new Color(0,0,0,0)));
                break;
            case 3: 
                setImage(new GreenfootImage("High Score : "+MyWorld.HIGHSCORE3, 24, Color.RED, new Color(0,0,0,0)));
                break;
        }
    }
}
