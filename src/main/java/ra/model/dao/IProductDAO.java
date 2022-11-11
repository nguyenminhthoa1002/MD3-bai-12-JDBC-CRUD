package ra.model.dao;

import java.util.List;

public interface IProductDAO<T,V> extends IProductManager<T,V>{
    List<T> searchProductByName(String name);
}
