package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.StringTokenizer;

import Model.DangKy;
import Model.LopHoc;

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
	
	public boolean checkDangKyDaCo(String mssv, String malop, ArrayList<DangKy> listdk) {
		for (DangKy dk: listdk) {
			if (dk.getMssv().equals(mssv) && dk.getMalop().equals(malop)) return false;
		}
		return true;
	}
	public boolean checkDKKoHopLe(String mssv,String malop, ArrayList<LopHoc> listlop, ArrayList<DangKy> listdk) {
		String tiet = "", thu = "";
		for (LopHoc l: listlop) {
			if (malop.equals(l.getMalop())) {
				tiet = l.getTiet();
				thu = l.getThu();
				break;
			}
		}
		for (DangKy dk: listdk) {
			if(mssv.equals(dk.getMssv())) {
				StringTokenizer s1 = new StringTokenizer(thu, ",");
				while (s1.hasMoreTokens()) {
					StringTokenizer s2 = new StringTokenizer(dk.getThu(), ",");
					String s1next = s1.nextToken();
					while (s2.hasMoreTokens()) {
						if (s1next.equals(s2.nextToken())) {
							StringTokenizer s3 = new StringTokenizer(tiet, ",");
							while (s3.hasMoreTokens()) {
								StringTokenizer s4 = new StringTokenizer(dk.getTiet(), ",");
								String s3next = s3.nextToken();
								while(s4.hasMoreTokens()) {
									if (s3next.equals(s4.nextToken())) return false;
								}
							}
						}
					}
				}
			}
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
