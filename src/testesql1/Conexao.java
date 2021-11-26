/*
CONNECTION Java - PostgreSQL
Powered by > GABRIEL CARVALHO
Github > GabPhoenix
*/

package testesql1;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Conexao {
	private String url;
	private String user;
	private String password;
	private Connection con;
	
//	Connection
	Conexao(){
		url = "jdbc:postgresql://localhost:5432/postgres";
		user = "YOUR USER";
		password = "YOUR PASSWORD";
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("CONNECTED SUCCESFULLY!");
			
			} catch (Exception e){
			e.printStackTrace();
			}
			
		}
//	run commands
	public int runSQL(String sql) {
		try {
			Statement stm = con.createStatement();
			int res = stm.executeUpdate(sql);
			con.commit();
			return res;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	
//	search commands
	public ResultSet searchSQL(String sql) {
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			return rs;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

//	close connection
	public boolean closeConnection() {
		try {
			con.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
		
}
