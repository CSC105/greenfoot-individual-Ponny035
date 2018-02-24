import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.*;//awt.Color;
/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    int score = 0;
    int count =0;
    boolean isEnd = true;
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Score() {
    
    }
    public Score(int x) {
        isEnd = false;
        setImage(new GreenfootImage("Score : "+x, 50, Color.BLACK, new Color(0,0,0,0)));
    }
    public void act() 
    {
        // Add your action code here.
       if(isEnd) {
        setScore();
        setImage(new GreenfootImage("Score : "+score, 24, Color.BLACK, new Color(0,0,0,0)));
       }
    }
    public void setScore() {
        if(count>=10) {
            score++;
            count = 0;
        }
        else {
            count++;
        }
    }
    
    public int getScore() {
        return score;
    }
    
    public void setScore(int x) {
        score = score + x;
    }
}
