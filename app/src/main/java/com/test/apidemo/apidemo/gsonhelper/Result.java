package com.test.apidemo.apidemo.gsonhelper;

import java.io.Serializable;

public class Result implements Serializable {
	private int goalsAwayTeam;
	private int goalsHomeTeam;

 	public void setGoalsAwayTeam(int goalsAwayTeam) {
		this.goalsAwayTeam = goalsAwayTeam;
	}

	public int getGoalsAwayTeam() {
		return goalsAwayTeam;
	}

 	public void setGoalsHomeTeam(int goalsHomeTeam) {
		this.goalsHomeTeam = goalsHomeTeam;
	}

	public int getGoalsHomeTeam() {
		return goalsHomeTeam;
	}

}