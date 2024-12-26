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

	// ȸ������
	public int insertUser(UserDTO user) {
		int result = sqlSession.insert(namespace + "insertUser", user);
		return result;
	}

	// �α���
	
	public UserDTO selectUserById(String id, String password) { 
		Map<String,Object> 
		paramMap = new HashMap<String, Object>();
		System.out.println("id : " + id);
		System.out.println("password : " + password);
		paramMap.put("id", id); //ù ��° �� 
		paramMap.put("password", password); // �� ��° �� return
		return sqlSession.selectOne(namespace + "selectUserById", paramMap); 
		}


////    �׽�Ʈ�ڵ� �α��� Map�ƴϰ� DTO��..???????????
//    public UserDTO selectUserById(String id, String password) {
//        UserDTO userParam = new UserDTO();
//        userParam.setId(id);  // DTO�� id ����
//        userParam.setPassword(password);  // DTO�� password ����
//        return sqlSession.selectOne(namespace + "selectUserById", userParam);
//    }

	
	
  
	
}
