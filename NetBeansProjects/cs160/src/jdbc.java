import java.sql.*;
import java.util.ArrayList;


public class jdbc {

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    private void start() throws SQLException{
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/racqual", "root", "99643333");
        stmt = conn.createStatement();
    }

    private void close() throws SQLException{
        rs.close();
        stmt.close();
        conn.close();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/racqual", "root", "99643333");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM listingInfo" );


        rs.close();
        stmt.close();
        conn.close();

    }

    public User getUser(String user) throws SQLException{
        start();
        rs = stmt.executeQuery("SELECT * FROM userInfo WHERE username = '"+ user + "'");
        User rtrn = null;
        if(rs.next()){
            rtrn = new User();
            rtrn.setUserName(rs.getString(1));
            rtrn.setPassWord(rs.getString(2));
            rtrn.setFirstName(rs.getString(3));
            rtrn.setLastName(rs.getString(4));
            rtrn.setEmail(rs.getString(5));
            long number = 0;
            String num = rs.getString(6);
            if(num != null) number = Long.parseLong(num.replace("-", "").replace("(","").replace(")", ""));
            rtrn.setPhoneNumber(number);
            rtrn.setCity(rs.getString(7));
            rtrn.setState(rs.getString(8));
            rtrn.setRating(rs.getInt(9));
        }
        close();
        return rtrn;
    }

    public ArrayList<Listing> getAllListing() throws SQLException{
        start();
        rs = stmt.executeQuery("SELECT * FROM listingInfo");
        ArrayList<Listing> rtrn = new ArrayList<Listing>();
        while(rs.next()){
           Listing temp = new Listing();
           temp.setUserName(rs.getString(2));
           temp.setRacquetID(rs.getInt(3));
           temp.setPrice(rs.getDouble(4));
           temp.setNewOrOld(rs.getString(5));
           temp.setDateListed(rs.getDate(6));
           temp.setDateSold(rs.getDate(7));
           //temp.setSellerRating(rs.getInt(8));
           temp.setDescription(rs.getString(9));
           temp.setPicURL(rs.getString(10));
           rtrn.add(temp);
        }
        close();
        return rtrn;
    }

    public Racquet getRacquet(int racquetId) throws SQLException{
        start();
        rs = stmt.executeQuery("SELECT * FROM racquetInfo WHERE racquetID = '" + racquetId + "'");
        Racquet rtrn = null;
        if(rs.next()){
            rtrn = new Racquet();
            rtrn.setModelName(rs.getString(2));
            rtrn.setBrand(rs.getString(3));
            rtrn.setMass(rs.getDouble(4));
            rtrn.setLength(rs.getDouble(5));
          //  rtrn.setSwingWeight(rs.getDouble(6));
            rtrn.setBalancePoint(rs.getDouble(7));
            rtrn.setQualityIndex(rs.getDouble(8));
        }
        close();
        return rtrn;
    }



}