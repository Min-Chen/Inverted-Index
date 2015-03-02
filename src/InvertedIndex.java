import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by minchen on 15/2/28.
 */
public class InvertedIndex {
    private static HashMap<String, HashMap<String, ArrayList<Integer>>> map = new HashMap<String, HashMap<String, ArrayList<Integer>>>();
    private static String currentFileName;
    private static int currentWordIndex;
    public static void main(String[] args)  {
        getFiles("./");
    }

    public static String filteredLine(String str){
        String pattern = "[^a-zA-Z0-9]+";
        return str.replaceAll(pattern," ");
    }


    public static void getFiles(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if(!files[i].isDirectory()){
                if(files[i].toString().toLowerCase().endsWith(".txt")) {
                    System.out.println(files[i]);
                    handleOneFile(files[i].getPath());
                }
            }
            else getFiles(files[i].getPath());
        }
    }

    public static void handleOneFile(String path) {
        try {
            FileReader fr = new FileReader (path);
            BufferedReader br = new BufferedReader(fr);
            currentFileName = path;
            currentWordIndex = 1;

            String str;
            while ((str= br.readLine()) != null){
                handleWords(filteredLine(str));
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println ("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void handleWords(String str) {
        String[] words = str.split(" ");
        for (int i=0; i<words.length; i++) {
            String word = words[i].toLowerCase().trim();
            if (word.equals("")) continue;
            storeWord(word);
            currentWordIndex++;
        }
    }

    public static void storeWord(String str) {
    }

}