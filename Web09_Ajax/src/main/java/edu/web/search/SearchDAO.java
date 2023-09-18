package edu.web.search;

import java.util.ArrayList;

public interface SearchDAO {
	public abstract ArrayList<SearchVO> select(String title);
}
