package tn.esprit.pidev.services.chat;

import tn.esprit.pidev.entities.chat.Discussion;

import java.util.List;

public interface IGestionDiscussion {
    public Discussion startDiscussionDuo(Integer userStart, Integer userEnd);

    public Discussion startDiscussionGroup(Integer userStart, String title, List<Integer> userList);

    public Discussion startDiscussionCommunity(Integer userStart, String title, List<Integer> userList, String discussionList);

    public Discussion addUserToDiscussion(Long id, List<Integer> userList);

    public Discussion addDiscussionToCommunity(Long id, String discussionList);

    public List<Discussion> retrieveAllDiscussions(Integer id);

    public List<Discussion> retrieveAllCommunities(Integer id);

    public Discussion renameDiscussion(Long id,String title);

    public boolean deleteDiscussion(Long id);
}
