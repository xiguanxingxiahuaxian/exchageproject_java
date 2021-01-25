package com.example.exchage.controller;


import com.example.exchage.entity.codeAndMegDTO;
import com.example.exchage.entity.loginUserDTO;
import com.example.exchage.entity.userEntity;
import com.example.exchage.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class loginController {

	@Autowired
	com.example.exchage.service.loginSrvice loginSrvice;
	@Autowired
	LoginMapper mapper;

	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public codeAndMegDTO check(@RequestParam("teacher") String teacher) {
		return loginSrvice.checkUserName(teacher);
	}
	@RequestMapping(value = "/queryUser", method = RequestMethod.GET)
	public List<userEntity> queryUser() {
		return mapper.findAll();
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public loginUserDTO register(@RequestParam("username") String username, @RequestParam("pwd") String pwd) {
		return loginSrvice.rgister(username, pwd);
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public codeAndMegDTO saveUser(@RequestBody userEntity userEntity) {
		return loginSrvice.saveUser(userEntity);
	}

	@RequestMapping(value="/updateStatus",method = RequestMethod.POST)
	public codeAndMegDTO updateStatus(@RequestParam("username") String username, @RequestParam("type") String type) {
		return loginSrvice.updateStatus(username,type);
	}

	@RequestMapping(value="/checkStatusInfo",method = RequestMethod.GET)
	public List<userEntity> checkStatusInfo() {
		return loginSrvice.checkEntity();
	}

	@RequestMapping(value="/updateInfo",method = RequestMethod.POST)
	public codeAndMegDTO updateStatus(@RequestBody userEntity userEntity) {
		return loginSrvice.updateInfo(userEntity);
	}

	@RequestMapping(value="/delete",method = RequestMethod.POST)
	public codeAndMegDTO delete(@RequestBody userEntity userEntity) {
		mapper.delete(userEntity.getId());
		userEntity userEntity1=mapper.checkUserName(userEntity.getUsername_());
		codeAndMegDTO codeAndMegDTO =new codeAndMegDTO();
		if(userEntity1==null){
			codeAndMegDTO.setCode("0");
			codeAndMegDTO.setMeg("删除成功");
		}else{
			codeAndMegDTO.setCode("-1");
			codeAndMegDTO.setMeg("删除失败");
		}
		return codeAndMegDTO;
	}
}
