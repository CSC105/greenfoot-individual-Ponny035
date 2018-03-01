import greenfoot.*; 
/**
 * Write a description of class End here.
 * 
 * @author Patipol Saechan 
 * @version 1.0
 */
public class End extends World
{
    int score = 0;

    public End( int score)
    {    
        super(600, 400, 1); 
        addObject( new Ground(), 0, 395 );
        addObject( new Replay(), 300, 154 );
        addObject( new Score(score), 300, 233 );
        Greenfoot.start();
    }
}
