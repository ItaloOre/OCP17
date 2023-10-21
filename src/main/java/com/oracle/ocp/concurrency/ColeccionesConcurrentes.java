package com.oracle.ocp.concurrency;

import java.util.concurrent.ConcurrentHashMap;

public class ColeccionesConcurrentes {

    public static void main(String[] args) {
        //var foodData = new HashMap<String,Integer>();
        var foodData = new ConcurrentHashMap<String,Integer>();
        foodData.put("pimguin",1);
        foodData.put("flamingo",2);
        for (String key: foodData.keySet()){
            foodData.remove(key);
        }
    }
}
