package com.wangzunbin.userservice.util.validation.constraints;

import com.wangzunbin.userservice.util.validation.UserIdExitValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * ClassName:UserIdExit
 * Function:
 *
 * @author WangZunBin
 * @version 1.0 2021/4/18 20:20
 */

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserIdExitValidator.class)
public @interface UserIdExit {

    String USER_ID_NOT_EXIT = "路口ID不能为空或者该路口不存在";

    String message() default USER_ID_NOT_EXIT;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
