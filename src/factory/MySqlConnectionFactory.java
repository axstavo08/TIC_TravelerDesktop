package Factory;

import java.sql.Connection;
import java.sql.DriverManager;

public final class MySqlConnectionFactory extends ConnectionDb{

    public MySqlConnectionFactory(String [] params) {
        this.params = params;
        this.Open();
    }

    @Override
    public Connection Open() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try{
            //
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost/"+this.params[0],this.params[1],this.params[2]);
        }catch(Exception e){
            e.printStackTrace();
        }
        return this.connection;
    }
    
}
