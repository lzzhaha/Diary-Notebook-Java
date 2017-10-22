package util;

import entity.User;


public class Register {
	
	static User user = new User();
	
	public static void setName(String name){
		
		user.setName(name);
		
	}

	
	
	public static String setID(String id){
		
		if(id.matches("//d{1,8}")){//id must contain 1 to 8 digits
			
			user.setID(id);
			
			return null;
		}else{
			
			return "Invalid ID format!";
		}
	}

	
	public static String setPassword(String password){
		
		if(password.matches("//d{6,15}")){
			
			user.setPassword(password);
			return null;
		}else{
			
			return "Invalid password format!";
		}
	}
	
	
	public static String register(String name, String password, String ID){
		
		user.setName(name);
		
		user.setPassword(password);
		
		user.setID(ID);
		
		return JDOM.write(name, password, ID);
	}
}
