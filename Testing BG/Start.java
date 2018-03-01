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
    boolean isActive = true;
    int speed = 0;
    public Start()
    {    
        super(600, 400, 1); 
        addObject( new Ground(), 0, 395 );
        addObject( new BackGroud(0), 60, 130 );
        addObject( new easy(), 150, 245 );
        addObject( new mid(), 300, 245 );
        addObject( new Hard(), 450, 245 );
        addObject( new Mode(), 300, 150 );
        Greenfoot.start();
    }
    
    public int getSpeed() {
        return speed;
    }
}
