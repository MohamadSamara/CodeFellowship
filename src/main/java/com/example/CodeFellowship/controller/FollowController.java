package com.example.CodeFellowship.controller;

import com.example.CodeFellowship.models.ApplicationUser;
import com.example.CodeFellowship.models.Post;
import com.example.CodeFellowship.repositories.ApplicationUserRepo;
import com.example.CodeFellowship.repositories.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class FollowController {

    @Autowired
    ApplicationUserRepo applicationUserRepo;

    @Autowired
    PostRepo postRepo;
    @PostMapping("/follow/{id}")
    public RedirectView following(Principal p, @PathVariable Long id)
    {
        if (p == null)
        {
            throw new IllegalArgumentException("User must be logged in to follow other users!");
        }

        ApplicationUser myUser = applicationUserRepo.findByUsername(p.getName());
        ApplicationUser userToFollow = applicationUserRepo.findById(id).orElseThrow();
        myUser.getFollowers().add(userToFollow);
        applicationUserRepo.save(myUser);
        return new RedirectView("/users/" + id);
    }



    @GetMapping("/feed")
    public String getAllFeed(Principal p , Model m){
        if (p != null)
        {
            ApplicationUser myUser = applicationUserRepo.findByUsername(p.getName());
            Set<ApplicationUser> followed = myUser.getFollowers();
            List<Post> posts = postRepo.findAllByApplicationUserIn(followed);
            m.addAttribute("posts", posts);
        }
        return "feed";
    }


}
