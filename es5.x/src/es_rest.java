import java.io.IOException;

import com.alibaba.fastjson.JSONObject;
public class es_rest {
	public static void main(String[] args) throws IOException {
		JSONObject data_to_web = new JSONObject();
		JSONObject query_body = new JSONObject();
		JSONObject match_body = new JSONObject();
		JSONObject null1 = new JSONObject();
		query_body.put("query", match_body);
		match_body.put("match_all", null1);
		JSONObject es_cluster_command = query_body;
		String es_cluster_url = "http://202.193.74.70:9200/person2/info/_search";
		JSONObject response = JSONObject
				.parseObject(HttpClientWeapon.ExecuteHttpPost(es_cluster_url, es_cluster_command));
		System.out.println(response);
		}
	}
/**
 * 构建索引
curl -XPOST "http://202.193.74.70:9200/person2/info/1" -d'
{
  "name": "啊1",
  "sex": "啊1",
  "email": "啊1",
  "school": "a",
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