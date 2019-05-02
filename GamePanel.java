import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.awt.Color;
import java.util.ArrayList;
/**
 * Write a description of class GamePanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GamePanel extends JPanel implements ActionListener
{
    private Timer _timer;
    private ArrayList<Alien> aliens;
    private ArrayList<Projectile> alienBullets;
    private ArrayList<Projectile> playerBullets;
    private ArrayList<Mothership> motherships;
    private Player _player;
    private int[] _board;
    private boolean endGame = false;
    private boolean goRight = false;
    private boolean goLeft = false;
    private boolean goDown = false;
    private boolean canShoot = true;
    private KeyPListener _pauseKey;
    private KeyInteractor _leftKey, _rightKey, _spaceKey;
    Random rand;
    private int count;
    public GamePanel(){
        _board = new int[66];
        this.setBackground(Color.BLACK);
        this.setSize(new Dimension(600, 600));
        aliens = new ArrayList<>();
        alienBullets = new ArrayList<>();
        playerBullets = new ArrayList<>();
        motherships = new ArrayList<>();
        _player = new Player(300, 500, this);
        rand = new Random();
        _pauseKey = new KeyPListener(this);
        _rightKey = new KeyRightListener(this);
        _leftKey = new KeyLeftListener(this);
        _spaceKey = new KeySpaceListener(this);
        goRight = true;
        
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 11; j++){
                Alien alien = new Alien(100 + 40 * j, 50 + 40 * i, this);
                aliens.add(alien);
            }
        }
        for(Alien alien: aliens){
            _board[aliens.indexOf(alien)] = 1;
        }
        _timer = new Timer(20, this);
        _timer.start();
        
    }
    public void shoot() {
    
        Projectile playerBullet = new Projectile(_player.getX(), 
                   _player.getY() - 2, this);  
        playerBullets.add(playerBullet); 
    }
    public void spawnMothership(){
        double rng = Math.random();
        rng = rng * 2 +1;
        int check = (int) rng;
        int direction = 1;
        int xloc = 0;
        if (check == 2) {
            direction = -1;
            xloc = 600;
        }
        Mothership newMother = new Mothership(xloc, 20, direction, this); 
        motherships.add(newMother);
        
    }
    public void paintComponent(java.awt.Graphics aBrush){
        super.paintComponent(aBrush);
        java.awt.Graphics2D betterBrush = (java.awt.Graphics2D) aBrush;
        _player.fill(betterBrush);
        _player.draw(betterBrush);
        for(Alien alien: aliens){
            if(alien.isVisible()){
            alien.fill(betterBrush);
            alien.draw(betterBrush);
        }
        }
        for(Mothership ship: motherships){
            if(ship.isVisible()){
            ship.fill(betterBrush);
            ship.draw(betterBrush);
        }
        }
        for(Projectile bullet: alienBullets){
            bullet.fill(betterBrush);
            bullet.draw(betterBrush);
        }
        for(Projectile bullet: playerBullets){
            if(bullet.isVisible()){
            bullet.fill(betterBrush);
            bullet.draw(betterBrush);
        }
        }
    }
    public void actionPerformed(ActionEvent e){
        
        int x = 0;
         if (count % 500 == 0 && ((x = (int)(Math.random())) % 4 == 0)){
             spawnMothership();
            }
         if(count % 10 == 0){
        for(Alien alien: aliens){
             
                x = (int)(Math.random() * 55);
                if(_board[aliens.indexOf(alien)] == x){
               if((_board[aliens.indexOf(alien) + 11] != 1)
                    & !alien.didShoot()){
                   Projectile alienBullet = new Projectile(alien.getX(), 
                   alien.getY() + 30, this);
                   
                   alienBullets.add(alienBullet);
                   //alien.setShot(true);
                }
            }
                if(alien.getX() > 550){
                    goDown = true;
                    goRight = false;
                    goLeft = true;
                }
                
                if(alien.getX() < 20){
                    goDown = true;
                    goRight = true;
                    goLeft = false;
                }
        
          
        }
    }
        for(Alien alien: aliens){
             if(goDown){
                alien.moveDown();                
            }
            if(goRight){
                 alien.moveRight();
                }
            if(goLeft){
                alien.moveLeft();
                
            }
        }
        
          
        for(Alien alien: aliens){
          
            for(Projectile bullet: playerBullets){
                if(bullet.isVisible()){
                 if((alien.piece.intersects(bullet.piece)) & 
                    (alien.isVisible())){
                        _board[aliens.indexOf(alien)] = 0;
                        alien.setVisible(false);
                        alien.setShot(true);
                        bullet.setVisible(false);
                        
                  
                    }
                }
            }
        }
    
        
        for(Projectile bullet: alienBullets){
            bullet.move();
        }
        for(Projectile bullet: playerBullets){
            bullet.moveUp();
        }
        for(Mothership ship: motherships){
            ship.move();
        }
        goDown = false;
        if (count % 20 == 0) {
            canShoot= true;
        }
        count++;
        
        repaint();
        
    }
    private class KeyPListener extends KeyInteractor 
    {
        public KeyPListener(JPanel p)
        {
            super(p,KeyEvent.VK_P);
        }
        
        public  void actionPerformed (ActionEvent e) {
            if(_timer.isRunning())
                _timer.stop();
            
            else
                _timer.start();
        }
    }
    private class KeyLeftListener extends KeyInteractor 
    {
        public KeyLeftListener(JPanel p)
        {
            super(p,KeyEvent.VK_LEFT);
        }
        
        public  void actionPerformed (ActionEvent e) {
            if(_timer.isRunning())
                _player.moveLeft();
                
        }
    }
    private class KeyRightListener extends KeyInteractor 
    {
        public KeyRightListener(JPanel p)
        {
            super(p,KeyEvent.VK_RIGHT);
        }
        
        public  void actionPerformed (ActionEvent e) {
            if(_timer.isRunning())
                _player.moveRight();
        }
    }
    private class KeySpaceListener extends KeyInteractor 
    {
        public KeySpaceListener(JPanel p)
        {
            super(p,KeyEvent.VK_SPACE);
        }
        
        public  void actionPerformed (ActionEvent e) {
            if(_timer.isRunning() && canShoot == true) {
                shoot();
                canShoot = false;  
                }
        }
    }
}
