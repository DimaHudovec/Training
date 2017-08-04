package db;

/**
 * Created by Dima Hudovec on 03.08.2017.
 */

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import planes.*;
import java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DataBase {

    private static Connection cn;
    private static Statement st;
    private static ResultSet rs;

    static {new DOMConfigurator().doConfigure("src//log4j.xml", LogManager.getLoggerRepository());}
    static Logger logger = Logger.getLogger(DataBase.class);

    public static ArrayList<Airplane> readPlaneInfo(String table, String dataBaseName) throws ClassNotFoundException, SQLException
    {
        try {
            cn = DriverManager.getConnection("jdbc:sqlite:" + dataBaseName);
            Statement st = null;
            try {
                st = cn.createStatement();
                ResultSet rs = null;
                try {
                    rs = st.executeQuery("SELECT * FROM " + table);
                    ArrayList<Airplane> lst = new ArrayList<Airplane>();
                    while (rs.next()) {
                        int range = rs.getInt(1);
                        int capac = rs.getInt(3);
                        String name = rs.getString(2);
                        double fuel = rs.getDouble(4);
                        if(table == "PassengerAirplanes") {
                            lst.add(new PassengerAirplane(range,name,fuel,capac));
                        }
                        else if (table == "CargoAirplanes"){
                            lst.add(new CargoAirplane(range,name,fuel,capac));
                        }
                    }
                    return lst;

                } finally {

                    if (rs != null) {
                        rs.close();
                    } else {
                        logger.error("Reading DB error");
                    }
                }
            } finally {
                if (st != null) {
                    st.close();
                } else {
                    logger.error("Statement not create");
                }
            }
        } catch (SQLException e) {
            logger.error("DB connection error: " + e);
        } finally {
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    logger.error("Сonnection close error: " + e);
                }
            }
        }
        return null;
    }
}
