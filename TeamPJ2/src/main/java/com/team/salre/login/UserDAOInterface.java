package com.team.salre.login;

import org.apache.ibatis.annotations.Mapper;

// Interface(�԰ݼ�): ���Ǵ� �ְ� ������ ����.
@Mapper
public interface UserDAOInterface {

			// ȸ������
			public int insertUser(UserDTO user);
			
			// �α���
			public UserDTO selectUserById(String id,String password);

}