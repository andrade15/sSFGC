package Janelas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Ajuda extends JFrame {

	/**
	 * Launch the application.
	 */
		/**
	 * Create the frame.
	 */
	public Ajuda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 798, 596);
		
		setUndecorated(false);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(205, 0, 577, 567);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Existem alguns aspectos que podem estar a dificultar o usuario... seleccione e veja a documentacao\r\nfd,mdfbvdmnvcnmvxcnmcbnkbv\r\nvsdkjcjhbcvhjcvxhjvcjbhcvhjbvckj/n\\n\r\n");
		lblNewLabel.setBounds(20, 47, 526, 425);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 207, 557);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Inserc\u00F5es");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblNewLabel.setText("Veja como são feitas as insercoes");
			}
		});
		btnNewButton.setBounds(38, 148, 89, 23);
		panel_1.add(btnNewButton);
		
		JButton btnConsultas = new JButton("Consultas");
		btnConsultas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblNewLabel.setText("");
				lblNewLabel.setText("Veja como sao feitas as consultas");
			}
		});
		btnConsultas.setBounds(38, 204, 89, 23);
		panel_1.add(btnConsultas);
		setVisible(true);
	}
}
