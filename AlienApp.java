import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Write a description of class AlienApp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AlienApp extends JFrame
{
    // instance variables - replace the example below with your own
    private GamePanel _gamePanel;
    public AlienApp()
    {
        super("AlienAttack");
        this.setResizable(false);
         _gamePanel = new GamePanel(); 
         this.setSize(600, 600);
         this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
         this.add(_gamePanel);  
         this.setVisible(true);
    }
    
    public static void main(String[] args){
        AlienApp app = new AlienApp();
    }
   
}
