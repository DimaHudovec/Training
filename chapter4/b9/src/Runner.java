/**
 * Created by Dima Hudovec on 03.08.2017.
 */

/*Авиакомпания. Определить иерархию самолетов. Создать авиакомпанию.
Посчитать общую вместимость и грузоподъемность. Провести сортировку
самолетов компании по дальности полета. Найти самолет в компании, со-
ответствующий заданному диапазону параметров потребления горючего.
import planes.*;*/

import db.*;
import org.apache.http.client.fluent.Content;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import planecontrol.Control;
import planes.*;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    static {new DOMConfigurator().doConfigure("src//log4j.xml", LogManager.getLoggerRepository());}
    static Logger logger = Logger.getLogger(Runner.class);
    public static void main (String [] args) throws SQLException, ClassNotFoundException, IOException {
        AirCompany company = new AirCompany("Belavia");
        company.addCompanyPlanes(DataBase.readPlaneInfo("PassengerAirplanes", "PlanesDB.sqlite"));
        company.addCompanyPlanes(DataBase.readPlaneInfo("CargoAirplanes", "PlanesDB.sqlite"));
        char ch;
        int code;
        while ((code = System.in.read()) != -1) {
            ch = (char) code;
            if(ch == 's') {
                logger.info("Sorted" + Control.sortByRange(company.getCompanyPlanes()));
            }
            else if(ch == 'c') {
                int[] capac = Control.getTotalCapacity(company.getCompanyPlanes());
                logger.info("Capacity " + capac[0] + " CarryingCapacity " + capac[1]);
            }
            else if(ch == 'f') {
                    logger.info("Filtered " + Control.filterByFuelCons(company.getCompanyPlanes(),5,10));
            }
            else if (ch == 'q') return;
            }
        }
    }
