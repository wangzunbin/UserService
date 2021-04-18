package com.wangzunbin.userservice.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangzunbin.userservice.domain.entity.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.slf4j.Slf4j;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

/**
 * ClassName:UserRestTest
 * Function:
 *
 * @author WangZunBin
 * @version 1.0 2021/4/18 18:02
 */

@SpringBootTest
@Slf4j
public class UserRestTest {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    void saveWhenSuccess() throws Exception {
        User user = User.builder()
                .mobile("1222221")
                .username("wangzunbin2")
                .password("121233").build();
        mockMvc.perform(post("/api/v1/user/save")
                //请求类型 json
                .content(objectMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON))
                // 期望的结果状态 200
                .andExpect(MockMvcResultMatchers.status().isOk())
                //添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void findWhenSuccess() throws Exception{
        mockMvc.perform(get("/api/v1/user/userId/{userId}", "4028aa8178e4a3800178e4a387d60000")
                .contentType(MediaType.APPLICATION_JSON))
                // 期望的结果状态 200
                .andExpect(MockMvcResultMatchers.status().isOk())
                //添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void updateWhenSuccess() throws Exception{
        User user = User.builder()
                .userId("4028aa8178e4a3800178e4a387d60000")
                .mobile("1222221121212")
                .username("wangzunbin")
                .password("121233").build();
        String contentAsString = mockMvc.perform(put("/api/v1/user/update")
                .content(objectMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON))
                // 期望的结果状态 200
//                .andExpect(MockMvcResultMatchers.status().isOk())
                //添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
//                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();
        log.debug(contentAsString);
    }

    @Test
    void deleteWhenSuccess() throws Exception{
        String contentAsString = mockMvc.perform(delete("/api/v1/user//userId/{userId}", "4028aa8178e4a3800178e4a387d60000")
                .contentType(MediaType.APPLICATION_JSON))
                // 期望的结果状态 200
                .andExpect(MockMvcResultMatchers.status().isOk())
                //添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();
        log.debug(contentAsString);
    }
}
