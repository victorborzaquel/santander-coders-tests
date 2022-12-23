import com.fasterxml.jackson.databind.ObjectMapper;
import com.victor.models.Product;
import com.victor.resources.ProductResource;
import com.victor.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.RequestBuilder;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class) // JUnit 5
public class ProductResourceTest {
    @Mock
    private ProductService productService;
    private Product product;
    private List<Product> products;
    @InjectMocks
    private ProductResource productResource;

    @Autowired
    private MockMvc mvc;

    @BeforeEach
    public void setUp() {
        product = new Product(1L, "TV 55", "TV 55 POLEGADAS LED, LG", 500L);
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void addProductHttpTest() throws Exception {
        when(productService.addProduct(any())).thenReturn(product);
        RequestBuilder requestBuilder = post("/api/v1/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(product));
        mvc.perform(requestBuilder).andExpect(status().isCreated());
        verify(productService, times(1)).addProduct(any());
    }

    @Test
    void listProductsHttpTest() throws Exception {
        when(productService.listProducts()).thenReturn(products);
        RequestBuilder requestBuilder = post("/api/v1/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(product));
        mvc.perform(requestBuilder).andDo(print());
        verify(productService).listProducts();
        verify(productService, times(1)).listProducts();
    }

    @Test
    void removeProductHttpTest() throws Exception {
        when(productService.removeProduct(product.getId())).thenReturn(product);
        RequestBuilder requestBuilder = post("/api/v1/products/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(product));
        mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andDo(print());
    }
}
