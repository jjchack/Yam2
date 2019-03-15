package cn.yc.yam.filter;


import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EncodingFilter implements Filter {

	// 过滤器业务处理方法：处理的公用的业务逻辑操作
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		
		// 转型
		final HttpServletRequest request = (HttpServletRequest) req;    
		HttpServletResponse response = (HttpServletResponse) res;
		
		// 一、处理公用业务
		request.setCharacterEncoding("UTF-8");					// POST提交有效
		response.setContentType("text/html;charset=UTF-8");
		
		HttpServletRequest proxy =  (HttpServletRequest) Proxy.newProxyInstance(
				request.getClass().getClassLoader(), 		
				new Class[]{HttpServletRequest.class}, 		
				new InvocationHandler() {					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						Object returnValue = null;
						String methodName = method.getName();
						if ("getParameter".equals(methodName)) {
							String value = request.getParameter(args[0].toString());	// 调用目标对象的方法
							String methodSubmit = request.getMethod(); // 直接调用目标对象的方法
							if ("GET".equals(methodSubmit)) {
								if (value != null && !"".equals(value.trim())){
									value = new String(value.getBytes("ISO8859-1"),"UTF-8");
								}
							} 
							return value;
						}
						else {
							returnValue = method.invoke(request, args);
						}
						
						return returnValue;
					}
				});
		
		// 二、放行 (执行下一个过滤器或者servlet)
		chain.doFilter(proxy, response);		// 传入代理对象
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void destroy() {
		
	}
}
