package kelas;
import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Shifa
 */
public class user {
    String user_name,user_email,user_password,user_fullname;
    int user_status;

    private Connection konek;
    
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String Query;
    
    public user() throws SQLException{
        koneksi koneksi = new koneksi ();
        konek = koneksi.konekDB();
        
    }
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_fullname() {
        return user_fullname;
    }

    public void setUser_fullname(String user_fullname) {
        this.user_fullname = user_fullname;
    }

    public int getUser_status() {
        return user_status;
    }

    public void setUser_status(int user_status) {
        this.user_status = user_status;
    }
    
    public void tambahUser() {
        Query = "INSERT INTO user VALUES(?, ?,MD5(?), ?, ?)";
        try {
            ps = konek.prepareStatement(Query);
            ps.setString(1, user_name);
            ps.setString(2, user_name);
            ps.setString(3, user_name);
            ps.setString(4, user_name);
            ps.setInt(5, user_status);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "user berhasil ditambahkan");
        }catch (SQLException SQLException) {
            JOptionPane.showMessageDialog(null, "user gagal ditambahkan");
        }
    }
    
}
