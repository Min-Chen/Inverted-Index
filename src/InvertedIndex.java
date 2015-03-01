import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * Created by minchen on 15/2/28.
 */
public class InvertedIndex {
    public static void main(String[] args)  {
        try {
            FileReader fr = new FileReader ("src/test.txt");
            BufferedReader br = new BufferedReader(fr);

            String str;
            while ((str= br.readLine()) != null){
                System.out.println(filteredLine(str));
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println ("File not found");
        } catch (IOException e) {
            e.printStackTrace();
            }
    }
    public static String filteredLine(String str){
        String pattern = "[^a-zA-Z0-9]+";
        return str.replaceAll(pattern," ");
    }
}
