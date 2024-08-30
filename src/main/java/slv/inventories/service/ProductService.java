package slv.inventories.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import slv.inventories.model.Product;
import slv.inventories.repository.RepositoryProduct;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private RepositoryProduct repositoryProduct;

    @Override
    public List<Product> listProducts() {
        return this.repositoryProduct.findAll();
    }

    @Override
    public Product searchProductById(Integer idProduct) {
        return this.repositoryProduct.findById(idProduct).orElse(null);
    }

    @Override
    public Product saveProduct(Product product) {
        return this.repositoryProduct.save(product);
    }

    @Override
    public void deleteProductById(Integer idProduct) {
        this.repositoryProduct.deleteById(idProduct);
    }
}
