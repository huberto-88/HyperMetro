package metro;

import java.util.Scanner;

public class MetroController {
    private HyperMetro metro;
    private final Scanner scanner = new Scanner(System.in);

    public void runMetroController(String pathToFile) {
        metro = new HyperMetro(pathToFile);

        while (true) {
            String request = scanner.nextLine();
            validateAndHandleRequest(request);
        }

    }

    private void validateAndHandleRequest(String entireRequest) {
        String request = entireRequest.split("\\s+")[0];
        String[] lineStation = entireRequest.split("(\" \"|\")");
        String line = null;
        String station = null;

        if (lineStation.length > 1) line = entireRequest.split("(\" \"|\")")[1];
        if (lineStation.length > 2) station = entireRequest.split("(\" \"|\")")[2];


        switch (request) {
            case "/output":
                metro.displayStation(line);
                break;
            case "/append":
                metro.appendStation(line, station);
                break;
            case "/add-head":
                metro.addHead(line, station);
                break;
            case "/remove":
                metro.removeStation(line, station);
                break;
            case "/exit":
                System.exit(8);
                break;
            default:
                System.out.println("Invalid command");
        }
    }
}