package gamecharacter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

public class GameCharacter {
    private String name;
    private int hp;
    private int damage;
    private int defense;
    private double money;
    private int level;
    private int exp;
    private ArrayList<Items> itemsList = new ArrayList<>();
    private ArrayList<Skills> skillsList = new ArrayList<>();

    public GameCharacter(String name, int hp, int damage, int defense, double money, int level, int exp) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.defense = defense;
        this.money = money;
        this.level = level;
        this.exp = exp;
    }

    public void receiveItems(Items item, int quantity){
        if (itemsList.contains(item)){
            itemsList.get(itemsList.indexOf(item)).setQuantity(item.getQuantity()+quantity);
        }
        else{
            item.setQuantity(quantity);
            itemsList.add(item);
        }
    }

    public void buy(Items itemToBuy, int quantity){
        if (this.money - itemToBuy.getPrice() * quantity >= 0){
            setMoney(this.money - itemToBuy.getPrice() * quantity);
            receiveItems(itemToBuy, quantity);
        } else if (this.money - itemToBuy.getPrice() * quantity < 0){
            throw new ArithmeticException("not enough money to buy "+itemToBuy.getName()+" = "+quantity);
        }
    }

    public void sell(Items itemToSell, int quantity){
        if (itemsList.contains(itemToSell) && itemsList.get(itemsList.indexOf(itemToSell)).getQuantity()-quantity >= 0){
            setMoney(this.money + itemToSell.getPrice()*quantity);
            itemsList.get(itemsList.indexOf(itemToSell)).setQuantity(itemsList.get(itemsList.indexOf(itemToSell)).getQuantity()-quantity);
        } else {
            throw new ArithmeticException("not enough "+itemToSell.getName()+" to sell = "+quantity);
        }
    }

    public void learnSkill(Skills skills){
        if (skillsList.contains(skills)){
            skillsList.get(skillsList.indexOf(skills)).setLevel(skillsList.get(skillsList.indexOf(skills)).getLevel()+1);
        } else {
            skills.setLevel(1);
            skillsList.add(skills);
        }
    }

    public void useItem(Items usableItem){
        if (usableItem.getQuantity()-1 >= 0){
            usableItem.setQuantity(usableItem.getQuantity()-1);
            if (usableItem.getClass().getName().contains("UsableItems")){
                usableItem.used(this);
            } else if (usableItem.getClass().getName().contains("Misc")){
                sell(usableItem, usableItem.getQuantity());
            } else if (usableItem.getClass().getName().contains("MonsterBall")){
                catchBy(usableItem);
            }
        } else {
            throw new IndexOutOfBoundsException("not enough "+usableItem.getName()+" = "+usableItem.getQuantity()+" to buy");
        }
    }

    public void catchBy(Items ball){
        if (ball.getQuantity()-1 >= 0){
            ball.setQuantity(ball.getQuantity()-1);
            Random r = new Random();
            if (r.nextInt(2) == 1){
                expUp(ball, r.nextInt(1000));
            }
        } else {
            throw new IndexOutOfBoundsException("not enough "+ball.getName()+" = "+ball.getQuantity()+" to catch.");
        }
    }

    public void expUp(Items ball, int catchPoint){
        System.out.println("------Before levelUp------");
        System.out.println("Ball: "+ball.getName());
        System.out.println("Exp: "+this.exp);
        System.out.println("Level: "+this.level);
        System.out.println("CatchPoint: "+catchPoint);
        if (ball.getName().matches("[pP]okeball")){
            this.exp += catchPoint*5;
        } else if (ball.getName().matches("[Gg]reatball")){
            this.exp += catchPoint*10;
        } else if (ball.getName().matches("[Uu]ltraball")){
            this.exp += catchPoint*15;
        }
        System.out.println("EXP after catch: " + this.exp);
        if (this.exp >= 1000){
            setLevel(this.level+this.exp/1000);
            setExp(this.exp%1000);
            System.out.println("------After LevelUp------");
            System.out.println("Ball: "+ball.getName());
            System.out.println("Exp: "+this.exp);
            System.out.println("Level: "+this.level);
        }
    }

    public void castSpell(Skills skill) throws IOException {
        if (skill.getType().matches("[Aa]ctive")){
            System.out.println(skill.getName());
        } else if (skill.getType().matches("[Pp]assive")){
            throw new IOException("passive don't cast");
        }
    }

    public ArrayList<Items> getItemsList() {
        return itemsList;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public ArrayList<Skills> getSkillsList() {
        return skillsList;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public int getLevel() {
        return level;
    }

    public int getDamage() {
        return damage;
    }

    public int getDefense() {
        return defense;
    }

    public int getExp() {
        return exp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
