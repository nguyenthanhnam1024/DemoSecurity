package com.example.demosecurity.repository;

import com.example.demosecurity.entity.AppUser;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findAppUserByUserName(String userName);
}
