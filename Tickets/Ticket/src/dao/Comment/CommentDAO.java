package dao.Comment;
import domain.Comment;
import java.util.ArrayList;
public interface CommentDAO {
    
    void createComment();
    Comment getCommentById();
    ArrayList<Comment> getAllComments();
    void delete(int id);
}
