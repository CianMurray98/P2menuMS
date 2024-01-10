package ie.atu.menums;

import org.apache.catalina.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "userms", url = "http://localhost:8082")
public interface UserFeignClient {

    @GetMapping("/user/{customerId}")
    User getUserByCustomerId(@PathVariable String customerId);

    @GetMapping("/order/{orderId}")
    Order getOrderById(@PathVariable String orderId);
}