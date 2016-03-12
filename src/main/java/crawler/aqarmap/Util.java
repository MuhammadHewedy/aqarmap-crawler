package crawler.aqarmap;

import java.util.concurrent.Future;

import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.DomSerializer;
import org.htmlcleaner.HtmlCleaner;
import org.w3c.dom.Document;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;

public class Util {

	public static final String PAGE_PARAM = "page";
	public static final String BASE_URL = "https://ksa.aqarmap.com";
	public static final String SEARCH_URL = "/ar/for-rent/apartment/riyadh/?minPrice=0&maxPrice=999999&photos=1";

	public static Document fromUrl(String url) {
		AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
		Future<Response> future = asyncHttpClient.prepareGet(url).execute();
		Document doc;
		try {
			doc = new DomSerializer(new CleanerProperties())
					.createDOM(new HtmlCleaner().clean(future.get().getResponseBody()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			asyncHttpClient.close();
		}
		return doc;
	}
}
