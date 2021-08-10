package br.ufsm.csi.model;

public class Artifact {

  private int ArtifactId;
  private int ArtifactTypeId;
  private int ArtifactSetTypeId;
  private int MainStatId;
  private double MainStatValue;

  private ArtifactType artifactType;
  private ArtifactSetType artifactSetType;
  private Substat MainStat;

  public Artifact() {

  }

  public Artifact(int artifactId) {
    ArtifactId = artifactId;
  }

  public Artifact(int artifactId, int artifactTypeId, int artifactSetTypeId, int mainStatId, double mainStatValue) {
    ArtifactId = artifactId;
    ArtifactTypeId = artifactTypeId;
    ArtifactSetTypeId = artifactSetTypeId;
    MainStatId = mainStatId;
    MainStatValue = mainStatValue;
  }

  public Artifact(int artifactTypeId, int artifactSetTypeId, int mainStatId, double mainStatValue) {
    ArtifactTypeId = artifactTypeId;
    ArtifactSetTypeId = artifactSetTypeId;
    MainStatId = mainStatId;
    MainStatValue = mainStatValue;
  }

  public int getArtifactId() {
    return ArtifactId;
  }

  public void setArtifactId(int artifactId) {
    ArtifactId = artifactId;
  }

  public int getArtifactTypeId() {
    return ArtifactTypeId;
  }

  public void setArtifactTypeId(int artifactTypeId) {
    ArtifactTypeId = artifactTypeId;
  }

  public int getArtifactSetTypeId() {
    return ArtifactSetTypeId;
  }

  public void setArtifactSetTypeId(int artifactSetTypeId) {
    ArtifactSetTypeId = artifactSetTypeId;
  }

  public int getMainStatId() {
    return MainStatId;
  }

  public void setMainStatId(int mainStatId) {
    MainStatId = mainStatId;
  }

  public double getMainStatValue() {
    return MainStatValue;
  }

  public void setMainStatValue(double mainStatValue) {
    MainStatValue = mainStatValue;
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

  public Substat getMainStat() {
    return MainStat;
  }

  public void setMainStat(Substat mainStat) {
    MainStat = mainStat;
  }
}
