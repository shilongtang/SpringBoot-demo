package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.blinkfox.zealot.bean.SqlInfo;
import com.blinkfox.zealot.config.ZealotConfigManager;
import com.blinkfox.zealot.core.Zealot;
import com.example.demo.model.po.Param;
import com.example.demo.service.ZealotService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * @Author: 青菜
 * @Date: 2019-06-26 17:38
 * @Description: zealot service impl
 * @Version 1.0
 */
@Slf4j
@Service
public class ZealotServiceServiceImpl implements ZealotService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    private void init() {
        ZealotConfigManager.getInstance().initLoadXmlLocations("zealot/xml");
    }

    @Override
    public String querySqlForList(String json) {
        Param param = JSON.parseObject(json, Param.class);
        String sqlFile = param.getSqlFile();
        String sqlFile1 = param.getSqlKey();
        Map map =  param.getParamMap();
        SqlInfo sqlInfo = Zealot.getSqlInfo(param.getSqlFile(), param.getSqlKey(), param.getParamMap());
        String sql = sqlInfo.getSql();
        Object[] params = sqlInfo.getParamsArr();
        log.info("执行sql：{}", sql);
        log.info("执行参数：{}", params);
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql, params);
        return JSON.toJSONString(mapList);
    }

    @Override
    public String querySqlForObject(String body) {
        Param param = JSON.parseObject(body, Param.class);
        String sqlFile = param.getSqlFile();
        String sqlFile1 = param.getSqlKey();
        Map map =  param.getParamMap();
        SqlInfo sqlInfo = Zealot.getSqlInfo(param.getSqlFile(), param.getSqlKey(), param.getParamMap());
        String sql = sqlInfo.getSql();
        Object[] params = sqlInfo.getParamsArr();
        log.info("执行sql：{}", sql);
        log.info("执行参数：{}", params);
        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(sql, params);
        return JSON.toJSONString(stringObjectMap);
    }

    @Override
    public Integer update(String body) {
        Param param = JSON.parseObject(body, Param.class);
        String sqlFile = param.getSqlFile();
        String sqlFile1 = param.getSqlKey();
        Map map =  param.getParamMap();
        SqlInfo sqlInfo = Zealot.getSqlInfo(param.getSqlFile(), param.getSqlKey(), param.getParamMap());
        String sql = sqlInfo.getSql();
        Object[] params = sqlInfo.getParamsArr();
        log.info("执行sql：{}", sql);
        log.info("执行参数：{}", params);
        int update = jdbcTemplate.update(sql, params);
        return update;
    }
}
