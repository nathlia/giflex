package br.ufsm.csi.model;


public class CharacterArtifact {

  private long CharacterArtifactId;
  private long CharacterId;
  private long ArtifactId;


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
