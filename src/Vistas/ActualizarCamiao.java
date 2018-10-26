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
import model.dao.CamiaoDAO;
import model.dao.ClienteDAO;
import model.entidade.Camiao;
import model.entidade.Cliente;


/**
 *
 * @author OSVALDO
 */
public final class ActualizarCamiao extends JFrame {
    
 
     private JPanel panel;
     private  int linhaSelecionada;
     private DefaultTableModel modelo=new DefaultTableModel();
     private Camiao ca;
    	private JPanel contentPane;
        
    
    private JButton salvar,limpar;
    private JLabel matricula,marca,seguros, num_viagens,num_manuntencao, peso_bruto, tanque;
 
      TextField txmatricula,txmarca,txseguros,txtanque,txnum_viagens,txnum_manuntencao,txpeso_bruto;
	
    public ActualizarCamiao(DefaultTableModel md,String ma, int linha) throws UnsupportedLookAndFeelException
    {
       super("Camiao"); 
              criarJanela();
              
       modelo=md;
       linhaSelecionada=linha;
       
       CamiaoDAO dao=new CamiaoDAO();
       ca=dao.listarPorID(ma);
        // cli.setIdCliente(Integer.parseInt(txId.getText()));

       txmatricula.setText(ca.getMatricula());
       txmarca.setText(ca.getMarca());
       txseguros.setText(ca.getSeguros());
       txtanque.setText(""+ca.getTanque());
        txpeso_bruto.setText(""+ca.getPeso_bruto());
       txnum_viagens.setText(""+ca.getNum_viagens());
       txnum_manuntencao.setText(""+ca.getNum_Manutencao());
       
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
		
		txmarca = new TextField();
		txmarca.setBounds(126, 53, 216, 22);
		contentPane.add(txmarca);
		txmarca.setColumns(10);
		
		JButton limpar = new JButton("Limpar");
		limpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		limpar.setBounds(321, 218, 89, 31);
		contentPane.add(limpar);
		
		JLabel matricula = new JLabel("Matricula");
		matricula.setFont(new Font("Tahoma", Font.PLAIN, 14));
		matricula.setBounds(44, 18, 60, 22);
		contentPane.add(matricula);
		
		txtanque = new TextField();
		txtanque.setBounds(126, 87, 216, 24);
		contentPane.add(txtanque);
		txtanque.setColumns(10);
		
		JLabel tanque = new JLabel("Tanque");
		tanque.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tanque.setBounds(44, 86, 74, 22);
		contentPane.add(tanque);
		
		txseguros = new TextField();
		txseguros.setBounds(126, 128, 216, 22);
		contentPane.add(txseguros);
		txseguros.setColumns(10);
		
		JButton salvar = new JButton("Salvar");
		salvar.setBounds(198, 218, 104, 31);
		contentPane.add(salvar);
		
		JLabel marca = new JLabel("Marca");
		marca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		marca.setBounds(44, 51, 74, 22);
		contentPane.add(marca);
		
		JLabel seguros = new JLabel("Seguros");
		seguros.setFont(new Font("Tahoma", Font.PLAIN, 14));
		seguros.setBounds(44, 126, 74, 22);
		contentPane.add(seguros);
		
		txmatricula = new TextField();
		txmatricula.setColumns(10);
		txmatricula.setBounds(126, 20, 216, 22);
		contentPane.add(txmatricula);
		
		JLabel peso_bruto = new JLabel("Peso Bruto");
		peso_bruto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		peso_bruto.setBounds(44, 165, 84, 29);
		contentPane.add(peso_bruto);
		
		txpeso_bruto = new TextField();
		txpeso_bruto.setColumns(10);
		txpeso_bruto.setBounds(126, 170, 216, 23);
		contentPane.add(txpeso_bruto);
		setVisible(true);
		
	
       
       salvar.addActionListener(new salvarListener());
       limpar.addActionListener(new LimparListener());
       
    }

    private class LimparListener implements ActionListener  {

        public LimparListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
        
                txmatricula.setText("");
       txmarca.setText("");
       txseguros.setText("");
       txtanque.setText("");
        txpeso_bruto.setText("");
       txnum_viagens.setText("");
       txnum_manuntencao.setText("");
            
        }
    }

    private class salvarListener implements ActionListener{

        public salvarListener() {
            
        }

        @Override
        public void actionPerformed(ActionEvent e) {
      Camiao ca=new Camiao();
     
        
       // cli.setIdCliente(Integer.parseInt(txId.getText()));
        ca.setMatricula(txmatricula.getText());
        ca.setMarca(txmarca.getText());
        ca.setTanque(Float.parseFloat(txtanque.getText()));
        ca.setSeguros(txseguros.getText());
        ca.setNum_viagens(Integer.parseInt(txnum_viagens.getText()));
        ca.setPeso_bruto(Integer.parseInt(txpeso_bruto.getText()));
        ca.setNum_Manutencao(Integer.parseInt(txnum_manuntencao.getText()));
         CamiaoDAO dao=new CamiaoDAO();
        dao.Update(ca);
        modelo.removeRow(linhaSelecionada);
        modelo.addRow(new Object[]{ca.getMatricula(),ca.getMarca(),ca.getTanque(),ca.getSeguros(),
            ca.getPeso_bruto(),ca.getNum_viagens(),ca.getNum_Manutencao()});
            setVisible(false);
       
        
        }
    }
    
    
    
    
   }

