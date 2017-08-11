package parsers.domparser;

/**
 * Created by hudov on 11.08.2017.
 */
public class DOMMain {
    public static void main(String [] args){
        AirplanesDOMBuilder domBuilder = new AirplanesDOMBuilder();
        domBuilder.buildSetAirplanes("data/airplanes.xml");
        System.out.println(domBuilder.getAirplanes());
    }
}
