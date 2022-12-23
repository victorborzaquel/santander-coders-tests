import com.victor.models.Request;
import com.victor.services.RequestService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class RequestServiceTest {
    private final Double FRETE_VALUE = 15D;
    @InjectMocks
    private RequestService requestService;

    Request getRequest() {
        return new Request(1L, "Fulano", 15, 85.55, "SP");
    }

    @Test
    void saveRequestWithShipping() {
        Request request = getRequest();
        Request saveRequest = requestService.saveRequest(request);
        assertEquals(100.55, saveRequest.getTotalValue());
    }

    @Test
    void saveRequestWithDiscount20Percent() {
        Request request = getRequest();
        request.setTotalValue(520D);
        Request saveRequest = requestService.saveRequest(request);
        assertEquals(428D, saveRequest.getTotalValue());
    }

    @Test
    void saveRequestDFWithFreeShipping() {
        double totalValue = 95D;
        Request request = getRequest();
        request.setStatus("DF");
        request.setTotalValue(totalValue);
        Request saveRequest = requestService.saveRequest(request);
        assertEquals(totalValue + FRETE_VALUE, saveRequest.getTotalValue());
    }
}
