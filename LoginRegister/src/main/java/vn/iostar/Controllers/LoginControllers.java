package vn.iostar.Controllers;

import java.io.IOException;
import java.net.http.HttpResponse;

import org.eclipse.tags.shaded.org.apache.bcel.classfile.Constant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iostar.Models.User;
import vn.iostar.Services.UserService;
import vn.iostar.Services.UserServiceimpl;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/login")
public class LoginControllers extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  ServletException, IOException{
		HttpSession session = req.getSession(false);
		if(session != null && session.getAttribute("account") != null) {
			resp.sendRedirect(req.getContextPath() + "/waiting");
			return;
			
		} 
		Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    session = req.getSession(true);
                    session.setAttribute("username", cookie.getValue());
                    resp.sendRedirect(req.getContextPath() + "/waiting");
                    return;
                }
            }
        }
        req.getRequestDispatcher("views/login.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean isRememberMe = false;
		
		String remember = req.getParameter("remember");
		
		if("on".equals(remember)) {
			isRememberMe = true;
		}
		String alertMsg = "";
		if(username.isEmpty() || password.isEmpty()) {
			alertMsg = "Tai khoan hoac mat khau khong duoc rong";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			return;
		}
		UserService service = new UserServiceimpl();
		User user = service.login(username, password);
		if(user != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("account", user);
			if(isRememberMe) {
				saveRememberMe(resp, username);
			}
			resp.sendRedirect(req.getContextPath()+ "/waiting");
		}
		else {
			alertMsg ="Tài khoản hoặc mật khẩu không đúng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
		}
    }
	private void saveRememberMe(HttpServletResponse resp, String username) {
		// TODO Auto-generated method stub
		Cookie cookie = new Cookie("username", username);
		cookie.setMaxAge(60*60*24);
		resp.addCookie(cookie);
	}
}
