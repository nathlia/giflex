package br.ufsm.csi.util;

import br.ufsm.csi.model.ArtifactSetType;
import br.ufsm.csi.dao.ArtifactSetTypeDAO;

public class TestArtifactSetType {
    public static void main(String args[]){
        //testInsert();
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
        ArtifactSetType artSetType = new ArtifactSetType("test", "test");

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
