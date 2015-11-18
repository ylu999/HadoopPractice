package hdfs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class App2 {
	public static final String HDFS_PATH = "hdfs://hadoop:9000/";

	public static void main(String[] args) {
		final URI uri;
		final FileSystem fileSystem;
		try {
			uri = new URI(HDFS_PATH);
			fileSystem = FileSystem.get(uri,new Configuration());
			mkdir(fileSystem,"abc");
			//System.out.println(readData(fileSystem,"/dddddddddddddddd.txt"));
			//deleteData(fileSystem,"d1000/eula.1028.txt");
			
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void mkdir(final FileSystem fileSystem,final String folder){
		try {
			fileSystem.mkdirs(new Path(folder));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void uploadData(final FileSystem fileSystem,final String from, final String to){
		try {
			FSDataOutputStream ouput = fileSystem.create(new Path(to));
			FileInputStream input = new FileInputStream(from);
			IOUtils.copyBytes(input, ouput, 1024,true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void downloadData(final FileSystem fileSystem,final String from, final String to){
		try {
			FSDataInputStream input = fileSystem.open(new Path(from));
			FileOutputStream output = new FileOutputStream(to);
			IOUtils.copyBytes(input, output, 1024,true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String readData(final FileSystem fileSystem,final String file){
		try {
			FSDataInputStream input = fileSystem.open(new Path(file));
			StringWriter writer = new StringWriter();
			org.apache.commons.io.IOUtils.copy(input, writer);
			return writer.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void deleteData(final FileSystem fileSystem,final String file){
		try {
			fileSystem.delete(new Path(file), true); // true to delete either file or folder
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
