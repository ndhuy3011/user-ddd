package com.ndhuy.user.profiles.domain;

import com.ndhuy.user.profiles.domain.valueobjects.Email;
import com.ndhuy.user.profiles.domain.valueobjects.Name;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "u_profile")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

    @EmbeddedId
    ProfileId id;

    @Embedded()
    @AttributeOverride(name = "value", column = @jakarta.persistence.Column(name = "name"))
    Name name;

    @Embedded
    @AttributeOverride(name = "value", column = @jakarta.persistence.Column(name = "email"))
    Email email;

    String avatar;

    private Profile(String name, String avatar, String email) {
        this.id = ProfileId.generate();
        this.name = new Name(name);
        this.avatar = avatar;
        this.email = new Email(email);
    }

    private Profile(ProfileId id, String name, String avatar, String email) {
        this.id = id;
        this.name = new Name(name);
        this.avatar = avatar;
        this.email = new Email(email);
    }


    public static Profile create(ProfileId id, String name, String avatar, String email) {
        return new Profile(id, name, avatar, email);
    }

    public static Profile create(String name, String avatar, String email) {
        return new Profile(name, avatar, email);
    }

    public void update(Name name, String avatar, Email email) {
        this.name = name;
        this.avatar = avatar;
        this.email = email;
    }

    public Profile update(String name, String avatar, String email) {
        update(name, avatar, email);
        return this;
    }

    public Profile(Profile profile) {
        this.id = profile.id;
        this.name = profile.name;
        this.avatar = profile.avatar;
        this.email = profile.email;
    }

}
