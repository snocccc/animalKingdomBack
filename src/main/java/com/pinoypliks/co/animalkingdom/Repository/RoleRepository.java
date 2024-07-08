package com.pinoypliks.co.animalkingdom.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pinoypliks.co.animalkingdom.Model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
    Optional<Role> findByName(String Name);

}
