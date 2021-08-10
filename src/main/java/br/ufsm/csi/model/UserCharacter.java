package br.ufsm.csi.model;

public class UserCharacter {

  private int UserCharacterId;
  private int UserId;
  private int CharacterId;

  private Player player;
  private Character character;

  public UserCharacter() {

  }

  public UserCharacter(int userCharacterId) {
    UserCharacterId = userCharacterId;
  }

  public UserCharacter(int userId, int characterId, Player player, Character character) {
    UserId = userId;
    CharacterId = characterId;
    this.player = player;
    this.character = character;
  }

  public UserCharacter(int userCharacterId, int userId, int characterId, Player player, Character character) {
    UserCharacterId = userCharacterId;
    UserId = userId;
    CharacterId = characterId;
    this.player = player;
    this.character = character;
  }

  public int getUserCharacterId() {
    return UserCharacterId;
  }

  public void setUserCharacterId(int userCharacterId) {
    this.UserCharacterId = userCharacterId;
  }


  public int getUserId() {
    return UserId;
  }

  public void setUserId(int userId) {
    this.UserId = userId;
  }


  public int getCharacterId() {
    return CharacterId;
  }

  public void setCharacterId(int characterId) {
    this.CharacterId = characterId;
  }

}
