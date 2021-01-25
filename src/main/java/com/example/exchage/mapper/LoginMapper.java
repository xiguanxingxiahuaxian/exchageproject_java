package com.example.exchage.mapper;


import com.example.exchage.entity.userEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import java.util.List;

@Repository
public interface LoginMapper extends JpaRepository<userEntity, Integer> {

	@Query("from userEntity u where u.username_=?1")
	userEntity checkUserName(@PathParam("username_") String username);

	@Query("from userEntity u where u.username_=?1")
	userEntity getUserInfo(@PathParam("username_") String username);

	@Transactional
	@Modifying
	@Query("update userEntity u set u.status_= ?1,u.type_= ?2 where u.username_= ?3")
	public int updateStatus(@PathParam("status_") String status, @PathParam("type_") String type, @PathParam("username_") String username);

	@Query("from userEntity u where u.status_=?1")
    List<userEntity> getUserInfoCheck(@PathParam("status_") String status_);

	@Transactional
	@Modifying
	@Query("update userEntity u set u.pwd_ =?1,u.username_= ?2,u.tel= ?3 where u.id= ?4")
	public int updateInfo(
            @PathParam("pwd_") String pwd,
            @PathParam("username_") String pwdusername_,
            @PathParam("tel") String tel,
            @PathParam("id") int id);


}

