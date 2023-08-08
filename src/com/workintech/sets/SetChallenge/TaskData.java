package com.workintech.sets.SetChallenge;

import java.util.*;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;

    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;


    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }

    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }

    public Set<Task> getTasks(String taskOwner){
        if(taskOwner != null && !taskOwner.isEmpty()) {
            if(taskOwner.equals("ann")) {
                return annsTasks;
            }
            if(taskOwner.equals("bob")) {
                return bobsTasks;
            }
            if(taskOwner.equals("carol")) {
                return carolsTasks;
            }
            if(taskOwner.equals("all")){
                List<Set<Task>> taskList = new ArrayList<>();
                taskList.add(annsTasks);
                taskList.add(carolsTasks);
                taskList.add(bobsTasks);
                return getUnion(taskList);
            }

        }


        return new HashSet<>();
    }



    public Set<Task> getUnion(List<Set<Task>> taskSets){

        Set<Task> total = new HashSet<>();

        for (Set<Task> set:taskSets
        ) {
            total.addAll(set);
        }
        return total;
    }


    public Set<Task> getIntersect(Set<Task> set1, Set<Task> set2){

        Set<Task> set1Copy = new HashSet<>(set1);

        set1Copy.retainAll(set2);

        return set1Copy;


    }

    public Set<Task> getDifference(Set<Task> set1, Set<Task> set2){

        Set<Task> set1Copy = new HashSet<>(set1);

        set1Copy.removeAll(set2);

        return set1Copy;


    }
}
