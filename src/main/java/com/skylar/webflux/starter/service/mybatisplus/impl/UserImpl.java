package com.skylar.webflux.starter.service.mybatisplus.impl;

import com.skylar.webflux.starter.entity.User;
import com.skylar.webflux.starter.mapper.UserMapper;
import com.skylar.webflux.starter.service.mybatisplus.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author skylar
 * @since 2019-08-25
 */
@Service
public class UserImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
