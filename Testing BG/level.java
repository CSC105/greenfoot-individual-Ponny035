import greenfoot.*;

/**
 * Write a description of class level here.
 * 
 * @author Patipol Saechan
 * @version 1.0
 */
public class level extends Actor
{
    private GreenfootImage image;
    public boolean isActive = true;
    public level() {
        this("replay.png");
    }
    
    public level(String img) {
        image = new GreenfootImage(img);
        image.scale(100,100);
        setImage( image );

    }
    
    public void act() 
    {

    }  
    
    public void checkKeys() {
        if (Greenfoot.mouseClicked(this)) {
            isActive = false;
            //(getWorld().getObjects(Mode.class)).setActive(false);
        }
    } 
    
}
