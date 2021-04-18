package com.wangzunbin.userservice.repository;

import com.wangzunbin.userservice.domain.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Service;

/**
 * ClassName:UserRepository
 * Function:
 *
 * @author WangZunBin
 * @version 1.0 2021/4/18 16:49
 */

public interface UserRepository extends JpaRepository<User, String> {

}
