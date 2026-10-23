package ru.aston.hometask.task3.builder;

public class CharacterBuilder {
    // mandatory fields
    private String name;
    private Sex sex;
    private Species species;
    private CharacterClass characterClass;

    // optional fields
    private String nickname;
    private Feat feat;
    private DistinguishingFeature feature;
    private HairColor hairColor;
    private EyeColor eyeColor;

    String getName() {
        return name;
    }

    Sex getSex() {
        return sex;
    }

    Species getSpecies() {
        return species;
    }

    CharacterClass getCharacterClass() {
        return characterClass;
    }

    String getNickname() {
        return nickname;
    }

    Feat getFeat() {
        return feat;
    }

    DistinguishingFeature getFeature() {
        return feature;
    }

    HairColor getHairColor() {
        return hairColor;
    }

    EyeColor getEyeColor() {
        return eyeColor;
    }

    public CharacterBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CharacterBuilder setSex(Sex sex) {
        this.sex = sex;
        return this;
    }

    public CharacterBuilder setSpecies(Species species) {
        this.species = species;
        return this;
    }

    public CharacterBuilder setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
        return this;
    }

    public CharacterBuilder setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public CharacterBuilder setFeat(Feat feat) {
        this.feat = feat;
        return this;
    }

    public CharacterBuilder setFeature(DistinguishingFeature feature) {
        this.feature = feature;
        return this;
    }

    public CharacterBuilder setHairColor(HairColor hairColor) {
        this.hairColor = hairColor;
        return this;
    }

    public CharacterBuilder setEyeColor(EyeColor eyeColor) {
        this.eyeColor = eyeColor;
        return this;
    }

    public RPGCharacter build() {
        if (name == null || name.isBlank()) {
            throw new IllegalStateException("Character must have a name.");
        }
        if (sex == null) {
            throw new IllegalStateException("Character's sex must be specified.");
        }
        if (species == null) {
            throw new IllegalStateException("Character's species must be specified.");
        }
        if (characterClass == null) {
            throw new IllegalStateException("Character's class must be specified.");
        }
        return new RPGCharacter(this);
    }
}
