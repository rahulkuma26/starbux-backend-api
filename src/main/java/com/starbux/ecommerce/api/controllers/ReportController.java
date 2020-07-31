package com.starbux.ecommerce.api.controllers;

import com.starbux.ecommerce.api.models.UserReport;
import com.starbux.ecommerce.api.services.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This class will represent report controller to handle GET request for two reports.
 * 1. User related reports where you can see which user has completed how many orders and total amount
 * 2. Topping related report where you can see which topping is used most number of times.
 */
@Slf4j
@RestController
public class ReportController {

    @Autowired
    ReportService reportService;

    @GetMapping("/userreport")   // fetchUserReport method to handle Get request
    public List<UserReport> fetchUserReport() {
        log.info(this.getClass().getName() + "Method : fetchUserReport :" + "fetching user report");
        return reportService.fetchUserReports();
    }

    @GetMapping("/toppingreport") // fetchtoppingreport method to handle Get request
    public String fetchtoppingreport() {
        log.info(this.getClass().getName() + "Method : fetchtoppingreport :" + "fetching topping report");
        return reportService.fetchtoppingreport();
    }
}
