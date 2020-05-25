package hospital;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import Dao.po_06drugsDao1;
import PoVo.po_06drugs;

/**
 * Servlet implementation class addServlet
 */
@WebServlet("/addServlet")
public class addServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	po_06drugsDao1 drugsDao1=new po_06drugsDao1();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public addServlet() {
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
		String drugName=request.getParameter("drugName");
		po_06drugs drug=drugsDao1.findByDrugName(drugName);
		//创建json对象
		JSONObject jo=new JSONObject();
		//读取数据库中的数据
		if(drug!=null) {
			String drugSpecification=drug.getDrugSpecification();
			double unitPriceOfDrugs=drug.getUnitPriceOfDrugs();
	        jo.put("drugSpecification",drugSpecification);
	        jo.put("unitPriceOfDrugs",unitPriceOfDrugs);
		}
		else {
			jo.put("drugSpecification","default");
	        jo.put("unitPriceOfDrugs","default");
		}
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
