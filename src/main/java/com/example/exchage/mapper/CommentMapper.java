package com.example.exchage.mapper;

import com.example.exchage.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * 地理位置维护
 *  查询
 *  新增
 *  查找全部
 *  删除
 */
@Repository
public interface CommentMapper extends JpaRepository<CommentEntity, Integer> {
    @Override
    List<CommentEntity> findAll();

    @Query("from CommentEntity u where u.areaname=?1")
    List<CommentEntity> getAreaName(@PathParam("areaname") String areaname);

}
