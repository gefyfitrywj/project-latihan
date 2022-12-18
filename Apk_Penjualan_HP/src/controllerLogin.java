
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author GIE
 */
public class controllerLogin extends modelLogin{
    private modelLogin model;
    KoneksiDatabase conn = new KoneksiDatabase();
    NewJFrame home;
    public void setLogin(modelLogin model) {
        this.model = model;
    }
    
    public void cek(F_Login view) throws SQLException{
        String username = view.getUsername().getText();
        String pass = view.getPassword().getText();
        String query = "SELECT * FROM admin WHERE Id_Admin = '" + username + "'";

        conn.statement = conn.connection.createStatement();
        ResultSet rs = conn.statement.executeQuery(query);

        if (rs.next()) {
            if (username.equals(rs.getString("email")) && pass.equals(rs.getString("password"))) {
                JOptionPane.showMessageDialog(view, "Login berhasil");
                home = new NewJFrame();
                home.setVisible(true);                
                view.dispose();
            } else {
                JOptionPane.showMessageDialog(view, "Email atau password salah");
            }
        }
    
    }
    
    public void cekLogin(F_Login view) throws SQLException {
        try {
            String email = view.getUsername().getText();
            String pass = view.getPassword().getText();

            if (email.trim().equals("") || pass.trim().equals("")) {
                JOptionPane.showMessageDialog(view, "Email atau Password tidak boleh kosong");
            } else {
                cek(view);
            }
        } catch (HeadlessException | NumberFormatException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
    }
}