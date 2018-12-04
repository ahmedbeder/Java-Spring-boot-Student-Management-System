package com.studentmgr.dao;

import java.util.List;

import com.studentmgr.model.Student;

public interface StudentDao {
	
	/**
	 * This method delete given object from the database.
	 *
	 * @param id
	 *            - Object id to load
	 * @throws DataAccessException
	 *             - throws if an error occurs
	 */
	Student getById(int id) throws Exception;

	/**
	 * This method queries all the objects
	 *
	 * @throws DataAccessException
	 *             - throws if an error occurs
	 */
	List<Student> getAll() throws Exception;

	/**
	 * This method delete given object from the database.
	 *
	 * @param object
	 *            - instance of Object class
	 * @throws DataAccessException
	 *             - throws if an error occurs
	 */
	boolean delete(Student object) throws Exception;

	/**
	 * This method insert a given object to the database.
	 *
	 * @param object
	 *            - instance of Object class
	 * @throws DataAccessException
	 *             - throws if an error occurs
	 */
	boolean add(Student object) throws Exception;

	/**
	 * This method update given object in the database.
	 *
	 * @param object
	 *            - instance of Object class
	 * @throws DataAccessException
	 *             - throws if an error occurs
	 */
	void modify(Student object) throws Exception;
	
}
