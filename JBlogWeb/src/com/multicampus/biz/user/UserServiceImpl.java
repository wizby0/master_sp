package com.multicampus.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {	
	@Autowired
	private UserDAOMybatis userDAO;

	public UserVO getUser(UserVO vo){
		return userDAO.getUser(vo);
	}
}
