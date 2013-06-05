package imp.main;

import imp.core.IPObject;
import imp.core.NetScanner;
import java.util.Scanner;

public class ImpudentSQL {
	
	private static IPObject start;
	private static IPObject end;
	private static IPObject subnet;
	
	public static void main(String[] args)
	{
		String startS;
		String endS;
		String subnetS;
		
		Scanner reader = new Scanner(System.in);
		
		
		do {
		System.out.println("Start address (x.x.x.x): ");
		startS = reader.nextLine();
		} while(!isIPAddress(startS));
		
		start = new IPObject(startS);
		
		do {
		System.out.println("End address (x.x.x.x): ");
		endS = reader.nextLine();
		} while(!isIPAddress(startS));

		end   = new IPObject(endS);
		
		do {
		System.out.println("Subnet Mask (x.x.x.x): ");
		subnetS = reader.nextLine();
		} while(!isIPAddress(subnetS));

		subnet   = new IPObject(subnetS);
		
		
		final NetScanner scan = new NetScanner(start, end, subnet);
		
		System.out.println(scan.getNumIP());
	}
	
	public static boolean isIPAddress(String ipAddress) 
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
}
