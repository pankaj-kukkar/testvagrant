package org.automation.jsonutility;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class tc001 extends JsonUtility {
	
	public static void main(String[] args) {
		
		//JsonUtility j = new JsonUtility();
		JSONArray players = getPlayerListFromJson("./SourceJson/RCB.json");
		getCountryCount(players);
		System.out.println(JsonUtility.Roles.keySet().toString()  + "  ");
		System.out.println(JsonUtility.Roles.values().toString()  + "  ");
		
		System.out.println(JsonUtility.Country.keySet().toString()  + "  ");
		System.out.println(JsonUtility.Country.values().toString()  + "  ");
		
		
	}

}
