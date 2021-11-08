package com.dabin.service;

import com.dabin.common.base.ServerResponse;
import com.dabin.dao.AlbumDOMapper;
import com.dabin.dao.PhotoDOMapper;
import com.dabin.pojo.dto.PhotoDTO;
import com.dabin.pojo.dto.SimpleAlbumDTO;
import com.dabin.pojo.dto.TagVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 相册管理相关service
 *
 * @author Jann Lee
 * @date 2018-11-29
 */
public class AlbumService {

    @Autowired
    AlbumDOMapper albumDOMapper;

    @Autowired
    PhotoDOMapper photoDOMapper;

    public ServerResponse<List<SimpleAlbumDTO>> listSimpleAlbums(int type, int limit) {

        return null;
    }

    public ServerResponse<List<PhotoDTO>> listAllPhotos(int albumId) {
        return null;
    }

    public ServerResponse<TagVO> countAlbumNumber() {
        return null;
    }
}
