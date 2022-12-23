package application;

public class Location extends Main{

	private boolean location = true;

	public Location(boolean location) {
		super();
		this.location = location;
	}

	public boolean isLocation() {
		return location;
	}
	public void setLocation(boolean location) {
		this.location = location;
	}
	
	
	public void locationControl() {
		
		if(location) {
			System.out.println("Şuan SafeHouse'dasınız.");
		}
		if(!location) {
			System.out.println("Şuan Battlefield'dasınız.");
		}
	}
	
}
