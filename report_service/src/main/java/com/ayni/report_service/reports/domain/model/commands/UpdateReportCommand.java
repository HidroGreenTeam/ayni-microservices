package com.ayni.report_service.reports.domain.model.commands;

import com.ayni.report_service.reports.domain.model.valueobjects.DiagnosedDisease;

public record UpdateReportCommand(
        Long id,
        DiagnosedDisease diagnosedDisease,
        Double accuracyPercentage) {
}
