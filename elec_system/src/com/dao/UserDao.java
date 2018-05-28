package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.domain.User;
import com.util.DBUtils;

public class UserDao {
	private static Connection conn;

	public ArrayList<User> getAllUsers() {
		ArrayList<User> users = new ArrayList<User>();
		User user = null;
		conn = DBUtils.getConn();
		String sql = "select * from user";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				user = new User();
				user.setUser_id(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setDepartment(rs.getString(4));
				user.setEmp(rs.getString(5));
				user.setTel(rs.getString(6));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
		return users;
	}

	public User getUserById(int user_id) {
		User user = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			pst = conn.prepareStatement("select * from user where user_id =?");
			pst.setInt(1, user_id);// 设置条件id
			rs = pst.executeQuery();
			while (rs.next()) {// 结果集存在则进行遍历
				user = new User();
				user.setUser_id(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setDepartment(rs.getString(4));
				user.setEmp(rs.getString(5));
				user.setTel(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
		return user;

	}
	
	public User getUserByName(String name) {
		User user = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			pst = conn.prepareStatement("select * from user where name =?");
			pst.setString(1, name);// 设置条件id
			rs = pst.executeQuery();
			while (rs.next()) {// 结果集存在则进行遍历
				user = new User();
				user.setUser_id(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setDepartment(rs.getString(4));
				user.setEmp(rs.getString(5));
				user.setTel(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
		return user;

	}

	public User add(User user) {
		conn = DBUtils.getConn();
		String sql = "insert into user values (?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setInt(1, user.getUser_id());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getDepartment());
			pstmt.setString(5, user.getEmp());
			pstmt.setString(6, user.getTel());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(pstmt);
			DBUtils.closeConnection(conn);
		}
		ArrayList<User> users = getAllUsers();
		return users.get(users.size() - 1);
	}

	public int remove(int user_id) {
		conn = DBUtils.getConn();
		String sql = "delete from user where user_id='" + user_id + "'";
		PreparedStatement pstmt = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(pstmt);
			DBUtils.closeConnection(conn);
		}
		return user_id;
	}
	public void update(User user){
		conn = DBUtils.getConn();
		String sql = "update user set name = ?, password = ?, department = ?, emp = ?, tel = ? where user_id = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getDepartment());
			pstmt.setString(4, user.getEmp());
			pstmt.setString(5, user.getTel());
			pstmt.setInt(6, user.getUser_id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(pstmt);
			DBUtils.closeConnection(conn);
		}
	}

}
