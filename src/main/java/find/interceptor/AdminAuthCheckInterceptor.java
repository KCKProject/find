package find.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import find.vo.AdminAuthInfo;

public class AdminAuthCheckInterceptor extends HandlerInterceptorAdapter {
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		
		if(session != null) {
			AdminAuthInfo adminAuthInfo = (AdminAuthInfo)session.getAttribute("adminAuthInfo");
			
			if(adminAuthInfo!=null) {
				return true;
			}
		}
		response.sendRedirect(request.getContextPath()+"/admin");
		return false;
	}
}
