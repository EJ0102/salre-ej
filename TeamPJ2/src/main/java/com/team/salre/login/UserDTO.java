package com.team.salre.login;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserDTO {

	private String id; // ����� ID
    private String password; // ��й�ȣ
    private String user_name; // ����� �̸�
    private String phone_num; // ��ȭ��ȣ
    private String email; // �̸���
    private String resident_num; // �ֹε�Ϲ�ȣ
    private String address; // �ּ�
    private String address_detail; // �� �ּ�
    private String auth_seller; // �����ڵ�
	
}
