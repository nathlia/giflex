package br.ufsm.csi.util;

import br.ufsm.csi.dao.ArtifactDAO;
import br.ufsm.csi.model.Artifact;

public class TestArtifacts {

    public static void main(String args[]){
        //testGetArtifact();
        //testInsert();
        testUpdate();
        //testDelete();
    }

    public static void testGetArtifact() {
        System.out.println("!!!Get Artifacts:!!!");
        for(Artifact a : new ArtifactDAO().getArtifact()) {
            System.out.println("ID:" + a.getArtifactId());
            System.out.println("Type ID:" + a.getArtifactTypeId());
            System.out.println("-Name:" + a.getArtifactType().getName());
            System.out.println("Set Type ID:" + a.getArtifactSetTypeId());
            System.out.println("-Name:" + a.getArtifactSetType().getName());
            System.out.println("-Effect:" + a.getArtifactSetType().getDescription());
            System.out.println("Main Stat ID:" + a.getMainStatId());
            System.out.println("-Name:" + a.getMainStat().getName());
            System.out.println("Main Stat Value:" + a.getMainStatValue());
            System.out.println("`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`" );
        }
    }

    public static void testInsert() {
        Artifact artifact = new Artifact( 2, 1, 2, 3,4780);

        new ArtifactDAO().insert(artifact);
    }

    public static void testUpdate() {
        
    }
}
