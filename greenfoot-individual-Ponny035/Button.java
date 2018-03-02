import greenfoot.*;

/**
 * Write a description of class level here.
 * 
 * @author Patipol Saechan
 * @version 1.3
 */
public class Button extends Actor
{
    private GreenfootImage image;
    public boolean isActive = false;
    
    public Button(String img) {
        image = new GreenfootImage(img);
        image.scale(100,100);
        setImage( image );

    }
    
    public void checkClick() {
        if (Greenfoot.mouseClicked(this)) {
            isActive = true;
        }
    } 
    
    public void checkKeys() {
        if (Greenfoot.isKeyDown("Space")) {
            isActive = true;
        }
    } 
    
}
