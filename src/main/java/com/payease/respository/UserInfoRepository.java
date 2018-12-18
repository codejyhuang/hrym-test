package com.payease.respository;

import com.payease.vo.EsUesrVO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by hrym13 on 2018/11/3.
 */
public interface UserInfoRepository extends ElasticsearchRepository<EsUesrVO,Integer> {
}
