package com.wangzunbin.userservice.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wangzunbin.userservice.util.validation.Query;
import com.wangzunbin.userservice.util.validation.Save;
import com.wangzunbin.userservice.util.validation.Update;
import com.wangzunbin.userservice.util.validation.constraints.UserIdExit;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:User
 * Function:
 *
 * @author WangZunBin
 * @version 1.0 2021/4/18 16:49
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
@Table(name = "wzb_users")
public class User implements Serializable {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(length = 32)
    @UserIdExit(groups = {Update.class, Query.class})
    private String userId;

    @Column(name = "username")
    private String username;

    @Column(name = "mobile")
    @Min(value = 5, groups = {Save.class})
    @NotBlank(message = "用户手机不能为空", groups = {Save.class})
    private String mobile;

    @Column(name = "password")
    @Min(value=5, groups = {Save.class})
    private String password;

}
