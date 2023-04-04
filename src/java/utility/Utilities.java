package utility;

import dal.*;
import java.util.*;
import model.*;
import java.sql.Date;
/**
 *
 * @author Admin
 */
public class Utilities {

    DAO d = new DAO();
    List<Account> listAcc = d.loadListAccount();
    List<Post> listpost = d.loadListPost();

    public Utilities() {
    }

    // validate not empty
    public boolean validNotEmpty(String u, String p, String cp, String f) {
        if (!"".equals(u) && !"".equals(p) && !"".equals(cp) && !"".equals(f)) {
            return true;
        }
        return false;
    }

    // validate not blank
    public boolean validNotBlank(String u) {
        if (!"".equals(u)) {
            return true;
        }
        return false;
    }



    //check exist pass
    public boolean checkExistPass(String pass) {
        for (Account u : listAcc) {
            if (u.getPassword().equals(pass)) {
                return true;
            }
        }
        return false;
    }

    // check exist username
    public boolean checkExistUsername(String u) {
        for (Account o : listAcc) {
            if (o.getUsername().equals(u)) {
                return true;
            }
        }
        return false;
    }

    //check repeat pass matching
    public boolean checkRepeatPass(String p, String cp) {
        if (cp.equals(p)) {
            return true;
        }
        return false;
    }

    // validate input field require
    public String validInputRequire(String u, String p, String cp, String f) {
        String errNoti = null;
        if (validName(f) != null) {
            errNoti = validName(f);
        } else if (validUsername(u) != null) {
            errNoti = validUsername(u);
        } else if (validPass(p) != null) {
            errNoti = validPass(p);
        }
        return errNoti;
    }

    // validate fullname of user
    public String validName(String f) {
        if (f.length() < 2 || f.length() > 32) {
            return "Name must be between 2 and 32 characters";
        }
        return null;
    }

    //validate email
    public String validEmail(String email) {
        String regex = "\\w+@\\w+[.]\\w+";
        if (!email.matches(regex)) {
            return "Invalid type of email!, for example: example1@gmail.com";
        }
        return null;
    }

    // validate username
    public String validUsername(String u) {
        String regex = "[a-zA-Z0-9 ]+";
        if (u.length() < 4 || u.length() > 12 || !u.matches(regex)) {
            return "User name must be between 4 and 12 characters and be the number or alphabet characters";
        }
        return null;
    }

    // validate pass
    public String validPass(String p) {
        if (p.length() < 4 || p.length() > 12) {
            return "Password must be between 4 and 12 characters";
        }
        return null;
    }

    // validate secure answer
    public String validSecureAns(String fq, String sq) {
        if (fq.length() < 1 || fq.length() > 100 || sq.length() < 1 || sq.length() > 100) {
            return "Answer of security questions must be between 2 and 100 characters";
        }
        return null;
    }

//    // get account if exist
    public Account getAccExist(String u, String p) {
        for (Account o : listAcc) {
            if (o.getUsername().equals(u) && o.getPassword().equals(p)) {
                return o;
            }
        }
        return null;
    }
//
//    // get account by username
//    public Account getAcc(String u) {
//        for (Account o : listacc) {
//            if (o.getUser().equals(u)) {
//                return o;
//            }
//        }
//        return null;
//    }
//
//    //sap xep nguoc theo cac bai post moi nhat
    public void sortDesc(List<Post> list) {
        Collections.sort(list, new Comparator<Post>() {
            @Override
            public int compare(Post o1, Post o2) {
                return o1.getPostID() > o2.getPostID() ? -1 : 1;
            }
        });
    }

    // get post to display at home page
    public List<Post> getPost() {
        List<Post> list = listpost;
        sortDesc(list);
        return list;
    }
    public List<Post> getPost(Date date) {
        List<Post> list = new DAO().getPostByDate(date);
        sortDesc(list);
        return list;
    }

    // search post by title
    public List<Post> findPostByHastag(String hastag) {
        List<Post> listFind = new ArrayList<>();
        for (Post o : listpost) {
            if (o.getHastag().toLowerCase().contains(hastag)) {
                listFind.add(o);
            }
        }
        return listFind;
    }

    //get post by id
    public Post getPostById(int id) {
        for (Post o : listpost) {
            if (o.getPostID() == id) {
                return o;
            }
        }
        return null;
    }

    //get comment of a post by postId
    public ArrayList<Comment> getCommentByPostId(int id) {
        d.loadComment(id);
        ArrayList<Comment> listFind = new ArrayList<>();
        for (Comment o : d.getCmtList()) {
            if (o.getPostID() == id) {
                listFind.add(o);
            }
        }
        return listFind;
    }
    public static void main(String[] args) {
        for (Comment c : new utility.Utilities().getCommentByPostId(20)) {
            System.out.println(c.getCommentID());
        }
    }

    //sap xep nguoc theo cac binh luan moi nhat
    public void sortDescComment(ArrayList<Comment> list) {

        Collections.reverse(list);
    }

    // get comment by desc time
    public ArrayList<Comment> getComment(int id) {
        ArrayList<Comment> list = getCommentByPostId(id);
        sortDescComment(list);
        return list;
    }

    public String[] getSplitedHastag(String hastag) {
        String newstr = hastag;
        for (int i = 0; i < hastag.length(); i++) {
            if (hastag.charAt(i) == '#') {
                if (i != 0) {
                    if (hastag.charAt(i - 1) != ' ') {
                        newstr = hastag.substring(0, i) + " " + hastag.substring(i);
                    }
                }
            }
        }
        
        String[] arr = newstr.split(" ");

        return arr;
    }
    
    public boolean checkFormHastag(String hastag) {
        String[] arr = getSplitedHastag(hastag);
        for (int i=0; i<arr.length;i++) {
            if(!arr[i].startsWith("#"))
                return false;
        }
        return true;
    }
}
