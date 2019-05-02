
/**
 * Write a description of class Projectile here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Projectile extends Entity
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Projectile
     */
    public Projectile(int x, int y, GamePanel _panel)
    {
        super(java.awt.Color.RED, _panel, 3, 15);
        this.setLocation(x,y);
    }
    
    public void setLocation(int x, int y){
        _x = x;
        _y = y;
        piece.setLocation(x,y);
    }
    public void move(){
        _y = getY() + 4;
        piece.setLocation(_x, _y);
    }
    public void moveUp(){
     _y = getY() - 4;
     piece.setLocation(_x, _y);
    }
}
