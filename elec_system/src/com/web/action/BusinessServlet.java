package com.web.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Admin;
import com.domain.Elec_Info;
import com.domain.User;
import com.service.Service;
import com.service.impl.ServiceImpl;
import com.util.CSVUtils;
import com.util.WebUtils;

public class BusinessServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Service service = new ServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");
		if ("logout".equals(op)) {
			lagout(request, response);
		} else if ("showme".equals(op)) {
			showMe(request, response);
		} else if ("toUpdateme".equals(op)) {
			toUpdateMe(request, response);
		} else if ("toUpdateUser".equals(op)) {
			toUpdateUser(request, response);
		} else if ("removeUser".equals(op)) {
			removeUser(request, response);
		} else if ("removeInfo".equals(op)) {
			removeInfo(request, response);
		} else if ("toUpdateInfo".equals(op)) {
			toUpdateInfo(request, response);
		}else if ("toExcel".equals(op)) {
			CSVUtils.toExcel(service.getAllInfos(),"D:/1.csv");
			WebUtils.forward("main.jsp", request, response);
		}
	}

	private void toUpdateInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String date = request.getParameter("date");
		Elec_Info info = service.getInfoByDate(date);
		request.getSession().setAttribute("updateInfo", info);
		WebUtils.forward("page/updateInfo.jsp", request, response);

	}

	private void removeInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String date = request.getParameter("date");
		service.remove(date);
		request.getSession().setAttribute("eleinfos", service.getAllInfos());
		WebUtils.forward("page/statusManage.jsp", request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("op");
		if ("login".equals(op)) {
			request.getSession()
					.setAttribute("eleinfos", service.getAllInfos());
			handleLogin(request, response);
		} else if ("updateUser".equals(op)) {
			updateUser(request, response);
		} else if ("updateAdminme".equals(op)) {
			updateAdminme(request, response);
		} else if ("updateUserme".equals(op)) {
			updateUserme(request, response);
		} else if ("updateInfo".equals(op)) {
			updateInfo(request, response);
		}else if ("addInfo".equals(op)) {
			addInfo(request,response);
		}
	}

	private void addInfo(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ia1 = request.getParameter("ia1");
		String ia2 = request.getParameter("ia2");
		String ib1 = request.getParameter("ib1");
		String ib2 = request.getParameter("ib2");
		String ic1 = request.getParameter("ic1");
		String ic2 = request.getParameter("ic2");


		Elec_Info info = new Elec_Info();
		info.setDate(new Date());
		info.setIa1(Double.parseDouble(ia1));
		info.setIa2(Double.parseDouble(ia2));
		info.setIb1(Double.parseDouble(ib1));
		info.setIb2(Double.parseDouble(ib2));
		info.setIc1(Double.parseDouble(ic1));
		info.setIc2(Double.parseDouble(ic2));
		

		service.add(info);
		request.getSession().setAttribute("eleinfos", service.getAllInfos());
		response.getWriter().print("page/statusManage.jsp");
		
	}

	private void updateInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String date = request.getParameter("date");
		String ia1 = request.getParameter("ia1");
		String ia2 = request.getParameter("ia2");
		String ib1 = request.getParameter("ib1");
		String ib2 = request.getParameter("ib2");
		String ic1 = request.getParameter("ic1");
		String ic2 = request.getParameter("ic2");


		Elec_Info info = service.getInfoByDate(date);
		info.setIa1(Double.parseDouble(ia1));
		info.setIa2(Double.parseDouble(ia2));
		info.setIb1(Double.parseDouble(ib1));
		info.setIb2(Double.parseDouble(ib2));
		info.setIc1(Double.parseDouble(ic1));
		info.setIc2(Double.parseDouble(ic2));
		

		service.update(info);
		request.getSession().setAttribute("eleinfos", service.getAllInfos());
		response.getWriter().print("page/statusManage.jsp");


	}

	private void updateUserme(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_id = request.getParameter("user_id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String department = request.getParameter("department");
		String emp = request.getParameter("emp");
		String tel = request.getParameter("tel");

		User user = service.getUserById(Integer.parseInt(user_id));
		user.setName(name);
		user.setPassword(password);
		user.setDepartment(department);
		user.setEmp(emp);
		user.setTel(tel);

		service.update(user);
		request.getSession().setAttribute("user", user);
		response.getWriter().print("page/usershowme.jsp");
	}

	private void updateAdminme(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String admin_id = request.getParameter("admin_id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String emp = request.getParameter("emp");
		String tel = request.getParameter("tel");

		Admin admin = service.getAdminById(Integer.parseInt(admin_id));
		admin.setName(name);
		admin.setPassword(password);
		admin.setEmp(emp);
		admin.setTel(tel);

		service.update(admin);
		request.getSession().setAttribute("admin", admin);
		response.getWriter().print("page/adminshowme.jsp");

	}

	private void removeUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_id = request.getParameter("user_id");
		service.removeUser(Integer.parseInt(user_id));
		request.getSession().setAttribute("users", service.getAllUsers());
		WebUtils.forward("page/showAllUsers.jsp", request, response);
	}

	private void toUpdateUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_id = request.getParameter("user_id");
		User user = service.getUserById(Integer.parseInt(user_id));
		request.getSession().setAttribute("updateUser", user);
		WebUtils.forward("page/updateUser.jsp", request, response);
	}

	private void updateUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_id = request.getParameter("user_id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String department = request.getParameter("department");
		String emp = request.getParameter("emp");
		String tel = request.getParameter("tel");

		User user = service.getUserById(Integer.parseInt(user_id));
		user.setName(name);
		user.setPassword(password);
		user.setDepartment(department);
		user.setEmp(emp);
		user.setTel(tel);

		service.update(user);
		request.getSession().setAttribute("users", service.getAllUsers());
		response.getWriter().print("page/showAllUsers.jsp");
	}

	private void toUpdateMe(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String admin_id = request.getParameter("admin_id");
		String user_id = request.getParameter("user_id");
		if (user_id != null) {
			User user = service.getUserById(Integer.parseInt(user_id));
			request.getSession().setAttribute("userme", user);
			WebUtils.forward("page/userUpdateme.jsp", request, response);
			return;
		}
		if (admin_id != null) {
			Admin admin = service.getAdminById(Integer.parseInt(admin_id));
			request.getSession().setAttribute("adminme", admin);
			WebUtils.forward("page/adminUpdateme.jsp", request, response);
			return;
		}

	}

	private void showMe(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_type = request.getParameter("user_type");
		if ("user".equals(user_type)) {
			User user = (User) request.getSession().getAttribute("user");
			System.out.println("user: " + user);
			WebUtils.forward("page/usershowme.jsp", request, response);
		} else if ("admin".equals(user_type)) {
			Admin admin = (Admin) request.getSession().getAttribute("admin");
			System.out.println("admin: " + admin);
			WebUtils.forward("page/adminshowme.jsp", request, response);
		}

	}

	private void lagout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_type = request.getParameter("user_type");
		if ("user".equals(user_type)) {
			request.getSession().removeAttribute("user");
			WebUtils.redirect("page/login.jsp", response);
		} else if ("admin".equals(user_type)) {
			request.getSession().removeAttribute("admin");
			WebUtils.redirect("page/adminLogin.jsp", response);
		}

	}

	private void handleLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String user_type = request.getParameter("user_type");
		if ("user".equals(user_type)) {
			User user = service.getUserByName(userName);
			if (user == null) {
				String msg = "用户名不存在，请注册";
				request.setAttribute("msg", msg);
				WebUtils.forward("page/login.jsp", request, response);
			} else {
				if (!user.getPassword().equals(password)) {
					String msg = "用户名和密码不匹配，请重新输入";
					request.setAttribute("msg", msg);
					WebUtils.forward("page/login.jsp", request, response);
				} else {
					request.getSession().setAttribute("user", user);
					WebUtils.forward("page/userIndex.jsp", request, response);
				}
			}
		} else if ("admin".equals(user_type)) {
			Admin admin = service.getAdminByName(userName);
			if (admin == null) {
				String msg = "用户名不存在，请注册";
				request.setAttribute("msg", msg);
				WebUtils.forward("page/adminLogin.jsp", request, response);
			} else {
				if (!admin.getPassword().equals(password)) {
					String msg = "用户名和密码不匹配，请重新输入";
					request.setAttribute("msg", msg);
					WebUtils.forward("page/adminLogin.jsp", request, response);
				} else {
					request.getSession().setAttribute("admin", admin);
					request.getSession().setAttribute("users",
							service.getAllUsers());
					WebUtils.forward("page/adminIndex.jsp", request, response);
				}
			}
		}

	}

}
