package cn.singleqi.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    @Autowired
    private Service service;

    @GetMapping("/")
    public String home(){
        return service.home();
    }
}
