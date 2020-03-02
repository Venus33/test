package service;

import java.util.List;

import dao.StuDao;
import entity.Stu;

public class StuService {
     //创建一个操作数据库表的到对象
	private StuDao sd = new StuDao();
	/**
	 * 获得数据库表中所有数据的方法
	 * @return 装满所有数据的集合
	 */
	public List<Stu> getAll() {
		// 调用dao中查询所有数据的方法
		List<Stu> list = sd.findall();
		// 判断这个集合中是否有数据
		if(list != null) {
			return list;
		}else {
			return null;
		}
	}
	
	public Stu findByid(String id) {
		// 调用dao中根据产品代码，查找数据的方法
		Stu stu = sd.findByid(id);
		return stu;
	}
}
