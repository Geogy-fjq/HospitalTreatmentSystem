package Util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class MyFilter
 */
@WebFilter("/loginFilter")
public class loginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public loginFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//防止其它方式进入除login.jsp以外的界面，确保只能通过账户密码登录进入
		HttpServletRequest req=(HttpServletRequest)request;
	    HttpServletResponse rep=(HttpServletResponse)response;
	    HttpSession ses=req.getSession();
        String currentURL=req.getRequestURI();//获取根目录所对应的绝对路径
        String targetURL=currentURL.substring(currentURL.indexOf("/",1),currentURL.length());//截取到当前文件名用于比较     
        if(!(targetURL.equals("/login.jsp"))){
			if(ses==null||ses.getAttribute("loginName")==null){
	            rep.sendRedirect(req.getContextPath()+"/login.jsp");
	        }
	    }
        else{
            chain.doFilter(req,rep);//本次无误，再次验证
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
