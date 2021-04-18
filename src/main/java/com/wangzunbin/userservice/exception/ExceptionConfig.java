package com.wangzunbin.userservice.exception;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.zalando.problem.ProblemModule;
import org.zalando.problem.violations.ConstraintViolationProblemModule;

import lombok.RequiredArgsConstructor;

/**
 * ClassName:ProblemConfiguration
 * Function:
 *
 * @author WangZunBin
 * @version 1.0 2021/4/18 19:31
 */

@Configuration
@RequiredArgsConstructor
public class ExceptionConfig implements InitializingBean {

    private final ObjectMapper objectMapper;

    @Override
    public void afterPropertiesSet() {
        objectMapper.registerModule(new ProblemModule().withStackTraces());
    }
}