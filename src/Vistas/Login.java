/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;


import com.sun.xml.internal.ws.dump.LoggingDumpTube;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author derci
 */
public class Login extends JFrame implements ActionListener {
    
    JButton log;
    JPanel painel;
    JTextField text;
    JLabel lab, lab1, errado;
    
   final  String pass = "sgfc1234";
  
   int tentativas = 3;
    
    public Login() throws IOException{
        
         try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JanelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(JanelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JanelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(JanelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       // this.setIconImage(new ImageIcon(getClass().getResource("C:\\Users\\OSVALDO\\Desktop\\Icons\\key.png")).getImage());
        
        setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Manjate\\Documents\\NetBeansProjects\\SGFC\\build\\classes\\Vistas\\fundo2.png")))));
        pack();
        new Fundo();
       
        setTitle("LOGIN");
        setSize(400,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
               
        painel = new JPanel();
        
        
        JLabel contato = new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Manjate\\Documents\\NetBeansProjects\\SGFC\\build\\classes\\Vistas\\contacts-icon.png"))));
        contato.setBounds(115,80,150,150);
        add(contato);
      // pack();
        
        
        JButton ok = new JButton("Entrar");
        ok.setBounds(145,370,100,25);
        add(ok);
        
        JLabel pword = new JLabel("Senha: ");
        pword.setBounds(100,285, 100, 25);
        add(pword);
        JPasswordField password = new JPasswordField(10);
        password.setBounds(145,285,100,25);
       add(password);  
       
        errado = new JLabel("Senha Incorreta!");
        errado.setForeground(Color.RED);  
        errado.setBounds(155,315,100,25);
          // 
            errado.hide();
           add(errado);
               
       password.addActionListener(new ActionListener() {
    
          public void actionPerformed(ActionEvent evento) {  
         
           if (password.getText().equals(pass)) {
               JOptionPane.showMessageDialog(null, "ACESSO CONCEDIDO!");               
               try {                  
                   new JanelaPrincipal();
               } catch (IOException ex) {
                   Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
               }     
              dispose();
              
           }               
           else 
              errado.show();
           
          }
    });         
       
       ok.addActionListener(new ActionListener(){
       
          public void actionPerformed(ActionEvent e) {
          
         if (password.getText().equals(pass)) {
             try {
                 JanelaPrincipal boss = new JanelaPrincipal();
             } catch (IOException ex) {
                 Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
             }
         } else
             errado.show();          
                      
          }
       
       } );
      
       password.addKeyListener(new KeyAdapter() {
       
           public void keyPressed(KeyEvent e) {
           
               if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
                   errado.hide();
           }
       });
       
       
       
       
        
        add(painel);
             
        setVisible(true);   
    
    }
  

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
