package imp.core;


public class NetScanner {

	private IPObject start;
	private IPObject end;
	private IPObject subnet;
	/**
	 * Creates a new NetScanner object. Scans through all possible IPs in range
	 * @param start starting IPObject
	 * @param end ending IPObject
	 * @param subnet subnet mask
	 */
	public NetScanner(IPObject start, IPObject end, IPObject subnet) 
	{
		this.start  = start;
		this.end    = end;
		this.subnet = subnet;
	}


	
	public int getNumIP()
	{
		int num = 0;
		
		// If the addresses are the same, there's only one address to check
		if (end.equals(start))
		{
			System.out.println("Equals!");
			return 1;
		} else if (subnet.toString().equals("255.255.255.0"))
		{
			return end.get()[3] - start.get()[3] + 1;
		} else if (subnet.toString().equals("255.255.0.0"))
		{
			int q4 = end.get()[3] - start.get()[3] + 1;
			int q3 = ((end.get()[2] - start.get()[2]) * 255) + 1;
			return q4*q3;
		}
		
		for (int i = 3; i >= 0; i--)
		{
			System.out.println("["+i+"] Start: "+ start.get()[i] + " End: "+ end.get()[i] +" Subnet: "+ subnet.get()[i]);
			if (subnet.get()[i] == 255)
			{
				break;
			}
		}
		
		
		
		return num;
	}
	
	public int[] getIps()
	{
		
		return null;
	}
}
