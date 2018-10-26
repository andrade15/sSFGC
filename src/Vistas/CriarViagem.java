package Vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CriarViagem extends JFrame {

	private JPanel contentPane;
	JPanel panel_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	JLabel lblSeleccioneAViagem;
	JComboBox comboBox_8;
	JComboBox comboBox_7;
	JLabel label_8;
	JComboBox comboBox_2;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public CriarViagem() {
		int cargas[] = {2,4,7,10,15,20,25};
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 292, 862);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JButton btnNewButton = new JButton("       Menu Principal");
		btnNewButton.setToolTipText("Cancelar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnNewButton.setForeground(new Color(0, 128, 128));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					new JanelaPrincipal();
					setVisible(false);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		btnNewButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btnNewButton.setForeground(Color.WHITE);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setIcon(new ImageIcon(CriarViagem.class.getResource("C:\\Users\\Manjate\\Documents\\NetBeansProjects\\SGFC\\build\\classes\\Vistas\\icones\\home-icon.png")));
		btnNewButton.setBounds(-5, 171, 297, 56);
		panel.add(btnNewButton);
		btnNewButton.setForeground(new Color(0, 128, 128));
		btnNewButton.setBackground(SystemColor.activeCaption);
		
		
		
		JLabel lblDadosDaViagem = new JLabel("Dados da VIAGEM");
		lblDadosDaViagem.setToolTipText("Campos obrigat\u00F3rios");
		lblDadosDaViagem.setForeground(Color.WHITE);
		lblDadosDaViagem.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDadosDaViagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblDadosDaViagem.setBounds(10, 294, 189, 34);
		panel.add(lblDadosDaViagem);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(-5, 177, 297, -3);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.DARK_GRAY);
		separator_1.setBounds(-5, 326, 297, 2);
		panel.add(separator_1);
		
		JLabel lblNewLabel = new JLabel("    Cliente");
		lblNewLabel.setIcon(new ImageIcon(CriarViagem.class.getResource("C:\\Users\\Manjate\\Documents\\NetBeansProjects\\SGFC\\build\\classes\\Vistas\\\\icones\\tick.png")));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setForeground(SystemColor.inactiveCaption);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(67, 339, 103, 34);
		panel.add(lblNewLabel);
		
		JLabel lblCarga = new JLabel("    Carga");
		lblCarga.setIcon(new ImageIcon(CriarViagem.class.getResource("C:\\Users\\Manjate\\Documents\\NetBeansProjects\\SGFC\\build\\classes\\Vistas\\\\icones\\tick.png")));
		lblCarga.setForeground(SystemColor.activeCaption);
		lblCarga.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblCarga.setBackground(Color.BLACK);
		lblCarga.setBounds(67, 384, 103, 34);
		panel.add(lblCarga);
		
		JLabel lblCamies = new JLabel("    Cami\u00F5es");
		lblCamies.setIcon(new ImageIcon(CriarViagem.class.getResource("C:\\Users\\Manjate\\Documents\\NetBeansProjects\\SGFC\\build\\classes\\Vistas\\\\icones\\tick.png")));
		lblCamies.setForeground(SystemColor.inactiveCaption);
		lblCamies.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblCamies.setBackground(Color.BLACK);
		lblCamies.setBounds(67, 444, 103, 34);
		panel.add(lblCamies);
		
		JLabel lblCondutor = new JLabel("     Condutor");
		lblCondutor.setIcon(new ImageIcon(CriarViagem.class.getResource("C:\\Users\\Manjate\\Documents\\NetBeansProjects\\SGFC\\build\\classes\\Vistas\\icones\\tick.png")));
		lblCondutor.setForeground(SystemColor.inactiveCaption);
		lblCondutor.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblCondutor.setBackground(Color.BLACK);
		lblCondutor.setBounds(67, 504, 103, 34);
		panel.add(lblCondutor);
		
		panel_1 = new JPanel();
		panel_1.setForeground(SystemColor.info);
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(285, 0, 1105, 781);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("NOVA CARGA");
		lblNewLabel_1.setForeground(new Color(0, 153, 204));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBackground(SystemColor.info);
		lblNewLabel_1.setBounds(621, 61, 284, 45);
		panel_1.add(lblNewLabel_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.DARK_GRAY);
		separator_2.setBounds(631, 104, 297, 2);
		panel_1.add(separator_2);
		
		JLabel lblNomeApelido = new JLabel("Peso");
		lblNomeApelido.setForeground(new Color(255, 255, 240));
		lblNomeApelido.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeApelido.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNomeApelido.setBackground(new Color(255, 255, 240));
		lblNomeApelido.setBounds(621, 125, 168, 37);
		panel_1.add(lblNomeApelido);
		
		JLabel lblNmeroDeBi = new JLabel("Tipo de Carga");
		lblNmeroDeBi.setHorizontalAlignment(SwingConstants.LEFT);
		lblNmeroDeBi.setForeground(new Color(255, 255, 240));
		lblNmeroDeBi.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNmeroDeBi.setBackground(Color.BLACK);
		lblNmeroDeBi.setBounds(621, 217, 168, 37);
		panel_1.add(lblNmeroDeBi);
		
		JLabel lblCidade = new JLabel("Seguro");
		lblCidade.setHorizontalAlignment(SwingConstants.LEFT);
		lblCidade.setForeground(new Color(255, 255, 240));
		lblCidade.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCidade.setBackground(Color.BLACK);
		lblCidade.setBounds(621, 306, 168, 37);
		panel_1.add(lblCidade);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setHorizontalAlignment(SwingConstants.LEFT);
		lblValor.setForeground(new Color(255, 255, 240));
		lblValor.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblValor.setBackground(Color.BLACK);
		lblValor.setBounds(621, 387, 168, 37);
		panel_1.add(lblValor);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setEnabled(false);
				new Ajuda();
				setEnabled(true);
			}
		});
		btnNewButton_1.setToolTipText("Ajuda");
		btnNewButton_1.setIcon(new ImageIcon(CriarViagem.class.getResource("C:\\Users\\Manjate\\Documents\\NetBeansProjects\\SGFC\\build\\classes\\Vistas\\\\icones\\Help.png")));
		btnNewButton_1.setBounds(1043, 61, 32, 28);
		panel_1.add(btnNewButton_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
			}
		});
		comboBox_2.setForeground(SystemColor.activeCaption);
		
      for(byte i = 0; i<cargas.length;i++){
			
			comboBox_2.addItem(cargas[i]+"");
	 	}
		comboBox_2.setSelectedItem(null);
		
		comboBox_2.setToolTipText("Selelccione o peso da carga");
		comboBox_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		comboBox_2.setBackground(SystemColor.inactiveCaption);
		comboBox_2.setBounds(621, 172, 297, 34);
		panel_1.add(comboBox_2);
		
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setForeground(SystemColor.activeCaption);
		
		
		comboBox_3.addItem("Combustivel");
		comboBox_3.addItem("Mobili�rio");
		comboBox_3.addItem("Materiais de Construc�o");
		comboBox_3.addItem("Alimentos");
		
		comboBox_3.setSelectedItem(null);
		comboBox_3.setToolTipText("Seleccione o tipo de carga");
		comboBox_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		comboBox_3.setBackground(SystemColor.inactiveCaption);
		comboBox_3.setBounds(621, 259, 297, 34);
		panel_1.add(comboBox_3);
		
		textField = new JTextField();
		textField.setToolTipText("estado do seguro");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField.setColumns(10);
		textField.setBounds(621, 340, 297, 37);
		panel_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setForeground(Color.BLACK);
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(621, 417, 297, 37);
		panel_1.add(textField_1);
		
		JButton button = new JButton("X");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
		});
		button.setToolTipText("Fechar");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		button.setBackground(SystemColor.menu);
		button.setBounds(1021, 0, 61, 34);
		panel_1.add(button);
		
		JLabel label = new JLabel("Cami\u00E3o");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setForeground(new Color(255, 255, 240));
		label.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label.setBackground(SystemColor.info);
		label.setBounds(99, 648, 284, 45);
		panel_1.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//CamiaoDAO dao = new CamiaoDao();
				//Vector v = dao.listarTodos();
				//for (byte i = 0; i<v.size(); i++){
				//Camiao ca = v.elementAt(i);
				//if (ca.getDisponibilidade().charAt(0) = 'd'&&(int)comboBox_2.getSelectedItem()<ca.getPesoBruto){
				//comboBox.addItem(ca.getMatricula());
			     //
				//
			//}
			//}
			}
		});
		comboBox.setToolTipText("Seleccione o condutor com o PB necess\u00E1rio");
		comboBox.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(99, 704, 297, 34);
		panel_1.add(comboBox);
		
		JLabel label_1 = new JLabel("Condutor");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setForeground(new Color(255, 255, 240));
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label_1.setBackground(SystemColor.info);
		label_1.setBounds(621, 648, 284, 45);
		panel_1.add(label_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("Seleccione o condutor para escalar a viagem");
		comboBox_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(621, 704, 297, 34);
		panel_1.add(comboBox_1);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(Color.DARK_GRAY);
		separator_3.setBounds(99, 691, 297, 2);
		panel_1.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBackground(Color.DARK_GRAY);
		separator_4.setBounds(621, 691, 297, 2);
		panel_1.add(separator_4);
		
		JLabel label_2 = new JLabel("NOVO CLIENTE");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(51, 153, 204));
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label_2.setBackground(SystemColor.info);
		label_2.setBounds(10, 61, 284, 45);
		panel_1.add(label_2);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBackground(Color.DARK_GRAY);
		separator_5.setBounds(99, 104, 297, 2);
		panel_1.add(separator_5);
		
		JLabel label_3 = new JLabel("Nome & Apelido");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setForeground(new Color(255, 255, 240));
		label_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label_3.setBackground(Color.BLACK);
		label_3.setBounds(99, 135, 168, 37);
		panel_1.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setForeground(Color.BLACK);
		textField_2.setColumns(10);
		textField_2.setBounds(99, 172, 297, 37);
		panel_1.add(textField_2);
		
		JLabel label_4 = new JLabel("Numero de BI");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setForeground(new Color(255, 255, 240));
		label_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label_4.setBackground(Color.BLACK);
		label_4.setBounds(99, 220, 168, 37);
		panel_1.add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("Numero de BI");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setForeground(Color.BLACK);
		textField_3.setColumns(10);
		textField_3.setBounds(99, 258, 297, 37);
		panel_1.add(textField_3);
		
		JLabel label_5 = new JLabel("Provincia");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setForeground(new Color(255, 255, 240));
		label_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label_5.setBackground(Color.BLACK);
		label_5.setBounds(99, 306, 168, 37);
		panel_1.add(label_5);
		
		 
		JComboBox comboBox_4 = new JComboBox();
		
		comboBox_4.setForeground(SystemColor.activeCaption);
		
		comboBox_4.setToolTipText("Seleccione a provincia de destino");


		comboBox_4.addItem("Maputo Cidade");
		comboBox_4.addItem("Provincia de Maputo");
		comboBox_4.addItem("Gaza");
		comboBox_4.addItem("Inhambane");
		comboBox_4.addItem("Manica");
		comboBox_4.addItem("Sofala");
		comboBox_4.addItem("Tete");
		comboBox_4.addItem("Zamb�zia");
		comboBox_4.addItem("Cabo Delgado");
		comboBox_4.addItem("Niassa");
		comboBox_4.addItem("Maputo Cidade");
	
	    comboBox_4.setSelectedItem(null);
		comboBox_4.setFont(new Font("Times New Roman", Font.BOLD, 12));
		comboBox_4.setBackground(new Color(240, 255, 255));
		comboBox_4.setBounds(99, 342, 297, 34);
		panel_1.add(comboBox_4);
		
	
		
		
		JLabel label_6 = new JLabel("Cidade");
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setForeground(new Color(255, 255, 240));
		label_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label_6.setBackground(Color.BLACK);
		label_6.setBounds(99, 387, 168, 37);
		panel_1.add(label_6);
		
		
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setForeground(SystemColor.activeCaption);
		String combo = (String)comboBox_4.getSelectedItem();
		
		String cidMaputo[] = {"Maputo", "Matola"};
		String cidGaza[] = {"Xai - Xai", "Madendere","Chibuto"};
		String cidInhambane[] = {"Inhambane Ceu", "Vilanculos"};
		
		comboBox_5.setSelectedItem(null);
		comboBox_5.setToolTipText("Seleccione a Cidade");
		comboBox_5.setFont(new Font("Times New Roman", Font.BOLD, 12));
		comboBox_5.setBackground(SystemColor.inactiveCaption);
		comboBox_5.setBounds(99, 419, 297, 34);
		panel_1.add(comboBox_5);
		
		JLabel label_7 = new JLabel("Contacto");
		label_7.setToolTipText("Insira um n�mero de telefone v�lido");
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setForeground(new Color(255, 255, 240));
		label_7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		label_7.setBackground(Color.BLACK);
		label_7.setBounds(99, 478, 168, 37);
		panel_1.add(label_7);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("Insira o contacto");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setForeground(Color.BLACK);
		textField_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(99, 512, 297, 37);
		panel_1.add(textField_4);
		
		JButton btnOk = new JButton("Salvar");
		btnOk.setToolTipText("Criar viagem");
		btnOk.setForeground(SystemColor.textInactiveText);
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnOk.setBackground(SystemColor.inactiveCaptionBorder);
		btnOk.setBounds(988, 717, 78, 37);
	
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String nome = null, bI = null,provincia = null,localidade = null,tipo = null;
				long telefone = 0;
				int carga = 0;
				try {
					
					new JanelaPrincipal();
					setVisible(false);
					try{
					nome = textField_2.getText();
					bI = textField_3.getText();
					provincia = (String)comboBox_4.getSelectedItem();
					localidade = (String)comboBox_5.getSelectedItem();
					
					telefone = Long.parseLong(textField_4.getText());
					carga = Integer.parseInt((String)comboBox_2.getSelectedItem());
					tipo = (String)comboBox_3.getSelectedItem();
					int pocket_money = Integer.parseInt(label_8.getText());
				    int distancia = Integer.parseInt((String)comboBox_7.getSelectedItem());
				    String pontoDePartida = (String)comboBox_8.getSelectedItem();
				    String seguro = (String)textField.getText();
				    double valor = Double.parseDouble((String)textField_1.getText());
				    
				    JOptionPane.showMessageDialog(null, " NOME: "+nome+" BI: "+bI+" PROVINCIA: "+provincia+"lOCALIDADE: "+localidade+"TELEFONE: "+telefone+"CARGA: "+carga+"TIPO: "+tipo+"POCKET MONEY"+pocket_money+"DISTANCIA: "+distancia+": "+pontoDePartida+"SEGURO:"+seguro+"VALOR: "+valor);
				    
					}catch(NullPointerException e){JOptionPane.showMessageDialog(null,"Introduza todos os campos necessarios");}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		comboBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int itemCount = comboBox_5.getItemCount();
				lblSeleccioneAViagem.hide();
				switch((int)comboBox_4.getSelectedIndex()){
				case 0:
				    for(int i=0;i<itemCount;i++){
				        comboBox_5.removeItemAt(0);
				     } 
					
					comboBox_5.addItem("Maputo");
				       comboBox_5.addItem("Matola");
				       comboBox_5.setSelectedItem(null);
				       break;
				       
				       
				case 1: for(int i=0;i<itemCount;i++){
			        comboBox_5.removeItemAt(0);
			     } 
					
					
					comboBox_5.addItem("Maputo");
			       comboBox_5.addItem("Matola");
			       comboBox_5.setSelectedItem(null);break;
				case 2:
					 for(int i=0;i<itemCount;i++){
					        comboBox_5.removeItemAt(0);
					     } 
					 comboBox_5.addItem("Xai - Xai");
				       comboBox_5.addItem("Ch�kw�");
				       comboBox_5.setSelectedItem(null);break;
				case 3:
					 for(int i=0;i<itemCount;i++){
					        comboBox_5.removeItemAt(0);
					     } 
					 comboBox_5.addItem("Inhambane - Ceu");
				       comboBox_5.addItem("Vilanculos");
				       comboBox_5.setSelectedItem(null);break;
				case 4:
					
					 for(int i=0;i<itemCount;i++){
					        comboBox_5.removeItemAt(0);
					     } 
					 comboBox_5.addItem("Beira");
				       comboBox_5.addItem("Gorongosa");
				       comboBox_5.setSelectedItem(null);break;
				case 5:
					
					 for(int i=0;i<itemCount;i++){
					        comboBox_5.removeItemAt(0);
					     } 
					 comboBox_5.addItem("Beira");
				       comboBox_5.addItem("Chibabava");
				       comboBox_5.setSelectedItem(null);break;
				case 6:
					
					 for(int i=0;i<itemCount;i++){
					        comboBox_5.removeItemAt(0);
					     } 
					 
					 comboBox_5.addItem("Tete");
					 comboBox_5.addItem("Mague");
				       comboBox_5.addItem("Vila Coutinho");
				       comboBox_5.setSelectedItem(null);break;
				case 7:
					
					 for(int i=0;i<itemCount;i++){
					        comboBox_5.removeItemAt(0);
					     } 
					 comboBox_5.addItem("Quelimane");
				       comboBox_5.addItem("Vila Junqueiro");
				       comboBox_5.setSelectedItem(null);break;
				case 8:
					
					 for(int i=0;i<itemCount;i++){
					        comboBox_5.removeItemAt(0);
					     } 
					 comboBox_5.addItem("Pemba");
				       comboBox_5.addItem("Moeda");
				       comboBox_5.addItem("Namumo");
				       comboBox_5.setSelectedItem(null);break;
				case 9:
					 for(int i=0;i<itemCount;i++){
					        comboBox_5.removeItemAt(0);
					     } 
					 comboBox_5.addItem("Lichinga");
				       comboBox_5.addItem("Chiconoco");
				       comboBox_5.setSelectedItem(null);
						 
				}
			}
		});
		panel_1.add(btnOk);
		
		lblSeleccioneAViagem = new JLabel("Seleccione a viagem para ter os dados");
		lblSeleccioneAViagem.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblSeleccioneAViagem.setForeground(new Color(255, 0, 0));
		lblSeleccioneAViagem.setBounds(99, 453, 262, 14);
		panel_1.add(lblSeleccioneAViagem);
		
		JLabel lblPocketMoney = new JLabel("Pocket Money");
		lblPocketMoney.setToolTipText("Insira um n\u00FAmero de telefone v\u00E1lido");
		lblPocketMoney.setHorizontalAlignment(SwingConstants.LEFT);
		lblPocketMoney.setForeground(new Color(255, 255, 240));
		lblPocketMoney.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPocketMoney.setBackground(Color.BLACK);
		lblPocketMoney.setBounds(99, 558, 168, 37);
		panel_1.add(lblPocketMoney);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBackground(Color.DARK_GRAY);
		separator_6.setBounds(99, 560, 297, 2);
		panel_1.add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBackground(Color.DARK_GRAY);
		separator_7.setBounds(621, 478, 297, 2);
		panel_1.add(separator_7);
		
		JLabel lblDistncia = new JLabel("Dist\u00E2ncia");
		lblDistncia.setToolTipText("Insira um n\u00FAmero de telefone v\u00E1lido");
		lblDistncia.setHorizontalAlignment(SwingConstants.LEFT);
		lblDistncia.setForeground(new Color(255, 255, 240));
		lblDistncia.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDistncia.setBackground(Color.BLACK);
		lblDistncia.setBounds(621, 478, 168, 37);
		panel_1.add(lblDistncia);
		
		comboBox_7 = new JComboBox();
		
		int distancias[] = {500,700,900,1200,1500,1700,2000,2500,2800,3000,4000,5000};
		comboBox_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
			}
		});
		comboBox_7.setForeground(SystemColor.activeCaption);
		
      for(byte i = 0; i<distancias.length;i++){
			
			comboBox_7.addItem(distancias[i]+"");
	 	}
		comboBox_7.setSelectedItem(null);
		
		
		comboBox_7.setToolTipText("Seleccione a provincia de destino");
		comboBox_7.setForeground(SystemColor.activeCaption);
		comboBox_7.setFont(new Font("Times New Roman", Font.BOLD, 12));
		comboBox_7.setBackground(SystemColor.inactiveCaption);
		comboBox_7.setBounds(621, 514, 297, 34);
		panel_1.add(comboBox_7);
		
		JLabel lblPontoDePartida = new JLabel("Ponto de partida");
		lblPontoDePartida.setToolTipText("Insira um n\u00FAmero de telefone v\u00E1lido");
		lblPontoDePartida.setHorizontalAlignment(SwingConstants.LEFT);
		lblPontoDePartida.setForeground(new Color(255, 255, 240));
		lblPontoDePartida.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPontoDePartida.setBackground(Color.BLACK);
		lblPontoDePartida.setBounds(621, 558, 168, 37);
		panel_1.add(lblPontoDePartida);
		
		comboBox_8 = new JComboBox();
		

		comboBox_8.addItem("Maputo Cidade");
		comboBox_8.addItem("Provincia de Maputo");
		comboBox_8.addItem("Gaza");
		comboBox_8.addItem("Inhambane");
		comboBox_8.addItem("Manica");
		comboBox_8.addItem("Sofala");
		comboBox_8.addItem("Tete");
		comboBox_8.addItem("Zamb�zia");
		comboBox_8.addItem("Cabo Delgado");
		comboBox_8.addItem("Niassa");
		comboBox_8.addItem("Maputo Cidade");
	
	    comboBox_8.setSelectedItem(null);
		comboBox_8.setToolTipText("Seleccione a provincia de partida");
		comboBox_8.setForeground(SystemColor.activeCaption);
		comboBox_8.setFont(new Font("Times New Roman", Font.BOLD, 12));
		comboBox_8.setBackground(SystemColor.inactiveCaption);
		comboBox_8.setBounds(621, 595, 297, 34);
		panel_1.add(comboBox_8);
		
		label_8 = new JLabel();
		label_8.setText("0");
		label_8.setForeground(new Color(0, 0, 128));
		label_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_8.setBounds(99, 597, 297, 31);
		panel_1.add(label_8);
		
		comboBox_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int s = Integer.parseInt(((String)comboBox_7.getSelectedItem()));
				if (s<600)
				label_8.setText(""+500);
				else
					if (s<1000)
						label_8.setText(""+1000);
					else
						label_8.setText(""+2000);
					
					
				
			}
		});
		
	//	JDateChooser data = new JDateChooser();
	    setLocationRelativeTo(null);
		setUndecorated(true);
		setVisible(true);
		
		
		
	

	}
}
