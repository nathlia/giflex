package br.ufsm.csi.util;

import br.ufsm.csi.dao.ArtifactDAO;
import br.ufsm.csi.model.Artifact;

public class TestArtifact {

    public static void main(String args[]){
        testGetArtifact();
        //testInsert();
        //testUpdate();
        //testDelete();
    }

    public static void testGetArtifact() {
        System.out.println("!!!Get Artifacts:!!!");
        for(Artifact a : new ArtifactDAO().getArtifact()) {
            System.out.println("ID:" + a.getArtifactId());
            System.out.println("Type:" + a.getArtifactTypeId());
            System.out.println("Set Type:" + a.getArtifactSetTypeId());
            System.out.println("Main Stat:" + a.getMainStatId());
            System.out.println("Main Stat Value:" + a.getMainStatValue());
            System.out.println("`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`" );
        }
    }
}
