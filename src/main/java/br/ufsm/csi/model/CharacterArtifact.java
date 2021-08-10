package br.ufsm.csi.model;

public class CharacterArtifact {

  private int CharacterArtifactId;
  private int CharacterId;
  private int ArtifactId;

  private Character character;
  private Artifact artifact;

  public CharacterArtifact() {

  }

  public CharacterArtifact(int characterArtifactId) {
    CharacterArtifactId = characterArtifactId;
  }

  public CharacterArtifact(int characterId, int artifactId) {
    CharacterId = characterId;
    ArtifactId = artifactId;
  }

  public CharacterArtifact(int characterArtifactId, int characterId, int artifactId) {
    CharacterArtifactId = characterArtifactId;
    CharacterId = characterId;
    ArtifactId = artifactId;
  }

  public int getCharacterArtifactId() {
    return CharacterArtifactId;
  }

  public void setCharacterArtifactId(int characterArtifactId) {
    this.CharacterArtifactId = characterArtifactId;
  }


  public int getCharacterId() {
    return CharacterId;
  }

  public void setCharacterId(int characterId) {
    this.CharacterId = characterId;
  }


  public int getArtifactId() {
    return ArtifactId;
  }

  public void setArtifactId(int artifactId) {
    this.ArtifactId = artifactId;
  }

  public Character getCharacter() {
    return character;
  }

  public void setCharacter(Character character) {
    this.character = character;
  }

  public Artifact getArtifact() {
    return artifact;
  }

  public void setArtifact(Artifact artifact) {
    this.artifact = artifact;
  }
}
