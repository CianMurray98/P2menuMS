package ie.atu.menums;

import org.apache.catalina.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "userms")
public interface UserFeignClient {

    @GetMapping("/user/{customerId}")
    User getUserByCustomerId(@PathVariable String customerId);

    @GetMapping("/order/{orderId}")
    Order getOrderById(@PathVariable String orderId);
}