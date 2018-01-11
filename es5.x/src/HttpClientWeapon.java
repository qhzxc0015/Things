import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.client.Client;

import com.alibaba.fastjson.JSONObject;


public class HttpClientWeapon {


	public static String ExecuteHttpGet(String url) throws IOException {
		
		return ExecuteHttpGet(url, "utf-8");
	}
	
	public static String ExecuteHttpGet(String url, String encoding) throws IOException {
		
		String response = null;
		
		CloseableHttpClient http_client = HttpClients.createDefault();
		CloseableHttpResponse http_response = null;
		HttpGet http_get = new HttpGet(url);

		
		try {
			
			http_response = http_client.execute(http_get);
			HttpEntity entity = http_response.getEntity();
			InputStream stream = entity == null ? null : entity.getContent();
			response = stream == null ? response : IOUtils.toString(stream, encoding);
		} 
		catch (Exception e) { e.printStackTrace(); } 
		finally { try { http_response.close(); } catch (IOException e) { e.printStackTrace(); } }
		
		return response;
	}

	public static String ExecuteHttpPost(String url, JSONObject params) {
		
		return ExecuteHttpPost(url, params, "utf-8");
	}
	
	public static String ExecuteHttpPost(String url, JSONObject params, String encoding) {
		
		String response = null;
		
		CloseableHttpClient http_client = HttpClients.createDefault();
		CloseableHttpResponse http_response = null;
		HttpPost http_post = new HttpPost(url);
		
		//http_post.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)"); 
		http_post.addHeader("Content-type","application/json; charset=" + encoding);  
		http_post.setHeader("Accept", "application/json"); 
		http_post.setEntity(new StringEntity(params.toJSONString(), Charset.forName(encoding))); 
		
		try {
			
			http_response = http_client.execute(http_post);
			HttpEntity entity = http_response.getEntity();
			InputStream stream = entity == null ? null : entity.getContent();
			response = stream == null ? response : IOUtils.toString(stream, encoding);	
			
		} 
		catch (Exception e) { e.printStackTrace(); } 
		finally { try { http_response.close(); } catch (IOException e) { e.printStackTrace(); } }
		
		return response;
	}

	public static String ExecuteHttpPost(String url, Map<String, String> params) {
		
		return ExecuteHttpPost(url, params, "utf-8");
	}
	
	public static String ExecuteHttpPost(String url, Map<String, String> params, String encoding) {
		
		String response = null;
		
		CloseableHttpClient http_client = HttpClients.createDefault();
		CloseableHttpResponse http_response = null;
		HttpPost http_post = new HttpPost(url);
		
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		
		if (null != params) {
			
			for(Entry<String, String> temp_pair : params.entrySet()) nvps.add(new BasicNameValuePair(temp_pair.getKey(), temp_pair.getValue()));
		}
		
		//http_post.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)"); 
		http_post.addHeader("Content-type","application/json; charset=" + encoding);  
		http_post.setHeader("Accept", "application/json"); 
		http_post.setEntity(new UrlEncodedFormEntity(nvps, Charset.forName(encoding))); 
		
		try {
			
			http_response = http_client.execute(http_post);
			HttpEntity entity = http_response.getEntity();
			InputStream stream = entity == null ? null : entity.getContent();
			response = stream == null ? response : IOUtils.toString(stream, encoding);
		} 
		catch (Exception e) { e.printStackTrace(); } 
		finally { try { http_response.close(); } catch (IOException e) { e.printStackTrace(); } }
		
		return response;
	}
}
