package com.ndhuy.user.profile.domain;

import com.ndhuy.user.profile.domain.valueobjects.Name;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
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
    
    Name name;

    String avatar;

    private Profile(String name, String avatar) {
        this.id = ProfileId.generate();
        this.name = new Name(name);
        this.avatar = avatar;
    }

    public static Profile create(String name, String avatar) {
        return new Profile( name, avatar);
    }

    public void update(String name, String avatar) {
        this.name = new Name(name);
        this.avatar = avatar;
    }


}
