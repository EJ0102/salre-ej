package com.team.salre.login;

import org.apache.ibatis.annotations.Mapper;

// Interface(규격서): 정의는 있고 구현은 없다.
@Mapper
public interface UserDAOInterface {

			// 회원가입
			public int insertUser(UserDTO user);
			
			// 로그인
			public UserDTO selectUserById(String id,String password);

}