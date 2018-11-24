package com.yc.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * ����Ȩ�޿��ƵĹ�����
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(urlPatterns={"*.jsp","*.s"})
public class LoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		
		/**
		 * ʵ���ų�Ȩ�޷��ʿ��Ƶ���Դ
		 */
		
		//��ȡ��ǰ������Դ��
		//��ȡ��ǰ������Դ��
		String path = httpRequest.getServletPath(); //���ط��ʵ���Դ·��
		//�ж���Դ��ʾ������Ҫ������
		if(path.endsWith("user.s") || path.endsWith("login.jsp")){
			//ֱ�ӷ���
			chain.doFilter(request, response);
			return;
		}
		if(httpRequest.getSession().getAttribute("loginedUser")!=null){
			//�Ѿ���¼
			//����ҵ�����ִ�� �������� ��doFilter
			chain.doFilter(request, response);
		}else{
			//δ��¼
			request.setAttribute("msg", "���ȵ�¼ϵͳ��");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
