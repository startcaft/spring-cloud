package com.startcaft.springcloud;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author pikai
 */
@RestController
public class PersonController {

    @RequestMapping(value="/person",method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Person get(HttpServletRequest request){
        Person person = new Person();
        person.setId(1);
        person.setName("person");
        person.setMessage(request.getRequestURL().toString());
        return person;
    }
}
