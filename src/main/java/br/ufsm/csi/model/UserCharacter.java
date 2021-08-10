package br.ufsm.csi.model;

public class UserCharacter {

  private long UserCharacterId;
  private long UserId;
  private long CharacterId;

  private Player player;
  private Character character;

  public UserCharacter() {

  }

  public UserCharacter(long userCharacterId) {
    UserCharacterId = userCharacterId;
  }

  public UserCharacter(long userId, long characterId, Player player, Character character) {
    UserId = userId;
    CharacterId = characterId;
    this.player = player;
    this.character = character;
  }

  public UserCharacter(long userCharacterId, long userId, long characterId, Player player, Character character) {
    UserCharacterId = userCharacterId;
    UserId = userId;
    CharacterId = characterId;
    this.player = player;
    this.character = character;
  }

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
