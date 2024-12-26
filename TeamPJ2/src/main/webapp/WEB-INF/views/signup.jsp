<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"></c:set>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    
    <script src="https://cdn.iamport.kr/v1/iamport.js"></script>
    <script>
    // 포트원 SDK 초기화
    IMP.init("imp74358381"); // 예: imp00000000
    
    
   function requestCertification() {
 	// IMP.certification(param, callback) 호출
    IMP.certification(
      {
        // param
        channelKey: "{channel-key-338d3c61-d13e-4639-9997-033ab26725cd}",
        merchant_uid: "ORD" + new Date().getTime(),  //"ORD20180131-0000011", // 주문 번호
        popup: false
        //m_redirect_url: "{https://your-service.com/signup/complete}", // 모바일환경에서 popup:false(기본값) 인 경우 필수, 예: https://www.myservice.com/payments/complete/mobile
        //popup: false, // PC환경에서는 popup 파라미터가 무시되고 항상 true 로 적용됨
      },
      function (rsp) {
        // callback//본인인증 완료 후 호출되는 콜백 함수. 본인인증 요청의 결과가 담긴 객체가 rsp로 전달됨.
        if (rsp.success) {
          // 인증 성공 시 로직
        	 alert("본인인증 성공: " + rsp.imp_uid);
             document.querySelector('[name="certified"]').value = "인증 완료";//서버는 이 값 확인해서 사용자가 본인인증 완료헀는지 판단.(아래 미인증과 관련)
             document.getElementById("signup-button").disabled=false;
        } else {
          // 인증 실패 시 로직
        	 alert("본인인증 실패: " + rsp.error_msg);
        }
      },
    );
    }
	</script>
    
    
    <style>
        body { display: flex; }
        .container { margin: auto; display: flex; }
        .form-container {
            padding: 20px; width: 400px;
            border: 1px solid #ddd; border-radius: 5px;
        }
        .input-field { width: 100%; margin-bottom: 10px; }
        button { width: 100%; }
    </style>
    
    
      <script>
        function validateForm(event) {
            // Prevent form submission 폼이 서버에 제출되는 기본 동작을 중지. 유효성 검사를 모두 통과한 후에 폼을 제출하기 위해 사용.
            event.preventDefault();

            // Get form inputs
            const id = document.querySelector('[name="id"]').value.trim(); //trim()은 공백을 제거.
            let password = document.querySelector('[name="password"]').value.trim();
            const userName = document.querySelector('[name="user_name"]').value.trim();
            let phoneNum = document.querySelector('[name="phone_num"]').value.trim();
            const email = document.querySelector('[name="email"]').value.trim();
            const residentNum = document.querySelector('[name="resident_num"]').value.trim();
            let address = document.querySelector('[name="address"]').value.trim();
            let addressDetail = document.querySelector('[name="address_detail"]').value.trim();
            const authSeller = document.querySelector('[name="auth_seller"]').value.trim();
            
            //const로 선언한 변수는 한 번 값이 할당되면 다시 할당할 수 없음
            
            
            

            // Validate inputs
            if (!id) {
                alert("ID를 입력하세요.");
                return false;
            }
            if (password.length < 6) {
                alert("비밀번호는 최소 6자리 이상이어야 합니다.");
                return false;
            }
            if (!/^[가-힣a-zA-Z\s]+$/.test(userName)) {
                alert("이름은 한글 또는 영문만 입력 가능합니다.");
                return false;
            }
            if (!/^\d{3}-\d{3,4}-\d{4}$/.test(phoneNum)) {
                alert("전화번호는 하이픈(-)을 포함한 10~11자리 숫자만 입력 가능합니다.");
                return false;
            }
            if (!/\S+@\S+\.\S+/.test(email)) { //\S+: 공백이 아닌 문자가 한 글자 이상.
                alert("유효한 이메일 주소를 입력하세요.");
                return false;
            }
            if (!/^\d{6}-\d{7}$/.test(residentNum)) {
                alert("주민등록번호는 '123456-1234567' 형식으로 입력하세요.");
                return false;
            }
            if (!address) {
                alert("주소를 입력하세요.");
                return false;
            }
            if (!authSeller || isNaN(authSeller)) { //authSeller:비어 있거나 숫자가 아니면 경고창을 띄움. isNaN은 값이 숫자가 아닌 경우 true를 반환.
                alert("Auth Seller는 숫자만 입력 가능합니다.");
                return false;
            }

            // Submit the form if all validations pass 모든 유효성 검사를 통과하면 폼을 서버로 제출.
            document.querySelector('form').submit();
        }
    </script>
    
</head>
<body>

    <div class="container">
        <div class="image">
            <img src="resources/signup_image.jpg" alt="Signup Image" style="width: 300px;" />
        </div>
        <div class="form-container">
            <h2>Sign Up</h2>
            
           <%--  <form method="post" action="${contextPath}/signup>--%>
           <!-- 유효성테스트 -->
            <form method="post" action="${contextPath}/signup" onsubmit="validateForm(event)">
                <input class="input-field" type="text" name="id" placeholder="ID" required />
                <input class="input-field" type="password" name="password" placeholder="Password" required />
                <input class="input-field" type="text" name="user_name" placeholder="Name" required />
                <input class="input-field" type="text" name="phone_num" placeholder="Phone Number(하이픈 포함)" required />
                <input class="input-field" type="email" name="email" placeholder="Email" required />
                <input class="input-field" type="text" name="resident_num" placeholder="Resident Number" required />
                <input class="input-field" type="text" name="address" placeholder="Address" required />
                <input class="input-field" type="text" name="address_detail" placeholder="Address Detail" required />
                <input class="input-field" type="text" name="auth_seller" placeholder="Auth Seller" required />
                
                 <!-- 본인인증 -->
			    <input type="hidden" name="certified" value="미인증" />
			    <button type="button" onclick="requestCertification()">본인인증</button>
                
                <button id="signup-button" type="submit" disabled>Sign Up</button>
            </form>
        </div>
    </div>
</body>
</html>

