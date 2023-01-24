package org.automation.jsonutility;
import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {
	
	public static HashMap<String,Integer> Roles = new HashMap<String, Integer>();
	public static HashMap<String,Integer> Country = new HashMap<String, Integer>();
	public static JSONArray getPlayerListFromJson(String jsonFilePath)
	{
		JSONObject jsonObj;
		JSONArray players;
		JSONParser jsonParser = new JSONParser();
		try {
			FileReader fr = new FileReader(jsonFilePath);
			jsonObj = (JSONObject) jsonParser.parse(fr);
			players =  (JSONArray) jsonObj.get("player");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return players;
	}
	public static void getCountryCount(JSONArray players)
	{
	//	Integer countrycount=0;
	//	Integer rolecount=0;
		
		for (int i = 0; i < players.size(); i++) {
			   JSONObject obj= (JSONObject) players.get(i);
		//for(JSONObject json1 : players)
		
			String countryName = (String) obj.get("country");
            String role = (String)obj.get("role");
            Integer countrycount = (Integer) Country.get(countryName);
			if(countrycount == null)
			{
				Country.put(countryName, 1);
			}
			else {
				
				//countrycount=countrycount+1;
				Country.put(countryName, ++countrycount);
			}
			
			Integer rolecount = (Integer) Roles.get(role);
			if(rolecount == null)
			{
				Roles.put(role, 1);
				
			}
			else {
				//rolecount=rolecount+1;
				Roles.put(role, ++rolecount);
			}
		}
	}

}