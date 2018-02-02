package com.startcaft.springcloud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/police")
public class PoliceController {

    @RequestMapping(value="/get",method = RequestMethod.GET)
    public Police get(){
        Police police = new Police(1,"周星星","9527");
        return police;
    }
}
