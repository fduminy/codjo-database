package net.codjo.database.common.api;
import net.codjo.database.common.api.structure.SqlConstraint;
import net.codjo.database.common.api.structure.SqlTable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
public interface DatabaseHelper {

    String getDriverClassName();


    String getConnectionUrl(ConnectionMetadata connectionMetadata);


    ConnectionMetadata createApplicationConnectionMetadata();


    ConnectionMetadata createLibraryConnectionMetadata();


    Connection createConnection(ConnectionMetadata connectionMetadata) throws SQLException;


    boolean isIdentityInsertAllowed();


    void setIdentityInsert(Connection connection,
                           String catalog,
                           String tableName,
                           boolean identityInsert) throws SQLException;


    void setIdentityInsert(Connection connection,
                           String catalog,
                           String tableName,
                           boolean temporaryTable,
                           boolean identityInsert) throws SQLException;


    void changeUserGroup(Connection connection, String userName, String groupName) throws SQLException;


    void dropAllObjects(Connection connection) throws SQLException;


    /**
     * @deprecated use truncateTable(Connection connection, SqlTable sqlTable) instead.
     */
    @Deprecated
    void truncateTable(Connection connection, String tableName) throws SQLException;


    /**
     * @deprecated use truncateTable(Connection connection, SqlTable sqlTable) instead.
     */
    @Deprecated
    void truncateTable(Connection connection, String tableName, boolean temporaryTable) throws SQLException;


    void truncateTable(Connection connection, SqlTable sqlTable) throws SQLException;


    void dropForeignKey(Connection connection, SqlConstraint sqlConstraint) throws SQLException;


    List<String> buildTablesOrder(Connection connection, Map<String, List<String>> relations)
          throws SQLException;


    List<String> buildTablesOrder(Connection connection,
                                  Map<String, List<String>> relations,
                                  List<String> tablesName) throws SQLException;
}
