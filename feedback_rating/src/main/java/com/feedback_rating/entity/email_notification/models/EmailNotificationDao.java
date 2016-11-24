/**
 * 
 */
package com.feedback_rating.entity.email_notification.models;

import java.util.Date;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.feedback_rating.entity.order.models.Order;
import com.feedback_rating.entity.order.models.OrderKey;


/**
 * @author gurushant.j
 *
 */
@Repository
public class EmailNotificationDao {
	@Autowired
	private SessionFactory _sessionFactory;
	
	private Session getSession()
	{
		return _sessionFactory.getCurrentSession();
	}
	
	public EmailNotification getOrderDetail(EmailNotifyKey key)
	{
		return (EmailNotification) getSession().load(EmailNotification.class, key);
	}
		
	public void updateEmailNotification(EmailNotifyKey key,boolean isFeedbackReceived)
	{
		Session session=getSession();
	//	session.beginTransaction();
		EmailNotification emailObj=(EmailNotification)session.load(EmailNotification.class, key);
		emailObj.setFeedbackReceivedTime(new Date());
		emailObj.setFeedbackExists(isFeedbackReceived);
		session.saveOrUpdate(emailObj);
		//session.getTransaction().commit();
		//session.disconnect();
	}
	

}