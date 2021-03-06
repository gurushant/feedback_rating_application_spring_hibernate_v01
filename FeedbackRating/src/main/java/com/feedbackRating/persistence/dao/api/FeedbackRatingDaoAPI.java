/**
 * 
 */
package com.feedbackRating.persistence.dao.api;

import org.hibernate.Session;

import com.feedbackRating.persistence.models.EmailNotification;
import com.feedbackRating.persistence.models.Order;
import com.feedbackRating.persistence.models.keys.EmailNotifyKey;
import com.feedbackRating.persistence.models.keys.OrderKey;

/**
 * @author gurushant.j
 *
 */
public interface FeedbackRatingDaoAPI {
	public boolean checkIsFeedbackReceived(EmailNotifyKey key);
	public EmailNotification getEmailDetail(EmailNotifyKey key);
	public boolean updateEmailNotification(EmailNotifyKey key,boolean isFeedbackReceived);
	public Order getOrderDetail(OrderKey key);
	public boolean updateOrderData(String feedback,float overallOrderRating,float overallRecipeRating,
			String jsonRatingData,OrderKey key);
	public Session getSession();

}
