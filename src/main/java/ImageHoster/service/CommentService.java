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

    public void addComment(Comment newComment){
        imageRepository.addComment(newComment);
    }

    public List<Comment> getAllComments(Integer imageId){
        return imageRepository.getAllComments(imageId);
    }
}
