package top.vertical.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.vertical.mapper.FavoritesMapper;
import top.vertical.pojo.Favorites;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FavoritesService {

    @Autowired
    private FavoritesMapper favoritesMapper;


    // 增加实习咨询收藏
    public void addFavorites(Long userId, Long internshipId) {
        Favorites favorite = new Favorites(null, userId, internshipId, LocalDateTime.now());
        favoritesMapper.addFavorites(favorite);
    }

// 删除实习咨询收藏
    public void deleteFavorites(Long userId, Long internshipId) {
        favoritesMapper.deleteFavorites(userId, internshipId);
    }

    //SHOW FAVOTIRES
    public List<Favorites> showFavorites(Long userId) {
        return favoritesMapper.findByUserId(userId);
    }


}

