package com.skylar.webflux.starter.service.webflux;

import com.skylar.webflux.starter.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 用户WebFlux service接口
 * Webflux service
 * @author SkyEgine
 */
public interface UserWebFluxService {
	/**
	 * 保存用户
	 * @param user 用户
	 * @return
	 */
	Mono<Integer> saveUser(User user);

	Mono<User> getUserById(Integer id);

	Flux<User> getUserByCond(User user);

	Mono<Integer> deleteUser(Integer id);


}
