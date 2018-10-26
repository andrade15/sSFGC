/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import model.dao.ClienteDAO;
import model.entidade.Cliente;


/**
 *
 * @author OSVALDO
 */
public final class ActualizarCliente extends JFrame {
    
    private JButton salvar,limpar;
    private JLabel Id,nome,provincia,distrito;
     private TextField txId,txnome,txprovincia,txdistrito;
     private JPanel painel;
     private  int linhaSelecionada;
     private DefaultTableModel modelo=new DefaultTableModel();
     private Cliente cli;
    	private JPanel contentPane;
	
    public ActualizarCliente(DefaultTableModel md,int id, int linha) throws UnsupportedLookAndFeelException
    {
       super("Cliente"); 
              criarJanela();
       modelo=md;
       linhaSelecionada=linha;
       
       ClienteDAO dao=new ClienteDAO();
       cli=dao.listarPorID(id);
       
       txId.setText(Integer.toString(cli.getIdCliente()));
       txnome.setText(cli.getNome());
       txprovincia.setText(cli.getProvincia());
        System.out.println(cli.getDistrito());
         txdistrito.setText(cli.getDistrito());
       
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
       
       

    }
    
    

    public void criarJanela() {
     
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		nome= new JLabel("Nome");
		nome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nome.setBounds(30, 59, 74, 22);
		contentPane.add(nome);
		
		txnome = new TextField();
		txnome.setBounds(100, 57, 216, 31);
		contentPane.add(txnome);
		txnome.setColumns(10);
		
	         limpar = new JButton("Limpar");
		limpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		limpar.setBounds(321, 218, 89, 31);
		contentPane.add(limpar);
		
		 provincia = new JLabel("Provincia");
		provincia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		provincia.setBounds(30, 109, 60, 22);
		contentPane.add(provincia);
		
		txprovincia = new TextField();
		txprovincia.setBounds(100, 107, 216, 31);
		contentPane.add(txprovincia);
		txprovincia.setColumns(10);
		
		distrito = new JLabel("Distrito");
		distrito.setFont(new Font("Tahoma", Font.PLAIN, 14));
		distrito.setBounds(30, 149, 74, 22);
		contentPane.add(distrito);
		
                txdistrito = new TextField();
		  txdistrito.setBounds(100, 147, 216, 31);
		contentPane.add(  txdistrito);
		  txdistrito.setColumns(10);
                
                
		txId = new TextField();
		txId.setBounds(100, 147, 216, 31);
		contentPane.add(txId);
		txId.setColumns(10);    
		
		 salvar = new JButton("Salvar");
		salvar.setBounds(198, 218, 104, 31);
		contentPane.add(salvar);
		
	         Id = new JLabel("ID");
		Id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Id.setBounds(30, 15, 60, 22);
		contentPane.add(Id);
		
		txId = new TextField();
		txId.setBounds(100, 11, 86, 31);
		contentPane.add(txId);
        
       
       //setResizable(false);
       setSize(450,300);
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       setVisible(true);
       
       salvar.addActionListener(new salvarListener());
       limpar.addActionListener(new LimparListener());
       
    }

    private class LimparListener implements ActionListener  {

        public LimparListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
         txnome.setText("");
         txprovincia.setText("");
         txdistrito.setText("");
        }
    }

    private class salvarListener implements ActionListener{

        public salvarListener() {
            
        }

        @Override
        public void actionPerformed(ActionEvent e) {
      Cliente cli=new Cliente();
     
      
        cli.setIdCliente(Integer.parseInt(txId.getText()));
        cli.setNome(txnome.getText());
        cli.setProvincia(txprovincia.getText());
        cli.setDistrito(txdistrito.getText());
        ClienteDAO dao=new ClienteDAO();  
        dao.Update(cli);
        modelo.removeRow(linhaSelecionada);
        modelo.addRow(new Object[]{cli.getIdCliente(),cli.getNome(),cli.getProvincia(),
                    cli.getDistrito(),cli.getTotalValor(),cli.getTotalSolicitacoes()});
            setVisible(false);
       
        
        }
    }
    
    
    
    
}
