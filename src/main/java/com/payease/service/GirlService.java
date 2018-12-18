package com.payease.service;

import com.payease.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hrym13 on 2018/3/31.
 */
@Repository
public interface GirlService extends JpaRepository<Girl,Integer> {

//   public Girl findAllByID(Integer id);

}
