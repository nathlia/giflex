package br.ufsm.csi.model;


public class Player {

  private long UserId;
  private String Name;
  private String Username;
  private String Password;

  public Player() {

  }

  public Player(long userId) {
    this.UserId= userId;
  }

  public Player(String Name, String Username, String Password) {
    this.Name = Name;
    this.Username = Username;
    this.Password = Password;
  }

  public Player(long UserId, String Name, String Username, String Password) {
    this.UserId = UserId;
    this.Name = Name;
    this.Username = Username;
    this.Password = Password;
  }

  public long getUserId() {
    return UserId;
  }

  public void setUserId(long userId) {
    this.UserId = userId;
  }


  public String getName() {
    return Name;
  }

  public void setName(String name) {
    this.Name = name;
  }


  public String getUsername() {
    return Username;
  }

  public void setUsername(String username) {
    this.Username = username;
  }


  public String getPassword() {
    return Password;
  }

  public void setPassword(String password) {
    this.Password = password;
  }

}
