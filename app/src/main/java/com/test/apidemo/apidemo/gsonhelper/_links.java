package com.test.apidemo.apidemo.gsonhelper;

import java.io.Serializable;

public class _links implements Serializable {
	private Self self;
	private AwayTeam awayTeam;
	private HomeTeam homeTeam;
	private SoccerSeason soccerSeason;

 	public void setSelf(Self self) {
		this.self = self;
	}

	public Self getSelf() {
		return self;
	}

 	public void setAwayTeam(AwayTeam awayTeam) {
		this.awayTeam = awayTeam;
	}

	public AwayTeam getAwayTeam() {
		return awayTeam;
	}

 	public void setHomeTeam(HomeTeam homeTeam) {
		this.homeTeam = homeTeam;
	}

	public HomeTeam getHomeTeam() {
		return homeTeam;
	}

 	public void setSoccerSeason(SoccerSeason soccerSeason) {
		this.soccerSeason = soccerSeason;
	}

	public SoccerSeason getSoccerSeason() {
		return soccerSeason;
	}

}