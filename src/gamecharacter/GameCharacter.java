package gamecharacter;

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
            //todo ability items
        }
    }

    public void catchBy(MonsterBall ball){
        if (ball.getQuantity()-1 >= 0){
            ball.setQuantity(ball.getQuantity()-1);
            Random r = new Random();
            System.out.println(r.nextInt(3)+0);
//            if (r.nextInt(3)+0 == 2){
//
//            }
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
}
