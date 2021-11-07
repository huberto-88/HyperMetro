package metro;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class HyperMetro {
    private static Map<String, Deque<String>> stationsSet = new HashMap<>();

    public HyperMetro(String path) {
        readJsonData(path);
    }

    public void displayStation(String stationName) {
        stationsSet.get(stationName).offerFirst("depot");
        stationsSet.get(stationName).offerLast("depot");
        System.out.println();

        for (int i = 0; i < stationsSet.get(stationName).size() - 2; i++) {
            System.out.println(
                    stationsSet.get(stationName)
                            .stream()
                            .skip(i)
                            .limit(3)
                            .collect(Collectors.joining(" - "))
            );
        }
        System.out.println();
        stationsSet.get(stationName).removeFirst();
        stationsSet.get(stationName).removeLast();
    }

    public void appendStation(String line, String station) {
        if (stationsSet.isEmpty() || !stationsSet.containsKey(line)) {
            stationsSet.put(line, new ArrayDeque<>(List.of(station)));
        } else {
            stationsSet.get(line).offer(station);
        }
    }

    public void addHead(String line, String station) {
        if (stationsSet.isEmpty() || !stationsSet.containsKey(line)) {
            stationsSet.put(line, new ArrayDeque<>(List.of(station)));
        } else {
            stationsSet.get(line).offerFirst(station);
        }
    }

    public void removeStation(String line, String station) {
        if (stationsSet.containsKey(line)) {
            stationsSet.get(line).remove(station);
        }
    }

    public static void readJsonData(String path) {
        try (FileReader fileReader = new FileReader(path);
             BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            Gson gson = new Gson();
            String json = bufferedReader.lines().collect(Collectors.joining());

            Map<String, SortedMap> sortedMap = gson.fromJson(json,
                    new TypeToken<Map<String, SortedMap<Integer, String>>>() {}.getType());

            for (String key : sortedMap.keySet()) {
                stationsSet.put(key, new ArrayDeque<String>(sortedMap.get(key).values()));
            }

        } catch (IOException fileNotFoundException) {
            System.out.println("Error! Such a file doesn't exist!");
        }
    }
}