package com.test.apidemo.apidemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.test.apidemo.apidemo.R;
import com.test.apidemo.apidemo.gsonhelper.FixtureElement;
import com.test.apidemo.apidemo.gsonhelper.FixturesDetail;

public class FixtureListAdapter extends BaseAdapter {

    private FixturesDetail fixturesDetail;

    public FixtureListAdapter(FixturesDetail fixturesDetail) {
        this.fixturesDetail =fixturesDetail;
    }

    private static class ViewHolder {
        TextView homeTeamTitle,awayTeamTitle,homeTeamGoalsValue,awayTeamGoalsValue,
                statusValue,dateValue;

    }
    @Override
    public int getCount() {
        return fixturesDetail.getCount();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder vh = null;
        if (view == null) {
            LayoutInflater vi = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = vi.inflate(R.layout.fixture_list_element, null);
            vh = new ViewHolder();
            vh.homeTeamTitle = (TextView) view.findViewById(R.id.homeTeamTextViewValue);
            vh.awayTeamTitle = (TextView) view.findViewById(R.id.awayTeamTextViewValue);
            vh.homeTeamGoalsValue = (TextView) view.findViewById(R.id.homeTeamTextViewGoalsValue);
            vh.awayTeamGoalsValue = (TextView) view.findViewById(R.id.awayTeamTextViewGoalsValue);
            vh.statusValue = (TextView) view.findViewById(R.id.statusTextViewValue);
            vh.dateValue = (TextView) view.findViewById(R.id.matchDateTextView);
            view.setTag(vh);
        } else {
            vh = ((ViewHolder) view.getTag());
        }
        FixtureElement fixtureElement = fixturesDetail.getFixtures()[position];
        vh.homeTeamTitle.setText(fixtureElement.getHometeamname());
        vh.awayTeamTitle.setText(fixtureElement.getawayTeamName());
        vh.homeTeamGoalsValue.setText(Integer.toString(fixtureElement.getResult().getGoalsHomeTeam()));
        vh.awayTeamGoalsValue.setText(Integer.toString(fixtureElement.getResult().getGoalsAwayTeam()));
        vh.statusValue.setText(fixtureElement.getStatus());
        vh.dateValue.setText(fixtureElement.getDate());
        return view;
    }
}
