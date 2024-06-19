package Server;

import java.sql.Date;
import java.sql.Time;

public class Sinhvienmodel1 {
	
String client;
String masv;
String ten;
String lop;
String diachi;
float diemhe4;
float diemhe10;
String xeploai;
int hocphi;
String nophocphi;
String trangthai;
/**
 * @param masv
 * @param ten
 * @param lop
 * @param diachi
 * @param diemhe4
 * @param diemhe10
 * @param xeploai
 *  * @param hocphi
 * @param nophocphi

 */
public Sinhvienmodel1(String masv, String ten, String lop, String diachi, float diemhe4, float diemhe10, String xeploai, int hocphi, String nophocphi) {
	super();
	this.masv = masv;
	this.ten = ten;
	this.lop = lop;
	this.diachi = diachi;
	this.diemhe4 = diemhe4;
	this.diemhe10 = diemhe10;
	this.xeploai = xeploai;
	this.hocphi= hocphi;
	this.nophocphi=nophocphi;
	
}


/**
 * @param masv
 * @param diemhe4
 * @param diemhe10
 * @param xeploai
 */
public Sinhvienmodel1(String masv, float diemhe4, float diemhe10, String xeploai) {
	super();
	this.masv = masv;
	this.diemhe4 = diemhe4;
	this.diemhe10 = diemhe10;
	this.xeploai = xeploai;
}




/**
 * @param client
 * @param masv
 * @param ten
 * @param lop
 * @param diachi
 */
public Sinhvienmodel1(String client, String masv, String ten, String lop, String diachi) {
	super();
	this.client = client;
	this.masv = masv;
	this.ten = ten;
	this.lop = lop;
	this.diachi = diachi;
}


/**
 * @param masv
 * @param ten
 * @param hocphi
 * @param nophocphi
 */
public Sinhvienmodel1(String masv, String ten, int hocphi, String nophocphi) {
	super();
	this.masv = masv;
	this.ten = ten;
	this.hocphi = hocphi;
	this.nophocphi = nophocphi;
}


/**
	 * @param masv
	 * @param ten
	 * @param lop
	 * @param diachi
 * @return 
	 */
	public  Sinhvienmodel1(String masv, String ten, String lop, String diachi) {
		super();
		this.masv = masv;
		this.ten = ten;
		this.lop = lop;
		this.diachi = diachi;
	}
	
/**
 * @param masv
 * @param diemhe4
 * @param diemhe10
 * @param xeploai
 */



public String getMasv() {
	return masv;
}
/**
 * @param masv
 * @param ten
 * @param diemhe10
 * @param xeploai
 * @param hocphi
 * @param nophocphi
 */
public Sinhvienmodel1(String masv, String ten, float diemhe10, String xeploai, int hocphi, String nophocphi) {
	super();
	this.masv = masv;
	this.ten = ten;
	this.diemhe10 = diemhe10;
	this.xeploai = xeploai;
	this.hocphi = hocphi;
	this.nophocphi = nophocphi;
}


/**
 * @param client
 * @param masv
 * @param ten
 * @param lop
 * @param diachi
 * @param trangthai
 */
public Sinhvienmodel1(String client, String masv, String ten, String lop, String diachi, String trangthai) {
	super();
	this.client = client;
	this.masv = masv;
	this.ten = ten;
	this.lop = lop;
	this.diachi = diachi;
	this.trangthai = trangthai;
}


public String getClient() {
	return client;
}


public void setClient(String client) {
	this.client = client;
}


public void setMasv(String masv) {
	this.masv = masv;
}
public String getTen() {
	return ten;
}
public void setTen(String ten) {
	this.ten = ten;
}
public String getLop() {
	return lop;
}
public void setLop(String lop) {
	this.lop = lop;
}
public String getDiachi() {
	return diachi;
}
public void setDiachi(String diachi) {
	this.diachi = diachi;
}
public float getDiemhe4() {
	return diemhe4;
}
public void setDiemhe4(float diemhe4) {
	this.diemhe4 = diemhe4;
}
public float getDiemhe10() {
	return diemhe10;
}
public void setDiemhe10(float diemhe10) {
	this.diemhe10 = diemhe10;
}
public String getXeploai() {
	return xeploai;
}
public void setXeploai(String xeploai) {
	this.xeploai = xeploai;
}



public String getTrangthai() {
	return trangthai;
}


public void setTrangthai(String trangthai) {
	this.trangthai = trangthai;
}


public int getHocphi() {
	return hocphi;
}


public void setHocphi(int hocphi) {
	this.hocphi = hocphi;
}


public String getNophocphi() {
	return nophocphi;
}


public void setNophocphi(String nophocphi) {
	this.nophocphi = nophocphi;
}

	
	
}
