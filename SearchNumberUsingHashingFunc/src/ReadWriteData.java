import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadWriteData {
    static String filePath = "src/inputData.txt";
    static String filePathOutput = "src/outputData.txt";

    public static ArrayList<String> readFile() {
        ArrayList<String> dataArray = new ArrayList<>();
        String data = " ";

        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()){
                data = myReader.nextLine().replaceAll(",", data);
                String[] data1 = data.split("\\s+");
                for(String s: data1)
                    dataArray.add(s);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return dataArray;
    }

    public static void writeFile(ArrayList<String> data) throws IOException {
        FileWriter fw = new FileWriter(filePathOutput);
        fw.write(data.toString());
        fw.flush();
    }
}
