package eigatracker;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase que se encarga de toda la logica en la base de datos
 * @author Hugo
 */
public class BD {
    
    private static final String URL = "jdbc:mysql://localhost:3306/eigatracker?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String USER = "root";
    private static final String PASS = "";
    private static String XAMPP;
    private static int STARTUPTIME;
    private Connection con;
    private Statement st;
    Process PROCESS_SQL;
    
    
    public void startXampp() {
        try {
            PROCESS_SQL = Runtime.getRuntime().exec(XAMPP + "\\xampp_start.exe");
            Thread.sleep(STARTUPTIME);
            }
        catch (InterruptedException | IOException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Please set the correct Xampp path at 'Options\\Options.txt'."
                    + "\nPlease set a correct amount of milliseconds."
                    + "\nDelete file for Default Options.", "XAMPP ERROR", JOptionPane.ERROR_MESSAGE);
            SelectRoute sr = new SelectRoute(0, " XAMPP ROUTE");
            sr.setVisible(true);
        }
    }
    
    public void stopXampp(){
        PROCESS_SQL.destroy();
    }
    
    /**
     * Establece la conexion con la Base de Datos
     * @return Connection: Conexion con la BD
     */
    private Connection getConnection(){
        try{
            con = DriverManager.getConnection(URL,USER, PASS);
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    /**
     * Ejecuta la query introducida para modificar datos.
     * @param _sql
     * @return int: Total de filas modificadas
     */
    public final int sentencia(final String _sql){
        con = getConnection();
        try{
            st = con.createStatement();
            int r = st.executeUpdate(_sql);
            cerrarConexion();
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return 0;
        }
    }
    
    /**
     * Ejecuta la query introducida para obtener datos.
     * @param _sql
     * @return ResultSet: Datos obtenidos
     */
    public final ResultSet consulta(final String _sql){
        con = getConnection();
        try{
            st = con.createStatement();
            return st.executeQuery(_sql);
        } catch (SQLException ex) {
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    public void cerrarConexion(){
        try{
            con.close();
            st.close();
        }
        catch(SQLException ex){
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }
    
    public void StartUp(final String[] _Options){
        XAMPP = _Options[0];
        STARTUPTIME = Integer.parseInt(_Options[1]);
        startXampp();
    }
    
}
