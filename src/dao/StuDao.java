package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Stu;

public class StuDao extends BaseDao {

	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	public List<Stu> findall(){
		List<Stu> list = new ArrayList<Stu>();
		try {
			// ������Ӷ���
			conn = BaseDao.getConnection();
			// ����Ҫִ�е�SQL����
			String sql = "select * from testgit";
			// ʵ����ִ�ж���
			pst = conn.prepareStatement(sql);
			// ��Ϊû�в��������Կ���ֱ�ӵ��÷���
			rs = pst.executeQuery();
			// ��ý�����е����ݣ����������浽������
			while (rs.next()) {
				// ��Ϊ���е�ÿһ�д���һ��ʵ����������ȴ���һ������������ÿһ������
				Stu stu = new Stu();
				// ���������һ���ն���
				stu.setId(rs.getString(1));
				stu.setName(rs.getString(2));
				stu.setSex(rs.getString(3));
				// ��������ϱ��浽������
				list.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pst, conn);
		}
		return list;
	}
	 public Stu findByid(String id) { 
		 Stu stu = null; 
		 try { // ������Ӷ���
			  conn = BaseDao.getConnection(); 
			  // ����Ҫִ�е�SQL���� 
			  String sql = "select * from testgit where id=?"; 
			  // ʵ����ִ�ж��� 
			  pst = conn.prepareStatement(sql); 
			  // Ϊռλ����ֵ 
			  pst.setString(1, id);
			  // ��Ϊû�в��������Կ���ֱ�ӵ��÷��� 
			  rs = pst.executeQuery(); 
			  // ��ý�����е����ݣ����������浽������ 
			  while(rs.next()) { 
				  // ��Ϊ���е�ÿһ�д���һ��ʵ����������ȴ���һ������������ÿһ������ 
				  stu = new Stu();
				  //���������һ���ն��� 
					stu.setId(rs.getString(1));
					stu.setName(rs.getString(2));
					stu.setSex(rs.getString(3));
				  }
			  } catch(SQLException e) { 
				  e.printStackTrace(); 
				  }finally {
					  closeAll(rs, pst, conn);
					  }
			          return stu; 
			  }
}
