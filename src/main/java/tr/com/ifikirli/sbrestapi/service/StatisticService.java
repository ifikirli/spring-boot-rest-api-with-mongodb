package tr.com.ifikirli.sbrestapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.ifikirli.sbrestapi.helper.DetailOrderStatisticModel;
import tr.com.ifikirli.sbrestapi.helper.OrderStatisticModel;
import tr.com.ifikirli.sbrestapi.model.Order;
import tr.com.ifikirli.sbrestapi.model.OrderProduct;
import tr.com.ifikirli.sbrestapi.util.DateUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StatisticService {

    @Autowired
    private OrderService orderService;

    public DetailOrderStatisticModel getMonthlyStatistics(int year, List<Integer> months) {

        List<OrderStatisticModel> monthlyStatistics = new ArrayList<>();

        for(Integer month : months) {

            Date startDate = DateUtil.getFirstDayByYearAndMonth(year, month-1);
            Date endDate = DateUtil.getFirstDayByYearAndMonth(year, month);

            OrderStatisticModel orderStatisticModel = new OrderStatisticModel(DateUtil.getMonthNameByDate(startDate));
            List<Order> monthlyOrders = orderService.listOrderByDateInterval(startDate, endDate);

            orderStatisticModel.setTotalOrderCount(monthlyOrders.size());
            orderStatisticModel.setTotalPurchasedAmount(monthlyOrders.stream().map(Order::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add));

            int totalBookCount = 0;

            for(Order order : monthlyOrders) {

                for(OrderProduct orderProduct : order.getOrderProducts()) {

                    totalBookCount = totalBookCount + orderProduct.getCount();
                }
            }

            orderStatisticModel.setTotalBookCount(totalBookCount);
            monthlyStatistics.add(orderStatisticModel);
        }

        return new DetailOrderStatisticModel(year, monthlyStatistics);
    }
}
