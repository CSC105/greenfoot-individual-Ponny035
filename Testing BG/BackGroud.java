import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ground here.
 * 
 * @author Patipol Saechan 
 * @version 1.0
 */
public class BackGroud extends Actor
{
    private GreenfootImage image;
    int speed = 2;
    public BackGroud(){
        image = new GreenfootImage("BG1.png");
        image.scale(2012,400);
        setImage( image );
    }
    
    public BackGroud(int x) {
        image = new GreenfootImage("BG1.png");
        image.scale(2012,400);
        setImage( image );
        speed = x;
    }
    
    public void act() 
    {
        moveLeft();
        checkSpawn(getX() <= -1006);
    }
    
    private void moveLeft() {
        setLocation(getX()-speed, getY());
    }
    
    private void checkSpawn(boolean edge) {
        if(edge) {
            super.setLocation(2012,130);
        }
    } 
}
