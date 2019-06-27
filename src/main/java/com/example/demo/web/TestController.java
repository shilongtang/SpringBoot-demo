package com.example.demo.web;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.help.utils.RedisUtil;
import com.example.demo.help.utils.result.ApiResponse;
import com.example.demo.rabbitmq.RabbitmqUtil;
import com.example.demo.service.AsyncService;
import com.example.demo.service.ZealotService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Author: 青菜
 * @Date: 2019/5/6 下午4:27
 * @Description: 测试
 * @Version 1.0
 */
@Slf4j
@Api(description="Spring Boot test", tags = "test API")
@ConditionalOnWebApplication
@RestController()
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TestController extends BaseController {

    @Autowired
    AsyncService asyncService;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    ZealotService zealotService;

    @Autowired
    RedisUtil redisUtil;

    @GetMapping("/threadTest")
    public void threadTest() {
        System.out.println(123);
       for (int i = 0; i< 5;i++){
           asyncService.executeAsyncTask(i);
           System.out.println(456);
       }
        System.out.println(789);

    }

    @GetMapping("/threadTest2")
    public void threadTest2() {
        for (int i = 0;i< 5; i++){
            asyncService.executeTaskFor(i);
        }

    }


    @Transactional
    @GetMapping("/zealotTest")
    public ApiResponse zealotTest() {
        JSONObject param = new JSONObject();
        param.put("position","apkInfo_get");
        JSONObject map = new JSONObject();
        map.put("versionCode", 115);
        param.put("paramMap",map);
        String s = zealotService.querySqlForObject(param.toJSONString());
        return callbackSuccess(s);
    }



    @Transactional
    @GetMapping("/zealotUpdateTest")
    public ApiResponse zealotUpdateTest() {
        JSONObject param = new JSONObject();
        param.put("position","apkInfo_update");
        Integer update = zealotService.update(param.toJSONString());
        try {
            int i = 0;
            int b = 1/i;
        }catch (Exception e){

        }

        return callbackSuccess(update+"");
    }



    @Transactional
    @GetMapping("/redisTest")
    public void redisTest() {

        AdminUser adminUser = new AdminUser();
        adminUser.setAccountType(100);
        redisTemplate.opsForValue().set("1123123",adminUser,3 * 60 * 60, TimeUnit.SECONDS);
    }

    @GetMapping("/rabbitmqTest")
    public void rabbitmqTest() {

    }

    public class AdminUser implements Serializable {


        private Integer id;

        /**
         * 记录唯一标识
         */
        private String adminUserId;

        /**
         * 父关联管理员id
         */
        private String pAdminUserId;

        /**
         * 品牌ID
         */
        private String brandId;

        /**
         * 登录账号
         */
        private String userName;

        /**
         * 别名
         */
        private String alias;

        /**
         * 登录密码
         */
        private String pwd;

        /**
         * 手机号码
         */
        private String mobile;

        /**
         * 角色关联id
         */
        private String roleId;

        /**
         * 100-超级管理员，200-代理商，300-品牌商户，0-未定义
         */
        private Integer accountType;

        /**
         * 是否主账号：1-是，0-否
         */
        private Integer isMain;


        private Integer isAllShop;

        /**
         * 0无效，1有效
         */
        private Integer state;

        private Date createTime;

        private Date updateTime;

        private String openId;

        private String miniOpenId;

        private String nickName;

        private String headImgUrl;

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getAdminUserId() {
            return adminUserId;
        }

        public void setAdminUserId(String adminUserId) {
            this.adminUserId = adminUserId;
        }

        public String getpAdminUserId() {
            return pAdminUserId;
        }

        public void setpAdminUserId(String pAdminUserId) {
            this.pAdminUserId = pAdminUserId;
        }

        public String getBrandId() {
            return brandId;
        }

        public void setBrandId(String brandId) {
            this.brandId = brandId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getRoleId() {
            return roleId;
        }

        public void setRoleId(String roleId) {
            this.roleId = roleId;
        }

        public Integer getAccountType() {
            return accountType;
        }

        public void setAccountType(Integer accountType) {
            this.accountType = accountType;
        }

        public Integer getIsMain() {
            return isMain;
        }

        public void setIsMain(Integer isMain) {
            this.isMain = isMain;
        }

        public Integer getState() {
            return state;
        }

        public void setState(Integer state) {
            this.state = state;
        }

        public Date getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Date createTime) {
            this.createTime = createTime;
        }

        public Date getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
        }

        public Integer getIsAllShop() {
            return isAllShop;
        }

        public void setIsAllShop(Integer isAllShop) {
            this.isAllShop = isAllShop;
        }

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }

        public String getMiniOpenId() {
            return miniOpenId;
        }

        public void setMiniOpenId(String miniOpenId) {
            this.miniOpenId = miniOpenId;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getHeadImgUrl() {
            return headImgUrl;
        }

        public void setHeadImgUrl(String headImgUrl) {
            this.headImgUrl = headImgUrl;
        }

    }


}
