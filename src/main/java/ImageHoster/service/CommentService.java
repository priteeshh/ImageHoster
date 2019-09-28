package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private ImageRepository imageRepository;

    //This method is called to add the comment to the particular image
    public void addComment(Comment newComment){
        imageRepository.addComment(newComment);
    }

    //This method is used to get all the comment of the particular image
    public List<Comment> getAllComments(Integer imageId){
        return imageRepository.getAllComments(imageId);
    }
}
