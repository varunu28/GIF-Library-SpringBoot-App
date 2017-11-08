package com.treehouse.giflib.controller;

import com.treehouse.giflib.data.GifRepository;
import com.treehouse.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping(value="/", params="q")
    public String listSearch(@RequestParam ("q") String q, ModelMap modelMap) {
        List<Gif> gifs= gifRepository.findBySearch(q);
        modelMap.put("gifs", gifs);
        return "search";
    }
}
