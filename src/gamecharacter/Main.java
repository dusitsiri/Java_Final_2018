package gamecharacter;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        //Character
        GameCharacter swordMan = new GameCharacter("Tiger", 10, 20, 30, 1000, 1, 0);
        GameCharacter lizardMan = new GameCharacter("Lizard", 100, 20, 50, 0, 2, 100);

        //todo Items
        UsableItems potion = new UsableItems("potion", 100);
        Items escapeRope = new Items("escape", 50);

        //Skills
        Skills thunder = new Skills("Thunder", "Active");
        Skills solarbeam = new Skills("Solarbeam", "Active");
        Skills statUp = new Skills("StatUp", "Passive");
        Skills dieHard = new Skills("DieHard", "Passive");

        //Monster balls
        MonsterBall pokeball = new MonsterBall("pokeball", 100);
        MonsterBall greatball = new MonsterBall("greatball", 200);
        MonsterBall ultraball = new MonsterBall("ultraball", 300);

        //test
        swordMan.receiveItems(potion, 5);
        System.out.println("----------ITEMS BEFORE USE----------");
        for (Items ball : swordMan.getItemsList()){
            System.out.println(ball.getName());
            System.out.println("price: "+ball.getPrice());
            System.out.println("quentity: "+ball.getQuantity());
        }
        System.out.println("----------Character before use item----------");
        System.out.println("Name: "+swordMan.getName());
        System.out.println("HP: "+swordMan.getHp());
        System.out.println("Damage: "+swordMan.getDamage());
        System.out.println("Defense: "+swordMan.getDefense());
        System.out.println("Exp: "+swordMan.getExp());
        System.out.println("Level: "+swordMan.getLevel());
        System.out.println("Money: "+swordMan.getMoney());

//        try{
//            swordMan.receiveItems(potion, 2);
//            swordMan.receiveItems(escapeRope, 10);
//            swordMan.buy(potion, 10);
//            swordMan.buy(escapeRope, 2);
//
//        } catch (ArithmeticException e){
//            System.err.println(e);
//        }
//
//
//        System.out.println("Money: "+ swordMan.getMoney()+"\n");
//        System.out.println("------After receive and buy-------");
//        for (Items items: swordMan.getItemsList()){
//            System.out.println(items.getName());
//            System.out.println(items.getPrice());
//            System.out.println(items.getQuantity());
//        }
//
//        try{
//            swordMan.sell(potion, 2);
//            swordMan.sell(escapeRope, 15);
//        } catch (ArithmeticException e){
//            System.err.println(e);
//        }
//
//        System.out.println("------After Selling-------");
//        for (Items items: swordMan.getItemsList()){
//            System.out.println(items.getName());
//            System.out.println(items.getPrice());
//            System.out.println(items.getQuantity());
//        }


//        swordMan.learnSkill(thunder);
//        swordMan.learnSkill(statUp);
//        swordMan.learnSkill(statUp);
//        swordMan.learnSkill(thunder);
//        System.out.println("--------After learn skills-------");
//        for (Skills skills: swordMan.getSkillsList()){
//            System.out.println(skills.getName());
//            System.out.println(skills.getType());
//            System.out.println(skills.getLevel());
//        }


        swordMan.useItem(potion);

//        System.out.println(swordMan.getMoney());
        System.out.println("----------ITEMS AFTER USED----------");
        for (Items ball : swordMan.getItemsList()){
            System.out.println(ball.getName());
            System.out.println("price: "+ball.getPrice());
            System.out.println("quentity: "+ball.getQuantity());
        }
        System.out.println("----------Character after use items----------");
        System.out.println("Name: "+swordMan.getName());
        System.out.println("HP: "+swordMan.getHp());
        System.out.println("Damage: "+swordMan.getDamage());
        System.out.println("Defense: "+swordMan.getDefense());
        System.out.println("Exp: "+swordMan.getExp());
        System.out.println("Level: "+swordMan.getLevel());
        System.out.println("Money: "+swordMan.getMoney());

    }
}
