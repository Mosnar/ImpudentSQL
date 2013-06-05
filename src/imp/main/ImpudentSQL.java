package imp.main;

import imp.core.IPObject;
import imp.core.NetScanner;
import java.util.Scanner;

public class ImpudentSQL {
	
	private static IPObject start;
	private static IPObject end;
	
	public static void main(String[] args)
	{
		String startS;
		String endS;
		
		final NetScanner scan = new NetScanner();
		Scanner reader = new Scanner(System.in);
		
		
		do {
		System.out.println("Start address (x.x.x.x): ");
		startS = reader.nextLine();
		} while(!scan.isIPAddress(startS));
		
		start = new IPObject(startS);
		
		do {
		System.out.println("End address (x.x.x.x): ");
		endS = reader.nextLine();
		} while(!scan.isIPAddress(startS));

		end   = new IPObject(endS);
	}
}
