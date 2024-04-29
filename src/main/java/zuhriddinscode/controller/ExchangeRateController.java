package zuhriddinscode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zuhriddinscode.service.ExchangeratesImpl;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ExchangeRateController {

    @Autowired
    private   ExchangeratesImpl exchangerates ;

    @GetMapping("/getrates")
    List<Map<String, Object>>  getAllrates(){
        return exchangerates.getRates();
    };


}