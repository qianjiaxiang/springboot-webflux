package com.skylar.webflux.starter.web.webflux;

import cn.hutool.core.util.StrUtil;
import com.skylar.webflux.starter.entity.User;
import com.skylar.webflux.starter.handler.UserHandler;
import com.skylar.webflux.starter.service.webflux.UserWebFluxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/userHandler")
public class UserWebHandler {
	@Autowired
	public UserHandler userHandler;
	@Autowired
	private UserWebFluxService userWebFluxService;

	/**
	 * 使用 userHandler 保存用户
	 * @param user
	 * @return
	 */
	@RequestMapping("/saveUser")
	public Mono<Integer> saveUser(@RequestBody User user){
		return userHandler.saveUser(user);
	}

	/**
	 * 使用 service 实现 通过条件查询
	 * @param userAccount
	 * @return
	 */
	@RequestMapping("/getUserList")
	public Flux<User> getUserByCond(@RequestParam(value = "userAccount", required = false) String userAccount){
		User user = new User();
		if(StrUtil.isNotEmpty(userAccount)){
			user.setUserAccount(userAccount);
		}
		return userWebFluxService.getUserByCond(user);
	}


	/**
	 * handler 查询所有用户
	 * @return
	 */
	@RequestMapping("/getAll")
	public Flux<User> getAllUser(){
		return userHandler.getAllUser();
	}

	/**
	 * service 通过 id 查询用户
	 * @param id
	 * @return
	 */
	@RequestMapping("/getSingleUser/{id}")
	public Mono<User> getSingleUserById(@PathVariable Integer id){
		return userWebFluxService.getUserById(id);
	}

	/**
	 * 通过 handler restful 风格查询 user
	 * @param id
	 * @return
	 */
	@RequestMapping("/getUser/{id}")
	public Mono<User> getUserById(@PathVariable Integer id){
		return userHandler.getUserById(id);
	}

	/**
	 * 通过 service restful 风格删除 user
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteUser/{id}")
	public Mono<Integer> deleteUser(@PathVariable Integer id){
		return userWebFluxService.deleteUser(id);
	}
}
