package com.ayni.report_service.reports.domain.model.queries;

import com.ayni.report_service.reports.domain.model.aggregates.Report;

import java.util.List;
import java.util.Optional;

public interface ReportQueryService {
    List<Report> getAllReports();

    Optional<Report> getReportById(Long id);
}
