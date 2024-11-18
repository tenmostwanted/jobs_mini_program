package top.vertical.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.vertical.common.R;
import top.vertical.pojo.Favorites;
import top.vertical.service.FavoritesService;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoritesController {

    @Autowired
    private FavoritesService favoritesService;

    @RequestMapping("/add")
    public R<Favorites> addFavorites(@RequestParam Long userId, @RequestParam Long internshipId) {
        favoritesService.addFavorites(userId, internshipId);
        return R.success();
    }

    @GetMapping("/list")
    public R<List<Favorites>>listFavorites(@RequestParam Long userId) {
        return R.success(favoritesService.showFavorites(userId));
    }


    @DeleteMapping("/delete")
    public R<Favorites> deleteFavorites(@RequestParam Long userId, @RequestParam Long internshipId) {
        favoritesService.deleteFavorites(userId, internshipId);
        return R.success();

    }



}
