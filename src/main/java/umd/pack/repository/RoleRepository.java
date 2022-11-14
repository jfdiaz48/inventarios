package umd.pack.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import umd.pack.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	Role findByName(String name);
	
	Optional<Role> findById(Integer id);
}
