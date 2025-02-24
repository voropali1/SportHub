package cz.cvut.ear.clubevidence.rest;

import cz.cvut.ear.clubevidence.model.Payment;
import cz.cvut.ear.clubevidence.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RequestMapping("/rest/payments")
public class PaymentController {
    PaymentService paymentService;
    @Autowired
    public PaymentController(PaymentService paymentService){
        this.paymentService= paymentService;

    }
}
