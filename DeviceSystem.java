//Sophia Chang, CIS 340, T/TH 3:00

import java.util.ArrayList;
import java.util.Scanner;

public class DeviceSystem {
	ArrayList<Device> deviceList = new ArrayList<Device>();
	
	//class variables 
	String name = "";
	String sku = "";
	boolean availability = true;
	
	//object tmpDevice
	Device tmpDevice = new Device(sku, name, availability);
	
	//add sample data into the system
	public void loadSampleData() {
		Device d1 = new Device("Apple 9.7-inch iPad Pro", "6757A", true);
		Device d2 = new Device("Amazon Kindle Fire Kids Edition", "93P51B", true);
		Device d3 = new Device("LeapFrog Epic Learning Tablet", "10N8C", true);
		Device d4 = new Device("Amazon Kindle Fire HD 8", "85U20", false);
		Device d5 = new Device("HP Envy 8 Note", "91H2D", true);
		
		deviceList.add(d1);
		deviceList.add(d2);
		deviceList.add(d3);
		deviceList.add(d4);
		deviceList.add(d5);
	} //end loadSampleData method
	
	//list all devices 
	public void displayDevices() {
		System.out.printf("\n%-2s %-10s %-50s", "#", "SKU", "Name");
		String availability = "";
		
		//loop to print out all devices
		for (int i = 0; i < deviceList.size(); i++) {
			//print available/checked out instead of true/false
			if (deviceList.get(i).getAvailability() == true) {
				availability = "Available";
			} //end nested if
			else 
				availability = "Checked Out";
			
			System.out.printf("\n%-2d %-10s %-50s %-15s", i+1, deviceList.get(i).getSku(), deviceList.get(i).getName(), availability);
		} //end for loop
	} //end displayDevices method
	
	public void addDevice() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("\nEnter Device name: ");
		name = scanner.nextLine();
		tmpDevice.setName(name);
		
		System.out.print("Enter Device SKU code: ");
		sku = scanner.nextLine();
		tmpDevice.setSku(sku);
		
		tmpDevice.setAvailability(true);
		deviceList.add(tmpDevice);
		System.out.println("\nDevice added to library");
		
		displayDevices();
		System.out.println("\n\nPress ENTER to continue...");
		String input = scanner.nextLine();
	} //end addDevice method
	
	public void editDevice() {
		Scanner scanner = new Scanner(System.in);
		int number = 0;
		
		displayDevices();
		System.out.print("\n\nEnter Device number to edit: ");
		
		//catch any user error that didn't enter a number
		try {
			number = Integer.parseInt(scanner.nextLine());
		}
		catch (NumberFormatException e) {
			System.out.println("Please enter a valid number");
			System.out.println("Press ENTER to continue...");
			String input = scanner.nextLine();
			return;
		}
		
		//loop through ArrayList to find device to edit
		for (int i = 0; i < deviceList.size(); i++) {
			if (i == number-1) {
				System.out.print("\nEnter Device name: ");
				name = scanner.nextLine();
				deviceList.get(i).setName(name);
				
				System.out.print("Enter Device SKU code: ");
				sku = scanner.nextLine();
				deviceList.get(i).setSku(sku);
				
				System.out.println("\nDevice information updated");
				displayDevices();
				System.out.println("\n\nPress ENTER to continue...");
				String input = scanner.nextLine();
			} //end nested if 
			else {
				System.out.println("Invalid number");
				System.out.println("\n\nPress ENTER to continue...");
				String input = scanner.nextLine();
				break;
			} //end nested else
		} //end for loop
	} //end editDevice method
	
	public void searchDevice() {
		Scanner scanner = new Scanner(System.in);
		Device d = new Device();
		String deviceName = "";
		String availability = "";
		
		System.out.print("Enter device to search for: ");
		String keyword = scanner.nextLine();
		keyword.toLowerCase();
		
		System.out.printf("\n%-2s %-10s %-50s", "#", "SKU", "Name");
		//loop through ArrayList to find if the search matched any device names (not case sensitive and partial matches)
		for (int i = 0; i < deviceList.size(); i++) {
			//print available/checked out instead of true/false
			if (deviceList.get(i).getAvailability() == true) {
				availability = "Available";
			} //end nested if
			else 
				availability = "Checked Out";
			//find specific devices and print out their info
			if(deviceList.get(i).getName().toLowerCase().contains(keyword)) {
				System.out.printf("\n%-2s %-10s %-50s %-15s", i+1, deviceList.get(i).getSku(), deviceList.get(i).getName(), availability);
			} //end nested if
		} //end for loop
		
		System.out.println("\n\nPress ENTER to continue...");
		String input = scanner.nextLine();
	} //end searchDevice method
		
	public void checkOut() {
		Scanner scanner = new Scanner(System.in);
		int num = 0;
		String availability = "";
		
		System.out.println("\nAvailable Devices");
		System.out.printf("\n%-2s %-10s %-50s", "#", "SKU", "Name");
		
		//check for available devices
		for (int i = 0; i < deviceList.size(); i++) {
			//print available/checked out instead of true/false
			if (deviceList.get(i).getAvailability() == true) {
				availability = "Available";
			} //end nested if
			else 
				availability = "Checked Out";
			//print out only the available devices
			if(deviceList.get(i).getAvailability() == true) {
				System.out.printf("\n%-2s %-10s %-50s %-15s", i+1, deviceList.get(i).getSku(), deviceList.get(i).getName(), availability);
			} //end nested if
		} //end for loop
		
		System.out.print("\n\nEnter device number: ");
		//catch any user error that didn't enter a number
		try {
			num = Integer.parseInt(scanner.nextLine());
		}
		catch (NumberFormatException e) {
			System.out.println("Please enter a valid number");
			System.out.println("\nPress ENTER to continue...");
			String input = scanner.nextLine();
			return;
		}
		
		//check out device or tell user input is invalid/checked out
		if (num > deviceList.size() || num < 0) {
			System.out.println("Invalid number");
		}
		else if(deviceList.get(num-1).getAvailability() == false) {
			System.out.println("Device is already checked out");
		}
		else {
			deviceList.get(num-1).setAvailability(false);
			System.out.println("Device checked out");
			System.out.println("\nPress ENTER to continue...");
			String input = scanner.nextLine();
			displayDevices();
			System.out.println("\n\nPress ENTER to continue...");
			String input1 = scanner.nextLine();
		}
		
	} //end checkOut method
	
	public void checkIn() {
		Scanner scanner = new Scanner(System.in);
		int num = 0;
		String availability = "";
		
		System.out.println("\nChecked Out Devices");
		System.out.printf("\n%-2s %-10s %-50s", "#", "SKU", "Name");
		
		//check for available devices
		for (int i = 0; i < deviceList.size(); i++) {
			//print available/checked out instead of true/false
			if (deviceList.get(i).getAvailability() == true) {
				availability = "Available";
			} //end if 
			else 
				availability = "Checked Out";
			//print out only the checked out devices
			if(deviceList.get(i).getAvailability() == false) {
				System.out.printf("\n%-2s %-10s %-50s %-15s", i+1, deviceList.get(i).getSku(), deviceList.get(i).getName(), availability);
			} //end if
		} //end for loop
		
		System.out.print("\n\nEnter device number: ");
		//catch any user error that didn't enter a number
		try {
			num = Integer.parseInt(scanner.nextLine());
		}
		catch (NumberFormatException e) {
			System.out.println("Please enter a valid number");
			System.out.println("Press ENTER to continue...");
			String input = scanner.nextLine();
		}
		
		//check in device or tell user input is invalid/checked in
		if (num > deviceList.size() || num < 0) {
			System.out.println("Invalid number");
		}
		else if(deviceList.get(num-1).getAvailability() == true) {
			System.out.println("Device is already checked in");
		}
		else {
			deviceList.get(num-1).setAvailability(true);
			System.out.println("Device checked in");
			System.out.println("\nPress ENTER to continue...");
			String input = scanner.nextLine();
		}
		
		displayDevices();
		System.out.println("\n\nPress ENTER to continue...");
		String input = scanner.nextLine();
	} //end checkIn method
	
	public void menu() {
		Scanner scanner = new Scanner(System.in);
		int menuInput = 0;
		
		//display menu at least once for user 
		do {
			System.out.println("\t\t\tLibrary Device Checkout System\n");
			System.out.println("1. List Devices by Title\n2. Add New Devices\n3. Edit Device Information");
			System.out.println("4. Search by Device Name\n5. Check out Devices\n6. Check In Devices\n7. Exit\n");
			System.out.print("Select menu options 1-7: ");
			
			//catch any user error that didn't enter a number
			try {
				menuInput = Integer.parseInt(scanner.nextLine());
			}
			catch (NumberFormatException e) {
				System.out.println("Please enter a valid number");
				System.out.println("Press ENTER to continue...");
				String input = scanner.nextLine();
			}
			
			//let user pick which feature they want to use
			switch (menuInput) {
			case 1:
				System.out.println("\n\n\n\n\n\t\t\tLibrary Device Checkout System - List");
				displayDevices();
				System.out.println("\n\n\n\n\n");
				break;
			case 2:
				System.out.println("\n\n\n\n\n\t\t\tLibrary Device Checkout System - Add New Device");
				addDevice();			
				System.out.println("\n\n\n\n\n");
				break;
			case 3:
				System.out.println("\n\n\n\n\n\t\t\tLibrary Device Checkout System - Edit");
				editDevice();
				System.out.println("\n\n\n\n\n");
				break;
			case 4:
				System.out.println("\n\n\n\n\n\t\t\tLibrary Device Checkout System - Search");
				searchDevice();
				System.out.println("\n\n\n\n\n");
				break;
			case 5:
				System.out.println("\n\n\n\n\n\t\t\tLibrary Device Checkout System - Check Out Devices");
				checkOut();
				System.out.println("\n\n\n\n\n");
				break;
			case 6:
				System.out.println("\n\n\n\n\n\t\t\tLibrary Device Checkout System - Check In Devices");
				checkIn();
				System.out.println("\n\n\n\n\n");
				break;
			case 7:
				System.out.println("Good bye!");
				System.exit(0);
				break;
			}
		} while(menuInput != 7);
	}
	
}
