package com.leaderboard.services;

import com.leaderboard.entities.Score;
import com.leaderboard.entities.User;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LeaderBoard {
    private HashMap<String, User> usersMap;
    private HashMap<String, Score> scoreMap;
    private static LeaderBoard leaderBoard;
    private static LeaderBoard getLeaderBoard(){
        if(leaderBoard == null)
            leaderBoard = new LeaderBoard();
        return leaderBoard;
    }
    private LeaderBoard(){
        this.scoreMap = new HashMap<>();
        this.usersMap = new HashMap<>();
    }

    //add user
    public void addUser(String name, String country, String email){
        if(!usersMap.containsKey(email)) {
            System.out.println("Error: User already exist");
            return;
        }
        usersMap.put(email, new User(name, country, email));
        System.out.println("user added successfully");
    }

    public void addScore(String email, Integer score){
        if(!usersMap.containsKey(email)){
            System.out.println("Error: User doesn't exist!");
            return;
        }

        scoreMap.put(email, new Score(usersMap.get(email), score));
        System.out.println("score added");
    }

    public void getTop(Integer val){
        List<Score> scores = scoreMap.entrySet().stream()
                .map(x -> x.getValue()).sorted().collect(Collectors.toList());
        for (int i=0; i<val; i++){
            System.out.println(scores.get(i));
        }
    }

    public void getTop(Integer val, String country){
        List<Score> scores = scoreMap.entrySet().stream()
                .filter(x -> x.getValue().getUser().getCountry().equals(country))
                .map(x -> x.getValue()).sorted().collect(Collectors.toList());
        for (int i=0; i<val; i++){
            System.out.println(scores.get(i).getUser().getName());
        }
    }

    public void getUserWithScore(Integer score){
        List<User> users = scoreMap.entrySet().stream()
                .filter(x -> x.getValue().getScore().equals(score))
                .map(x -> x.getValue().getUser())
                .collect(Collectors.toList());
        for (User user : users){
            System.out.println(user.getName());
        }
    }

    public void search(String name){
        List<User> users = usersMap.entrySet().stream()
                .filter(x -> x.getValue().getName().equals(name))
                .map(x -> x.getValue())
                .collect(Collectors.toList());
        for (User user : users)
            System.out.println(user.getName());
    }

    public void search(String name, String email){
        List<User> users = usersMap.entrySet().stream()
                .filter(x -> x.getValue().getEmail().equals(email))
                .map(x -> x.getValue())
                .collect(Collectors.toList());
        for (User user : users)
            System.out.println(user.getName());
    }

    public void search(String name, String email, String country){
        List<User> users = usersMap.entrySet().stream()
                .filter(x -> (x.getValue().getCountry().equals(country) &&  x.getValue().getName().equals(name)))
                .map(x -> x.getValue())
                .collect(Collectors.toList());
        for (User user : users)
            System.out.println(user.getName());
    }
}
