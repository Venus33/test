package service;

import java.util.List;

import dao.StuDao;
import entity.Stu;

public class StuService {
     //����һ���������ݿ��ĵ�����
	private StuDao sd = new StuDao();
	/**
	 * ������ݿ�����������ݵķ���
	 * @return װ���������ݵļ���
	 */
	public List<Stu> getAll() {
		// ����dao�в�ѯ�������ݵķ���
		List<Stu> list = sd.findall();
		// �ж�����������Ƿ�������
		if(list != null) {
			return list;
		}else {
			return null;
		}
	}
	
	public Stu findByid(String id) {
		// ����dao�и��ݲ�Ʒ���룬�������ݵķ���
		Stu stu = sd.findByid(id);
		return stu;
	}
}
