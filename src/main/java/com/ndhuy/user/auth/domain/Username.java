package com.ndhuy.user.auth.domain;

import com.ndhuy.user.auth.domain.valueobjects.NormarlClose;
import com.ndhuy.user.auth.domain.valueobjects.Password;
import com.ndhuy.user.auth.domain.valueobjects.Phone;
import com.ndhuy.user.profile.domain.valueobjects.Email;
import com.ndhuy.user.profile.domain.valueobjects.Name;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Username {

    @EmbeddedId
    @AttributeOverride(name = "id", column = @jakarta.persistence.Column(name = "id"))
    @AttributeOverride(name = "username", column = @jakarta.persistence.Column(name = "username"))
    UserNameId usernameId;

    @Embedded
    @AttributeOverride(name = "value", column = @jakarta.persistence.Column(name = "password"))
    Password password;

    @Embedded
    @AttributeOverride(name = "value", column = @jakarta.persistence.Column(name = "email"))
    Email email;

    @Enumerated
    @AttributeOverride(name = "value", column = @jakarta.persistence.Column(name = "status"))
    NormarlClose status;

    String avatar;

    @Embedded
    @AttributeOverride(name = "value", column = @jakarta.persistence.Column(name = "phone"))
    Phone phone;

    String address;

    @Embedded
    @AttributeOverride(name = "value", column = @jakarta.persistence.Column(name = "name"))
    Name fullName;

    
}
