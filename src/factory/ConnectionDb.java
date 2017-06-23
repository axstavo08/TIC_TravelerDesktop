package Factory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class ConnectionDb {
    protected String[] params;
    protected Connection connection;
    abstract Connection Open();
    public ResultSet query(String sql){
        Statement st;
        ResultSet rs = null;
        try{
            st = connection.createStatement();
            rs = st.executeQuery(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
    public boolean execute(String sql){
        Statement st;
        boolean save = true;
        try{
            st = connection.createStatement();
            st.executeUpdate(sql);
        }catch(SQLException e){
            save = false;
            e.printStackTrace();
        }
        return save;
    }
    public boolean close(){
        boolean ok = true;
        try{
            connection.close();
        }catch(Exception e){
            ok = false;
            e.printStackTrace();
        }
        return ok;
    }
}
