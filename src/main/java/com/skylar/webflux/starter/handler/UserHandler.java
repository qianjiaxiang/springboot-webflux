package com.skylar.webflux.starter.handler;

import com.skylar.webflux.starter.entity.User;
import com.skylar.webflux.starter.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * @author SkyEgine
 */
@Component
public class UserHandler {
	@Resource
	private UserMapper userMapper;

	public Mono<Integer> saveUser(User user){
		return Mono.create(userSink -> userSink.success(userMapper.insert(user)));
	}
	public Flux<User> getAllUser(){
		return Flux.fromIterable(userMapper.selectByMap(null));
	}

	public Mono<User> getUserById(Integer id) {
		return Mono.justOrEmpty(userMapper.selectById(id));
	}
}
