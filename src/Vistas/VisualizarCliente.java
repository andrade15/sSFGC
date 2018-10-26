package vistas;

import Vistas.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;

import javax.swing.JCheckBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.BoxLayout;

import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.ClienteDAO;
import model.entidade.Cliente;

public class VisualizarCliente extends JFrame{
    
	private JPanel contentPane;
	private JTextField textField;
	private JLabel    nome;
        private JComboBox comboBox;
	private JTextField textField_1;
	private JPanel panel2;
	private JButton btnEliminar;
        private JButton btnInserir;
	private JButton btnAlterar;
	private JButton btnPesquisar;
        private JTable tabela;
        private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
    private DefaultTableModel modelo=new DefaultTableModel();
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public VisualizarCliente() {
		 super("Clientes");
		  criaJTable();
		setSize(1366,768);
	
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setToolTipText("");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 202, 1346, 453);
		panel_1.setLayout(null);
               
                JScrollPane js=new JScrollPane(tabela);
                 js.setBounds(0, 0, 1346, 453);
                 panel_1.add(js);
		

	   
		
		
		
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
              
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(0, 655, 1366, 113);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		btnEliminar = new JButton("Eliminnar");
		btnEliminar.setBounds(1242, 31, 100, 35);
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(btnEliminar);
		
		btnAlterar = new JButton("Actualizar");
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlterar.setBounds(1097, 31, 100, 35);
		panel_2.add(btnAlterar);
		
		 btnInserir = new JButton("Inserir");
		btnInserir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInserir.setBounds(926, 31, 119, 35);
		panel_2.add(btnInserir);
		
		JLabel lblNewLabel_1 = new JLabel("Clientes ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(65, 11, 60, 23);
		panel_2.add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\OSVALDO\\Desktop\\icon-noticias.png"));
		label.setBounds(327, 11, 60, 47);
		panel_2.add(label);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.inactiveCaption);
		panel_3.setBounds(0, 72, 1366, 129);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel codigo = new JLabel("Codigo");
		codigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		codigo.setBounds(104, 31, 55, 22);
		panel_3.add(codigo);
		
		textField_4 = new JTextField();
		textField_4.setBounds(169, 29, 104, 30);
		panel_3.add(textField_4);
		textField_4.setColumns(10);
		
		  nome = new JLabel("Nome");
		nome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nome.setBounds(106, 75, 46, 14);
		panel_3.add(nome);
		
		textField_5 = new JTextField();
		textField_5.setBounds(169, 70, 274, 29);
		panel_3.add(textField_5);
		textField_5.setColumns(10);
		
		JButton pesquisar = new JButton("Pesquisar");
		pesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pesquisar.setBounds(453, 66, 104, 34);
		panel_3.add(pesquisar);
		
		comboBox = new JComboBox();
		comboBox.setBounds(1049, 24, 165, 40);
              
                
                comboBox.addItem("Clientes");
                 comboBox.addItem("Camioes");
                 comboBox.addItem("Condutor");
		panel_3.add(comboBox);
        
                
        
		
		JLabel lblNewLabel = new JLabel("Visualizacao");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(935, 26, 104, 33);
		panel_3.add(lblNewLabel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.activeCaption);
		panel_4.setBounds(0, 0, 1366, 36);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JButton Saida = new JButton("X");
		Saida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Saida.setBounds(1304, 0, 62, 37);
		panel_4.add(Saida);
		Saida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		Saida.setBackground(Color.DARK_GRAY);
		Saida.setForeground(Color.WHITE);
		
	    
		
		JLabel timeLabel = new JLabel("Data ");
		timeLabel.setForeground(Color.WHITE);
		timeLabel.setSize(201, 35);
		timeLabel.setLocation(10, 67);
	      panel_2.add(timeLabel);
	        

	        ;
	  
	        final DateFormat timeFormat = new SimpleDateFormat("dd.MM.yyyy | HH:mm:ss a");
	        ActionListener timerListener = new ActionListener()
	        {
	            public void actionPerformed(ActionEvent e)
	            {
	                Date date = new Date();
	                String time = timeFormat.format(date);
	                timeLabel.setText(time);
	            }
	        };
	        Timer timer = new Timer(1000, timerListener);        
	        timer.setInitialDelay(0);
	        timer.start(); 
		
		 try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ActualizarCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ActualizarCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ActualizarCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ActualizarCliente.class.getName()).log(Level.SEVERE, null, ex);
            
        }
       
		
	
		setUndecorated(true);
		setVisible(true);
		  btnEliminar.addActionListener(new btnEliminarListener());
               btnAlterar.addActionListener(new btnAlterarListener());
               btnInserir.addActionListener(new btnInserirListenr());
              // btnPesquisar.addActionListener(new ExemploJTable.btnPesquisarListener());
	 comboBox.addActionListener(new ActionListener() {
                    
                     public void actionPerformed(ActionEvent e) {
                     int i = comboBox.getSelectedIndex();
                     switch (i){
                         case 0:
                             new VisualizarCliente();
                             setVisible(false);
                             break;
                         case 1:
                             new VisualizarCamiao();
                             setVisible(false);
                             break;
                         }
                     
                     }});
        
	}

private void criaJTable() {
	  tabela=new JTable(modelo);
          modelo.addColumn("Id");
	  modelo.addColumn("Nome");
	  modelo.addColumn("Provincia");
	  modelo.addColumn("Distrito");
	  modelo.addColumn("TotalValor");
	  modelo.addColumn("Solicitacoes");
	  tabela.getColumnModel().getColumn(0).setPreferredWidth(4);
	  tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
	  tabela.getColumnModel().getColumn(2).setPreferredWidth(50);
	  tabela.getColumnModel().getColumn(3).setPreferredWidth(50);
	  tabela.getColumnModel().getColumn(4).setPreferredWidth(10);
	  tabela.getColumnModel().getColumn(5).setPreferredWidth(10);
	  pesquisar(modelo);
	  
		
	}

	public static void pesquisar(DefaultTableModel modelo) {
	   modelo.setNumRows(0);
           
	ClienteDAO cdao=new  ClienteDAO();
         List <Cliente> Clientes= cdao.listar();
        for(Cliente c:Clientes){
            
            modelo.addRow(new Object[]{c.getIdCliente(),c.getNome(),c.getProvincia(),c.getDistrito(),
            c.getTotalValor(),c.getTotalSolicitacoes()});
        }
	}
        
        public static void pesquisard(DefaultTableModel modelo) {
	   modelo.setNumRows(0);
           
	ClienteDAO cdao=new  ClienteDAO();
         List <Cliente> Clientes= cdao.listar();
        for(Cliente c:Clientes){
            
            modelo.addRow(new Object[]{c.getIdCliente(),c.getNome(),c.getProvincia(),c.getDistrito(),
            c.getTotalValor(),c.getTotalSolicitacoes()});
        }
	}


    private class btnInserirListenr implements ActionListener {
 
    
        public void actionPerformed(ActionEvent e) {
           InserirCliente ic=new InserirCliente(modelo);
           ic.setVisible(true);
        }
    }


    private  class btnAlterarListener implements ActionListener {

   
        @Override
        public void actionPerformed(ActionEvent e) {
           int linhaSelecionada=-1;
           linhaSelecionada=tabela.getSelectedRow();
           if(linhaSelecionada>=0)
           {
               
                   int idCli=(int)tabela.getValueAt(linhaSelecionada,0);
                   
                   ActualizarCliente ac=new ActualizarCliente(modelo,idCli,linhaSelecionada);
                   
                   ac.setVisible(true);
              
           
           
           
           }
           else
                JOptionPane.showMessageDialog(null, "seleciona uma linha.");   
           
        }
    }
        
        public class  btnEliminarListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            int linhaSelecionada=-1;
            linhaSelecionada = tabela.getSelectedRow();
            
            if(linhaSelecionada>=0)
            {
            int idCliente=(int)tabela.getValueAt(linhaSelecionada,0);
            ClienteDAO dao=new ClienteDAO();
            dao.delete(idCliente);
            pesquisar(modelo);
            }
            else
           JOptionPane.showMessageDialog(null,"Seleciona Uma Linha");
            
            
        }   
        
        
        
        
        }
        
        

	public void actionPerformed(ActionEvent e) {
		
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
        
      
}
