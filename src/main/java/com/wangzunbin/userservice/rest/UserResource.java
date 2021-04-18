package com.wangzunbin.userservice.rest;

import com.wangzunbin.userservice.domain.entity.User;
import com.wangzunbin.userservice.domain.service.IUserService;
import com.wangzunbin.userservice.util.validation.Query;
import com.wangzunbin.userservice.util.validation.Save;
import com.wangzunbin.userservice.util.validation.Update;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import lombok.RequiredArgsConstructor;

/**
 * ClassName:UserResource
 * Function:
 *
 * @author WangZunBin
 * @version 1.0 2021/4/18 17:54
 */

@RequestMapping("/api/v1/user/")
@RestController
@RequiredArgsConstructor
@Valid
public class UserResource {

    private final IUserService userService;

    @PostMapping("/save")
    public void save(@RequestBody @Validated({Save.class})  User user){
        userService.save(user);
    }

    @GetMapping("/userId/{userId}")
    public User get(@PathVariable @Validated({Query.class}) String userId){
        return userService.find(userId);
    }

    @DeleteMapping("/userId/{userId}")
    public void delete(@PathVariable @NotEmpty String userId){
        userService.delete(userId);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Validated({Update.class}) User user){
        userService.update(user);
    }
}
