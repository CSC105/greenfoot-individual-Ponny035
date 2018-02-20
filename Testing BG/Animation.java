import greenfoot.*;
/**
 * Write a description of class Animation here.
 * Re code and change some thing to readable in v1.0  
 *
 * @author Bunyarit Patipol Saechan
 * @version 1.1
 * getdamage skip 1 frame
 */
public class Animation
{
    private int currentFrame;
    private int allFrames;
    private GreenfootImage[] images;
    public Animation(String name, int allFrames, int width, int height) {
        this.allFrames = allFrames;
        images = new GreenfootImage[allFrames];
        currentFrame = 1;
        for(int i = 1; i <= allFrames; ++i) { 
          images[i-1] = new GreenfootImage(name+i+".png");
          images[i-1].scale(width, height);
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
    
    public GreenfootImage getDamage(int time) {
        if(time>0) {
            nextFrame(1);
            time--;
            return images[currentFrame];
        }
        else {
            nextFrame();
            return images[currentFrame];
        }
    }
}
