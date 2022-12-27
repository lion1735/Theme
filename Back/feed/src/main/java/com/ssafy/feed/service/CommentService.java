package com.ssafy.feed.service;

public interface CommentService {
    boolean registComment(int boardIdx, int userIdx, String content);

    boolean deleteComment(int userIdx, int commentIdx);

    boolean alertComment(int userIdx, int commentIdx, String content);

    String alertUser(int userIdx);
}
