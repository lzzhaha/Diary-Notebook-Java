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

import util.Register;

public class RegisterGUI extends JFrame{
	 private JPanel contentPane;
	 private JTextField nametext;  
	 private JTextField IDtext;  
	 private JTextField passwdtext;  

	 
	 public RegisterGUI(){
		 
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  setBounds(100, 100, 3000, 1000);
		  contentPane = new JPanel();
		  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		  setContentPane(contentPane);
		  contentPane.setLayout(null);
	
		  JLabel namelabel = new JLabel("Please enter your name"); 
		  
		  namelabel.setBounds(102, 91, 250, 23);
		  contentPane.add(namelabel);
		  
	        JLabel IDlabel = new JLabel("Please enter your ID");
	        IDlabel.setBounds(102, 160, 250, 23);
	        contentPane.add(IDlabel);


	        JLabel passwdlaber = new JLabel("Please enter password");
	        passwdlaber.setBounds(102, 224, 250, 23);
	        contentPane.add(passwdlaber);

	        nametext = new JTextField();  
	        nametext.setBounds(300, 92, 92, 21); 
	        contentPane.add(nametext);
	        nametext.setColumns(10);  

	       
	        IDtext = new JTextField();
	        IDtext.setBounds(300, 161, 92, 21);
	        contentPane.add(IDtext);
	        IDtext.setColumns(8);

	     
	        passwdtext = new JTextField();
	        passwdtext.setBounds(300, 225, 92, 21);
	        contentPane.add(passwdtext);
	        passwdtext.setColumns(10);


	        JButton register_button = new JButton("Sign Up"); 
	        
	       register_button.addMouseListener(new MouseAdapter(){
	    	   
	    	   @Override
	    	   public void mouseClicked(MouseEvent e){
	    		   String name = nametext.getText();
	    		   
	    		   String id = IDtext.getText();
	    		   
	    		   String password = passwdtext.getText();
	    		   
	    		   String id_check_msg;
	    		   
	    		   String password_check_msg;
	    		   
	    		   if((id_check_msg = Register.setID(id)) == null){//id format OK
	    			   
	    			   if((password_check_msg = Register.setPassword(password))==null)
	    			   {//password format OK
	    				   
	    				   String notice = Register.register(name, password, id);
	    				   
	    				   JOptionPane.showMessageDialog(contentPane,notice,"information",
	    						   JOptionPane.PLAIN_MESSAGE);
	    				   
	    				   
	    				   setVisible(false);
	    				   
	    				   new IndexGUI().init(); // go back to index page
	    			   }else{
	    				   
	    				   JOptionPane.showMessageDialog(contentPane,password_check_msg, 
	    						   "ERROR", JOptionPane.ERROR_MESSAGE);
	    			   }
	    			   
	    		   }else{
	    			   
	    			   JOptionPane.showMessageDialog(contentPane,id_check_msg, 
    						   "ERROR", JOptionPane.ERROR_MESSAGE);
	    		   }
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
	       lblNewLabel.setBounds(400, 164, 400, 15);
	       contentPane.add(lblNewLabel);

	       JLabel lblNewLabel_1 = new JLabel("(password length should be 6 to 15 digits)");
	       lblNewLabel_1.setBounds(400, 228, 400, 15);
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
