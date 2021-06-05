package tr.com.ifikirli.sbrestapi.helper;

import java.math.BigDecimal;

public class OrderStatisticModel {

    String month;
    int totalOrderCount;
    int totalBookCount;
    BigDecimal totalPurchasedAmount;

    public OrderStatisticModel(String month) {

        this.month = month;
        this.totalOrderCount = 0;
        this.totalBookCount = 0;
        this.totalPurchasedAmount = BigDecimal.ZERO;
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
