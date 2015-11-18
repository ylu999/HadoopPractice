package rpc;

import org.apache.hadoop.ipc.VersionedProtocol;

public interface MyBizable extends VersionedProtocol{
	public static long VERSION = 123123123123L;

	public abstract String hello(String name);

}