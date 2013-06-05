package imp.core;

public class IPObject {
	
	private int[] addr;
	public boolean scanned;
	public boolean vulnderable;
	public serverType serverType;
	
	/**
	 * Constructor
	 * @param ipAd ip address as a string (xxx.xxx.xxx.xxx)
	 */
	public IPObject(String ipAd)
	{
		addr = new int[4];
		String[] splits = ipAd.split("\\.");
		for (int i = 0; i < 4; i++)
		{
			addr[i] = Integer.parseInt(splits[i]);
		}
		scanned = false;
		serverType = imp.core.serverType.UNKNOWN;
	}
	
	/**
	 * Return a human readable string (xxx.xxx.xxx.xxx)
	 */
	public String toString()
	{
		return addr[0]+"."+addr[1]+"."+addr[2]+"."+addr[3];
	}
	
	/**
	 * Return the ip array
	 * @return ip int array
	 */
	public int[] get()
	{
		return addr;
	}
	
	/**
	 * Do two IPObjects equal eachother
	 * @param comp
	 * @return true or false
	 */
	public boolean equals(IPObject comp)
	{
		boolean c1 = (this.addr[0] == comp.addr[0]);
		boolean c2 = (this.addr[1] == comp.addr[1]);
		boolean c3 = (this.addr[2] == comp.addr[2]);
		boolean c4 = (this.addr[3] == comp.addr[3]);
		
		return (c1 && c2 && c3 && c4);
	}
}
