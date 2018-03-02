import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ground here.
 * 
 * @author Patipol Saechan 
 * @version 1.3
 */
public class BackGround extends Actor
{
    private GreenfootImage image;
    private int speed = 2;
    public BackGround(){
        image = new GreenfootImage("BG.png");
        image.scale(2012,400);
        setImage( image );
    }
    
    //set move check
    public BackGround(int x) {
        image = new GreenfootImage("BG.png");
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
