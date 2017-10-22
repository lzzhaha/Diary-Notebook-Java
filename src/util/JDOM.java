package util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

public class JDOM {

	//record user information
	public static String write(String in_name, String in_password, String id){
		
		String path = "/home/shiyanlou/Diary-Notebook-Java/UserInfo.xml";
		
		File file = new File(path);
		
		SAXBuilder saxBuilder = new SAXBuilder();
		
		Document doc;
		
		try{
			
			doc = saxBuilder.build(file);
			
			//map the tag in xml file to Element object
			
			Element root = doc.getRootElement();
			
			
			
			if(checkID(id, root)){//OK to register
				

				Element user = new Element("User");
				
				Element  name = new Element("name");

				Element password = new Element("password");
				
				user.setAttribute("id", id);
				
				name.setText(in_name);
				
				password.setText(in_password);
				
				
				//add name and password tags into user tag
				user.addContent(name);
				
				user.addContent(password);
				
				//add user tag into root tag
				root.addContent(user);
				
				//output XML file
				
				XMLOutputter out = new XMLOutputter();
				
				out.output(doc, new FileOutputStream(file));
				
				return "Registration Succeed!";
			}else{
				
				return "ID already exists!";
			}

		}catch(JDOMException e){
			
			e.printStackTrace();
		}catch(IOException e){
			
			e.printStackTrace();
		}
		
		return "ERROR";
	}
	
	
	//Check whether the given ID already exist
	public static boolean checkID(String id, Element root){
		
		boolean result = true;
		
		List<Element> users = root.getChildren();
		
		Iterator<Element> it = users.iterator();
		
		
		while(it.hasNext()){
			
			Element user = (Element) it.next();
			
			if(user.getAttribute("id").equals(id)){
				
				result = false;
				break;
			}
		}
		
		return result;
	}
	
	
	//Read XML file for registration
	
	public static String read(String id, String password){
		

		String path = "/home/shiyanlou/Diary-Notebook-Java/UserInfo.xml";
		
		File file = new File(path);
		
		SAXBuilder saxBuilder = new SAXBuilder();
		
		try{
			
			Document doc = saxBuilder.build(file);
			
			Element root = doc.getRootElement();
			
			//Obtain the name and password 
			String info = getInfo(root).get(id);
			
			if(info == null){//no such user
				return "Invalid authentication!";
			}else{
				
				String[] buffer = info.split("/");
				
				if(buffer[1] == password){
					
					return "Welcome! " + buffer[0];
				}else{
					
					return "Invalid authentication!";
				}
			}
			
			
		}catch(JDOMException e){
			
			e.printStackTrace();
		}catch(IOException e){
			
			e.printStackTrace();
		}
		
		return "Error";
	}
	
	
	/*get the name and password from root
	 * @return name-password pair
	 * 
	 * */
	private static Map<String, String> getInfo(Element root){
		
		Map<String, String> info = new TreeMap<String, String>();
		
		List<Element> users = root.getChildren("User");
		
		Iterator<Element> it = users.iterator();
		
		while(it.hasNext()){
			
			Element user = it.next();
			
			String id = user.getAttributeValue("id");
			
			String name = user.getAttributeValue("name");
			
			String password = user.getAttributeValue("password");
			
			info.put(id, name + "/" + password);
			
		}
		
		return info;
	}
			
}

