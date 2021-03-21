package src;

import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;


public class BirthdayExample {

    /* 
    Dunc: ReadJSONFile
    Desc: Reads a json file storing an array and returns an object 
    that can be iterated over

    Class are groups of functions,
    1 code contains one main function
    */


    public static JSONArray ReadJSONArrayFile(String fileName) {

        /* 
        read the birthday.json file and iterate over it

        parsing is converting
        */

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        JSONArray birthdayList = null;
         
        try (FileReader reader = new FileReader(fileName))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            birthdayList = (JSONArray) obj;
            System.out.println(birthdayList);
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return birthdayList;

    }

    public static void main(final String[] args) {

        //
        // how to read user input from keyboard
        //
        System.out.println("Reading user input into a string");

        // get user input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a name:");
        String name = input.nextLine();
    
        
        // print user inputp
        System.out.println("name = " + name);
    
        // close the scanner
        input.close();


        //
        // reads a json data file
        //

        // this is the relative path to the .json file.  If this does not work for you, use
        // a full path to the file. Example is below.
        
        // relative path
        String pathToFile = "./src/birthday.json";

        // full path
        // String pathToFile = "E:/Users/jerome/GitHub/evc-cit044-java-references-and-data-structures/src/birthday.json";


        JSONArray jsonData = ReadJSONArrayFile(pathToFile);

        // loop over list
        String birthday;
        JSONObject obj;
        for (Integer i = 0; i < jsonData.size() ; i++) {

            // parse the object and pull out the name and birthday
            obj = (JSONObject) jsonData.get(i);
            birthday = (String) obj.get("birthday");
            name = (String) obj.get("name");

            System.out.println("name = " + name);
            System.out.println("birthday = " + birthday);

            Map<String, String> lookUp = new HashMap<String, String>();
            lookUp.put(name, birthday);
            
            System.out.println(i);
    
        }
        
    
    }
    
}
