package me.elmajni.customerservice.web;

import org.springframework.beans.factory.annotation.Value;

public class CustomerConfigTestController {

    @Value("${}")
    String p1;
    @Value("${}")
    String p2;
    @Value("${}")
    String x;
    @Value("${}")
    String y;

}
