package cn.guet2309.client;

import cn.guet2309.lucene.LuceneIndexer;
import cn.guet2309.lucene.LuceneSearcher;

public class LuceneClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new LuceneIndexer("D:\\GLTSearch").createIndex();
		new LuceneSearcher().search("∆°æ∆”„", 10);

	}

}
