import { Component } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
})
export class ProductListComponent {
  products: Product[];

  constructor(private productService: ProductService, private router: Router) {}

  ngOnInit() {
    // Load Products
    this.getProducts();
  }

  private getProducts() {
    // Subscribe to the observable
    this.productService.getProductList().subscribe((data) => {
      this.products = data;
    });
  }

  editProduct(id: number){
    this.router.navigate(['edit-product', id]);
  }

  deleteProduct(id: number){
    this.productService.deleteProduct(id).subscribe(
      {
        next: (data) => this.getProducts(),
        error: (error) => console.log(error)
        
      }
    );
  }
}
