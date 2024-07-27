
import HashTable.HashTable;
import HashTable.HashTable2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        Scanner input = new Scanner(System.in);
        HashTable hashTableDiv = new HashTable(1);
        HashTable2 hashTableMult = new HashTable2(2);
        int selection;
        boolean continueRunning = true;

        while (continueRunning) {
            System.out.println("Seleccione una opción del menú: ");
            System.out.println("1. Cargar datos usando método de división.");
            System.out.println("2. Cargar datos usando método de multiplicación.");
            System.out.println("3. Buscar datos usando método de división.");
            System.out.println("4. Buscar datos usando método de multiplicación.");
            System.out.println("5. Salir del programa");
            selection = input.nextInt();

            switch (selection) {
                case 1:
                    double timeDiv = loadDivisionMethod(hashTableDiv);
                    System.out.println("Tiempo de procesamiento (división): " + timeDiv + " segundos.");
                    break;
                case 2:
                    double timeMult = loadMultiplicationMethod(hashTableMult);
                    System.out.println("Tiempo de procesamiento (multiplicación): " + timeMult + " segundos.");
                    break;
                case 3:
                    double searchTimeDiv = searchDivisionMethod(hashTableDiv);
                    System.out.println("Tiempo de búsqueda (división): " + searchTimeDiv + " segundos.");
                    break;
                case 4:
                    double searchTimeMult = searchMultiplicationMethod(hashTableMult);
                    System.out.println("Tiempo de búsqueda (multiplicación): " + searchTimeMult + " segundos.");
                    break;
                case 5:
                    continueRunning = false;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
        input.close();
    }

    private static double loadDivisionMethod(HashTable hashTable) {
        String filePath = "/Users/limberg/Documents/Tercer_Cuatrimestre/Estructura_de_datos_avanzada/233348_TablasHashC2/src/dataSet/bussines.csv";
        return readDataFromFile(filePath, hashTable);
    }

    private static double loadMultiplicationMethod(HashTable2 hashTable) {
        String filePath = "/Users/limberg/Documents/Tercer_Cuatrimestre/Estructura_de_datos_avanzada/233348_TablasHashC2/src/dataSet/bussines.csv";
        return readDataFromFile2(filePath, hashTable);
    }

    private static double searchDivisionMethod(HashTable hashTable) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID: ");
        String key = scanner.nextLine();

        long startTime = System.nanoTime();
        hashTable.search(key);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        return duration / 1_000_000_000.0;
    }

    private static double searchMultiplicationMethod(HashTable2 hashTable) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID: ");
        String key = scanner.nextLine();

        long startTime = System.nanoTime();
        hashTable.search(key);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        return duration / 1_000_000_000.0;
    }

    private static double readDataFromFile(String filePath, HashTable hashTable) {
        String line;
        String delimiter = ",";
        int id = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            long startTime = System.nanoTime();
            while ((line = br.readLine()) != null) {
                String[] business = line.split(delimiter);
                hashTable.add(business[0], business[1]);
                id++;
            }
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            return duration / 1_000_000_000.0;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static double readDataFromFile2(String filePath, HashTable2 hashTable) {
        String line;
        String delimiter = ",";
        int id = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            long startTime = System.nanoTime();
            while ((line = br.readLine()) != null) {
                String[] business = line.split(delimiter);
                hashTable.add(business[0], business[1]);
                id++;
            }
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            return duration / 1_000_000_000.0;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
