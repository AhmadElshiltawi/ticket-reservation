package Project;

import java.time.LocalDateTime;

public class Main {
    public static void main(String args[]) {
      LocalDateTime time = LocalDateTime.now();
      String s = time.toString();
      LocalDateTime parse = LocalDateTime.parse(s);
      System.out.println(parse.getSecond());
    }
}
