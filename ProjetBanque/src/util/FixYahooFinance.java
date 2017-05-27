package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.joda.time.DateTime;
import org.json.JSONException;
import org.json.JSONObject;

public class FixYahooFinance {
	static String _YAHOO_COOKIE_ = "";
	static String _YAHOO_CRUMB_ = "";
	static DateTime _YAHOO_CHECKED_ = null;
	static long _YAHOO_TTL_ = 300;

	public static void get_yahoo_crumb() {
		// use same cookie for 5 min
		DateTime now = new DateTime();
		long delta = 0;
		if(_YAHOO_CHECKED_ != null){
			delta = (now.getMillis() - _YAHOO_CHECKED_.getMillis()) / 1000;
		}
		
		if (delta > _YAHOO_TTL_ || _YAHOO_CHECKED_ == null) {
			URLConnection connection;
			try {
				connection = new URL("https://finance.yahoo.com/quote/SPY/history").openConnection();
				connection.connect();
				List<String> cookies = connection.getHeaderFields().get("Set-Cookie");
				// cookies.forEach(System.out::println);
				_YAHOO_COOKIE_ = cookies.get(0).split(";")[0].substring(2);
				_YAHOO_COOKIE_ = URLDecoder.decode(_YAHOO_COOKIE_, "utf-8");

				String regex = ".\"CrumbStore\":\\{\"crumb\":\"(?<crumb>[^\"]+)\"\\}";
				Pattern pattern = Pattern.compile(regex);
				Matcher m = null;

				InputStreamReader in = new InputStreamReader((InputStream) connection.getContent());
				BufferedReader buff = new BufferedReader(in);
				String line;
				while ((line = buff.readLine()) != null) {
					m = pattern.matcher(line);
					if (m.find()) {
						_YAHOO_CRUMB_ = m.group().split("\"")[5];
						_YAHOO_CRUMB_ = URLDecoder.decode(_YAHOO_CRUMB_, "utf-8");

						// set global params
						_YAHOO_CHECKED_ = new DateTime();
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	public static String getCookie() {
		return _YAHOO_COOKIE_;
	}

	public static String getCrumb() {
		return _YAHOO_CRUMB_;
	}

	public static void main(String[] args) {
		get_yahoo_crumb();

		System.out.println(_YAHOO_COOKIE_);
		System.out.println(_YAHOO_CRUMB_);

		DateTime today = new DateTime();
		String url = "https://query1.finance.yahoo.com/v7/finance/download/" + "SOP.PA" + "?period1="
				+ today.minusMonths(6).getMillis() / 1000 + "&period2=" + today.getMillis() / 1000 + "&interval=" + "1d"
				+ "&events=history&crumb=" + _YAHOO_CRUMB_;

		JSONObject jsonObj = null;
		try { // try connect
			jsonObj = JsonReader.readJsonFromUrl(url, _YAHOO_COOKIE_);
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}

		if (jsonObj != null) {
			System.out.println(jsonObj.toString());
		}

	}
}
