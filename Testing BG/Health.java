import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health extends Actor
{
    /**
     * Act - do whatever the Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage image;
    private int health;
    int HP; // flamigo health
    
    public Health(int health){
      image = new GreenfootImage("heart1.png");
      image.scale(25,25);
      this.health = health;
      setImage( image );
      //anime = new Animation( "heart", 2, 25, 25 );
      //setImage(anime.getFrame());
    }
    
    public void act() 
    {
        HP = getWorld().getObjects(Flamigo.class).get(0).getHP();
        checkHP(health,HP);
        // Add your action code here.
        //setImage(anime.getFrame()); 
    }    
    //(Rock) getWorld().getObjects(Rock.class).get(0)).getX()
    public void checkHP (int health,int hp) {
        if(health > hp) {
            image = new GreenfootImage("heart2.png");
            image.scale(25,25);
            setImage( image );
        }
        else if (hp >(health-12)) {
           image = new GreenfootImage("heart1.png");
            image.scale(25,25);
            setImage( image ); 
        }
    }
}
