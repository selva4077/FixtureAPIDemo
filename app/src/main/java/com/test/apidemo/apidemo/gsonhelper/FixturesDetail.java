package com.test.apidemo.apidemo.gsonhelper;

import java.io.Serializable;

public class FixturesDetail implements Serializable {
	private FixtureElement[] fixtures;
	private int count;
	private _links _links;

 	public void setFixtures(FixtureElement[] fixtures) {
		this.fixtures = fixtures;
	}

	public FixtureElement[] getFixtures() {
		return fixtures;
	}

 	public void setCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	public void set_links(_links _links) {
		this._links = _links;
	}

	public _links get_links() {
		return _links;
	}
}