package imp.main;

import imp.core.IPObject;
import imp.model.NetScanner;
import imp.view.MainScreen;

import java.util.ArrayList;
import java.util.Scanner;

public class ImpudentSQL {
	
	private static IPObject start;
	private static IPObject end;
	
	public static void main(String[] args) {
		String startS;
		String endS;
		
		Scanner reader = new Scanner(System.in);
		
		// Start the GUI
		new MainScreen();
		
		
		// Get the start address
		do {
		System.out.println("Start address (x.x.x.x): ");
		startS = reader.nextLine();
		} while(!isIPAddress(startS));
		start = new IPObject(startS);

		// Get the end address
		do {
		System.out.println("End address (x.x.x.x): ");
		endS = reader.nextLine();
		} while(!isIPAddress(startS));
		end   = new IPObject(endS);

		reader.close();
		
		final NetScanner scan = new NetScanner(start, end);
		ArrayList<IPObject> entries = scan.getIps();
		for(IPObject entry : entries)
		{
			System.out.println(entry);
		}
	}
	
	/**
	 * This method will check if a string matches the correct format of an
	 * IPv4 address
	 * @param ipAddress string ip address (x.x.x.x)
	 * @return true or false
	 */
	public static boolean isIPAddress(String ipAddress) {
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
