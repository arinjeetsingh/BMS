package BankSystem;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Balance extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JLabel balancelabel;
	private JButton back;
	static Balance frame = new Balance("","","");
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
	public Balance(String name,String pin, String FormNo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 0, 904, 845);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ATM obj7=new ATM(name,pin,FormNo);
				obj7.setVisible(true);
			}
		});
		back.setFont(new Font("Verdana", Font.BOLD, 15));
		back.setBackground(Color.WHITE);
		back.setForeground(Color.black);
		back.setBounds(221, 403, 177, 36);
		contentPane.add(back);
		

		balancelabel = new JLabel("");
		balancelabel.setForeground(Color.white);
		balancelabel.setFont(new Font("Verdana", Font.BOLD, 20));
		balancelabel.setBounds(154, 178, 353, 55);
		contentPane.add(balancelabel);
		
		JButton viewBalance = new JButton("View Balance");
		viewBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try
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
						   balance+= Integer.parseInt(rs2.getString("number"));
					   }
					   if(rs2.getString("type").equals("withdrawal"))
					   {
						   balance = balance-Integer.parseInt(rs2.getString("number"));
					   }
					   
					   balancelabel.setText("<html>Your available balance is<br>"+" " + "₹"+balance+"</html>");
					   
				   }
				
			}
			catch(Exception ec)
			{
				System.out.println(ec.getMessage());
			}
				
			}
		});
		viewBalance.setBackground(new Color(255, 255, 255));
		viewBalance.setFont(new Font("Verdana", Font.BOLD, 15));
		viewBalance.setBounds(221, 329, 177, 36);
		contentPane.add(viewBalance);
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel.setLabelFor(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("D:\\Bank Management System\\atm.jpg"));
		lblNewLabel.setBounds(-29, -104, 972, 931);
		contentPane.add(lblNewLabel);
		
		
		
		
		
		
	}
}
