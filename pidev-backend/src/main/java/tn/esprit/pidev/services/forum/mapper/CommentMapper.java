package tn.esprit.pidev.services.forum.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import tn.esprit.pidev.entities.forum.Comment;
import tn.esprit.pidev.entities.forum.Post;
import tn.esprit.pidev.dto.CommentsDto;
import tn.esprit.pidev.entities.user.User;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "text", source = "commentsDto.text")
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "post", source = "post")
    @Mapping(target = "user", source = "user")
    Comment map(CommentsDto commentsDto, Post post, User user);

    @Mapping(target = "postId", expression = "java(comment.getPost().getPostId())")
    @Mapping(target = "email", expression = "java(comment.getUser().getEmail())")
    CommentsDto mapToDto(Comment comment);
}