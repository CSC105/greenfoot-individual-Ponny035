import greenfoot.*; 
import java.util.List;
/**
 * Write a description of class Rock here.
 * 
 * @author Patipol Saechan 
 * @version 1.3
 */
public class Rock extends Object
{
    private boolean hit = false;
    
    public void act() 
    {
        moveLeft();
        checkSpawn(getX()<(-25));
    } 
    
    private void checkSpawn(boolean edge) {
       if(edge) {
           int x = 0;
           x = Greenfoot.getRandomNumber(2000);
           while(x<1000) {
               x = Greenfoot.getRandomNumber(2000);  
            }
           getWorld().addObject( new Rock(), x, 307 );
           getWorld().removeObject(this);
       }
    }
    
    public void setHit(boolean Hit) {
        hit = Hit;
    }
    
    public boolean getHit() {
        return hit;
    }
}
