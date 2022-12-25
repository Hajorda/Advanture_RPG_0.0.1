package application;

import java.lang.ModuleLayer.Controller;

	//	Ana karakterin değerlerinin kontrol edildiği class.
public class Player {
	
	private String name;
	private int health;
	private int armor;
	private int damage;
	private int gold;

	public Player(int health, int armor, int damage, String name, int gold) {
		this.health = health;
		this.name = name;
		this.armor = armor;
		this.damage = damage;
		this.gold = gold;
	}
	
		//	Getter-Setter'lar.	
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
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
	
}
