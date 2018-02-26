import greenfoot.*;

/**
 * Write a description of class Start here.
 * 
 * @author Patipol 
 * @version 1.0
 */
public class Start extends World
{
    private GreenfootSound soundTrack;
    public Start()
    {    
        super(600, 400, 1); 
        soundTrack = new GreenfootSound( "The Lion Sleeps Tonight [8 Bit Tribute to The Tokens] - 8 Bit Universe.wav" );
        //soundTrack.playLoop();
        addObject( new Ground(), 60, 390 );
        addObject( new Ground(), 200, 390 );
        addObject( new Ground(), 340, 390 );
        addObject( new Ground(), 480, 390 );
        addObject( new Ground(), 620, 390 );
        addObject( new easy(), 150, 245 );
        addObject( new mid(), 300, 245 );
        addObject( new Hard(), 450, 245 );
        addObject( new Mode(), 300, 150 );
        Greenfoot.start();
    }
}
