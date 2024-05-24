package com.pardys.pardysback.user.repo;

import com.pardys.pardysback.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {


}
