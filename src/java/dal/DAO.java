/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Category;
import model.Comment;
import model.Post;

/**
 *
 * @author ASUS
 */
public class DAO extends DBContext {

    private ArrayList<Account> userList;
    private ArrayList<Post> postList;
    private ArrayList<Comment> cmtList;

    public DAO(ArrayList<Account> userList, ArrayList<Post> postList, ArrayList<Comment> cmtList) {
        this.userList = userList;
        this.postList = postList;
        this.cmtList = cmtList;
    }

    public ArrayList<Account> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<Account> userList) {
        this.userList = userList;
    }

    public ArrayList<Post> getPostList() {
        return postList;
    }

    public void setPostList(ArrayList<Post> postList) {
        this.postList = postList;
    }

    public ArrayList<Comment> getCmtList() {
        return cmtList;
    }

    public void setCmtList(ArrayList<Comment> cmtList) {
        this.cmtList = cmtList;
    }

    public DAO() {
    }

    public List<Account> loadListAccount() {
        userList = new ArrayList<>();
        String sql = "select * from Account";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account u = new Account();
                u.setUserID(rs.getInt("userID"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setName(rs.getString("name"));
                u.setRoleID(rs.getInt("roleID"));
                userList.add(u);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return userList;
    }

    public Account getAccount(int id) {
        String sql = "select * from Account where userid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account u = new Account();
                u.setUserID(rs.getInt("userID"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setName(rs.getString("name"));
                u.setRoleID(rs.getInt("roleID"));
                return u;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void signup(String fname, String username, String pass, int role) {
        String sql = "insert into Account values (?,?,2,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, pass);
            st.setString(3, fname);
            st.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // reset password
    public void updatePass(String pass, String username) {
        String sql = "update account set password = ? where username like ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setString(2, username);
            ps.execute();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public List<Post> loadListPost() {
        postList = new ArrayList<Post>();
        String sql = "select * from post";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post p = new Post();
                p.setPostID(rs.getInt("postID"));
                p.setUserID(rs.getInt("userID"));
                p.setHastag(rs.getString("hastag"));
                p.setContent(rs.getString("content"));
                p.setDate(rs.getDate("date"));
                p.setStatus(rs.getString("status"));
                p.setImage(rs.getString("image"));
                p.setCategoryID(rs.getInt("categoryID"));
                postList.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error load post");
        }
        return postList;
    }

    public void insertPost(Post p) {
        String sql = "insert into post(userID,hastag,status,content,image,date,categoryID) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, p.getUserID());
            st.setString(2, p.getHastag());
            st.setString(3, p.getStatus());
            st.setString(4, p.getContent());
            st.setString(5, p.getImage());
            st.setDate(6, p.getDate());
            st.setInt(7, p.getCategoryID());
            st.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deletePost(int deleteId) {
        String sql = "Delete from post where postID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, deleteId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error at delete post" + e.getMessage());
        }

    }

    public void updatePost(Post p) {
        String sql = "update post set status=?,content=?,image=?,date=?,hastag=?,categoryID=? where postId = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, p.getStatus());
            ps.setString(2, p.getContent());
            ps.setString(3, p.getImage());
            ps.setDate(4, p.getDate());
            ps.setString(5, p.getHastag());
            ps.setInt(6, p.getCategoryID());
            ps.setInt(7, p.getPostID());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void insertComment(Comment c) {
        String sql = "insert into comment values (?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, c.getUserID());
            st.setInt(2, c.getPostID());
            st.setString(3, c.getComment());
            st.setDate(4, c.getDate());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void loadComment(int id) {
        cmtList = new ArrayList<Comment>();
        String sql = "select * from comment where postID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int userId = Integer.parseInt(rs.getString(1));
                int postId = Integer.parseInt(rs.getString(2));
                String comment = rs.getString(3);
                Date date = rs.getDate(4);
                int commentID = Integer.parseInt(rs.getString(5));
                cmtList.add(new Comment(userId, postId, commentID, comment, date));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteComment(int deleteId) {
        String sql = "Delete from comment where commentID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, deleteId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error at delete post" + e.getMessage());
        }
    }

    public List<Post> getPostMaxCountCmt(Date from, Date to) {
        postList = new ArrayList<>();
        String sql = "select * from post where date  between ? and ? and postID in (\n"
                + "select postID  from  Comment group by postID having count(comment) = (\n"
                + "select max(s) from (select COUNT(comment) as's' from  Comment a join Post b on a.postID = b.postID where b.date  between ? and ? group by a.postID  ) as T))";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1, from);
            ps.setDate(2, to);
            ps.setDate(3, from);
            ps.setDate(4, to);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post p = new Post();
                p.setPostID(rs.getInt("postID"));
                p.setUserID(rs.getInt("userID"));
                p.setCategoryID(rs.getInt("categoryID"));
                p.setHastag(rs.getString("hastag"));
                p.setContent(rs.getString("content"));
                p.setDate(rs.getDate("date"));
                p.setStatus(rs.getString("status"));
                p.setImage(rs.getString("image"));
                postList.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return postList;
    }

    public int countPost(Date from, Date to) {
        String sql = "select count(*) from post where date  between ? and ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1, from);
            ps.setDate(2, to);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public List<Post> getPostByDate(Date date) {
        List<Post> list = new ArrayList<Post>();
        String sql = "select * from post where date  = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1, date);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post p = new Post();
                p.setPostID(rs.getInt("postID"));
                p.setUserID(rs.getInt("userID"));
                p.setCategoryID(rs.getInt("categoryID"));
                p.setHastag(rs.getString("hastag"));
                p.setContent(rs.getString("content"));
                p.setDate(rs.getDate("date"));
                p.setStatus(rs.getString("status"));
                p.setImage(rs.getString("image"));
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public int countComment(Date from, Date to) {
        String sql = "select count(*) from comment a join post b on a.postID = b.postID where b.date  between ? and ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1, from);
            ps.setDate(2, to);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    public List<Post> getPostByCateID (int id){
        List<Post> list = new ArrayList<>();
        String sql = "select * from Post where categoryID  = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post p = new Post();
                p.setPostID(rs.getInt("postID"));
                p.setUserID(rs.getInt("userID"));
                p.setCategoryID(rs.getInt("categoryID"));
                p.setHastag(rs.getString("hastag"));
                p.setContent(rs.getString("content"));
                p.setDate(rs.getDate("date"));
                p.setStatus(rs.getString("status"));
                p.setImage(rs.getString("image"));
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    public List<Category> getAllCate(){
        List<Category> list = new ArrayList<>();
        String sql = "select * from category ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt("categoryID"), rs.getString("categoryName")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
