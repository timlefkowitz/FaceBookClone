package com.home.facebookclone.repos;


import com.home.facebookclone.models.usersPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersPostRepo extends JpaRepository<usersPost, Long> {
}
