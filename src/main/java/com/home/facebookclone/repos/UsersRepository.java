package com.home.facebookclone.repos;


import com.home.facebookclone.models.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersRepository extends JpaRepository<user, Long> {


    user findByUsername(String username);
    user getByUsername(String username);


}
