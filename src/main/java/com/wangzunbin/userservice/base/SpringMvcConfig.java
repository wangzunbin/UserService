package com.wangzunbin.userservice.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.problem.ProblemModule;
import org.zalando.problem.violations.ConstraintViolationProblemModule;

import javax.annotation.PostConstruct;

import lombok.RequiredArgsConstructor;

/**
 * ClassName:SpringMvcConfig
 * Function:
 *
 * @author WangZunBin
 * @version 1.0 2021/4/18 19:21
 */

@Configuration
@RequiredArgsConstructor
public class SpringMvcConfig {

    private final ObjectMapper objectMapper;

    @PostConstruct
    public ObjectMapper objectMapper() {
        return objectMapper.registerModule(new ProblemModule().withStackTraces()).disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }
}
