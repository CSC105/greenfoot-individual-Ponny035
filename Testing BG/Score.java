import greenfoot.*;  
import java.*;
/**
 * Write a description of class Ground here.
 * 
 * @author Patipol Saechan 
 * @version 1.0
 */
public class Score extends Actor
{
    int score = 0;
    int count =0;
    boolean isEnd = true;
    
    public Score() {
    
    }
    
    public Score(int x) {
        isEnd = false;
        setImage(new GreenfootImage("Score : "+x, 50, Color.BLACK, new Color(0,0,0,0)));
    }
    
    public void act() 
    {
       if(isEnd) {
        setScore();
        setImage(new GreenfootImage("Score : "+score, 24, Color.BLACK, new Color(0,0,0,0)));
       }
    }
    
    public void setScore() {
        score++;
        count = 0;
    }
    
    public int getScore() {
        return score;
    }
    
    public void countScore() {
        setScore();
    }
    
    public void setScore(int x) {
        score = score + x;
    }
}
