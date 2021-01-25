package com.example.exchage.mapper;

import com.example.exchage.entity.DMessage;
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
public interface DMessageMapper extends JpaRepository<DMessage, Integer> {

    //查看发布的
    @Query("from DMessage u where u.username=?1")
    List<DMessage> getMessage(@PathParam("username") String username);

}
