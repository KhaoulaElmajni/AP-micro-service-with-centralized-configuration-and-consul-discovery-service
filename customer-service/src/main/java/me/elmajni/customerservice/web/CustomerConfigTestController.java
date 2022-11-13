package me.elmajni.customerservice.web;

import me.elmajni.customerservice.CustomerServiceApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RefreshScope
public class CustomerConfigTestController {
    private static final Logger LOG = Logger.getLogger(CustomerServiceApplication.class.getName());

    @Value("${global.params.p1}")
    private String p1;
    @Value("${global.params.p2}")
    private String p2;
    @Value("${customer.params.x}")
    private String x;
    @Value("${customer.params.y}")
    private String y;

    @GetMapping(path = "/params")
    public Map<String,String> params(){
        LOG.log(Level.INFO, "Index API is calling");
        return Map
                .of("P1",p1,"P2",p2,"X",x,"Y",y);
    }

}
