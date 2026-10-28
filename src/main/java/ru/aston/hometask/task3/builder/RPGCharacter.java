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


    private RPGCharacter(String name, 
                         Sex sex, 
                         Species species, 
                         CharacterClass characterClass, 
                         String nickname, 
                         Feat feat, 
                         DistinguishingFeature feature, 
                         HairColor hairColor,
                         EyeColor eyeColor) {
        this.name = name;
        this.sex = sex;
        this.species = species;
        this.characterClass = characterClass;
        this.nickname = nickname;
        this.feat = feat;
        this.feature = feature;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
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

    public static class Builder {
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

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder sex(Sex sex) {
            this.sex = sex;
            return this;
        }

        public Builder species(Species species) {
            this.species = species;
            return this;
        }

        public Builder characterClass(CharacterClass characterClass) {
            this.characterClass = characterClass;
            return this;
        }

        public Builder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public Builder feat(Feat feat) {
            this.feat = feat;
            return this;
        }

        public Builder feature(DistinguishingFeature feature) {
            this.feature = feature;
            return this;
        }

        public Builder hairColor(HairColor hairColor) {
            this.hairColor = hairColor;
            return this;
        }

        public Builder eyeColor(EyeColor eyeColor) {
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
            return new RPGCharacter(name, sex, species, characterClass, nickname, feat, feature, hairColor, eyeColor);
        }
    }
}
