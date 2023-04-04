
package model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Comment {
    private int userID, postID,commentID;
    private String comment;
    private Date date;

    public Comment() {
    }

    public Comment(int userID, int postID, int commentID, String comment, Date date) {
        this.userID = userID;
        this.postID = postID;
        this.commentID = commentID;
        this.comment = comment;
        this.date = date;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    

    
    
}
