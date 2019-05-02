
/**
 * Write a description of class Mothership here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Mothership extends Entity
{
    // instance variables - replace the example below with your own
    public int direction;
    
    /**
     * Constructor for objects of class Mothership
     */
    public Mothership(int x, int y, int d, GamePanel _panel)
    {
        // initialise instance variables
        super(java.awt.Color.YELLOW, _panel, 10, 10);
        this.setLocation(x,y);
        direction = d;
    }

    public void setLocation(int x, int y){
        _x = x;
        _y = y;
        piece.setLocation(x,y);
    }
    public void move(){
        _x = getX() + direction * 3;
        piece.setLocation(_x, _y);
    }
}
