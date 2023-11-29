package org.millie.www.MillieServer.common;

import org.millie.www.MillieServer.common.dto.ApiResponse;
import org.millie.www.MillieServer.common.httpmessage.SuccessMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HealthCheckController {

    @GetMapping
    public ApiResponse healthCheck() {
        return ApiResponse.success(SuccessMessage.OK);
    }
}
