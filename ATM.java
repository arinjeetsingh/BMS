package BankSystem;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ATM extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static ATM frame2 = new ATM("","","");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ATM(String name, String pin, String FormNo) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 0, 904, 845);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Please select your transaction:");
		
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(149, 220, 381, 49);
		contentPane.add(lblNewLabel_2);
		
		JButton deposit = new JButton("Deposit");
		deposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2.setVisible(false);
				Deposit obj3= new Deposit(name,pin,FormNo);
				obj3.setVisible(true);
			}
		});
		deposit.setFont(new Font("Verdana", Font.PLAIN, 15));
		deposit.setBackground(new Color(255, 255, 255));
		deposit.setForeground(new Color(0, 0, 0));
		deposit.setBounds(144, 324, 133, 29);
		contentPane.add(deposit);
		
		
		
		JButton withdrawal = new JButton("Withdrawal");
		withdrawal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2.setVisible(false);
				Withdrawal obj3= new Withdrawal(name,pin,FormNo);
				obj3.setVisible(true);
			}
		});
		withdrawal.setForeground(Color.BLACK);
		withdrawal.setFont(new Font("Verdana", Font.PLAIN, 15));
		withdrawal.setBackground(Color.WHITE);
		withdrawal.setBounds(375, 324, 133, 29);
		contentPane.add(withdrawal);
		
		
		JButton fastcash = new JButton("Fast Cash");
		fastcash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2.setVisible(false);
				FastCash obj5= new FastCash(name,pin,FormNo);
				obj5.setVisible(true);
			}
		});
		fastcash.setForeground(Color.BLACK);
		fastcash.setFont(new Font("Verdana", Font.PLAIN, 15));
		fastcash.setBackground(Color.WHITE);
		fastcash.setBounds(144, 365, 133, 29);
		contentPane.add(fastcash);
		
		
		JButton btnNewButton_2 = new JButton("Mini-Statement");
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(375, 365, 133, 29);
		contentPane.add(btnNewButton_2);
		
		JButton pinchange = new JButton("Pin Change");
		pinchange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			 frame2.setVisible(false);
			 PINChange obj8= new PINChange(pin);
			 obj8.setVisible(true);
			 
			}
		});
		pinchange.setForeground(Color.BLACK);
		pinchange.setFont(new Font("Verdana", Font.PLAIN, 15));
		pinchange.setBackground(Color.WHITE);
		pinchange.setBounds(144, 408, 133, 29);
		contentPane.add(pinchange);
		
		
		JButton balance = new JButton("Balance Enquiry");
		balance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame2.setVisible(false);
				Balance obj6=new Balance(name,pin,FormNo);
				obj6.setVisible(true);
				
				
			}
		});
		balance.setForeground(Color.BLACK);
		balance.setFont(new Font("Verdana", Font.PLAIN, 12));
		balance.setBackground(Color.WHITE);
		balance.setBounds(375, 408, 133, 35);
		contentPane.add(balance);
		
		JButton profile = new JButton("Profile");
		profile.setForeground(Color.BLACK);
		profile.setFont(new Font("Verdana", Font.PLAIN, 15));
		profile.setBackground(Color.WHITE);
		profile.setBounds(144, 447, 133, 29);
		contentPane.add(profile);
		
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2.setVisible(false);
				
			}
		});
		exit.setForeground(Color.BLACK);
		exit.setFont(new Font("Verdana", Font.PLAIN, 15));
		exit.setBackground(Color.WHITE);
		exit.setBounds(375, 453, 133, 29);
		contentPane.add(exit);
		
		JLabel hello = new JLabel("Hello" + " " + name);
		hello.setForeground(Color.WHITE);
		hello.setFont(new Font("Verdana", Font.BOLD, 15));
		hello.setBounds(199, 189, 244, 21);
		contentPane.add(hello);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel.setLabelFor(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("D:\\Bank Management System\\atm.jpg"));
		lblNewLabel.setBounds(-29, -104, 972, 931);
		contentPane.add(lblNewLabel);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
