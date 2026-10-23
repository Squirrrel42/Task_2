package ru.aston.hometask.task3.builder;

import java.util.Optional;

public class RPGCharacter {
    // mandatory fields
    private final String name;
    private final Sex sex;
    private final Species species;
    private final CharacterClass characterClass;

    // optional fields
    private final String nickname;
    private final Feat feat;
    private final DistinguishingFeature feature;
    private final HairColor hairColor;
    private final EyeColor eyeColor;


    public RPGCharacter(CharacterBuilder builder) {
        this.name = builder.getName();
        this.sex = builder.getSex();
        this.species = builder.getSpecies();
        this.characterClass = builder.getCharacterClass();
        this.nickname = builder.getNickname();
        this.feat = builder.getFeat();
        this.feature = builder.getFeature();
        this.hairColor = builder.getHairColor();
        this.eyeColor = builder.getEyeColor();
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public Species getSpecies() {
        return species;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }


    public Optional<String> getNickname() {
        return Optional.ofNullable(nickname);
    }

    public Optional<Feat> getFeat() {
        return Optional.ofNullable(feat);
    }

    public Optional<DistinguishingFeature> getFeature() {
        return Optional.ofNullable(feature);
    }

    public Optional<HairColor> getHairColor() {
        return Optional.ofNullable(hairColor);
    }

    public Optional<EyeColor> getEyeColor() {
        return Optional.ofNullable(eyeColor);
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("Character{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", species=" + species +
                ", characterClass=" + characterClass);

        if(nickname != null) {
            b.append(", nickname='").append(nickname).append('\'');
        }
        if (feat != null) {
            b.append(", feat=").append(feat);
        }
        if(feature != null) {
            b.append(", feature=").append(feature);
        }
        if (hairColor != null) {
            b.append(", hairColor=").append(hairColor);
        }
        if (eyeColor != null) {
            b.append(", eyeColor=").append(eyeColor);
        }
        b.append('}');
        return b.toString();
    }
}
