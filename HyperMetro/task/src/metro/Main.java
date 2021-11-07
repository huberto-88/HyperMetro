package metro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> stationList = new LinkedList<>();
        stationList.add("depot");
        stationList.add("depot");
        stationList.addAll(1, readFile(args[0]));

        for (int i = 0; i < stationList.size() - 2; i++) {
            System.out.println(
                    stationList.stream()
                            .skip(i)
                            .limit(3)
                            .collect(Collectors.joining(" - "))
            );
        }
    }

    public static LinkedList<String> readFile(String path) {
        File file = new File(path);
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            return bufferedReader.lines()
                    .collect(Collectors.toCollection(LinkedList::new));

        } catch (IOException fileNotFoundException) {
            System.out.println("Error! Such a file doesn't exist!");
        }
        return new LinkedList<>();
    }
}