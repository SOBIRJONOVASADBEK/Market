package com.demo.repository;

import com.demo.domain.PaymentList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentList,Long> {
}
