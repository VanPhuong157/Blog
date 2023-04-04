/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;



/**
 *
 * @author ASUS
 */
public class Post {
    private int postID,userID,categoryID;
    private String content,status,image,hastag;
    private Date date;

    public String getHastag() {
        return hastag;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public void setHastag(String hastag) {
        this.hastag = hastag;
    }

    public Post(int postID, int userID, int categoryID, String content, String status, String image, String hastag, Date date) {
        this.postID = postID;
        this.userID = userID;
        this.categoryID = categoryID;
        this.content = content;
        this.status = status;
        this.image = image;
        this.hastag = hastag;
        this.date = date;
    }

    public Post() {
    }

   
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
