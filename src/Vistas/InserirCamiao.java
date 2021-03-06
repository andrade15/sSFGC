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
import Vistas.VisualizarCamiao;
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
import model.dao.CamiaoDAO;
import model.entidade.Camiao;

/**
 *
 * @author OSVALDO
 */
public class InserirCamiao extends JFrame {
    
    private JButton salvar,limpar;
    private JLabel matricula,marca,seguros,tanque,num_viagens,num_manuntencao, peso_bruto;
       private TextField txmatricula,txmarca,txseguros,txtanque,txnum_viagens,txnum_manuntencao,txpeso_bruto;

       private JPanel painel;
     private DefaultTableModel modelo;
     	private JPanel contentPane;

    public InserirCamiao(DefaultTableModel md)
    {
       super("Novo Camiao"); 
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
                setSize(450,350);
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
                   txmatricula.setText("");
       txmarca.setText("");
       txseguros.setText("");
       txtanque.setText("");
        txpeso_bruto.setText("");
       
       txnum_manuntencao.setText("");
        }
    }

    private class salvarListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
           Camiao ca=new Camiao();
           
        ca.setMatricula(txmatricula.getText());
        ca.setMarca(txmarca.getText());
        ca.setTanque(Float.parseFloat(txtanque.getText()));
        ca.setSeguros(txseguros.getText());
       // ca.setNum_viagens(Integer.parseInt(txnum_viagens.getText()));
        ca.setPeso_bruto(Integer.parseInt(txpeso_bruto.getText()));
        //ca.setNum_Manutencao(Integer.parseInt(txnum_manuntencao.getText()));
           
        CamiaoDAO dao=new CamiaoDAO();
        
        dao.inserir(ca);
        VisualizarCamiao.pesquisar(modelo);
                setVisible(false);
       
        
        }
    }
    
    
    
    
}
