package Project;

import java.time.LocalDateTime;
import java.util.regex.*;

public class Main {
    public static void main(String args[]) {
      String format = "room 2 : time 2022-12-04T12:15";
      Pattern pattern = Pattern.compile("room (\\d) : time (.+)$");
      Matcher matcher = pattern.matcher(format);
      if(matcher.find())
      {
        int room = Integer.parseInt(matcher.group(1));
        LocalDateTime time = LocalDateTime.parse(matcher.group(2));
        System.out.println(room + " " + time.toString());
      }
      

    }
}
