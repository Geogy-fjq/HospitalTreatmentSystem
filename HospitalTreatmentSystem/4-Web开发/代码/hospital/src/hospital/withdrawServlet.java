package hospital;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import Dao.po_14registrationformDao1;
import Dao.vo_2withdrawNumberDao1;
import PoVo.po_14registrationform;

/**
 * Servlet implementation class withdrawServlet
 */
@WebServlet("/withdrawServlet")
public class withdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	po_14registrationformDao1 registrationformDao1=new po_14registrationformDao1();
	vo_2withdrawNumberDao1 withdrawNumberDao1=new vo_2withdrawNumberDao1();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public withdrawServlet() {
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
		po_14registrationform registrationform=registrationformDao1.findByMedicalNumber(Integer.parseInt(medicalRecordNumber));
		String registrationID=Integer.toString(registrationform.getRegistrationID());
		//退号
		String result=withdrawNumberDao1.withdrawNumber(registrationID);
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
