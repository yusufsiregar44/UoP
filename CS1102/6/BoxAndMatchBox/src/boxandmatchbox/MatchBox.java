package boxandmatchbox;

public class MatchBox extends Box {
  double weight;

  public MatchBox(double width, double height, double depth) {
    super(width, height, depth);
  }

  void getVolume() {
    System.out.println("Width of Matchbox is : " + width);
    System.out.println("Height of Matchbox is : " + height);
    System.out.println("Depth of Matchbox is : " + depth);
    System.out.println("Volume is : " + width * height * depth);
  }

  void calculateWeight() {
    double volume = width * height * depth;

    weight = volume *  0.03611;
    
    System.out.println("Weight is : " + weight);
  }

}