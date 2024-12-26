package com.team.salre.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.favre.lib.crypto.bcrypt.BCrypt;

@Service
public class UserService {

	  @Autowired
	    private UserDAO userDAO;


	  
	    //----------------------------회원가입
	    public int registerUser(UserDTO user) {
	        // 비밀번호 암호화
	        String hashedPassword = BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray());
	    	user.setPassword(hashedPassword); // 암호화된 비밀번호로 설정

	        // DB에 저장
	        return userDAO.insertUser(user);
	    }

	    
	    
	   
	    //----------------------------로그인
	    public UserDTO loginUser(String id, String password) {
	        UserDTO user = userDAO.selectUserById(id, password);
	        //System.out.println("userDTO : " + user);
	       
	      //사용자 정보가 없으면 null 반환
			if(user ==null) {
				return null;
			}
			
		    // bcrypt 비밀번호 검증 (직접 bcrypt를 사용하여 비밀번호를 비교)
	        if (at.favre.lib.crypto.bcrypt.BCrypt.verifyer().verify(password.toCharArray(), user.getPassword()).verified) {
	            // 비밀번호가 일치하면 비밀번호는 null 처리 (보안상)
	            user.setPassword(password);
//	        	user.setPassword(null); 용범씨한테 질문 ?????????????????????????
	            return user;
	        } else {
	            // 비밀번호 불일치 시 null 반환
	            return null;
	        }
			
	        
	        
	        
	    //----------------------------아이디 찾기
	   
	     
	     
	        
	        
			
		}
	        
	
}
