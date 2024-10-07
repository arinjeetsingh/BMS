package BankSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfcn;
	private JPasswordField tfpin;
	String Fno;
	String gname;
	static Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 810, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(152, 213, 241));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("E:\\Arin\\C\\Users\\arinj\\eclipse-workspace\\BankManagementSystem\\src\\BankSystem\\icons\\SUPERFAST.png"));
		lblNewLabel.setBounds(170, 10, 458, 224);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Card Number");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 22));
		lblNewLabel_1.setBounds(128, 288, 187, 52);
		contentPane.add(lblNewLabel_1);
		
		tfcn = new JTextField();
		tfcn.setBackground(new Color(255, 255, 255));
		tfcn.setForeground(new Color(0, 0, 0));
		tfcn.setFont(new Font("Verdana", Font.PLAIN, 20));
		tfcn.setBounds(353, 297, 296, 40);
		contentPane.add(tfcn);
		tfcn.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("PIN");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(133, 384, 160, 52);
		contentPane.add(lblNewLabel_1_1);
		
		JButton signin = new JButton("Sign In");
		signin.setForeground(new Color(255, 255, 255));
		signin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cardNumber= tfcn.getText();
				String pin= tfpin.getText();
				
				try {
				String url="jdbc:mysql://localhost:3306/bms";
				String uname="root";
				String spwd="arinjeet12345@";
				String query= "SELECT * FROM login where cardNO=? and pin=?";
				
				String query2="SELECT * FROM p1 where formNO=?";
				
				Connection con = null;

				   con= DriverManager.getConnection(url,uname,spwd);
				   PreparedStatement pst= con.prepareStatement(query); 
				   pst.setString(1,cardNumber);
				   pst.setString(2, pin);
				   ResultSet rs = pst.executeQuery();
				   if(rs.next())
				   {
					   
					   Fno= rs.getString("formNo");	
					   
					   PreparedStatement pst2= con.prepareStatement(query2);
					   pst2.setString(1, Fno);
					   ResultSet rs2= pst2.executeQuery();
					   if(rs2.next())
					   {
					      
						  gname= rs2.getString("name");
						  
						   frame.setVisible(false);
						   ATM obj2= new ATM(gname,pin,Fno);
						   obj2.setVisible(true);
					   }
					   
					   
					   /*frame.setVisible(false);
					   ATM obj2= new ATM(gname);
					   obj2.setVisible(true);
				   */
					   }
				   else
				   {
					   JOptionPane.showMessageDialog(null, "Incorrect card number or PIN", "ERROR", JOptionPane.ERROR_MESSAGE);
				   }
				   
				   
				   
				   
				   
				}
				catch(Exception ec1)
				{
					System.out.println(ec1.getMessage());
				}
			}
		});
		signin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		signin.setBackground(new Color(0, 0, 0));
		signin.setFont(new Font("Verdana", Font.BOLD, 20));
		signin.setBounds(313, 489, 160, 35);
		contentPane.add(signin);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setForeground(new Color(255, 255, 255));
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				SignUpOne obj= new SignUpOne();
				obj.setVisible(true);
			}
		});
		btnSignUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSignUp.setFont(new Font("Verdana", Font.BOLD, 20));
		btnSignUp.setBackground(new Color(0, 0, 0));
		btnSignUp.setBounds(67, 489, 160, 35);
		contentPane.add(btnSignUp);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setForeground(new Color(255, 255, 255));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					tfcn.setText(null);
					tfpin.setText(null);
			}
		});
		btnClear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClear.setFont(new Font("Verdana", Font.BOLD, 20));
		btnClear.setBackground(new Color(0, 0, 0));
		btnClear.setBounds(570, 489, 160, 35);
		contentPane.add(btnClear);
		
		tfpin = new JPasswordField();
		tfpin.setBackground(new Color(255, 255, 255));
		tfpin.setBounds(353, 388, 296, 40);
		contentPane.add(tfpin);
	}
}
