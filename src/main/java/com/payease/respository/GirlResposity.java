package com.payease.respository;

import com.payease.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hrym13 on 2018/3/31.
 */
public interface GirlResposity extends JpaRepository<Girl,Integer> {
}
