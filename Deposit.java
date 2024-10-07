package BankSystem;

import java.awt.EventQueue;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
// import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Deposit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField amount;
	private JButton deposit;
	private JButton back;
	static Deposit frame = new Deposit("","","");
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
	public Deposit(String name, String pin, String formNo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 0, 904, 845);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel_1 = new JLabel("Enter the amount you want to deposit");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_1.setBounds(157, 235, 349, 37);
		contentPane.add(lblNewLabel_1);
		
		amount = new JTextField();
		amount.setFont(new Font("Verdana", Font.BOLD, 16));
		amount.setForeground(new Color(0, 0, 0));
		amount.setBounds(158, 324, 336, 27);
		contentPane.add(amount);
		amount.setColumns(10);
		
		deposit = new JButton("Deposit");
		deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String number= amount.getText();
				 Date currentDate = new Date();
				 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				 String date = dateFormat.format(currentDate);
				 
				 UIManager.put("OptionPane.background", Color.white);
		         UIManager.put("Panel.background", Color.white);
		         UIManager.put("OptionPane.messageForeground", Color.BLACK);
		         UIManager.put("Button.background",Color.black);
		         UIManager.put("Button.foreground",  Color.WHITE);
		         UIManager.put("Button.focus", new Color(60, 63, 65));
		         String input = JOptionPane.showInputDialog(null, "Enter the pin to deposit money");
			if(number.equals(""))
			{
				 UIManager.put("OptionPane.background", Color.white);
		         UIManager.put("Panel.background", Color.white);
		         UIManager.put("OptionPane.messageForeground", Color.BLACK);
		         UIManager.put("Button.background",Color.black);
		         UIManager.put("Button.foreground",  Color.WHITE);
		         UIManager.put("Button.focus", new Color(60, 63, 65));
				 
		         JOptionPane.showMessageDialog(null, "Please enter some amount", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				     
				if(input.equals(pin))
				{  try
				  {
				   String url="jdbc:mysql://localhost:3306/bms";
				   String uname="root";
				   String spwd="arinjeet12345@";
				   String sql="INSERT INTO bank values(?,?,?,?,?,?)";
				   Connection con = null;
				   con= DriverManager.getConnection(url,uname,spwd);
				   PreparedStatement pst= con.prepareStatement(sql);
				   pst.setString(1, pin);
				   pst.setString(2, date);
				   pst.setString(3,"Deposit");
				   pst.setString(4, number);
				   pst.setString(5, name);
				   pst.setString(6, formNo);
				   int rs= pst.executeUpdate();	
				   if(rs>0)
				   {   
					    UIManager.put("OptionPane.background", Color.white);
				         UIManager.put("Panel.background", Color.white);
				         UIManager.put("OptionPane.messageForeground", Color.BLACK);
				         UIManager.put("Button.background",Color.black);
				         UIManager.put("Button.foreground",  Color.WHITE);
				         UIManager.put("Button.focus", new Color(60, 63, 65));
					 JOptionPane.showMessageDialog(null, "₹"+ number + "Successfully deposited!");
					 amount.setText("");
					 frame.setVisible(false);
					 ATM obj5= new ATM(name,pin,formNo);
					 obj5.setVisible(true);
				   }
				   
				   else
				   {
					   JOptionPane.showMessageDialog(null, "There was an error depositing the money in the account", "ERROR", JOptionPane.ERROR_MESSAGE);
				   }
				  }
				 catch(Exception ec)
				  {
					 System.out.println(ec.getMessage());
				  }
				}
				else
				{
					 UIManager.put("OptionPane.background", Color.white);
			         UIManager.put("Panel.background", Color.white);
			         UIManager.put("OptionPane.messageForeground", Color.BLACK);
			         UIManager.put("Button.background",Color.black);
			         UIManager.put("Button.foreground",  Color.WHITE);
			         UIManager.put("Button.focus", new Color(60, 63, 65));
					 
			       
			      JOptionPane.showMessageDialog(null, "Incorrect PIN", "ERROR", JOptionPane.ERROR_MESSAGE);
				
				}
			}	
			}
		});
		deposit.setBackground(new Color(255, 255, 255));
		deposit.setForeground(new Color(0, 0, 0));
		deposit.setFont(new Font("Verdana", Font.PLAIN, 16));
		deposit.setBounds(163, 449, 109, 21);
		contentPane.add(deposit);
		
		
		back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ATM obj5= new ATM(name,pin,formNo);
				obj5.setVisible(true);
			}
		});
		back.setForeground(Color.BLACK);
		back.setFont(new Font("Verdana", Font.PLAIN, 16));
		back.setBackground(Color.WHITE);
		back.setBounds(385, 449, 109, 21);
		contentPane.add(back);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel.setLabelFor(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("D:\\Bank Management System\\atm.jpg"));
		lblNewLabel.setBounds(-29, -104, 972, 931);
		contentPane.add(lblNewLabel);
		
		
		
		
		
		
		
		
		
	}
}
