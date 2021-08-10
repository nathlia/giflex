package br.ufsm.csi.model;

public class Artifact {

  private long ArtifactId;
  //private long ArtifactTypeId;
  //private long ArtifactSetTypeId;
  private long MainStatId;
  private double MainStatValue;

  private ArtifactType artifactType;
  private ArtifactSetType artifactSetType;

  public Artifact() {

  }

  public Artifact(long artifactId) {
    ArtifactId = artifactId;
  }

  public Artifact(long artifactId, long mainStatId, double mainStatValue, ArtifactType artifactType, ArtifactSetType artifactSetType) {
    ArtifactId = artifactId;
    MainStatId = mainStatId;
    MainStatValue = mainStatValue;
    this.artifactType = artifactType;
    this.artifactSetType = artifactSetType;
  }

  public Artifact(long mainStatId, double mainStatValue, ArtifactType artifactType, ArtifactSetType artifactSetType) {
    MainStatId = mainStatId;
    MainStatValue = mainStatValue;
    this.artifactType = artifactType;
    this.artifactSetType = artifactSetType;
  }

  public ArtifactType getArtifactType() {
    return artifactType;
  }

  public void setArtifactType(ArtifactType artifactType) {
    this.artifactType = artifactType;
  }

  public ArtifactSetType getArtifactSetType() {
    return artifactSetType;
  }

  public void setArtifactSetType(ArtifactSetType artifactSetType) {
    this.artifactSetType = artifactSetType;
  }

  public long getArtifactId() {
    return ArtifactId;
  }

  public void setArtifactId(long artifactId) {
    this.ArtifactId = artifactId;
  }

  public long getMainStatId() {
    return MainStatId;
  }

  public void setMainStatId(long mainStatId) {
    this.MainStatId = mainStatId;
  }


  public double getMainStatValue() {
    return MainStatValue;
  }

  public void setMainStatValue(double mainStatValue) {
    this.MainStatValue = mainStatValue;
  }

}
