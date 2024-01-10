package ie.atu.menums;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "orderms", url = "http://localhost:8081")
public interface OrderFeignClient {

    @GetMapping("/order/{orderId}")
    Order getOrderById(@PathVariable String orderId);
}