package com.pinoypliks.co.animalkingdom.Repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pinoypliks.co.animalkingdom.Model.Userauth;

public interface UserauthRepository extends JpaRepository <Userauth, Long>{
    Optional<Userauth> findByEmail(String Email);
    Optional<Userauth> findByUsername(String Username);
    Optional<Userauth> findByUsernameOrEmail(String Email, String Username);

    Boolean existByEmail (String Email);
    Boolean existByUsername(String Username);


}
