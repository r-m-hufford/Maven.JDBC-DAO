package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DAO<T> implements DAOInterface<T>{

    public Statement statement;

    public DAO(Statement statement) {
        this.statement = statement;
    }

    public T findById(int id) throws SQLException {
        DTO dto = new DTO();
        ResultSet rs = statement.executeQuery("SELECT * FROM players WHERE id = " + id);
        rs.beforeFirst();
        while(rs.next()) {
            if (rs.getInt("id") == id) {
                dto.setID(rs.getInt("id"));
                dto.setFirstName(rs.getString("first_name"));
                dto.setLastName(rs.getString("last_name"));
            }
        }
        System.out.println(dto.toString());
        return (T) dto;
        //before while create a new DTO and loop through responses
        //

    }

    public List findALl() throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM players");
        rs.beforeFirst();
        while(rs.next()) {
            System.out.print("ID: " + rs.getInt("id"));
            System.out.print(", FirstName: " + rs.getString("first_name"));
            System.out.println(", LastName: " + rs.getString("last_name"));
        }
        return null;

    }

    public T update(T dto) {
        return null;
    }

    public T create(T dto) {
        return null;
    }

    public void delete(int id) {

    }
}
