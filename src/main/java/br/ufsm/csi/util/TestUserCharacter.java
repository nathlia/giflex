package br.ufsm.csi.util;

import br.ufsm.csi.dao.UserCharacterDAO;
import br.ufsm.csi.model.UserCharacter;

public class TestUserCharacter {

    public static void main(String args[]) {
        //testGet();
        testInsert();
        //testUpdate();
        //testDelete();
    }

    public static void testGet() {
        System.out.println("!!!Get User Characters:!!!");
        for (UserCharacter uc : new UserCharacterDAO().getUserCharacter()) {
            System.out.println("ID:" + uc.getUserCharacterId());
            System.out.println("Player ID:" + uc.getPlayerId());
            System.out.println("-Name:" + uc.getPlayer().getName());
            System.out.println("Character  ID:" + uc.getCharacterId());
            System.out.println("-Name:" + uc.getCharacter().getName());
            System.out.println("`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`");
        }
    }

    public static void testInsert() {
        UserCharacter userCharacter = new UserCharacter(4, 4);
        new UserCharacterDAO().insert(userCharacter);
    }

    public static void testUpdate() {
        UserCharacter userCharacterUpdate = new UserCharacter(8, 3,1);
        new UserCharacterDAO().update(userCharacterUpdate);
    }

    public static void testDelete() {
        UserCharacter userCharacterDelete = new UserCharacter(9);
        new UserCharacterDAO().delete(userCharacterDelete);
    }
}
