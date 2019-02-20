package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Link {
	public static void main(String[] args) {
		//ѡ��Ҫ���������ݿ�------�������������䣩
		String url="jdbc:mysql://192.168.2.80:3306/db2";
		String user="root";
		String password="123456";
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//�������� ����ip �˿ں� �û��� ����	//ѡ��Ҫ���������ݿ�
			con =DriverManager.getConnection(url, user, password);
			//��������ڣ�дsql��䣩
			pstmt = con.prepareStatement("select * from student;");
			//����sql��䲢�鿴����������ɾ�ķ�����Ӱ�������������ǲ�ѯ���ز�ѯ�Ľ��
			//���е�ʱ��ע���������ɾ�������executeUpdate ����int �����ѯ�����executeQuery������ResultSet
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("id")+" "+rs.getString("name"));
			}
			
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
