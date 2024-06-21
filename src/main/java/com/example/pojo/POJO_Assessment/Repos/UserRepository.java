package com.example.pojo.POJO_Assessment.Repos;

import com.example.pojo.POJO_Assessment.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
User findByUserId(Long userId);

}
