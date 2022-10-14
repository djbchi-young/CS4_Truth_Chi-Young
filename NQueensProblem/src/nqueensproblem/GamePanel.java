/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nqueensproblem;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *
 * @author crisbisnar
 */
public class GamePanel extends JPanel implements Runnable{
    //N for the problem
    
    final int n = 8;
    
    //SCREEN SETTINGS
    public final int tileSize = 64; 
    final int screenWidth = tileSize * n; 
    final int screenHeight = tileSize * n;
    
    
    //FPS
    int FPS = 60;
   
    
    Thread gameThread;
    
    int[][] queens = new int[n][2];
    
    public void checkQueens(int queenNum){
        if(queenNum == 0){
            queens[queenNum][0] = 1;
            queens[queenNum][1] = 1;
        }
        else{
            //set X
            queens[queenNum][0] = queenNum+1;
            //set Y
            ArrayList<Integer> confirmedHorizontals = new ArrayList();
            ArrayList<Integer> confirmedDiagonals = new ArrayList();

            
            //check horizontals
            for(int i = 1; i<=n; i++){
                int checkedQueens = 0;
                for(int k = queenNum-1; k>=0; k--){
                    if(!(queens[k][1] == i))
                    
                    checkedQueens++;
                }
                if(checkedQueens == queenNum-1){
                    confirmedHorizontals.add(i);
                }
            }
            
            //check diagonals
            ArrayList<Integer> upDiagonal = new ArrayList();
            ArrayList<Integer> downDiagonal = new ArrayList();
            for(int i = 1; i<=n; i++){
                int checkedQueens = 0;
                
                for(int k = queenNum-1; k>=0; k--){
                    boolean isPossible = true;
                    for(int j = (n-queenNum+1); j<=n; j++){
                        if(k+j == i && queens[queenNum][1]+j == i){
                            isPossible = false;
                        }
                    }
                    if(isPossible){
                        downDiagonal.add(i);
                    }
                }
                
               
            }
            for(int diagonal : downDiagonal){
                if(upDiagonal.contains(diagonal)){
                    confirmedDiagonals.add(diagonal);
                }
            }
            
            
            for(int posY : confirmedHorizontals){
                if(confirmedDiagonals.contains(posY)){
                    queens[queenNum][1] = posY;
                    break;
                }
            }
                
        }
    }
    
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
    }

    
    public int getTileSize(){
        return tileSize;
    }
    
    
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    @Override
    public void run(){
        
        double drawInterval = 100000000;
        double nextDrawTime = System.nanoTime() + drawInterval;
        
        
        while(gameThread != null){
//          System.out.println("The game loop is running");
        long currentTime = System.nanoTime();
        //UPDATE 1: Update information
            update();
        //DRAW 2: Draw screen with updated information
            repaint();
            
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                //converts from nanoseconds to milliseconds for the sleep function
                remainingTime = remainingTime/1000000;
                
                //sets remainingTime to 0 if less than 0
                if(remainingTime < 0){
                    remainingTime = 0;
                }
                //sleep() uses milliseconds and long variables
                Thread.sleep((long)remainingTime);
                
                //updates the nextDrawTime
                nextDrawTime += drawInterval;
            } catch (InterruptedException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void update(){
       for(int i=0; i<n; i++){
           checkQueens(i);
       }
    }
    
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        boolean color = true;
        for(int i = n; i>0; i--){
            for(int k = n; k>0; k--){
                if(color){
                    g.setColor(Color.white);
                }else{
                    g.setColor(Color.black);
                }
                g.fillRect((k-1)*tileSize,(i-1)*tileSize, tileSize, tileSize);
                color = !color;
            }
            if(n%2 == 0){
                color = !color;
            }
        }
    }

    
}
