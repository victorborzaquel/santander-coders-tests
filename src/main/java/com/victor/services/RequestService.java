package com.victor.services;

import com.victor.models.Request;
import org.springframework.stereotype.Service;

@Service
public class RequestService {
    private final Double DISCOUNT_UP_500 = .2;

    public Request saveRequest(Request request) {
        addShipping(request);
        addDiscount(request);
        return request;
    }

    private Request addShipping(Request request) {
        if (request.getTotalValue() < 100 || !request.getStatus().equals("DF")) {
            request.setTotalValue(request.getTotalValue() + 15);
        }
        return request;
    }

    private Request addDiscount(Request request) {
        if (request.getTotalValue() > 500) {
            Double discount = request.getTotalValue() * DISCOUNT_UP_500;
            request.setTotalValue(request.getTotalValue() - discount);
        }
        return request;
    }
}
