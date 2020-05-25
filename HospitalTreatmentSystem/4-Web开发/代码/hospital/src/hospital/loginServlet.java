package hospital;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import Dao.po_02usersDao1;
import Dao.po_03doctorsDao1;
import Dao.po_04administratorsDao1;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	po_02usersDao1 usersDao1=new po_02usersDao1();
	po_03doctorsDao1 doctorsDao1=new po_03doctorsDao1();
	po_04administratorsDao1 administratorsDao1=new po_04administratorsDao1();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户名和密码
        String loginName=request.getParameter("loginName");
        String password=request.getParameter("password");
        //匹配数据库中的用户名和密码
        String loginName1=null;
    	String password1=null;
        if(usersDao1.findByLoginName(loginName)!=null) {
        	loginName1=usersDao1.findByLoginName(loginName).getUserLoginName();
        	password1=usersDao1.findByLoginName(loginName).getUserPassword();
        }
        else if(doctorsDao1.findByLoginName(loginName)!=null) {
            loginName1=doctorsDao1.findByLoginName(loginName).getDoctorLoginName();
            password1=doctorsDao1.findByLoginName(loginName).getDoctorPassword();
        }
        else if(administratorsDao1.findByLoginName(loginName)!=null) {
            loginName1=administratorsDao1.findByLoginName(loginName).getAdministratorLoginName();
            password1=administratorsDao1.findByLoginName(loginName).getAdministratorPassword();
        }
        //创建json对象
        JSONObject jsonObject=null;
        if((loginName1!=null && password1!=null) && (loginName1.equals(loginName) && password1.equals(password))) {
            jsonObject=new JSONObject("{flag:true}");
        }else {
            jsonObject=new JSONObject("{flag:false}");
        }
        
        //将数据返回给ajax
        response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
