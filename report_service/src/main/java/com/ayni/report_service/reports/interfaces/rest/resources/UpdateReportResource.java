package com.ayni.report_service.reports.interfaces.rest.resources;

import jakarta.validation.constraints.NotNull;

public record UpdateReportResource(
        @NotNull String diagnosedDisease,
        @NotNull Double accuracyPercentage) {
}
