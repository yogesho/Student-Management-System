package Student_Managment_System.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Student_Managment_System.dao.StudentDao;
import Student_Managment_System.dto.Student;

@WebServlet("/edit")
public class StudentEditController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		StudentDao studentDao=new StudentDao();
		Student student=new Student();
		
		student.setId(id);
		student.setName(name);
		student.setEmail(email);
		student.setAddress(address);
		student.setPassword(password);
		
		Student dbStudent=studentDao.updateStudent(student);
		
		if(dbStudent!=null) {
			List<Student> list=studentDao.getAllStudent();
			req.setAttribute("list", list);
			RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
			dispatcher.forward(req, resp);
		}
		else {
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
