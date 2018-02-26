import greenfoot.*;  

/**
 * Write a description of class Ground here.
 * 
 * @author Patipol Saechan 
 * @version 1.0
 */
public class Red_Algae extends Actor
{
    private GreenfootImage image;
    private int speed = 5;
    private int count = 0;
    int x = 0;
    int y = 0;
    
    public Red_Algae(){
        image = new GreenfootImage("Red_Algae.png");
        image.scale(100,100);
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
            while(x<1000) {
                x=Greenfoot.getRandomNumber(2000);  
            }
            getWorld().addObject( new Red_Algae(), x, 296 );
            getWorld().removeObject(this);
        }
    }   
    
    public void setSpeed (int speed) {
        this.speed = speed;
    }

}
