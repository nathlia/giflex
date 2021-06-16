package br.ufsm.csi.model;

public class UserCharacter {

  private long UserCharacterId;
  private long UserId;
  private long CharacterId;


  public long getUserCharacterId() {
    return UserCharacterId;
  }

  public void setUserCharacterId(long userCharacterId) {
    this.UserCharacterId = userCharacterId;
  }


  public long getUserId() {
    return UserId;
  }

  public void setUserId(long userId) {
    this.UserId = userId;
  }


  public long getCharacterId() {
    return CharacterId;
  }

  public void setCharacterId(long characterId) {
    this.CharacterId = characterId;
  }

}
