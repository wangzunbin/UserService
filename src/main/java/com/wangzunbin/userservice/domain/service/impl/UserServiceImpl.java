package com.wangzunbin.userservice.domain.service.impl;

import com.wangzunbin.userservice.domain.entity.User;
import com.wangzunbin.userservice.domain.service.IUserService;
import com.wangzunbin.userservice.repository.UserRepository;


import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

import static com.wangzunbin.userservice.util.JpaUpdateSupport.copyPropertiesIgnoreNull;

/**
 * ClassName:UserServiceImpl
 * Function:
 *
 * @author WangZunBin
 * @version 1.0 2021/4/18 16:59
 */

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;


    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(String userId) {
//        Assert.isTrue(ObjectUtils.isEmpty(userId), "用户ID不能为空");
        User user = userRepository.getOne(userId);
        userRepository.delete(user);
    }

    @Override
    public void update(User user) {
        Assert.notNull(user, "用户对象不能为空");
        User localUser = userRepository.getOne(user.getUserId());
        copyPropertiesIgnoreNull(user, localUser);
        userRepository.save(localUser);
    }

    @Override
    public User find(String userId) {
        return userRepository.getOne(userId);
    }
}
