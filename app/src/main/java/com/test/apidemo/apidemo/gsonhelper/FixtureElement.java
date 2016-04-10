package com.test.apidemo.apidemo.gsonhelper;

import java.io.Serializable;

public class FixtureElement implements Serializable {
	private _links _links;
	private Result result;
	private String awayTeamName;
	private String date;
	private String status;
	private int matchday;

 	public void set_links(_links _links) {
		this._links = _links;
	}

	public _links get_links() {
		return _links;
	}

 	public void setResult(Result result) {
		this.result = result;
	}

	public Result getResult() {
		return result;
	}

 	public void setawayTeamName(String awayTeamName) {
		this.awayTeamName = awayTeamName;
	}

	public String getawayTeamName() {
		return awayTeamName;
	}

	private String homeTeamName;

 	public void setHometeamname(String homeTeamName) {
		this.homeTeamName = homeTeamName;
	}

	public String getHometeamname() {
		return homeTeamName;
	}

 	public void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
	}

 	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

 	public void setMatchDay(int matchDay) {
		this.matchday = matchDay;
	}

	public int getMatchDay() {
		return matchday;
	}

}