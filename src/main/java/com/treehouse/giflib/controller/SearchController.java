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
    public String getSearch(@RequestParam ("q") String q, ModelMap modelMap) {
        List<Gif> gifs = gifRepository.getAllGifs();
        List<Gif> matchedGifs = new ArrayList<>();

        for (Gif gif : gifs) {
            if (gif.getName().toLowerCase().contains(q.toLowerCase())) {
                matchedGifs.add(gif);
            }
        }

        modelMap.put("search", matchedGifs);
        return "search";
    }
}
