package com.wangzunbin.userservice.domain.service;

import com.wangzunbin.userservice.domain.entity.User;

/**
 * ClassName:IUserService
 * Function:
 *
 * @author WangZunBin
 * @version 1.0 2021/4/18 17:30
 */
public interface IUserService {

    User save(User user);

    void delete(String userId);

    void update(User user);

    User find(String userId);
}
