package com.yc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.yc.bean.User;
import com.yc.dao.BeanUtils;

import biz.BizException;
import biz.UserBiz;

/**
 * 用户Servlet 包含 登录注册 查询 退出 忘记密码 使用op 字段标识业务操作类型
 */
@WebServlet("/user.s")
public class UserServlrt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBiz ubiz;	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if("login".equals(op)){
				login(request,response);
		}else if("query".equals(op)){
			query(request,response);
		}else if("add".equals(op)){
			add(request,response);
		}else if("find".equals(op)){
			find(request,response);
		}else if("save".equals(op)){
			save(request,response);
		}
	}

	
	private void save(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		response.setCharacterEncoding("utf-8");
		User user = BeanUtils.asBean(request, User.class);
		String msg;
		try{
			ubiz.save(user);
			msg = "用户信息保存成功";
		}catch(BizException e){
			e.printStackTrace();
			msg = e.getMessage();
		}
		response.getWriter().append(msg);
	}


	private void find(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		User user = ubiz.findById(id);
		//将user返回给页面
		String userString = JSON.toJSONString(user);
		response.getWriter().append(userString);
	}


	private void add(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		UserBiz ubiz = new UserBiz();
		//接受页面传回的参数
		//将参数加载到user对象种
		User user = BeanUtils.asBean(request, User.class);
		// 调用UserBiz.add 方法 ， 将用户添加到数据库
		try{
			ubiz.add(user);
			//方式一
			//request.getRequestDispatcher("user.s?op=query").forward(request, response);
			//方式二
			//query(request,response);
		}catch(BizException e){
			//如果成功，也跳转到用户查询界面
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
		}finally{
			//如果成功则跳转到用户查询界面‘
			//如果成功 也跳转到用户查询界面
			query(request,response);
		}
	}


	private void query(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		UserBiz ubiz = new UserBiz();
		User user = BeanUtils.asBean(request, User.class);
		request.setAttribute("userList", ubiz.find(user));
		request.getRequestDispatcher("manage-user.jsp").forward(request, response);
	}


	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接受参数
				String username = request.getParameter("username");
				String userpwd = request.getParameter("userpwd");
				
				UserBiz ubiz = new UserBiz();
				//Map<String,String> user = null;
				User user = null;
				
				try{
					user = ubiz.login(username, userpwd);
				}catch(BizException e){
					e.printStackTrace();
					request.setAttribute("msg", e.getMessage());
					//失败
					request.getRequestDispatcher("login.jsp").forward(request, response);
					return;
				}
				
				if(user == null){
					request.setAttribute("msg", "用户名或密码错误：");
					//失败
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}else{
					//将用户信息保存到会话中
		            request.getSession().setAttribute("loginedUser", user);   
		            response.sendRedirect("index.jsp");
		            
				}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
