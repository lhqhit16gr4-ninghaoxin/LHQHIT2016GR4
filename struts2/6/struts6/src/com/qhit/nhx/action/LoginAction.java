package com.qhit.nhx.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qhit.nhx.bean.User;

public class LoginAction extends ActionSupport {
	private User user;
	public String login(){
		if(user.getUsername().equals("admin")&&user.getPassword().equals("123456")){
			ActionContext.getContext().getSession().put("user", user);
			return SUCCESS;
		}
		addActionError("�û�����������������µ�¼��");
		return INPUT;
	}
    
	@Override
	public void validate() {
		if(user==null){
			addFieldError("login.formInput","δ��д�û����������룡");
		}else if(user.getUsername()==null||user.getUsername().length()<5){
			addFieldError("login.username","�û���������д�����ȴ����壡");
		}else if(user.getPassword()==null||user.getPassword().length()<5){
			addFieldError("login.password","���������д�����ȴ����壡");
			
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
