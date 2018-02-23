import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpaceToPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpaceToPlay extends Actor
{
    /**
     * Act - do whatever the SpaceToPlay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage image;
    public void act() 
    {
        // Add your action code here.
        setImage("SpaceToPlay.png");
        Greenfoot.delay(2);
        setImage("SpaceToPlay2.png");
    }    
}
