package com.collectionfactories;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.Map.entry;

public class CreateLists {
    public static void main(String args[]){

        //old fashion method to create a small list
        List<String> friends = new ArrayList<>();
        friends.add("Raphael");
        friends.add("Olivia");
        friends.add("Thibaut");

        //A more convenient way to write this code is to use the Arrays.asList() factory method
        List<String> friends2 = Arrays.asList("name1","name2","name3");


        List<String> friends3 = Arrays.asList("Raphael", "Olivia");
        friends3.set(0, "Richard");
        //friends3.add("Thibaut");//throws an UnsupportedOperationException

        //create a set by convenient way
        Set<String> setOfFreinds = new HashSet<>(Arrays.asList("name1","name2","name3"));

        //another way...
        Set<String> setOfFreindsByStream = Stream.of("name1","name2").collect(Collectors.toSet());

        //List Factory
        List<String> tokens = List.of("Eth","BTC","DHC");
       // tokens.add("Bintance"); //throws an UnsupportedOperationException
        System.out.println(tokens); //In fact the list that’s produced is immutable


        Set<String> friends5 = Set.of("Raphael", "Olivia", "Olivia4");
        //friends5.add("test");  //set.of is immutable function...

        //This method is convenient if you want to create a small map of up to ten keys and values. To go beyond this, use the alternative factory method called Map.ofEntries,
        //which takes Map.Entry<K, V>
        Map<String, Integer> ageOfFriends = Map.of("Raphael", 30, "Olivia", 25, "Thibaut", 26);
        //ageOfFriends.put("jalal",43);  //map.of function is immutable
        System.out.println(ageOfFriends);

        Map<String, Integer> ageOfFriends2  = Map.ofEntries(entry("Raphael", 30),
                            entry("Olivia", 25),
                            entry("Thibaut", 26));
        System.out.println(ageOfFriends);

        System.out.println("Reomve Friend with age <= 25 years old ");
        //ageOfFriends2.entrySet().removeIf(entry -> entry.getValue() <= 25);
        System.out.println(ageOfFriends);


        List<String> actors = List.of("Keanu", "Jessica");
        //actors.set(0, "Brad"); // An UnsupportedOperationException is thrown. The collection produced by List.of  is immutable.
        System.out.println(actors);

        for(Map.Entry<String,Integer> person:ageOfFriends2.entrySet()){
            String friend = person.getKey();
            Integer age = person.getValue();
            System.out.println("Friend Name is "+ friend + " and age is " + age);
        }


        //print all key& values by one instruction
        ageOfFriends2.forEach((friend,age) -> System.out.println("friend name is " + friend + " and age is "+ age ));

        //Sorting map by value and key
        ageOfFriends2
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(System.out::println);

        //Merge Two Maps
        Map<String, String> familyGroup = Map.ofEntries(
                entry("Teo", "Star Wars"), entry("Cristina", "James Bond"));
        Map<String, String> friendsGroup = Map.ofEntries(
                entry("Raphael", "Star Wars"));

        Map<String,String> everyone = new HashMap<>(familyGroup);
        everyone.putAll(friendsGroup);
        System.out.println(everyone);

        Map<String, String> familyGroup2 = Map.ofEntries(
                entry("Teo", "Star Wars"), entry("Cristina", "James Bond"));
        Map<String, String> friendsGroup2 = Map.ofEntries(
                entry("Raphael", "Star Wars"), entry("Cristina", "Matrix"));
        Map<String,String> everyoneWithConfilit = new HashMap<>(familyGroup2);
        friendsGroup2.forEach((k,v) -> everyoneWithConfilit.merge(k,v,(movie1,movie2) ->movie1 + " & " + movie2 ));
        System.out.println(everyoneWithConfilit);



        Map<String, Integer> movies = new HashMap<>();
        movies.put("JamesBond", 20);
        movies.put("Matrix", 15);
        movies.put("Harry Potter", 5);
        movies.entrySet().removeIf(en -> en.getValue()<10);
        System.out.println(movies);

        //In this example, you use the reduceValues method to find the maximum value in the map:

        ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();
        long parallelismThreshold = 1;
        Optional<Long> maxValue = Optional.ofNullable(map.reduceValues(parallelismThreshold, Long::max));


    }
}
