package com.home.facebookclone.repos;


import com.home.facebookclone.models.status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface statusRepo extends JpaRepository<status, String> {
}
