package com.team.salre.login;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserDAO implements UserDAOInterface {

	@Autowired
	private SqlSession sqlSession;
	String namespace = "com.team.salre.login.UserDAOInterface.";

	// 회원가입
	public int insertUser(UserDTO user) {
		int result = sqlSession.insert(namespace + "insertUser", user);
		return result;
	}

	// 로그인
	
	public UserDTO selectUserById(String id, String password) { 
		Map<String,Object> 
		paramMap = new HashMap<String, Object>();
		System.out.println("id : " + id);
		System.out.println("password : " + password);
		paramMap.put("id", id); //첫 번째 값 
		paramMap.put("password", password); // 두 번째 값 return
		return sqlSession.selectOne(namespace + "selectUserById", paramMap); 
		}


////    테스트코드 로그인 Map아니고 DTO로..???????????
//    public UserDTO selectUserById(String id, String password) {
//        UserDTO userParam = new UserDTO();
//        userParam.setId(id);  // DTO의 id 설정
//        userParam.setPassword(password);  // DTO의 password 설정
//        return sqlSession.selectOne(namespace + "selectUserById", userParam);
//    }

	
	
  
	
}
