package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class RegisterGUI extends JFrame{
	 private JPanel contentPane;
	 private JTextField nametext;  
	 private JTextField IDtext;  
	 private JTextField passwdtext;  

	 
	 public RegisterGUI(){
		 
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  setBounds(100, 100, 650, 400);
		  contentPane = new JPanel();
		  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		  setContentPane(contentPane);
		  contentPane.setLayout(null);
	
		  JLabel namelabel = new JLabel("Please enter your name"); 
		  
		  namelabel.setBounds(102, 91, 151, 23);
		  contentPane.add(namelabel);
		  
	        JLabel IDlabel = new JLabel("Please enter your ID");
	        IDlabel.setBounds(102, 160, 151, 23);
	        contentPane.add(IDlabel);


	        JLabel passwdlaber = new JLabel("Please enter password");
	        passwdlaber.setBounds(102, 224, 163, 23);
	        contentPane.add(passwdlaber);

	        nametext = new JTextField();  
	        nametext.setBounds(271, 92, 92, 21); 
	        contentPane.add(nametext);
	        nametext.setColumns(10);  

	       
	        IDtext = new JTextField();
	        IDtext.setBounds(271, 161, 92, 21);
	        contentPane.add(IDtext);
	        IDtext.setColumns(8);

	     
	        passwdtext = new JTextField();
	        passwdtext.setBounds(271, 225, 92, 21);
	        contentPane.add(passwdtext);
	        passwdtext.setColumns(10);


	        JButton register_button = new JButton("Sign Up"); 
	        
	       register_button.addMouseListener(new MouseAdapter(){
	    	   
	    	   @Override
	    	   public void mouseClicked(MouseEvent e){
	    		   
	    	   }
	       });
	       
	       register_button.setBounds(321, 305, 93, 23);
	       contentPane.add(register_button);

	       JButton back_button = new JButton("BACK");
	       
	       back_button.addMouseListener(new MouseAdapter(){
	    	   @Override
	    	   
	    	   public void mouseClicked(MouseEvent e){
	    		   
	    		   IndexGUI.init();// go back to index page
	    		   
	    		   setVisible(false);
	    	   }
	       });
	       
	       
	       back_button.setBounds(531, 305, 93, 23);
	       contentPane.add(back_button);

	       JLabel label = new JLabel("Welcome to use Notebook"); 
	       label.setFont(new Font("Ubuntu", Font.BOLD | Font.ITALIC, 30));
	       label.setBounds(143, 26, 374, 35);
	       contentPane.add(label);

	       JLabel lblNewLabel = new JLabel("(ID length should be 1 to 8 digits)");
	       lblNewLabel.setBounds(373, 164, 163, 15);
	       contentPane.add(lblNewLabel);

	       JLabel lblNewLabel_1 = new JLabel("(password length should be 1 to 6 digits)");
	       lblNewLabel_1.setBounds(373, 228, 163, 15);
	       contentPane.add(lblNewLabel_1);
	 }
	 
	 
	 
	 
	 
	 
	 /**
	  * Launch the registration page.
	  */
	 
	 public void registerGUI(){
		 
		 EventQueue.invokeLater(new Runnable(){
			 
			 public void run(){
				 
				 try{
					 
					 RegisterGUI frame = new RegisterGUI();
					 
					 frame.setVisible(true);
					 
				 }catch(Exception e){
					 
					 e.printStackTrace();
				 }
				 
			 }
		 });
		 
	 }
	 
}
