package Factory;

public class FactoryConnectionDb {
    public static String[] configMySql= {"bdviajero","root","barcelona_15"};
    public static int gidusuario=0;
    public static ConnectionDb Open(){
        return new MySqlConnectionFactory(configMySql);
    }
}

