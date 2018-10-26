/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.dao.ClienteDAO;
import model.entidade.Cliente;
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

/**
 *
 * @author OSVALDO
 */
public class InserirCliente extends JFrame {
    
    private JButton salvar,limpar;
    private JLabel nome,provincia,distrito;
     private TextField txnome,txprovincia,txdistrito;
     private JPanel painel;
     private DefaultTableModel modelo;
     	private JPanel contentPane;

    public InserirCliente(DefaultTableModel md)
    {
       super("Novo Cliente"); 
         modelo = md;
       criarJanela();
    }
    
   

    public void criarJanela() {
        
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(450,300);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 nome = new JLabel("Nome");
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
		contentPane.add(txdistrito);
		txdistrito.setColumns(10);
                
		
		 salvar = new JButton("Salvar");
		salvar.setBounds(198, 218, 104, 31);
		contentPane.add(salvar);
		
                setVisible(true);
                setSize(450,300);
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

        public void actionPerformed(ActionEvent e) {
      Cliente cli=new Cliente();
        cli.setNome(txnome.getText());
        cli.setProvincia(txprovincia.getText());
        cli.setDistrito(txdistrito.getText());
        ClienteDAO dao=new ClienteDAO();
          
        dao.inserir(cli);
        VisualizarCliente.pesquisar(modelo);
                setVisible(false);
       
        
        }
    }
    
    
    
    
}
