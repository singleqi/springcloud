package cn.singleqi.feign;

import org.springframework.stereotype.Component;

@Component
public class ServiceHystrix implements Service {
    @Override
    public String home() {
        return "Feign + hystrix ,提供者服务挂了";
    }
}
