package com.company.sigorta.service;
import com.company.sigorta.model.PaymentModel;
import com.company.sigorta.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaymentService
{
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) { this.paymentRepository = paymentRepository; }

    public List<PaymentModel> getPayments() { return paymentRepository.findAll(); }

    public PaymentModel getPaymentById(Integer id) { return paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment not found")); }

    public PaymentModel getPaymentByType(String type) { return paymentRepository.findByPaymentType(type).orElseThrow(() -> new RuntimeException("Payment not found")); }

    public PaymentModel createPayment(PaymentModel payment) { return paymentRepository.save(payment); }

    public PaymentModel updatePayment(Integer id, PaymentModel payment)
    {
        PaymentModel existingPayment = getPaymentById(id);
        existingPayment.setPaymentDate(payment.getPaymentDate());
        existingPayment.setPaymentAmount(payment.getPaymentAmount());
        existingPayment.setPaymentType(payment.getPaymentType());
        return paymentRepository.save(existingPayment);
    }

    public void deletePayment(Integer id) { paymentRepository.deleteById(id); }
}