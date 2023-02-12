package com.spring.practice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.spring.practice.common.JDBCUtil;
import com.spring.practice.dto.UserTestDTO;

public class UserTestDAO {
	
	private final String insert_sql="insert into userTest values((select (nvl(max(idx),0)+1) from userTest),?,?)";
	private final String selectAll_sql = "select * from userTest order by idx asc";
	private final String selectOne_sql = "select * from userTest where idx=?";
	
	public void insertUserDTO(UserTestDTO dto) {
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstmt =null;
		try {
			pstmt = conn.prepareStatement(insert_sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2,dto.getPass());
			pstmt.executeUpdate();
			System.out.println("값 저장 완료");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("값 저장 실패");
		}finally {
			JDBCUtil.close(conn, pstmt);
		}
	}
	
	public List<UserTestDTO> getAllUsers(){
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		List<UserTestDTO> list_dto = null;
		UserTestDTO dto = null;
		try {
			
			pstmt= conn.prepareStatement(selectAll_sql);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				list_dto = new ArrayList<UserTestDTO>();
				do {
					dto = new UserTestDTO();
					dto.setIdx(rs.getInt("idx"));
					dto.setId(rs.getString("id"));
					dto.setPass(rs.getString("pass"));
					
					list_dto.add(dto);
				}while(rs.next());
				
			}else {
				System.out.println("데이터베이스 값 없음");
			}
			return list_dto;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, conn, pstmt);
		}
		return null;
	}
	
	
	
	public UserTestDTO getUserDetail(UserTestDTO dto) {
		Connection conn = JDBCUtil.getConnection();
		UserTestDTO user_detail = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			pstmt= conn.prepareStatement(selectOne_sql);
			pstmt.setInt(1, dto.getIdx());
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				user_detail = new UserTestDTO();
				user_detail.setId(rs.getString("id"));
				user_detail.setIdx(rs.getInt("idx"));
				user_detail.setPass(rs.getString("pass"));
				
				return user_detail;
				
			}else {
				System.out.println("데이터 없음");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
}
