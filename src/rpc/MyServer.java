package rpc;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Server;

public class MyServer {
	public static final String SERVER_ADDRESS = "localhost";
	public static final int PORT = 12345;
	public static void main(String[] args){
		try {
			final Server server = RPC.getServer(new MyBiz(), SERVER_ADDRESS, PORT, new Configuration());
			server.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
