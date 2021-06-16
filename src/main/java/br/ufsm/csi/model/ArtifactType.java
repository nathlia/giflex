package br.ufsm.csi.model;


public class ArtifactType {

  private long ArtifactTypeId;
  private String Name;

  public ArtifactType() {
  }

  public ArtifactType(long artifactTypeId) {
    ArtifactTypeId = artifactTypeId;
  }

  public ArtifactType( String name) {
    Name = name;
  }

  public ArtifactType(long artifactTypeId, String name) {
    ArtifactTypeId = artifactTypeId;
    Name = name;
  }

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
