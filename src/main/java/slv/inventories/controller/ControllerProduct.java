package slv.inventories.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import slv.inventories.Exception.NotFoundException;
import slv.inventories.model.Product;
import slv.inventories.service.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//http:/localhost:8080/inventory-app
@RequestMapping("inventory-app")
@CrossOrigin(value = "http://localhost:4200")
public class ControllerProduct {
    private static final Logger logger = LoggerFactory.getLogger(ControllerProduct.class);

    @Autowired
    private ProductService productService;

    // To obtain all data from the DB, this is going to be the link http://localhost:8080/inventory-app/products
    @GetMapping("/products")
    public List<Product> getProducts(){
        List<Product> products = this.productService.listProducts();
        logger.info("Products obtained: ");
        products.forEach((product -> logger.info(product.toString())));
        return products;
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        logger.info("Product to add: " + product);
        return this.productService.saveProduct(product);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> obtainProductById(@PathVariable int id) {
        Product product = this.productService.searchProductById(id);
        if (product != null)
            return ResponseEntity.ok(product);
        else
            throw new NotFoundException("Product #" + id + "could not be found");
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product receivedProduct){
        Product product = this.productService.searchProductById(id);
        if (product == null)
            throw new NotFoundException("ID " + id + " could not be found");
        product.setDescription(receivedProduct.getDescription());
        product.setPrice(receivedProduct.getPrice());
        product.setStock(receivedProduct.getStock());
        this.productService.saveProduct(product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Map<String, Boolean>>deleteProduct(@PathVariable int id){
        Product product = this.productService.searchProductById(id);
        if (product == null)
            throw new NotFoundException("ID " + id + " could not be found");
        this.productService.deleteProductById(product.getIdProduct());
        Map<String, Boolean> answer = new HashMap<>();
        answer.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(answer);
    }
}
