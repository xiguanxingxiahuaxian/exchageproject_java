package com.example.exchage.mapper;

import com.example.exchage.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import java.util.List;


@Repository
public interface GoodsMapper extends JpaRepository<Goods, Integer> {


    @Transactional
    @Modifying
    @Query("update Goods u set u.type= ?1,u.desc= ?2,u.fastsole= ?3,u.newprice= ?4,u.oldprice= ?5,u.send= ?6,u.tel= ?7,u.title= ?8,u.imageurl= ?9 where u.id= ?10")
    int updateGoods(
            @PathParam("type") String type,
            @PathParam("desc") String desc,
            @PathParam("fastsole") String fastsole,
            @PathParam("newprice") String newprice,
            @PathParam("oldprice") String oldprice,
            @PathParam("send") String send,
            @PathParam("tel") String tel,
            @PathParam("title") String title,
            @PathParam("imageurl") String imageurl,
            @PathParam("id") int id);


    @Query("from Goods u where u.username=?1")
    List<Goods> getUsername(@PathParam("username") String username);


    @Query("from Goods u where u.title=?1")
    List<Goods> getGoodByGoodname(@PathParam("title") String title);


    @Query("from Goods u where u.type=?1")
    List<Goods> getGoods(@PathParam("type") String type);
}
