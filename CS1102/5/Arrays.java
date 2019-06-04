public class Arrays {
  public static void main(String[] args) {

    String[] words = new String[3];

    words[0] = "Toyota";

    String[] newWords = words;

    newWords[0] = "Honda";

    System.out.println(words[0]);
    System.out.println(newWords[0]);
  }
}