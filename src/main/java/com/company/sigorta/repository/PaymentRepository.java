package com.company.sigorta.repository;
import com.company.sigorta.model.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<PaymentModel, Integer>
{
    Optional<PaymentModel> findByPaymentType(String paymentType);
}

