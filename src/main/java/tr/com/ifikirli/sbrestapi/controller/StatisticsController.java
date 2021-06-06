package tr.com.ifikirli.sbrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tr.com.ifikirli.sbrestapi.dto.DetailOrderStatisticDto;
import tr.com.ifikirli.sbrestapi.exception.BusinessException;
import tr.com.ifikirli.sbrestapi.helper.DetailOrderStatisticModel;
import tr.com.ifikirli.sbrestapi.response.CustomResponse;
import tr.com.ifikirli.sbrestapi.service.StatisticService;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("statistics")
@Validated
public class StatisticsController extends BaseController {

    @Autowired
    StatisticService statisticService;

    @GetMapping
    public ResponseEntity<CustomResponse<DetailOrderStatisticDto>> getMonthlyStatistics(@Min(value = 2010, message = "Year min value must be 2010")
                                                                       @Max(value = 2100, message = "Year max value must be 2100")
                                                                       @RequestParam int year,
                                                                                        @Size(min = 1, max = 12, message = "Month count must be between 1 and 12.")
                                                                       @RequestParam List<Integer> months) {

        List<Integer> validatedMonths = months.stream().filter(it -> it <= 12 && it >= 0).collect(Collectors.toList());

        if(validatedMonths.size() <= 0)
            throw new BusinessException("Invalid months");

        Collections.sort(months);
        DetailOrderStatisticModel detailOrderStatisticModel = statisticService.getMonthlyStatistics(year, months);

        return renderResponse(new DetailOrderStatisticDto(detailOrderStatisticModel));
    }
}
