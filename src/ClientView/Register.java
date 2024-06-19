package ClientView;

import java.awt.EventQueue;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Client.Client;

import java.sql.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField texttk;
	private JPasswordField textpassword;
	private JPasswordField textmk;
	private JPasswordField textxnmk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 3));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblngK = new JLabel("Đăng Kí");
		lblngK.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\edit.png"));
		lblngK.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblngK.setBounds(229, 37, 179, 42);
		contentPane.add(lblngK);
		
		JLabel lblNewLabel_1 = new JLabel("Tài Khoản:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(33, 106, 86, 29);
		contentPane.add(lblNewLabel_1);
		
		texttk = new JTextField();
		texttk.setColumns(10);
		texttk.setBounds(203, 106, 233, 33);
		contentPane.add(texttk);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật Khẩu:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(33, 165, 86, 29);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Xác Nhận Mật Khẩu:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(33, 223, 148, 29);
		contentPane.add(lblNewLabel_1_2);
		
		JButton buttondn = new JButton("Đăng Nhập");
		buttondn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttondn.setBackground(Color.PINK);
		buttondn.setBounds(117, 400, 162, 42);
		contentPane.add(buttondn);
		buttondn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				buttondn(e);
			}
		});

		
		
		JButton buttoncl = new JButton("Clear");
		buttoncl.setBackground(Color.LIGHT_GRAY);
		buttoncl.setBounds(493, 167, 117, 29);
		contentPane.add(buttoncl);
		
		textmk = new JPasswordField();
		textmk.setBounds(203, 165, 233, 37);
		contentPane.add(textmk);
		
		textxnmk = new JPasswordField();
		textxnmk.setBounds(203, 223, 233, 37);
		contentPane.add(textxnmk);
		
		JButton buttondksv = new JButton("Đăng Kí ");
		buttondksv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		    	if (textmk.getText().equals(textxnmk.getText())) {
		    	    Client.processRegister1(texttk.getText(), textmk.getText());
		    	} else {
		    	    JOptionPane.showConfirmDialog(null, "Mật khẩu xác nhận không trùng khớp");
		    	}
		    
		    }
		});

		buttondksv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttondksv.setBackground(Color.PINK);
		buttondksv.setBounds(356, 400, 162, 42);
		contentPane.add(buttondksv);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Đồng ý điều khoản và điều kiện");
		rdbtnNewRadioButton.setForeground(Color.RED);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton.setBounds(203, 286, 294, 33);
		contentPane.add(rdbtnNewRadioButton);
		
		
		
		buttoncl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				buttonclear(e);
				
			}
		});
	
		
	}
private void buttondn(ActionEvent e) {
	dispose();
	Login lg=new Login();
	lg.show();
}
private void buttonclear(ActionEvent e) {
	texttk.setText("");
	textmk.setText(" ");
	textxnmk.setText(" ");

}
}
