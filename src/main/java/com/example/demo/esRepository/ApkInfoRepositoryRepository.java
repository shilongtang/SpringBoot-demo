package com.example.demo.esRepository;

import com.example.demo.model.po.ApkInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @Author: 青菜
 * @Date: 2019-05-30 17:49
 * @Description: apk es
 * @Version 1.0
 */
@Component
public interface ApkInfoRepositoryRepository extends ElasticsearchRepository<ApkInfo,Long> {

}
