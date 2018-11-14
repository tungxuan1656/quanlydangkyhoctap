package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Model.LopHoc;

public class LopHocDAO extends SubjectDAO {
	
	public ArrayList<LopHoc> getListLop(){
        ArrayList<LopHoc> listlop = new ArrayList<>();
        String selectLH = "SELECT * FROM LopHoc ORDER BY malop";
        
        try {
            PreparedStatement ps = conn.prepareStatement(selectLH);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                LopHoc lop = new LopHoc();
                lop.setMalop(rs.getString("malop"));
                lop.setMahp(rs.getString("mahp"));
                lop.setTenhp(rs.getString("tenhp"));
                lop.setTinchi(rs.getInt("tinchi"));
                lop.setTiet(rs.getString("tiet"));
                lop.setThu(rs.getString("thu"));
                lop.setPhonghoc(rs.getString("phonghoc"));
                
                listlop.add(lop);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listlop;
    }
	
	public ArrayList<LopHoc> searchListLH(String malop, String tenhp, String mahp) {
        ArrayList<LopHoc> searchlh = new ArrayList<>();
        String searchLH = "SELECT * FROM LopHoc "
        		+ "WHERE malop LIKE N\'%" + malop + "%\' AND "
        				+ "tenhp LIKE N\'%" + tenhp + "%\' AND "
        						+ "mahp LIKE N\'%" + mahp + "%\'";
        
        try {
            PreparedStatement ps = conn.prepareStatement(searchLH);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            	LopHoc lop = new LopHoc();
                lop.setMalop(rs.getString("malop"));
                lop.setMahp(rs.getString("mahp"));
                lop.setTenhp(rs.getString("tenhp"));
                lop.setTinchi(rs.getInt("tinchi"));
                lop.setTiet(rs.getString("tiet"));
                lop.setThu(rs.getString("thu"));
                lop.setPhonghoc(rs.getString("phonghoc"));
                
                searchlh.add(lop);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return searchlh;
    }
	
	public boolean addLopHoc(LopHoc lop){
        
        String addLH = "INSERT INTO LopHoc(malop, tenhp, mahp, tinchi, tiet, thu, phonghoc) "
                + "VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(addLH);
            ps.setString(1, lop.getMalop());
            ps.setString(2, lop.getTenhp());
            ps.setString(3,lop.getMahp());
            ps.setInt(4, lop.getTinchi());
            ps.setString(5, lop.getTiet());
            ps.setString(6, lop.getThu());
            ps.setString(7, lop.getPhonghoc());
            
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
	
	public boolean deleteLopHoc(String malop) {
		String deleteLH = "DELETE FROM LopHoc WHERE malop LIKE \'" + malop + "\'";
		try {
			PreparedStatement ps = conn.prepareStatement(deleteLH);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		

	}

}
