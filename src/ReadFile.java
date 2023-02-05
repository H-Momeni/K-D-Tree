import java.io.*;
import java.util.*;

import javax.sound.midi.Patch;

public class ReadFile {

    public float[][] Read(String path1, String path2) throws FileNotFoundException {

        Scanner scanner=new Scanner(new File(path1));
        String txt = scanner.useDelimiter("\\A").next();
        scanner.close();

        String[] parts = txt.split("\\r?\\n");
        String[] num = new String[10000]; // 10000 boad hadeaksar
        String[] count = parts[0].split(" ");

        int n = parts.length;
        int k = count.length;

        float[][] arr = new float[n][k + 1];

        for (int i = 0; i < n; i++) {
            num = parts[i].split(" ");
            for (int j = 0; j < k; j++) {
                arr[i][j] = Float.parseFloat(num[j]);
            }
        }
        if (path2 != null) { //baraye kd tree daray label
            Scanner out = new Scanner(new File(path2));
            String text = out.useDelimiter("\\A").next();
            out.close();
            String[] parts1 = text.split("\\r?\\n");

            for (int i = 0; i < n; i++) {
                arr[i][k] = Float.parseFloat(parts1[i]);
            }          
        }
        return arr;
    }

}