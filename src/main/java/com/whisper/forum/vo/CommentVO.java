package com.whisper.forum.vo;

import java.util.List;

public class CommentVO {
    private Long commentId;

    private Long userId;

    private String userName;

    private String headPortrait;

    private String creatTime;

    private String commentMsg;

    private List<ReplyVO> replyVO;
}
