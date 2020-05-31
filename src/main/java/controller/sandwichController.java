package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class sandwichController {

    @RequestMapping("/order")
    public String orderPage() {
        return "order";
    }

    @RequestMapping("/save")
    public String save(@RequestParam(name="condiment",required = false) String[] condiment, Model model) {
        String result = "";
        try {
            for (int i = 0; i < condiment.length; i++) {
                if (!condiment[i].equals("") && condiment[i] != null) {
                    result += condiment[i] + " ";
                }
            }
        }catch (NullPointerException e){
        }finally {
        if (result.equals(""))
            model.addAttribute("condiment", "No condiments");
        else
            model.addAttribute("condiment", result);
        }
        return "/result";
    }
}
