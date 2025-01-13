package com.ndhuy.user.profile.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Residence {
    @EmbeddedId
    ProfileId id;

    String titleResidence;

    String addressResidence;

    
    public static Residence create(ProfileId id, String titleResidence, String addressResidence) {
        return new Residence(id, titleResidence, addressResidence);
    }
}
