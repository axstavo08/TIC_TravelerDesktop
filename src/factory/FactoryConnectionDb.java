package Factory;

public class FactoryConnectionDb {
    public static String[] configMySql= {"bdviajero","root","barcelona_15"}; //--gustavo
    //public static String[] configMySql= {"bdviajero","root",""}; //--juan carlos
    //public static String[] configMySql= {"bdviajero","root","root"}; //--walberth
    public static int gidusuario=0;
    public static ConnectionDb Open(){
        return new MySqlConnectionFactory(configMySql);
    }
}

