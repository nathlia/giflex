package br.ufsm.csi.model;


public class Substat {

  private long SubstatId;
  private String Name;


  public Substat() {
  }

  public Substat(long substatId) {
    SubstatId = substatId;
  }
  public Substat( String name) {
    Name = name;
  }

  public Substat(long substatId, String name) {
    SubstatId = substatId;
    Name = name;
  }

  public long getSubstatId() {
    return SubstatId;
  }

  public void setSubstatId(long substatId) {
    this.SubstatId = substatId;
  }


  public String getName() {
    return Name;
  }

  public void setName(String name) {
    this.Name = name;
  }

}
