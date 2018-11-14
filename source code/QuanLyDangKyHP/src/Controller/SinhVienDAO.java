package Controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.SinhVien;

public class SinhVienDAO extends SubjectDAO {
	
	//SinhVien
	public ArrayList<SinhVien> getListSV(){
        ArrayList<SinhVien> listsv = new ArrayList<>();
        String selectSV = "SELECT * FROM SinhVien";
        
        try {
            PreparedStatement ps = conn.prepareStatement(selectSV);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SinhVien s = new SinhVien();
                s.setMssv(rs.getString("mssv"));
                s.setTensv(rs.getString("tensv"));
                s.setNgaysinh(rs.getDate("ngaysinh"));
                s.setKhoa(rs.getString("khoa"));
                s.setLop(rs.getString("lop"));
                s.setThanhpho(rs.getString("thanhpho"));
                
                listsv.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listsv;
    }
	
	public ArrayList<SinhVien> searchListSV(String mssv, String tensv, String khoa, String lop, String thanhpho) {
        ArrayList<SinhVien> searchsv = new ArrayList<>();
        String searchSV = "SELECT * FROM SinhVien "
        		+ "WHERE mssv LIKE N\'%" + mssv + "%\' AND "
        				+ "tensv LIKE N\'%" + tensv + "%\' AND "
        						+ "khoa LIKE N\'%" + khoa + "%\' AND "
        								+ "lop LIKE N\'%" + lop + "%\' AND "
        										+ "thanhpho LIKE N\'%" + thanhpho + "%\' ";
        
        try {
            PreparedStatement ps = conn.prepareStatement(searchSV);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SinhVien s = new SinhVien();
                s.setMssv(rs.getString("mssv"));
                s.setTensv(rs.getString("tensv"));
                s.setNgaysinh(rs.getDate("ngaysinh"));
                s.setKhoa(rs.getString("khoa"));
                s.setLop(rs.getString("lop"));
                s.setThanhpho(rs.getString("thanhpho"));
                
                searchsv.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return searchsv;
    }
	
	public boolean addSinhVien(SinhVien s){
        
        String addSV = "INSERT INTO SinhVien(mssv, tensv, ngaysinh, khoa, lop, thanhpho) "
                + "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(addSV);
            ps.setString(1, s.getMssv());
            ps.setString(2, s.getTensv());
            ps.setDate(3, new Date(s.getNgaysinh().getTime()));
            ps.setString(4, s.getKhoa());
            ps.setString(5, s.getLop());
            ps.setString(6, s.getThanhpho());
            
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
	
	public boolean deleteSinhVien(String mssv) {
		String deleteSV = "DELETE FROM SinhVien WHERE mssv LIKE N\'" + mssv + "\'";
		try {
			PreparedStatement ps = conn.prepareStatement(deleteSV);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
    public static void main(String[] args) {
        for (SinhVien sv: new SinhVienDAO().getListSV()) {
        	System.out.println(sv.getNgaysinh());
        }
    }

}
