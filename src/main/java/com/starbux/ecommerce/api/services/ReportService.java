package com.starbux.ecommerce.api.services;

import com.starbux.ecommerce.api.models.UserReport;
import org.springframework.validation.annotation.Validated;

import java.util.List;
/**
 * This interface will represent ReportService which defined methods to fetch reports to admin
 */
@Validated
public interface ReportService {
    List<UserReport> fetchUserReport();

    String fetchToppingReport();
}
