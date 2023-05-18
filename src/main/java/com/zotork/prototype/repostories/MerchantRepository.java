package com.zotork.prototype.repostories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.zotork.prototype.entities.Merchants;

@Repository
public interface MerchantRepository extends JpaRepository<Merchants,Long> {

    Optional<UserDetails> findByMerchantName(String username);
    
}
