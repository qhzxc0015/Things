package cn.guet2309.util;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class IndexWRUtil {
	private static IndexWriter iWriter;
	private static IndexReader iReader;
	
	public static IndexWriter getIndexWriter(Directory dir){
		if(iWriter == null){
			Analyzer analyzer = new IKAnalyzer(true);
			IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_36, analyzer);
			try {
				if(IndexWriter.isLocked(dir))
					IndexWriter.unlock(dir);
				iWriter = new IndexWriter(dir, iwc);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return iWriter;
	}
	
	public static IndexWriter getIndexWriter(String directory){
		try {
			return getIndexWriter(FSDirectory.open(new File(directory)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static IndexReader getIndexReader(Directory directory){
		try {
			if(iReader == null){
				iReader = IndexReader.open(directory);
			}else{
				IndexReader ir = IndexReader.openIfChanged(iReader);
				if(ir != null){
					iReader.close();
					iReader = ir;
				}
			}
		} catch (CorruptIndexException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return iReader;
	}
	
	public static IndexReader getIndexReader(String directory){
		try {
			return getIndexReader(FSDirectory.open(new File(directory)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void closeIndexWriter(){
		try {
			iWriter.close();
		} catch (CorruptIndexException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void closeIndexReader(){
		try {
			iReader.close();
		} catch (CorruptIndexException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
