package daos;

import java.sql.SQLException;
import java.util.List;

public interface DAOInterface<T> {

    public DTO findById(int id) throws SQLException;

    public List findALl() throws SQLException;

    public DTO update(DTO dto) throws SQLException;

    public DTO create(DTO dto);

    public void delete(int id);
}
