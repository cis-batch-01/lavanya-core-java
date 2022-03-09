package com.technocis.lms.methods;

import java.util.ArrayList;
import java.util.List;

import com.technocis.lms.Topic;

public class AreaOfInterest {

	public List<Topic> findAreaOfInterest(List<Topic> topicList, String detail) {
		List<Topic> resList = new ArrayList<Topic>();
		for (int i = 0; i < topicList.size(); i++) {
			if (topicList.get(i).gettName().toLowerCase().contains(detail.toLowerCase())) {
				resList.add(topicList.get(i));
			}
		}
		return resList;

	}
}