package Student_Managment_System.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Student_Managment_System.dao.StudentDao;
import Student_Managment_System.dto.Student;

@WebServlet("/login")
public class StudentLoginController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		StudentDao studentDao=new StudentDao();
		
		Student student=studentDao.loginStudent(email);
		
		if(student.getEmail().equals(email) && student.getPassword().equals(password)) {
			List<Student> list=studentDao.getAllStudent();
			
			req.setAttribute("list", list);
			
			Cookie cookie=new Cookie("username", student.getName());
			resp.addCookie(cookie);
			
			RequestDispatcher dispatcher=req.getRequestDispatcher("display");
			dispatcher.forward(req, resp);
//			RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
//			
//			dispatcher.forward(req, resp);
		}
		else {
			req.setAttribute("message", "please login with proper credentials");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
			
			dispatcher.forward(req,resp);
		}
	}
}
