package ra.model.entity;

import java.util.Date;

public class Product {
    private String productId;
    private String productName;
    private float importPrice;
    private String descriptions;
    private boolean productStatus;
    private Date dateInputProduct;

    public Product() {
    }

    public Product(String productId, String productName, float importPrice, String descriptions, boolean productStatus, Date dateInputProduct) {
        this.productId = productId;
        this.productName = productName;
        this.importPrice = importPrice;
        this.descriptions = descriptions;
        this.productStatus = productStatus;
        this.dateInputProduct = dateInputProduct;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public Date getDateInputProduct() {
        return dateInputProduct;
    }

    public void setDateInputProduct(Date dateInputProduct) {
        this.dateInputProduct = dateInputProduct;
    }
}
