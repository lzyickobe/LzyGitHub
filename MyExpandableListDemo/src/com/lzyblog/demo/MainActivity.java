package com.lzyblog.demo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.Toast;
import com.lzyblog.R;
import com.lzyblog.bean.GroupInfo;
import com.lzyblog.widget.MyExpandableListView;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		List<GroupInfo> groups = new ArrayList<GroupInfo>();
		List<List<String>> childs = new ArrayList<List<String>>();

		for (int i = 0; i < 10; i++) {
			GroupInfo groupInfo = new GroupInfo();
			groupInfo.groupName = "·Ö×é" + i;
			groupInfo.groupNum = i + "/20";
			groups.add(groupInfo);

			List<String> child = new ArrayList<String>();
			for (int j = 0; j < 10; j++) {
				child.add("ºÃÓÑ " + i + "-" + j);
			}
			childs.add(child);
		}

		MyExpandableListView exList = (MyExpandableListView) findViewById(R.id.home_expandableListView);
		exList.setHeaderView(getLayoutInflater().inflate(R.layout.friend_item_group, exList, false));

		MyExpandableListAdapter adapter = new MyExpandableListAdapter(this, exList, groups, childs);
		//      setListAdapter(adapter);
		exList.setAdapter(adapter);

		exList.setOnChildClickListener(new OnChildClickListener() {
			public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
				Toast.makeText(MainActivity.this, "groupPos:" + groupPosition + "|childPos:" + childPosition, Toast.LENGTH_SHORT).show();
				return false;
			}
		});
	}
}