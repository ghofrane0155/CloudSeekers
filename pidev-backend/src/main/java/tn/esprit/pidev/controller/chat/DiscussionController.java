package tn.esprit.pidev.controller.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pidev.entities.chat.Discussion;
import tn.esprit.pidev.services.chat.IGestionDiscussion;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/discussion")
public class DiscussionController {
    @Autowired
    IGestionDiscussion iGestionDiscussion ;

    @PostMapping("/startDiscussionDuo")
    public Discussion cstartDiscussionDuo(@RequestParam Integer userStart,@RequestParam Integer userEnd) {
        return iGestionDiscussion.startDiscussionDuo(userStart,userEnd);
    }

    @PostMapping("/startDiscussionGroup")
    public Discussion cstartDiscussionGroup(@RequestParam Integer userStart,@RequestParam String title, @RequestBody List<Integer> userList) {
        return iGestionDiscussion.startDiscussionGroup(userStart,title,userList);
    }

    @PostMapping("/startDiscussionCommunity")
    public Discussion cstartDiscussionCommunity(@RequestParam Integer userStart,@RequestParam String title, @RequestBody List<Integer> userList,@RequestParam String discussionList) {
        return iGestionDiscussion.startDiscussionCommunity(userStart,title,userList,discussionList);
    }

    @PutMapping("/addUserToDiscussion")
    public Discussion caddUserToDiscussion(@RequestParam Long id, @RequestBody List<Integer> userList) {
        return iGestionDiscussion.addUserToDiscussion(id,userList);
    }

    @PutMapping("/addDiscussionToCommunity")
    public Discussion caddDiscussionToCommunity(@RequestParam Long id, @RequestParam String discussionList) {
        return iGestionDiscussion.addDiscussionToCommunity(id,discussionList);
    }

    @GetMapping("/retrieveAllDiscussions")
    public List<Discussion> cretrieveAllDiscussions(@RequestParam Integer id) {
        return iGestionDiscussion.retrieveAllDiscussions(id);
    }

    @GetMapping("/retrieveAllCommunities")
    public List<Discussion> cretrieveAllCommunities(@RequestParam Integer id) {
        return iGestionDiscussion.retrieveAllCommunities(id);
    }


    @PutMapping("/renameDiscussion")
    public Discussion crenameDiscussion(@RequestParam Long id,@RequestParam String title) {
        return iGestionDiscussion.renameDiscussion(id,title);
    }

    @PutMapping("/deleteDiscussion")
    public boolean cdeleteDiscussion(@RequestParam Long id) {
        return iGestionDiscussion.deleteDiscussion(id);
    }
}
