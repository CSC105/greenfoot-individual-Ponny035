import greenfoot.*; 

/**
 * Write a description of class Ground here.
 * 
 * @author Patipol Saechan 
 * @version 1.3
 */
public class Coin extends Object
{
    private GreenfootImage image;
    
    public Coin(){
        image = new GreenfootImage("ETH.png");
        image.scale(50,50);
        setImage( image );
    }
    
    public void act() 
    {
        moveLeft();
        checkSpawn(getX() < -25);
    }    
    
    private void checkSpawn(boolean edge) {
        if(edge) {
            int x=0;
            x=Greenfoot.getRandomNumber(2000);
            while(x<1500) {
                x=Greenfoot.getRandomNumber(3000);  
            }
            getWorld().addObject( new Coin(), x, 300 );
            getWorld().removeObject(this);
        }
    }   
}
