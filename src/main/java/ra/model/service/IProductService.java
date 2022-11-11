package ra.model.service;

import java.util.List;

public interface IProductService<T,V> extends IProductManagementService<T,V> {
    List<T> searchProductByName(String name);
}
