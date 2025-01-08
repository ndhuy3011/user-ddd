package com.ndhuy.user.auth.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsernameRepository  extends JpaRepository<Username, UserNameId> {
   
}
