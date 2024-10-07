package BankSystem;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class PINChange extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField pwd;
	private JLabel lblNewLabel_2;
	private JPasswordField repwd;
	private JButton btnNewButton;
	static PINChange frame = new PINChange("");

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
	public PINChange(String oldpin) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 0, 904, 845);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Enter your new PIN:");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(189, 193, 288, 43);
		contentPane.add(lblNewLabel_1);
		
		pwd = new JPasswordField();
		pwd.setBackground(new Color(255, 255, 255));
		pwd.setForeground(new Color(0, 0, 0));
		pwd.setFont(new Font("Verdana", Font.BOLD, 15));
		pwd.setBounds(189, 246, 288, 43);
		contentPane.add(pwd);
		
		lblNewLabel_2 = new JLabel("Re-enter your new PIN:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_2.setBounds(189, 310, 288, 43);
		contentPane.add(lblNewLabel_2);
		
		repwd = new JPasswordField();
		repwd.setForeground(Color.BLACK);
		repwd.setFont(new Font("Verdana", Font.BOLD, 15));
		repwd.setBackground(Color.WHITE);
		repwd.setBounds(189, 363, 288, 43);
		contentPane.add(repwd);
		
		btnNewButton = new JButton("Change PIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newPin= pwd.getText();
				String renewPin= repwd.getText();
				
				
			if(newPin.equals(renewPin))
			{
				
				Connection con =null;
				String url= "jdbc:mysql://localhost:3306/bms";
				String username="root";
				String pwd="arinjeet12345@";
				String sql="Update login set pin=? where pin=?";
				String query="Update bank set pin=? where pin=?";
				String query2="Update p3 set pin=? where pin=?";
				try
				{
				con = DriverManager.getConnection(url,username,pwd);
				PreparedStatement pst= con.prepareStatement(sql);
				PreparedStatement pst2=con.prepareStatement(query);
				PreparedStatement pst3=con.prepareStatement(query2);
				pst.setString(2,oldpin);
				pst.setString(1,newPin);
				
				pst2.setString(2, oldpin);
				pst2.setString(1, newPin);
				
				pst3.setString(2, oldpin);
				pst3.setString(1, newPin);
				
				int result= pst.executeUpdate();
                int result2=pst2.executeUpdate();
                
				if(result>0 && result2>0)
				{
					 UIManager.put("OptionPane.background", Color.white);
			         UIManager.put("Panel.background", Color.white);
			         UIManager.put("OptionPane.messageForeground", Color.BLACK);
			         UIManager.put("Button.background",Color.black);
			         UIManager.put("Button.foreground",  Color.WHITE);
			         UIManager.put("Button.focus", new Color(60, 63, 65));
					JOptionPane.showMessageDialog(null, "PIN changed Successfully!");
					Login obj9=new Login();
					frame.setVisible(false);
					obj9.setVisible(true);
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "There was an error changing the pin", "ERROR", JOptionPane.ERROR_MESSAGE);
				}

				}

				catch(Exception ex)
				{
				System.out.println(ex.getMessage());
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
				JOptionPane.showMessageDialog(null, "PIN and RE-type PIN do not match", "ERROR", JOptionPane.ERROR_MESSAGE);
			}	
				
				
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 15));
		btnNewButton.setBounds(252, 436, 164, 33);
		contentPane.add(btnNewButton);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel.setLabelFor(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("D:\\Bank Management System\\atm.jpg"));
		lblNewLabel.setBounds(-29, -104, 972, 931);
		contentPane.add(lblNewLabel);
		
		
		
		
		
		
		
	}
}
