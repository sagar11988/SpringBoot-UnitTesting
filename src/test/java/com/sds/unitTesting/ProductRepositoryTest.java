/*
 * package com.sds.ProductManagement;
 * 
 * import static org.junit.Assert.assertEquals;
 * 
 * import java.sql.Date;
 * 
 * import org.junit.Test; import org.junit.runner.RunWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest; import
 * org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager; import
 * org.springframework.test.context.junit4.SpringRunner;
 * 
 * import com.sds.ProductManagement.entity.Product; import
 * com.sds.ProductManagement.entity.ProductKey; import
 * com.sds.ProductManagement.exception.ProductNotFoundException; import
 * com.sds.ProductManagement.repository.ProductRespository;
 * 
 * import junit.framework.Assert;
 * 
 * @DataJpaTest
 * @RunWith(SpringRunner.class) 
 * public class ProductRepositoryTest {
 * 
 * @Autowired
 * ProductRespository productRepository;
 * 
 * @Autowired 
 * TestEntityManager entityManager;
 * 
 * 
 * 
 * 
 * @Test 
 * public void saveProductDetails() {
 * 
 * ProductKey key=new ProductKey(11988, 1);
 * 
 * Product product=new Product(key, "Cycle", 15000, 5, new Date(20220113),
 * true);
 * 
 * productRepository.save(product);
 * 
 * Product result = entityManager.find(Product.class, key);
 * 
 * assertEquals(product.getProductName(), result.getProductName());
 * 
 * }
 * 
 * 
 * @Test public void findProductDetailsbyID() {
 * 
 * ProductKey key=new ProductKey(11, 1); Product product =
 * productRepository.findById(key).orElseThrow(()-> new
 * ProductNotFoundException("not found"));
 * 
 * Product result = entityManager.find(Product.class, key);
 * 
 * assertEquals(product.getProductName(), result.getProductName());
 * 
 * }
 * 
 * 
 * 
 * 
 * } a
 */