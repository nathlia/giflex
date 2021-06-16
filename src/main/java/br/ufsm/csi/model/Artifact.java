package br.ufsm.csi.model;


public class Artifact {

  private long ArtifactId;
  private long ArtifactTypeId;
  private long ArtifactSetTypeId;
  private long MainStatId;
  private double MainStatValue;


  public long getArtifactId() {
    return ArtifactId;
  }

  public void setArtifactId(long artifactId) {
    this.ArtifactId = artifactId;
  }


  public long getArtifactTypeId() {
    return ArtifactTypeId;
  }

  public void setArtifactTypeId(long artifactTypeId) {
    this.ArtifactTypeId = artifactTypeId;
  }


  public long getArtifactSetTypeId() {
    return ArtifactSetTypeId;
  }

  public void setArtifactSetTypeId(long artifactSetTypeId) {
    this.ArtifactSetTypeId = artifactSetTypeId;
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
