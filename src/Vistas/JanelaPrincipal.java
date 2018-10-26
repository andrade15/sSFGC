
package Vistas;

import Vistas.VisualizarCamiao;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import model.dao.CamiaoDAO;
import model.dao.ClienteDAO;
import model.dao.CondutorDAO;
import model.dao.ViagemDAO;
import model.entidade.Camiao;
import model.entidade.Cliente;
import model.entidade.Condutor;
import model.entidade.Viagem;
import vistas.VisualizarViagem;
       

/**
 *
 * @author derci
 */
public class JanelaPrincipal extends JFrame implements ActionListener {
   
    //JTextArea (int linhas, int colunas)
    
    JButton b1, b2;
    JPanel painel;
    JLabel criar, fundo; 
    private ViagemDAO v;
    private ClienteDAO cli;
    private CondutorDAO co;
    private CamiaoDAO ca;
    
 
     public JanelaPrincipal() throws IOException {       
        super("Truck Manager");
        
        setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Manjate\\Documents\\NetBeansProjects\\SGFC\\build\\classes\\Vistas\\background.png")))));
        pack();
      
        setSize(1000,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
//        this.setIconImage(new ImageIcon(getClass().getResource("C:\\Users\\OSVALDO\\Desktop\\Icons\\truck-icon.png")).getImage());    
        
        
      JLabel timeLabel = new JLabel();
      timeLabel.setBounds(800,470,150,20);
    

        add(timeLabel);
  
        final DateFormat timeFormat = new SimpleDateFormat("dd.MM.yyyy | HH:mm:ss a");
        ActionListener timerListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Date date = new Date();
                String time = timeFormat.format(date);
                timeLabel.setText(time);
                timeLabel.setForeground(Color.WHITE);
            }
        };
        Timer timer = new Timer(1000, timerListener);        
        timer.setInitialDelay(0);
        timer.start();      
            
        
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
        
        
        JMenu menu = new JMenu();
        menu.setIcon(new ImageIcon("C:\\Users\\OSVALDO\\Desktop\\Icons\\new.png"));
        menu.setToolTipText("Novo");
            JMenuItem item = new JMenuItem("Nova viagem");
              item.addActionListener(new ActionListener() {            
               public void actionPerformed(ActionEvent e) { 
                 new CriarViagem();
                setVisible(false);
            }
              });   
             
            JMenuItem item1 = new JMenuItem("Abrir...");            
            JMenuItem item2 = new JMenuItem("Gravar");           
            JMenuItem item3 = new JMenuItem("Sair");
              item3.addActionListener(new ActionListener() { 
                 public void actionPerformed(ActionEvent e) {                                          
                   System.exit(0);
                 }           
              });           
          
            menu.add(item);
            menu.add(item1);
            menu.add(item2);
            menu.addSeparator();
            menu.add(item3);
          
        JMenu menu1 = new JMenu();
        menu1.setIcon(new ImageIcon("C:\\Users\\Manjate\\Documents\\NetBeansProjects\\SGFC\\build\\classes\\Vistas\\edit.png"));
        menu1.setToolTipText("Editar");
        
            JMenuItem item4 = new JMenuItem("Viagem");
            item4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Viagem vi = new Viagem();                    
                   // v.Update(vi);
                }
            });
            
            JMenuItem item5 = new JMenuItem("Cliente");
            item5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Cliente cliente = new Cliente();
                   // cli.Update(cliente);
                }
            });
            
            JMenuItem item6 = new JMenuItem("Condutor");
            item6.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Condutor con = new Condutor();
                  //  co.Update(con);
                }
            });
            
            JMenuItem item7 = new JMenuItem("Camiao");
            item7.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Camiao con = new Camiao();
                  //  co.Update(con);
                }
            });
                       
            menu1.add(item4);
            menu1.add(item5);
            menu1.add(item6);
            menu1.add(item7);
          
        JMenu menu2 = new JMenu();
        menu2.setIcon(new ImageIcon("C:\\Users\\Manjate\\Documents\\NetBeansProjects\\SGFC\\build\\classes\\Vistas\\view.png"));
        menu2.setToolTipText("Visualizar");
        
            JMenuItem item8 = new JMenuItem("Viagens");
               item8.addActionListener(new ActionListener() {
                   public void actionPerformed(ActionEvent  e) {
                      new VisualizarViagem();
                      setVisible(false);
                   }
               });
               
               
            JMenuItem item9 = new JMenuItem("Camioes");
            item9.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new VisualizarCamiao();
                } 
            });
            
            JMenuItem item10 = new JMenuItem("Condutores");
            item10.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
               //    new VisualizarCondutor();
                }
            });
            
            JMenuItem item11 = new JMenuItem("Clientes");
            item11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              new VisualizarCliente();
               }
           });
            
            JMenuItem item12 = new JMenuItem("Estatísticas");
            item12.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    
                }
            });
            
            menu2.add(item8);
            menu2.add(item9);
            menu2.add(item10);
            menu2.add(item11);
            menu2.add(item12);           
           
        JMenu menu3 = new JMenu();
        menu3.setIcon(new ImageIcon("C:\\Users\\Manjate\\Documents\\NetBeansProjects\\SGFC\\build\\classes\\Vistas\\help.png"));
        menu3.setToolTipText("Ajuda");
            JMenuItem item13 = new JMenuItem("Atualizações");
            JMenuItem item14 = new JMenuItem("Guia de utilizador");
            JMenuItem item15 = new JMenuItem("Sobre");
            
            menu3.add(item13);            
            menu3.add(item14);
            menu3.add(item15);
            
    painel = new JPanel();         
        
    BufferedImage buttonIcon = ImageIO.read(new File("C:\\Users\\Manjate\\Documents\\NetBeansProjects\\SGFC\\build\\classes\\Vistas\\plus.png"));
    b1 = new JButton(new ImageIcon(buttonIcon));
    b1.setBounds(450,250,100,100); 
    b1.setBorderPainted(false);
    b1.setFocusPainted(false);
    b1.setContentAreaFilled(false);
    b1.setToolTipText("Nova Viagem");
       add(b1);
       
        b1.addMouseMotionListener(new MouseMotionAdapter() {
       
        public void mouseMoved(MouseEvent e) {            
           b1.setIcon(new ImageIcon("C:\\Users\\Manjate\\Documents\\NetBeansProjects\\SGFC\\build\\classes\\Vistas\\plus azul.png"));
        }
     
           
        });
        
        b1.addMouseListener(new MouseAdapter() {
         public void mouseExited(MouseEvent e) {
           b1.setIcon(new ImageIcon("C:\\Users\\Manjate\\Documents\\NetBeansProjects\\SGFC\\build\\classes\\Vistas\\plus.png"));
         }

         });
      
       
        b1.addActionListener(new ActionListener() {
            
            public void mouseClicked(MouseEvent e) {  
                
         new CriarViagem();              
            }          

            @Override
            public void actionPerformed(ActionEvent e) {
              new CriarViagem(); //To change body of generated methods, choose Tools | Templates.
            }
        });  
        
        
        
        JMenuBar bar = new JMenuBar(); // create menu bar
        setJMenuBar(bar);
        bar.add(menu);
        bar.add(menu1);
        bar.add(menu2);
           bar.add(Box.createHorizontalGlue());
        bar.add(menu3);
        
       
       add(painel);
       
       
        setVisible(true);
    }    
    
     
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}
