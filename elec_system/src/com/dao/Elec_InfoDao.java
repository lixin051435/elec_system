package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.domain.Elec_Info;
import com.domain.User;
import com.util.DBUtils;

public class Elec_InfoDao {
	private static Connection conn;

	public ArrayList<Elec_Info> getAllInfos() {
		ArrayList<Elec_Info> infos = new ArrayList<Elec_Info>();
		conn = DBUtils.getConn();
		Elec_Info info = null;
		String sql = "select * from elec_info";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				info = new Elec_Info();
				info.setDate(rs.getTimestamp(1));
				info.setIa1(rs.getDouble(2));
				info.setIa2(rs.getDouble(3));
				info.setIb1(rs.getDouble(4));
				info.setIb2(rs.getDouble(5));
				info.setIc1(rs.getDouble(6));
				info.setIc2(rs.getDouble(7));
				info.setStatus(rs.getString(8));
				infos.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
		return infos;
	}

	public Elec_Info getInfoByDate(String datetime) {
		// 必须是 yyyy-MM-dd HH:mm:ss格式
		Elec_Info info = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			pst = conn
					.prepareStatement("select * from elec_info where date =?");
			pst.setString(1, datetime);// 设置条件id
			rs = pst.executeQuery();
			while (rs.next()) {// 结果集存在则进行遍历
				info = new Elec_Info();
				info.setDate(rs.getTimestamp(1));
				info.setIa1(rs.getDouble(2));
				info.setIa2(rs.getDouble(3));
				info.setIb1(rs.getDouble(4));
				info.setIb2(rs.getDouble(5));
				info.setIc1(rs.getDouble(6));
				info.setIc2(rs.getDouble(7));
				info.setStatus(rs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnection(conn);
		}
		return info;
	}

	public void add(Elec_Info info) {
		conn = DBUtils.getConn();
		String sql = "insert into elec_info values (?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			Timestamp t = new Timestamp(info.getDate().getTime());
			pstmt.setTimestamp(1, t);
			pstmt.setDouble(2, info.getIa1());
			pstmt.setDouble(3, info.getIa2());
			pstmt.setDouble(4, info.getIb1());
			pstmt.setDouble(5, info.getIb2());
			pstmt.setDouble(6, info.getIc1());
			pstmt.setDouble(7, info.getIc2());
			pstmt.setString(8, info.getStatus());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(pstmt);
			DBUtils.closeConnection(conn);
		}
	}

	public void update(Elec_Info info) {
		conn = DBUtils.getConn();
		String sql = "update elec_info set ia1 = ?, ia2 = ?, ib1 = ?, ib2 = ?, ic1 = ?, ic2 = ?, status = ? where date = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setDouble(1, info.getIa1());
			pstmt.setDouble(2, info.getIa2());
			pstmt.setDouble(3, info.getIb1());
			pstmt.setDouble(4, info.getIb2());
			pstmt.setDouble(5, info.getIc1());
			pstmt.setDouble(6, info.getIc2());
			pstmt.setString(7, info.getStatus());
			Timestamp t = new Timestamp(info.getDate().getTime());
			pstmt.setTimestamp(8, t);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(pstmt);
			DBUtils.closeConnection(conn);
		}
	}
	public void remove(String datetime) {
		conn = DBUtils.getConn();
		String sql = "delete from elec_info where date ='" + datetime + "'";
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
	}

}
