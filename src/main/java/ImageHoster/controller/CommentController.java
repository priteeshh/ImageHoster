package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.repository.ImageRepository;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private ImageService imageService;

    //This method is called we want to submit the comment
    //This will take the comment from @RequestPram and call the addComment service to add the comment to the image to DB
    @RequestMapping(value = "/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
    public String submitComment(@PathVariable Integer imageId, @PathVariable String imageTitle, @RequestParam(name = "comment") String newComment, HttpSession session, Model model) {
        Image image = imageService.getImage(imageId);
        User user = (User) session.getAttribute("loggeduser");
        Comment addComment = new Comment();
        addComment.setImage(image);
        addComment.setText(newComment);
        addComment.setCreatedDate(new Date());
        addComment.setUser(user);
        commentService.addComment(addComment);
        return "redirect:/images/" + image.getId() +"/"+ image.getTitle();
    }
}
