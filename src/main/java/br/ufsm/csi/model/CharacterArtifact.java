package br.ufsm.csi.model;


public class CharacterArtifact {

  private long CharacterArtifactId;
  private long CharacterId;
  private long ArtifactId;

  private Character character;
  private Artifact artifact;

  public CharacterArtifact() {

  }

  public CharacterArtifact(long characterArtifactId) {
    CharacterArtifactId = characterArtifactId;
  }

  public CharacterArtifact(long characterId, long artifactId, Character character, Artifact artifact) {
    CharacterId = characterId;
    ArtifactId = artifactId;
    this.character = character;
    this.artifact = artifact;
  }

  public CharacterArtifact(long characterArtifactId, long characterId, long artifactId, Character character, Artifact artifact) {
    CharacterArtifactId = characterArtifactId;
    CharacterId = characterId;
    ArtifactId = artifactId;
    this.character = character;
    this.artifact = artifact;
  }

  public long getCharacterArtifactId() {
    return CharacterArtifactId;
  }

  public void setCharacterArtifactId(long characterArtifactId) {
    this.CharacterArtifactId = characterArtifactId;
  }


  public long getCharacterId() {
    return CharacterId;
  }

  public void setCharacterId(long characterId) {
    this.CharacterId = characterId;
  }


  public long getArtifactId() {
    return ArtifactId;
  }

  public void setArtifactId(long artifactId) {
    this.ArtifactId = artifactId;
  }

}
