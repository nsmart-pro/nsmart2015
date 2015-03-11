package simple;


import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.swing.text.DefaultEditorKit.CutAction;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NaverShopping {
	
	public String cutString(String target){
		String result = null;
		
		if(target != null || target.length() == 0){
			for(int i = 0; i < target.length(); i++){
				if(Character.getType(target.charAt(i)) == 5){
					result = target.substring(0, i);
					break;
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		
		boolean first  = true;
		
		String key = URLEncoder.encode("오렌지", "UTF-8"); 
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

}
