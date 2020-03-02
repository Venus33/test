package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Stu;
import service.StuService;

@WebServlet("/FindById")
public class FindByIdServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ��������������ľͱ���Ҫ���ñ���
		req.setCharacterEncoding("UTF-8");
		// ���ҳ���ϵ�����
		String id = req.getParameter("id");
		// ����service�л�����ݵķ���
		StuService ss = new StuService();
		// ��Ϊ�����õ��������������ݣ�һ�������ݿ���б���ľ���һ��ʵ���������Ϣ
		// ��������ʹ��һ��ʵ�������б���
		Stu stu = ss.findByid(id);
		if (stu != null) {
			// ����õ����ݣ����뵽��������
			req.setAttribute("stu",stu);
			// ҳ����ת���޸�ҳ��,��ѯʹ��ת��
			req.getRequestDispatcher("update.jsp").forward(req, resp);
		}else{
			resp.sendRedirect("Index");
		}
	}
}
