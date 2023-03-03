package ssf.workshop15.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ssf.workshop15.service.TextService;
import ssf.workshop15.model.Corpus;


@Controller
@RequestMapping(path="/analyze")
public class TextController {

    @Autowired
    private TextService textSvc;

    @GetMapping()
    public String analyze(Model model, @RequestParam(defaultValue = "") String para){
        textSvc.analyze(para);
        List<Corpus> ll = textSvc.getListOfCurrentNextWord();
        model.addAttribute("wordCountList",ll);
        return "result";
    }
    
}
