package a.b.c;

import a.b.m.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RecParamC extends ActionSupport implements ModelDriven<User>{
	@Override
	public String execute() {
		return SUCCESS;
	}

	private User user=new User();//ʹ��ģ������������new�������
	
	
	public String add() {
		System.out.println("name:" + user.getName());
		System.out.println("age:" + user.getAge());
		return "C";
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}
