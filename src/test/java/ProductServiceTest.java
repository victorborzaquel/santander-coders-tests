import com.victor.entities.Product;
import com.victor.repositories.ProductRepository;
import com.victor.services.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

//@ExtendWith(SpringExtension.class) // JUnit 5
@RunWith(MockitoJUnitRunner.class) // JUnit 4
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @Autowired
    @InjectMocks
    private ProductService productService;

    private Product product1;
    private Product product2;
    List<Product> products;

    @Before
    public void setUp() {
        products = new ArrayList<>();
        product1 = new Product(1L, "TV 55", "TV 55 POLEGADAS LED, LG", 500L);
        product2 = new Product(2L, "TV 48", "TV 48 POLEGADAS LCD, LG", 500L);

        products.add(product1);
        products.add(product2);
    }

    @Test
    public void findProductByIdTest() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product1));
        Product product = productService.findProductById(1L);
        assertEquals(product.getDescription(), product1.getDescription());
        assertEquals(product.getId(), product1.getId());
        assertEquals(product.getName(), product1.getName());
        assertEquals(product.getUnits(), product1.getUnits());
    }
}
