package deliverable4_ser322;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Iterator interface for mapping ResultSet to a java Object
 */
public interface RSConvertable<T> {
    public T fromDB(ResultSet rs) throws SQLException;
}
