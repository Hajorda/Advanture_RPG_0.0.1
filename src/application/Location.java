package application;

public class Location extends MainController{

	protected static boolean location = true;

	public Location(boolean location) {
		this.location = location;
	}

	public boolean isLocation() {
		return location;
	}
	public void setLocation(boolean location) {
		this.location = location;
	}
	
	
	public static void locationControl() {
		
		//	Store'a gitme durumu.
		if(location) {
			System.out.println("Şuan Store'dasınız.");
			Store.selamlama();
		}
		//	Battlefield'a gitme durumu.
		if(!location) {
			System.out.println("Şuan Battlefield'dasınız.");
			//Battlefield.selamlama();
		}
	}
	
}
