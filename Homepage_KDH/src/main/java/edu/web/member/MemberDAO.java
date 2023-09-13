package edu.web.member;

public interface MemberDAO {
	public abstract int insert(MemberVO vo);
	
	public abstract MemberVO select(String id);
	
	public abstract int login(String id, String pw);
	
	public abstract int update(String id, MemberVO vo);
	
	public abstract int delete(String id);
}
