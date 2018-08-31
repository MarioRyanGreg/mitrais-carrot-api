package com.mitrais.carrot.repositories;

import com.mitrais.carrot.models.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByEmail(String email);
    
    public Optional<User> findByUserNameOrEmail(String username, String email);

    public List<User> findByIdIn(List<Long> userIds);

    public Optional<User> findByUserName(String userName);

    public Boolean existsByUserName(String username);

    public Boolean existsByEmail(String email);
}
