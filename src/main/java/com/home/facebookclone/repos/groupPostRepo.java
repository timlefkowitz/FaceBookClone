package com.home.facebookclone.repos;


import com.home.facebookclone.models.groupPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface groupPostRepo extends JpaRepository<groupPost, Long> {
}
