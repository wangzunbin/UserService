package com.wangzunbin.userservice.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.zalando.problem.spring.web.advice.ProblemHandling;

/**
 * ClassName:ExceptionHandling
 * Function:
 *
 * @author WangZunBin
 * @version 1.0 2021/4/18 19:37
 */

@ControllerAdvice
class ExceptionHandling implements ProblemHandling {

    @Override
    public boolean isCausalChainsEnabled() {
        return true;
    }

}