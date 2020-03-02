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
			// 获得连接对象
			conn = BaseDao.getConnection();
			// 创建要执行的SQL命令
			String sql = "select * from testgit";
			// 实例化执行对象
			pst = conn.prepareStatement(sql);
			// 因为没有参数，所以可以直接调用方法
			rs = pst.executeQuery();
			// 获得结果集中的数据，并将它保存到集合中
			while (rs.next()) {
				// 因为表中的每一行代表一个实体对象，所以先创建一个对象来保存每一行数据
				Stu stu = new Stu();
				// 这个对象是一个空对象
				stu.setId(rs.getString(1));
				stu.setName(rs.getString(2));
				stu.setSex(rs.getString(3));
				// 将这个集合保存到集合中
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
		 try { // 获得连接对象
			  conn = BaseDao.getConnection(); 
			  // 创建要执行的SQL命令 
			  String sql = "select * from testgit where id=?"; 
			  // 实例化执行对象 
			  pst = conn.prepareStatement(sql); 
			  // 为占位符赋值 
			  pst.setString(1, id);
			  // 因为没有参数，所以可以直接调用方法 
			  rs = pst.executeQuery(); 
			  // 获得结果集中的数据，并将它保存到集合中 
			  while(rs.next()) { 
				  // 因为表中的每一行代表一个实体对象，所以先创建一个对象来保存每一行数据 
				  stu = new Stu();
				  //这个对象是一个空对象 
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
