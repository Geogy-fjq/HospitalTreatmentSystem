package hospital;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.po_13registeredgradesDao1;

/**
 * Servlet implementation class changeFeeServlet
 */
@WebServlet("/changeFeeServlet")
public class changeFeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	po_13registeredgradesDao1 registeredgradesDao1=new po_13registeredgradesDao1();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeFeeServlet() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text;charset=utf-8");
    	//获取挂号级别和是否要病历本
        String registeredGrade=request.getParameter("registeredGrade");
        String medicalRecordNeeded=request.getParameter("medicalRecordNeeded");
        //读取数据库中对应挂号级别所需的金额
        double fee=0;
        if(!registeredGrade.equals("0")) {
            fee=registeredgradesDao1.findByName(registeredGrade).getRegistrationFee();
            //添加是否要病历本的金额
            fee=fee+Double.parseDouble(medicalRecordNeeded);
            //响应
    		response.getWriter().write(String.valueOf(fee));
        }
        else {
        	//响应
    		response.getWriter().write("");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
