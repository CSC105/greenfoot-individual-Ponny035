import greenfoot.*; 

/**
 * Write a description of class Ground here.
 * 
 * @author Patipol Saechan 
 * @version 1.0
 */
public class Coin extends Actor
{
    private GreenfootImage image;
    private int speed = 5;
    private int count = 0;
    int x = 0;
    int y = 0;
    
    public Coin(){
        image = new GreenfootImage("ETH.png");
        image.scale(50,50);
        setImage( image );
    }
    
    public void act() 
    {
        setSpeed(((MyWorld)getWorld()).getSpeed ());
        moveLeft();
        checkSpawn(getX() < -25);
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
            int x=0;
            x=Greenfoot.getRandomNumber(2000);
            while(x<1500) {
                x=Greenfoot.getRandomNumber(3000);  
            }
            getWorld().addObject( new Coin(), x, 300 );
            getWorld().removeObject(this);
        }
    }   
    
    public void setSpeed (int speed) {
        this.speed = speed;
    }
}
