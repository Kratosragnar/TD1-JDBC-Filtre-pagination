import java.time.Instant;

public class Main {
    public static void main(String[] args) throws Exception {

        DBConnection db = new DBConnection();
        DataRetriever dr = new DataRetriever(db);

        System.out.println("Categories");
        dr.getAllCategories().forEach(c ->
                System.out.println(c.getId() + " - " + c.getName()));

        System.out.println("\n Pagination (page 1, size 3) ");
        dr.getProductList(1, 3).forEach(p ->
                System.out.println(p.getId() + " - " + p.getName()));

        System.out.println("\n Filtre: name contient 'phone' ");
        dr.getProductsByCriteria("phone", null, null, null)
                .forEach(p -> System.out.println(p.getName()));
    }
}
