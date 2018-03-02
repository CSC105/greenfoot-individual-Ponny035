import greenfoot.*;  
import java.*;
/**
 * Write a description of class Ground here.
 * 
 * @author Patipol Saechan 
 * @version 1.3
 */
public class Score extends Actor
{
    private boolean isEnd = false;
    private int score;
    public Score() {
    
    }
    
    public Score(int score) {
        isEnd = true;
        this.score = score;
    }
    
    public void act() 
    {
        printScore();
    }
    
    private void printScore() {
        if(isEnd) {
           setImage(new GreenfootImage("Total Score : "+score, 50, Color.WHITE, new Color(0,0,0,0)));
        }
        else {
           score = ((MyWorld)getWorld()).getScore();
           setImage(new GreenfootImage("Score : "+score, 24, Color.WHITE, new Color(0,0,0,0))); 
        }
    }
}
