package hospital;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import Dao.vo_7dispensingDao1;

/**
 * Servlet implementation class dispensingServlet
 */
@WebServlet("/dispensingServlet")
public class dispensingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	vo_7dispensingDao1 dispensingDao1=new vo_7dispensingDao1();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dispensingServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码格式
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		//获得jsp中的数据
		String medicalRecordNumber=request.getParameter("medicalRecordNumber");	
		//发药
		String result=dispensingDao1.dispensing(medicalRecordNumber);
		//创建json对象
		JSONObject jo=new JSONObject();
        jo.put("result",result);
        //将数据返回给ajax
        response.getOutputStream().write(JSONObject.valueToString(jo).getBytes("utf-8"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
