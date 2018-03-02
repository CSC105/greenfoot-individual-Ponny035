import greenfoot.*;  

/**
 * Write a description of class Ground here.
 * 
 * @author Patipol Saechan 
 * @version 1.3
 */
public class Star extends Picture
{
    private GreenfootImage image;
    public Star () {
        image = new GreenfootImage("star.png");
        image.scale(25,25);
        setImage( image );
    }  
}
