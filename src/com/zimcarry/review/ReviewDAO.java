package com.zimcarry.review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zimcarry.db.DBConn;

public class ReviewDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public boolean insertReview(ReviewDTO reviewDTO) {
		try {
			String sql = "INSERT INTO tb_review(re_score, re_title, re_content, re_bookidx) VALUES(?, ?, ?, ?)";
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, reviewDTO.getReScore());
			pstmt.setString(2, reviewDTO.getReTitle());
			pstmt.setString(3, reviewDTO.getReContent().trim());
			pstmt.setLong(4, reviewDTO.getReBookidx());
			int result = pstmt.executeUpdate();
			if (result > 0) {
				sql = "UPDATE tb_book SET b_isreview = ? WHERE b_idx = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "y");
				pstmt.setLong(2, reviewDTO.getReBookidx());
				result = pstmt.executeUpdate();
				if (result > 0) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			DBConn.close(conn, pstmt);
		}
		return false;
	}
	
	public List<ReviewDTO> selectReviewList() {
		List<ReviewDTO> reviewList = new ArrayList<ReviewDTO>();
		
		try {
			String sql = "SELECT re_idx, re_score, re_title, re_content, re_writedate, re_bookidx FROM tb_review";
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ReviewDTO reviewDTO = new ReviewDTO();
				reviewDTO.setReIdx(rs.getLong("re_idx"));
				reviewDTO.setReScore(rs.getDouble("re_score"));
				reviewDTO.setReTitle(rs.getString("re_title"));
				reviewDTO.setReContent(rs.getString("re_content"));
				reviewDTO.setReWritedate(rs.getDate("re_writedate"));
				reviewDTO.setReBookidx(rs.getLong("re_bookidx"));
				reviewList.add(reviewDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reviewList;
	}
	public List<ReviewDTO> ReviewList() {
		List<ReviewDTO> reviewList = new ArrayList<ReviewDTO>();
		
		return reviewList;
	}
}