import greenfoot.*; 
/**
 * Write a description of class Health here.
 * 
 * @author Patipol Saechan
 * @version 1.0
 */
public class Health extends Actor
{
    private GreenfootImage image;
    private int health;
    int HP; // flamingo health
    
    public Health(int health) {
        image = new GreenfootImage("heart1.png");
        image.scale(25,25);
        this.health = health;
        setImage( image );
    }
    
    public void act() 
    {
        HP = getWorld().getObjects(Flamingo.class).get(0).getHP();
        checkHP(health,HP);
    }    
    
    public void checkHP(int health,int hp) {
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
