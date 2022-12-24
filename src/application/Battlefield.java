package application;

public class Battlefield extends Location{
	
	public Battlefield(boolean location) {
		super(location);
	}

	private static int level = 1; 
	private static int mediumPotionCounter = 0;
	private static int bigPotionCounter = 0;
	
	
	
	public static int getMediumPotionCounter() {
		return mediumPotionCounter;
	}


	public static void setMediumPotionCounter(int mediumPotionCounter) {
		Battlefield.mediumPotionCounter = mediumPotionCounter;
	}


	public static int getBigPotionCounter() {
		return bigPotionCounter;
	}


	public static void setBigPotionCounter(int bigPotionCounter) {
		Battlefield.bigPotionCounter = bigPotionCounter;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public static void increaseLevel() {
		level ++;
	}
	// yaratıkların kaçar tane olacağına karar veren method
	
	
	public void generateObstacle() {
		Goblin goblin = new Goblin(level);
		Skeleton skeleton = new Skeleton(level);
		Zombie zombie = new Zombie(level);
	}
	
	
	public static void selamlama(Goblin goblin, Skeleton skeleton, Zombie zombie, Player player) {
		System.out.println("Hoş geldin: "+ MainController.name);
		Combat( goblin,  skeleton,  zombie,  player);
	}
	
	
	
	//	Dövüşme metodu.
	public static void Combat(Goblin goblin, Skeleton skeleton, Zombie zombie, Player player) {
		while(goblin.getHealth()+skeleton.getHealth()+zombie.getHealth() > 0 ) {
			//go store button
			if(true) {
				goStore();
				
			}
			//potion kullan
			else if(true) {
				//usePotion();
			}
			//fight methodunu kullanır
			else if(true) {
				speak();
				fight(goblin, skeleton, zombie, player);
				if(player.getHealth()<0) {
					break;
				}
			}
		}
		if(player.getHealth()<0) {
			//öldün ekranını çağırır.
		}
		else {
			getReward(player);
			increaseLevel();
			goStore();
		}
		
		
	}
	
	public static void fight(Goblin goblin, Skeleton skeleton, Zombie zombie, Player player) {
		skeleton.setHealth(skeleton.getHealth() - (player.getDamage()-skeleton.getArmor()));
		zombie.setHealth(zombie.getHealth() - (player.getDamage()-zombie.getArmor()));
		goblin.setHealth(goblin.getHealth() - (player.getDamage()-goblin.getArmor()));
		player.setHealth(player.getHealth()-(zombie.getDamage()+skeleton.getDamage()+goblin.getDamage())-(3*player.getArmor()));
		
	}
	
	public static void goStore() {
		Location.location = true;
		Location.locationControl();
	}
	
	public static void getReward(Player player) {
		player.setGold(player.getGold() + (level*10));
	}
	
	//	Canavarlarla konuşulan metod.
	public static String speak() {
		return "sea";
	}
	
	public void useMediumPotion() {
		setMediumPotionCounter(mediumPotionCounter-1);
	}
	
	public void useBigPotion() {
		setBigPotionCounter(bigPotionCounter-1);
	}




	
}
