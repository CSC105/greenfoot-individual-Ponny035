import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Red_Algae here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Red_Algae extends Actor
{
    /**
     * Act - do whatever the Red_Algae wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage image;
    private int speed = 5;
    private int count = 0;
    Flamingo nok = new Flamingo();
    int x = 0;
    int y = 0;
    int i=0;
    
    public Red_Algae(){
      image = new GreenfootImage("Red_Algae.png");
      image.scale(100,100);
      setImage( image );
      //anime = new Animation( "heart", 2, 25, 25 );
      //setImage(anime.getFrame());
    }
 
    public void act() 
    {
        // Add your action code here.
        moveLeft();
        //damage(x,y);
        checkSpawn(getX() < -25);
    } 
    
    private void moveLeft() {
        setLocation(getX()-speed, getY());
        /*if(damage()) {
            damage++;
            System.out.println("np"+damage);
        }*/
        if(count == 10) {
            speed++;
            count = 0 ;
        }
    }
    
    private void checkSpawn(boolean edge) {
       if(edge) {
           getWorld().addObject( new Red_Algae(), 700, 296 );
           getWorld().removeObject(this);
       }
       else {
           
       } 
    }   
}
