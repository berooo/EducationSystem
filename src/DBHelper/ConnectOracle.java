package DBHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectOracle {
	public  Connection conn;
	private String user="system";
	private String password="Aa13992128496";
	private String className="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:orcl";
	
	public ConnectOracle(){
		try{
			Class.forName(className);
			System.out.println("加载数据库驱动成功！");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	//创建数据库连接
	public Connection getCon(){
		try{
			conn=DriverManager.getConnection(url, user,password);
			System.out.println("创建数据库成功！");
		}catch(SQLException e)
		{
			System.out.print(conn);
			System.out.println("创建数据库连接失败！");
			conn=null;
			e.printStackTrace();
		}
		return conn;
		
	}
	
	public void closed(){
		try{
			if(conn!=null){
				conn.close();
			}
		}catch(SQLException e){
			System.out.println("关闭conn对象失败！");
			e.printStackTrace();
		}
	}

}
