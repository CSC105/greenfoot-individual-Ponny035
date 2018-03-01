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
    int count = 0;
    boolean isEnd = true;
    
    public Score() {
    
    }
    
    public Score(int x) {
        isEnd = false;
        setImage(new GreenfootImage("Total Score : "+x, 50, Color.RED, new Color(0,0,0,0)));
    }
    
    public void act() 
    {
       if(isEnd) {
           score = ((MyWorld)getWorld()).getScore();
           setImage(new GreenfootImage("Score : "+score, 24, Color.RED, new Color(0,0,0,0)));
       }
    }

}
