import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class End here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class End extends World
{
    int score = 0;
    /**
     * Constructor for objects of class End.
     * 
     */
    public End( int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject( new Ground(), 60, 390 );
        addObject( new Ground(), 200, 390 );
        addObject( new Ground(), 340, 390 );
        addObject( new Ground(), 480, 390 );
        addObject( new Ground(), 620, 390 );
        addObject( new Replay(), 300, 154 );
        addObject( new Score(score), 300, 233 );
    }
}
