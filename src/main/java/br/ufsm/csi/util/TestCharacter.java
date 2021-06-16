package br.ufsm.csi.util;

import br.ufsm.csi.dao.CharacterDAO;
import br.ufsm.csi.model.Character;

public class TestCharacter {
    public static void main(String args[]){
        //testGetCharacter();
        //testInsert();
        //testUpdate();
        testDelete();
    }

    public static void testGetCharacter() {
        System.out.println("!!!Get Characters:!!!");
        for(Character c : new CharacterDAO().getCharacter()) {
            System.out.println("Id:" + c.getCharacterId());
            System.out.println("Name:" + c.getName());
            System.out.println("Level:" + c.getLevel());
            System.out.println("Crit Rate:" + c.getCritRate());
            System.out.println("Crit DMG:" + c.getCritDmg());
            System.out.println("`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`" );
        }
    }

    public static void testInsert() {
        Character chara = new Character("Zongli", "80", "36.2%", "109.1%");

        new CharacterDAO().insert(chara);
    }

    public static void testUpdate() {
        //update user from id
        Character charaUp = new Character(1,"Erase", "20", "20.5%", "40.8%");
        new CharacterDAO().update(charaUp);

    }

    public static void testDelete() {
        //delete from id

        Character charaDel = new Character(1);

        new CharacterDAO().delete(charaDel);
    }
}
