package com.gfg.divy.SpringBootBackendService.Repository;

import com.gfg.divy.SpringBootBackendService.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<User,Long> {
}
