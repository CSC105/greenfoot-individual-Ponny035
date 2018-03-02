import greenfoot.*; 
/**
 * Write a description of class End here.
 * 
 * @author Patipol Saechan 
 * @version 1.3
 */
public class End extends World
{
    public End( int score)
    {    
        super(600, 400, 1); 
        addObject( new Ground(), 0, 395 );
        addObject( new BackGround(0), 60, 130 );
        addObject( new Replay(), 300, 164 );
        addObject( new Score(score), 300, 243 );
        Greenfoot.start();
    }
}
