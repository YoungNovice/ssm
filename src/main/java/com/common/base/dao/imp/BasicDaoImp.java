package com.common.base.dao.imp;

import com.common.base.dao.BasicDao;
import com.common.base.util.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * BasicDaoImp
 * @author Young
 */
public class BasicDaoImp<T> implements BasicDao<T> {
	
	@Autowired
	private SqlSession sqlSession;
	private static final String ST_NAMESPACE = "bean.";
	private static final String ST_BREAK = ".";
	private static final String ST_INSERT = "insert";
	private static final String ST_SELECT_ENTITY = "select";
	private static final String ST_SELECT_LIST = "List";
	private static final String ST_DELETE_ENTITY = "delete";
	private static final String ST_UPDATE_ENTITY = "update";
	private static final String ST_SELECT_PAGE = "Page";
	private static final String ST_SELECT_COUNT = "Count";
	private String className;

	public BasicDaoImp() throws DataAccessException {
		Type t = getClass().getGenericSuperclass();
		if (ParameterizedType.class.isAssignableFrom(t.getClass())) {
			this.className = ((Class<?>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName();
		}
	}	
	@SuppressWarnings("unchecked")
	private void getFiledValue(Object t, int startIndex, int endIndex) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Method method = t.getClass().getMethod("getMap");
		((Map<String, Object>) method.invoke(t)).put("startIndex", startIndex);
		((Map<String, Object>) method.invoke(t)).put("endIndex", endIndex);
	}

	@Override
	public int insertEntity(Object t) throws DataAccessException {
		return this.sqlSession.insert(ST_NAMESPACE + className + ST_BREAK + ST_INSERT + className, t);
	}

	@Override
	public int insertEntity(Object t, String mapid) throws DataAccessException {
		return this.sqlSession.insert(ST_NAMESPACE + className + ST_BREAK + ST_INSERT + className + mapid, t);
	}

	@Override
	@SuppressWarnings("unchecked")
	public T selectEntity(Object t, String mapid) throws DataAccessException {
		return (T) this.sqlSession.selectOne(ST_NAMESPACE + className + ST_BREAK + ST_SELECT_ENTITY + className + mapid, t);
	}
	@Override
	@SuppressWarnings("unchecked")
	public T selectEntity(Object t) throws DataAccessException {
		return (T) this.sqlSession.selectOne(ST_NAMESPACE + className + ST_BREAK + ST_SELECT_ENTITY + className, t);
	}
	@Override
	public List<T> selectEntityList(Object t) throws DataAccessException {
		return this.sqlSession.selectList(ST_NAMESPACE + className + ST_BREAK + ST_SELECT_ENTITY + className + ST_SELECT_LIST, t);
	}
	@Override
	public List<T> selectEntityList(Object t, String mapid) throws DataAccessException {
		return this.sqlSession.selectList(ST_NAMESPACE + className + ST_BREAK + ST_SELECT_ENTITY + className + ST_SELECT_LIST + mapid, t);
	}
	@Override
	public int deleteEntity(Object t) throws DataAccessException {
		return this.sqlSession.delete(ST_NAMESPACE + className + ST_BREAK + ST_DELETE_ENTITY + className, t);
	}
	@Override
	public int deleteEntity(Object t, String mapid) throws DataAccessException {
		return this.sqlSession.delete(ST_NAMESPACE + className + ST_BREAK + ST_DELETE_ENTITY + className + mapid, t);
	}
	@Override
	public int updateEntity(Object t) throws DataAccessException {
		return this.sqlSession.update(ST_NAMESPACE + className + ST_BREAK + ST_UPDATE_ENTITY + className, t);
	}
	@Override
	public int updateEntity(Object t, String mapid) throws DataAccessException {
		return this.sqlSession.update(ST_NAMESPACE + className + ST_BREAK + ST_UPDATE_ENTITY + className + mapid, t);
	}
	@Override
	@SuppressWarnings("unchecked")
	public PageInfo<T> selectEntityPage(Object t, PageInfo<T> page) throws DataAccessException {
		int pageSize = page.getPageSize();
		int pageIndex = page.getPageIndex();
		//判断是否需要统计总量
		if(page.isAutoCount()){
			int maxPage;
			int recordCount = this.sqlSession.selectOne(
					ST_NAMESPACE + className + ST_BREAK + ST_SELECT_ENTITY + className + ST_SELECT_COUNT, t);
			page.setTotalRow(recordCount);
			if (recordCount == 0) {
				maxPage = 0;
			} else if ((recordCount % pageSize) == 0) {
				maxPage = recordCount / pageSize;
			} else {
				maxPage = recordCount / pageSize + 1;
			}
			if (pageIndex  > maxPage) {
				pageIndex = maxPage;
			}
			
		}
		int startIndex = 0;
		if (pageIndex != 0) {
			startIndex = (pageIndex - 1) * pageSize;
		}
		int endIndex = 0;
		if (pageIndex != 0) {
			endIndex = pageIndex * pageSize;
		}
		try {
			getFiledValue(t, startIndex, endIndex);
			Method method = t.getClass().getMethod("getMap");
			((Map<String, Object>) method.invoke(t)).put("page", page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<T> list = this.sqlSession.selectList(ST_NAMESPACE + className + ST_BREAK + ST_SELECT_ENTITY + className + ST_SELECT_PAGE, t);
		page.setList(list);
		return page;
	}
	@Override
	@SuppressWarnings("unchecked")
	public PageInfo<T> selectEntityPage(Object t, String mapid, PageInfo<T> page) throws DataAccessException {
		int pageSize = page.getPageSize();
		int pageIndex = page.getPageIndex();
		//判断是否需要统计总量
		if(page.isAutoCount()){
			int maxPage;
			int recordCount = this.sqlSession.selectOne(
					ST_NAMESPACE + className + ST_BREAK + ST_SELECT_ENTITY + className + ST_SELECT_COUNT + mapid, t);
			page.setTotalRow(recordCount);
			if (recordCount == 0) {
				maxPage = 0;
			} else if ((recordCount % pageSize) == 0) {
				maxPage = recordCount / pageSize;
			} else {
				maxPage = recordCount / pageSize + 1;
			}
			if (pageIndex  > maxPage) {
				pageIndex = maxPage;
			}
			
		}
		int startIndex = 0;
		if (pageIndex != 0) {
			startIndex = (pageIndex - 1) * pageSize;
		}
		int endIndex = 0;
		if (pageIndex != 0) {
			endIndex = pageIndex * pageSize;
		}
		try {
			getFiledValue(t, startIndex, endIndex);
			Method method = t.getClass().getMethod("getMap");
			((Map<String, Object>) method.invoke(t)).put("page", page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<T> list = this.sqlSession.selectList(ST_NAMESPACE + className + ST_BREAK + ST_SELECT_ENTITY + className + ST_SELECT_PAGE + mapid, t);
		page.setList(list);
		return page;
	}
	@Override
	public PageInfo<T> selectEntityPage(Object t, int pageIndex, int pageSize) throws DataAccessException {
		int recordCount = this.sqlSession.selectOne(ST_NAMESPACE + className + ST_BREAK + ST_SELECT_ENTITY + className + ST_SELECT_COUNT, t);
		int maxPage;
		if (recordCount == 0) {
			maxPage = 0;
		} else if ((recordCount % pageSize) == 0) {
			maxPage = recordCount / pageSize;
		} else {
			maxPage = recordCount / pageSize + 1;
		}
		if (pageIndex > maxPage) {
			pageIndex = maxPage;
		}
		int startIndex = 0;
		if (pageIndex != 0) {
			startIndex = (pageIndex - 1) * pageSize;
		}
		int endIndex = 0;
		if (pageIndex != 0) {
			endIndex = pageIndex * pageSize;
		}
		try {
			getFiledValue(t, startIndex, endIndex);
		} catch (SecurityException | InvocationTargetException | IllegalAccessException | NoSuchMethodException | IllegalArgumentException ignored) {
		
		}
		List<T> list = this.sqlSession.selectList(ST_NAMESPACE + className + ST_BREAK + ST_SELECT_ENTITY + className + ST_SELECT_PAGE, t);
		return new PageInfo<>(list, pageSize, recordCount, pageIndex);
	}
	@Override
	public PageInfo<T> selectEntityPage(Object t, String mapid, int pageIndex, int pageSize) throws DataAccessException {

		int recordCount = this.sqlSession.selectOne(ST_NAMESPACE + className + ST_BREAK + ST_SELECT_ENTITY + className + ST_SELECT_COUNT + mapid, t);
		int maxPage;
		if (recordCount == 0) {
			maxPage = 0;
		} else if ((recordCount % pageSize) == 0) {
			maxPage = recordCount / pageSize;
		} else {
			maxPage = recordCount / pageSize + 1;
		}
		if (pageIndex > maxPage) {
			pageIndex = maxPage;
		}
		int startIndex = 0;
		if (pageIndex != 0) {
			startIndex = (pageIndex - 1) * pageSize;
		}
		int endIndex = 0;
		if (pageIndex != 0) {
			endIndex = pageIndex * pageSize;
		}
		try {
			getFiledValue(t, startIndex, endIndex);
		} catch (SecurityException | IllegalArgumentException | IllegalAccessException | NoSuchMethodException | InvocationTargetException ignored) {
		}
		List<T> list = this.sqlSession.selectList(ST_NAMESPACE + className + ST_BREAK + ST_SELECT_ENTITY + className + ST_SELECT_PAGE + mapid, t);
		return new PageInfo<>(list, pageSize, recordCount, pageIndex);
	}


	@Override
	public int selectCount(Object t) throws DataAccessException {
		Object o = this.sqlSession.selectOne(ST_NAMESPACE + className + ST_BREAK + ST_SELECT_ENTITY + className + ST_SELECT_COUNT, t);
		if (null == o) {
			return 0;
		}
		return (int) (Integer) o;
	}

	@Override
	public int selectCount(Object t, String mapid) throws DataAccessException {
		return (int) (Integer) this.sqlSession.selectOne(ST_NAMESPACE + className + ST_BREAK + ST_SELECT_ENTITY + className + ST_SELECT_COUNT + mapid, t);
	}
	
}
