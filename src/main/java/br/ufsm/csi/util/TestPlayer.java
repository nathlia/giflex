package br.ufsm.csi.util;

import br.ufsm.csi.dao.PlayerDAO;
import br.ufsm.csi.model.Player;

public class TestPlayer {

    public static void main(String args[]){
        //testGetPlayer();
        //testInsert();
        //testUpdate();
        //testDelete();
    }

    public static void testGetPlayer() {
        System.out.println("!!!Get Players:!!!");
        for(Player p : new PlayerDAO().getPlayer()) {
            System.out.println("Id:" + p.getUserId());
            System.out.println("Name:" + p.getName());
            System.out.println("Username:" + p.getUsername());
            System.out.println("`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`" );
        }
    }

    public static void testInsert() {
        Player user = new Player("erase", "erase@gmail.com", "000");

        new PlayerDAO().insert(user);
    }

    public static void testUpdate() {
        //update user from id
        Player userUp = new Player(3, "lippe", "lippe@gmail.com", "666");
        new PlayerDAO().update(userUp);
        System.out.println("-------------------------------");
        System.out.println("nome: " + userUp.getName());
        System.out.println("email: " + userUp.getUsername());
        System.out.println("password: " + userUp.getPassword());
        System.out.println("-------------------------------");
    }

    public static void testDelete() {
        //delete from id
        Player userDel = new Player(4);

        new PlayerDAO().delete(userDel);
    }
}
