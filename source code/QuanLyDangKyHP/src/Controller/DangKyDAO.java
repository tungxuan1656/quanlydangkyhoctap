package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.DangKy;

public class DangKyDAO extends SubjectDAO {

	public ArrayList<DangKy> getListDK(){
        ArrayList<DangKy> listdk = new ArrayList<>();
        String selectDK = "SELECT SinhVien.mssv, tensv, LopHoc.malop, mahp, tenhp, tinchi, tiet, thu, phonghoc " + 
        		"FROM SinhVien, DangKy, LopHoc " + 
        		"WHERE SinhVien.mssv LIKE DangKy.mssv and LopHoc.malop LIKE DangKy.malop";
        
        try {
            PreparedStatement ps = conn.prepareStatement(selectDK);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            	DangKy d = new DangKy();
                d.setMssv(rs.getString("mssv"));
                d.setTensv(rs.getString("tensv"));
                d.setMalop(rs.getString("malop"));
                d.setMahp(rs.getString("mahp"));
                d.setTenhp(rs.getString("tenhp"));
                d.setTin(rs.getInt("tinchi"));
                d.setTiet(rs.getString("tiet"));
                d.setThu(rs.getString("thu"));
                d.setPhonghoc(rs.getString("phonghoc"));
                
                listdk.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listdk;
    }
	
	public ArrayList<DangKy> searchListDK(String mssv, String malop) {
        ArrayList<DangKy> searchdk = new ArrayList<>();
        String searchLH = "SELECT SinhVien.mssv, tensv, LopHoc.malop, mahp, tenhp, tinchi, tiet, thu, phonghoc "
        		+ "FROM SinhVien, DangKy, LopHoc "
        		+ "WHERE SinhVien.mssv LIKE DangKy.mssv AND LopHoc.malop LIKE DangKy.malop AND "
        				+ "LopHoc.malop LIKE N\'%" + malop + "%\' AND "
        				+ "SinhVien.mssv LIKE N\'%" + mssv + "%\'";
        
        try {
            PreparedStatement ps = conn.prepareStatement(searchLH);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            	DangKy d = new DangKy();
                d.setMssv(rs.getString("mssv"));
                d.setTensv(rs.getString("tensv"));
                d.setMalop(rs.getString("malop"));
                d.setMahp(rs.getString("mahp"));
                d.setTenhp(rs.getString("tenhp"));
                d.setTin(rs.getInt("tinchi"));
                d.setTiet(rs.getString("tiet"));
                d.setThu(rs.getString("thu"));
                d.setPhonghoc(rs.getString("phonghoc"));
                
                searchdk.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return searchdk;
    }
	
	public boolean checkDangKy(String mssv, String malop, ArrayList<DangKy> listdk) {
		for (DangKy dk: listdk) {
			if (dk.getMssv().equals(mssv) && dk.getMalop().equals(malop)) return false;
		}
		return true;
	}
	
	public boolean addDangKy(String mssv, String malop){
        
        String addDK = "INSERT INTO DangKy(mssv, malop) "
                + "VALUES(?,?)";
        
        try {
            PreparedStatement ps = conn.prepareStatement(addDK);
            ps.setString(1, mssv);
            ps.setString(2, malop);
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
	}
	
	public boolean deleteDangKy(String mssv, String malop) {
		String deleteDK = "DELETE FROM DangKy WHERE mssv LIKE N\'" + mssv + "\' AND malop LIKE N\'" + malop + "\'";
		try {
			PreparedStatement ps = conn.prepareStatement(deleteDK);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
