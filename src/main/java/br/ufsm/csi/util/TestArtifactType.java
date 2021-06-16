package br.ufsm.csi.util;

import br.ufsm.csi.dao.ArtifactTypeDAO;
import br.ufsm.csi.model.ArtifactType;

public class TestArtifactType {
    public static void main(String args[]){
        //testInsert();
        //testGetArtifactType();
        //testUpdate();
        //testDelete();
    }

    public static void testGetArtifactType() {
        System.out.println("!!!Get Artifact Type:!!!");
        for(ArtifactType artType : new ArtifactTypeDAO().getArtifactType()) {
            System.out.println("Id:" + artType.getArtifactTypeId());
            System.out.println("Name:" + artType.getName());
            System.out.println("`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`" );
        }
    }

    public static void testInsert() {
        ArtifactType artType = new ArtifactType("erase");

        new ArtifactTypeDAO().insert(artType);
    }

    public static void testUpdate() {
        //update user from id
        ArtifactType artTypeUp = new ArtifactType(1,"Flower");
        new ArtifactTypeDAO().update(artTypeUp);
    }

    public static void testDelete() {
        //delete from id
        ArtifactType artTypeDel = new ArtifactType(2);

        new ArtifactTypeDAO().delete(artTypeDel);
    }
}
