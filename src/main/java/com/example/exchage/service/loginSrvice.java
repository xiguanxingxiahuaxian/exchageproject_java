package com.example.exchage.service;


import com.example.exchage.entity.codeAndMegDTO;
import com.example.exchage.entity.loginUserDTO;
import com.example.exchage.entity.userEntity;
import com.example.exchage.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class loginSrvice {
	// 多表的交互

	@Autowired
	LoginMapper loginMapper;

	public codeAndMegDTO checkUserName(String teacher) {
		codeAndMegDTO codeAndMegDTO = new codeAndMegDTO();
		userEntity userEntity = loginMapper.checkUserName(teacher);
		if (userEntity == null) {
			codeAndMegDTO.setCode("0");
			codeAndMegDTO.setMeg("用户可以注册");
			return codeAndMegDTO;
		} else {
			if (userEntity.getStatus_().equals("1")) {
				codeAndMegDTO.setCode("1");
				codeAndMegDTO.setMeg("用户已经注册");
			} else {
				codeAndMegDTO.setCode("1");
				codeAndMegDTO.setMeg("用户正在审核中,请耐心等待");
			}

			return codeAndMegDTO;

		}
	}

	public codeAndMegDTO saveUser(userEntity Entity) {
		codeAndMegDTO codeAndMegDTO = checkUserName(Entity.getUsername_());
		if (codeAndMegDTO.getCode().equals("0")) {
			Entity.setStatus_("1");
			userEntity userEntity = loginMapper.save(Entity);
			if (userEntity != null) {
				codeAndMegDTO.setCode("0");
				codeAndMegDTO.setMeg("用户注册成功");
				return codeAndMegDTO;
			} else {
				codeAndMegDTO.setCode("1");
				codeAndMegDTO.setMeg("用户注册失败");
			}
		}
		return codeAndMegDTO;
	}

	public loginUserDTO rgister(String username, String pwd) {
		loginUserDTO loginUserDTO =new loginUserDTO();
		codeAndMegDTO codeAndMegDTO = new codeAndMegDTO();
		userEntity userEntity = loginMapper.getUserInfo(username);
		if (userEntity != null) {
			if (userEntity.getPwd_().equals(pwd)) {
				codeAndMegDTO.setCode("0");
				codeAndMegDTO.setMeg("用户登录成功");
				loginUserDTO.setUserEntity(userEntity);
			} else {
				codeAndMegDTO.setCode("1");
				codeAndMegDTO.setMeg("用户密码错误");
			}
			loginUserDTO.setCodeAndMegDTO(codeAndMegDTO);
			return loginUserDTO;
		} else {
			codeAndMegDTO.setCode("1");
			codeAndMegDTO.setMeg("登录失败，请注册");
			loginUserDTO.setCodeAndMegDTO(codeAndMegDTO);
			return loginUserDTO;
		}
	}
	public codeAndMegDTO updateStatus(String username, String type){
		codeAndMegDTO codeAndMegDTO = new codeAndMegDTO();
		int num=loginMapper.updateStatus( "1",type,username);
		if(num==1){
			codeAndMegDTO.setCode("0");
			codeAndMegDTO.setMeg("审核通过");
		}else{
			codeAndMegDTO.setCode("1");
			codeAndMegDTO.setMeg("审核失败请联系管理员");
		}
		return codeAndMegDTO;
	}
	public List<userEntity> checkEntity(){
		return loginMapper.getUserInfoCheck("0");
	}
	public codeAndMegDTO updateInfo(userEntity userEntity){
		codeAndMegDTO codeAndMegDTO = new codeAndMegDTO();
		int num=loginMapper.updateInfo(
				userEntity.getPwd_(),
				userEntity.getUsername_(),
				userEntity.getTel(),
				Integer.valueOf(userEntity.getId()));
		if(num==1){
			codeAndMegDTO.setCode("0");
			codeAndMegDTO.setMeg("修改信息成功");
		}else{
			codeAndMegDTO.setCode("1");
			codeAndMegDTO.setMeg("修改失败请联系管理员");
		}
		return codeAndMegDTO;
	}
}

