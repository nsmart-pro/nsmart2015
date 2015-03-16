package simple;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.swing.text.DefaultEditorKit.CutAction;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NaverShopping {
	
	public void printPricesOf(String keyword) throws UnsupportedEncodingException, IOException  {
		
		boolean first  = true;

		String key = URLEncoder.encode(keyword, "UTF-8");
		Document doc = Jsoup.connect("http://shopping.naver.com/search/all_search.nhn?query="+key+"&cat_id=&frm=NVSHSRC").get();
		Elements title = doc.select("li._product_list");

		for(Element li : title){
			if(first) {
				System.out.println("Product Category : " + li.select("div.info > span.depth").text());
				first = false;
			}
			System.out.println(li.select("div.info > span.price > em").text() + "::: " 
					  			+ li.select("a.tit").text() );
		}

	}
	
	public void test(String keyword) throws UnsupportedEncodingException, IOException  {
		
		boolean first  = true;

		String key = URLEncoder.encode(keyword, "UTF-8");
		Document doc = Jsoup.connect("http://search.naver.com/search.naver?where=nexearch&query="+key+"&sm=top_hty&fbm=1&ie=utf8").get();
		Elements title = doc.select("li._product_list");

		for(Element li : title){
			if(first) {
				System.out.println("Product Category : " + li.select("div.info > span.depth").text());
				first = false;
			}
			System.out.println(li.select("div.info > span.price > em").text() + "::: " 
					  			+ li.select("a.tit").text() );
		}

	}

	public static void main(String[] args) throws Exception {
		
		NaverShopping shopping = new NaverShopping();
		
		shopping.printPricesOf("바나나");
		//shopping.test("운동화");

	}
	
	

}
