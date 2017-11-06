package com.treehouse.giflib.controller;

import com.treehouse.giflib.data.GifRepository;
import com.treehouse.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FavoritesController {

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/favorites")
    public String listFavorites(ModelMap modelMap) {

        List<Gif> gifList = gifRepository.getAllGifs();
        List<Gif> favoriteGifs = new ArrayList<>();

        for (Gif gif : gifList) {
            if (gif.isFavorite()) {
                favoriteGifs.add(gif);
            }
        }
        modelMap.put("favorites", favoriteGifs);

        return "favorites";
    }
}
