package br.ufsm.csi.model;

public class UserCharacter {

  private int UserCharacterId;
  private int PlayerId;
  private int CharacterId;

  private Player player;
  private Character character;

  public UserCharacter() {

  }

  public UserCharacter(int userCharacterId) {
    UserCharacterId = userCharacterId;
  }

  public UserCharacter( int characterId, int playerId) {
    CharacterId = characterId;
    PlayerId = playerId;
  }

  public UserCharacter(int userCharacterId, int characterId, int playerId) {
    UserCharacterId = userCharacterId;
    PlayerId = playerId;
    CharacterId = characterId;
  }

  public int getUserCharacterId() {
    return UserCharacterId;
  }

  public void setUserCharacterId(int userCharacterId) {
    this.UserCharacterId = userCharacterId;
  }


  public int getPlayerId() {
    return PlayerId;
  }

  public void setPlayerId(int playerId) {
    this.PlayerId = playerId;
  }


  public int getCharacterId() {
    return CharacterId;
  }

  public void setCharacterId(int characterId) {
    this.CharacterId = characterId;
  }

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  public Character getCharacter() {
    return character;
  }

  public void setCharacter(Character character) {
    this.character = character;
  }
}
