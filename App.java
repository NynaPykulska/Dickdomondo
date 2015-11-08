import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import difflib.Delta;
import difflib.DiffUtils;
import difflib.Patch;
import static java.lang.Math.abs;
import difflib.*;
 
public class App {
        // Helper method for get the file content
        private static List<String> fileToLines(String filename) {
                List<String> lines = new LinkedList<String>();
                String line = "";
                try {
                        BufferedReader in = new BufferedReader(new FileReader(filename));
                        while ((line = in.readLine()) != null) {
                                lines.add(line);
                        }
                } catch (IOException e) {
                        e.printStackTrace();
                }
                return lines;
        }
        
        private static boolean isImportant (Delta d) {

            String original = d.getOriginal().getLines().toString();
            String revised = d.getRevised().getLines().toString();
        	            
            String[] splitO = original.split("\\W+");
            String[] splitR = revised.split("\\W+");

            int lngth;
            String longer;
            String shorter;
            int counter;
            boolean ifFound = false;
            
            if(splitO.length != splitR.length) ifFound = true;
            for (int i= 0; i < splitO.length; i++){
                if (!splitO[i].equals(splitR[i])){
                    if(abs(splitO[i].length() - splitR[i].length()) > 2) ifFound = true;
                    if(splitO[i].length() > splitR[i].length()){
                        longer = splitO[i];
                        shorter = splitR[i];
                        lngth = splitO[i].length();
                    }
                    else {
                        longer = splitR[i];
                        shorter = splitO[i];
                        lngth = splitR[i].length();
                    }
                    counter = 0;
                    for (int j = 0, k = 0; j < lngth; j++, k++){
                        if (longer.charAt(j) != shorter.charAt(k)) {
                            if(longer.length()!=shorter.length()) k--;
                            counter++;
                        }
                    }
                    if (counter > 2){
                        System.out.println(longer + "\n" + shorter);
                        ifFound = true;
                    }
                }
            }
            return ifFound;
        }
        public static void main(String[] args) {
            List<String> original = fileToLines(args[0]);
            List<String> revised  = fileToLines(args[1]);

                       
            Patch patch = DiffUtils.diff(original, revised);

            for (Delta delta : patch.getDeltas())
                if(isImportant(delta)) System.out.println("Difference: " + delta.getOriginal().getLines() + delta.getRevised().getLines());
        }
    
}}