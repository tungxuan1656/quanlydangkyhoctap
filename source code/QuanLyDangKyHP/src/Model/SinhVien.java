package Model;

import java.util.Date;

public class SinhVien {
	private String tensv, mssv, khoa, lop, thanhpho;
	private Date ngaysinh;
	public String getTensv() {
		return tensv;
	}
	public void setTensv(String tensv) {
		this.tensv = tensv;
	}
	public String getMssv() {
		return mssv;
	}
	public void setMssv(String mssv) {
		this.mssv = mssv;
	}
	public String getKhoa() {
		return khoa;
	}
	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public String getThanhpho() {
		return thanhpho;
	}
	public void setThanhpho(String thanhpho) {
		this.thanhpho = thanhpho;
	}
	public java.util.Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(java.util.Date date) {
		this.ngaysinh = date;
	}
	
}
