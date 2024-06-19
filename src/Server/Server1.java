package Server;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Client.ClientHandler;
import ServerView.ViewSinhVien;

import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.Toolkit;

public class Server1 extends JFrame {
	private Sinhviencontroller1 studentController;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	 ServerSocket serverSocket;
	private JTable table;
	private JTextField masv;
	private JTextField tensv;
	private JTextField lopsv;
	private JTextField diachisv;
	private JTextField port;
	private JTable table_1;

	private class ServerThread extends Thread {
	    private int port;

	    public ServerThread(int port) {
	        this.port = port;
	    }
	    @Override
	    public void run() {
	        try {
	            serverSocket = new ServerSocket(port);
	            System.out.println("Server đang chạy đợi kết nối...");

	            while (true) {
	                Socket clientSocket = serverSocket.accept();
	                System.out.println("Client mới kết nối: " + clientSocket.getInetAddress().getHostAddress());

	                ClientHandler clientHandler = new ClientHandler(clientSocket);
	                clientHandler.start();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

	private void startServer(int port) {
	    ServerThread serverThread = new ServerThread(port);
	    serverThread.start();
	}


	public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				try {
					Server1 frame = new Server1();
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
	public Server1() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\OneDrive\\Pictures\\Ảnh chụp màn hình\\Screenshot 2023-06-03 220234.png"));
	
		studentController = new Sinhviencontroller1(); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1147, 752);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 235, 215));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(Color.BLACK, 3));
		scrollPane.setBackground(SystemColor.controlDkShadow);
		scrollPane.setBounds(34, 150, 649, 216);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Mã sinh viên", "Tên sinh viên", "Lớp", "Địa chỉ"
			}
		));
		scrollPane.setViewportView(table);
		table.getSelectionModel().addListSelectionListener(selectionListenerdiemso);
		
		JButton btncapnhat = new JButton("Thêm ");
		btncapnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themSinhVien();
			}
		});
		btncapnhat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btncapnhat.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 0, 255), new Color(255, 0, 255)));
		btncapnhat.setBackground(new Color(127, 255, 212));
		btncapnhat.setBounds(710, 524, 111, 29);
		contentPane.add(btncapnhat);
		
		JLabel lblNewLabel_1 = new JLabel("Quản Lí Sinh Viên");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\education.png"));
		lblNewLabel_1.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 20));
		lblNewLabel_1.setBounds(493, 26, 262, 45);
		contentPane.add(lblNewLabel_1);
		
		JButton buttondx = new JButton("Đăng Xuất");
		buttondx.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\logout.png"));
		buttondx.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttondx.setBackground(Color.YELLOW);
		buttondx.setBounds(872, 6, 134, 29);
		contentPane.add(buttondx);
		
		JButton btnYuCuSa = new JButton("Sửa");
		btnYuCuSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suaSinhVien();
			
			}
		});
		btnYuCuSa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnYuCuSa.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 0, 255), new Color(255, 0, 255)));
		btnYuCuSa.setBackground(new Color(127, 255, 212));
		btnYuCuSa.setBounds(864, 524, 119, 29);
		contentPane.add(btnYuCuSa);
		
		JLabel lblNewLabel = new JLabel("Mã SV:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(717, 151, 66, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblTnSv = new JLabel("Tên SV:");
		lblTnSv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnSv.setBounds(717, 228, 66, 22);
		contentPane.add(lblTnSv);
		
		JLabel lblLp = new JLabel("Lớp :");
		lblLp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLp.setBounds(717, 292, 70, 33);
		contentPane.add(lblLp);
		
		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblaCh.setBounds(717, 369, 80, 33);
		contentPane.add(lblaCh);
		
		
		masv = new JTextField();
		masv.setBounds(824, 149, 231, 33);
		contentPane.add(masv);
		masv.setColumns(10);
		
		tensv = new JTextField();
		tensv.setColumns(10);
		tensv.setBounds(824, 225, 231, 33);
		contentPane.add(tensv);
		
		lopsv = new JTextField();
		lopsv.setColumns(10);
		lopsv.setBounds(824, 294, 231, 33);
		contentPane.add(lopsv);
		
		diachisv = new JTextField();
		diachisv.setColumns(10);
		diachisv.setBounds(824, 371, 231, 33);
		contentPane.add(diachisv);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaSinhVien();
			}
		});
		btnXa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXa.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 0, 255), new Color(255, 0, 255)));
		btnXa.setBackground(new Color(127, 255, 212));
		btnXa.setBounds(1021, 524, 105, 29);
		contentPane.add(btnXa);
		
		JButton btnResetForm = new JButton("Reset ");
		btnResetForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetForm();
			}
		});
		btnResetForm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnResetForm.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 0, 255), null));
		btnResetForm.setBackground(Color.PINK);
		btnResetForm.setBounds(889, 441, 105, 33);
		contentPane.add(btnResetForm);
		
		JLabel lblNewLabel_2 = new JLabel("PORT");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(20, 26, 71, 21);
		contentPane.add(lblNewLabel_2);
		
		port = new JTextField();
		port.setBounds(89, 24, 194, 29);
		contentPane.add(port);
		port.setColumns(10);
		
		JButton bat = new JButton("Bật ");
		bat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String portText = port.getText();
                if (portText.isEmpty()) {
                    JOptionPane.showMessageDialog(Server1.this, "Vui lòng nhập số cổng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                } else {
                    int portNumber = Integer.parseInt(portText);
                    startServer(portNumber);
                }
			}
		});
		
		bat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bat.setBounds(58, 72, 119, 29);
		contentPane.add(bat);
		
		JButton btnNgtKtNi = new JButton("ngắt kết nối");
		btnNgtKtNi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   stopServer();
			}
		});
		btnNgtKtNi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNgtKtNi.setBounds(202, 72, 119, 29);
		contentPane.add(btnNgtKtNi);
		
		JButton capnhat = new JButton("Cập nhật tất cả");
		capnhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				capNhatBangSinhVien1();
				capNhatBangSinhVien();
//				capNhatBangSinhVienthem();
				
			}
		});
		capnhat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		capnhat.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		capnhat.setBackground(new Color(255, 204, 255));
		capnhat.setBounds(835, 629, 171, 33);
		contentPane.add(capnhat);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new LineBorder(Color.BLACK, 3));
		scrollPane_1.setBackground(SystemColor.controlDkShadow);
		scrollPane_1.setBounds(110, 495, 514, 167);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CLient","Mã sv", "Tên sv", "Lớp", "Địa chỉ", "Trạng thái"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_3 = new JLabel("Các yêu cầu sửa  từ client :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_3.setBounds(255, 443, 241, 29);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ADMIN");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\school (1).png"));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(1021, 0, 112, 36);
		contentPane.add(lblNewLabel_4);
		
		JButton chapnhan = new JButton("Đã chấp nhập yêu cầu");
		chapnhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoayeucau();
				Client.Client.sendNotifi();
			}
		});
		chapnhan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chapnhan.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 0, 255), new Color(255, 0, 255)));
		chapnhan.setBackground(new Color(127, 255, 212));
		chapnhan.setBounds(284, 672, 171, 29);
		contentPane.add(chapnhan);
		table_1.getSelectionModel().addListSelectionListener(selectionListenerchinhsua);
        buttondx.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buttondn(e);
			}
		});
		capNhatBangSinhVien();
	}
	//table_1 "cap nhap"
    private void capNhatBangSinhVien1() {
        List<Sinhvienmodel1> danhSachSV = studentController.getDanhSachSinhVien();
        DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        model.setRowCount(0);
        for (Sinhvienmodel1 sinhVien : danhSachSV) {
            Object[] row = {sinhVien.getClient(), sinhVien.getMasv(), sinhVien.getTen(), sinhVien.getLop(), sinhVien.getDiachi(), sinhVien.getTrangthai() };
            model.addRow(row);
        }
    }
    //table_1 "Them"
    private void capNhatBangSinhVienthem() {
        List<Sinhvienmodel1> danhSachSV = studentController.getDanhSachSinhVienthem();
        DefaultTableModel model = (DefaultTableModel) table_1.getModel();
        model.setRowCount(0);
        for (Sinhvienmodel1 sinhVien : danhSachSV) {
            Object[] row = {sinhVien.getClient(), sinhVien.getMasv(), sinhVien.getTen(), sinhVien.getLop(), sinhVien.getDiachi(), sinhVien.getTrangthai() };
            model.addRow(row);
        }
    }
   
    public void xoayeucau() {
        int selectedIndex = table_1.getSelectedRow();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sinh viên cần xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            int dialogResult = JOptionPane.showConfirmDialog(this, "Xác thực xóa yêu cầu?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                String maSV = table_1.getValueAt(selectedIndex, 1).toString(); // Retrieve value from the second column (index 1)
                studentController.deleteStudentt(maSV);
                JOptionPane.showMessageDialog(this, "Xóa yêu cầu thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                resetForm();
                capNhatBangSinhVien1();
            }
        }
    }

 
  //////////////////////////////////////////////////////////////////////  
    
    
    
    
    private void capNhatBangSinhVien() {
        List<Sinhvienmodel1> danhSachSV = studentController.getDanhSachSinhVien1();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (Sinhvienmodel1 sinhVien : danhSachSV) {
            Object[] row = { sinhVien.getMasv(), sinhVien.getTen(), sinhVien.getLop(), sinhVien.getDiachi() };
            model.addRow(row);
        }
    }
   
    private void resetForm() {
        masv.setText("");
        tensv.setText("");
        lopsv.setText("");
        diachisv.setText("");
    }

private void themSinhVien() {
    String maSV = masv.getText().trim();
    String tenSV = tensv.getText().trim();
    String lopSV = lopsv.getText().trim();
    String diachiSV = diachisv.getText().trim();

    if (maSV.isEmpty() || tenSV.isEmpty() || lopSV.isEmpty() || diachiSV.isEmpty()) {
        // Hiển thị thông báo lỗi khi thông tin không đầy đủ
        JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }

    Sinhvienmodel1 student = new Sinhvienmodel1(maSV, tenSV, lopSV, diachiSV);
    student.setMasv(maSV);
    student.setTen(tenSV);
    student.setLop(lopSV);
    student.setDiachi(diachiSV);
    Sinhviencontroller1 sinhviencontroller1 = new Sinhviencontroller1();
	sinhviencontroller1.addStudent1(student);

    capNhatBangSinhVien();
}


public void xoaSinhVien() {
    int selectedIndex = table.getSelectedRow();
    if (selectedIndex == -1) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn sinh viên cần xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    } else {
        int dialogResult = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa sinh viên này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            String maSV = table.getValueAt(selectedIndex, 0).toString();
            studentController.deleteStudent1(maSV);
            JOptionPane.showMessageDialog(this, "Xóa sinh viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            resetForm();
            capNhatBangSinhVien();
        }
    }
}



private void suaSinhVien() {
    String maSV = masv.getText();
    String tenSV = tensv.getText();
    String lopSV = lopsv.getText();
    String diaChiSV = diachisv.getText();

    // Gọi phương thức sửa sinh viên từ lớp Controller
    Sinhvienmodel1 student = new Sinhvienmodel1(diaChiSV, diaChiSV, diaChiSV, diaChiSV);
    student.setMasv(maSV);
    student.setTen(tenSV);
    student.setLop(lopSV);
    student.setDiachi(diaChiSV);
    studentController.updateStudent1(student);

    // Cập nhật lại bảng thông tin sinh viên
    capNhatBangSinhVien();
}
	
	
	
private void stopServer() {
    try {
        if (serverSocket != null && !serverSocket.isClosed()) {
            serverSocket.close();
        
            System.out.println("Server đã ngừng hoạt động");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
	private void buttondn(ActionEvent e) {
     Server1.this.dispose();
	}
	
	ListSelectionListener selectionListenerdiemso = new ListSelectionListener() {
	    @Override
	    public void valueChanged(ListSelectionEvent e) {
	        if (!e.getValueIsAdjusting()) { // Kiểm tra xem sự kiện có phải do người dùng thực hiện chọn hàng hay không
	            int selectedIndex = table.getSelectedRow();
	            if (selectedIndex != -1) { // Đảm bảo có hàng được chọn trong bảng
	                // Lấy thông tin từ hàng đã chọn trong bảng
	                String maSV2 = table.getValueAt(selectedIndex, 0).toString();
	                String diem44 = table.getValueAt(selectedIndex, 1).toString();
	                String diem100 = table.getValueAt(selectedIndex, 2).toString();
	                String xeploaii = table.getValueAt(selectedIndex, 3).toString();

	                // Đẩy thông tin lên các trường văn bản tương ứng
	                masv.setText(maSV2);
	                tensv.setText(diem44);
	                lopsv.setText(diem100);
	                diachisv.setText(xeploaii);
	            }
	        }
	    }
	};
	
	ListSelectionListener selectionListenerchinhsua = new ListSelectionListener() {
	    @Override
	    public void valueChanged(ListSelectionEvent e) {
	        if (!e.getValueIsAdjusting()) { // Kiểm tra xem sự kiện có phải do người dùng thực hiện chọn hàng hay không
	            int selectedIndex = table_1.getSelectedRow();
	            if (selectedIndex != -1) { // Đảm bảo có hàng được chọn trong bảng
	                // Lấy thông tin từ hàng đã chọn trong bảng
	                String maSV2 = table_1.getValueAt(selectedIndex, 1).toString();
	                String diem44 = table_1.getValueAt(selectedIndex, 2).toString();
	                String diem100 = table_1.getValueAt(selectedIndex, 3).toString();
	                String xeploaii = table_1.getValueAt(selectedIndex, 4).toString();

	                // Đẩy thông tin lên các trường văn bản tương ứng
	                masv.setText(maSV2);
	                tensv.setText(diem44);
	                lopsv.setText(diem100);
	                diachisv.setText(xeploaii);
	            }
	        }
	    }
	};
	}


