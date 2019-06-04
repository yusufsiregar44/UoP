package boxandmatchbox;

public class App {
    public static void main(String[] args) throws Exception {
      MatchBox m = new MatchBox(5, 10, 3);

      m.getVolume();
      m.calculateWeight();
    }
}