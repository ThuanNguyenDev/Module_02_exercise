public interface Database {
    void save(Product product);
    Product get(String id);
    void update(Product product);
    void delete(String id);
}

public class ProductService {
    private Database database;

    public ProductService(Database database) {
        this.database = database;
    }

    public void createProduct(Product product) {
        database.save(product);
    }

    public Product getProduct(String id) {
        return database.get(id);
    }

    public void updateProduct(Product product) {
        database.update(product);
    }

    public void deleteProduct(String id) {
        database.delete(id);
    }
}
