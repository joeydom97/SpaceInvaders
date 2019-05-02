
/**
 * Write a description of class Entity here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Entity
{
    // instance variables - replace the example below with your own
    public int _x;
    public int _y;
    private boolean _isVisible = true;
    public SmartRectangle piece;
    protected java.awt.Color _color;
    /**
     * Constructor for objects of class Entity
     */
    public Entity(java.awt.Color color, GamePanel panel, int width, int height)
    {
        _color = color;
        piece = new SmartRectangle(_color);
        piece.setSize(width, height);
    }
    
    public void draw(java.awt.Graphics2D aBrush){
        piece.draw(aBrush);
    }
    public void fill(java.awt.Graphics2D aBrush){
        piece.fill(aBrush);
    }
    
    public int getX(){
        return _x;
    }
    
    public int getY(){
        return _y;
    }
    
    public void setVisible(boolean isVisible){
        _isVisible = isVisible;
    }
    public boolean isVisible(){
        return _isVisible;
    }

}
