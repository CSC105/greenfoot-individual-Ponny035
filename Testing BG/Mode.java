import greenfoot.*; 

/**
 * Write a description of class Ground here.
 * 
 * @author Patipol Saechan 
 * @version 1.0
 */
public class Mode extends Actor
{
    private GreenfootSound soundTrack;
    boolean isActive = true;
    public Mode () {
        //soundTrack = new GreenfootSound( "Mawin.wav" );
        //soundTrack.playLoop();
    }

    public void act() 
    {
       if(!isActive) {
           soundTrack.stop();
       }
    }  
    
    public void setActive (boolean a) {
        isActive = a;
    }
}
