import greenfoot.*;

/**
 * Write a description of class Start here.
 * 
 * @author Patipol 
 * @version 1.3
 */
public class Start extends World
{   
    public Start()
    {    
        super(600, 400, 1); 
        addObject( new Ground(), 0, 395 );
        addObject( new BackGround(0), 60, 130 );
        addObject( new Easy(), 150, 245 );
        addObject( new Medium(), 300, 245 );
        addObject( new Hard(), 450, 245 );
        addObject( new Mode(), 300, 150 );
        addObject( new Star(), 145, 317 );
        addObject( new Star(), 263, 317 );
        addObject( new Star(), 298, 317 );
        addObject( new Star(), 332, 317 );
        addObject( new Star(), 397, 317 );
        addObject( new Star(), 432, 317 );
        addObject( new Star(), 467, 317 );
        addObject( new Star(), 501, 317 );
        Greenfoot.start();
    }
}
