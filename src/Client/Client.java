package Client;

import java.io.*;
import java.net.Socket;

import ClientView.Login;

public class Client {
    private static Login loginView;
    private static Socket socket;
    private static ClientHandler socketHandler;
    private static int portNumber = 0;
    
    public static void setPortNumber(int port) {
        portNumber = port;
    }
    
    public void initView() {
    	
        loginView = new Login();
        loginView.setVisible(true);
        loginView.setClient(this);
        try {
        	
			socket = new Socket("localhost", portNumber);
        	socketHandler = new ClientHandler(socket);
        	new Thread(socketHandler).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    
    public static  void processLogin1(String account, String password) {
        // Gửi yêu cầu đăng nhập tới server
        try {
			if (socketHandler != null) {
			    String requestData = account ;
			     String hashedPassword = EnCryption.hashPassword(password);
			    String request = "request-login-sinhvien," + account + "," +hashedPassword;
			    socketHandler.sendRequest(request);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    
    public static void processRegister1(String account, String password) {
        // Gửi yêu cầu đăng ký tới server
        if (socketHandler != null) {
            socketHandler.sendRequest("register-sinhvien"+ "," + account + "," + password);
        }
    }
    
    public static void yeucausua(String clientIP, String masv,String tensv, String lopsv,String diachisv) {
    	if (socketHandler != null) {
            socketHandler.sendRequest("sua" + "," + clientIP + "," + masv + "," + tensv + "," + lopsv + "," + diachisv);
        }
    }
    
    public static void nhancongport(int port) {
    	if (socketHandler != null) {
            socketHandler.sendRequest("congketnoi"+ "," + port );
        }
    	
    	
    }	
    public void connectToServer() {
        try {
            socket = new Socket("localhost", portNumber);
            socketHandler = new ClientHandler(socket);
            new Thread(socketHandler).start();
            System.out.println("Connected to server: " + socket.getInetAddress().getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void sendNotifi() {
        if (socketHandler != null) {
            socketHandler.sendRequest("xoayeucau");
        }
    }
    public static void sendMessage(String message) {
        if (socketHandler != null) {
            socketHandler.sendRequest("send-message," + message);
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        loginView = new Login();
        loginView.setClient(client); 
        client.setPortNumber(portNumber);
        client.initView();
       
    }
}
