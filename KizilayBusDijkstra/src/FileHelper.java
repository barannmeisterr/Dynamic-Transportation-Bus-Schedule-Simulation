// Author: Arda Baran
import java.io.*;
import java.util.*;

public class FileHelper {
    public static MyHashSet<Integer> readStationIdsFromFile(String filePath) {
        MyHashSet<Integer> stationSet = new MyHashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); 

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                for (int i = 1; i < parts.length; i++) { 
                    stationSet.add(Integer.parseInt(parts[i]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stationSet;
    }
}
