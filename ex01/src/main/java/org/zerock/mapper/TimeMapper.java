package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	@Select("select sysdate from dual")
	public String geTime();
	
	public String getTime2();
}
