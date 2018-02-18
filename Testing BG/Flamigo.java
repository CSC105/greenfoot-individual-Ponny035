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
    private int gravity = 2;
    private int vSpeed = 0;
    public Flamigo(){
      anim = new Animation( "Flamingo", 36, 50, 75 );
      isRight = true;
      setImage(anim.getFrame());
    }
    
    public void act() 
    {
        // Add your action code here.
        checkKeys();
        checkFall();
        setImage(anim.getFrame());
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
        else if(Greenfoot.isKeyDown("Right")) {
            if( !isRight ){
              isRight = true;
              //image.mirrorHorizontally();
              
            }
            setImage( m );
            setLocation(x+2, y);
        }
        else if (Greenfoot.isKeyDown("Space")&&onGround()) {
            vSpeed = -25;
            fall();
        }
    }  
    
    private void jump () {
        if(Greenfoot.isKeyDown("Space")) {
            int x = getX();
            int y = getY();
            setImage("Flamingo36.png");
            move(3);
            //setLocation(x, y+2);
        }
    }
    private boolean onGround() {
        Actor under = getOneObjectAtOffset (0, 45, Ground.class);
        return under != null;
    }
    private void checkFall() {
        if(onGround()) {
            vSpeed = 0;
            setLocation(getX(), 294);
        }
        else {
            fall();
        }
    }
    private void fall() {
        setLocation(getX(), getY()+vSpeed);
        vSpeed = vSpeed + gravity;
    }
}
