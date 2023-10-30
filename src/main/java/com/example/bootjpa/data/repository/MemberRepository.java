package com.example.bootjpa.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bootjpa.data.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {

    MemberEntity findByUsername(String username);
    
}
