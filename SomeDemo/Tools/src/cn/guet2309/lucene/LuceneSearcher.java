package cn.guet2309.lucene;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

import cn.guet2309.entity.TourInformation;
import cn.guet2309.util.IndexWRUtil;


public class LuceneSearcher {
	private IndexReader ireader;
	private IndexSearcher isearcher;
	private static QueryParser qparser;
	static{
		String[] queryFields = { "infoName", "infoAddress", "infoIntro" };
		qparser = new MultiFieldQueryParser(Version.LUCENE_36, queryFields, new IKAnalyzer(true));
		qparser.setDefaultOperator(QueryParser.AND_OPERATOR);
	}
	public LuceneSearcher(){
		String directory ="D:\\GLTSearch";
		ireader = IndexWRUtil.getIndexReader(directory);
		isearcher = new IndexSearcher(ireader);
	}
	
	public ArrayList<TourInformation> search(String keyword, int N) {
		ArrayList<TourInformation> results = new ArrayList<TourInformation>();
		try {
			Query query = qparser.parse(keyword);
			TopDocs hits = isearcher.search(query, N);
			for (ScoreDoc scoreDoc : hits.scoreDocs) {
				Document document = isearcher.doc(scoreDoc.doc);
				results.add(new TourInformation(document.get("infoAutoID"),
						document.get("infoName"), document.get("infoIntro"),
						document.get("infoAddress"), document.get("infoTel"),
						document.get("infoKeyWord"), document.get("infoDPContent"), 
						document.get("productName")));
			}
		} catch (CorruptIndexException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return results;
	}
}
