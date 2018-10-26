/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import javax.swing.*;
import java.awt.*;
 

public class Fundo extends JFrame {
    
    
    
    public Fundo() {
    
    
        setSize(1366,768);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        
        
        JLabel fundo = new JLabel();
        fundo.setBackground(SystemColor.activeCaption);
        
        add(fundo);
        setVisible(true);
        
        
        
    
    }
    
}
