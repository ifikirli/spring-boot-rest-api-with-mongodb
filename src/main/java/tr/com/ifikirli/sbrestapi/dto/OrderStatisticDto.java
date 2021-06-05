package tr.com.ifikirli.sbrestapi.dto;

import tr.com.ifikirli.sbrestapi.helper.OrderStatisticModel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderStatisticDto {

    String month;
    int totalOrderCount;
    int totalBookCount;
    BigDecimal totalPurchasedAmount;

    public OrderStatisticDto(OrderStatisticModel orderStatisticModel) {

        this.month = orderStatisticModel.getMonth();
        this.totalOrderCount = orderStatisticModel.getTotalOrderCount();
        this.totalBookCount = orderStatisticModel.getTotalBookCount();
        this.totalPurchasedAmount = orderStatisticModel.getTotalPurchasedAmount();
    }

    public static List<OrderStatisticDto> convertFromDetailOrderStatisticModel(List<OrderStatisticModel> monthlyOrderStatistics) {

        List<OrderStatisticDto> result = new ArrayList<>();

        for(OrderStatisticModel orderStatisticModel : monthlyOrderStatistics) {

            result.add(new OrderStatisticDto(orderStatisticModel));
        }

        return result;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getTotalOrderCount() {
        return totalOrderCount;
    }

    public void setTotalOrderCount(int totalOrderCount) {
        this.totalOrderCount = totalOrderCount;
    }

    public int getTotalBookCount() {
        return totalBookCount;
    }

    public void setTotalBookCount(int totalBookCount) {
        this.totalBookCount = totalBookCount;
    }

    public BigDecimal getTotalPurchasedAmount() {
        return totalPurchasedAmount;
    }

    public void setTotalPurchasedAmount(BigDecimal totalPurchasedAmount) {
        this.totalPurchasedAmount = totalPurchasedAmount;
    }
}
