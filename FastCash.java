package BankSystem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class FastCash extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static FastCash frame = new FastCash("","","");
	/**
	 * Launch the application.
	 */
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
	public FastCash(String name, String pin, String FormNo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 0, 904, 845);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
        JLabel lblNewLabel_2 = new JLabel("Please select withdrawal amount:");
		
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(149, 220, 381, 49);
		contentPane.add(lblNewLabel_2);
		
		
		
		
		JButton thousand = new JButton("₹1000");
		thousand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String number= "1000";
				 Date currentDate = new Date();
				 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				 String date = dateFormat.format(currentDate);
				 
				 UIManager.put("OptionPane.background", Color.white);
		         UIManager.put("Panel.background", Color.white);
		         UIManager.put("OptionPane.messageForeground", Color.BLACK);
		         UIManager.put("Button.background",Color.black);
		         UIManager.put("Button.foreground",  Color.WHITE);
		         UIManager.put("Button.focus", new Color(60, 63, 65));
		         String input = JOptionPane.showInputDialog(null, "Enter the pin to withdraw money");
		         
		         if(input.equals(pin))
					{  try
					  {
					   String url="jdbc:mysql://localhost:3306/bms";
					   String uname="root";
					   String spwd="arinjeet12345@";
					   String sql="INSERT INTO bank values(?,?,?,?,?,?)";
					   Connection con = null;
					   con= DriverManager.getConnection(url,uname,spwd);
					   
					   
					   
					   String query="SELECT * FROM bank where pin=?";
					   PreparedStatement pst2= con.prepareStatement(query);
					   pst2.setString(1,pin);
					   ResultSet rs2= pst2.executeQuery();
					  
					   
					   int balance=0;
					   
					   while(rs2.next())
					   {
						   if(rs2.getString("type").equals("Deposit"))
						   {
							   balance+= Integer.parseInt(rs2.getString("amount"));
						   }
						   if(rs2.getString("type").equals("withdrawal"))
						   {
							   balance = balance-Integer.parseInt(rs2.getString("amount"));
						   }
						   
					   }
					   if(balance<1000)
					   {
						     UIManager.put("OptionPane.background", Color.white);
					         UIManager.put("Panel.background", Color.white);
					         UIManager.put("OptionPane.messageForeground", Color.BLACK);
					         UIManager.put("Button.background",Color.black);
					         UIManager.put("Button.foreground",  Color.WHITE);
					         UIManager.put("Button.focus", new Color(60, 63, 65));
							 
					         JOptionPane.showMessageDialog(null, "Insufficient account balance", "ERROR", JOptionPane.ERROR_MESSAGE);
					   }
					   else
					   {
						   PreparedStatement pst= con.prepareStatement(sql);
						   pst.setString(1, pin);
						   pst.setString(2, date);
						   pst.setString(3,"withdrawal");
						   pst.setString(4, "1000");
						   pst.setString(5, name);
						   pst.setString(6, FormNo);
						   int rs= pst.executeUpdate();	
						   if(rs>0)
						   {   
							
							 JOptionPane.showMessageDialog(null, "₹1000 Withdrawal Successfull!");
							 
							 frame.setVisible(false);
							 ATM obj5= new ATM(name,pin,FormNo);
							 obj5.setVisible(true);
						   }
						   else
						   {
							   JOptionPane.showMessageDialog(null, "There was an error withdrawing the money from the account", "ERROR", JOptionPane.ERROR_MESSAGE);
						   }
					   }
					   
					  }
					catch(Exception ec2)
					{
						System.out.println(ec2.getMessage());
					}
			      }
			}
		});
		thousand.setForeground(Color.BLACK);
		thousand.setFont(new Font("Verdana", Font.PLAIN, 15));
		thousand.setBackground(Color.WHITE);
		thousand.setBounds(146, 324, 133, 29);
		contentPane.add(thousand);
		
		JButton withdrawal = new JButton("₹2000");
		withdrawal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				 String number= "2000";
				 Date currentDate = new Date();
				 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				 String date = dateFormat.format(currentDate);
				 
				 UIManager.put("OptionPane.background", Color.white);
		         UIManager.put("Panel.background", Color.white);
		         UIManager.put("OptionPane.messageForeground", Color.BLACK);
		         UIManager.put("Button.background",Color.black);
		         UIManager.put("Button.foreground",  Color.WHITE);
		         UIManager.put("Button.focus", new Color(60, 63, 65));
		         String input = JOptionPane.showInputDialog(null, "Enter the pin to withdraw money");
		         
		         if(input.equals(pin))
					{  try
					  {
					   String url="jdbc:mysql://localhost:3306/bms";
					   String uname="root";
					   String spwd="arinjeet12345@";
					   String sql="INSERT INTO bank values(?,?,?,?,?,?)";
					   Connection con = null;
					   con= DriverManager.getConnection(url,uname,spwd);
					   
					   
					   
					   String query="SELECT * FROM bank where pin=?";
					   PreparedStatement pst2= con.prepareStatement(query);
					   pst2.setString(1,pin);
					   ResultSet rs2= pst2.executeQuery();
					  
					   
					   int balance=0;
					   
					   while(rs2.next())
					   {
						   if(rs2.getString("type").equals("Deposit"))
						   {
							   balance+= Integer.parseInt(rs2.getString("amount"));
						   }
						   if(rs2.getString("type").equals("withdrawal"))
						   {
							   balance = balance-Integer.parseInt(rs2.getString("amount"));
						   }
						   
					   }
					   if(balance<1000)
					   {
						     UIManager.put("OptionPane.background", Color.white);
					         UIManager.put("Panel.background", Color.white);
					         UIManager.put("OptionPane.messageForeground", Color.BLACK);
					         UIManager.put("Button.background",Color.black);
					         UIManager.put("Button.foreground",  Color.WHITE);
					         UIManager.put("Button.focus", new Color(60, 63, 65));
							 
					         JOptionPane.showMessageDialog(null, "Insufficient account balance", "ERROR", JOptionPane.ERROR_MESSAGE);
					   }
					   else
					   {
						   PreparedStatement pst= con.prepareStatement(sql);
						   pst.setString(1, pin);
						   pst.setString(2, date);
						   pst.setString(3,"withdrawal");
						   pst.setString(4, "2000");
						   pst.setString(5, name);
						   pst.setString(6, FormNo);
						   int rs= pst.executeUpdate();	
						   if(rs>0)
						   {   
							
							 JOptionPane.showMessageDialog(null, "₹2000 Withdrawal Successfull!");
							 
							 frame.setVisible(false);
							 ATM obj5= new ATM(name,pin,FormNo);
							 obj5.setVisible(true);
						   }
						   else
						   {
							   JOptionPane.showMessageDialog(null, "There was an error withdrawing the money from the account", "ERROR", JOptionPane.ERROR_MESSAGE);
						   }
					   }
					   
					  }
					catch(Exception ec2)
					{
						System.out.println(ec2.getMessage());
					}
			      }
			}
				
				
			
		});
		withdrawal.setForeground(Color.BLACK);
		withdrawal.setFont(new Font("Verdana", Font.PLAIN, 15));
		withdrawal.setBackground(Color.WHITE);
		withdrawal.setBounds(377, 324, 133, 29);
		contentPane.add(withdrawal);
		
		JButton fastcash = new JButton("₹5000");
		fastcash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				 String number= "5000";
				 Date currentDate = new Date();
				 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				 String date = dateFormat.format(currentDate);
				 
				 UIManager.put("OptionPane.background", Color.white);
		         UIManager.put("Panel.background", Color.white);
		         UIManager.put("OptionPane.messageForeground", Color.BLACK);
		         UIManager.put("Button.background",Color.black);
		         UIManager.put("Button.foreground",  Color.WHITE);
		         UIManager.put("Button.focus", new Color(60, 63, 65));
		         String input = JOptionPane.showInputDialog(null, "Enter the pin to withdraw money");
		         
		         if(input.equals(pin))
					{  try
					  {
					   String url="jdbc:mysql://localhost:3306/bms";
					   String uname="root";
					   String spwd="arinjeet12345@";
					   String sql="INSERT INTO bank values(?,?,?,?,?,?)";
					   Connection con = null;
					   con= DriverManager.getConnection(url,uname,spwd);
					   
					   
					   
					   String query="SELECT * FROM bank where pin=?";
					   PreparedStatement pst2= con.prepareStatement(query);
					   pst2.setString(1,pin);
					   ResultSet rs2= pst2.executeQuery();
					  
					   
					   int balance=0;
					   
					   while(rs2.next())
					   {
						   if(rs2.getString("type").equals("Deposit"))
						   {
							   balance+= Integer.parseInt(rs2.getString("amount"));
						   }
						   if(rs2.getString("type").equals("withdrawal"))
						   {
							   balance = balance-Integer.parseInt(rs2.getString("amount"));
						   }
						   
					   }
					   if(balance<1000)
					   {
						     UIManager.put("OptionPane.background", Color.white);
					         UIManager.put("Panel.background", Color.white);
					         UIManager.put("OptionPane.messageForeground", Color.BLACK);
					         UIManager.put("Button.background",Color.black);
					         UIManager.put("Button.foreground",  Color.WHITE);
					         UIManager.put("Button.focus", new Color(60, 63, 65));
							 
					         JOptionPane.showMessageDialog(null, "Insufficient account balance", "ERROR", JOptionPane.ERROR_MESSAGE);
					   }
					   else
					   {
						   PreparedStatement pst= con.prepareStatement(sql);
						   pst.setString(1, pin);
						   pst.setString(2, date);
						   pst.setString(3,"withdrawal");
						   pst.setString(4, "5000");
						   pst.setString(5, name);
						   pst.setString(6, FormNo);
						   int rs= pst.executeUpdate();	
						   if(rs>0)
						   {   
							
							 JOptionPane.showMessageDialog(null, "₹5000 Withdrawal Successfull!");
							 
							 frame.setVisible(false);
							 ATM obj5= new ATM(name,pin,FormNo);
							 obj5.setVisible(true);
						   }
						   else
						   {
							   JOptionPane.showMessageDialog(null, "There was an error withdrawing the money from the account", "ERROR", JOptionPane.ERROR_MESSAGE);
						   }
					   }
					   
					  }
					catch(Exception ec2)
					{
						System.out.println(ec2.getMessage());
					}
			      }
			}
				
				
			
		});
		fastcash.setForeground(Color.BLACK);
		fastcash.setFont(new Font("Verdana", Font.PLAIN, 15));
		fastcash.setBackground(Color.WHITE);
		fastcash.setBounds(146, 365, 133, 29);
		contentPane.add(fastcash);
		
		JButton btnNewButton_2 = new JButton("₹10,000");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				 String number= "10,000";
				 Date currentDate = new Date();
				 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				 String date = dateFormat.format(currentDate);
				 
				 UIManager.put("OptionPane.background", Color.white);
		         UIManager.put("Panel.background", Color.white);
		         UIManager.put("OptionPane.messageForeground", Color.BLACK);
		         UIManager.put("Button.background",Color.black);
		         UIManager.put("Button.foreground",  Color.WHITE);
		         UIManager.put("Button.focus", new Color(60, 63, 65));
		         String input = JOptionPane.showInputDialog(null, "Enter the pin to withdraw money");
		         
		         if(input.equals(pin))
					{  try
					  {
					   String url="jdbc:mysql://localhost:3306/bms";
					   String uname="root";
					   String spwd="arinjeet12345@";
					   String sql="INSERT INTO bank values(?,?,?,?,?,?)";
					   Connection con = null;
					   con= DriverManager.getConnection(url,uname,spwd);
					   
					   
					   
					   String query="SELECT * FROM bank where pin=?";
					   PreparedStatement pst2= con.prepareStatement(query);
					   pst2.setString(1,pin);
					   ResultSet rs2= pst2.executeQuery();
					  
					   
					   int balance=0;
					   
					   while(rs2.next())
					   {
						   if(rs2.getString("type").equals("Deposit"))
						   {
							   balance+= Integer.parseInt(rs2.getString("amount"));
						   }
						   if(rs2.getString("type").equals("withdrawal"))
						   {
							   balance = balance-Integer.parseInt(rs2.getString("amount"));
						   }
						   
					   }
					   if(balance<1000)
					   {
						     UIManager.put("OptionPane.background", Color.white);
					         UIManager.put("Panel.background", Color.white);
					         UIManager.put("OptionPane.messageForeground", Color.BLACK);
					         UIManager.put("Button.background",Color.black);
					         UIManager.put("Button.foreground",  Color.WHITE);
					         UIManager.put("Button.focus", new Color(60, 63, 65));
							 
					         JOptionPane.showMessageDialog(null, "Insufficient account balance", "ERROR", JOptionPane.ERROR_MESSAGE);
					   }
					   else
					   {
						   PreparedStatement pst= con.prepareStatement(sql);
						   pst.setString(1, pin);
						   pst.setString(2, date);
						   pst.setString(3,"withdrawal");
						   pst.setString(4, "10,000");
						   pst.setString(5, name);
						   pst.setString(6, FormNo);
						   int rs= pst.executeUpdate();	
						   if(rs>0)
						   {   
							
							 JOptionPane.showMessageDialog(null, "₹10,000 Withdrawal Successfull!");
							 
							 frame.setVisible(false);
							 ATM obj5= new ATM(name,pin,FormNo);
							 obj5.setVisible(true);
						   }
						   else
						   {
							   JOptionPane.showMessageDialog(null, "There was an error withdrawing the money from the account", "ERROR", JOptionPane.ERROR_MESSAGE);
						   }
					   }
					   
					  }
					catch(Exception ec2)
					{
						System.out.println(ec2.getMessage());
					}
			      }
			}
				
				
		
		});
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setFont(new Font("Verdana", Font.PLAIN, 15));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(377, 365, 133, 29);
		contentPane.add(btnNewButton_2);
		
		
		
		
		JButton back = new JButton("BACK");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ATM obj6= new ATM(name,pin,FormNo);
				obj6.setVisible(true);
			}
		});
		back.setForeground(Color.BLACK);
		back.setFont(new Font("Verdana", Font.PLAIN, 15));
		back.setBackground(Color.WHITE);
		back.setBounds(255, 444, 133, 29);
		contentPane.add(back);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel.setLabelFor(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("D:\\Bank Management System\\atm.jpg"));
		lblNewLabel.setBounds(-29, -104, 972, 931);
		contentPane.add(lblNewLabel);
		
		
		
	}
}
