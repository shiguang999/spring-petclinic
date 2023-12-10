package org.springframework.samples.petclinic.owner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.User;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends Repository<User, Integer> {

	@Query("SELECT user FROM  User user where user.username=:username ")
	@Transactional(readOnly = true)
	User findByUsername(@Param("username")String username);

	void save(User user);

	//void register(User user);

	//Map<String,Object> login(String username, String password);

	//User login(String username,String password);
}
