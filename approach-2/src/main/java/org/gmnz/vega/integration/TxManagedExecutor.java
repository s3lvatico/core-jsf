package org.gmnz.vega.integration;


import org.hibernate.Session;


abstract class TxManagedExecutor<R> {


	protected Session session;



	protected abstract R execute() throws DaoException;


}
