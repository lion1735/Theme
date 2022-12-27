package com.ssafy.feed.service.impl;

import com.ssafy.feed.client.ThemeClient;
import com.ssafy.feed.client.UserClient;
import com.ssafy.feed.dto.board.BoardDto;
import com.ssafy.feed.dto.board.BoardGroupListDto;
import com.ssafy.feed.dto.board.BoardGroupShowListDto;
import com.ssafy.feed.dto.board.BoardSimpleListDto;
import com.ssafy.feed.dto.comment.CommentListDto;
import com.ssafy.feed.dto.theme.UserThemeDtoWithMSA;
import com.ssafy.feed.dto.user.UserFollowThemeDto;
import com.ssafy.feed.dto.user.UserInfoByIdDto;
import com.ssafy.feed.entity.Board;
import com.ssafy.feed.entity.Comment;
import com.ssafy.feed.entity.Likes;
import com.ssafy.feed.entity.Picture;
import com.ssafy.feed.repository.BoardRepository;
import com.ssafy.feed.repository.CommentRepository;
import com.ssafy.feed.repository.LikeRepository;
import com.ssafy.feed.repository.PictureRepository;
import com.ssafy.feed.service.FeedService;
import io.swagger.models.auth.In;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FeedServiceImpl implements FeedService {
    ThemeClient themeClient;
    BoardRepository boardRepository;
    CommentRepository commentRepository;
    LikeRepository likeRepository;
    UserClient userClient;
    PictureRepository pictureRepository;
    @Autowired
    FeedServiceImpl(LikeRepository likeRepository,ThemeClient themeClient,PictureRepository pictureRepository,BoardRepository boardRepository,CommentRepository commentRepository,UserClient userClient){
        this.themeClient =themeClient;
        this.likeRepository = likeRepository;
        this.boardRepository=boardRepository;
        this.commentRepository = commentRepository;
        this.userClient = userClient;
        this.pictureRepository = pictureRepository;
    }
    @Override
    public List<BoardGroupShowListDto> themeBoardGroup(int user_idx, int theme_idx, int pageIdx, int pageSize) {
        List<UserThemeDtoWithMSA> themeUserList = themeClient.getThemeUserList(theme_idx,user_idx); //테마 번호로 openType이 0,1인 userTheme만 받아오기
        List<Integer> openUserList = new ArrayList<>();
        List<BoardGroupShowListDto> result = new ArrayList<>();
        Pageable pageable = PageRequest.of(pageIdx, pageSize);
        for(UserThemeDtoWithMSA theme : themeUserList){ //해당 번호 배열로 저장
            openUserList.add(theme.getUserIdx());
            List<BoardGroupListDto> boardGroupListDtos = boardRepository.getBoardGourpByListWithJPA(openUserList,theme.getUserThemeIdx(),pageable); //게시글 목록 리턴
            for(int i=0;i<boardGroupListDtos.size();i++){

                BoardGroupShowListDto boardGroupShowListDto = BoardGroupShowListDto.builder()
                        .boardCount(boardGroupListDtos.get(i).getBoardCount())
                        .isBookMarked(isScrap(user_idx,theme_idx))
                        .isFollow(false)
                        .isMy(false)
                        .latitude(boardGroupListDtos.get(i).getLatitude())
                        .longitude(boardGroupListDtos.get(i).getLongitude())
                        .themeIdx(boardGroupListDtos.get(i).getThemeIdx())
                        .city(boardGroupListDtos.get(i).getCity())
                        .name(boardGroupListDtos.get(i).getName())
                        .place(boardGroupListDtos.get(i).getPlace())
                        .userIdx(boardGroupListDtos.get(i).getUserIdx())
                        .boardIdx(boardGroupListDtos.get(i).getIdx())
                        .build();
                result.add(boardGroupShowListDto);
            }
        }
        return  result;
    }

    @Override
    public List<BoardSimpleListDto> themeBoardList(int theme_idx, String name, int pageIdx, int pageSize,int userIdx) {
        List<UserThemeDtoWithMSA> themeUserList = themeClient.getThemeUserList(theme_idx,userIdx);
        List<Integer> openUserList = new ArrayList<>();
        List<BoardSimpleListDto> boardSimpleListDtoList = new ArrayList<>();
        Pageable pageable = PageRequest.of(pageIdx, pageSize);
        for(UserThemeDtoWithMSA theme : themeUserList){
            openUserList.add(theme.getUserIdx());

            List<Board> boardGroupListDto = boardRepository.getBoardListWithJPA(openUserList,theme.getUserThemeIdx(),name,pageable);

            for(Board board : boardGroupListDto){
                Integer commentCount = commentRepository.findByBoard(board).size();
                List<Likes> likeCount = likeRepository.findByBoard(board);
                UserInfoByIdDto userInfo = userClient.getUserInfo(board.getUserIdx());
                List<Picture> pictureList = pictureRepository.findByBoard(board);
                String themeName = themeClient.getThemeName(theme_idx);
                boolean isWriter = false;
                String []  pictures= new String[pictureList.size()];
                for(int i=0;i<pictureList.size();i++){
                    pictures[i] = (pictureList.get(i).getPicture());
                }
                if(board.getUserIdx() == userIdx) isWriter = true;
                BoardSimpleListDto boardSimpleListDto = BoardSimpleListDto.builder()
                        .boardIdx(board.getIdx())
                        .alertCount(board.getAlertCount())
                        .city(board.getCity())
                        .commentCount(commentCount)
                        .isWriter(isWriter)
                        .likeCount(0)
                        .modifyTime(board.getModifyTime())
                        .name(board.getName())
                        .nickname(userInfo.getNickname())
                        .picture(pictures)
                        .themeIdx(board.getThemeIdx())
                        .themeName(themeName)
                        .profile(userInfo.getPicture())
                        .userIdx(userInfo.getUserIdx())
                        .boardIdx(board.getIdx())
                        .build();
                boardSimpleListDtoList.add(boardSimpleListDto);
            }
        }

        return boardSimpleListDtoList;
    }

    @Override
    public List<BoardSimpleListDto> feedByRegion(int userIdx, int region, int pageIdx, int pageSize) {
        Pageable pageable = PageRequest.of(pageIdx, pageSize); // 페이지네이션
        String[] regionList = {"전국","서울","대전","광주","구미","부울경"};
        List<BoardSimpleListDto> boardSimpleListDtoList = new ArrayList<>();
        List<UserFollowThemeDto> userFollowThemeDtoList = userClient.getUserFollowTheme(userIdx);
        for(int i=0;i<userFollowThemeDtoList.size();i++){ // 해당 유저가 팔로우한 사람의 테마리스트들 확인
            int followUserIdx = userFollowThemeDtoList.get(i).getFollowUserIdx();
            int followThemeIdx = userFollowThemeDtoList.get(i).getFollowThemeIdx();
            int openType = getThemeOpenType(followUserIdx,followThemeIdx); // 0 전체 공개, 1 친구 공개, 2 비공개
            if(openType!=2){
                // 해당 사람이 해당 테마로 작성한 글들 불러오기
                List<Board> boardList;
                if(region == 0) boardList = boardRepository.findByUserIdxAndThemeIdx(followUserIdx,followThemeIdx,pageable);
                else boardList = boardRepository.findByUserIdxAndThemeIdxAndCity(followUserIdx,followThemeIdx,regionList[region],pageable);// 지역별로 나눠서 확인해야함 - 받은 지역 확인하기
                for(int j=0;j<boardList.size();j++) {
                    UserInfoByIdDto userInfo = userClient.getUserInfo(boardList.get(j).getUserIdx()); // 해당 게시글을 작성한 유저의 정보 받기
                    Optional<Board> board = boardRepository.findById(boardList.get(j).getIdx()); // 해당 게시글
                    List<Likes> likeList = likeRepository.findByBoard(board.get()); // 해당 게시글의 좋아요 갯수
                    List<Likes> likeMy = likeRepository.findByUserIdxAndBoard(userIdx,board.get()); // 해당 게시글에 본인이 좋아했는지 조회
                    boolean likeMyBoolean = false;
                    if(likeMy != null) likeMyBoolean = true;
                    List<Comment> commentList = commentRepository.findByBoard(board.get()); // 해당 게시글의 댓글
                    boolean isWriter = true;
                    List<CommentListDto> commentListDtoList = new ArrayList<>();
                    for(int k=0;k<commentList.size();k++) {
                        UserInfoByIdDto userInfoByIdDto = userClient.getUserInfo(commentList.get(k).getUserIdx());
                        if(commentList.get(k).getUserIdx()!=userIdx) isWriter = false;
                        else isWriter = true;
                        Comment targetComment = commentList.get(k);
                        CommentListDto commentListDto = CommentListDto.builder()
                                .commentIdx(targetComment.getIdx())
                                .alertCount(targetComment.getAlertCount())
                                .content(targetComment.getContent())
                                .userIdx(targetComment.getUserIdx())
                                .isWriter(isWriter)
                                .profile(userInfoByIdDto.getPicture())
                                .boardIdx(board.get().getIdx())
                                .nickname(userInfoByIdDto.getNickname())
                                .build();
                        commentListDtoList.add(commentListDto);
                    }
                    List<Picture> pictureList = pictureRepository.findByBoard(board.get()); // 해당 게시글의 사진
                    String[] pictures = new String[pictureList.size()];
                    for(int k=0;k<pictureList.size();k++){
                        pictures[k] = (pictureList.get(k).getPicture());
                    }
                    isWriter = true;
                    if(boardList.get(j).getUserIdx()!=userIdx) isWriter = false;

                    BoardSimpleListDto boardSimpleListDto = BoardSimpleListDto.builder()
                            .boardIdx(boardList.get(j).getIdx())
                            .alertCount(boardList.get(j).getAlertCount())
                            .city(boardList.get(j).getCity())
                            .commentCount(commentList.size())
                            .isWriter(isWriter)
                            .likeCount(likeList.size())
                            .modifyTime(boardList.get(j).getModifyTime())
                            .name(boardList.get(j).getName())
                            .nickname(userInfo.getNickname())
                            .picture(pictures)
                            .description(boardList.get(j).getDescription())
                            .themeIdx(boardList.get(j).getThemeIdx())
                            .themeName(themeClient.getUserThemeName(boardList.get(j).getThemeIdx()))
                            .profile(userInfo.getPicture())
                            .userIdx(boardList.get(j).getUserIdx())
                            .likeMy(likeMyBoolean)
                            .commentListDtoList(commentListDtoList)
                            .build();
                    boardSimpleListDtoList.add(boardSimpleListDto);
                }
            }
        }
        return boardSimpleListDtoList;
    }
    @Override
    public List<UserFollowThemeDto> getUserFollowTheme(int userIdx){ // 해당 유저가 팔로우하고 있는 사람,테마의 idx받아오기
        List<UserFollowThemeDto> userFollowThemeDtoList = userClient.getUserFollowTheme(userIdx);
        return userFollowThemeDtoList;
    }

    @Override
    public int getThemeOpenType(int followingUserIdx, int followThemeIdx) { // 해당 테마의 공개 여부 확인하기
        return themeClient.getThemeOpenType(followingUserIdx,followThemeIdx);
    }
    @Override
    public String getThemeName(int themeIdx) { // 테마 idx로 이름 받아오기
        String themeInfo = themeClient.getThemeName(themeIdx);
        return themeInfo;
    }
    @Override
    public String getUserThemeName(int themeIdx) {
        String themeInfo = themeClient.getUserThemeName(themeIdx);
        return themeInfo;
    }

    @Override
    public BoardSimpleListDto detailBoard(int userIdx, int board_idx) {
        Optional<Board> board = boardRepository.findById(board_idx);
        if(board.isPresent()){
            UserInfoByIdDto userInfo = userClient.getUserInfo(board.get().getUserIdx()); // 해당 게시글을 작성한 유저의 정보 받기
            List<Likes> likeList = likeRepository.findByBoard(board.get()); // 해당 게시글의 좋아요 갯수
            List<Likes> likeMy = likeRepository.findByUserIdxAndBoard(userIdx,board.get()); // 해당 게시글에 본인이 좋아했는지 조회
            boolean likeMyBoolean = false;
            if(likeMy != null) likeMyBoolean = true;
            List<Comment> commentList = commentRepository.findByBoard(board.get()); // 해당 게시글의 댓글
            boolean isWriter = true;
            List<CommentListDto> commentListDtoList = new ArrayList<>();
            for(int k=0;k<commentList.size();k++) {
                UserInfoByIdDto userInfoByIdDto = userClient.getUserInfo(commentList.get(k).getUserIdx());
                if(commentList.get(k).getUserIdx()!=userIdx) isWriter = false;
                else isWriter = true;
                Comment targetComment = commentList.get(k);

                CommentListDto commentListDto = CommentListDto.builder()
                        .commentIdx(targetComment.getIdx())
                        .alertCount(targetComment.getAlertCount())
                        .content(targetComment.getContent())
                        .userIdx(targetComment.getUserIdx())
                        .isWriter(isWriter)
                        .profile(userInfoByIdDto.getPicture())
                        .boardIdx(board.get().getIdx())
                        .nickname(userInfoByIdDto.getNickname())
                        .build();
                commentListDtoList.add(commentListDto);
            }
            List<Picture> pictureList = pictureRepository.findByBoard(board.get()); // 해당 게시글의 사진
            String[] pictures = new String[pictureList.size()];
            for(int k=0;k<pictureList.size();k++){
                pictures[k] = (pictureList.get(k).getPicture());
            }
            isWriter = true;
            if(board.get().getUserIdx()!=userIdx) isWriter = false;
            BoardSimpleListDto boardSimpleListDto = BoardSimpleListDto.builder()
                    .boardIdx(board.get().getIdx())
                    .alertCount(board.get().getAlertCount())
                    .city(board.get().getCity())
                    .commentCount(commentList.size())
                    .isWriter(isWriter)
                    .likeCount(likeList.size())
                    .modifyTime(board.get().getModifyTime())
                    .name(board.get().getName())
                    .nickname(userInfo.getNickname())
                    .picture(pictures)
                    .themeIdx(board.get().getThemeIdx())
                    .description(board.get().getDescription())
                    .themeName(themeClient.getUserThemeName(board.get().getThemeIdx()))
                    .profile(userInfo.getPicture())
                    .userIdx(board.get().getUserIdx())
                    .likeMy(likeMyBoolean)
                    .commentListDtoList(commentListDtoList)
                    .build();
            return boardSimpleListDto;
        }
        return null;
    }

    public List<BoardDto> getUserBoardList(int user_idx) {
        List<Board> userBoardList = boardRepository.findByUserIdx(user_idx);

        List<BoardDto> boardDtos = new ArrayList<>();
        for(int i=0;i<userBoardList.size();i++) {
            Board board = userBoardList.get(i);

            BoardDto boardDto = BoardDto.builder()
                    .createTime(board.getCreateTime())
                    .description(board.getDescription())
                    .idx(board.getIdx())
                    .city(board.getCity())
                    .alertCount(board.getAlertCount())
                    .name(board.getName())
                    .place(board.getPlace())
                    .userIdx(board.getUserIdx())
                    .themeIdx(board.getThemeIdx())
                    .modifyTime(board.getModifyTime())
                    .build();

            boardDtos.add(boardDto);
        }

        return boardDtos;
    }

    @Override
    public List<BoardGroupShowListDto> userThemeList(int userThemeIdx,int pageIdx,int pageSize,int user_idx) {
        int userIdx = whoUserIdx(userThemeIdx);
        List<BoardGroupShowListDto> result = new ArrayList<>();
        List<UserThemeDtoWithMSA> themeUserList = themeClient.getUserThemeUserList(userThemeIdx,user_idx); //테마 번호로 openType이 1인 userTheme만 받아오기
        List<Integer> openUserList = new ArrayList<>();
        Pageable pageable = PageRequest.of(pageIdx, pageSize);
        for(UserThemeDtoWithMSA theme : themeUserList){ //해당 번호 배열로 저장
            openUserList.add(theme.getUserIdx());
            boolean isFollow = false;
            boolean isMy = false;
            if(theme.getUserIdx()==user_idx) isMy = true;
            else{
                List<UserFollowThemeDto> userFollowThemeDtoList = userClient.getUserFollowTheme(user_idx);
                for(int i=0;i<userFollowThemeDtoList.size();i++){
                    if(userFollowThemeDtoList.get(i).getFollowThemeIdx()==theme.getUserThemeIdx()){
                        isFollow = true;
                        break;
                    }
                }
            }
            List<BoardGroupListDto> boardGroupListDtos = boardRepository.getBoardGourpByListWithJPA(openUserList,theme.getUserThemeIdx(),pageable); //게시글 목록 리턴
            for(int i=0;i<boardGroupListDtos.size();i++){
                BoardGroupShowListDto boardGroupShowListDto = BoardGroupShowListDto.builder()
                        .boardCount(boardGroupListDtos.get(i).getBoardCount())
                        .isBookMarked(false)
                        .isFollow(isFollow)
                        .isMy(isMy)
                        .latitude(boardGroupListDtos.get(i).getLatitude())
                        .longitude(boardGroupListDtos.get(i).getLongitude())
                        .themeIdx(boardGroupListDtos.get(i).getThemeIdx())
                        .city(boardGroupListDtos.get(i).getCity())
                        .name(boardGroupListDtos.get(i).getName())
                        .place(boardGroupListDtos.get(i).getPlace())
                        .userIdx(boardGroupListDtos.get(i).getUserIdx())
                        .boardIdx(boardGroupListDtos.get(i).getIdx())
                        .build();
                result.add(boardGroupShowListDto);
            }
        }
        return  result;
    }
    @Override
    public int whoUserIdx(int userThemeIdx) {
        return themeClient.whoUserIdx(userThemeIdx);
    }
    @Override
    public boolean isScrap(int userIdx, int themeIdx) {
        return themeClient.isScrap(userIdx,themeIdx);
    }
    @Override
    public List<UserThemeDtoWithMSA> getUserThemeUserList(int theme_idx,int user_idx) {
        return themeClient.getUserThemeUserList(theme_idx,user_idx);
    }
}
