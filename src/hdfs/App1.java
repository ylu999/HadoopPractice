package hdfs;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;

public class App1 {
	public static final String HDFS_PATH = "hdfs://hadoop:9000/";
	public static void main(String[] args) {
		URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
		try {
			final URL url = new URL(HDFS_PATH+"user/yushan/dddddddddddddddd.txt");
			final InputStream in = url.openStream();
			IOUtils.copyBytes(in,System.out,1024,true);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

}
