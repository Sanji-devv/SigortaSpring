package com.company.sigorta.controller;
import com.company.sigorta.model.PaymentModel;
import com.company.sigorta.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController
{
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) { this.paymentService = paymentService; }

    @GetMapping("/list_payment")
    public List<PaymentModel> getPayments() { return paymentService.getPayments(); }

    @GetMapping("/payment_id/{id}")
    public ResponseEntity<PaymentModel> getPaymentById(@PathVariable Integer id) { return ResponseEntity.ok(paymentService.getPaymentById(id)); }

    @PostMapping("/add_payment")
    public ResponseEntity<PaymentModel> createPayment(@RequestBody PaymentModel payment) { return ResponseEntity.ok(paymentService.createPayment(payment)); }

    @PutMapping("/update_payment/{id}")
    public ResponseEntity<PaymentModel> updatePayment(@PathVariable Integer id, @RequestBody PaymentModel payment) { return ResponseEntity.ok(paymentService.updatePayment(id, payment)); }

    @DeleteMapping("/delete_payment/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Integer id)
    {
        paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }
}