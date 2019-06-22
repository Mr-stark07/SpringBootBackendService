package com.gfg.divy.SpringBootBackendService.Repository;

import com.gfg.divy.SpringBootBackendService.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
