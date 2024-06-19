package Server;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        // Tạo JLabel chứa ảnh làm nền
        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Pictures\\Saved Pictures\\pexels-photo-2820819.jpeg"); // Thay thế đường dẫn tới ảnh của bạn ở đây
        JLabel backgroundLabel = new JLabel(backgroundIcon);

        // Tạo JPanel và đặt LayoutManager
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(backgroundLabel, BorderLayout.CENTER);

        // Đặt panel làm nền cho JFrame
        setContentPane(panel);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\OneDrive\\Pictures\\Ảnh chụp màn hình\\Screenshot 2023-04-01 180447.png"));
        panel.add(lblNewLabel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyFrame frame = new MyFrame();
            frame.setVisible(true);
        });
    }
}
