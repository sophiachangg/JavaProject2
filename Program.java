//Sophia Chang, CIS 340, T/TH 3:00
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		//create object to call methods from DeviceSystem
		DeviceSystem system = new DeviceSystem();
		
		//load sample data into program
		system.loadSampleData();
		
		//display menu
		system.menu();
		
	}
}
