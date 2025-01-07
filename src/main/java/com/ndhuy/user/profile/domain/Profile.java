package com.ndhuy.user.profile.domain;

import com.ndhuy.user.profile.domain.valueobjects.Email;
import com.ndhuy.user.profile.domain.valueobjects.Name;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Profile {

    @EmbeddedId
    ProfileId id;
    @Enumerated
    Name name;
    @Enumerated
    Email email;

    String avatar;

    private Profile(String name, String avatar,String email) {
        this.id = ProfileId.generate();
        this.name = new Name(name);
        this.avatar = avatar;
        this.email = new Email(email);
    }

    public static Profile create(String name, String avatar,String email) {
        return new Profile(name, avatar,email);
    }

    public void update(Name name, String avatar,Email email) {
        this.name = name;
        this.avatar = avatar;
        this.email = email;
    }

    public Profile update(String name, String avatar,String email) {
        update(name, avatar,email);
        return this;
    }

    public Profile(Profile profile) {
        this.id = profile.id;
        this.name = profile.name;
        this.avatar = profile.avatar;
        this.email = profile.email;
    }

}
