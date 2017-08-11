package parsers.staxparser;

/**
 * Created by hudov on 11.08.2017.
 */
public class StAXMain {
    public static void main(String [] args){
        AirplanesStAXBuilder staxBuilder = new AirplanesStAXBuilder();
        staxBuilder.buildSetAirplanes("data/airplanes.xml");
        System.out.println(staxBuilder.getAirplanes());
    }
}
