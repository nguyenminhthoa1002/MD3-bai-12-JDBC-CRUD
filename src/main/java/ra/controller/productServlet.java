package ra.controller;

import ra.model.entity.Product;
import ra.model.service.IProductService;
import ra.model.serviceImple.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "productServlet", value = "/productServlet")
public class productServlet extends HttpServlet {
    private IProductService<Product,String> productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action!=null&&action.equals("Update")){
            String productId = request.getParameter("productId");
            Product productUpdate = productService.getById(productId);
            request.setAttribute("productUpdate",productUpdate);
            request.getRequestDispatcher("views/updateProduct.jsp").forward(request,response);
        } else if (action!=null && action.equals("Delete")) {
            String productId = request.getParameter("productId");
            boolean result = productService.delete(productId);
            if (result){
                getAllProduct(request,response);
            } else {
                request.getRequestDispatcher("views/error.jsp").forward(request,response);
            }
        } else {
            getAllProduct(request, response);
        }
    }

    public void getAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> listProduct = productService.getAll();
        request.setAttribute("listProduct",listProduct);
        request.getRequestDispatcher("views/product.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        if (action!=null&&action.equals("Create")){
            Product pro = new Product();
            pro.setProductId(request.getParameter("productId"));
            pro.setProductName(request.getParameter("productName"));
            pro.setImportPrice(Float.parseFloat(request.getParameter("importPrice")));
            pro.setDescriptions(request.getParameter("descriptions"));
            pro.setProductStatus(Boolean.parseBoolean(request.getParameter("productStatus")));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                pro.setDateInputProduct(sdf.parse(request.getParameter("dateInputProduct")));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            boolean result = productService.save(pro);
            if (result){
                getAllProduct(request,response);
            } else {
                request.getRequestDispatcher("views/error.jsp").forward(request,response);
            }
        } else if (action!= null && action.equals("Update")) {
            Product pro = new Product();
            pro.setProductId(request.getParameter("productId"));
            pro.setProductName(request.getParameter("productName"));
            pro.setImportPrice(Float.parseFloat(request.getParameter("importPrice")));
            pro.setDescriptions(request.getParameter("descriptions"));
            pro.setProductStatus(Boolean.parseBoolean(request.getParameter("productStatus")));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                pro.setDateInputProduct(sdf.parse(request.getParameter("dateInputProduct")));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            boolean result = productService.update(pro);
            if (result){
                getAllProduct(request,response);
            } else {
                request.getRequestDispatcher("views/error.jsp").forward(request,response);
            }
        } else if (action!=null&&action.equals("Search")) {
            List<Product> listProductSearch = productService.searchProductByName(request.getParameter("searchName"));
            if (listProductSearch==null){
                getAllProduct(request,response);
            } else {
                request.setAttribute("listProduct",listProductSearch);
                request.getRequestDispatcher("views/product.jsp").forward(request,response);
            }
        }
    }
}
