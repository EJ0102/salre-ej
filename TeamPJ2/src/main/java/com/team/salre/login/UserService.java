package com.team.salre.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.favre.lib.crypto.bcrypt.BCrypt;

@Service
public class UserService {

	  @Autowired
	    private UserDAO userDAO;


	  
	    //----------------------------ȸ������
	    public int registerUser(UserDTO user) {
	        // ��й�ȣ ��ȣȭ
	        String hashedPassword = BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray());
	    	user.setPassword(hashedPassword); // ��ȣȭ�� ��й�ȣ�� ����

	        // DB�� ����
	        return userDAO.insertUser(user);
	    }

	    
	    
	   
	    //----------------------------�α���
	    public UserDTO loginUser(String id, String password) {
	        UserDTO user = userDAO.selectUserById(id, password);
	        //System.out.println("userDTO : " + user);
	       
	      //����� ������ ������ null ��ȯ
			if(user ==null) {
				return null;
			}
			
		    // bcrypt ��й�ȣ ���� (���� bcrypt�� ����Ͽ� ��й�ȣ�� ��)
	        if (at.favre.lib.crypto.bcrypt.BCrypt.verifyer().verify(password.toCharArray(), user.getPassword()).verified) {
	            // ��й�ȣ�� ��ġ�ϸ� ��й�ȣ�� null ó�� (���Ȼ�)
	            user.setPassword(password);
//	        	user.setPassword(null); ��������� ���� ?????????????????????????
	            return user;
	        } else {
	            // ��й�ȣ ����ġ �� null ��ȯ
	            return null;
	        }
			
	        
	        
	        
	    //----------------------------���̵� ã��
	   
	     
	     
	        
	        
			
		}
	        
	
}
