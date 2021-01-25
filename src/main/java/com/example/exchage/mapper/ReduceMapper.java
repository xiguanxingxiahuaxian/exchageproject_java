package com.example.exchage.mapper;

import com.example.exchage.entity.ReduceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 地理位置维护
 *  查询
 *  新增
 *  查找全部
 *  删除
 */
@Repository
public interface ReduceMapper extends JpaRepository<ReduceEntity, Integer> {
    @Override
    List<ReduceEntity> findAll();

}
