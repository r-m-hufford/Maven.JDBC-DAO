package daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO<T> implements DAOInterface<T>{

    public Statement statement;

    public DAO(Statement statement) {
        this.statement = statement;
    }

    public DTO findById(int id) throws SQLException {
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
        return dto;
        //before while create a new DTO and loop through responses
        //

    }

    public List findALl() throws SQLException {
        List<DTO> entries = new ArrayList<DTO>();

        ResultSet rs = statement.executeQuery("SELECT * FROM players");
        rs.beforeFirst();
        while(rs.next()) {
            DTO entry = new DTO();
            entry.setID(rs.getInt("id"));
            entry.setFirstName(rs.getString("first_name"));
            entry.setLastName(rs.getString("last_name"));
            entries.add(entry);
        }
        return entries;
    }

    public DTO update(DTO dto) throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM players WHERE id = " + dto.getID());
        while(rs.next()) {
            String newLast = rs.getString("last_name") + ".";
            rs.updateString( "last_name", newLast );
            rs.updateRow();
        }
        System.out.println();
        rs.beforeFirst();
        while(rs.next()) {
            System.out.print("ID: " + rs.getInt("id"));
            System.out.print(", FirstName: " + rs.getString("first_name"));
            System.out.println(", LastName: " + rs.getString("last_name"));
        }

        return null;
    }


    public DTO create(DTO dto) {
        return null;
    }

    public void delete(int id) {

    }
}
