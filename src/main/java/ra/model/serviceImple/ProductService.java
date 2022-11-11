package ra.model.serviceImple;

import ra.model.dao.IProductDAO;
import ra.model.daoImple.ProductDAOImple;
import ra.model.entity.Product;
import ra.model.service.IProductService;

import java.util.List;

public class ProductService implements IProductService<Product,String> {
    private IProductDAO<Product,String> productDAO = new ProductDAOImple();
    @Override
    public List<Product> getAll() {
        return productDAO.getAll();
    }

    @Override
    public boolean save(Product product) {
        return productDAO.save(product);
    }

    @Override
    public boolean update(Product product) {
        return productDAO.update(product);
    }

    @Override
    public boolean delete(String id) {
        return productDAO.delete(id);
    }

    @Override
    public Product getById(String id) {
        return productDAO.getById(id);
    }

    @Override
    public List<Product> searchProductByName(String name) {
        return null;
    }
}
