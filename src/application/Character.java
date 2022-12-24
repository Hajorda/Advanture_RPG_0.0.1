package application;

public class Character {
	
	

	private int health;
	private int armor;
	private int damage;
	private String name;
	
	public Character(int health, int armor, int damage, int level, String name) {
		super();
		this.armor = armor;
		this.damage = damage;
		this.health = health;
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	
	
}
