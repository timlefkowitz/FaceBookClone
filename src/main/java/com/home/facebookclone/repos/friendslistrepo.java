package com.home.facebookclone.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface friendslistrepo extends JpaRepository<friendslistrepo, Long> {
}
