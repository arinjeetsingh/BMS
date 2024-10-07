package BankSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.Cursor;
import javax.swing.border.BevelBorder;
import javax.swing.DebugGraphics;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class SignUpTwo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tidNo;
	String formNo;
	static SignUpTwo frame=new SignUpTwo("");
	 String senior;
     String account;
     
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// SignUpTwo frame = new SignUpTwo("", null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param formNo 
	 * @param formNo 
	 */
	public SignUpTwo(String formNo)
	    {
		this.formNo = formNo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 0, 700, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(152, 213, 241));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PAGE 2 : Additional Details");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 26));
		lblNewLabel.setBounds(196, 0, 407, 81);
		contentPane.add(lblNewLabel);
		
		
		JLabel lblNewLabel_2 = new JLabel("Religeon:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2.setBounds(142, 88, 112, 47);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Income:");
		lblNewLabel_2_1_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2_1_1.setBounds(140, 140, 182, 47);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Education");
		lblNewLabel_2_1_1_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2_1_1_1.setBounds(140, 197, 182, 47);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Occupation:");
		lblNewLabel_2_2.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(142, 270, 123, 47);
		contentPane.add(lblNewLabel_2_2);
		
		tidNo = new JTextField();
		tidNo.setFont(new Font("Verdana", Font.PLAIN, 15));
		tidNo.setColumns(10);
		tidNo.setBounds(336, 377, 291, 30);
		contentPane.add(tidNo);
		
		JLabel txt2 = new JLabel("Enter ID Number:");
		txt2.setFont(new Font("Verdana", Font.BOLD, 15));
		txt2.setBounds(140, 369, 160, 47);
		contentPane.add(txt2);
		
		JLabel lblNewLabel_2_4 = new JLabel("Senior Citizen:");
		lblNewLabel_2_4.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2_4.setBounds(140, 428, 160, 47);
		contentPane.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("Do you have an existing bank account?");
		lblNewLabel_2_4_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2_4_1.setBounds(140, 490, 418, 47);
		contentPane.add(lblNewLabel_2_4_1);
		
		JComboBox treligeon = new JComboBox();
		treligeon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		treligeon.setBackground(new Color(218, 218, 237));
		treligeon.setModel(new DefaultComboBoxModel(new String[] {"Hinduism", "Buddhism", "Islam", "Christianity", "Folk"}));
		treligeon.setFont(new Font("Verdana", Font.PLAIN, 15));
		treligeon.setBounds(338, 103, 291, 21);
		contentPane.add(treligeon);
		
		JComboBox tincome = new JComboBox();
		tincome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tincome.setModel(new DefaultComboBoxModel(new String[] {"<50,000", "50,000 - 1 lakh", "1 lakh - 5 lakh", "5 lakh - 10 lakh", "10 lakh - 50 lakh", "50 lakh - 1 crore", ">1 crore"}));
		tincome.setFont(new Font("Verdana", Font.PLAIN, 15));
		tincome.setBounds(336, 155, 291, 21);
		contentPane.add(tincome);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Qualification:");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2_1_1_1_1.setBounds(142, 226, 182, 47);
		contentPane.add(lblNewLabel_2_1_1_1_1);
		
		JComboBox tqualification = new JComboBox();
		tqualification.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tqualification.setFont(new Font("Verdana", Font.PLAIN, 15));
		tqualification.setModel(new DefaultComboBoxModel(new String[] {"Non-Graduate", "Graduate", "Post-Graduate", "Docterate", "Others"}));
		tqualification.setBounds(336, 223, 291, 21);
		contentPane.add(tqualification);
		
		JComboBox toccupation = new JComboBox();
		toccupation.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		toccupation.setModel(new DefaultComboBoxModel(new String[] {"Salaried", "Self-employed", "Business", "Student"}));
		toccupation.setFont(new Font("Verdana", Font.PLAIN, 15));
		toccupation.setBounds(336, 282, 291, 21);
		contentPane.add(toccupation);
		
		JRadioButton senioryes = new JRadioButton("Yes");
		senioryes.setBackground(new Color(152, 213, 241));
		senioryes.setFont(new Font("Verdana", Font.PLAIN, 15));
		senioryes.setBounds(344, 441, 103, 21);
		contentPane.add(senioryes);
		
		JRadioButton seniorno = new JRadioButton("No");
		seniorno.setFont(new Font("Verdana", Font.PLAIN, 15));
		seniorno.setBackground(new Color(152, 213, 241));
		seniorno.setBounds(466, 441, 103, 21);
		contentPane.add(seniorno);
		
		ButtonGroup btgrp1= new ButtonGroup();
		btgrp1.add(seniorno);
        btgrp1.add(senioryes);
        
        
		JRadioButton accountyes = new JRadioButton("Yes");
		accountyes.setFont(new Font("Verdana", Font.PLAIN, 15));
		accountyes.setBackground(new Color(152, 213, 241));
		accountyes.setBounds(142, 543, 103, 21);
		contentPane.add(accountyes);
		
		JRadioButton accountno = new JRadioButton("No");
		accountno.setFont(new Font("Verdana", Font.PLAIN, 15));
		accountno.setBackground(new Color(152, 213, 241));
		accountno.setBounds(264, 543, 103, 21);
		contentPane.add(accountno);
		
		ButtonGroup btgrp2= new ButtonGroup();
		btgrp2.add(accountyes);
        btgrp2.add(accountno);
        
        JLabel txt = new JLabel("Select ID:");
        txt.setFont(new Font("Verdana", Font.BOLD, 15));
        txt.setBounds(142, 327, 160, 47);
        contentPane.add(txt);
        
        JComboBox tid = new JComboBox();
        tid.setModel(new DefaultComboBoxModel(new String[] {"Adhaar Card", "PAN Card", "Driving License"}));
        tid.setFont(new Font("Verdana", Font.PLAIN, 15));
        tid.setBounds(336, 331, 291, 21);
        contentPane.add(tid);
        
       
       
        
        
        
        senior= null;
        account=null;
        
       
        
        JButton btnNewButton = new JButton("Next");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(0, 0, 0));
        btnNewButton.setFont(new Font("Verdana", Font.BOLD, 17));
        btnNewButton.setBounds(264, 604, 103, 30);
        contentPane.add(btnNewButton);
        
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 try 
        	        {
        			    String religeon= (String) treligeon.getSelectedItem();
        		        String occupation= (String) toccupation.getSelectedItem();
        		        String income= (String) tincome.getSelectedItem();
        		        String id= (String) tid.getSelectedItem();
        		        String idNo= tidNo.getText();
        		        String education= (String) tqualification.getSelectedItem();
        			  if(senioryes.isSelected())
			            {
			             	senior="yes";
			        	}
			            else if(seniorno.isSelected())
			            {
			        	senior="no";  			        	
			            }
			            else
			            {
			            	senior=""; 
			            }
			            if(accountyes.isSelected())
			           {
			        	account="yes";
			           }
			           else if(accountno.isSelected())
			           {
			        	account="no";
			           }
			           else
			            {
			            	account=""; 
			            }
			            
			            
        	           if(religeon.equals("")||occupation.equals("")||income.equals("")||id.equals("")||idNo.equals("")||education.equals("")||senior.equals("")||account.equals(""))
        	           {
        	        	 UIManager.put("OptionPane.background", Color.white);
   				         UIManager.put("Panel.background", Color.white);
   				         UIManager.put("OptionPane.messageForeground", Color.BLACK);
   				         UIManager.put("Button.background",Color.black);
   				         UIManager.put("Button.foreground",  Color.WHITE);
   				         UIManager.put("Button.focus", new Color(60, 63, 65));
        	        	 JOptionPane.showMessageDialog(null, "All the fields must be filled");   
        	           }
        	           else
        	           {
        	            UIManager.put("OptionPane.background", Color.white);
   				        UIManager.put("Panel.background", Color.white);
   				        UIManager.put("OptionPane.messageForeground", Color.BLACK);
   				        UIManager.put("Button.background",Color.black);
   				        UIManager.put("Button.foreground",  Color.WHITE);
   				        UIManager.put("Button.focus", new Color(60, 63, 65));

   					    int response= JOptionPane.showConfirmDialog(null, "Are you sure you have entered correct details and wish to proceed to next page?");
   					
        	           
   					   
   			        if(response== JOptionPane.YES_OPTION)
        	        	 {	 
        	        	   String url="jdbc:mysql://localhost:3306/bms";
    					   String uname="root";
    					   String spwd="arinjeet12345@";
    					   String sql="INSERT INTO p2 values(?,?,?,?,?,?,?,?,?)";
    					   Connection con = null;

    					   con= DriverManager.getConnection(url,uname,spwd);
    					   PreparedStatement pst= con.prepareStatement(sql); 
    					   pst.setString(1,formNo);
    					   pst.setString(2,religeon);
    					   pst.setString(3,income);
    					   pst.setString(4,education);
    					   pst.setString(5,occupation);
    					   pst.setString(6,id);
    					   pst.setString(7,idNo);
    					   pst.setString(8,senior);
    					   pst.setString(9,account);
    					   
    					   int result= pst.executeUpdate();
    					   if(result>0)
    						   {
    						     UIManager.put("OptionPane.background", Color.white);
   					             UIManager.put("Panel.background", Color.white);
   					             UIManager.put("OptionPane.messageForeground", Color.BLACK);
   					             UIManager.put("Button.background",Color.black);
   					             UIManager.put("Button.foreground",  Color.WHITE);
   					             UIManager.put("Button.focus", new Color(60, 63, 65));
   					        
   						         JOptionPane.showMessageDialog(null, "Details Saved Successfully!");
   						         frame.setVisible(false);
   						         SignUpThree obj= new SignUpThree(formNo);
   						         obj.setVisible(true);
    								   
    							 }
    							   else if(response== JOptionPane.NO_OPTION)
    							   {
    								   //
    							   }
    						   
    						   else
    						   {
    							   JOptionPane.showMessageDialog(null, "There was a problem in adding the details", "Information", JOptionPane.INFORMATION_MESSAGE);
    							   
    						   }

    					    }
        	           }
        	        	
        	        }
        	        	
        	        
        	        catch(Exception ec)
        	        {
        	        	System.out.print(ec.getMessage());
        	        }
        	}
        });
	}
}
