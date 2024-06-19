package ServerView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ClientView.Login;


import Server.Sinhviencontroller1;
import Server.Sinhvienmodel1;

import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ViewGV extends JFrame {
	  private Sinhviencontroller1 studentController;

	private JPanel contentPane;
	private JTable table;
	private JTable table2;
	private JTable table1;
	private JTextField masv1;
	private JTextField tensv;
	private JTextField lop;
	private JTextField diachi;
	private JTextField masv_n;
	private JTextField tensv_n;
	private JTextField hocphi;
	private JTextField trangthai_n;
	private JTextField masv_2;
	private JTextField diem4;
	private JTextField diem10;
	private JTextField xeploai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewGV frame = new ViewGV();
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
	public ViewGV() {
		setBackground(new Color(0, 255, 255));
		setForeground(new Color(255, 69, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Downloads\\cr.jpg"));
		setTitle("Kiểm tra java /22CE071");
		studentController = new Sinhviencontroller1(); 
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1195, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(27, 42, 1108, 600);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(250, 250, 210));
		tabbedPane.addTab("Xếp loại sinh viên", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBackground(new Color(250, 250, 210));
		panel_4.setBounds(0, 0, 1103, 573);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 110, 529, 361);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		scrollPane_1.setBounds(0, 0, 529, 361);
		panel_5.add(scrollPane_1);
		
		table2 = new JTable();
		table2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		table2.setBackground(new Color(245, 245, 245));
		table2.setForeground(Color.BLACK);
		table2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã Sinh Viên", "Điểm hệ 4", "Điểm hệ 10", "Xếp loại"
			}
		));
		scrollPane_1.setViewportView(table2);
		
		// Đăng ký sự kiện cho diremso
		table2.getSelectionModel().addListSelectionListener(selectionListenerdiemso);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Xếp loại");
		lblNewLabel_1_1_1.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(519, 10, 214, 45);
		panel_4.add(lblNewLabel_1_1_1);
		
		masv_2 = new JTextField();
		masv_2.setColumns(10);
		masv_2.setBounds(700, 110, 241, 29);
		panel_4.add(masv_2);
		
		diem4 = new JTextField();
		diem4.setColumns(10);
		diem4.setBounds(700, 170, 241, 29);
		panel_4.add(diem4);
		
		diem10 = new JTextField();
		diem10.setColumns(10);
		diem10.setBounds(700, 234, 241, 29);
		panel_4.add(diem10);
		
		xeploai = new JTextField();
		xeploai.setColumns(10);
		xeploai.setBounds(700, 299, 241, 29);
		panel_4.add(xeploai);
		
		JLabel lblTnSv_1 = new JLabel("Mã SV:");
		lblTnSv_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnSv_1.setBounds(597, 105, 104, 35);
		panel_4.add(lblTnSv_1);
		
		JLabel lblTnSv_2 = new JLabel("Điểm hệ 4:");
		lblTnSv_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnSv_2.setBounds(597, 164, 104, 35);
		panel_4.add(lblTnSv_2);
		
		JLabel lblTnSv_3 = new JLabel("ĐIểm hệ 10:");
		lblTnSv_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnSv_3.setBounds(597, 228, 104, 35);
		panel_4.add(lblTnSv_3);
		
		JLabel lblTnSv_4 = new JLabel("Xếp loại:");
		lblTnSv_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnSv_4.setBounds(597, 293, 104, 35);
		panel_4.add(lblTnSv_4);
		
		JButton btnThem_2 = new JButton("Thêm");
		btnThem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themSinhVien2();
			}
		});
		btnThem_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThem_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnThem_2.setBackground(new Color(204, 255, 255));
		btnThem_2.setBounds(619, 401, 104, 35);
		panel_4.add(btnThem_2);
		
		JButton btnReset_3 = new JButton("Reset");
		btnReset_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetForm2();
			}
		});
		btnReset_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReset_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnReset_3.setBackground(new Color(204, 255, 255));
		btnReset_3.setBounds(979, 204, 104, 35);
		panel_4.add(btnReset_3);
		
		JButton btnSua_2 = new JButton("Sửa");
		btnSua_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suaSinhVien2();
			}
		});
		btnSua_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSua_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnSua_2.setBackground(new Color(204, 255, 255));
		btnSua_2.setBounds(790, 401, 104, 35);
		panel_4.add(btnSua_2);
		
		JButton btnXoa_2 = new JButton("Xóa");
		btnXoa_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaSinhVien2();
			}
		});
		btnXoa_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXoa_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnXoa_2.setBackground(new Color(204, 255, 255));
		btnXoa_2.setBounds(964, 401, 104, 35);
		panel_4.add(btnXoa_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(250, 250, 210));
		tabbedPane.addTab("Học phí", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel trangthai = new JPanel();
		trangthai.setBorder(new LineBorder(new Color(0, 0, 0)));
		trangthai.setBackground(new Color(250, 250, 210));
		trangthai.setBounds(0, 0, 1103, 573);
		panel_2.add(trangthai);
		trangthai.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(10, 109, 529, 357);
		trangthai.add(panel_7);
		panel_7.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBorder(new LineBorder(Color.BLACK, 2, true));
		scrollPane_3.setBounds(0, 0, 525, 357);
		panel_7.add(scrollPane_3);
		
		table1 = new JTable();
		table1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã sinh viên", "Tên sinh viên", "số học phí cần nộp", "Trạng thái"
			}
		));
		scrollPane_3.setViewportView(table1);
		
//		
		
	

		// Đăng ký sự kiện cho bảng
		table1.getSelectionModel().addListSelectionListener(selectionListener);

		
		
		
		
		
		masv_n = new JTextField();
		masv_n.setColumns(10);
		masv_n.setBounds(692, 109, 241, 29);
		trangthai.add(masv_n);
		
		tensv_n = new JTextField();
		tensv_n.setColumns(10);
		tensv_n.setBounds(692, 177, 241, 29);
		trangthai.add(tensv_n);
		
		hocphi = new JTextField();
		hocphi.setColumns(10);
		hocphi.setBounds(692, 244, 241, 29);
		trangthai.add(hocphi);
		
		trangthai_n = new JTextField();
		trangthai_n.setColumns(10);
		trangthai_n.setBounds(692, 309, 241, 29);
		trangthai.add(trangthai_n);
		
		JLabel lblMnHc = new JLabel("Mã SV  :");
		lblMnHc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMnHc.setBounds(593, 109, 104, 35);
		trangthai.add(lblMnHc);
		
		JLabel lblGiHc = new JLabel("Tên SV :");
		lblGiHc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiHc.setBounds(593, 172, 104, 35);
		trangthai.add(lblGiHc);
		
		JLabel lblNgyHc = new JLabel("Học phí :");
		lblNgyHc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgyHc.setBounds(593, 238, 104, 35);
		trangthai.add(lblNgyHc);
		
		JLabel lblPhngHc = new JLabel("Trạng thái :");
		lblPhngHc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPhngHc.setBounds(593, 303, 104, 35);
		trangthai.add(lblPhngHc);
		
		JLabel lblNewLabel_1_1 = new JLabel("Học phí");
		lblNewLabel_1_1.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(502, 10, 214, 45);
		trangthai.add(lblNewLabel_1_1);
		
		JButton btnThem_1 = new JButton("Thêm");
		btnThem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themSinhVien1();
			}
		});
		btnThem_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThem_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnThem_1.setBackground(new Color(204, 255, 255));
		btnThem_1.setBounds(593, 400, 104, 35);
		trangthai.add(btnThem_1);
		
		JButton btnSua_1 = new JButton("Sửa");
		btnSua_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suaSinhVien1();
			}
		});
		btnSua_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSua_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnSua_1.setBackground(new Color(204, 255, 255));
		btnSua_1.setBounds(773, 400, 104, 35);
		trangthai.add(btnSua_1);
		
		JButton btnXoa_1 = new JButton("Xóa");
		btnXoa_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaSinhVien1();
			}
		});
		btnXoa_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXoa_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnXoa_1.setBackground(new Color(204, 255, 255));
		btnXoa_1.setBounds(959, 400, 104, 35);
		trangthai.add(btnXoa_1);
		
		JButton btnReset_1 = new JButton("Reset");
		btnReset_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetForm1();
			}
		});
		btnReset_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReset_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnReset_1.setBackground(new Color(204, 255, 255));
		btnReset_1.setBounds(975, 212, 104, 35);
		trangthai.add(btnReset_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(250, 250, 210));
		tabbedPane.addTab("Thông tin sinh viên", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 101, 564, 365);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 564, 365);
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		scrollPane.setBackground(SystemColor.controlDkShadow);
		panel_3.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 Sinh Vi\u00EAn", "T\u00EAn SInh Vi\u00EAn", "L\u1EDBp H\u1ECDc", "\u0110\u1ECBa Ch\u1EC9"
			}
		));
		scrollPane.setViewportView(table);
		// Đăng ký sự kiện cho bảng
				table.getSelectionModel().addListSelectionListener(selectionListenerInFor);
		
		masv1 = new JTextField();
		masv1.setColumns(10);
		masv1.setBounds(730, 93, 241, 29);
		panel.add(masv1);
		
		tensv = new JTextField();
		tensv.setColumns(10);
		tensv.setBounds(730, 150, 241, 29);
		panel.add(tensv);
		
		lop = new JTextField();
		lop.setColumns(10);
		lop.setBounds(730, 217, 241, 29);
		panel.add(lop);
		
		diachi = new JTextField();
		diachi.setColumns(10);
		diachi.setBounds(730, 280, 241, 29);
		panel.add(diachi);
		
		JLabel lblMSv = new JLabel("Lớp:");
		lblMSv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMSv.setBounds(647, 212, 104, 35);
		panel.add(lblMSv);
		
		JLabel lblTnSv = new JLabel("Tên SV:");
		lblTnSv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnSv.setBounds(647, 150, 104, 35);
		panel.add(lblTnSv);
		
		JLabel lblaCh = new JLabel("Địa chỉ:");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblaCh.setBounds(647, 275, 104, 35);
		panel.add(lblaCh);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setForeground(new Color(0, 0, 0));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themSinhVien();
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThem.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnThem.setBackground(new Color(0, 255, 255));
		btnThem.setBounds(624, 402, 114, 45);
		panel.add(btnThem);
		
		JButton btnSua = new JButton("Sửa ");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suaSinhVien();
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSua.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSua.setBackground(new Color(0, 255, 255));
		btnSua.setBounds(796, 402, 104, 45);
		panel.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaSinhVien();
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXoa.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnXoa.setBackground(new Color(0, 255, 255));
		btnXoa.setBounds(967, 402, 104, 45);
		panel.add(btnXoa);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetForm();
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnReset.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnReset.setBackground(new Color(0, 255, 255));
		btnReset.setBounds(993, 179, 100, 45);
		panel.add(btnReset);
		
		JLabel lblNewLabel_1 = new JLabel("Thông Tin Sinh Viên");
		lblNewLabel_1.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 15));
		lblNewLabel_1.setBounds(485, 10, 214, 45);
		panel.add(lblNewLabel_1);
		
		JLabel lblMSv_1 = new JLabel("Mã SV:");
		lblMSv_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMSv_1.setBounds(647, 87, 104, 35);
		panel.add(lblMSv_1);
		
		JButton btnThem_1_5 = new JButton("Giảng viên");
		btnThem_1_5.setBounds(889, 11, 117, 48);
		btnThem_1_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThem_1_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnThem_1_5.setBackground(new Color(250, 240, 230));
		contentPane.add(btnThem_1_5);
		
		JLabel lblNewLabel_1_2 = new JLabel("Quản Lí Sinh Viên");
		lblNewLabel_1_2.setBounds(478, 10, 195, 45);
		lblNewLabel_1_2.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\school (1).png"));
		
		lblNewLabel_1_2.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setBackground(new Color(0, 0, 0));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Đăng nhập", "Đăng xuất"}));
		comboBox.setBounds(1039, 11, 96, 48);
		contentPane.add(comboBox);
		
		comboBox.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String selectedOption = (String) comboBox.getSelectedItem();
		        if (selectedOption.equals("Đăng xuất")) {
		            // Mở trang đăng nhập (Login)
		            
		            
		            // Đóng trang hiện tại (ViewGV)
		            ViewGV.this.dispose();
		        }
		    }
		});
		
		
		
		
		
		capNhatBangSinhVien();
		capNhatBangSinhVien1();
		  capNhatBangSinhVien2();
	}
	
	
	 private void resetForm() {
	        masv1.setText("");
	        tensv.setText("");
	        lop.setText("");
	        diachi.setText("");
	    }
	
	private void themSinhVien() {
        String maSV = masv1.getText().trim();
        String tenSV = tensv.getText().trim();
        String lopSV = lop.getText().trim();
        String diachiSV = diachi.getText().trim();

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
        String maSV = masv1.getText();
        String tenSV = tensv.getText();
        String lopSV = lop.getText();
        String diaChiSV = diachi.getText();

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
    
    private void capNhatBangSinhVien() {
        List<Sinhvienmodel1> danhSachSV = studentController.getDanhSachSinhVien1();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (Sinhvienmodel1 sinhVien : danhSachSV) {
            Object[] row = { sinhVien.getMasv(), sinhVien.getTen(), sinhVien.getLop(), sinhVien.getDiachi() };
            model.addRow(row);
        }
    }
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private void resetForm1() {
        masv_n.setText("");
        tensv_n.setText("");
        hocphi.setText("");
        trangthai_n.setText("");
    }

    private void themSinhVien1() {
        String maSV1 = masv_n.getText().trim();
        String tensv = tensv_n.getText().trim();
        String hocphiStr = hocphi.getText().trim();
        int hocphi = Integer.parseInt(hocphiStr);
        String nophocphi = trangthai_n.getText().trim();

        if (maSV1.isEmpty() || tensv.isEmpty() || nophocphi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Sinhvienmodel1 student = new Sinhvienmodel1(maSV1, tensv, hocphi, nophocphi);
        Sinhviencontroller1 sinhviencontroller1 = new Sinhviencontroller1();
        sinhviencontroller1.addStudent3(student);

        capNhatBangSinhVien1();
    }

    public void xoaSinhVien1() {
        int selectedIndex = table1.getSelectedRow();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sinh viên cần xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            int dialogResult = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa sinh viên này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                String maSV = table1.getValueAt(selectedIndex, 0).toString();
                studentController.deleteStudent3(maSV);
                JOptionPane.showMessageDialog(this, "Xóa sinh viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                resetForm1();
                capNhatBangSinhVien1();
            }
        }
    }

    private void suaSinhVien1() {
    	
    	
   	 int selectedIndex = table1.getSelectedRow();
   	    if (selectedIndex == -1) {
   	        JOptionPane.showMessageDialog(this, "Vui lòng chọn sinh viên cần sửa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
   	        return;
   	    }
   	  
       String maSV = masv_n.getText();
       String ten = tensv_n.getText().trim();
       String hocphiStr = hocphi.getText().trim();
       int hocphi = Integer.parseInt(hocphiStr);
       String nophocphi = trangthai_n.getText().trim();

       // Gọi phương thức sửa sinh viên từ lớp Controller
       Sinhvienmodel1 student = new Sinhvienmodel1(maSV, ten, hocphi, nophocphi);
       studentController.updateStudent3(student);

       // Cập nhật lại bảng thông tin sinh viên
       capNhatBangSinhVien1();
   }

    private void capNhatBangSinhVien1() {
        List<Sinhvienmodel1> danhSachSV = studentController.getDanhSachSinhVien3();
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        model.setRowCount(0);
        for (Sinhvienmodel1 sinhVien : danhSachSV) {
            Object[] row = { sinhVien.getMasv(), sinhVien.getTen(), sinhVien.getHocphi(), sinhVien.getNophocphi() };
            model.addRow(row);
        }
    }
    
    
    
    
    
    private void resetForm2() {
        masv_2.setText("");
        diem4.setText("");
        diem10.setText("");
        xeploai.setText("");
    }

    private void themSinhVien2() {
        String maSV2 = masv_2.getText().trim();
        String diem44 = diem4.getText().trim();
        float diem4= Float.parseFloat(diem44);
        String diem100 = diem10.getText().trim();
        float diem10 = Float.parseFloat(diem100);
        String xeploaii = xeploai.getText().trim();

        if (maSV2.isEmpty() || xeploaii.isEmpty() ) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Sinhvienmodel1 student = new Sinhvienmodel1(maSV2, diem4, diem10, xeploaii);
        Sinhviencontroller1 sinhviencontroller1 = new Sinhviencontroller1();
        sinhviencontroller1.addStudent2(student);

        capNhatBangSinhVien2();
    }

    public void xoaSinhVien2() {
        int selectedIndex = table2.getSelectedRow();
        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sinh viên cần xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            int dialogResult = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa sinh viên này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                String maSV = table2.getValueAt(selectedIndex, 0).toString();
                studentController.deleteStudent2(maSV);
                JOptionPane.showMessageDialog(this, "Xóa sinh viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                resetForm2();
                capNhatBangSinhVien2();
            }
        }
    }

    private void suaSinhVien2() {
    	
    	
   	 int selectedIndex = table2.getSelectedRow();
   	    if (selectedIndex == -1) {
   	        JOptionPane.showMessageDialog(this, "Vui lòng chọn sinh viên cần sửa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
   	        return;
   	    }
   	  
       String maSV2 = masv_2.getText();
       String diem44 = diem4.getText().trim();
       float diem4= Float.parseFloat(diem44);
       String diem100 = diem10.getText().trim();
       float diem10 = Float.parseFloat(diem100);
       String xeploaii = xeploai.getText().trim();

       // Gọi phương thức sửa sinh viên từ lớp Controller
       Sinhvienmodel1 student = new Sinhvienmodel1(maSV2, diem4, diem10, xeploaii);
       studentController.updateStudent2(student);

       // Cập nhật lại bảng thông tin sinh viên
       capNhatBangSinhVien2();
   }

    private void capNhatBangSinhVien2() {
        List<Sinhvienmodel1> danhSachSV = studentController.getDanhSachSinhVien2();
        DefaultTableModel model = (DefaultTableModel) table2.getModel();
        model.setRowCount(0);
        for (Sinhvienmodel1 sinhVien : danhSachSV) {
            Object[] row = { sinhVien.getMasv(), sinhVien.getDiemhe4(), sinhVien.getDiemhe10(), sinhVien.getXeploai() };
            model.addRow(row);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //sự kiện của bảng học phí
	ListSelectionListener selectionListener = new ListSelectionListener() {
	    @Override
	    public void valueChanged(ListSelectionEvent e) {
	        if (!e.getValueIsAdjusting()) { // Kiểm tra xem sự kiện có phải do người dùng thực hiện chọn hàng hay không
	            int selectedIndex = table1.getSelectedRow();
	            if (selectedIndex != -1) { // Đảm bảo có hàng được chọn trong bảng
	                // Lấy thông tin từ hàng đã chọn trong bảng
	                String maSV = table1.getValueAt(selectedIndex, 0).toString();
	                String ten = table1.getValueAt(selectedIndex, 1).toString();
	                String hocphiStr = table1.getValueAt(selectedIndex, 2).toString();
	                String nophocphi = table1.getValueAt(selectedIndex, 3).toString();

	                // Đẩy thông tin lên các trường văn bản tương ứng
	                masv_n.setText(maSV);
	                tensv_n.setText(ten);
	                hocphi.setText(hocphiStr);
	                trangthai_n.setText(nophocphi);
	            }
	        }
	    }
	};
	
//	sự kiện bảng thông tin
	ListSelectionListener selectionListenerInFor = new ListSelectionListener() {
	    @Override
	    public void valueChanged(ListSelectionEvent e) {
	        if (!e.getValueIsAdjusting()) { // Kiểm tra xem sự kiện có phải do người dùng thực hiện chọn hàng hay không
	            int selectedIndex = table.getSelectedRow();
	            if (selectedIndex != -1) { // Đảm bảo có hàng được chọn trong bảng
	                // Lấy thông tin từ hàng đã chọn trong bảng
	                String maSV = table.getValueAt(selectedIndex, 0).toString();
	                String ten = table.getValueAt(selectedIndex, 1).toString();
	                String lop1 = table.getValueAt(selectedIndex, 2).toString();
	                String diachii = table.getValueAt(selectedIndex, 3).toString();

	                // Đẩy thông tin lên các trường văn bản tương ứng
	                masv1.setText(maSV);
	                tensv.setText(ten);
	                lop.setText(lop1);
	                diachi.setText(diachii);
	            }
	        }
	    }
	};
	
	
//	sự kiện bảng diem so
	ListSelectionListener selectionListenerdiemso = new ListSelectionListener() {
	    @Override
	    public void valueChanged(ListSelectionEvent e) {
	        if (!e.getValueIsAdjusting()) { // Kiểm tra xem sự kiện có phải do người dùng thực hiện chọn hàng hay không
	            int selectedIndex = table2.getSelectedRow();
	            if (selectedIndex != -1) { // Đảm bảo có hàng được chọn trong bảng
	                // Lấy thông tin từ hàng đã chọn trong bảng
	                String maSV2 = table2.getValueAt(selectedIndex, 0).toString();
	                String diem44 = table2.getValueAt(selectedIndex, 1).toString();
	                String diem100 = table2.getValueAt(selectedIndex, 2).toString();
	                String xeploaii = table2.getValueAt(selectedIndex, 3).toString();

	                // Đẩy thông tin lên các trường văn bản tương ứng
	                masv_2.setText(maSV2);
	                diem4.setText(diem44);
	                diem10.setText(diem100);
	                xeploai.setText(xeploaii);
	            }
	        }
	    }
	};
}
