package simple;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.text.DefaultEditorKit.CutAction;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TMon {
	
	private static HashMap<String, HashMap<String, String>> host2cookies = new HashMap<String, HashMap<String, String>>();

	private static void storeCookiesByHost(URL url, Connection con) {
	        try {
	            String host = url.getHost();
	            HashMap<String, String> cookies = host2cookies.get(host);
	            if (cookies == null) {
	                cookies = new HashMap<String, String>();
	                host2cookies.put(host, cookies);
	            }
	            cookies.putAll(con.response().cookies());
	            
	            cookies.put("abtype_cookie", "%7B%22v10%22%3A%22A%7C8952d253f0fff886ae9b4808cc9c2820%22%2C%22v16%22%3A%22B%7Cbbaf47bd6d7da3b07cd6fc6016ae5249%22%2C%22v17%22%3A%22E%7C477cab82b27539a6db245f36f8449db0%22%2C%22v18%22%3A%22A%7C92d79c88444deadb2d2ab4128a38af53%22%2C%22v19%22%3A%22B%7Ca5a38f9fdbbdedc0d2f91b48075d8c55%22%2C%22v23%22%3A%22B%7C5c05907055e1c2244c080d5bf85719fa%22%2C%22v28%22%3A%22B%7C9f9a80652e09c1ae6f746ba3eca23b77%22%2C%22v29%22%3A%22D%7C65c8063617d44f47da87e8843af1063d%22%2C%22v30%22%3A%22B%7Cb969c43647d60f4a5af2f618cf15c47c%22%2C%22v35%22%3A%22A%7Cd5ee4a1aced5d4375a444b1e1fedeb7b%22%2C%22v36%22%3A%22A%7C86eb60dfe42d94a799c3597edab93bfb%22%2C%22v40%22%3A%22A%7C1fd46e19ac1454574f59a380b879d155%22%2C%22v57%22%3A%22A%7Cafd89ae858058d48084c53c0901c4863%22%2C%22v59%22%3A%22A%7Cd469199538337c9c7e96f94a6d12044f%22%2C%22v63%22%3A%22A%7Ce27c4b912482e158389f2e9a62918acc%22%2C%22v66%22%3A%22A%7C0553e3a3d4c5c4c9fcc1ff6284bce1b5%22%2C%22v70%22%3A%22A%7Cc56e441ddab03be271c792fc8d1e2fc0%22%2C%22v71%22%3A%22A%7Cc47937ef6a26ef42118ae970122f5117%22%2C%22v72%22%3A%22A%7Ca998c774001942e578ff146fb5441c51%22%2C%22v73%22%3A%22A%7C8c49864baebb13bb2c7bb47536311ecc%22%7D"); 
	            cookies.put("optimizelySegments", "%7B%22918774107%22%3A%22ie%22%2C%22924286371%22%3A%22direct%22%2C%22930224925%22%3A%22false%22%7D");
	            cookies.put("optimizelyEndUserId", "oeu1403066093594r0.045222350040963644"); 
	            cookies.put("optimizelyBuckets", "%7B%7D"); 
	            cookies.put("__CT_Data", "gpv=15&apv_29209_www07=15"); 
	            cookies.put("WRUID", "0"); 
	            cookies.put("_ga", "GA1.3.1915360987.1403066094"); 
	            cookies.put("recent_view_key", "RECENTVIEW:d2e034a2-5534-4e21-8925-e09e4f0a5ff1"); 
	            cookies.put("__utma", "146648369.1915360987.1403066094.1403066103.1403068257.2"); 
	            cookies.put("tl_web", "%7B%22tl_s_id%22%3A%22d91b9892-7feb-416d-b61a-8dfa5cea7296%22%2C%22sid_ctime%22%3A1426559580%2C%22tl_aid%22%3A%22f108f4f4-ad25-4e23-934c-72db46fb063b%22%2C%22aid_ctime%22%3A1426559580%2C%22aid_ltime%22%3A1426559692%2C%22tl_seq%22%3A20%2C%22tl_aid_seq%22%3A20%2C%22tl_ab%22%3A%7B%22v10%22%3A%22A%22%2C%22v16%22%3A%22B%22%2C%22v17%22%3A%22E%22%2C%22v18%22%3A%22A%22%2C%22v19%22%3A%22B%22%2C%22v23%22%3A%22B%22%2C%22v28%22%3A%22B%22%2C%22v29%22%3A%22D%22%2C%22v30%22%3A%22B%22%2C%22v35%22%3A%22A%22%2C%22v36%22%3A%22A%22%2C%22v40%22%3A%22A%22%2C%22v57%22%3A%22A%22%2C%22v59%22%3A%22A%22%2C%22v63%22%3A%22A%22%2C%22v66%22%3A%22A%22%2C%22v70%22%3A%22A%22%2C%22v71%22%3A%22A%22%2C%22v72%22%3A%22A%22%2C%22v73%22%3A%22A%22%7D%2C%22ab_ver%22%3A%5B%5D%7D"); 
	            cookies.put("_gat", "1"); 
	            cookies.put("gmon_cd", "28260630"); 
	            cookies.put("PREV_PAGE", "http%3A%2F%2Fwww.ticketmonster.co.kr%2Fsearch%2F%3Fkeyword%3D%25EC%2595%2584%25EB%2594%2594%25EB%258B%25A4%25EC%258A%25A4%26keyword_view%3D%25EC%2595%2584%25EB%2594%2594%25EB%258B%25A4%25EC%258A%25A4%26uis%3Dd91b9892%26sarea%3Dg%26st%3D0"); 
	            cookies.put("CLK_AREA", ""); 
	            cookies.put("CLK_LINKORD", ""); 
	            cookies.put("home_planbanner", "1"); 
	            cookies.put("abtest_id", "929592577"); 
	            cookies.put("dontShow", "yes"); 
	            cookies.put("_gr_test_url", "0"); 
	            cookies.put("_gr_ep", "/home"); 
	            cookies.put("_gr_er", ""); 
	            cookies.put("gnb_banner_start", "1"); 
	            cookies.put("tmonhome_todayhot_slide_start", "2"); 
	            cookies.put("_gr_cc", "1"); 
	            cookies.put("_AT_vid", "TSL2YWYMXW9V6H895AB2BFQ8X1495310"); 
	            cookies.put("_gr_uuid", "074a8742-3437-49a8-bda7-c769d446dcd9"); 
	            cookies.put("_gr_ep_sent", "1");

	            System.out.println(host);
	            System.out.println(cookies);
	        } catch (Throwable t) {
	            // MTMT move to log
	            System.err.println(t.toString()+":: Error saving cookies from: " + url);
	        }    
	}   

	private static void loadCookiesByHost(URL url, Connection con) {
	    try {
	        String host = url.getHost();
	        if (host2cookies.containsKey(host)) {
	            HashMap<String, String> cookies = host2cookies.get(host);
	            for (Entry<String, String> cookie : cookies.entrySet()) {
	                con.cookie(cookie.getKey(), cookie.getValue());
	                System.out.println (cookie.getKey() +" : "+ cookie.getValue());
	            }
	        }
	    } catch (Throwable t) {
	        // MTMT move to log
	        System.err.println(t.toString()+":: Error loading cookies to: " + url);
	    }
	}

	public void getOuterPage(String keyword) throws UnsupportedEncodingException, IOException  {
		
		String key = URLEncoder.encode(keyword, "UTF-8");
		URL url = new URL("http://www.ticketmonster.co.kr/search/?keyword="+key+"&keyword_view="+key+"&uis=03d5e0a6&sarea=g&st=0");
		Connection con = Jsoup.connect(url.toString());
		
		Document doc = con.get();
		
		storeCookiesByHost(url, con);
		
		//System.out.println(doc.html());
		
	}

	public void getCookie(String keyword) throws UnsupportedEncodingException, IOException  {
		
		String key = URLEncoder.encode(keyword, "UTF-8");
		URL url = new URL("http://www.ticketmonster.co.kr/search/?keyword="+key+"&keyword_view="+key+"&uis=03d5e0a6&sarea=g&st=0");
		Connection con = Jsoup.connect(url.toString());
		
		Document doc = con.userAgent("Mozilla").get();
		
		Map<String, String> cookies  = con.response().cookies();
		
		System.out.println(cookies);
		
		for (Entry<String, String> cookie : cookies.entrySet()) {
			System.out.println (cookie.getKey() +" : "+ cookie.getValue());
        }
	}
		
	
	public void getDealList() throws UnsupportedEncodingException, IOException  {
		
		//boolean first  = true;

		URL url = new URL("http://www.ticketmonster.co.kr/search/getDealsContents");
		
		Connection con = Jsoup.connect(url.toString());
		loadCookiesByHost(url, con);
		Document doc = con.data("srch", URLEncoder.encode("{\"keyword\":\"아디다스\",\"cat_srl\":0,\"sortby\":\"popular\",\"filter\":{\"delivery\":[],\"price\":[]},\"idx\":0,\"deal_srls\":[]}", "UTF-8"))
							.userAgent("Mozilla").timeout(3000).post(); 
		
		System.out.println(doc.html());

		/*
		Elements title = doc.select("li._product_list");

		for(Element li : title){
			if(first) {
				System.out.println("Product Category : " + li.select("div.info > span.depth").text());
				first = false;
			}
			System.out.println(li.select("div.info > span.price > em").text() + "::: " 
					  			+ li.select("a.tit").text() );
		}
		*/

	}
	
	public String getSearchParam() {
		String result = null;
		
		return result;
	}

	public static void main(String[] args) throws Exception {
		
		TMon shopping = new TMon();
		
		shopping.getOuterPage("아디다스");
		
		//shopping.getCookie("아디다스");

		shopping.getDealList();
	}
	
	

}
