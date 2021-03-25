//Sophia Chang, CIS 340, T/TH 3:00

public class Device {
	//variables
	private String sku;
	private String name;
	private boolean availability = true;
	
	//constructors
	public Device() {
		
	}
	public Device(String name, String sku, boolean availability) {
		this.sku = sku.toUpperCase();
		this.name = name;
		this.availability = availability;
	}
	
	//getters and setters
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku.toUpperCase();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
}
