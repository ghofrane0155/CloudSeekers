package tn.esprit.pidev.services.forum;

import tn.esprit.pidev.dto.CommentsDto;

import java.util.List;

public interface IGestionComment {
    List<CommentsDto> getAllCommentsForPost(Long postId);
    void create(CommentsDto commentsDto);
    void deleteComment(Long commentId);
}
