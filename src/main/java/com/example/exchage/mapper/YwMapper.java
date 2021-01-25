package com.example.exchage.mapper;

import com.example.exchage.entity.AreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
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
public interface YwMapper extends JpaRepository<AreaEntity, Integer> {

    @Transactional
    @Modifying
    @Query("update AreaEntity u set u.areaname= ?1,u.dlongtude=?2,u.dlatitude=?3,u.dreductprice =?4 where u.id= ?5")
    public int updateArea(
            @PathParam("areaname") String areaname,
            @PathParam("dlongtude") String dlongtude,
            @PathParam("dlatitude") String dlatitude,
            @PathParam("dreductprice") String dreductprice,
            @PathParam("id") String id);


  /* @Transactional
    @Modifying
    @Query("update AreaEntity u set u.scbyusername= ?1 where u.id= ?2")
     int updateSc(
            @PathParam("scbyusername") String scbyusername,
            @PathParam("id") String id);

*/


    @Override
    AreaEntity findOne(Integer integer);

    @Override
    <S extends AreaEntity> S save(S s);

    @Override
    List<AreaEntity> findAll();

    @Override
    void delete(AreaEntity areaEntity);

    @Query("from AreaEntity u where u.dselect=?1")
    List<AreaEntity> getArea(@PathParam("dselect") String dselect);

}
