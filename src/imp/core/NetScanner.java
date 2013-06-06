package imp.core;

import java.util.ArrayList;


public class NetScanner {

	private IPObject start;
	private IPObject end;
	
	/**
	 * Creates a new NetScanner object. Scans through all possible IPs in range
	 * @param start starting IPObject
	 * @param end ending IPObject
	 * @param subnet subnet mask
	 */
	public NetScanner(IPObject start, IPObject end) 
	{
		this.start  = start;
		this.end    = end;
	}

	/**
	 * Generates an ArrayList of scannable IP objects
	 * @return ArrayList of ip objects
	 */
	public ArrayList<IPObject> getIps()
	{
		ArrayList<IPObject> entries = new ArrayList<IPObject>();
        for (long i = start.toInt(); i <= end.toInt(); i++) 
        {
            String address = intToIp(i);
            entries.add(new IPObject(address));
        }
		return entries;
	}
	
	/**
	 * Static method to convert an integer back into an IPv4 address
	 * @param ipAddress
	 * @return
	 */
    public String intToIp(long ipAddress) {
        long octet1 = (ipAddress & 0xFF000000) >>> 24;
        long octet2 = (ipAddress & 0xFF0000) >>> 16;
        long octet3 = (ipAddress & 0xFF00) >>> 8;
        long octet4 = ipAddress & 0xFF;
        
        return new StringBuffer().append(octet1).append('.').append(octet2)
                                 .append('.').append(octet3).append('.')
                                 .append(octet4).toString();
    }
}
