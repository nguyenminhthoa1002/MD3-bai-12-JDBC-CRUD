package ra.model.daoImple;

import ra.model.dao.IProductDAO;
import ra.model.entity.Product;
import ra.model.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImple implements IProductDAO<Product,String> {
    @Override
    public List<Product> getAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> listProduct= null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getAllProduct()}");
            ResultSet rs = callSt.executeQuery();
            listProduct = new ArrayList<>();
            while (rs.next()){
                Product pro = new Product();
                pro.setProductId(rs.getString("productId"));
                pro.setProductName(rs.getString("productName"));
                pro.setImportPrice(rs.getFloat("importPrice"));
                pro.setDescriptions(rs.getString("descriptions"));
                pro.setProductStatus(rs.getBoolean("productStatus"));
                pro.setDateInputProduct(rs.getDate("dateInputProduct"));

                listProduct.add(pro);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return listProduct;
    }

    @Override
    public boolean save(Product product) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_insertProduct(?,?,?,?,?,?)}");
            callSt.setString(1,product.getProductId());
            callSt.setString(2, product.getProductName());
            callSt.setFloat(3,product.getImportPrice());
            callSt.setString(4, product.getDescriptions());
            callSt.setBoolean(5,product.isProductStatus());
            callSt.setDate(6,new Date(product.getDateInputProduct().getTime()));

            callSt.executeUpdate();
        }catch (Exception ex){
            result = false;
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }

    @Override
    public boolean update(Product product) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_updateProduct(?,?,?,?,?,?)}");
            callSt.setString(1,product.getProductId());
            callSt.setString(2, product.getProductName());
            callSt.setFloat(3,product.getImportPrice());
            callSt.setString(4, product.getDescriptions());
            callSt.setBoolean(5,product.isProductStatus());
            callSt.setDate(6,new Date(product.getDateInputProduct().getTime()));

            callSt.executeUpdate();
        }catch (Exception ex){
            result = false;
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_deleteProduct(?)}");
            callSt.setString(1,id);

            callSt.executeUpdate();
        }catch (Exception ex){
            result = false;
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }

    @Override
    public Product getById(String id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Product productInfo = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getProductById(?)}");
            callSt.setString(1,id);
            ResultSet rs = callSt.executeQuery();
            productInfo = new Product();
            if (rs.next()){
                productInfo.setProductId(rs.getString("productId"));
                productInfo.setProductName(rs.getString("productName"));
                productInfo.setImportPrice(rs.getFloat("importPrice"));
                productInfo.setDescriptions(rs.getString("descriptions"));
                productInfo.setProductStatus(rs.getBoolean("productStatus"));
                productInfo.setDateInputProduct(rs.getDate("dateInputProduct"));
            }
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return productInfo;
    }

    @Override
    public List<Product> searchProductByName(String name) {
        return null;
    }
}
