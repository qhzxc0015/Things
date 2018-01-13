import java.io.IOException;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * 数据类型：
"address":"江苏省扬州市观海二广场93号-15-4",
"school":"北京中医药大学",
"sex":"男",
"name":"夏旭",
"Tel":"13107490776",
"email":"kakl4vp@0355.net"
 * 
 *
 */
public class es_rest {
	public static void main(String[] args) throws IOException {
		JSONObject data_to_web = new JSONObject();
		String type="sex";
		String str="男";
		long begin= System.currentTimeMillis();
		//检索数据
		System.out.println("关键词"+"'"+str+"'"+"总共命中条数："+search_index_total(type,str));
		long end= System.currentTimeMillis();
		System.out.println("耗时:"+new create_data().getTime(begin, end)+"秒");
				int num=200000;//构建索引条数
		//构建索引
		create_index(num);
		
		}

public static int search_index_total(String type,String str){
	//检索数据
	JSONObject query_body = new JSONObject();
	JSONObject match_body = new JSONObject();
	JSONObject null1 = new JSONObject();
	null1.put(type, str);
	query_body.put("query", match_body);
	match_body.put("match_phrase", null1);
	JSONObject es_cluster_command = query_body;
	String es_cluster_url1 = "http://202.193.75.175:9200/person2/info/_search?pretty";
	JSONObject response1 = JSONObject.parseObject(HttpClientWeapon.ExecuteHttpPost(es_cluster_url1, es_cluster_command));
	return	response1.getJSONObject("hits").getIntValue("total");
}


public static void create_index(int num){
	//构建索引
	JSONObject person = new JSONObject(datas.getJson());
	int i;
	for (i=num;i>1000;i--){
	String es_cluster_url2 = "http://202.193.75.175:9200/person2/info/"+Integer.toString(i);
//	System.out.println(es_cluster_url2);
	JSONObject response2 = JSONObject.parseObject(HttpClientWeapon.ExecuteHttpPost(es_cluster_url2, person));
	}
	System.out.println("success");
}

}
/**
 * 常用查询
 * 列出所有索引：curl '202.193.75.175:9200/_cat/indices?v'
 * 是否健康：curl 'localhost:9200/_cat/health?v'
 */



/**
 * 构建索引
curl -XPOST "http://202.193.74.70:9200/person3/info/1" -d'
{
  "name": "啊1",
  "sex": "啊1",
  "email": "啊1",
  "school": "a",
  "Tel": "1啊"
}'

curl -XPOST "http://202.193.74.70:9200/person3/info/1" -d'
{
  "name": "啊1",
  "sex": "啊1",
  "email": "啊1",
  "Tel": "1啊"
}'
 * 检索数据
curl -XGET "http://202.193.74.70:9200/person2/info/_search" -d'
{
  "size": 100,
  "query": {
  "match_phrase": {
  "school": "大学"
  }
  }
}'
**/