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
        return (T) dto;
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

    public T update(T dto) {
        return null;
    }

    public T create(T dto) {
        return null;
    }

    public void delete(int id) {

    }
}
