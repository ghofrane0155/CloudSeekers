package tn.esprit.pidev.services.forum;

import tn.esprit.pidev.dto.PostRequest;
import tn.esprit.pidev.dto.PostResponse;

import java.util.List;

public interface IGestionPost {
    void create(PostRequest postRequest);
    List<PostResponse> getAllPosts();
    PostResponse getPostById(Long id);
    List<PostResponse> getPostsBySubforum(Long subforumId);
    void deletePost(Long postId);
    void updatePost(Long postId, PostRequest postRequest);
    //List<PostResponse> getPostsByUsername(String username);

    //void removePost(Long postId);

}
