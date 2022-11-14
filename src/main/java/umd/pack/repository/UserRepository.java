package umd.pack.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import umd.pack.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findOneByEmail(String email);
}
