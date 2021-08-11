package br.ufsm.csi.util;

import br.ufsm.csi.dao.ArtifactSubstatDAO;
import br.ufsm.csi.model.ArtifactSubstat;

public class TestArtifactSubstat {
    public static void main(String args[]) {
        //testGet();
        //testInsert();
        //testUpdate();
        //testDelete();
    }

    public static void testGet() {
        System.out.println("`-`-`-`- Get Artifact Substats: -`-`-`-`");
        for (ArtifactSubstat a : new ArtifactSubstatDAO().getArtifactSubstat()) {
            System.out.println("Artifact ID:" + a.getArtifactSubstatId());
            System.out.println("Type ID:" + a.getArtifact().getArtifactTypeId());
            System.out.println("- ype:" + a.getArtifact().getArtifactType().getName());
            System.out.println("Set Type ID:" + a.getArtifact().getArtifactSetTypeId());
            System.out.println("- Name:" + a.getArtifact().getArtifactSetType().getName());
            System.out.println("- Effect:" + a.getArtifact().getArtifactSetType().getDescription());
            System.out.println("Main Stat ID:" + a.getArtifact().getMainStatId());
            System.out.println("- Name:" + a.getArtifact().getMainStat().getName());
            System.out.println("Main Stat Value:" + a.getArtifact().getMainStatValue());
            System.out.println("Substat Artifact ID:" + a.getArtifactSubstatId());
            System.out.println("Substat ID:" + a.getSubstat().getSubstatId());
            System.out.println("- Name:" + a.getSubstat().getName());
            System.out.println("`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`-`");
        }
    }

    public static void testInsert() {
        ArtifactSubstat artifactSubstat = new ArtifactSubstat(1, 1, 2, 1233);

        //new ArtifactSubstatDAO().insert(artifactSubstat);
    }

    public static void testUpdate() {
        ArtifactSubstat artifactSubstatUpdate = new ArtifactSubstat();

        //new ArtifactSubstatDAO().update(artifactSubstatUpdate);
    }

    public static void testDelete() {
        ArtifactSubstat artifactSubstatDelete = new ArtifactSubstat(6);
        //new ArtifactSubstatDAO().delete(artifactSubstatDelete);
    }
}
