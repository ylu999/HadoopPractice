package rpc;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.VersionedProtocol;

public class MyClient {
	public static void main(String[] args){
		Class<? extends VersionedProtocol> protocol = MyBizable.class;
		InetSocketAddress addr = new InetSocketAddress(MyServer.SERVER_ADDRESS,MyServer.PORT);
		Configuration conf = new Configuration();
		try {
			final MyBizable proxy = (MyBizable)RPC.waitForProxy(protocol, MyBizable.VERSION, addr, conf);
			System.out.println(proxy.hello("from Client"));
			RPC.stopProxy(proxy);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
