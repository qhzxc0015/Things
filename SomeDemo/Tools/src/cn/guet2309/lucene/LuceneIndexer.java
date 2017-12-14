package cn.guet2309.lucene;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.Directory;

import cn.guet2309.util.DatabaseManager;
import cn.guet2309.util.IndexWRUtil;


public class LuceneIndexer {
	private IndexWriter iWriter;
	
    public LuceneIndexer(Directory directory){
    	this.iWriter = IndexWRUtil.getIndexWriter(directory);
    }
    public LuceneIndexer(String directory){
    	this.iWriter = IndexWRUtil.getIndexWriter(directory);
    }
    public LuceneIndexer(){};
    
    public void createIndex1(){
    	int N=0,M=20000;
    	DatabaseManager dm = new DatabaseManager();
    	while(N<=100000){
    		String sqlwords = "select * from guilin limit "+N+","+M;
    		ResultSet result = dm.executeQuery(sqlwords);
    		N+=M;
    		try {
				while (result.next()) {
					int infoAutoID = 0;
					infoAutoID = result.getInt(2);
					String infoName = null;
					if ((infoName = result.getString(5)) == null) {
						infoName = "null";
					}
					String infoIntro = null;
					if ((infoIntro = result.getString(6)) == null) {
						infoIntro = "null";
					}
					String infoAddress = null;
					if ((infoAddress = result.getString(7)) == null) {
						infoAddress = "null";
					}
					String infoTel = null;
					if ((infoTel = result.getString(4)) == null) {
						infoTel = "null";
					}
					String infoKeyWord = null;
					if ((infoKeyWord = result.getString(8)) == null) {
						infoKeyWord = "null";
					}
					String infoDPContent = null;
					if ((infoDPContent = result.getString(13)) == null) {
						infoDPContent = "null";
					}
					String productName = null;
					if ((productName = result.getString(10)) == null) {
						productName = "null";
					}
					Document doc = new Document();
					doc.add(new Field("infoAutoID", "" + infoAutoID,Field.Store.YES, Field.Index.ANALYZED));
					Field infoNameF = new Field("infoName", infoName,Field.Store.YES, Field.Index.ANALYZED);
					infoNameF.setBoost(3);
					doc.add(infoNameF);
					doc.add(new Field("infoIntro", infoIntro, Field.Store.YES,Field.Index.ANALYZED));
					doc.add(new Field("infoAddress", infoAddress, Field.Store.YES,Field.Index.ANALYZED));
					doc.add(new Field("infoTel", infoTel, Field.Store.NO,Field.Index.ANALYZED));
					doc.add(new Field("infoKeyWord", infoKeyWord, Field.Store.NO,Field.Index.ANALYZED));
					doc.add(new Field("infoDPContent", infoDPContent,Field.Store.NO, Field.Index.ANALYZED));
					doc.add(new Field("productName", productName, Field.Store.NO,Field.Index.ANALYZED));
					
					iWriter.addDocument(doc);
				}
			} catch (CorruptIndexException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					if(result!=null)
						result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
    	}
    }
    public void createIndex(){
    	DatabaseManager dm = new DatabaseManager();
    		String sqlwords = "select * from guilin";
    		ResultSet result = dm.executeQuery(sqlwords);
    		try {
				while (result.next()) {
					int infoAutoID = 0;
					infoAutoID = result.getInt(2);
					String infoName = null;
					if ((infoName = result.getString(5)) == null) {
						infoName = "null";
					}
					String infoIntro = null;
					if ((infoIntro = result.getString(6)) == null) {
						infoIntro = "null";
					}
					String infoAddress = null;
					if ((infoAddress = result.getString(7)) == null) {
						infoAddress = "null";
					}
					String infoTel = null;
					if ((infoTel = result.getString(4)) == null) {
						infoTel = "null";
					}
					String infoKeyWord = null;
					if ((infoKeyWord = result.getString(8)) == null) {
						infoKeyWord = "null";
					}
					String infoDPContent = null;
					if ((infoDPContent = result.getString(13)) == null) {
						infoDPContent = "null";
					}
					String productName = null;
					if ((productName = result.getString(10)) == null) {
						productName = "null";
					}
					Document doc = new Document();
					doc.add(new Field("infoAutoID", "" + infoAutoID,Field.Store.YES, Field.Index.ANALYZED));
					Field infoNameF = new Field("infoName", infoName,Field.Store.YES, Field.Index.ANALYZED);
					infoNameF.setBoost(3);
					doc.add(infoNameF);
					doc.add(new Field("infoIntro", infoIntro, Field.Store.YES,Field.Index.ANALYZED));
					doc.add(new Field("infoAddress", infoAddress, Field.Store.YES,Field.Index.ANALYZED));
					doc.add(new Field("infoTel", infoTel, Field.Store.NO,Field.Index.ANALYZED));
					doc.add(new Field("infoKeyWord", infoKeyWord, Field.Store.NO,Field.Index.ANALYZED));
					doc.add(new Field("infoDPContent", infoDPContent,Field.Store.NO, Field.Index.ANALYZED));
					doc.add(new Field("productName", productName, Field.Store.NO,Field.Index.ANALYZED));
					
					iWriter.addDocument(doc);
				}
			} catch (CorruptIndexException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					if(result!=null)
						result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
    }

}
