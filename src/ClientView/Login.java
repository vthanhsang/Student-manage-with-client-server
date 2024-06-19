package ClientView;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ServerView.ViewGV;
import ServerView.ViewSinhVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import Client.Client;

import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

public class Login extends JFrame {
	 private Client client; 
	private JPanel contentPane;
	private JTextField texttk;
	private JPasswordField textpassword;
	private JPasswordField textmk;
	private JTextField port;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public void setClient(Client client) {
        this.client = client;
    }
	
	
	
	
	/**
	 * Create the frame.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Downloads\\education.png"));
		setTitle("Quản Lí Sinh Viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 586);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Đăng Nhập");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\login.png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setBounds(339, 74, 228, 68);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tài Khoản:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(20, 208, 86, 29);
		contentPane.add(lblNewLabel_1);
		
		texttk = new JTextField();
		texttk.setBounds(116, 209, 255, 32);
		contentPane.add(texttk);
		texttk.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mật Khẩu:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(20, 289, 86, 29);
		contentPane.add(lblNewLabel_1_2);
		
		JButton buttondk = new JButton("Đăng Kí");
		buttondk.setBackground(Color.PINK);
		buttondk.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttondk.setBounds(386, 390, 141, 42);
		contentPane.add(buttondk);
		
		 buttondk.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	buttondkactionPerformed(evt);
	            }
	        });
		
		JButton buttoncl = new JButton("Clear");
		buttoncl.setBackground(Color.LIGHT_GRAY);
		buttoncl.setBounds(436, 254, 117, 29);
		contentPane.add(buttoncl);
		
		JButton buttondn = new JButton("Đăng Nhập ");
		buttondn.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 255, 255), new Color(255, 0, 255)));
		buttondn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client.processLogin1(texttk.getText(), textmk.getText());
			}
		});
		buttondn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttondn.setBackground(new Color(210, 180, 140));
		buttondn.setBounds(65, 390, 239, 42);
		contentPane.add(buttondn);
		
		textmk = new JPasswordField();
		textmk.setBounds(116, 286, 255, 32);
		contentPane.add(textmk);
		
		JLabel lblNewLabel_2 = new JLabel("PORT :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(10, 32, 67, 38);
		contentPane.add(lblNewLabel_2);
		
		port = new JTextField();
		port.setBounds(75, 32, 148, 38);
		contentPane.add(port);
		port.setColumns(10);
		
		JButton btnNewButton = new JButton("Kết Nối");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  String portText = port.getText(); // Lấy giá trị từ trường JTextField
			        int portNumber = Integer.parseInt(portText); // Chuyển đổi thành kiểu int

			        client.setPortNumber(portNumber);
			        client.nhancongport(portNumber);
			        client.connectToServer();
			}
		});
		btnNewButton.setBounds(94, 90, 97, 21);
		contentPane.add(btnNewButton);

		
		
		
		
		
		buttoncl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				buttonclear(e);
				
			}
		});
		
		
		
	}
	 private void buttondkactionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGradient2ActionPerformed
	        // TODO add your handling code here:
	        dispose();
	        Register registerJFrame = new Register();
	        registerJFrame.show();
	        
	    }
	
	private void buttonclear(ActionEvent e) {
		texttk.setText("");
		textmk.setText(" ");
	//	textpassword.setText(" " );
		
	}
	
}
