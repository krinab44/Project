/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cart_mart_2;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * Returns a string of text created from a JSON file
 * The URL argument must be a URL pointed to a JSON file
 *   
 * @author david
 */
public class JsonReader {
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
        sb.append((char) cp);
        }
        return sb.toString();
    }
/**
 * Returns a string of text created from a JSON file
 * The URL argument must be a URL pointed to a JSON file
 * 
 * @param  url         an absolute path to a file
 * @return jsonText    string built from JSON file   
 * @author david
 * @throws java.io.IOException
 */
    public static String readJsonFromUrl(String url) throws IOException {
        try (InputStream is = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            return jsonText;
        }
    }
 /**
 * Returns a string of text created from a JSON file
 * The fileName argument must be a text file with Charset UTF-8
 * The parsing of the file is setup for the file to be a JSON
 * 
 * @param  fileName    an absolute path to a file
 * @return jsonText    string built from JSON file   
 * @author david
 * @throws java.io.FileNotFoundException
 * @throws java.io.IOException
 */   
    public static String readJsonFromFile(String fileName) throws FileNotFoundException, IOException {
        Path path = Paths.get(fileName);
        String jsonText = Files.readString(path, Charset.forName("UTF-8"));
        return jsonText;
    }
}
