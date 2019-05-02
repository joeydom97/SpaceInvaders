
/**
 * Write a description of class Alien here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Alien extends Entity
{
    // instance variables - replace the example below with your own
  

    /**
     * Constructor for objects of class Alien
     */
    private boolean _shoot = false;
    public Alien(int x, int y, GamePanel _panel)
    {
        super(java.awt.Color.GREEN, _panel, 30, 30);
        this.setLocation(x,y);
    }

    public void setLocation(int x, int y){
        _x = x;
        _y = y;
        piece.setLocation(x,y);
    }
    public void moveRight(){
        _x = getX() + 1;
        piece.setLocation(_x, _y);
    }
    public void moveDown(){
        _y = getY() + 30;
        piece.setLocation(_x, _y);
    }
    public void moveLeft(){
        _x = getX() - 1;
        piece.setLocation(_x, _y);
    }
    public void setShot(boolean shoot){
        _shoot = shoot;
    }
    public boolean didShoot(){
        return _shoot;
    }
    
    
  
}
