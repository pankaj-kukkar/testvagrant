package org.automation.Tests;

import org.automation.assertionutility.JsonAssert;
import org.automation.jsonutility.JsonUtility;
import org.json.simple.JSONArray;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases {
	JsonAssert j;
	// this can be saved in the app config and read the path from there. I am not including in this project as if now.
	String jsonFilePath = "./SourceJson/RCB.json";
	//String jsonFilePath = "./SourceJson/RCB_failcase.json"; // this file path can be used for negative scenarios test
	@BeforeMethod
	public void setup()
	{
		JSONArray players = JsonUtility.getPlayerListFromJson(jsonFilePath);
		JsonUtility.getCountryCount(players);
		j = new JsonAssert();
	}
	
	@Test
	public void TC001_validateForeignPlayersInTeam() {
		System.out.println("Getting the Foreign players numbers from the json file...");
		boolean isFourForiegenPlayes = j.isMax4ForiegnPlayers();
		Assert.assertEquals(isFourForiegenPlayes,true,"There are  more than 4 foreign players in this team");
	}
	
	@Test
	public void TC002_validateWicketKeeperInTeam() {
		boolean isAtleastOneWiketKeeper = j.isAtleast1WicketKeeper();
		System.out.println("Getting the number of wiket keepers from the json file...");
		Assert.assertEquals(isAtleastOneWiketKeeper,true, "There is less than 1 wicket keeper in this team");
	}

}
