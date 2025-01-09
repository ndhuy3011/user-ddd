package com.ndhuy.user.auth.domain;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsernameRepository  extends JpaRepository<Username, UserNameId> {
   Optional<Username> findByUuid(UUID uuid);
}
