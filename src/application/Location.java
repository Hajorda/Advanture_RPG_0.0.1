package application;

public class Location extends Controller{

	private static boolean location = true;

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
	
	
	public static void locationControl() {
		
		if(location) {
			
		}
		if(!location) {
			System.out.println("Şuan Battlefield'dasınız.");
		}
	}
	
}
