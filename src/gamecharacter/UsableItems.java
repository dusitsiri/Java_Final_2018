package gamecharacter;

public class UsableItems extends Items {

    public UsableItems(String name, double price) {
        super(name, price);
    }

    public void used(GameCharacter character){
        System.out.println("USABLEITEMS");
        character.setHp(character.getHp()+50);
        character.setDamage(character.getDamage()+50);
        character.setDefense(character.getDefense()+50);
    }
}
