package tr.com.ifikirli.sbrestapi.helper;

import java.util.List;

public class DetailOrderStatisticModel {

    int year;
    List<OrderStatisticModel> monthlyOrderStatistics;

    public DetailOrderStatisticModel(int year, List<OrderStatisticModel> monthlyOrderStatistics) {

        this.year = year;
        this.monthlyOrderStatistics = monthlyOrderStatistics;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<OrderStatisticModel> getMonthlyOrderStatistics() {
        return monthlyOrderStatistics;
    }

    public void setMonthlyOrderStatistics(List<OrderStatisticModel> monthlyOrderStatistics) {
        this.monthlyOrderStatistics = monthlyOrderStatistics;
    }
}
