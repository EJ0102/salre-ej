package com.team.salre.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping("/salre")
public class LoginController {

	
	 @Autowired
	    private UserService userService;

	    // 회원가입 페이지
	    @GetMapping("/signup")
	    public String signupPage() {
	        return "signup"; // signup.jsp 반환
	    }

	    // 회원가입 처리
	    @PostMapping("/signup")
	    public String registerUser(UserDTO user, Model model) {
	        int result = userService.registerUser(user);
	        model.addAttribute("message", result>0? "회원가입 성공" : "회원가입 실패");
	        return "redirect:login"; // 회원가입 후 로그인 페이지로 이동 //salre/ 추가했음
	    }

	    // 로그인 페이지
	    @GetMapping("/login")
	    public String loginPage() {
	        return "login"; // login.jsp 반환
	    }

	    // 로그인 처리
	    @PostMapping("/login")
	    public String loginUser(@RequestParam String id, @RequestParam String password, HttpSession session, Model model) {
	        UserDTO user = userService.loginUser(id, password);
	        System.out.println("user : " + user);
	        if (user != null) {
	        	session.setAttribute("loggedInUser", user);
	        	model.addAttribute("user", user);
	            return "home"; // 로그인 성공 시 home.jsp로 이동
	        	
	        	//return "redirect:/home"; // 로그인 성공 시 홈으로 이동
	            
	        	 
	        } else {
	            model.addAttribute("error", "로그인 실패: 아이디 또는 비밀번호가 잘못되었습니다.");
	            return "login"; // 로그인 실패 시 다시 로그인 페이지
	        }
	    }
	    
	    //ID 찾기 페이지
	    @GetMapping("/findId")
	    public String findIdPage() {
	    	return "findId";
	    }
	    
	    
	    /*테스트코드
	    //ID 찾기 처리 ........잠시 미뤄두기... 늪에 빠짐
	   @PostMapping("/findId")
	    public String findId(@RequestParam String user_name,@RequestParam String residentNum,
	    					@RequestParam String email, Model model) {
	    	String id = userService.
	    	
	    }
	 	*/
	    
	    
	    
	   
}




















