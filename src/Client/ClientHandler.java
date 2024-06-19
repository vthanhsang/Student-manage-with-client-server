package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import ClientView.Connect;
import ClientView.ConnectRegister;
import Server.Sinhvienmodel1;
import ServerView.ViewGV;
import ServerView.ViewSinhVien;

public class ClientHandler extends Thread {
    private Socket socket;
    private ViewSinhVien viewSinhVien;
    public ClientHandler(Socket socket) {
        this.socket = socket;
    }
    
    public ClientHandler(Socket socket, ViewSinhVien viewSinhVien) {
        this.socket = socket;
        this.viewSinhVien = viewSinhVien;
    }
    public Socket getSocket() {
        return socket;
    }
    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Vòng lặp để liên tục đọc yêu cầu từ client
            while (true) {
                String request = in.readLine();
                if (request == null) {
                    break;
                }

                String[] requestData = request.split(",");
                String command = requestData[0];

                if (command.equals("congketnoi")) {
                    if (requestData.length >= 2) {
                        int clientPort = Integer.parseInt(requestData[1]);
                        connectToClient(clientPort);
                    }
                } else if (command.equals("request-login-sinhvien")) {
                    if (requestData.length >= 3) {
                        String account = requestData[1];
                        String password = requestData[2];

                        boolean isValidLogin = validateLoginSinhviena(account, password);
                        if (isValidLogin) {
                            out.println("Đăng nhập thành công");
                        } else {
                            out.println("Đăng nhập thất bại");
                        }
                    } else {
                        out.println("Đăng nhập thất bại");
                    }
                } else if (command.equals("register-sinhvien")) {
                    if (requestData.length >= 3) {
                        String account = requestData[1];
                        String password = requestData[2];
                        boolean isSuccess = registerAccountSinhvien(account, password);
                        if (isSuccess) {
                            out.println("Đăng ký thành công");
                        } else {
                            out.println("Đăng ký thất bại");
                        }
                    } else {
                        out.println("Đăng ký thất bại");
                    }
                }else 
                	if (command.equals("sua")) {
                	    if (requestData.length >= 6) {
                	    	String clientIP=requestData[1];
                	        String maSv = requestData[2];
                	        String tenSv = requestData[3];
                	        String lop = requestData[4];
                	        String diaChi = requestData[5];
                	        insertChinhsuaRequest(clientIP, maSv, tenSv, lop, diaChi);

                	        out.println("Yêu cầu sửa thành công");
                	    } else {
                	        out.println("Yêu cầu sửa thất bại");
                	    }
                	}
                	else if(command.equals("xoayeucau")) {
                		out.println("Server đã chấp nhận yêu cầu");
                	}
                	else
                		if (command.equals("send-message")) {
                        if (requestData.length >= 2) {
                            String message = requestData[1];
                            // Append the received message to the textArea
                            viewSinhVien.appendMessage(message);
                        }
                    }

            }

            // Đóng kết nối với client
            socket.close();
            System.out.println("Client disconnected: " + socket.getInetAddress().getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    private void receivertext(String text) {
    	
    }
    
    
    
    private void connectToClient(int clientPort) {
        try {
            // Tạo một socket mới để kết nối đến client với địa chỉ IP và số cổng được chỉ định
            Socket clientSocket = new Socket("localhost", clientPort);

            ClientHandler clientHandler = new ClientHandler(clientSocket);
            // Tạo để xử lý kết nối với client
            clientHandler.start();
            System.out.println("Connected to client: " + clientSocket.getInetAddress().getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insertChinhsuaRequest(String clientIP, String maSv, String tenSv, String lop, String diaChi) {
        String query = "INSERT INTO chinhsua (client, ma_sv, tensv, lop, diachi) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection con = Connect.getconnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, clientIP);
            statement.setString(2, maSv);
            statement.setString(3, tenSv);
            statement.setString(4, lop);
            statement.setString(5, diaChi);
           statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean validateLoginSinhviena(String account, String password) {

        String hashedPasswordInput = EnCryption.hashPassword(password);

        String query = "SELECT * FROM accountsv WHERE taikhoan=? AND bam=?";

        try {
            Connection con = ConnectRegister.getconnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, account);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                // Hiển thị dialog thông báo đăng nhập thành công
                JOptionPane.showMessageDialog(null, "Đăng Nhập Thành Công");
                // Đăng nhập thành công, hiển thị giao diện chính
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                    	
                        ViewSinhVien mainJFrame = new ViewSinhVien();
                        mainJFrame.setVisible(true);
                    }
                });
                return true;
            } else {

                // Đăng nhập thất bại, hiển thị thông báo lỗi
                JOptionPane.showMessageDialog(null,
                        "Tên tài khoản hoặc mật khẩu không đúng! Vui lòng kiểm tra lại!");
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Đăng nhập thất bại! Vui lòng kiểm tra lại!");
        }

        return false;
    }

    private boolean registerAccountSinhvien(String account, String password) {
        try {
            // Hash the password
            String hashedPassword = EnCryption.hashPassword(password);
            String sql = "INSERT INTO accountsv (taikhoan, bam, matkhau) VALUES (?, ?, ?)";

            // Create a PreparedStatement
            Connection con = ConnectRegister.getconnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, account);
            preparedStatement.setString(2, hashedPassword);
            preparedStatement.setString(3, password);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            JOptionPane.showMessageDialog(null, "Đăng ký thành công");
            return true; // Return true if registration is successful

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void sendRequest(String request) {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
