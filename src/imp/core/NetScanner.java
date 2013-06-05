package imp.core;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetScanner {

	public NetScanner() 
	{
	
	}

	public boolean isIPAddress(String ipAddress) 
	{
		String[] tokens = ipAddress.split("\\.");
		if (tokens.length != 4) {
			return false;
		}
		for (String str : tokens) {
			int i = Integer.parseInt(str);
			if ((i < 0) || (i > 255)) {
				return false;
			}
		}
		return true;
	}
	
	public int[] splitIP()
	{
		return null;
	}
	
	public int getNumIP(String start, String end)
	{
		int num = 0;

		
		
		return num;
	}
	
	public int[] getIps(String start, String end)
	{
		
		return null;
	}
}
