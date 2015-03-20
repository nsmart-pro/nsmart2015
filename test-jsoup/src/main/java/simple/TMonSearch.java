package simple;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.URL;
import java.net.URLEncoder;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TMonSearch {
 
  private List<String> cookies;
  private HttpURLConnection conn;
 
  private final String USER_AGENT = "Mozilla/5.0";
 
  public static void main(String[] args) throws Exception {
 
	String key = URLEncoder.encode("아디다스", "UTF-8");
	String url_outer = "http://www.ticketmonster.co.kr/search/?keyword="+key+"&keyword_view="+key+"&uis=03d5e0a6&sarea=g&st=0";
	String url_inner = "http://www.ticketmonster.co.kr/search/getDealsContents";
	//String gmail = "https://mail.google.com/mail/";
 
	TMonSearch http = new TMonSearch();
 
	// make sure cookies is turn on
	CookieHandler.setDefault(new CookieManager());
 
	// 1. Send a "GET" request, so that you can extract the form's data.
	String page = http.GetPageContent(url_outer);
	
	
 
	// 2. Construct above post's content and then send a POST request for
	String postParams = http.getFormParams(page);
	http.sendPost(url_inner, postParams);
 
	// 3. success then go to gmail.
	//String result = http.GetPageContent(gmail);
	//System.out.println(result);
  }
 
  private void sendPost(String url, String postParams) throws Exception {
 
	URL obj = new URL(url);
	conn = (HttpURLConnection) obj.openConnection();
 
	// Acts like a browser
	conn.setUseCaches(false);
	conn.setRequestMethod("POST");
	conn.setRequestProperty("Host", "accounts.google.com");
	conn.setRequestProperty("User-Agent", USER_AGENT);
	conn.setRequestProperty("Accept",
		"text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
	conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
	for (String cookie : this.cookies) {
		conn.addRequestProperty("Cookie", cookie.split(";", 1)[0]);
	}
	conn.setRequestProperty("Connection", "keep-alive");
	conn.setRequestProperty("Referer", "https://accounts.google.com/ServiceLoginAuth");
	conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	conn.setRequestProperty("Content-Length", Integer.toString(postParams.length()));
 
	conn.setDoOutput(true);
	conn.setDoInput(true);
 
	// Send post request
	DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
	wr.writeBytes(postParams);
	wr.flush();
	wr.close();
 
	int responseCode = conn.getResponseCode();
	System.out.println("\nSending 'POST' request to URL : " + url);
	System.out.println("Post parameters : " + postParams);
	System.out.println("Response Code : " + responseCode);
 
	BufferedReader in = 
             new BufferedReader(new InputStreamReader(conn.getInputStream()));
	String inputLine;
	StringBuffer response = new StringBuffer();
 
	while ((inputLine = in.readLine()) != null) {
		response.append(inputLine);
	}
	in.close();
	
	System.out.println(response.toString());
 
  }
 
  private String GetPageContent(String url) throws Exception {
 
	URL obj = new URL(url);
	conn = (HttpURLConnection) obj.openConnection();
 
	// default is GET
	conn.setRequestMethod("GET");
 
	conn.setUseCaches(false);
 
	// act like a browser
	conn.setRequestProperty("User-Agent", USER_AGENT);
	conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
	conn.setRequestProperty("Accept-Language", "ko-KR,ko;q=0.8,en-US,en;q=0.5");
	conn.setRequestProperty("Accept-Charset", "windows-949,utf-8;q=0.7,*;q=0.3");
	conn.setRequestProperty("Connection", "keep-alive");
	if (cookies != null) {
		for (String cookie : this.cookies) {
			conn.addRequestProperty("Cookie", cookie.split(";", 1)[0]);
		}
	}
	int responseCode = conn.getResponseCode();
	System.out.println("\nSending 'GET' request to URL : " + url);
	System.out.println("Response Code : " + responseCode);
 
	BufferedReader in = 
            new BufferedReader(new InputStreamReader(conn.getInputStream()));
	String inputLine;
	StringBuffer response = new StringBuffer();
 
	while ((inputLine = in.readLine()) != null) {
		response.append(inputLine);
	}
	in.close();
 
	// Get the response cookies
	setCookies(conn.getHeaderFields().get("Set-Cookie"));
 
	return response.toString();
 
  }
 
  public String getFormParams(String html)
		throws UnsupportedEncodingException {
 
	List<String> paramList = new ArrayList<String>();
	
	String key = "srch";
	String value = URLEncoder.encode("{\"keyword\":\"아디다스\",\"cat_srl\":0,\"sortby\":\"popular\",\"filter\":{\"delivery\":[],\"price\":[]},\"idx\":0,\"deal_srls\":[]}", "UTF-8");
	paramList.add("srch" + "=" + value);
 
	// build parameters list
	StringBuilder result = new StringBuilder();
	for (String param : paramList) {
		if (result.length() == 0) {
			result.append(param);
		} else {
			result.append("&" + param);
		}
	}
	return result.toString();
  }
 
  public List<String> getCookies() {
	return cookies;
  }
 
  public void setCookies(List<String> cookies) {
	this.cookies = cookies;
  }
 
}