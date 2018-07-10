package sms.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
class MessageController {

    @GetMapping
    String getCodeCouple(){
        return "CodeCouple.pl";
    }

}