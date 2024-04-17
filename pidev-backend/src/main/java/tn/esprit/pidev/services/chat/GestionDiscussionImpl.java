package tn.esprit.pidev.services.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.pidev.entities.chat.Discussion;
import tn.esprit.pidev.entities.chat.TypeDiscussion;
import tn.esprit.pidev.entities.user.User;
import tn.esprit.pidev.repository.chat.IDiscussionRepository;
import tn.esprit.pidev.repository.user.IUserRepository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class GestionDiscussionImpl implements IGestionDiscussion {
    @Autowired
    IDiscussionRepository iDiscussionRepository;
    @Autowired
    IUserRepository iUserRepository;
    @Override
    public Discussion startDiscussionDuo(Integer userStart, Integer userEnd) {
        Discussion discussion = new Discussion();
        discussion.setTypeDiscussion(TypeDiscussion.Duo);
        User userEndo = iUserRepository.findById(userEnd).get() ;
        discussion.getUsers().add(iUserRepository.findById(userStart).get());
        discussion.getUsers().add(userEndo);
        discussion.setTitle(userEndo.getPrenom() + " " + userEndo.getNom());
        discussion.setDateStart(LocalDateTime.now());
        discussion.setArchived(false);
        return iDiscussionRepository.save(discussion) ;
    }

    @Override
    public Discussion startDiscussionGroup(Integer userStart, String title, List<Integer> userList) {
        Discussion discussion = new Discussion();
        discussion.setTypeDiscussion(TypeDiscussion.Group);
        discussion.setTitle(title);
        discussion.getUsers().add(iUserRepository.findById(userStart).get());
        for (Integer user : userList) {
            discussion.getUsers().add(iUserRepository.findById(user).get());
        }
        discussion.setDateStart(LocalDateTime.now());
        discussion.setArchived(false);
        return iDiscussionRepository.save(discussion) ;
    }

    @Override
    public Discussion startDiscussionCommunity(Integer userStart, String title, List<Integer> userList, String discussionList) {
        Discussion discussion = new Discussion();
        discussion.setTypeDiscussion(TypeDiscussion.Community);
        discussion.setTitle(title);
        discussion.getUsers().add(iUserRepository.findById(userStart).get());
        for (Integer user : userList) {
            discussion.getUsers().add(iUserRepository.findById(user).get());
        }

        String[] splitArray = discussionList.split("_");
        List<String> discussionListo = Arrays.asList(splitArray);

        for (String discussionx : discussionListo) {
            Discussion discussiono = new Discussion();
            discussiono.setTypeDiscussion(TypeDiscussion.CommunitySlave);
            discussiono.setTitle(discussionx);
            discussiono.setDateStart(LocalDateTime.now());
            discussiono.setArchived(false);
            discussion.getCommunity().add(discussiono);
           iDiscussionRepository.save(discussiono) ;
        }
        discussion.setDateStart(LocalDateTime.now());
        discussion.setArchived(false);
        return iDiscussionRepository.save(discussion) ;
    }

    @Override
    public Discussion addUserToDiscussion(Long id, List<Integer> userList) {
        Discussion discussion = iDiscussionRepository.findById(id).get();
        for (Integer user : userList) {
            discussion.getUsers().add(iUserRepository.findById(user).get());
        }
        return iDiscussionRepository.save(discussion) ;
    }

    @Override
    public Discussion addDiscussionToCommunity(Long id, String discussionList) {
        Discussion discussion = iDiscussionRepository.findById(id).get();
        String[] splitArray = discussionList.split("|");
        List<String> discussionListo = Arrays.asList(splitArray);

        for (String discussionx : discussionListo) {
            Discussion discussiono = new Discussion();
            discussiono.setTypeDiscussion(TypeDiscussion.CommunitySlave);
            discussion.setTitle(discussionx);
            discussion.setDateStart(LocalDateTime.now());
            discussion.setArchived(false);
            discussion.getCommunity().add(discussiono);
            iDiscussionRepository.save(discussiono) ;
        }
        return iDiscussionRepository.save(discussion) ;
    }

    public List<Discussion> retrieveAllDiscussions(Integer id){
        User user = iUserRepository.findById(id).get();
        return iDiscussionRepository.findByUsersContainingAndArchivedIsFalseAndTypeDiscussionIsNot(user,TypeDiscussion.Community);
    }

    public List<Discussion> retrieveAllCommunities(Integer id){
        User user = iUserRepository.findById(id).get();
        return iDiscussionRepository.findByUsersContainingAndArchivedIsFalseAndTypeDiscussionIs(user,TypeDiscussion.Community);

    }

    @Override
    public Discussion renameDiscussion(Long id, String title) {
        Discussion discussion = iDiscussionRepository.findById(id).get();
        discussion.setTitle(title);
        return iDiscussionRepository.save(discussion) ;
    }

    @Override
    public boolean deleteDiscussion(Long id) {
        Discussion discussion = iDiscussionRepository.findById(id).get() ;
        discussion.setArchived(true);
        try {
            iDiscussionRepository.save(discussion);
            return true ;
        } catch(Exception e) {
            return false ;
        }
    }
}
