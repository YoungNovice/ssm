package com.common.base.dao;

import com.common.base.util.PageInfo;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * @author Young
 */
public interface BasicDao<T> {
	
	int insertEntity(Object t) throws DataAccessException;
	
	int insertEntity(Object t, String mapid) throws DataAccessException;

	 T selectEntity(Object t)throws DataAccessException;
	
	 T selectEntity(Object t, String mapid)throws DataAccessException;
	
	 List<T> selectEntityList(Object t) throws DataAccessException;

	 List<T> selectEntityList(Object t, String mapid) throws DataAccessException;
	
	 int deleteEntity(Object t) throws DataAccessException;
	
	 int deleteEntity(Object t, String mapid) throws DataAccessException;
	
	 int updateEntity(Object t) throws DataAccessException;
	
	 int updateEntity(Object t, String mapid) throws DataAccessException;
	
	 int selectCount(Object t) throws DataAccessException;
	
	 int selectCount(Object t, String mapid) throws DataAccessException;
	
	 PageInfo<T> selectEntityPage(Object t, int pageIndex, int pageSize) throws DataAccessException;
	
	 PageInfo<T> selectEntityPage(Object t, String mapid, int pageIndex, int pageSize) throws DataAccessException;
	
	 PageInfo<T> selectEntityPage(Object t, PageInfo<T> page) throws DataAccessException;
	
	 PageInfo<T> selectEntityPage(Object t, String mapid, PageInfo<T> page) throws DataAccessException;


}
