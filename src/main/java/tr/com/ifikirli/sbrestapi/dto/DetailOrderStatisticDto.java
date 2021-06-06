package tr.com.ifikirli.sbrestapi.dto;

import tr.com.ifikirli.sbrestapi.helper.DetailOrderStatisticModel;

import java.util.List;

public class DetailOrderStatisticDto {

    int year;
    List<OrderStatisticDto> monthlyOrderStatistics;

    public DetailOrderStatisticDto(DetailOrderStatisticModel detailOrderStatisticModel) {

        this.year = detailOrderStatisticModel.getYear();
        this.monthlyOrderStatistics = OrderStatisticDto.convertFromDetailOrderStatisticModel(detailOrderStatisticModel.getMonthlyOrderStatistics());
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<OrderStatisticDto> getMonthlyOrderStatistics() {
        return monthlyOrderStatistics;
    }

    public void setMonthlyOrderStatistics(List<OrderStatisticDto> monthlyOrderStatistics) {
        this.monthlyOrderStatistics = monthlyOrderStatistics;
    }
}
