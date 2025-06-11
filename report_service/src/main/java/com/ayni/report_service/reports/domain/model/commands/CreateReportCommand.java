package com.ayni.report_service.reports.domain.model.commands;

import com.ayni.report_service.reports.domain.model.valueobjects.DiagnosedDisease;

public record CreateReportCommand(
        DiagnosedDisease diagnosedDisease,
        Double accuracyPercentage) {
}
