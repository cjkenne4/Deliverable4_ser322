package deliverable4_ser322;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RSConvertable<T> {
    public T fromDB(ResultSet rs) throws SQLException;
}
