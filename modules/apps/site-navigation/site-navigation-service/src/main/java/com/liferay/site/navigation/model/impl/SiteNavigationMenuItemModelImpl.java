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

package com.liferay.site.navigation.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.site.navigation.model.SiteNavigationMenuItem;
import com.liferay.site.navigation.model.SiteNavigationMenuItemModel;
import com.liferay.site.navigation.model.SiteNavigationMenuItemSoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the SiteNavigationMenuItem service. Represents a row in the &quot;SiteNavigationMenuItem&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>SiteNavigationMenuItemModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SiteNavigationMenuItemImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SiteNavigationMenuItemImpl
 * @generated
 */
@JSON(strict = true)
public class SiteNavigationMenuItemModelImpl
	extends BaseModelImpl<SiteNavigationMenuItem>
	implements SiteNavigationMenuItemModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a site navigation menu item model instance should use the <code>SiteNavigationMenuItem</code> interface instead.
	 */
	public static final String TABLE_NAME = "SiteNavigationMenuItem";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"uuid_", Types.VARCHAR},
		{"siteNavigationMenuItemId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP},
		{"siteNavigationMenuId", Types.BIGINT},
		{"parentSiteNavigationMenuItemId", Types.BIGINT},
		{"name", Types.VARCHAR}, {"type_", Types.VARCHAR},
		{"typeSettings", Types.CLOB}, {"order_", Types.INTEGER},
		{"lastPublishDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("siteNavigationMenuItemId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("siteNavigationMenuId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("parentSiteNavigationMenuItemId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("type_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("typeSettings", Types.CLOB);
		TABLE_COLUMNS_MAP.put("order_", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("lastPublishDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table SiteNavigationMenuItem (mvccVersion LONG default 0 not null,uuid_ VARCHAR(75) null,siteNavigationMenuItemId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,siteNavigationMenuId LONG,parentSiteNavigationMenuItemId LONG,name VARCHAR(255) null,type_ VARCHAR(75) null,typeSettings TEXT null,order_ INTEGER,lastPublishDate DATE null)";

	public static final String TABLE_SQL_DROP =
		"drop table SiteNavigationMenuItem";

	public static final String ORDER_BY_JPQL =
		" ORDER BY siteNavigationMenuItem.siteNavigationMenuItemId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY SiteNavigationMenuItem.siteNavigationMenuItemId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long GROUPID_COLUMN_BITMASK = 2L;

	public static final long NAME_COLUMN_BITMASK = 4L;

	public static final long PARENTSITENAVIGATIONMENUITEMID_COLUMN_BITMASK = 8L;

	public static final long SITENAVIGATIONMENUID_COLUMN_BITMASK = 16L;

	public static final long UUID_COLUMN_BITMASK = 32L;

	public static final long SITENAVIGATIONMENUITEMID_COLUMN_BITMASK = 64L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static SiteNavigationMenuItem toModel(
		SiteNavigationMenuItemSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		SiteNavigationMenuItem model = new SiteNavigationMenuItemImpl();

		model.setMvccVersion(soapModel.getMvccVersion());
		model.setUuid(soapModel.getUuid());
		model.setSiteNavigationMenuItemId(
			soapModel.getSiteNavigationMenuItemId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setSiteNavigationMenuId(soapModel.getSiteNavigationMenuId());
		model.setParentSiteNavigationMenuItemId(
			soapModel.getParentSiteNavigationMenuItemId());
		model.setName(soapModel.getName());
		model.setType(soapModel.getType());
		model.setTypeSettings(soapModel.getTypeSettings());
		model.setOrder(soapModel.getOrder());
		model.setLastPublishDate(soapModel.getLastPublishDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<SiteNavigationMenuItem> toModels(
		SiteNavigationMenuItemSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<SiteNavigationMenuItem> models =
			new ArrayList<SiteNavigationMenuItem>(soapModels.length);

		for (SiteNavigationMenuItemSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public SiteNavigationMenuItemModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _siteNavigationMenuItemId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSiteNavigationMenuItemId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _siteNavigationMenuItemId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SiteNavigationMenuItem.class;
	}

	@Override
	public String getModelClassName() {
		return SiteNavigationMenuItem.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<SiteNavigationMenuItem, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<SiteNavigationMenuItem, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SiteNavigationMenuItem, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((SiteNavigationMenuItem)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<SiteNavigationMenuItem, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<SiteNavigationMenuItem, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(SiteNavigationMenuItem)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<SiteNavigationMenuItem, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<SiteNavigationMenuItem, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, SiteNavigationMenuItem>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			SiteNavigationMenuItem.class.getClassLoader(),
			SiteNavigationMenuItem.class, ModelWrapper.class);

		try {
			Constructor<SiteNavigationMenuItem> constructor =
				(Constructor<SiteNavigationMenuItem>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<SiteNavigationMenuItem, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<SiteNavigationMenuItem, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<SiteNavigationMenuItem, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<SiteNavigationMenuItem, Object>>();
		Map<String, BiConsumer<SiteNavigationMenuItem, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<SiteNavigationMenuItem, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion", SiteNavigationMenuItem::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<SiteNavigationMenuItem, Long>)
				SiteNavigationMenuItem::setMvccVersion);
		attributeGetterFunctions.put("uuid", SiteNavigationMenuItem::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<SiteNavigationMenuItem, String>)
				SiteNavigationMenuItem::setUuid);
		attributeGetterFunctions.put(
			"siteNavigationMenuItemId",
			SiteNavigationMenuItem::getSiteNavigationMenuItemId);
		attributeSetterBiConsumers.put(
			"siteNavigationMenuItemId",
			(BiConsumer<SiteNavigationMenuItem, Long>)
				SiteNavigationMenuItem::setSiteNavigationMenuItemId);
		attributeGetterFunctions.put(
			"groupId", SiteNavigationMenuItem::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<SiteNavigationMenuItem, Long>)
				SiteNavigationMenuItem::setGroupId);
		attributeGetterFunctions.put(
			"companyId", SiteNavigationMenuItem::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<SiteNavigationMenuItem, Long>)
				SiteNavigationMenuItem::setCompanyId);
		attributeGetterFunctions.put(
			"userId", SiteNavigationMenuItem::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<SiteNavigationMenuItem, Long>)
				SiteNavigationMenuItem::setUserId);
		attributeGetterFunctions.put(
			"userName", SiteNavigationMenuItem::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<SiteNavigationMenuItem, String>)
				SiteNavigationMenuItem::setUserName);
		attributeGetterFunctions.put(
			"createDate", SiteNavigationMenuItem::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<SiteNavigationMenuItem, Date>)
				SiteNavigationMenuItem::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", SiteNavigationMenuItem::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<SiteNavigationMenuItem, Date>)
				SiteNavigationMenuItem::setModifiedDate);
		attributeGetterFunctions.put(
			"siteNavigationMenuId",
			SiteNavigationMenuItem::getSiteNavigationMenuId);
		attributeSetterBiConsumers.put(
			"siteNavigationMenuId",
			(BiConsumer<SiteNavigationMenuItem, Long>)
				SiteNavigationMenuItem::setSiteNavigationMenuId);
		attributeGetterFunctions.put(
			"parentSiteNavigationMenuItemId",
			SiteNavigationMenuItem::getParentSiteNavigationMenuItemId);
		attributeSetterBiConsumers.put(
			"parentSiteNavigationMenuItemId",
			(BiConsumer<SiteNavigationMenuItem, Long>)
				SiteNavigationMenuItem::setParentSiteNavigationMenuItemId);
		attributeGetterFunctions.put("name", SiteNavigationMenuItem::getName);
		attributeSetterBiConsumers.put(
			"name",
			(BiConsumer<SiteNavigationMenuItem, String>)
				SiteNavigationMenuItem::setName);
		attributeGetterFunctions.put("type", SiteNavigationMenuItem::getType);
		attributeSetterBiConsumers.put(
			"type",
			(BiConsumer<SiteNavigationMenuItem, String>)
				SiteNavigationMenuItem::setType);
		attributeGetterFunctions.put(
			"typeSettings", SiteNavigationMenuItem::getTypeSettings);
		attributeSetterBiConsumers.put(
			"typeSettings",
			(BiConsumer<SiteNavigationMenuItem, String>)
				SiteNavigationMenuItem::setTypeSettings);
		attributeGetterFunctions.put("order", SiteNavigationMenuItem::getOrder);
		attributeSetterBiConsumers.put(
			"order",
			(BiConsumer<SiteNavigationMenuItem, Integer>)
				SiteNavigationMenuItem::setOrder);
		attributeGetterFunctions.put(
			"lastPublishDate", SiteNavigationMenuItem::getLastPublishDate);
		attributeSetterBiConsumers.put(
			"lastPublishDate",
			(BiConsumer<SiteNavigationMenuItem, Date>)
				SiteNavigationMenuItem::setLastPublishDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getSiteNavigationMenuItemId() {
		return _siteNavigationMenuItemId;
	}

	@Override
	public void setSiteNavigationMenuItemId(long siteNavigationMenuItemId) {
		_siteNavigationMenuItemId = siteNavigationMenuItemId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getSiteNavigationMenuId() {
		return _siteNavigationMenuId;
	}

	@Override
	public void setSiteNavigationMenuId(long siteNavigationMenuId) {
		_columnBitmask |= SITENAVIGATIONMENUID_COLUMN_BITMASK;

		if (!_setOriginalSiteNavigationMenuId) {
			_setOriginalSiteNavigationMenuId = true;

			_originalSiteNavigationMenuId = _siteNavigationMenuId;
		}

		_siteNavigationMenuId = siteNavigationMenuId;
	}

	public long getOriginalSiteNavigationMenuId() {
		return _originalSiteNavigationMenuId;
	}

	@JSON
	@Override
	public long getParentSiteNavigationMenuItemId() {
		return _parentSiteNavigationMenuItemId;
	}

	@Override
	public void setParentSiteNavigationMenuItemId(
		long parentSiteNavigationMenuItemId) {

		_columnBitmask |= PARENTSITENAVIGATIONMENUITEMID_COLUMN_BITMASK;

		if (!_setOriginalParentSiteNavigationMenuItemId) {
			_setOriginalParentSiteNavigationMenuItemId = true;

			_originalParentSiteNavigationMenuItemId =
				_parentSiteNavigationMenuItemId;
		}

		_parentSiteNavigationMenuItemId = parentSiteNavigationMenuItemId;
	}

	public long getOriginalParentSiteNavigationMenuItemId() {
		return _originalParentSiteNavigationMenuItemId;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask |= NAME_COLUMN_BITMASK;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@JSON
	@Override
	public String getType() {
		if (_type == null) {
			return "";
		}
		else {
			return _type;
		}
	}

	@Override
	public void setType(String type) {
		_type = type;
	}

	@JSON
	@Override
	public String getTypeSettings() {
		if (_typeSettings == null) {
			return "";
		}
		else {
			return _typeSettings;
		}
	}

	@Override
	public void setTypeSettings(String typeSettings) {
		_typeSettings = typeSettings;
	}

	@JSON
	@Override
	public int getOrder() {
		return _order;
	}

	@Override
	public void setOrder(int order) {
		_order = order;
	}

	@JSON
	@Override
	public Date getLastPublishDate() {
		return _lastPublishDate;
	}

	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		_lastPublishDate = lastPublishDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(SiteNavigationMenuItem.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), SiteNavigationMenuItem.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SiteNavigationMenuItem toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, SiteNavigationMenuItem>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SiteNavigationMenuItemImpl siteNavigationMenuItemImpl =
			new SiteNavigationMenuItemImpl();

		siteNavigationMenuItemImpl.setMvccVersion(getMvccVersion());
		siteNavigationMenuItemImpl.setUuid(getUuid());
		siteNavigationMenuItemImpl.setSiteNavigationMenuItemId(
			getSiteNavigationMenuItemId());
		siteNavigationMenuItemImpl.setGroupId(getGroupId());
		siteNavigationMenuItemImpl.setCompanyId(getCompanyId());
		siteNavigationMenuItemImpl.setUserId(getUserId());
		siteNavigationMenuItemImpl.setUserName(getUserName());
		siteNavigationMenuItemImpl.setCreateDate(getCreateDate());
		siteNavigationMenuItemImpl.setModifiedDate(getModifiedDate());
		siteNavigationMenuItemImpl.setSiteNavigationMenuId(
			getSiteNavigationMenuId());
		siteNavigationMenuItemImpl.setParentSiteNavigationMenuItemId(
			getParentSiteNavigationMenuItemId());
		siteNavigationMenuItemImpl.setName(getName());
		siteNavigationMenuItemImpl.setType(getType());
		siteNavigationMenuItemImpl.setTypeSettings(getTypeSettings());
		siteNavigationMenuItemImpl.setOrder(getOrder());
		siteNavigationMenuItemImpl.setLastPublishDate(getLastPublishDate());

		siteNavigationMenuItemImpl.resetOriginalValues();

		return siteNavigationMenuItemImpl;
	}

	@Override
	public int compareTo(SiteNavigationMenuItem siteNavigationMenuItem) {
		long primaryKey = siteNavigationMenuItem.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SiteNavigationMenuItem)) {
			return false;
		}

		SiteNavigationMenuItem siteNavigationMenuItem =
			(SiteNavigationMenuItem)obj;

		long primaryKey = siteNavigationMenuItem.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		SiteNavigationMenuItemModelImpl siteNavigationMenuItemModelImpl = this;

		siteNavigationMenuItemModelImpl._originalUuid =
			siteNavigationMenuItemModelImpl._uuid;

		siteNavigationMenuItemModelImpl._originalGroupId =
			siteNavigationMenuItemModelImpl._groupId;

		siteNavigationMenuItemModelImpl._setOriginalGroupId = false;

		siteNavigationMenuItemModelImpl._originalCompanyId =
			siteNavigationMenuItemModelImpl._companyId;

		siteNavigationMenuItemModelImpl._setOriginalCompanyId = false;

		siteNavigationMenuItemModelImpl._setModifiedDate = false;

		siteNavigationMenuItemModelImpl._originalSiteNavigationMenuId =
			siteNavigationMenuItemModelImpl._siteNavigationMenuId;

		siteNavigationMenuItemModelImpl._setOriginalSiteNavigationMenuId =
			false;

		siteNavigationMenuItemModelImpl.
			_originalParentSiteNavigationMenuItemId =
				siteNavigationMenuItemModelImpl._parentSiteNavigationMenuItemId;

		siteNavigationMenuItemModelImpl.
			_setOriginalParentSiteNavigationMenuItemId = false;

		siteNavigationMenuItemModelImpl._originalName =
			siteNavigationMenuItemModelImpl._name;

		siteNavigationMenuItemModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SiteNavigationMenuItem> toCacheModel() {
		SiteNavigationMenuItemCacheModel siteNavigationMenuItemCacheModel =
			new SiteNavigationMenuItemCacheModel();

		siteNavigationMenuItemCacheModel.mvccVersion = getMvccVersion();

		siteNavigationMenuItemCacheModel.uuid = getUuid();

		String uuid = siteNavigationMenuItemCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			siteNavigationMenuItemCacheModel.uuid = null;
		}

		siteNavigationMenuItemCacheModel.siteNavigationMenuItemId =
			getSiteNavigationMenuItemId();

		siteNavigationMenuItemCacheModel.groupId = getGroupId();

		siteNavigationMenuItemCacheModel.companyId = getCompanyId();

		siteNavigationMenuItemCacheModel.userId = getUserId();

		siteNavigationMenuItemCacheModel.userName = getUserName();

		String userName = siteNavigationMenuItemCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			siteNavigationMenuItemCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			siteNavigationMenuItemCacheModel.createDate = createDate.getTime();
		}
		else {
			siteNavigationMenuItemCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			siteNavigationMenuItemCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			siteNavigationMenuItemCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		siteNavigationMenuItemCacheModel.siteNavigationMenuId =
			getSiteNavigationMenuId();

		siteNavigationMenuItemCacheModel.parentSiteNavigationMenuItemId =
			getParentSiteNavigationMenuItemId();

		siteNavigationMenuItemCacheModel.name = getName();

		String name = siteNavigationMenuItemCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			siteNavigationMenuItemCacheModel.name = null;
		}

		siteNavigationMenuItemCacheModel.type = getType();

		String type = siteNavigationMenuItemCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			siteNavigationMenuItemCacheModel.type = null;
		}

		siteNavigationMenuItemCacheModel.typeSettings = getTypeSettings();

		String typeSettings = siteNavigationMenuItemCacheModel.typeSettings;

		if ((typeSettings != null) && (typeSettings.length() == 0)) {
			siteNavigationMenuItemCacheModel.typeSettings = null;
		}

		siteNavigationMenuItemCacheModel.order = getOrder();

		Date lastPublishDate = getLastPublishDate();

		if (lastPublishDate != null) {
			siteNavigationMenuItemCacheModel.lastPublishDate =
				lastPublishDate.getTime();
		}
		else {
			siteNavigationMenuItemCacheModel.lastPublishDate = Long.MIN_VALUE;
		}

		return siteNavigationMenuItemCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<SiteNavigationMenuItem, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<SiteNavigationMenuItem, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SiteNavigationMenuItem, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((SiteNavigationMenuItem)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<SiteNavigationMenuItem, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<SiteNavigationMenuItem, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SiteNavigationMenuItem, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((SiteNavigationMenuItem)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, SiteNavigationMenuItem>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _mvccVersion;
	private String _uuid;
	private String _originalUuid;
	private long _siteNavigationMenuItemId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _siteNavigationMenuId;
	private long _originalSiteNavigationMenuId;
	private boolean _setOriginalSiteNavigationMenuId;
	private long _parentSiteNavigationMenuItemId;
	private long _originalParentSiteNavigationMenuItemId;
	private boolean _setOriginalParentSiteNavigationMenuItemId;
	private String _name;
	private String _originalName;
	private String _type;
	private String _typeSettings;
	private int _order;
	private Date _lastPublishDate;
	private long _columnBitmask;
	private SiteNavigationMenuItem _escapedModel;

}