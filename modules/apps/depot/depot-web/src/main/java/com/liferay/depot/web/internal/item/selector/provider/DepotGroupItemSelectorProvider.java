/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.depot.web.internal.item.selector.provider;

import com.liferay.depot.model.DepotEntry;
import com.liferay.depot.service.DepotEntryService;
import com.liferay.depot.util.DepotSupportChecker;
import com.liferay.item.selector.provider.GroupItemSelectorProvider;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupService;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Cristina González
 */
@Component(service = GroupItemSelectorProvider.class)
public class DepotGroupItemSelectorProvider
	implements GroupItemSelectorProvider {

	/**
	 * @deprecated As of Athanasius (7.3.x)
	 */
	@Deprecated
	@Override
	public String getEmptyResultsMessage() {
		return "no-asset-libraries-were-found";
	}

	@Override
	public String getEmptyResultsMessage(Locale locale) {
		return ResourceBundleUtil.getString(
			_resourceBundleLoader.loadResourceBundle(locale),
			"no-asset-libraries-were-found");
	}

	@Override
	public List<Group> getGroups(
		long companyId, long groupId, String keywords, int start, int end) {

		try {
			List<Group> groups = new ArrayList<>();

			for (DepotEntry depotEntry :
					_depotEntryService.getGroupConnectedDepotEntries(
						_getLiveGroupId(groupId), start, end)) {

				groups.add(depotEntry.getGroup());
			}

			return groups;
		}
		catch (PortalException portalException) {
			_log.error(portalException, portalException);

			return Collections.emptyList();
		}
	}

	@Override
	public int getGroupsCount(long companyId, long groupId, String keywords) {
		try {
			return _depotEntryService.getGroupConnectedDepotEntriesCount(
				_getLiveGroupId(groupId));
		}
		catch (PortalException portalException) {
			_log.error(portalException, portalException);

			return 0;
		}
	}

	@Override
	public String getGroupType() {
		return "depot";
	}

	@Override
	public String getIcon() {
		return "books";
	}

	@Override
	public String getLabel(Locale locale) {
		return _language.get(locale, "asset-library");
	}

	@Override
	public boolean isEnabled() {
		return _depotSupportChecker.isEnabled();
	}

	private long _getLiveGroupId(long groupId) throws PortalException {
		Group group = _groupService.getGroup(groupId);

		if (group.isStagingGroup()) {
			return group.getLiveGroupId();
		}

		return groupId;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		DepotGroupItemSelectorProvider.class);

	@Reference
	private DepotEntryService _depotEntryService;

	@Reference
	private DepotSupportChecker _depotSupportChecker;

	@Reference
	private GroupService _groupService;

	@Reference
	private Language _language;

	@Reference(target = "(bundle.symbolic.name=com.liferay.depot.web)")
	private ResourceBundleLoader _resourceBundleLoader;

}