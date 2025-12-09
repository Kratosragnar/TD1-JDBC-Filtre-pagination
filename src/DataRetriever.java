import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {

    private final DBConnection databaseConnection;

    public DataRetriever(DBConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public List<Category> getAllCategories() throws SQLException {
        List<Category> categories = new ArrayList<>();

        String query = "SELECT id, name FROM product_category";

        try (Connection connection = databaseConnection.getDBConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Category category = new Category(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
                categories.add(category);
            }
        }

        return categories;
    }
}