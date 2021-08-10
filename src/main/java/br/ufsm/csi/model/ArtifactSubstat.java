package br.ufsm.csi.model;


public class ArtifactSubstat {

  private long ArtifactSubstatId;
  private long ArtifactId;
  private long SubstatId;
  private double SubstatValue;

  private Artifact artifact;
  private Substat substat;

  public ArtifactSubstat() {

  }


  public ArtifactSubstat(long artifactSubstatId) {
    ArtifactSubstatId = artifactSubstatId;
  }

  public ArtifactSubstat(long artifactId, long substatId, double substatValue, Artifact artifact, Substat substat) {
    ArtifactId = artifactId;
    SubstatId = substatId;
    SubstatValue = substatValue;
    this.artifact = artifact;
    this.substat = substat;
  }

  public ArtifactSubstat(long artifactSubstatId, long artifactId, long substatId, double substatValue, Artifact artifact, Substat substat) {
    ArtifactSubstatId = artifactSubstatId;
    ArtifactId = artifactId;
    SubstatId = substatId;
    SubstatValue = substatValue;
    this.artifact = artifact;
    this.substat = substat;
  }

  public long getArtifactSubstatId() {
    return ArtifactSubstatId;
  }

  public void setArtifactSubstatId(long artifactSubstatId) {
    this.ArtifactSubstatId = artifactSubstatId;
  }


  public long getArtifactId() {
    return ArtifactId;
  }

  public void setArtifactId(long artifactId) {
    this.ArtifactId = artifactId;
  }


  public long getSubstatId() {
    return SubstatId;
  }

  public void setSubstatId(long substatId) {
    this.SubstatId = substatId;
  }


  public double getSubstatValue() {
    return SubstatValue;
  }

  public void setSubstatValue(double substatValue) {
    this.SubstatValue = substatValue;
  }

}
