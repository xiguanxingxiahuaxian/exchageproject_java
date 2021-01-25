package com.example.exchage.mapper;

import com.example.exchage.entity.ScAreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * 地理位置维护
 * 查询
 * 新增
 * 查找全部
 * 删除
 */
@Repository
public interface ScMapper extends JpaRepository<ScAreaEntity, Integer> {



  /* @Transactional
    @Modifying
    @Query("update AreaEntity u set u.scbyusername= ?1 where u.id= ?2")
     int updateSc(
            @PathParam("scbyusername") String scbyusername,
            @PathParam("id") String id);

*/



    @Query("from ScAreaEntity u where u.username=?1")
    List<ScAreaEntity> getUsername(@PathParam("username") String username);

}
