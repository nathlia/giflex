package br.ufsm.csi.util;

import br.ufsm.csi.model.ArtifactSetType;
import br.ufsm.csi.dao.ArtifactSetTypeDAO;

public class TestArtifactSetType {
    public static void main(String args[]){
        testInsert();
        //testGetArtifactSetType();
        //testUpdate();
        //testDelete();
    }

    public static void testGetArtifactSetType() {
        System.out.println("!!!Get Artifact Set Type:!!!");
        for(ArtifactSetType artSetType : new ArtifactSetTypeDAO().getArtifactSetType()) {
            System.out.println("Id:" + artSetType.getArtifactSetTypeId());
            System.out.println("Name:" + artSetType.getName());
            System.out.println("Set buff:" + artSetType.getDescription());
            System.out.println("`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`" );
        }
    }

    public static void testInsert() {
        ArtifactSetType artSetType = new ArtifactSetType("Virisdescent Venerer", "2-Piece Bonus Anemo DMG Bonus +15% <br> 4-Piece Bonus Increases Swirl DMG by 60%. Decreases opponent's Elemental RES to the element infused in the Swirl by 40% for 10s.");

        new ArtifactSetTypeDAO().insert(artSetType);
    }

    public static void testUpdate() {
        //update user from id
        ArtifactSetType artSetTypeUp = new ArtifactSetType(2,"update test","update test");
        new ArtifactSetTypeDAO().update(artSetTypeUp);
    }

    public static void testDelete() {
        //delete from id
        ArtifactSetType artSetTypeDel = new ArtifactSetType(2);

        new ArtifactSetTypeDAO().delete(artSetTypeDel);
    }
}
