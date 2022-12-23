package application;

public class Player extends Controller {

	private String name;		
	private int health=100;		
	private int damage=10;
	private int armor=0;
	private int level=1;
	private int itemDmg=0;
	private int itemPrtct=0;
	private int money=10;

	// Constructer
	public Player(String name, int health, int damage, int armor, int level, int itemDmg, int itemPrtct, int money) {
		super();
		this.name = name;
		this.health = health;
		this.damage = damage;
		this.armor = armor;
		this.level = level;
		this.itemDmg = itemDmg;
		this.itemPrtct = itemPrtct;
		this.money = money;
	}

	// Getters-Setters
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
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getArmor() {
		return armor;
	}
	public void setArmor(int armor) {
		this.armor = armor;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getItemDmg() {
		return itemDmg;
	}
	public void setItemDmg(int itemDmg) {
		this.itemDmg = itemDmg;
	}
	public int getItemPrtct() {
		return itemPrtct;
	}
	public void setItemPrtct(int itemPrtct) {
		this.itemPrtct = itemPrtct;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
		
	public static void sami() {
		System.out.println("a");
	}
	
	
}
