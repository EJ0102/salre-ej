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

	    // ȸ������ ������
	    @GetMapping("/signup")
	    public String signupPage() {
	        return "signup"; // signup.jsp ��ȯ
	    }

	    // ȸ������ ó��
	    @PostMapping("/signup")
	    public String registerUser(UserDTO user, Model model) {
	        int result = userService.registerUser(user);
	        model.addAttribute("message", result>0? "ȸ������ ����" : "ȸ������ ����");
	        return "redirect:login"; // ȸ������ �� �α��� �������� �̵� //salre/ �߰�����
	    }

	    // �α��� ������
	    @GetMapping("/login")
	    public String loginPage() {
	        return "login"; // login.jsp ��ȯ
	    }

	    // �α��� ó��
	    @PostMapping("/login")
	    public String loginUser(@RequestParam String id, @RequestParam String password, HttpSession session, Model model) {
	        UserDTO user = userService.loginUser(id, password);
	        System.out.println("user : " + user);
	        if (user != null) {
	        	session.setAttribute("loggedInUser", user);
	        	model.addAttribute("user", user);
	            return "home"; // �α��� ���� �� home.jsp�� �̵�
	        	
	        	//return "redirect:/home"; // �α��� ���� �� Ȩ���� �̵�
	            
	        	 
	        } else {
	            model.addAttribute("error", "�α��� ����: ���̵� �Ǵ� ��й�ȣ�� �߸��Ǿ����ϴ�.");
	            return "login"; // �α��� ���� �� �ٽ� �α��� ������
	        }
	    }
	    
	    //ID ã�� ������
	    @GetMapping("/findId")
	    public String findIdPage() {
	    	return "findId";
	    }
	    
	    
	    /*�׽�Ʈ�ڵ�
	    //ID ã�� ó�� ........��� �̷�α�... �˿� ����
	   @PostMapping("/findId")
	    public String findId(@RequestParam String user_name,@RequestParam String residentNum,
	    					@RequestParam String email, Model model) {
	    	String id = userService.
	    	
	    }
	 	*/
	    
	    
	    
	   
}




















