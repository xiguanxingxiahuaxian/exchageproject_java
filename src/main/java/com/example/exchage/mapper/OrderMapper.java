package com.example.exchage.mapper;

import com.example.exchage.entity.OrdEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
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
public interface OrderMapper extends JpaRepository<OrdEntity, Integer> {
    @Override
    List<OrdEntity> findAll();

    /**
     * 个人订单
     * @param username
     * @return
     */
    @Query("from OrdEntity u where u.username=?1")
    List<OrdEntity> getUsername(@PathParam("username") String username);

    /**
     * 订单详情
     * @param integer
     * @return
     */
    @Override
    OrdEntity findOne(Integer integer);

    /**
     * 下订单
     * @param s
     * @param <S>
     * @return
     */
    @Override
    <S extends OrdEntity> S save(S s);

    /**
     * 取消订单
     */
    @Transactional
    @Modifying
    @Query("update OrdEntity u set u.dorderstate= ?1 where u.id= ?2")
    public int updateStatus(@PathParam("dorderstate") String dorderstate,  @PathParam("id") int id);

}
