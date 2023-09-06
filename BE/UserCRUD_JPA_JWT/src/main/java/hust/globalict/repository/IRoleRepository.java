package hust.globalict.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hust.globalict.entity.ERole;
import hust.globalict.entity.Role;
import hust.globalict.entity.User;

public interface IRoleRepository extends JpaRepository<Role, Long> {
	Role findByName(ERole name);
}
