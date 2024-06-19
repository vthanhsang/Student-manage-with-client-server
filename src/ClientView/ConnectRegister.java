package ClientView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectRegister {
    public static void main(String[] args) {
    	getconnection();
      
}
    public static Connection getconnection() {
    
          Connection conn = null;

          try {
              // Bước 1: Đăng ký JDBC driver
              Class.forName("com.mysql.jdbc.Driver");
              System.out.println("Đang kết nối đến cơ sở dữ liệu...");
              conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root",null);

             
              
              System.out.println("Đã đóng kết nối đến cơ sở dữ liệu.");
          } catch (SQLException se) {
              //
              se.printStackTrace();
          } catch (Exception e) {
              // Xử lý lỗi Class.forName()
              e.printStackTrace();
          } 
          
		return conn;
      }
   
    }

