import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Flamigo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flamigo extends Actor
{
    /**
     * Act - do whatever the Flamigo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Animation anim;
    private GreenfootImage image;
    private boolean isRight;
    private int direct=1;
    public Flamigo(){
      anim = new Animation( "Flamingo", 36, 50, 75 );
      isRight = true;
      setImage(anim.getFrame());
    }
    public void act() 
    {
        // Add your action code here.
        //checkKeys();
       
        if(super.isAtEdge()) {
           isRight=!isRight;
           direct*= -1;
           //move(1);
        }
       else {
           //move(1);
        }
        setImage(anim.getFrame(isRight));
        move(direct);
        
        //m.mirrorHorizontally();
    }  
    private void checkKeys() {
        int x = getX();
        int y = getY();
        GreenfootImage m = new GreenfootImage(anim.getFrame());
        if(Greenfoot.isKeyDown("Left")) {
            if( isRight ){
              //isRight = false;
              m.mirrorHorizontally();
              
            }
            setImage( m );
            setLocation(x-2, y);
        }
        if(Greenfoot.isKeyDown("Right")) {
            if( !isRight ){
              isRight = true;
              //image.mirrorHorizontally();
              
            }
            setImage( m );
            setLocation(x+2, y);
        }
    }
}
