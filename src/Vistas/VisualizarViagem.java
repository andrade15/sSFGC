package vistas;

import Vistas.ActualizarCamiao;

import Vistas.novaViagem;
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
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.CamiaoDAO;
import model.dao.ClienteDAO;
import model.dao.ViagemDAO;
import model.entidade.Camiao;
import model.entidade.Cliente;
import model.entidade.Viagens;

public class VisualizarViagem extends JFrame{
    
	private JPanel contentPane;
	private JTextField textField;
	private JLabel    nome;
	private JTextField textField_1;
	private JPanel panel2;
	private  JLabel numViagens;
        private JButton btnActualizar;
	private JButton btneliminar;
	private JButton btnPesquisar;
        private JTable tabela;
        private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
        JComboBox comboBox;
    private DefaultTableModel modelo=new DefaultTableModel();
	/**
	 * Launch the application.
	 */
	public void executar() {
         new VisualizarViagem();}

	/**
	 * Create the frame.
	 */
	public VisualizarViagem() {
		 super("Consultas");
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
		
		
		
		btneliminar = new JButton("Eliminar");
		btneliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btneliminar.setBounds(1097, 31, 100, 35);
		panel_2.add(btneliminar);
		
		 btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnActualizar.setBounds(926, 31, 119, 35);
		panel_2.add(btnActualizar);
		
		numViagens =new JLabel("Viagens ");
		numViagens.setFont(new Font("Tahoma", Font.PLAIN, 16));
		numViagens.setForeground(Color.WHITE);
		numViagens.setBounds(65, 11, 60, 23);
		panel_2.add(numViagens);
               
		
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
                
               
                 comboBox.addItem("Cliente");
                 comboBox.addItem("Camiao");
                comboBox.addItem("Condutor");
                 comboBox.setSelectedItem(null);
		panel_3.add(comboBox);
                
            comboBox.addActionListener(new ActionListener() {
                     
                  public void actionPerformed(ActionEvent e) {
                  int   i = comboBox.getSelectedIndex();
                  switch(i){
                      case 0:
                             new VisualizarCliente(); setVisible(false);  break;
                      case 1:
                                 new   Vistas.VisualizarCamiao(); setVisible(true);break;
                         }}});
                

		
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
            Logger.getLogger(ActualizarCamiao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ActualizarCamiao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ActualizarCamiao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ActualizarCamiao.class.getName()).log(Level.SEVERE, null, ex);
            
        }
       
		
	         criaJTable();
		setUndecorated(true);
		setVisible(true);
		
              
                
               btnActualizar.addActionListener(new btnInserirListenr());
              // btnPesquisar.addActionListener(new ExemploJTable.btnPesquisarListener());
	
	}

private void criaJTable() {

	
	  tabela=new JTable(modelo);
          modelo.addColumn("Id Cliente");
	  modelo.addColumn("Codigo");
	  modelo.addColumn("Ponto Partida");
	  modelo.addColumn("Distancia");
	  modelo.addColumn("Data Partida");
	  modelo.addColumn("P.Money");
          modelo.addColumn("Provincia");
	  modelo.addColumn("Distrito");
	  modelo.addColumn("Cidade");
	  modelo.addColumn("ID Carga");
          modelo.addColumn("Tipo");
	  modelo.addColumn("Valor");
	  modelo.addColumn("Custo");
	  modelo.addColumn("ID Funcionario");
          modelo.addColumn("Matricula");
	  modelo.addColumn("Numero");
	  modelo.addColumn("Data multa");
          
	  tabela.getColumnModel().getColumn(0).setPreferredWidth(4);
	  tabela.getColumnModel().getColumn(1).setPreferredWidth(7);
	  tabela.getColumnModel().getColumn(2).setPreferredWidth(10);
	  tabela.getColumnModel().getColumn(3).setPreferredWidth(15);
	  tabela.getColumnModel().getColumn(4).setPreferredWidth(8);
	  tabela.getColumnModel().getColumn(5).setPreferredWidth(5);
          tabela.getColumnModel().getColumn(6).setPreferredWidth(10);
	  tabela.getColumnModel().getColumn(7).setPreferredWidth(10);
	  tabela.getColumnModel().getColumn(8).setPreferredWidth(10);
	  tabela.getColumnModel().getColumn(9).setPreferredWidth(4);
	  tabela.getColumnModel().getColumn(10).setPreferredWidth(10);
	  tabela.getColumnModel().getColumn(11).setPreferredWidth(15);
          tabela.getColumnModel().getColumn(12).setPreferredWidth(50);
	  tabela.getColumnModel().getColumn(13).setPreferredWidth(4);
	  tabela.getColumnModel().getColumn(14).setPreferredWidth(12);
	  tabela.getColumnModel().getColumn(15).setPreferredWidth(10);
           tabela.getColumnModel().getColumn(15).setPreferredWidth(10);
	  pesquisar(modelo);
	  
		
	}
		
	

	public  void pesquisar(DefaultTableModel modelo) {
	   modelo.setNumRows(0);
           
	ViagemDAO cadao=new  ViagemDAO();
         List <Viagens> v= cadao.listarTudo();
        for(Viagens vi:v){
            
            modelo.addRow(new Object[]{vi.getIdCliente(),vi.getCodigo(),vi.getPonto_partida(),
                vi.getDistancia(),vi.getData_partida(),vi.getPocket_money(),vi.getProvincia(),
                vi.getDistrito(),vi.getCidade(),vi.getIdcarga(),vi.getTipo(),vi.getValor(),vi.getCusto(),vi.getIdfun(),
                vi.getMatricula(),vi.getNumero(),vi.getData_multa() });
           
	}
             
        }
        
        
        public static void pesquisard(DefaultTableModel modelo) {
	   modelo.setNumRows(0);
           
	CamiaoDAO cdao=new  CamiaoDAO();
         List <Camiao> Camioes= cdao.listar();
        for(Camiao c:Camioes){
            
            //modelo.addRow(new Object[]{c.getIdCliente(),c.getNome(),c.getProvincia(),c.getDistrito(),
          //  c.getTotalValor(),c.getTotalSolicitacoes()});
        }
	}


    private class btnInserirListenr implements ActionListener {
 
    
        public void actionPerformed(ActionEvent e) {
          // novaViagem ic=new novaViagem(modelo);
         //  ic.setVisible(true);
        }
    }


        

	public void actionPerformed(ActionEvent e) {
		
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
  
    }


