package com.startcaft.springcloud;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: pikai
 * @Description:
 * @Date: Created in 2018/2/6 22:21
 */
@RestController
public class PoliceController {

    @RequestMapping(value="/get/{id}",method = RequestMethod.GET)
    public Police get(@PathVariable(value="id",required = true) Integer id,
                      HttpServletRequest request){
        Police police = new Police();
        police.setId(id);
        police.setName("police");
        police.setMessage(request.getRequestURL().toString());
        return police;
    }
}
