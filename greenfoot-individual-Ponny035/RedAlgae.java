import greenfoot.*;  

/**
 * Write a description of class Ground here.
 * 
 * @author Patipol Saechan 
 * @version 1.3
 */
public class RedAlgae extends Object
{
    private GreenfootImage image;
    
    public RedAlgae(){
        super();
        image = new GreenfootImage("Red_Algae.png");
        image.scale(100,100);
        setImage( image );
    }
 
    public void act() 
    {
        moveLeft();
        checkSpawn(getX() < -25);
    } 
    
    private void checkSpawn(boolean edge) {
        if(edge) {
            int x = 0;
            x = Greenfoot.getRandomNumber(2000);
            while(x<1000) {
                x = Greenfoot.getRandomNumber(2000);  
            }
            getWorld().addObject( new RedAlgae(), x, 296 );
            getWorld().removeObject(this);
        }
    }   
}
