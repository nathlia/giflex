package br.ufsm.csi.model;


public class ArtifactType {

  private long ArtifactTypeId;
  private String Name;


  public long getArtifactTypeId() {
    return ArtifactTypeId;
  }

  public void setArtifactTypeId(long artifactTypeId) {
    this.ArtifactTypeId = artifactTypeId;
  }


  public String getName() {
    return Name;
  }

  public void setName(String name) {
    this.Name = name;
  }

}
