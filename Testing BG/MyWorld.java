import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Patipol Saechan 
 * @version 1.0
 * add more
 *  watch
 *  black panther
 * Bug fix
 *  - sound track
 */
public class MyWorld extends World
{
    //private GreenfootSound soundTrack;
    int speed = 5;
    
    public MyWorld()
    {    
        super(600, 400, 1, false);
        //soundTrack = new GreenfootSound("Soft Kitty.wav");
        //soundTrack.playLoop();
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
        Greenfoot.start();
        
    }
    
    public MyWorld( int health) {
        super(600, 400, 1, false);
        int x=16;
        addObject( new Flamingo(health), 84, 294 );
        for(int i=12; i<=health;i+=12 ) {
            addObject( new Health(i), (x+30), 39 );
            x= x+30;
        }
        addObject( new Ground(), 60, 390 );
        addObject( new Ground(), 200, 390 );
        addObject( new Ground(), 340, 390 );
        addObject( new Ground(), 480, 390 );
        addObject( new Ground(), 620, 390 );
        addObject( new PlayButton(), 300, 200);
        addObject( new SpaceToPlay(), 300, 365);
        Greenfoot.start();
    }
    
    public void setSpeed(int speed) {
        this.speed = this.speed+speed;
    }
    
    public int getSpeed() {
        return speed;
    }
}
