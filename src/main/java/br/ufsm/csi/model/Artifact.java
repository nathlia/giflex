package br.ufsm.csi.model;

public class Artifact {

  private long ArtifactId;
  //private long ArtifactTypeId;
  //private long ArtifactSetTypeId;
  //private long MainStatId;
  private double MainStatValue;

  private ArtifactType artifactType;
  private ArtifactSetType artifactSetType;
  private Substat MainStatId;

  public Artifact() {

  }

  public Artifact(long artifactId) {
    ArtifactId = artifactId;
  }

  public Artifact(long artifactId, double mainStatValue, ArtifactType artifactType, ArtifactSetType artifactSetType) {
    ArtifactId = artifactId;
    MainStatValue = mainStatValue;
    this.artifactType = artifactType;
    this.artifactSetType = artifactSetType;
  }

  public Artifact( double mainStatValue, ArtifactType artifactType, ArtifactSetType artifactSetType) {
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

  public Substat getMainStatId() {
    return MainStatId;
  }

  public void setMainStatId(Substat mainStatId) {
    MainStatId = mainStatId;
  }
  public double getMainStatValue() {
    return MainStatValue;
  }

  public void setMainStatValue(double mainStatValue) {
    this.MainStatValue = mainStatValue;
  }

}
