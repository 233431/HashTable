import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String line = "";
        String splitBy = ",";
        int id = 1;

        HashTable hashTable = new HashTable();

        try {
            BufferedReader br = new BufferedReader(new FileReader("bussines.csv"));

            br.readLine();

            long startTime, endTime;

            startTime = System.nanoTime();
            while ((line = br.readLine()) != null) {
                String[] business = line.split(splitBy);
                String key = business[0];
                hashTable.insertMultiplication(key, business);
                id++;
            }
            endTime = System.nanoTime();
            long insertionTimeMultiplication = endTime - startTime;

            br.close();
            br = new BufferedReader(new FileReader("bussines.csv"));
            br.readLine();
            id = 1;

            startTime = System.nanoTime();
            while ((line = br.readLine()) != null) {
                String[] business = line.split(splitBy);
                String key = business[0];
                hashTable.insertDivision(key, business);
                id++;
            }
            endTime = System.nanoTime();
            long insertionTimeDivision = endTime - startTime;

            System.out.println("Insertion time (Multiplication): " + insertionTimeMultiplication + " ns");
            System.out.println("Insertion time (Division): " + insertionTimeDivision + " ns");

        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la clave de búsqueda: ");
        String searchKey = scanner.nextLine();
        scanner.close();

        long startTime = System.nanoTime();
        String[] resultMultiplication = hashTable.searchMultiplication(searchKey);
        long endTime = System.nanoTime();
        long searchTimeMultiplication = endTime - startTime;

        startTime = System.nanoTime();
        String[] resultDivision = hashTable.searchDivision(searchKey);
        endTime = System.nanoTime();
        long searchTimeDivision = endTime - startTime;

        if (resultMultiplication != null) {
            System.out.println("Found using multiplication: " + String.join(", ", resultMultiplication));
        } else {
            System.out.println("Not found using multiplication");
        }

        if (resultDivision != null) {
            System.out.println("Found using division: " + String.join(", ", resultDivision));
        } else {
            System.out.println("Not found using division");
        }

        System.out.println("Search time (Multiplication): " + searchTimeMultiplication + " ns");
        System.out.println("Search time (Division): " + searchTimeDivision + " ns");
    }
}
