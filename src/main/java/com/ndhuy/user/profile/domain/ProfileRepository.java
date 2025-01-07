package com.ndhuy.user.profile.domain;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfileRepository extends JpaRepository<Profile, ProfileId> {
    @Query("SELECT p FROM Profile p WHERE (:id IS NULL OR p.id = :id) AND (:email IS NULL OR p.email = :email) AND (:name IS NULL OR p.name = :name)")
    Optional<Profile> findBySearchProfifle(@Param("id") UUID id, @Param("email") String email,
            @Param("name") String name);
}
