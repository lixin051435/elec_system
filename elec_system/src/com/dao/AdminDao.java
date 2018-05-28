package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.domain.Admin;
import com.util.DBUtils;

public class AdminDao {

	private static Connection conn;

	public ArrayList<Admin> getAllAdmins() {
		ArrayList<Admin> admins = new ArrayList<Admin>();
		Admin admin = null;
		conn = DBUtils.getConn();
		String sql = "select * from admin";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				admin = new Admin();
				admin.setAdmin_id(rs.getInt(1));
				admin.setName(rs.getString(2));
				admin.setPassword(rs.getString(3));
				admin.setEmp(rs.getString(4));
				admin.setTel(rs.getString(5));
				admins.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
		return admins;
	}

	public Admin getAdminById(int admin_id) {
		Admin admin = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			pst = conn.prepareStatement("select * from admin where admin_id =?");
			pst.setInt(1, admin_id);// 设置条件id
			rs = pst.executeQuery();
			while (rs.next()) {// 结果集存在则进行遍历
				admin = new Admin();
				admin.setAdmin_id(rs.getInt(1));
				admin.setName(rs.getString(2));
				admin.setPassword(rs.getString(3));
				admin.setEmp(rs.getString(4));
				admin.setTel(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
		return admin;

	}
	
	public Admin getAdminByName(String name) {
		Admin admin = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			pst = conn.prepareStatement("select * from admin where name =?");
			pst.setString(1, name);// 设置条件id
			rs = pst.executeQuery();
			while (rs.next()) {// 结果集存在则进行遍历
				admin = new Admin();
				admin.setAdmin_id(rs.getInt(1));
				admin.setName(rs.getString(2));
				admin.setPassword(rs.getString(3));
				admin.setEmp(rs.getString(4));
				admin.setTel(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
		return admin;

	}

	public Admin add(Admin admin) {
		conn = DBUtils.getConn();
		String sql = "insert into admin values (?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setInt(1, admin.getAdmin_id());
			pstmt.setString(2, admin.getName());
			pstmt.setString(3, admin.getPassword());
			pstmt.setString(4, admin.getEmp());
			pstmt.setString(5, admin.getTel());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(pstmt);
			DBUtils.closeConnection(conn);
		}
		return admin;
	}

	public int remove(int admin_id) {
		conn = DBUtils.getConn();
		String sql = "delete from admin where admin_id = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setInt(1, admin_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(pstmt);
			DBUtils.closeConnection(conn);
		}
		return admin_id;
	}
	
	public void update(Admin admin){
		conn = DBUtils.getConn();
		String sql = "update admin set name = ?, password = ?, emp = ?, tel = ? where admin_id = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, admin.getName());
			pstmt.setString(2, admin.getPassword());
			pstmt.setString(3, admin.getEmp());
			pstmt.setString(4, admin.getTel());
			pstmt.setInt(5, admin.getAdmin_id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(pstmt);
			DBUtils.closeConnection(conn);
		}
	}
}
