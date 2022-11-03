package com.ssafy.feed.service;

import com.ssafy.feed.dto.board.BoardGroupListDto;
import com.ssafy.feed.dto.board.BoardSimpleListDto;
import com.ssafy.feed.dto.user.UserFollowThemeDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface FeedService {
    List<BoardGroupListDto> themeBoardGroup(int theme_idx,int pageIdx,int pageSize);

    List<BoardSimpleListDto> themeBoardList(int theme_idx, String name, int pageIdx, int pageSize,int userIdx);

    List<BoardSimpleListDto> feedByRegion(int userIdx, int region, int pageIdx, int pageSize);
    List<UserFollowThemeDto> getUserFollowTheme(int userIdx);
    int getThemeOpenType(int followUserIdx, int followThemeIdx);
}
