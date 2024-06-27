package com.pinoypliks.co.animalkingdom.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinoypliks.co.animalkingdom.Model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
