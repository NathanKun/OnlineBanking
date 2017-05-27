/**
 * Ref: http://stackoverflow.com/questions/4308554/simplest-way-to-read-json-from-a-url-in-java
 * @author HE Junyang, Roland Illig
 *
 */
package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * JsonReader
 * 
 * @author HE Junyang, Roland Illig
 *
 */
public class JsonReader {

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}
	
	/**
	 * Transform csv to json string
	 * @param rd	BufferedReader
	 * @return	string of json
	 * @throws IOException	IOException
	 */
	private static String readCSV(BufferedReader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		String line = null;
		sb.append("{\"stock\":[");
		
		line = rd.readLine();
		String[] header = line.split(",");
		String[] data = null;
		int headerCount = header.length;
		
		while((line = rd.readLine()) != null) {
			data = line.split(",");
			sb.append("{");
			for(int i = 0; i < headerCount; i++) {
				sb.append("\"");
				sb.append(header[i]);
				sb.append("\":\"");
				sb.append(data[i]);
				sb.append("\",");
			}
			sb.append("},");
		}
		sb.setLength(sb.length() - 1);
		
		sb.append("]}");
		return sb.toString();
	}

	/**
	 * read JSON object from Url
	 * 
	 * @param url
	 *            url to read
	 * @return The JSON Object
	 * @throws IOException
	 *             IOException
	 * @throws JSONException
	 *             JSONException
	 */
	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	/**
	 * read JSON object from Url
	 * 
	 * @param url
	 *            url to read
	 * @param cookies
	 *            cookies
	 * @return The JSON Object
	 * @throws IOException
	 *             IOException
	 * @throws JSONException
	 *             JSONException
	 */
	public static JSONObject readJsonFromUrl(String url, String cookies) throws IOException, JSONException {
		CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
		URLConnection conn = new URL(url).openConnection();
		conn.setRequestProperty("Cookie", "B=" + cookies);
		conn.setUseCaches(true);
		conn.setDoOutput(true);
		conn.connect();
		InputStreamReader in = new InputStreamReader((InputStream) conn.getContent(), Charset.forName("UTF-8"));
		try {
			BufferedReader buff = new BufferedReader(in);
			String jsonText = readCSV(buff);
			//System.out.println(jsonText);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			in.close();
		}
	}
}