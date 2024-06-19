package Server;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ClientView.Connect;
public class Sinhviencontroller1 {
	private Connection connection;
	 public Sinhviencontroller1() {
	        try {
	            // Thiết lập kết nối đến cơ sở dữ liệu
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlisinhvien", "root", null);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 
	 
	 /////////////////////////////////////////////////////////////
	 public void insertChinhsuaRequest(Sinhvienmodel1 student) {
	        String query = "INSERT INTO chinhsua (client, ma_sv, tensv, lop, diachi, trangthai) VALUES (?, ?, ?, ?, ?, ?)";

	        try {
	            Connection con = Connect.getconnection();
	            PreparedStatement statement = con.prepareStatement(query);
	            statement.setString(1, student.getClient());
	            statement.setString(2, student.getMasv());
	            statement.setString(3, student.getTen());
	            statement.setString(4, student.getLop());
	            statement.setString(5, student.getDiachi());
	            statement.setString(6, "Cap Nhap");
	           statement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	    
	    public List<Sinhvienmodel1> getDanhSachSinhVien() {
	        List<Sinhvienmodel1> danhSachSV = new ArrayList<>();

	        try {
	            // Tạo câu truy vấn SQL để lấy danh sách sinh viên từ bảng
	            String query = "SELECT * FROM chinhsua";
	            Statement statement = connection.createStatement();

	            // Thực hiện câu truy vấn
	            ResultSet resultSet = statement.executeQuery(query);

	            // Lặp qua kết quả và tạo đối tượng sinh viên từ mỗi dòng
	            while (resultSet.next()) {
	                Sinhvienmodel1 student = new Sinhvienmodel1(
	                    resultSet.getString("client"),
	                    resultSet.getString("ma_sv"),
	                    resultSet.getString("tensv"),
	                    resultSet.getString("lop"),
	                    resultSet.getString("diachi"),
	                    "Cập nhật" // Đặt giá trị trạng thái "Cập nhật"
	                );

	                danhSachSV.add(student);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return danhSachSV;
	    }

	 
	 
	 public void insertChinhsuaRequest1(Sinhvienmodel1 student) {
	        String query = "INSERT INTO chinhsua (client, ma_sv, tensv, lop, diachi, trangthai) VALUES (?, ?, ?, ?, ?, ?)";

	        try {
	            Connection con = Connect.getconnection();
	            PreparedStatement statement = con.prepareStatement(query);
	            statement.setString(1, student.getClient());
	            statement.setString(2, student.getMasv());
	            statement.setString(3, student.getTen());
	            statement.setString(4, student.getLop());
	            statement.setString(5, student.getDiachi());
	            statement.setString(6, "Thêm");
	           statement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	   public List<Sinhvienmodel1> getDanhSachSinhVienthem() {
	        List<Sinhvienmodel1> danhSachSV = new ArrayList<>();

	        try {
	            // Tạo câu truy vấn SQL để lấy danh sách sinh viên từ bảng
	            String query = "SELECT * FROM chinhsua";
	            Statement statement = Connect.getconnection().createStatement();

	            // Thực hiện câu truy vấn
	            ResultSet resultSet = statement.executeQuery(query);

	            // Lặp qua kết quả và tạo đối tượng sinh viên từ mỗi dòng
	            while (resultSet.next()) {
	                Sinhvienmodel1 student = new Sinhvienmodel1(
	                    resultSet.getString("client"),
	                    resultSet.getString("ma_sv"),
	                    resultSet.getString("tensv"),
	                    resultSet.getString("lop"),
	                    resultSet.getString("diachi"),
	                    "Thêm" // Đặt giá trị trạng thái "Cập nhật"
	                );

	                danhSachSV.add(student);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return danhSachSV;
	    }
	 
	 
	
	 
	  public void deleteStudentt(String maSV) {
	        try {
	            // Tạo câu truy vấn SQL để xóa sinh viên từ bảng
	            String query = "DELETE FROM chinhsua WHERE ma_sv = ?";
	            PreparedStatement statement = Connect.getconnection().prepareStatement(query);
	            statement.setString(2, maSV);
	            // Thực hiện câu truy vấn
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    } 
	  
/////////////////////////////////////////////////////////////////////
	 public void addStudent1(Sinhvienmodel1 student) {
	        try {
	            // Tạo câu truy vấn SQL để thêm sinh viên vào bảng
	            String query = "INSERT INTO inforsv (ma_sv, ten_sv, lop_sv, dia_chi) VALUES (?, ?, ?, ?)";
	            PreparedStatement statement = connection.prepareStatement(query);
	            statement.setString(1, student.getMasv());
	            statement.setString(2, student.getTen());
	            statement.setString(3, student.getLop());
	            statement.setString(4, student.getDiachi());

	            // Thực hiện câu truy vấn
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 public void updateStudent1(Sinhvienmodel1 student) {
	        try {
	            // Tạo câu truy vấn SQL để cập nhật thông tin sinh viên trong bảng
	            String query = "UPDATE inforsv SET ten_sv = ?, lop_sv = ?, dia_chi = ? WHERE ma_sv = ?";
	            PreparedStatement statement = connection.prepareStatement(query);
	            statement.setString(1, student.getTen());
	            statement.setString(2, student.getLop());
	            statement.setString(3, student.getDiachi());
	            statement.setString(4, student.getMasv());

	            // Thực hiện câu truy vấn
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void deleteStudent1(String maSV) {
	        try {
	            // Tạo câu truy vấn SQL để xóa sinh viên từ bảng
	            String query = "DELETE FROM inforsv WHERE ma_sv = ?";
	            PreparedStatement statement = connection.prepareStatement(query);
	            statement.setString(1, maSV);

	            // Thực hiện câu truy vấn
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public List<Sinhvienmodel1> getDanhSachSinhVien1() {
	        List<Sinhvienmodel1> danhSachSV = new ArrayList<>();

	        try {
	            // Tạo câu truy vấn SQL để lấy danh sách sinh viên từ bảng
	            String query = "SELECT * FROM inforsv";
	            Statement statement = connection.createStatement();

	            // Thực hiện câu truy vấn
	            ResultSet resultSet = statement.executeQuery(query);

	            // Lặp qua kết quả và tạo đối tượng sinh viên từ mỗi dòng
	            while (resultSet.next()) {
	            	Sinhvienmodel1 student = new Sinhvienmodel1(query, query, query, query);
	                student.setMasv(resultSet.getString("ma_sv"));
	                student.setTen(resultSet.getString("ten_sv"));
	                student.setLop(resultSet.getString("lop_sv"));
	                student.setDiachi(resultSet.getString("dia_chi"));

	                danhSachSV.add(student);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return danhSachSV;
	    }
//	    
//	    
//	table diemso    
//	    
	    public void addStudent2(Sinhvienmodel1 student) {
	        try {
	            // Tạo câu truy vấn SQL để thêm sinh viên vào bảng
	            String query = "INSERT INTO diemsv (ma_sv, diemgpa, diemheso10, xeploai) VALUES (?, ?, ?, ?)";
	            PreparedStatement statement = connection.prepareStatement(query);
	            statement.setString(1, student.getMasv());
	            statement.setFloat(2, student.getDiemhe4());
	            statement.setFloat(3, student.getDiemhe10());
	            statement.setString(4, student.getXeploai());

	            // Thực hiện câu truy vấn
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 public void updateStudent2(Sinhvienmodel1 student) {
	        try {
	            // Tạo câu truy vấn SQL để cập nhật thông tin sinh viên trong bảng
	            String query = "UPDATE diemsv SET diemgpa = ?, diemheso10 = ?, xeploai = ? WHERE ma_sv = ?";
	            PreparedStatement statement = connection.prepareStatement(query);
	            statement.setFloat(1, student.getDiemhe4());
	            statement.setFloat(2, student.getDiemhe10());
	            statement.setString(3, student.getXeploai());
	            statement.setString(4, student.getMasv());

	            // Thực hiện câu truy vấn
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void deleteStudent2(String maSV) {
	        try {
	            // Tạo câu truy vấn SQL để xóa sinh viên từ bảng
	            String query = "DELETE FROM diemsv WHERE ma_sv = ?";
	            PreparedStatement statement = connection.prepareStatement(query);
	            statement.setString(1, maSV);

	            // Thực hiện câu truy vấn
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public List<Sinhvienmodel1> getDanhSachSinhVien2() {
	        List<Sinhvienmodel1> danhSachSV = new ArrayList<>();

	        try {
	            // Tạo câu truy vấn SQL để lấy danh sách sinh viên từ bảng
	            String query = "SELECT * FROM diemsv";
	            Statement statement = connection.createStatement();

	            // Thực hiện câu truy vấn
	            ResultSet resultSet = statement.executeQuery(query);

	            // Lặp qua kết quả và tạo đối tượng sinh viên từ mỗi dòng
	            while (resultSet.next()) {
	            	Sinhvienmodel1 student = new Sinhvienmodel1(query, resultSet.getFloat("diemgpa"), resultSet.getFloat("diemheso10"), query);
	                student.setMasv(resultSet.getString("ma_sv"));
	                student.setDiemhe4(resultSet.getFloat("diemgpa"));
	                student.setDiemhe10(resultSet.getFloat("diemheso10"));
	                student.setXeploai(resultSet.getString("xeploai"));

	                danhSachSV.add(student);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return danhSachSV;
	    }
	    
	    
	  
	
	    
	    //table  hocphis
	    public void addStudent3(Sinhvienmodel1 student) {
	        try {
	            // Tạo câu truy vấn SQL để thêm sinh viên vào bảng
	            String query = "INSERT INTO hocphi (ma_sv, ten_sv, hocphi, nophocphi) VALUES (?, ?, ?, ?)";
	            PreparedStatement statement = connection.prepareStatement(query);
	            statement.setString(1, student.getMasv());
	            statement.setString(2, student.getTen());
	            statement.setInt(3, student.getHocphi());
	            statement.setString(4, student.getNophocphi());

	            // Thực hiện câu truy vấn
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 public void updateStudent3(Sinhvienmodel1 student) {
	        try {
	            // Tạo câu truy vấn SQL để cập nhật thông tin sinh viên trong bảng
	            String query = "UPDATE hocphi SET ten_sv = ?, hocphi = ?, nophocphi = ? WHERE ma_sv = ?";
	            PreparedStatement statement = connection.prepareStatement(query);
	            statement.setString(1, student.getTen());
	            statement.setInt(2, student.getHocphi());
	            statement.setString(3, student.getNophocphi());
	           
	            statement.setString(4, student.getMasv());

	            // Thực hiện câu truy vấn
	            
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public void deleteStudent3(String maSV) {
	        try {
	            // Tạo câu truy vấn SQL để xóa sinh viên từ bảng
	            String query = "DELETE FROM hocphi WHERE ma_sv = ?";
	            PreparedStatement statement = connection.prepareStatement(query);
	            statement.setString(1, maSV);

	            // Thực hiện câu truy vấn
	            statement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public List<Sinhvienmodel1> getDanhSachSinhVien3() {
	        List<Sinhvienmodel1> danhSachSV2 = new ArrayList<>();

	        try {
	            // Tạo câu truy vấn SQL để lấy danh sách sinh viên từ bảng
	            String query = "SELECT * FROM hocphi";
	            Statement statement = connection.createStatement();

	            // Thực hiện câu truy vấn
	            ResultSet resultSet = statement.executeQuery(query);

	            // Lặp qua kết quả và tạo đối tượng sinh viên từ mỗi dòng
	            while (resultSet.next()) {
	            	Sinhvienmodel1 student = new Sinhvienmodel1(query, query, resultSet.getInt("hocphi"), query);
	                student.setMasv(resultSet.getString("ma_sv"));
	                student.setTen(resultSet.getString("ten_sv"));
	                student.setHocphi(resultSet.getInt("hocphi"));
	                student.setNophocphi(resultSet.getString("nophocphi"));

	                danhSachSV2.add(student);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return danhSachSV2;
	    }
	    
	    
	    
	  
	    
	    //table sinhvien class sinh vien
	    public List<Sinhvienmodel1> getDanhSachSinhVienn() {
	        List<Sinhvienmodel1> danhSachSVn = new ArrayList<>();

	        try {
	            // Tạo câu truy vấn SQL để lấy danh sách sinh viên từ bảng
	            String query = "SELECT * FROM sinhvien";
	            Statement statement = connection.createStatement();

	            // Thực hiện câu truy vấn
	            ResultSet resultSet = statement.executeQuery(query);

	            // Lặp qua kết quả và tạo đối tượng sinh viên từ mỗi dòng
	            while (resultSet.next()) {
	            	Sinhvienmodel1 student = new Sinhvienmodel1(query, query, resultSet.getFloat("diemheso10"), query, resultSet.getInt("hocphi"), query);
	                student.setMasv(resultSet.getString("ma_sv"));
	                student.setTen(resultSet.getString("ten_sv"));
	                student.setDiemhe10(resultSet.getFloat("diemheso10"));
	                student.setXeploai(resultSet.getString("xeploai"));
	                student.setHocphi(resultSet.getInt("hocphi"));
	                student.setNophocphi(resultSet.getString("nophocphi"));
	                danhSachSVn.add(student);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return danhSachSVn;
	    }
	    

	    
}
