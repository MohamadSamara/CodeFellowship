package com.example.CodeFellowship.controller;

import com.example.CodeFellowship.models.ApplicationUser;
import com.example.CodeFellowship.models.Post;
import com.example.CodeFellowship.repositories.ApplicationUserRepo;
import com.example.CodeFellowship.repositories.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    ApplicationUserRepo applicationUserRepo;
    @Autowired
    PostRepo postRepo;
    @GetMapping("/users/{id}")
    public String getUser(@PathVariable Long id , Principal p, Model m){

        if(p != null){
            String username = p.getName();
            ApplicationUser user= applicationUserRepo.findByUsername(username);
            m.addAttribute("user", user);

            ApplicationUser applicationUser = applicationUserRepo.findById(id)
                            .orElseThrow( () -> new ResourceNotFoundException("user not found with id " + id) );
            m.addAttribute("applicationUser" , applicationUser);
            m.addAttribute("post", applicationUser.getPostList());

        }
        return "users";
    }

    @GetMapping("/users")
    public String getAllUser(Principal p, Model m){

        if(p != null){
            List <ApplicationUser> applicationUser = applicationUserRepo.findAll();
            m.addAttribute("applicationUser", applicationUser);
            m.addAttribute("p", p); // Add the p variable to the model
        }
        return "allUsers";
    }

    @PostMapping("/addPost")
    public RedirectView addPost(Principal p , String body , Long userId , RedirectAttributes redir) {

        if(p != null){
            ApplicationUser user = applicationUserRepo.findById(userId).orElseThrow();
            Post post = new Post(body ,  user);
            post.setCreatedAt(LocalDate.now());
            postRepo.save(post);
            return new RedirectView("/myProfile");
        }else{
            redir.addFlashAttribute("errorMessage", "Something Error Happened !");
            return new RedirectView("/");
        }

    }


    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException
    {
        ResourceNotFoundException(String message)
        {
            super(message);
        }
    }

}
