/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nqueensproblem;

import javax.swing.JFrame;

/**
 *
 * @author TRUTH
 */
public class NQueensProblem {

    /**
     * @param args the command line arguments
     */
    static GamePanel gamePanel = new GamePanel();
    
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Conway's Game of Life");
        
        
        window.add(gamePanel);
        
        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        gamePanel.startGameThread();
    }
    
}
