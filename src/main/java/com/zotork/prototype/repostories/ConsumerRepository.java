package com.zotork.prototype.repostories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.zotork.prototype.entities.Consumer;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer,Long> {

    Optional<UserDetails> findByConsumerName(String username);

    Optional<UserDetails> findByMobileNumber(Long mobileNumber);

    Optional<UserDetails> findByPrefferedUsername(String prefferedName);
    
}
