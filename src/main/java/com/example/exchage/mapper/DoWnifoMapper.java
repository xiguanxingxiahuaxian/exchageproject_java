package com.example.exchage.mapper;

import com.example.exchage.entity.DoWnifno;
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
public interface DoWnifoMapper extends JpaRepository<DoWnifno, Integer> {
    @Override
    List<DoWnifno> findAll();

    @Query("from DoWnifno u where u.mid=?1")
    List<DoWnifno> geDownName(@PathParam("mid") int mid);


}
