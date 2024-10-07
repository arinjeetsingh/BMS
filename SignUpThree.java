package BankSystem;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.UIManager;

import java.awt.Cursor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;
import java.awt.event.ActionEvent;

public class SignUpThree extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String account;
	static SignUpThree frame = new SignUpThree("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// SignUpThree frame = new SignUpThree("");
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
	public SignUpThree(String formNo) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 0, 760, 736);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(152, 213, 241));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPage = new JLabel("PAGE 3 : Account Details");
		lblPage.setForeground(Color.RED);
		lblPage.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 26));
		lblPage.setBounds(228, 10, 407, 81);
		contentPane.add(lblPage);
		
		JLabel lblNewLabel_2 = new JLabel("Account Type:");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_2.setBounds(103, 101, 357, 47);
		contentPane.add(lblNewLabel_2);
		
		JRadioButton tsavings = new JRadioButton("Saving");
		tsavings.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tsavings.setBackground(new Color(152, 213, 241));
		tsavings.setFont(new Font("Verdana", Font.PLAIN, 18));
		tsavings.setBounds(103, 160, 103, 21);
		contentPane.add(tsavings);
		
		JRadioButton tCurrent = new JRadioButton("Current");
		tCurrent.setFont(new Font("Verdana", Font.PLAIN, 18));
		tCurrent.setBackground(new Color(152, 213, 241));
		tCurrent.setBounds(103, 211, 103, 21);
		contentPane.add(tCurrent);
		
		JRadioButton tfixeddeposit = new JRadioButton("Fixed Deposit");
		tfixeddeposit.setFont(new Font("Verdana", Font.PLAIN, 18));
		tfixeddeposit.setBackground(new Color(152, 213, 241));
		tfixeddeposit.setBounds(293, 160, 154, 21);
		contentPane.add(tfixeddeposit);
		
		JRadioButton trecurringdeposit = new JRadioButton("Recurring Deposit");
		trecurringdeposit.setFont(new Font("Verdana", Font.PLAIN, 18));
		trecurringdeposit.setBackground(new Color(152, 213, 241));
		trecurringdeposit.setBounds(293, 211, 233, 21);
		contentPane.add(trecurringdeposit);
		
		ButtonGroup bg= new ButtonGroup();
		bg.add(trecurringdeposit);
		bg.add(tfixeddeposit);
		bg.add(tCurrent);
		bg.add(tsavings);
		
		JLabel lblNewLabel_2_1 = new JLabel("Services Required:");
		lblNewLabel_2_1.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(103, 258, 357, 47);
		contentPane.add(lblNewLabel_2_1);
		
		JCheckBox tib = new JCheckBox("Internet  Banking");
		tib.setFont(new Font("Verdana", Font.PLAIN, 18));
		tib.setBackground(new Color(152, 213, 241));
		tib.setBounds(103, 323, 223, 21);
		contentPane.add(tib);
		
		JCheckBox tatm = new JCheckBox("ATM Card");
		tatm.setFont(new Font("Verdana", Font.PLAIN, 18));
		tatm.setBackground(new Color(152, 213, 241));
		tatm.setBounds(378, 323, 189, 21);
		contentPane.add(tatm);
		
		JCheckBox tmb = new JCheckBox("Mobile Banking:");
		tmb.setFont(new Font("Verdana", Font.PLAIN, 18));
		tmb.setBackground(new Color(152, 213, 241));
		tmb.setBounds(103, 378, 189, 21);
		contentPane.add(tmb);
		
		JCheckBox talert = new JCheckBox("Email and SMS alerts");
		talert.setFont(new Font("Verdana", Font.PLAIN, 18));
		talert.setBackground(new Color(152, 213, 241));
		talert.setBounds(378, 378, 223, 21);
		contentPane.add(talert);
		
		JCheckBox tcheque = new JCheckBox("Cheque book");
		tcheque.setFont(new Font("Verdana", Font.PLAIN, 18));
		tcheque.setBackground(new Color(152, 213, 241));
		tcheque.setBounds(103, 433, 189, 21);
		contentPane.add(tcheque);
		
		JCheckBox tstatement = new JCheckBox("E-Statement");
		tstatement.setFont(new Font("Verdana", Font.PLAIN, 18));
		tstatement.setBackground(new Color(152, 213, 241));
		tstatement.setBounds(378, 433, 189, 21);
		contentPane.add(tstatement);
		
		JCheckBox finalcheck = new JCheckBox("I hereby acknoledge that all the details entered by me are corect and to best of my knowledge.");
		finalcheck.setBackground(new Color(152, 213, 241));
		finalcheck.setFont(new Font("Verdana", Font.PLAIN, 12));
		finalcheck.setBounds(49, 544, 655, 21);
		contentPane.add(finalcheck);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String check;
				
				if(finalcheck.isSelected())
				{
					check="yes";
				}
				else
				{
					check="no";
				}
				
				if(tCurrent.isSelected())
				{
					account="Current";
				}
				else if(tsavings.isSelected())
				{
					account="Savings";
				}
				else if(trecurringdeposit.isSelected())
				{
					account="Recurring Deposit";
				}
				else if(tfixeddeposit.isSelected())
				{
					account="Fixed Deposit";
				}
				else
				{
					account="";
				}	
				
				Random ran=new Random();
				String cardNo= ""+ Math.abs((ran.nextLong() % 90000000L)+ 5040936000000000L);
				String pin="" + Math.abs((ran.nextLong()%+9000L)+ 1000L);
				
				String facilities="";
				
				if(tatm.isSelected())
				{
					facilities=facilities+" "+"atm";
				}
				if(tib.isSelected())
				{
					facilities=facilities+" "+"InternetBanking";
				}
				if(tmb.isSelected())
				{
					facilities=facilities+" "+"MobileBanking";
				}
				
				if(talert.isSelected())
				{
					facilities=facilities+" "+"Alerts";
				}
				if(tcheque.isSelected())
				{
					facilities=facilities+" "+"Chequebook";
				}
				if(tstatement.isSelected())
				{
					facilities=facilities+" "+"E-Statement";
				}
				
		try
		{
		  if(facilities.equals("")|| account.equals(""))	
		  {
			     UIManager.put("OptionPane.background", Color.white);
		         UIManager.put("Panel.background", Color.white);
		         UIManager.put("OptionPane.messageForeground", Color.BLACK);
		         UIManager.put("Button.background",Color.black);
		         UIManager.put("Button.foreground",  Color.WHITE);
		         UIManager.put("Button.focus", new Color(60, 63, 65));
	        	 JOptionPane.showMessageDialog(null, "All the fields must be filled");
		  }
		  else if(check.equals("no"))
		  {
			     UIManager.put("OptionPane.background", Color.white);
		         UIManager.put("Panel.background", Color.white);
		         UIManager.put("OptionPane.messageForeground", Color.BLACK);
		         UIManager.put("Button.background",Color.black);
		         UIManager.put("Button.foreground",  Color.WHITE);
		         UIManager.put("Button.focus", new Color(60, 63, 65));
	        	 JOptionPane.showMessageDialog(null, "Please click the checkbox that you accept the terms and conditions.");
		  }
		  else
		  {
			  
			        UIManager.put("OptionPane.background", Color.white);
			        UIManager.put("Panel.background", Color.white);
			        UIManager.put("OptionPane.messageForeground", Color.BLACK);
			        UIManager.put("Button.background",Color.black);
			        UIManager.put("Button.foreground",  Color.WHITE);
			        UIManager.put("Button.focus", new Color(60, 63, 65));

				    int response= JOptionPane.showConfirmDialog(null, "Are you sure you have entered correct details and wish to generate the card number and pin?");
				       
				    if(response== JOptionPane.YES_OPTION)
   	        	     {	 
   	        	       String url="jdbc:mysql://localhost:3306/bms";
					   String uname="root";
					   String spwd="arinjeet12345@";
					   String sql="INSERT INTO p3 values(?,?,?,?,?)";
					   String sql2="INSERT INTO login values(?,?,?)";
					   
					   Connection con = null;

					   con= DriverManager.getConnection(url,uname,spwd);
					   PreparedStatement pst= con.prepareStatement(sql);
					   pst.setString(1, formNo);
					   pst.setString(2, account);
					   pst.setString(3, cardNo);
					   pst.setString(4, pin);
					   pst.setString(5, facilities);
				     
					   PreparedStatement pst2= con.prepareStatement(sql2); 
					   pst2.setString(1,formNo);
					   pst2.setString(2,cardNo);
					   pst2.setString(3,pin);
					   
					   int result= pst.executeUpdate();
					   int result2=pst2.executeUpdate();
					   
					   if(result>0)
						   {

					        if (result > 0) {
					            // Ensure the image path is correct
					            String imagePath = "E:\\Arin\\C\\Users\\arinj\\eclipse-workspace\\BankManagementSystem\\src\\BankSystem\\icons\\DEBIT.png";
					            ImageIcon imageIcon = new ImageIcon(imagePath);

					             UIManager.put("OptionPane.background", Color.white);
					                UIManager.put("Panel.background", Color.white);
					                UIManager.put("OptionPane.messageForeground", Color.BLACK);
					                UIManager.put("Button.background", Color.black);
					                UIManager.put("Button.foreground", Color.WHITE);
					                UIManager.put("Button.focus", new Color(60, 63, 65));
					                Image originalImage = imageIcon.getImage();
					                Image resizedImage = originalImage.getScaledInstance(600, 314, Image.SCALE_SMOOTH);
					                ImageIcon resizedIcon = new ImageIcon(resizedImage);
					                
					                Object[] message = { resizedIcon, "<html><body style='font-size:14px;'><b>Please note your card number and pin for future login.</b>" +
					                                     "<br>Your Card Number is " + cardNo + "<br>and your pin is " + pin + "</body></html>"
					                                    };

					                JOptionPane.showMessageDialog(null, message, "Card Details", JOptionPane.INFORMATION_MESSAGE);

					                frame.setVisible(false);
					                Login obj2 = new Login();
					                obj2.setVisible(true);
					        }
						         
						             
						             
								   
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
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
				
				
				
				
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnNewButton.setBounds(172, 619, 120, 31);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Verdana", Font.PLAIN, 17));
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setBounds(410, 619, 116, 31);
		contentPane.add(btnCancel);
		
	}
}
