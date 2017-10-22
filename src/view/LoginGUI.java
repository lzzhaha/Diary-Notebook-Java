package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import util.JDOM;

public class LoginGUI extends JFrame{
	
	private static final long serialVersionUID = 4994949944841194839L;
	private JPanel contentPane;  
	private JTextField IDtxt; 
	private JLabel Passwdlabel;
	private JPasswordField passwordField;
	private JButton login_button;
	private JButton back_button;
	
	
	public LoginGUI(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel IDlabel = new JLabel("Please enter ID");
		IDlabel.setBounds(68, 170, 250, 39);
		contentPane.add(IDlabel);

		IDtxt = new JTextField();
		IDtxt.setBounds(400, 179, 126, 21);
		contentPane.add(IDtxt);
		IDtxt.setColumns(10);

		Passwdlabel = new JLabel("Please enter password");
		Passwdlabel.setBounds(68, 219, 250, 50);
		contentPane.add(Passwdlabel);

		passwordField = new JPasswordField();
		passwordField.setBounds(400, 234, 126, 21);
		contentPane.add(passwordField);

		login_button = new JButton("login");


		login_button.addMouseListener(new MouseAdapter(){
			
			@Override
			public void mouseClicked(MouseEvent e){
				event_login();
			}
		});
		
		login_button.addKeyListener(new KeyAdapter(){
			
			@Override 
			public void keyPressed(KeyEvent e){
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					event_login();
				}
			}
		});
		
		login_button.setBounds(239, 310, 93, 23);
		
		contentPane.add(login_button);
		
		back_button = new JButton("BACK");
		
		back_button.addMouseListener(new MouseAdapter(){
			
			@Override
			public void mouseClicked(MouseEvent e){
				
				IndexGUI.init();
				setVisible(false);
			}
		});
		
		back_button.setBounds(507,310, 93, 23);
		
		contentPane.add(back_button);
		
		JLabel label = new JLabel("Welcome to use Notebook");
		label.setFont(new Font("Ubuntu", Font.BOLD | Font.ITALIC, 30));
		label.setBounds(142, 54, 386, 35);
		contentPane.add(label);
	}
	
	
	/*
	 * Launch the login page
	 * */
	
	public void loginGUI(){
		
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				
				try{
					LoginGUI frame = new LoginGUI();
					
					frame.setVisible(true);
				}catch(Exception e){
					
					e.printStackTrace();
				}
			}
		});
	}
	
	
	private void event_login(){
		String id = IDtxt.getText();
		
		String password = new String(passwordField.getPassword());
		
		String flag = JDOM.read(id, password);
		
		if(flag.contains("Welcome")){
			
			  JOptionPane.showMessageDialog(contentPane, flag, "Diary_Notebook",JOptionPane.PLAIN_MESSAGE);
	          
			  //get Name 
			  String[] buffer = flag.split(" ");
			  
			  new UserGUI().init(buffer[1]);
	          
	          setVisible(false);
		}else{
			
			JOptionPane.showMessageDialog(contentPane,
					flag,"ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}
}
