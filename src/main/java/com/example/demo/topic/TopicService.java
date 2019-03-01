package com.example.demo.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic(1, "java", "core java"),
			new Topic(2, "adv java", "jsp and servlet"), new Topic(3, "jpa", "jpa in depth")));

	public List<Topic> getAllTopics() {
		return topics;
	}

	public Topic getTopic(int id) {
		return topics.stream().filter(t -> t.getId() == id).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(int id, Topic topic) {
		for(Topic t:topics) {
			if(t.getId()==id) {
				System.out.println("done");
				topics.set(topics.indexOf(t), topic);
				return;
			}
		}
	}

	public void deleteTopic(int id, Topic topic) {
		topics.removeIf(t->t.getId()==id);
	}
	

}
