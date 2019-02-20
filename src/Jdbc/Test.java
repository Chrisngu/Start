package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
	public static void main(String[] args) {
		//选择要操作的数据库------加载驱动（反射）
				String url="jdbc:mysql://192.168.2.80:3306/db2?useUnicode=true&characterEncoding=utf8";
				String user="root";
				String password="123456";
				ResultSet rs=null;
				Connection con=null;
				PreparedStatement pstmt = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					//创建连接 主机ip 端口号 用户名 密码	//选择要操作的数据库
					con =DriverManager.getConnection(url, user, password);
					//创建命令窗口（写sql语句）
					pstmt = con.prepareStatement("insert into student(name,b_id,gerden) values(?,?,?)");
					//运行sql语句并查看结果，如果增删改返回受影响的行数，如果是查询返回查询的结果
					//运行的时候注意如果是增删改则调用executeUpdate 返回int 如果查询则调用executeQuery，返回ResultSet
				/*	rs = pstmt.executeQuery();
					while(rs.next()) {
						System.out.println(rs.getInt("id")+" "+rs.getString("name"));
					}*/
					pstmt.setString(1,"中华田园犬");
					pstmt.setInt(2, 2);
					pstmt.setInt(3, 0);
					int i=pstmt.executeUpdate();
					System.out.println(i);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					if(rs!=null)
						try {
							rs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if(pstmt!=null)
						try {
							pstmt.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if(con!=null)
						try {
							con.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
				}
	}
}
