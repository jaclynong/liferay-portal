/**
 * Copyright (c) 2000-2008 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.portlet.announcements.service.base;

import com.liferay.counter.service.CounterLocalService;
import com.liferay.counter.service.CounterLocalServiceFactory;
import com.liferay.counter.service.CounterService;
import com.liferay.counter.service.CounterServiceFactory;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.DynamicQueryInitializer;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceLocalServiceFactory;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.ResourceServiceFactory;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserLocalServiceFactory;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.UserServiceFactory;
import com.liferay.portal.service.persistence.ResourceFinder;
import com.liferay.portal.service.persistence.ResourceFinderUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.ResourceUtil;
import com.liferay.portal.service.persistence.UserFinder;
import com.liferay.portal.service.persistence.UserFinderUtil;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.UserUtil;

import com.liferay.portlet.announcements.model.Announcement;
import com.liferay.portlet.announcements.service.AnnouncementFlagLocalService;
import com.liferay.portlet.announcements.service.AnnouncementFlagLocalServiceFactory;
import com.liferay.portlet.announcements.service.AnnouncementFlagService;
import com.liferay.portlet.announcements.service.AnnouncementFlagServiceFactory;
import com.liferay.portlet.announcements.service.AnnouncementLocalService;
import com.liferay.portlet.announcements.service.persistence.AnnouncementFinder;
import com.liferay.portlet.announcements.service.persistence.AnnouncementFinderUtil;
import com.liferay.portlet.announcements.service.persistence.AnnouncementFlagPersistence;
import com.liferay.portlet.announcements.service.persistence.AnnouncementFlagUtil;
import com.liferay.portlet.announcements.service.persistence.AnnouncementPersistence;
import com.liferay.portlet.announcements.service.persistence.AnnouncementUtil;

import org.springframework.beans.factory.InitializingBean;

import java.util.List;

/**
 * <a href="AnnouncementLocalServiceBaseImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public abstract class AnnouncementLocalServiceBaseImpl
	implements AnnouncementLocalService, InitializingBean {
	public Announcement addAnnouncement(Announcement announcement)
		throws SystemException {
		announcement.setNew(true);

		return announcementPersistence.update(announcement);
	}

	public void deleteAnnouncement(long announcementId)
		throws PortalException, SystemException {
		announcementPersistence.remove(announcementId);
	}

	public void deleteAnnouncement(Announcement announcement)
		throws PortalException, SystemException {
		announcementPersistence.remove(announcement);
	}

	public List<Announcement> dynamicQuery(
		DynamicQueryInitializer queryInitializer) throws SystemException {
		return announcementPersistence.findWithDynamicQuery(queryInitializer);
	}

	public List<Announcement> dynamicQuery(
		DynamicQueryInitializer queryInitializer, int begin, int end)
		throws SystemException {
		return announcementPersistence.findWithDynamicQuery(queryInitializer,
			begin, end);
	}

	public Announcement updateAnnouncement(Announcement announcement)
		throws SystemException {
		announcement.setNew(false);

		return announcementPersistence.update(announcement, true);
	}

	public AnnouncementPersistence getAnnouncementPersistence() {
		return announcementPersistence;
	}

	public void setAnnouncementPersistence(
		AnnouncementPersistence announcementPersistence) {
		this.announcementPersistence = announcementPersistence;
	}

	public AnnouncementFinder getAnnouncementFinder() {
		return announcementFinder;
	}

	public void setAnnouncementFinder(AnnouncementFinder announcementFinder) {
		this.announcementFinder = announcementFinder;
	}

	public AnnouncementFlagLocalService getAnnouncementFlagLocalService() {
		return announcementFlagLocalService;
	}

	public void setAnnouncementFlagLocalService(
		AnnouncementFlagLocalService announcementFlagLocalService) {
		this.announcementFlagLocalService = announcementFlagLocalService;
	}

	public AnnouncementFlagService getAnnouncementFlagService() {
		return announcementFlagService;
	}

	public void setAnnouncementFlagService(
		AnnouncementFlagService announcementFlagService) {
		this.announcementFlagService = announcementFlagService;
	}

	public AnnouncementFlagPersistence getAnnouncementFlagPersistence() {
		return announcementFlagPersistence;
	}

	public void setAnnouncementFlagPersistence(
		AnnouncementFlagPersistence announcementFlagPersistence) {
		this.announcementFlagPersistence = announcementFlagPersistence;
	}

	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	public CounterService getCounterService() {
		return counterService;
	}

	public void setCounterService(CounterService counterService) {
		this.counterService = counterService;
	}

	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	public ResourceService getResourceService() {
		return resourceService;
	}

	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	public ResourceFinder getResourceFinder() {
		return resourceFinder;
	}

	public void setResourceFinder(ResourceFinder resourceFinder) {
		this.resourceFinder = resourceFinder;
	}

	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public UserFinder getUserFinder() {
		return userFinder;
	}

	public void setUserFinder(UserFinder userFinder) {
		this.userFinder = userFinder;
	}

	public void afterPropertiesSet() {
		if (announcementPersistence == null) {
			announcementPersistence = AnnouncementUtil.getPersistence();
		}

		if (announcementFinder == null) {
			announcementFinder = AnnouncementFinderUtil.getFinder();
		}

		if (announcementFlagLocalService == null) {
			announcementFlagLocalService = AnnouncementFlagLocalServiceFactory.getImpl();
		}

		if (announcementFlagService == null) {
			announcementFlagService = AnnouncementFlagServiceFactory.getImpl();
		}

		if (announcementFlagPersistence == null) {
			announcementFlagPersistence = AnnouncementFlagUtil.getPersistence();
		}

		if (counterLocalService == null) {
			counterLocalService = CounterLocalServiceFactory.getImpl();
		}

		if (counterService == null) {
			counterService = CounterServiceFactory.getImpl();
		}

		if (resourceLocalService == null) {
			resourceLocalService = ResourceLocalServiceFactory.getImpl();
		}

		if (resourceService == null) {
			resourceService = ResourceServiceFactory.getImpl();
		}

		if (resourcePersistence == null) {
			resourcePersistence = ResourceUtil.getPersistence();
		}

		if (resourceFinder == null) {
			resourceFinder = ResourceFinderUtil.getFinder();
		}

		if (userLocalService == null) {
			userLocalService = UserLocalServiceFactory.getImpl();
		}

		if (userService == null) {
			userService = UserServiceFactory.getImpl();
		}

		if (userPersistence == null) {
			userPersistence = UserUtil.getPersistence();
		}

		if (userFinder == null) {
			userFinder = UserFinderUtil.getFinder();
		}
	}

	protected AnnouncementPersistence announcementPersistence;
	protected AnnouncementFinder announcementFinder;
	protected AnnouncementFlagLocalService announcementFlagLocalService;
	protected AnnouncementFlagService announcementFlagService;
	protected AnnouncementFlagPersistence announcementFlagPersistence;
	protected CounterLocalService counterLocalService;
	protected CounterService counterService;
	protected ResourceLocalService resourceLocalService;
	protected ResourceService resourceService;
	protected ResourcePersistence resourcePersistence;
	protected ResourceFinder resourceFinder;
	protected UserLocalService userLocalService;
	protected UserService userService;
	protected UserPersistence userPersistence;
	protected UserFinder userFinder;
}