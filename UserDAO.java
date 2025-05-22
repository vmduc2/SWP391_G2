/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

/**
 *
 * @author PC
 */
import java.util.*;
import java.lang.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Customer;
import model.User;

public class UserDao extends DBContext {

    public Customer getInfoCustomersByID(int customer_id) {
        String sql = "SELECT * "
                + "FROM Users u "
                + "JOIN Customer c ON u.user_id = c.user_id "
                + "WHERE u.user_id = ?;";
        Customer h = new Customer();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, customer_id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                h.setCustomerId(rs.getInt("customer_id"));
                h.setName(rs.getString("name"));
                h.setAddress(rs.getString("address"));
                h.setContactInfo(rs.getString("contact_info"));
                h.setRegistrationDate(rs.getTimestamp("registration_date").toLocalDateTime());
                h.setStatus(rs.getString("status"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return h;
    }

    public void changeInfoCustomersByID(int customer_id, String name, String Address, String ContactInfo) {
        String sql = "UPDATE Customer SET name = ?, address = ?, contact_info = ? WHERE customer_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, Address);
            st.setString(3, ContactInfo);
            st.setInt(4, customer_id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public User getInfoByID(int customer_id) {
        String sql = "SELECT * "
                + "FROM Users u "
                + "JOIN Customer c ON u.user_id = c.user_id "
                + "WHERE u.user_id = ?;";
        User h = new User();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, customer_id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                h.setEmail(rs.getString("email"));
                h.setUsername(rs.getString("username"));
                h.setPassword_hash(rs.getString("password_hash"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return h;
    }

    public void changeInfoByID(int customer_id, String username, String email) {
        String sql = "UPDATE Users u JOIN Customer c ON u.user_id = c.user_id " +
             "SET u.username = ?, u.email = ? " +
             "WHERE c.customer_id = ?";
;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, email);
            st.setInt(3, customer_id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}

