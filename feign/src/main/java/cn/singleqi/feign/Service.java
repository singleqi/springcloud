package cn.singleqi.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "service", fallback = ServiceHystrix.class)
public interface Service {

    @GetMapping("/")
    String home();

}
