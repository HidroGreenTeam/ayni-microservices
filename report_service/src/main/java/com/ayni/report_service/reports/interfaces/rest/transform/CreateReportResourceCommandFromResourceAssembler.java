package com.ayni.report_service.reports.interfaces.rest.transform;

import com.ayni.report_service.reports.domain.model.commands.CreateReportCommand;
import com.ayni.report_service.reports.domain.model.valueobjects.DiagnosedDisease;
import com.ayni.report_service.reports.interfaces.rest.resources.CreateReportResource;

public class CreateReportResourceCommandFromResourceAssembler {
    public static CreateReportCommand toCommandFromResource(CreateReportResource resource) {
        return new CreateReportCommand(
                DiagnosedDisease.fromString(resource.diagnosedDisease()),
                resource.accuracyPercentage());
    }
}
