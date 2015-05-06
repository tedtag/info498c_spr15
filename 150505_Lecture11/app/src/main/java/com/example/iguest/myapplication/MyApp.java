package com.example.iguest.myapplication;

import android.app.Application;

import java.util.List;

/**
 * Created by iguest on 5/5/15.
 */

class Question
{
    public Question()
    {

    }

    private String text;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
}

class Topic
{
    public Topic()
    {

    }

    private String title;
    private String description;
    private List<Question> questions;
}

public interface ITopicRepository
{
    public List<Topic> getAllTopics();

    public List<Topic> getTopicsByKeyword(String keyword);
}

public class MyApp extends Application {

    private static MyApp instance = null;

    private TopicRepository repo = new InMemoryRepository();

    /* Protect MyApp at runtime */
    public MyApp() {
        if (instance == null) {
            instance = this;
        } else {
            throw new RuntimeException("Cannot create more than one MyApp");
        }
    }

    public List<Topic> getAllTopics() {
        return topicList;
    }
}
