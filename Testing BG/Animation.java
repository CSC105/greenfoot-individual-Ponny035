import greenfoot.*;
/**
 * Write a description of class Animation here.
 * Re code and change some thing to readable in v1.0  
 *
 * @author Bunyarit Patipol Saechan
 * @version 1.1
 * getdamage shink 50% next frame
 */
public class Animation
{
    private int currentFrame;
    private int allFrames;
    private GreenfootImage[] images;
    private GreenfootImage[] shink;
    private GreenfootImage[] yai;
    private int width;
    private int height;
    
    public Animation(String name, int allFrames, int width, int height) {
        this.allFrames = allFrames;
        images = new GreenfootImage[allFrames];
        shink = new GreenfootImage[allFrames];
        yai = new GreenfootImage[allFrames];
        currentFrame = 1;
        this.width = width;
        this.height = height;
        for(int i = 1; i <= allFrames; ++i) { 
          images[i-1] = new GreenfootImage(name+i+".png");
          images[i-1].scale(width*2, height*2);
        }
        for(int i = 1; i <= allFrames; ++i) { 
          images[i-1] = new GreenfootImage(name+i+".png");
          images[i-1].scale(width, height);
        }
        for(int i = 1; i <= allFrames; ++i) { 
          shink[i-1] = new GreenfootImage(name+i+".png");
          shink[i-1].scale(width/2, height/2);
        }
    }
    
    public void nextFrame() {
        currentFrame++;
        if(currentFrame == allFrames ) {
            currentFrame = 1;
        }
    }
    
    public void nextFrame(int n) {
        currentFrame+=n;
        if(currentFrame == allFrames ) {
            currentFrame = 1;
        }
    }
    
    public GreenfootImage getFrame() {
      nextFrame();
      return images[currentFrame];
    }
    
    public int getAllFrames() {
      return allFrames;
    }
    
    public int getCurrentFrame() {
      return currentFrame;
    }
    
    public GreenfootImage getEat( ) {
            nextFrame();
            return yai[currentFrame];
    }
    
    public GreenfootImage getDamage( ) {
            nextFrame();
            return shink[currentFrame];
    }
}
