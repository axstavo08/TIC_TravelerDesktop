package report;

import Factory.ConnectionDb;
import Factory.FactoryConnectionDb;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CReporte {

    ConnectionDb cnn;

    public CReporte() {
        cnn = FactoryConnectionDb.Open();
    }

    private void buildReport(String nameReport, List args) {
        try {
            String[] params = FactoryConnectionDb.configMySql;
            Connection cn = (DriverManager.getConnection("jdbc:mysql://localhost/" + params[0], params[1], params[2]));
            Class.forName("com.mysql.jdbc.Driver");
            try {
                String master = System.getProperty("user.dir") + "/reports/" + nameReport;

                if (master == null) {
                    System.out.println("No se encontró el archivo del reporte maestro.");
                    System.exit(2);
                }
                JasperReport masterReport = null;
                try {
                    masterReport = (JasperReport) JRLoader.loadObject(master);
                } catch (JRException e) {
                    System.out.println("Error cargando el reporte maestro: " + e.getMessage());
                    System.exit(3);
                }
                Map<String, Object> parameters = (args != null) ? buildParameters(args) : null;
                JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parameters, cn);
                Boolean cantPages = (jasperPrint.getPages().size() > 0) ? Boolean.TRUE : Boolean.FALSE;
                JasperViewer jviewer = new JasperViewer(jasperPrint, false);
                if (cantPages) {
                    jviewer.setTitle(nameReport);
                    jviewer.setVisible(true);
                }
                cnn.close();
            } catch (JRException j) {
                System.out.println("Mensaje de Error:" + j.getMessage());
            }
            cnn.close();
        } catch (SQLException ex) {
            System.out.println("\n*** SQLException caught ***\n");
            while (ex != null) {
                System.out.println("SQLState: "
                        + ex.getSQLState());
                System.out.println("Message:  " + ex.getMessage());
                System.out.println("Vendor:   "
                        + ex.getErrorCode());
                ex = ex.getNextException();
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("No se encontró la clase.\nDetalles del error: " + ex.getMessage());
        }
    }

    private Map<String, Object> buildParameters(List args) {
        Map<String, Object> parameters = new LinkedHashMap<>();
        Integer counter = 1;
        for (Object obj : args) {
            parameters.put("param" + counter.toString(), obj);
            counter++;
        }
        return parameters;
    }

    public void listRoutes() {
        buildReport("rptRoute.jasper", null);
    }

    public void listAirports() {
        buildReport("rptAirport.jasper", null);
    }

    public void listFlights() {
        buildReport("rptScheduledFlight.jasper", null);
    }

    public void lisrRoutesByOrigin(String name) {
        buildReport("rptRoutesByOrigin.jasper", new ArrayList<>(Arrays.asList(name)));
    }

    public void lisrAirportsByName(String name) {
        buildReport("rptAirportParams.jasper", new ArrayList<>(Arrays.asList(name)));
    }
}
