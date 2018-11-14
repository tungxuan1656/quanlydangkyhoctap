package Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

public class SubjectDAO {
	@SuppressWarnings("unused")
	
	String user="sa";
	String pw="1010";
	String dbname="DANGKYHOCPHAN";
	protected Connection conn;
	
	public SubjectDAO() {
		try {
			FileReader fr = new FileReader("databaselogin.txt");
			BufferedReader br = new BufferedReader(fr);
			user = br.readLine();
			pw = br.readLine();
			dbname = br.readLine();
			fr.close();
			br.close(); 
		} catch (Exception ex) {
			System.out.println("Lỗi đọc file");
		}
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connect = "jdbc:sqlserver://localhost:1433;databasename=" + dbname + ";"+ "username=" + user + ";password=" + pw;
			conn = DriverManager.getConnection(connect);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
