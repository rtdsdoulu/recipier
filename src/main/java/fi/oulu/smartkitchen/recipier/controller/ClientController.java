package fi.oulu.smartkitchen.recipier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Sam on 12/12/2016.
 */
@Controller
public class ClientController {

    @RequestMapping("/client")
    public String clientWeb(Model model){
        return "clientpage.html";
    }

//    @RequestMapping("/analyzer")
//    public String analyzeWeb(Model model){
//        return "analyze.html";
//    }
}
