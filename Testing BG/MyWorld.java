import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Patipol Saechan 
 * @version 0.3
 * flyable
 * watch
 * black panther
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private GreenfootSound soundTrack;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        soundTrack = new GreenfootSound( "Soft Kitty.wav" );
        soundTrack.playLoop();
        addObject( new Flamingo(), 84, 294 );
        addObject( new Health(12), 46, 39 );
        addObject( new Health(24), 76, 39 );
        addObject( new Health(36), 106, 39 );
        addObject( new Health(48), 136, 39 );
        addObject( new Health(60), 166, 39 );
        addObject( new Ground(), 60, 390 );
        addObject( new Ground(), 200, 390 );
        addObject( new Ground(), 340, 390 );
        addObject( new Ground(), 480, 390 );
        addObject( new Ground(), 620, 390 );
        addObject( new PlayButton(), 300, 200);
        addObject( new SpaceToPlay(), 300, 365);
    }
}
