package br.ufsm.csi.model;


public class ArtifactType {

  private int ArtifactTypeId;
  private String Name;

  public ArtifactType() {
  }

  public ArtifactType(int artifactTypeId) {
    ArtifactTypeId = artifactTypeId;
  }

  public ArtifactType( String name) {
    Name = name;
  }

  public ArtifactType(int artifactTypeId, String name) {
    ArtifactTypeId = artifactTypeId;
    Name = name;
  }

  public int getArtifactTypeId() {
    return ArtifactTypeId;
  }

  public void setArtifactTypeId(int artifactTypeId) {
    this.ArtifactTypeId = artifactTypeId;
  }


  public String getName() {
    return Name;
  }

  public void setName(String name) {
    this.Name = name;
  }

}
