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
 * �û�Servlet ���� ��¼ע�� ��ѯ �˳� �������� ʹ��op �ֶα�ʶҵ���������
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
			msg = "�û���Ϣ����ɹ�";
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
		//��user���ظ�ҳ��
		String userString = JSON.toJSONString(user);
		response.getWriter().append(userString);
	}


	private void add(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		UserBiz ubiz = new UserBiz();
		//����ҳ�洫�صĲ���
		//���������ص�user������
		User user = BeanUtils.asBean(request, User.class);
		// ����UserBiz.add ���� �� ���û���ӵ����ݿ�
		try{
			ubiz.add(user);
			//��ʽһ
			//request.getRequestDispatcher("user.s?op=query").forward(request, response);
			//��ʽ��
			//query(request,response);
		}catch(BizException e){
			//����ɹ���Ҳ��ת���û���ѯ����
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
		}finally{
			//����ɹ�����ת���û���ѯ���桮
			//����ɹ� Ҳ��ת���û���ѯ����
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
		//���ܲ���
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
					//ʧ��
					request.getRequestDispatcher("login.jsp").forward(request, response);
					return;
				}
				
				if(user == null){
					request.setAttribute("msg", "�û������������");
					//ʧ��
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}else{
					//���û���Ϣ���浽�Ự��
		            request.getSession().setAttribute("loginedUser", user);   
		            response.sendRedirect("index.jsp");
		            
				}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
