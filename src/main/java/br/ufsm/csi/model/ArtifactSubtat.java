package br.ufsm.csi.model;


public class ArtifactSubtat {

  private long ArtifactSubstatId;
  private long ArtifactId;
  private long SubstatId;
  private double SubstatValue;


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
