import com.victor.models.Product;
import com.victor.repositories.ProductRepository;
import com.victor.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class) // JUnit 5
//@RunWith(MockitoJUnitRunner.class) // JUnit 4
class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product product1;
    private Product product2;
    List<Product> products;

    @BeforeEach
    public void setUp() {
        products = new ArrayList<>();
        product1 = new Product(1L, "TV 55", "TV 55 POLEGADAS LED, LG", 500L);
        product2 = new Product(2L, "TV 48", "TV 48 POLEGADAS LCD, LG", 500L);

        products.add(product1);
        products.add(product2);
    }

    @Test
    void findProductByIdTest() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product1));
        Product product = productService.findProductById(1L);
        assertEquals(product.getDescription(), product1.getDescription());
        assertEquals(product.getId(), product1.getId());
        assertEquals(product.getName(), product1.getName());
        assertEquals(product.getUnits(), product1.getUnits());
    }

    @Test
    void addProductTest() {
        when(productRepository.save(any())).thenReturn(product2);
        Product product = productService.addProduct(product2);
        assertEquals(product.getDescription(), product2.getDescription());
        assertEquals(product.getId(), product2.getId());
        assertEquals(product.getName(), product2.getName());
        assertEquals(product.getUnits(), product2.getUnits());
    }

    @Test
    void removeProductTest() {
        doNothing().when(productRepository).delete(any());
        when(productRepository.findById(2L)).thenReturn(Optional.of(product2));
        Product product = productService.removeProduct(2L);
        assertEquals(product.getId(), product2.getId());
    }

    @Test
    void listProductsTest() {
        when(productRepository.findAll()).thenReturn(products);
        List<Product> products = productService.listProducts();
        assertEquals(2, products.size());
    }

    @Test
    void removeProductNotFoundTest() {
        when(productRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(IllegalStateException.class, () -> productService.removeProduct(1L));
    }
}
