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

  public CharacterArtifact(int characterId, int artifactId, Character character, Artifact artifact) {
    CharacterId = characterId;
    ArtifactId = artifactId;
    this.character = character;
    this.artifact = artifact;
  }

  public CharacterArtifact(int characterArtifactId, int characterId, int artifactId, Character character, Artifact artifact) {
    CharacterArtifactId = characterArtifactId;
    CharacterId = characterId;
    ArtifactId = artifactId;
    this.character = character;
    this.artifact = artifact;
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

}
