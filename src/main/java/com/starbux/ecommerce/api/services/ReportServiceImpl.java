package com.starbux.ecommerce.api.services;

import com.starbux.ecommerce.api.models.UserReport;
import com.starbux.ecommerce.api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<UserReport> fetchUserReport() {
        return (List<UserReport>) (List<?>) orderRepository.findUserReport();
    }

    @Override
    public String fetchToppingReport() {
        return null;
    }
}
