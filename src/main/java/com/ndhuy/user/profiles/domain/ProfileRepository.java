package com.ndhuy.user.profiles.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfileRepository extends JpaRepository<Profile, ProfileId> {
    /**
     * @param id
     * @param email
     * @param name
     * @return Profile
     */
    @Query("SELECT p FROM Profile p WHERE (:id IS NULL OR p.id = :id) AND (:email IS NULL OR p.email = :email) AND (:name IS NULL OR p.name = :name)")
    Optional<Profile> findBySearchProfifle(@Param("id") ProfileId id, @Param("email") String email,
            @Param("name") String name);
}
