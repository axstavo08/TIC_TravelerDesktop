package report;

import Factory.ConnectionDb;
import Factory.FactoryConnectionDb;
import java.sql.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.*;
import java.util.HashMap;
import java.util.Map;

public class CReporte{
    ConnectionDb cnn;
    public CReporte(){
        cnn = FactoryConnectionDb.Open();
    }
    private void ReporteTodo(String NombreReporte)
    {        
//    String id_contact="0";
    
    try {
             String[] params = FactoryConnectionDb.configMySql;
            Connection cn =(DriverManager.getConnection("jdbc:mysql://localhost/"+params[0],params[1],params[2]));
            Class.forName("com.mysql.jdbc.Driver");
            try
            {            
             String master = System.getProperty("user.dir") +"/reports/" + NombreReporte;
            
            if (master == null) 
            {                
                System.out.println("No encuentro el archivo del reporte maestro.");
                System.exit(2);
            } 

            JasperReport masterReport = null;
            try 
            {
                masterReport = (JasperReport) JRLoader.loadObject(master);
            } 
            catch (JRException e) 
            {
                System.out.println("Error cargando el reporte maestro: " + e.getMessage());
                System.exit(3);
            }              
//            Map parametro = new HashMap();
//            parametro.put("id",id_contact);           
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,null,cn);
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle(NombreReporte);
            jviewer.setVisible(true);
            cnn.close();
        }
        catch (Exception j)
        {
            System.out.println("Mensaje de Error:"+j.getMessage());
        }
         cnn.close();    
        }
        catch(SQLException ex) {
           System.out.println ("\n*** SQLException caught ***\n");
            while (ex != null) {
		System.out.println ("SQLState: " +
				ex.getSQLState ());
		System.out.println ("Message:  " + ex.getMessage ());
		System.out.println ("Vendor:   " +
				ex.getErrorCode ());
		ex = ex.getNextException ();
		}
        }
        catch (java.lang.Exception ex) {
		ex.printStackTrace ();
	}
    }
    private void ReporteCon1Parametro(String NombreReporte,String par1)
    {        
    try {
             String[] params = FactoryConnectionDb.configMySql;
            Connection cn =(DriverManager.getConnection("jdbc:mysql://localhost/"+params[0],params[1],params[2]));
            Class.forName("com.mysql.jdbc.Driver");
            try
            {            
             String master = System.getProperty("user.dir") +"/reports/" + NombreReporte;
            
            if (master == null) 
            {                
                System.out.println("No encuentro el archivo del reporte maestro.");
                System.exit(2);
            } 

            JasperReport masterReport = null;
            try 
            {
                masterReport = (JasperReport) JRLoader.loadObject(master);
            } 
            catch (JRException e) 
            {
                System.out.println("Error cargando el reporte maestro: " + e.getMessage());
                System.exit(3);
            }              
            Map parametro = new HashMap();
            parametro.put("Id1",par1);           
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,parametro,cn);
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle(NombreReporte);
            jviewer.setVisible(true);
            cnn.close();
        }
        catch (Exception j)
        {
            System.out.println("Mensaje de Error:"+j.getMessage());
        }
         cnn.close();    
        }
        catch(SQLException ex) {
           System.out.println ("\n*** SQLException caught ***\n");
            while (ex != null) {
		System.out.println ("SQLState: " +
				ex.getSQLState ());
		System.out.println ("Message:  " + ex.getMessage ());
		System.out.println ("Vendor:   " +
				ex.getErrorCode ());
		ex = ex.getNextException ();
		}
        }
        catch (java.lang.Exception ex) {
		ex.printStackTrace ();
	}
    }

        private void ReporteCon3Parametro(String NombreReporte,String par1,String par2,String par3)
    {        
    try {
             String[] params = FactoryConnectionDb.configMySql;
            Connection cn =(DriverManager.getConnection("jdbc:mysql://localhost/"+params[0],params[1],params[2]));
            Class.forName("com.mysql.jdbc.Driver");
            try
            {            
             String master = System.getProperty("user.dir") +"/reports/" + NombreReporte;
            
            if (master == null) 
            {                
                System.out.println("No encuentro el archivo del reporte maestro.");
                System.exit(2);
            } 

            JasperReport masterReport = null;
            try 
            {
                masterReport = (JasperReport) JRLoader.loadObject(master);
            } 
            catch (JRException e) 
            {
                System.out.println("Error cargando el reporte maestro: " + e.getMessage());
                System.exit(3);
            }              
            Map parametro = new HashMap();
            parametro.put("Id1",par1);
            parametro.put("Id2",par2);
            parametro.put("Id3",par3);            
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,parametro,cn);
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle(NombreReporte);
            jviewer.setVisible(true);
            cnn.close();
        }
        catch (Exception j)
        {
            System.out.println("Mensaje de Error:"+j.getMessage());
        }
         cnn.close();    
        }
        catch(SQLException ex) {
           System.out.println ("\n*** SQLException caught ***\n");
            while (ex != null) {
		System.out.println ("SQLState: " +
				ex.getSQLState ());
		System.out.println ("Message:  " + ex.getMessage ());
		System.out.println ("Vendor:   " +
				ex.getErrorCode ());
		ex = ex.getNextException ();
		}
        }
        catch (java.lang.Exception ex) {
		ex.printStackTrace ();
	}
    }

public void Listatrabajadores()
{
     ReporteTodo("listatrabajadores.jasper");
}
public void ListRoutes()
{
     ReporteTodo("rptRoute.jasper");
}
public void ReporteHorario(int idtrabajador)
{
     ReporteCon1Parametro("reportehorario.jasper",idtrabajador+"");
}
public void ReporteAsistencia(int idtrabajador)
{
     ReporteCon1Parametro("reporteasistencia.jasper",idtrabajador+"");
}
public void ReporteMarcaciones(int idtrabajador,String desde,String hasta)
{
     ReporteCon3Parametro("reportemarcaciones.jasper",idtrabajador+"",desde,hasta);
}
}
