package servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import util.JsonReader;

/**
 * Servlet implementation class SearchAddress
 */
@WebServlet("/SearchAddress")
public class SearchAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String q = request.getParameter("q");
		if(q.length() != 0) {
			q = URLEncoder.encode(q, "UTF-8");
			//q = q.replace("+", "%20");
			String url = "http://api-adresse.data.gouv.fr/search/?q=" + q;
			
			// Connect and get JSON Object
			JSONObject jsonObj = null;
			try {	// try connect
				jsonObj = JsonReader.readJsonFromUrl(url);
			} catch (JSONException e) {
				System.out.println("Connection faild");
				e.printStackTrace();
			}
			
			// explore JSON object
			JSONArray addressList = null;
			try {
				JSONArray featureList = jsonObj.getJSONArray("features");
				addressList = new JSONArray();
				for(int i = 0; i < featureList.length(); i++){
					JSONObject obj = (JSONObject) featureList.get(i);
					obj = obj.getJSONObject("properties");
					obj.remove("score");
					obj.remove("citycode");
					obj.remove("street");
					obj.remove("context");
					obj.remove("label");
					obj.remove("id");
					addressList.put(obj);
				}
			} catch (JSONException e) {
				System.out.println("Exploration JSON object faild");
				e.printStackTrace();
			}
			
			// Generate out string
			StringBuilder out = new StringBuilder();
			try {
				for(int i = 0; i < addressList.length(); i++){
					JSONObject obj = (JSONObject) addressList.get(i);
					out.append(obj.getString("name"));
					out.append(", ");
					out.append(obj.getString("postcode"));
					out.append(", ");
					out.append(obj.getString("city"));
					out.append(";");
				}
			} catch (JSONException e) {
				System.out.println("Out String generation failed");
				e.printStackTrace();
			}
			
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(out.toString());
			//System.out.println(out.toString());
		} else {
			response.sendRedirect("./");
		}
	}

}