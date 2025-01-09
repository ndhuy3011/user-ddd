package com.ndhuy.user.auth.domain;

import java.util.UUID;

import com.ndhuy.user.auth.domain.valueobjects.NormarlClose;
import com.ndhuy.user.auth.domain.valueobjects.Password;
import com.ndhuy.user.auth.domain.valueobjects.Phone;
import com.ndhuy.user.profile.domain.valueobjects.Email;
import com.ndhuy.user.profile.domain.valueobjects.Name;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Username {

    @EmbeddedId
    @AttributeOverride(name = "username", column = @jakarta.persistence.Column(name = "username"))
    UserNameId usernameId;

    @Column(name = "uuid", unique = true, nullable = false)
    UUID uuid;

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

    @Version
    private Long version;

    private Username(UserNameId usernameId, Password password, Email email, String avatar, Phone phone, String address,
            Name fullName) {
        this.uuid = UUID.randomUUID();
        this.usernameId = usernameId;
        this.password = password;
        this.email = email;
        this.status = NormarlClose.NORMARL;
        this.avatar = avatar;
        this.phone = phone;
        this.address = address;
        this.fullName = fullName;
    }

    public static Username create(String username, String password, String email, String avatar, String phone,
            String address, String fullName) {
        return new Username(UserNameId.generate(username), new Password(password), new Email(email),
                avatar, new Phone(phone), address, new Name(fullName));
    }

}
