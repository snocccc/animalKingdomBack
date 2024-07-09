package com.pinoypliks.co.animalkingdom.Repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pinoypliks.co.animalkingdom.Model.Userauth;

public interface UserauthRepository extends JpaRepository <Userauth, Long>{
    Optional<Userauth> findByEmail(String email);
    Optional<Userauth> findByUsername(String username);
    Optional<Userauth> findByUsernameOrEmail(String email, String username);

    Boolean existsByEmail (String email);
    Boolean existsByUsername(String username);


}
