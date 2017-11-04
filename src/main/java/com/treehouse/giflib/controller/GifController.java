package com.treehouse.giflib.controller;

import com.treehouse.giflib.data.GifRepository;
import com.treehouse.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class GifController {

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/")
    public String listGifs() {
        return "home";
    }

    @RequestMapping("/gif")
    public String gifDetails(ModelMap modelMap) {
        Gif gif = gifRepository.findByName("android-explosion");
        modelMap.put("gif", gif);
        return "gif-details";
    }
}
