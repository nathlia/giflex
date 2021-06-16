package br.ufsm.csi.model;

public class Character {

  private long CharacterId;
  private String Name;
  private String Level;
  private String CritRate;
  private String CritDmg;

  public Character() {

  }

  public Character(long CharacterId) {
    this.CharacterId = CharacterId;
  }

  public Character(String name, String level, String critRate, String critDmg) {
    Name = name;
    Level = level;
    CritRate = critRate;
    CritDmg = critDmg;
  }

  public Character(long characterId, String name, String level, String critRate, String critDmg) {
    CharacterId = characterId;
    Name = name;
    Level = level;
    CritRate = critRate;
    CritDmg = critDmg;
  }

  public long getCharacterId() {
    return CharacterId;
  }

  public void setCharacterId(long characterId) {
    this.CharacterId = characterId;
  }


  public String getName() {
    return Name;
  }

  public void setName(String name) {
    this.Name = name;
  }


  public String getLevel() {
    return Level;
  }

  public void setLevel(String level) {
    this.Level = level;
  }


  public String getCritRate() {
    return CritRate;
  }

  public void setCritRate(String critRate) {
    this.CritRate = critRate;
  }


  public String getCritDmg() {
    return CritDmg;
  }

  public void setCritDmg(String critDmg) {
    this.CritDmg = critDmg;
  }

}
