package helloweb.databace;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ticketdb {
	static String url = "jdbc:h2:G:/file/h2/TEST";
	static String username = "root";
	static String password = "password";
	static String driverclass = "org.h2.Driver";
	static int id;
	static int id1;
	public static void create() throws Exception{
		Class.forName(driverclass);
		Connection cn = DriverManager.getConnection(url, username, password);
		Statement sm = cn.createStatement();
		
		id = 1;
		id1 = 1;
		
		sm.executeUpdate("DROP TABLE IF EXISTS TICKET;");
		sm.executeUpdate("CREATE TABLE TICKET(ID INT PRIMARY KEY, PLACE VARCHAR(20), COST FLOAT, NUMBER INT);");
		sm.executeUpdate("DROP TABLE IF EXISTS MESSAGE;");
		sm.executeUpdate("CREATE TABLE MESSAGE(ID INT PRIMARY KEY, PLACE VARCHAR(20), COST FLOAT, NUMBER INT);");
		cn.close();
		sm.close();
	}
	public static void addData(String place, double cost, int number) throws Exception{
		Class.forName(driverclass);
		Connection cn = DriverManager.getConnection(url, username, password);
		Statement sm = cn.createStatement();
		String Sql = "INSERT INTO TICKET VALUES(" +id+ ",'" +place+ "'," +cost+ "," +number+ ")";
		sm.executeUpdate(Sql);
		cn.close();
		sm.close();
		id++;
	}
	
	public static String TicketMessage() throws Exception{
		Class.forName(driverclass);
		Connection cn = DriverManager.getConnection(url, username, password);
		Statement sm = cn.createStatement();
		ResultSet rs = sm.executeQuery("SELECT * FROM TICKET");
		
		String ti = "<tr>\n"+
				"<td>id</td>\n"+
				"<td>place</td>\n"+
				"<td>cost</td>\n"+
				"<td>number</td>\n"+
				"</tr>\n";
				
		while(rs.next()) {
			ti += "<tr>\n"+
					"<td>"+rs.getString("id")+"</td>\n"+
					"<td>"+rs.getString("place")+"</td>\n"+
					"<td>"+rs.getString("cost")+"</td>\n"+
					"<td>"+rs.getString("number")+"</td>\n"+
					"</tr>\n";
		}
		cn.close();
		sm.close();
		return ti;
	}
	
	public static String TicketMessage1() throws Exception{
		Class.forName(driverclass);
		Connection cn = DriverManager.getConnection(url, username, password);
		Statement sm = cn.createStatement();
		ResultSet rs = sm.executeQuery("SELECT * FROM MESSAGE");
		
		String ti = "<tr>\n"+
				"<td>id</td>\n"+
				"<td>place</td>\n"+
				"<td>cost</td>\n"+
				"<td>number</td>\n"+
				"</tr>\n";
				
		while(rs.next()) {
			ti += "<tr>\n"+
					"<td>"+rs.getString("id")+"</td>\n"+
					"<td>"+rs.getString("place")+"</td>\n"+
					"<td>"+rs.getString("cost")+"</td>\n"+
					"<td>"+rs.getString("number")+"</td>\n"+
					"</tr>\n";
		}
		cn.close();
		sm.close();
		return ti;
	}
	
	public static int TicketNum(String place) throws Exception{
		Class.forName(driverclass);
		Connection cn = DriverManager.getConnection(url, username, password);
		Statement sm = cn.createStatement();
		String Sql = "SELECT NUMBER FROM TICKET WHERE PLACE ='" + place + "'";
		ResultSet rs = sm.executeQuery(Sql);
		rs.next();
		int num = Integer.parseInt(rs.getString("NUMBER"));
		cn.close();
		sm.close();
		return num;
	}
	public static double TicketCost(String place) throws Exception{
		Class.forName(driverclass);
		Connection cn = DriverManager.getConnection(url, username, password);
		Statement sm = cn.createStatement();
		String Sql = "SELECT COST FROM TICKET WHERE PLACE ='" + place + "'";
		ResultSet rs = sm.executeQuery(Sql);
		rs.next();
		double cos = Double.parseDouble(rs.getString("COST"));
		cn.close();
		sm.close();
		return cos;
	}
	public static int TicketExist(String place) throws Exception{
		Class.forName(driverclass);
		Connection cn = DriverManager.getConnection(url, username, password);
		Statement sm = cn.createStatement();
		String Sql = "SELECT COUNT(*) FROM TICKET WHERE PLACE ='" + place + "'";
		ResultSet rs = sm.executeQuery(Sql);
		rs.next();
		int count = Integer.parseInt(rs.getString("COUNT(*)"));
		cn.close();
		sm.close();
		return count;
	}
	public static void TicketGet(String place) throws Exception{
		Class.forName(driverclass);
		Connection cn = DriverManager.getConnection(url, username, password);
		Statement sm = cn.createStatement();
		String Sql = "SELECT NUMBER FROM TICKET WHERE PLACE ='" + place + "'";
		ResultSet rs = sm.executeQuery(Sql);
		rs.next();
		int num = Integer.parseInt(rs.getString("NUMBER"))-1;
		String Sql1 = "UPDATE TICKET SET NUMBER = " + num + " WHERE PLACE = '" + place + "'";
		sm.executeUpdate(Sql1);
		
		String Sql2 = "INSERT INTO MESSAGE VALUES(" +id1+ ",'" +place+ "'," +TicketCost(place)+ ",1)";
		sm.executeUpdate(Sql2);
		id1++;
		
		cn.close();
		sm.close();
	}

}
