
package BankSystem;

import java.util.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSlider;

import javax.swing.JRadioButton;
import java.awt.Cursor;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;



public class SignUpOne extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Random ran;
	private JTextField tname;
	private JTextField tfathername;
	private JTextField temail;
	private JTextField tdob;
	private JTextField tcity;
	private JTextField tpincode;
	private static JFrame frame= new SignUpOne();
	long random;       
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignUpOne() {
	
		ran = new Random();
		random = Math.abs((ran.nextLong()% 9000L) + 1000);
	    		
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 0, 770, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(152, 213, 241));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Application Form No."+" "+ random);
		lblNewLabel_1.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 30));
		lblNewLabel_1.setBounds(180, 10, 451, 66);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Page: 1 -  Personal Details");
		lblNewLabel_1_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 24));
		lblNewLabel_1_1.setBounds(220, 60, 352, 60);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2.setBounds(142, 126, 78, 47);
		contentPane.add(lblNewLabel_2);
		
		tname = new JTextField();
		tname.setBackground(new Color(255, 255, 255));
		tname.setFont(new Font("Verdana", Font.PLAIN, 15));
		tname.setBounds(366, 130, 291, 30);
		contentPane.add(tname);
		tname.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Father's Name:");
		lblNewLabel_2_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(142, 174, 182, 47);
		contentPane.add(lblNewLabel_2_1);
		
		tfathername = new JTextField();
		tfathername.setFont(new Font("Verdana", Font.PLAIN, 15));
		tfathername.setColumns(10);
		tfathername.setBounds(366, 182, 291, 30);
		contentPane.add(tfathername);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Date of Birth:");
		lblNewLabel_2_1_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2_1_1.setBounds(142, 226, 182, 47);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Gender:");
		lblNewLabel_2_1_1_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2_1_1_1.setBounds(142, 273, 182, 47);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JRadioButton tmale = new JRadioButton("Male");
		tmale.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tmale.setFont(new Font("Verdana", Font.BOLD, 15));
		tmale.setBackground(new Color(152, 213, 241));
		tmale.setBounds(366, 286, 130, 21);
		contentPane.add(tmale);
		
		JRadioButton tfemale = new JRadioButton("Female");
		tfemale.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tfemale.setBackground(new Color(152, 213, 241));
		tfemale.setFont(new Font("Verdana", Font.BOLD, 15));
		tfemale.setBounds(531, 286, 103, 21);
		contentPane.add(tfemale);
		
		ButtonGroup btgrp =new ButtonGroup();
		btgrp.add(tmale);
		btgrp.add(tfemale);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Email:");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2_1_1_1_1.setBounds(142, 322, 182, 47);
		contentPane.add(lblNewLabel_2_1_1_1_1);
		
		temail = new JTextField();
		temail.setFont(new Font("Verdana", Font.PLAIN, 15));
		temail.setColumns(10);
		temail.setBounds(366, 341, 291, 30);
		contentPane.add(temail);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Address:");
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2_1_1_1_1_1.setBounds(142, 379, 182, 47);
		contentPane.add(lblNewLabel_2_1_1_1_1_1);
		
		tdob = new JTextField();
		
		tdob.setFont(new Font("Verdana", Font.PLAIN, 15));
		
		tdob.setBounds(366, 236, 291, 30);
		contentPane.add(tdob);
		
		JTextPane taddress = new JTextPane();
		taddress.setBackground(new Color(255, 255, 255));
		taddress.setFont(new Font("Verdana", Font.PLAIN, 15));
		taddress.setBounds(366, 392, 291, 93);
		contentPane.add(taddress);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("City:");
		lblNewLabel_2_1_1_1_1_1_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2_1_1_1_1_1_1.setBounds(142, 507, 182, 47);
		contentPane.add(lblNewLabel_2_1_1_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_2 = new JLabel("State:");
		lblNewLabel_2_1_1_1_1_1_2.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2_1_1_1_1_1_2.setBounds(142, 560, 182, 47);
		contentPane.add(lblNewLabel_2_1_1_1_1_1_2);
		
		tcity = new JTextField();
		tcity.setFont(new Font("Verdana", Font.PLAIN, 15));
		tcity.setColumns(10);
		tcity.setBounds(366, 515, 291, 30);
		contentPane.add(tcity);
		
		JLabel lblNewLabel_2_1_1_1_1_1_2_1 = new JLabel("Pincode:");
		lblNewLabel_2_1_1_1_1_1_2_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2_1_1_1_1_1_2_1.setBounds(142, 614, 182, 47);
		contentPane.add(lblNewLabel_2_1_1_1_1_1_2_1);
		
		tpincode = new JTextField();
		tpincode.setFont(new Font("Verdana", Font.PLAIN, 15));
		tpincode.setColumns(10);
		tpincode.setBounds(366, 622, 291, 30);
		contentPane.add(tpincode);
		
		JComboBox tstate = new JComboBox();
		tstate.setFont(new Font("Verdana", Font.PLAIN, 15));
		tstate.setModel(new DefaultComboBoxModel(new String[] {"Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jharkhand", "Karnataka", "Kerala", "Maharashtra", "Madhya Pradesh", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Tripura", "Telangana", "Uttar Pradesh", "Uttarakhand", "West Bengal", "Andaman & Nicobar (UT)", "Chandigarh (UT)", "Dadra & Nagar Haveli and Daman & Diu (UT)", "Delhi [National Capital Territory (NCT)]", "Jammu & Kashmir (UT)", "Ladakh (UT)", "Lakshadweep (UT)", "Puducherry (UT)"}));
		tstate.setBounds(366, 575, 291, 21);
		contentPane.add(tstate);
		
		JButton next = new JButton("Next");
		
		next.setForeground(new Color(255, 255, 255));
		next.setBackground(new Color(0, 0, 0));
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String formNo= String.valueOf(random);
				String name= tname.getText();
				String fname= tfathername.getText();
				String dob= tdob.getText();
				String gender=null;
				 if(tmale.isSelected())
				 {
					 gender= "Male";
				 }
				 else if(tfemale.isSelected())
				 {
					 gender= "Female";
				 }
				
				String email= temail.getText();
				String address = taddress.getText();
				String city = tcity.getText();
				String state = (String) tstate.getSelectedItem();
				String pincode= tpincode.getText();
				
				try {
					if(name.equals("")||fname.equals("")||dob.equals("")||gender.equals("")||email.equals("")||address.equals("")||state.equals("")||pincode.equals("")||city.equals(""))
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
					
		            if (response== JOptionPane.YES_OPTION) 
		            {
					   String url="jdbc:mysql://localhost:3306/bms";
					   String uname="root";
					   String spwd="arinjeet12345@";
					   String sql="INSERT INTO p1 values(?,?,?,?,?,?,?,?,?,?)";
					   Connection con = null;
					   con= DriverManager.getConnection(url,uname,spwd);
					   PreparedStatement pst= con.prepareStatement(sql); 
					   pst.setString(1,formNo);
					   pst.setString(2,name);
					   pst.setString(3,fname);
					   pst.setString(4,dob);
					   pst.setString(5,gender);
					   pst.setString(6,email);
					   pst.setString(7,address);
					   pst.setString(8,city);
					   pst.setString(9,state);
					   pst.setString(10,pincode);
					   
					 
					   
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
						  SignUpTwo obj=new SignUpTwo(formNo);
						  obj.setVisible(true);
					   }
					   
					   else
					   {
						    UIManager.put("OptionPane.background", Color.white);
					        UIManager.put("Panel.background", Color.white);
					        UIManager.put("OptionPane.messageForeground", Color.BLACK);
					        UIManager.put("Button.background",Color.black);
					        UIManager.put("Button.foreground",  Color.WHITE);
					        UIManager.put("Button.focus", new Color(60, 63, 65));
					        
						   JOptionPane.showMessageDialog(null, "There was a problem in adding the details", "Information", JOptionPane.INFORMATION_MESSAGE);
						   
					   }
		            }
					   else if(response== JOptionPane.NO_OPTION)
					   {
						   //
					   }

				    }
			     
					
				}
				catch(Exception ae)
				{
					System.out.println(ae);
				}
			}
		});
		
		
		next.setFont(new Font("Verdana", Font.BOLD, 15));
		next.setBounds(315, 712, 93, 30);
		contentPane.add(next);
		
		
		
	}
}
