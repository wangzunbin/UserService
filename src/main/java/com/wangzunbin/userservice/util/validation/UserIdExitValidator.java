package com.wangzunbin.userservice.util.validation;

import com.wangzunbin.userservice.domain.service.IUserService;
import com.wangzunbin.userservice.util.validation.constraints.UserIdExit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * ClassName:UserIdExitValidator
 * Function:
 *
 * @author WangZunBin
 * @version 1.0 2021/4/18 20:22
 */

public class UserIdExitValidator implements ConstraintValidator<UserIdExit, String> {

    @Autowired
    private IUserService userService;

    @Override
    public boolean isValid(String userId, ConstraintValidatorContext context) {
        return StringUtils.hasLength(userId) || Objects.isNull(userService.find(userId));
    }
}
