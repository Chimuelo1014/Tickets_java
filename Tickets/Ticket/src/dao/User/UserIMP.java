package dao.User;
import domain.User;

import java.sql.*;
import java.util.ArrayList;
public class UserIMP implements UserRepository{

    private Connection connection;
    
    public UserIMP(Connection connection) {
        this.connection= connection;
    }

    @Override 
    public void createUser(User user) {
        String sql = "INSERT INTO user (id,name,rol) VALUES (?,?,?)";
        try (
            PreparedStatement pstm = connection.prepareStatement(sql);)
        {
            pstm.setInt(1, user.getId());
            pstm.setString(2, user.getName());
            pstm.setString(3, user.getRol());
            int rows = pstm.executeUpdate();
            System.out.println("rows afecteds: "+rows);
        }
        catch(SQLException e){
            System.out.println("databse error"+e.getMessage());
        }
    }

    @Override
    public User getUserById(int id) {
       String sql = "SELECT * FROM user WHERE id = ?";
        
       try (
       
        PreparedStatement pstm = connection.prepareStatement(sql)
        ){
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            return new User(rs.getInt("id"),
            rs.getString("name"),
            rs.getString("rol")
            );
        }
        
    } catch (SQLException e) {
      
        e.printStackTrace();
    }
    return null;

    }

    @Override
    public ArrayList<User> getAllUsers() {
        String sql = "SELECT * FROM user";
        ArrayList <User> listUsers = new ArrayList<>();
        try (
            PreparedStatement pstm = connection.prepareStatement(sql);
        ){
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                listUsers.add(new User(rs.getInt("id"),
                rs.getString("name"),
                rs.getString("rol")
                ));
            }
            rs.close();            
        } catch (SQLException e) {
            System.out.println("error sql"+e.getMessage());
        }
        
        return listUsers;
        

    }

    @Override
    public void updateUser(User user, int id) {
       String sql = "Update user SET id =?, name =?, rol = ? WHERE id =?";
       try (
            PreparedStatement pstm = connection.prepareStatement(sql);
       ) {
        pstm.setInt(1, user.getId());
        pstm.setString(2, user.getName());
        pstm.setString(3, user.getRol());
        pstm.setInt(4, id);
        int rows = pstm.executeUpdate();
        System.out.println("rows affected: "+rows);
       } catch (SQLException e) {
            System.out.println("database Connection error "+e.getMessage());
       }
       
    }

    @Override
    public void deleteUser(int id) {
      String sql = "DELETE FROM user WHERE id=?";
      try(
          PreparedStatement pstm = connection.prepareStatement(sql)
      ) {
        pstm.setInt(1, id);
        int rows = pstm.executeUpdate();
        System.out.println("rows affected: "+rows);
      } catch (Exception e) {
        System.out.println("database Connection error "+e.getMessage());
      }
    }
}