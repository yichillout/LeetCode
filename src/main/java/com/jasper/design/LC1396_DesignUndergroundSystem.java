package com.jasper.design;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

class Passenger {
    int checkinTime;
    int checkoutTime;
    String checkinLocation;
    String checkoutLocation;

    public Passenger(String checkinLocation, int checkinTime) {
        this.checkinLocation = checkinLocation;
        this.checkinTime = checkinTime;
    }

    void checkout(String checkoutLocation, int checkoutTime) {
        this.checkoutLocation = checkoutLocation;
        this.checkoutTime = checkoutTime;
    }

}

class Route {
    String startStation;
    String endStation;
    int totalNumberOfTrips;
    long totalTimeSpentInTrips;

    public Route(String startStation, String endStation) {
        this.startStation = startStation;
        this.endStation = endStation;
    }

    double getAverageTime() {
        return (double) totalTimeSpentInTrips / totalNumberOfTrips;
    }

    void addTrip(int startTime, int endTime) {
        totalTimeSpentInTrips += endTime - startTime;
        totalNumberOfTrips++;
    }
}

class UndergroundSystem {

    Map<Integer, Passenger> currentPassengerMap;
    Map<String, Route> routeMap;

    public UndergroundSystem() {
        currentPassengerMap = new HashMap<>();
        routeMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        if (!currentPassengerMap.containsKey(id)) {
            Passenger passenger = new Passenger(stationName, t);
            currentPassengerMap.put(id, passenger);
        }
    }

    public void checkOut(int id, String stationName, int t) {
        if (currentPassengerMap.containsKey(id)) {
            Passenger passenger = currentPassengerMap.get(id);
            passenger.checkout(stationName, t);
            String routeKey = passenger.checkinLocation + "," + passenger.checkoutLocation;
            Route route = routeMap.getOrDefault(routeKey, new Route(passenger.checkinLocation, passenger.checkoutLocation));
            route.addTrip(passenger.checkinTime, passenger.checkoutTime);
            routeMap.put(routeKey, route);
            currentPassengerMap.remove(id);
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        return routeMap.get(startStation + "," + endStation).getAverageTime();
    }
}


class UndergroundSystem1 {
    Map<String, Integer> routeToTotal;
    Map<String, Integer> routeToCount;
    Map<Integer, String> idToStart;
    Map<Integer, Integer> idToStartTime;

    public UndergroundSystem1() {
        routeToTotal = new HashMap<>();
        routeToCount = new HashMap<>();
        idToStart = new HashMap<>();
        idToStartTime = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        idToStart.put(id, stationName);
        idToStartTime.put(id, t);
    }

    public void checkOut(int id, String stationName, int t) {
        String start = idToStart.get(id);
        int startTime = idToStartTime.get(id);
        String route = start + "-" + stationName;
        routeToTotal.put(route, routeToTotal.getOrDefault(route, 0) + t - startTime);
        routeToCount.put(route, routeToCount.getOrDefault(route, 0) + 1);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "-" + endStation;
        double total = routeToTotal.getOrDefault(route, 0);
        int count = routeToCount.getOrDefault(route, 0);
        return total / count;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */

public class LC1396_DesignUndergroundSystem {

    public static void main(String[] args) {
        UndergroundSystem1 undergroundSystem = new UndergroundSystem1();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);        // Customer 45 "Leyton" -> "Waterloo" in 15-3 = 12
        undergroundSystem.checkOut(27, "Waterloo", 20);        // Customer 27 "Leyton" -> "Waterloo" in 20-10 = 10
        undergroundSystem.checkOut(32, "Cambridge", 22);       // Customer 32 "Paradise" -> "Cambridge" in 22-8 = 14
        undergroundSystem.getAverageTime("Paradise", "Cambridge");              // return 14.00000. One trip "Paradise" -> "Cambridge", (14) / 1 = 14
        undergroundSystem.getAverageTime("Leyton", "Waterloo");                 // return 11.00000. Two trips "Leyton" -> "Waterloo", (10 + 12) / 2 = 11
        undergroundSystem.checkIn(10, "Leyton", 24);
        undergroundSystem.getAverageTime("Leyton", "Waterloo");                 // return 11.00000
        undergroundSystem.checkOut(10, "Waterloo", 38);        // Customer 10 "Leyton" -> "Waterloo" in 38-24 = 14
        undergroundSystem.getAverageTime("Leyton", "Waterloo");                 // return 12.00000. Three trips "Leyton" -> "Waterloo", (10 + 12 + 14) / 3 = 12
    }
}
