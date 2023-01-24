package org.automation.assertionutility;
import org.automation.jsonutility.*;

public class JsonAssert {
	
	public boolean isMax4ForiegnPlayers()
	{
		Integer indianPlayers = JsonUtility.Country.get("India");
		if(indianPlayers == null || indianPlayers <7) {
			return   false;

		} else
			return true;
	}
	public boolean isAtleast1WicketKeeper(){
		Integer wicketKeeperCount = JsonUtility.Roles.get("Wicket-keeper");
		if(wicketKeeperCount==null){
			return false;
		}
		else {
			return true;
		}
	}
}
