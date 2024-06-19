package ServerView;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class ViewSinhVien extends JFrame {
    private Sinhviencontroller1 studentController;
    private JPanel contentPane;
    private JTable table;
    private JTextField masv;
    private JTextField tensv;
    private JTextField lop;
    private JTextField diachi;
    private JTextField port;
    private JTextField textsend;
    private JTextArea textArea;
    private JLabel lalbelchat;
    private JButton send;
    private JPanel panel;
    private static boolean isChatOn = false;

    public static void main(String[] args) {
    	 
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewSinhVien frame = new ViewSinhVien();
                    frame.setVisible(true);
                    isChatOn = false;
                    frame.hideComponents();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ViewSinhVien() {
    	
    	
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\OneDrive\\Pictures\\Ảnh chụp màn hình\\Screenshot 2023-06-03 220234.png"));
        studentController = new Sinhviencontroller1(); 

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1124, 752);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        //chat
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
        panel.setBounds(577, 122, 521, 411);
        contentPane.add(panel);

        textArea = new JTextArea();
        textArea.setBounds(20, 47, 479, 200);
        panel.add(textArea);

        lalbelchat = new JLabel("Chat");
        lalbelchat.setFont(new Font("Tahoma", Font.BOLD, 20));
        lalbelchat.setBounds(10, 10, 93, 27);
        panel.add(lalbelchat);

        textsend = new JTextField();
        textsend.setColumns(10);
        textsend.setBounds(20, 311, 348, 46);
        panel.add(textsend);

        send = new JButton("Send");
        send.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String text=textsend.getText();
        		Client.Client.sendMessage(text);;
        		textsend.setText("");
        	}
        });
        send.setBounds(394, 315, 105, 37);
        panel.add(send);
        //chat

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new LineBorder(Color.BLACK, 3));
        scrollPane.setBackground(SystemColor.controlDkShadow);
        scrollPane.setBounds(34, 150, 636, 491);
        contentPane.add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
            },
            new String[] {
                "Mã sinh viên", "Tên sinh viên", "Lớp", "Địa chỉ"
            }
        ));
        scrollPane.setViewportView(table);
        table.getSelectionModel().addListSelectionListener(selectionListenerInFor);

        JButton btncapnhat = new JButton("Cập Nhật");
        btncapnhat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                capNhatBangSinhVien();
            }
        });
        btncapnhat.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btncapnhat.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        btncapnhat.setBackground(new Color(255, 127, 80));
        btncapnhat.setBounds(705, 556, 119, 45);
        contentPane.add(btncapnhat);

        JLabel lblNewLabel_1 = new JLabel("Quản Lí Sinh Viên");
        lblNewLabel_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\customer-satisfaction.png"));
        lblNewLabel_1.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 20));
        lblNewLabel_1.setBounds(421, 26, 262, 45);
        contentPane.add(lblNewLabel_1);

        JButton buttondx = new JButton("Đăng Xuất");
        buttondx.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\logout.png"));
        buttondx.setFont(new Font("Tahoma", Font.PLAIN, 16));
        buttondx.setBackground(Color.YELLOW);
        buttondx.setBounds(797, 6, 145, 29);
        contentPane.add(buttondx);

        JButton yeucausua = new JButton("Yêu cầu sửa");
        yeucausua.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                themSinhVien();
                Client.Client.yeucausua(port.getText(),masv.getText(),tensv.getText(),lop.getText(),diachi.getText());
                JOptionPane.showMessageDialog(null, "Yêu cầu sửa đã được gửi");
            }
        });
        yeucausua.setFont(new Font("Tahoma", Font.PLAIN, 20));
        yeucausua.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        yeucausua.setBackground(new Color(255, 127, 80));
        yeucausua.setBounds(896, 556, 125, 45);
        contentPane.add(yeucausua);

        JLabel lblNewLabel = new JLabel("Mã SV:");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(717, 188, 66, 25);
        contentPane.add(lblNewLabel);

        masv = new JTextField();
        masv.setBounds(793, 177, 224, 36);
        contentPane.add(masv);
        masv.setColumns(10);

        JLabel lblTnSv = new JLabel("Tên SV:");
        lblTnSv.setForeground(new Color(255, 255, 255));
        lblTnSv.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTnSv.setBounds(717, 287, 66, 22);
        contentPane.add(lblTnSv);

        JLabel lblLp = new JLabel("Lớp :");
        lblLp.setForeground(new Color(255, 255, 255));
        lblLp.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblLp.setBounds(717, 360, 70, 33);
        contentPane.add(lblLp);

        JLabel lblaCh = new JLabel("Địa chỉ");
        lblaCh.setForeground(new Color(255, 255, 255));
        lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblaCh.setBounds(717, 440, 80, 33);
        contentPane.add(lblaCh);

        tensv = new JTextField();
        tensv.setColumns(10);
        tensv.setBounds(797, 273, 224, 36);
        contentPane.add(tensv);

        lop = new JTextField();
        lop.setColumns(10);
        lop.setBounds(797, 357, 224, 36);
        contentPane.add(lop);

        diachi = new JTextField();
        diachi.setColumns(10);
        diachi.setBounds(797, 437, 224, 36);
        contentPane.add(diachi);

        JLabel lblNewLabel_2 = new JLabel("IP");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(43, 26, 60, 36);
        contentPane.add(lblNewLabel_2);

        port = new JTextField();
        port.setBounds(80, 26, 192, 37);
        contentPane.add(port);
        port.setColumns(10);

        try {
            InetAddress localHost = InetAddress.getLocalHost();
            String ipAddress = localHost.getHostAddress();
            port.setText(ipAddress);

            JButton yeucauthem = new JButton("Yêu cầu thêm");
            yeucauthem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    themSinhVien1();
                    JOptionPane.showMessageDialog(null, "Yêu cầu sửa đã được gửi");
                }
            });
            yeucauthem.setFont(new Font("Tahoma", Font.PLAIN, 18));
            yeucauthem.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
            yeucauthem.setBackground(new Color(255, 127, 80));
            yeucauthem.setBounds(797, 635, 125, 45);
            contentPane.add(yeucauthem);

            JLabel lblNewLabel_3 = new JLabel("New label");
            lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Admin\\OneDrive\\Pictures\\Ảnh chụp màn hình\\Screenshot 2023-07-16 120324.png"));
            lblNewLabel_3.setBounds(0, 81, 1098, 657);
            contentPane.add(lblNewLabel_3);

            JLabel lblNewLabel_4 = new JLabel("USER");
            lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\client.png"));
            lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
            lblNewLabel_4.setBounds(972, 0, 112, 36);
            contentPane.add(lblNewLabel_4);

            JButton chat = new JButton("On chat");
            chat.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    isChatOn = true;
                    hideComponents();
                }
            });
            chat.setFont(new Font("Tahoma", Font.PLAIN, 15));
            chat.setBounds(996, 81, 102, 25);
            contentPane.add(chat);

            JButton OffChat = new JButton("Off chat");
            OffChat.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    isChatOn = false;
                    hideComponents();
                }
            });
            OffChat.setFont(new Font("Tahoma", Font.PLAIN, 15));
            OffChat.setBounds(884, 81, 102, 25);
            contentPane.add(OffChat);
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }

        buttondx.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttondn(e);
            }
        });

        capNhatBangSinhVien();
    }

    private void hideComponents() {
        if (textArea != null) {
            textArea.setVisible(isChatOn);
        }
        if (lalbelchat != null) {
            lalbelchat.setVisible(isChatOn);
        }
        if (textsend != null) {
            textsend.setVisible(isChatOn);
        }
        if (send != null) {
            send.setVisible(isChatOn);
        }
        if (panel != null) {
            panel.setVisible(isChatOn);
        }
    }

    private void themSinhVien() {
        String clientIP = port.getText().trim();
        String maSV = masv.getText().trim();
        String tenSV = tensv.getText().trim();
        String lopSV = lop.getText().trim();
        String diachiSV = diachi.getText().trim();
        String trangthai = "Cập Nhật";

        if (maSV.isEmpty() || tenSV.isEmpty() || lopSV.isEmpty() || diachiSV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Sinhvienmodel1 student = new Sinhvienmodel1(clientIP, maSV, tenSV, lopSV, diachiSV, trangthai);
        student.setClient(clientIP);
        student.setMasv(maSV);
        student.setTen(tenSV);
        student.setLop(lopSV);
        student.setDiachi(diachiSV);
        student.setTrangthai("Cap Nhap");
        Sinhviencontroller1 sinhviencontroller1 = new Sinhviencontroller1();
        sinhviencontroller1.insertChinhsuaRequest(student);

        capNhatBangSinhVien();
    }

    private void themSinhVien1() {
        String clientIP = port.getText().trim();
        String maSV = masv.getText().trim();
        String tenSV = tensv.getText().trim();
        String lopSV = lop.getText().trim();
        String diachiSV = diachi.getText().trim();
        String trangthai = "Thêm";

        if (maSV.isEmpty() || tenSV.isEmpty() || lopSV.isEmpty() || diachiSV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Sinhvienmodel1 student = new Sinhvienmodel1(clientIP, maSV, tenSV, lopSV, diachiSV, trangthai);
        student.setClient(clientIP);
        student.setMasv(maSV);
        student.setTen(tenSV);
        student.setLop(lopSV);
        student.setDiachi(diachiSV);
        student.setTrangthai("Thêm");
        Sinhviencontroller1 sinhviencontroller1 = new Sinhviencontroller1();
        sinhviencontroller1.insertChinhsuaRequest1(student);

        capNhatBangSinhVien();
    }

    ListSelectionListener selectionListenerInFor = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                int selectedIndex = table.getSelectedRow();
                if (selectedIndex != -1) {
                    String maSV = table.getValueAt(selectedIndex, 0).toString();
                    String ten = table.getValueAt(selectedIndex, 1).toString();
                    String lop1 = table.getValueAt(selectedIndex, 2).toString();
                    String diachii = table.getValueAt(selectedIndex, 3).toString();

                    masv.setText(maSV);
                    tensv.setText(ten);
                    lop.setText(lop1);
                    diachi.setText(diachii);
                }
            }
        }
    };

    private void capNhatBangSinhVien() {
        List<Sinhvienmodel1> danhSachSV = studentController.getDanhSachSinhVien1();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (Sinhvienmodel1 sinhVien : danhSachSV) {
            Object[] row = { sinhVien.getMasv(), sinhVien.getTen(), sinhVien.getLop(), sinhVien.getDiachi()};
            model.addRow(row);
        }
    }
    
    public void appendMessage(String message) {
        textArea.append(message + "\n");
    }

    private void buttondn(ActionEvent e) {
        ViewSinhVien.this.dispose();
    }
}
