package com.company.sigorta.repository;

import com.company.sigorta.model.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentModel, Integer>
{

}

