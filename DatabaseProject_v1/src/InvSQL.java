/**
 * ?!: 待修改
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InvSQL {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String url;
	private static String username;
	private static String password;
	private static Connection conn;

	public InvSQL(User adm) throws SQLException, ClassNotFoundException {
//		Undone: MySQL DB connection, different permissions
		String server = "jdbc:mysql://127.0.0.1:3306/";
		String database = "dbms_g15";
		String config = "?useSSL=false";
//		+ "&allowPublicKeyRetrieval=true&serverTimezone=UTC";
//		what is the difference between the two urls?
		this.url = server + database + config;
		this.username = "root";
//		?!
		this.password = "Weber245267";
//		要求DBMS權限
		Class.forName(JDBC_DRIVER);
		this.initializing();
	}	

	private void initializing() throws SQLException {
		this.conn = DriverManager.getConnection(url,username,password);
	}
	
	private static boolean isNumeric(String str) {
		//check whether the string is numeric
		return str.matches("^[1-9][0-9]*$");
//		return str.matches("^(-|\\+)[1-9][0-9]*$"); //正負數
	}
	
	public String function() throws SQLException {
		//function:
		String result = "";
		return result;
	}
	
	public String modifyQuantity(String id, String size, int sign, String numStr, String plat) throws SQLException {
		//修改資料庫裡的網路童裝數量，門市童裝、寄賣品可以共用，需要新增修改table的變數和plat；門市要新增門市屬性
		/**check:
		 * relation結構，要SQL
		 * 有無該商品id
		 * 是否輸入修改數字
		 * 商品是否在該平台上架
		 * 庫存數量是否<減少數量
		 */
//		?!
		String result = "";
		int num = 0;
		if(this.isNumeric(numStr)) {
			num = Integer.valueOf(numStr);
		} else {
			return "請在修改數量內輸入數字";
		}
//		?!
		PreparedStatement stat1 = 
				conn.prepareStatement("SELET quantity FROM tableName WHERE id=? AND size=? AND platform=?;");
		//先取得原先庫存數量再增減
		int stock = 0;  //原庫存
		stock = stock+sign*num;
//		?!
		PreparedStatement stat = 
				conn.prepareStatement("UPDATE tableName SET quantity=? WHERE id=? AND size=? AND platform=?;");
		stat.setInt(1, stock); 
		stat.setString(2, id);
		stat.setString(3, size);
		stat.setString(4, plat);
		int resultNum = stat.executeUpdate();
		if (resultNum==1) {
			result = String.format("<html><body> 操作成功！<br>更新之商品資訊如下："
					+ "<br>ID：%s<br>尺寸：%s<br>修改數量：%s<br>更新後庫存量：%d<br>平台：%s<body></html>"
					,id,size,sign*num,stock,plat);
		}		
		return result;
	}
	
	public String checkArrival(String id, String size, String numStr) throws SQLException {
		//確認DB的門市童裝到貨庫存，要增加門市屬性
		/**check:
		 * relation結構，要SQL
		 * 有無該商品id
		 * 是否輸入修改數字
		 * 商品是否有運送紀錄
		 * 運送數量是否<減少數量
		 * ??是否有運送ID或其他PK屬性
		 */
//		?!
		String result = "";
		int loss = 0;
		if(this.isNumeric(numStr)) {
			loss = Integer.valueOf(numStr);
		} else {
			return "請在修改數量內輸入數字";
		}
//		?!
		PreparedStatement stat1 = 
				conn.prepareStatement("SELET quantity FROM tableName WHERE id=? AND size=?;");
		//先取得原先運送數量再減去遺失數量
		int total = 0;  //運送數量
		total = total-loss;
//		?!
		PreparedStatement stat = 
				conn.prepareStatement("UPDATE tableName SET quantity=? WHERE id=? AND size=?;");
		stat.setInt(1, total-loss); 
		stat.setString(2, id);
		stat.setString(3, size);
		int resultNum = stat.executeUpdate();
		if (resultNum==1) {
			result = String.format("<html><body> 操作成功！<br>更新之商品資訊如下："
					+ "<br>ID：%s<br>尺寸：%s<br>遺失數量：%s<br>實際到貨量：%d<body></html>"
					,id,size,loss,total);
		}
		return result;
	}
		
	public void closeConn() throws SQLException {
		this.conn.close();
	}
}
