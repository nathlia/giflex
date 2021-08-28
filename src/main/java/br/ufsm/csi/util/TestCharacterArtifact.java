package br.ufsm.csi.util;

import br.ufsm.csi.dao.CharacterArtifactDAO;
import br.ufsm.csi.model.CharacterArtifact;

public class TestCharacterArtifact {

    public static void main(String args[]) {
        testGet();
        //testInsert();
        //testUpdate();
        //testDelete();
    }

    public static void testGet() {
        System.out.println("-`-`-Artifacts equipped to Character:-`-`-`");
        for (CharacterArtifact ca : new CharacterArtifactDAO().getCharacterArtifact()) {
            System.out.println("ID:" + ca.getCharacterArtifactId());
            System.out.println("Character ID:" + ca.getCharacterId());
            System.out.println("-Name:" + ca.getCharacter().getName());
            System.out.println("Artifact ID:" + ca.getCharacterId());
            System.out.println("-Type:" + ca.getArtifact().getArtifactType().getName());
            System.out.println("-Set:" + ca.getArtifact().getArtifactSetType().getName());
            System.out.println("-Main Stat:" + ca.getArtifact().getMainStat().getName());
            System.out.println("-Main Value:" + ca.getArtifact().getMainStatValue());
            System.out.println("`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`");
        }
    }

    public static void testInsert() {
        CharacterArtifact characterArtifact = new CharacterArtifact(5, 1);
        new CharacterArtifactDAO().insert(characterArtifact);
    }

    public static void testUpdate() {
        CharacterArtifact characterArtifactUpdate = new CharacterArtifact(3, 2, 1);
        new CharacterArtifactDAO().update(characterArtifactUpdate);
    }

    public static void testDelete() {
        CharacterArtifact characterArtifactDelete = new CharacterArtifact(3);
        new CharacterArtifactDAO().delete(characterArtifactDelete);
    }
}
