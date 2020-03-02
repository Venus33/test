package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Stu;
import service.StuService;

@WebServlet("/Index")

public class IndexServlet extends HttpServlet {
	// ����һ��service���л�����ݿ������ݵĶ���
		private StuService  ss = new StuService();
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doPost(req, resp);
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// ��Ϊ������Ҫ�����ݿ���е��������ݶ�չʾ����������һ�����ж��еı������ʹ��һ��������װ
			
			// ����service�л���������ݵķ�������������һ��������,Ϊ�˼��ڻ������ʱ����ǿת�Ĳ���������ʹ�÷���
			List<Stu> list = ss.getAll();
			// ���������ϱ��浽��������
			req.setAttribute("list", list);
			// ʵ��ҳ�����ת,��Ϊ����Ĳ����ǲ�ѯ�����Ǿ�ʹ��ת��
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		
}
