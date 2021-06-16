package br.ufsm.csi.model;


public class ArtifactSetType {

  private long ArtifactSetTypeId;
  private String Name;
  private String Description;

  public ArtifactSetType() {

  }

  public ArtifactSetType(long artifactSetTypeId) {
    ArtifactSetTypeId = artifactSetTypeId;
  }

  public ArtifactSetType(String name, String description) {
    Name = name;
    Description = description;
  }

  public ArtifactSetType(long artifactSetTypeId, String name, String description) {
    ArtifactSetTypeId = artifactSetTypeId;
    Name = name;
    Description = description;
  }

  public long getArtifactSetTypeId() {
    return ArtifactSetTypeId;
  }

  public void setArtifactSetTypeId(long artifactSetTypeId) {
    this.ArtifactSetTypeId = artifactSetTypeId;
  }


  public String getName() {
    return Name;
  }

  public void setName(String name) {
    this.Name = name;
  }


  public String getDescription() {
    return Description;
  }

  public void setDescription(String description) {
    this.Description = description;
  }

}
