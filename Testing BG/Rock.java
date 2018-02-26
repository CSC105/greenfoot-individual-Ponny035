import greenfoot.*; 
import java.util.List;
/**
 * Write a description of class Rock here.
 * 
 * @author Patipol Saechan 
 * @version 1.0
 */
public class Rock extends Actor
{
    Flamingo nok = new Flamingo();
    private int speed = 5;
    private boolean hit = false;
    private int count = 0;
    int x = 0;
    int y = 0;
    
    public void act() 
    {
        moveLeft();
        x = ((Flamingo) getWorld().getObjects(Flamingo.class).get(0)).getX();
        y = ((Flamingo) getWorld().getObjects(Flamingo.class).get(0)).getY();
        setSpeed(((MyWorld)getWorld()).getSpeed ());
        checkSpawn(getX() < (-25));
    } 
    
    private void moveLeft() {
        setLocation(getX()-speed, getY());
        if(count == 10) {
            speed++;
            count = 0 ;
        }
    }
    
    private void checkSpawn(boolean edge) {
       if(edge) {
           x=0;
           x=Greenfoot.getRandomNumber(2000);
           while(x<1000) {
               x=Greenfoot.getRandomNumber(2000);  
            }
           getWorld().addObject( new Rock(), x, 307 );
           getWorld().removeObject(this);
       }
       else {
           
       } 
    }
    
    public void setHit(boolean Hit) {
        hit = Hit;
    }
    
    public boolean getHit() {
        return hit;
    }
    
    public void setSpeed (int speed) {
        this.speed = speed;
    }
}
