package com.jun.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);  // 소셜 로그인 시 이미 생성된 사용자인지 처음 가입하는지에 대한 정보 판단
    
}


