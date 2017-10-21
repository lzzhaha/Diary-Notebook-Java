package view;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import util.Diary;
public class UserGUI extends JFrame{
	private JPanel contentPane;
	private JTextField textField;
	
	private JFileChooser chooser;
	
	private static  String pathname;
	
	public UserGUI(){
	
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 600, 400);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	        tabbedPane.setToolTipText("Notebook");
	        tabbedPane.setBounds(0, 0, 574, 67);
	        contentPane.add(tabbedPane);
	        
	        final JPanel panel = new JPanel();
	        tabbedPane.addTab("Diary Management", null, panel, null);
	        
	        chooser = new JFileChooser(".\\"+pathname);//Initialize JFileChooser?set user directory as default

	        FileNameExtensionFilter filter=new FileNameExtensionFilter("Allowed","ky");// Only ".ky" file is allowed

	        chooser.setFileFilter(filter);

	        JButton readButton = new JButton("Read the diary");

	        readButton.addMouseListener(new MouseAdapter() {
	            @Override
	  
	            public void mouseClicked(MouseEvent e) {

	                int value = chooser.showOpenDialog(panel);

	               JInternalFrame internalFrame_Read = new JInternalFrame("Read the diary", false, true, false, false);
	                internalFrame_Read.setBounds(0, 77, 584, 275);
	                contentPane.add(internalFrame_Read);
	                internalFrame_Read.getContentPane().setLayout(null);
	                JTextPane txtDiary = new JTextPane();
	                txtDiary.setBounds(0, 0, 568, 246);
	                internalFrame_Read.getContentPane().add(txtDiary);

	    
	                javax.swing.text.Document doc=txtDiary.getDocument();
	                txtDiary.setBackground(Color.GREEN);
	                txtDiary.setEditable(false);

	                
	                if (value == JFileChooser.APPROVE_OPTION) {//the user has chosen a file

	                 
	                    File file = chooser.getSelectedFile();

	                    
	                    if(file.exists()) {    

	                        internalFrame_Read.setVisible(true);
	                    }
	                }
	            }
	        });

	        panel.add(readButton);

	        JButton addButton = new JButton("Create a new diary");
	        addButton.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {

	           
	                final JInternalFrame internalFrame_Write = new JInternalFrame("Create a diary",false, true, false, false);


	                internalFrame_Write.setBounds(0, 77, 584, 275);   
	                contentPane.add(internalFrame_Write);
	                internalFrame_Write.getContentPane().setLayout(null);

	                textField = new JTextField();
	                textField.setBounds(76, 0, 492, 21);
	                internalFrame_Write.getContentPane().add(textField);
	                textField.setColumns(10);

	                JLabel label = new JLabel("Title");

	             
	                 label.setBounds(46, 3, 52, 15);
	                 internalFrame_Write.getContentPane().add(label);

	                
	                final JEditorPane editorPane = new JEditorPane();
	                editorPane.setBounds(0, 31, 568, 179);
	                internalFrame_Write.getContentPane().add(editorPane);

	                JButton save = new JButton("SAVE");//????
	                save.setBounds(465, 213, 93, 23);
	                save.addMouseListener(new MouseAdapter() {
	                    public void mouseClicked(MouseEvent e) {
	                       
	                        String title = textField.getText();    
	                        
	                        String txt = editorPane.getText();
	                  

	                        internalFrame_Write.setVisible(false);
	                    }
	                });
	                internalFrame_Write.getContentPane().add(save);
	                internalFrame_Write.setVisible(true);
	            }  
	        });

	        panel.add(addButton);

	        JButton delButton = new JButton("Delete");
	        
	        delButton.addActionListener(new ActionListener() {
	            
	             public void actionPerformed(ActionEvent e) {
	                File file=null;
	                int value=chooser.showOpenDialog(panel);
	                if(value==JFileChooser.APPROVE_OPTION){
	             
	                    file=chooser.getSelectedFile();

	                  
	                    int x= JOptionPane.showConfirmDialog(panel,"Confirm delete?","Please confirm",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);

	                    if(file.exists())
	                    {
	                        
	                        if(x==JOptionPane.OK_OPTION) {
	                            file.delete();

	                   
	                            JOptionPane.showMessageDialog(panel, "Delete Success!","information", JOptionPane.PLAIN_MESSAGE);
	                        }
	                    }

	                }

	            }
	        });

	        panel.add(delButton);

	        JButton back_button = new JButton("BACK");
	        back_button.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                IndexGUI.init();
	                setVisible(false);
	            }
	        });

	        panel.add(back_button);
	    }
}
	

