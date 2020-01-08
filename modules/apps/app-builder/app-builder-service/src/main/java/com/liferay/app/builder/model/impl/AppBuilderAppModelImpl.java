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

package com.liferay.app.builder.model.impl;

import com.liferay.app.builder.model.AppBuilderApp;
import com.liferay.app.builder.model.AppBuilderAppModel;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the AppBuilderApp service. Represents a row in the &quot;AppBuilderApp&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>AppBuilderAppModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AppBuilderAppImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AppBuilderAppImpl
 * @generated
 */
public class AppBuilderAppModelImpl
	extends BaseModelImpl<AppBuilderApp> implements AppBuilderAppModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a app builder app model instance should use the <code>AppBuilderApp</code> interface instead.
	 */
	public static final String TABLE_NAME = "AppBuilderApp";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"appBuilderAppId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"ddmStructureId", Types.BIGINT},
		{"ddmStructureLayoutId", Types.BIGINT},
		{"deDataListViewId", Types.BIGINT}, {"name", Types.VARCHAR},
		{"status", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("appBuilderAppId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("ddmStructureId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ddmStructureLayoutId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("deDataListViewId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table AppBuilderApp (uuid_ VARCHAR(75) null,appBuilderAppId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,ddmStructureId LONG,ddmStructureLayoutId LONG,deDataListViewId LONG,name STRING null,status INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table AppBuilderApp";

	public static final String ORDER_BY_JPQL =
		" ORDER BY appBuilderApp.appBuilderAppId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY AppBuilderApp.appBuilderAppId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long DDMSTRUCTUREID_COLUMN_BITMASK = 2L;

	public static final long GROUPID_COLUMN_BITMASK = 4L;

	public static final long STATUS_COLUMN_BITMASK = 8L;

	public static final long UUID_COLUMN_BITMASK = 16L;

	public static final long APPBUILDERAPPID_COLUMN_BITMASK = 32L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public AppBuilderAppModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _appBuilderAppId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAppBuilderAppId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _appBuilderAppId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return AppBuilderApp.class;
	}

	@Override
	public String getModelClassName() {
		return AppBuilderApp.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<AppBuilderApp, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<AppBuilderApp, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AppBuilderApp, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((AppBuilderApp)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<AppBuilderApp, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<AppBuilderApp, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(AppBuilderApp)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<AppBuilderApp, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<AppBuilderApp, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, AppBuilderApp>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			AppBuilderApp.class.getClassLoader(), AppBuilderApp.class,
			ModelWrapper.class);

		try {
			Constructor<AppBuilderApp> constructor =
				(Constructor<AppBuilderApp>)proxyClass.getConstructor(
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

	private static final Map<String, Function<AppBuilderApp, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<AppBuilderApp, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<AppBuilderApp, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<AppBuilderApp, Object>>();
		Map<String, BiConsumer<AppBuilderApp, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<AppBuilderApp, ?>>();

		attributeGetterFunctions.put("uuid", AppBuilderApp::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<AppBuilderApp, String>)AppBuilderApp::setUuid);
		attributeGetterFunctions.put(
			"appBuilderAppId", AppBuilderApp::getAppBuilderAppId);
		attributeSetterBiConsumers.put(
			"appBuilderAppId",
			(BiConsumer<AppBuilderApp, Long>)AppBuilderApp::setAppBuilderAppId);
		attributeGetterFunctions.put("groupId", AppBuilderApp::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<AppBuilderApp, Long>)AppBuilderApp::setGroupId);
		attributeGetterFunctions.put("companyId", AppBuilderApp::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<AppBuilderApp, Long>)AppBuilderApp::setCompanyId);
		attributeGetterFunctions.put("userId", AppBuilderApp::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<AppBuilderApp, Long>)AppBuilderApp::setUserId);
		attributeGetterFunctions.put("userName", AppBuilderApp::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<AppBuilderApp, String>)AppBuilderApp::setUserName);
		attributeGetterFunctions.put(
			"createDate", AppBuilderApp::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<AppBuilderApp, Date>)AppBuilderApp::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", AppBuilderApp::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<AppBuilderApp, Date>)AppBuilderApp::setModifiedDate);
		attributeGetterFunctions.put(
			"ddmStructureId", AppBuilderApp::getDdmStructureId);
		attributeSetterBiConsumers.put(
			"ddmStructureId",
			(BiConsumer<AppBuilderApp, Long>)AppBuilderApp::setDdmStructureId);
		attributeGetterFunctions.put(
			"ddmStructureLayoutId", AppBuilderApp::getDdmStructureLayoutId);
		attributeSetterBiConsumers.put(
			"ddmStructureLayoutId",
			(BiConsumer<AppBuilderApp, Long>)
				AppBuilderApp::setDdmStructureLayoutId);
		attributeGetterFunctions.put(
			"deDataListViewId", AppBuilderApp::getDeDataListViewId);
		attributeSetterBiConsumers.put(
			"deDataListViewId",
			(BiConsumer<AppBuilderApp, Long>)
				AppBuilderApp::setDeDataListViewId);
		attributeGetterFunctions.put("name", AppBuilderApp::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<AppBuilderApp, String>)AppBuilderApp::setName);
		attributeGetterFunctions.put("status", AppBuilderApp::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<AppBuilderApp, Integer>)AppBuilderApp::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

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

	@Override
	public long getAppBuilderAppId() {
		return _appBuilderAppId;
	}

	@Override
	public void setAppBuilderAppId(long appBuilderAppId) {
		_appBuilderAppId = appBuilderAppId;
	}

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

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

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

	@Override
	public long getDdmStructureId() {
		return _ddmStructureId;
	}

	@Override
	public void setDdmStructureId(long ddmStructureId) {
		_columnBitmask |= DDMSTRUCTUREID_COLUMN_BITMASK;

		if (!_setOriginalDdmStructureId) {
			_setOriginalDdmStructureId = true;

			_originalDdmStructureId = _ddmStructureId;
		}

		_ddmStructureId = ddmStructureId;
	}

	public long getOriginalDdmStructureId() {
		return _originalDdmStructureId;
	}

	@Override
	public long getDdmStructureLayoutId() {
		return _ddmStructureLayoutId;
	}

	@Override
	public void setDdmStructureLayoutId(long ddmStructureLayoutId) {
		_ddmStructureLayoutId = ddmStructureLayoutId;
	}

	@Override
	public long getDeDataListViewId() {
		return _deDataListViewId;
	}

	@Override
	public void setDeDataListViewId(long deDataListViewId) {
		_deDataListViewId = deDataListViewId;
	}

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
	public String getName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId);
	}

	@Override
	public String getName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId, useDefault);
	}

	@Override
	public String getName(String languageId) {
		return LocalizationUtil.getLocalization(getName(), languageId);
	}

	@Override
	public String getName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(
			getName(), languageId, useDefault);
	}

	@Override
	public String getNameCurrentLanguageId() {
		return _nameCurrentLanguageId;
	}

	@JSON
	@Override
	public String getNameCurrentValue() {
		Locale locale = getLocale(_nameCurrentLanguageId);

		return getName(locale);
	}

	@Override
	public Map<Locale, String> getNameMap() {
		return LocalizationUtil.getLocalizationMap(getName());
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@Override
	public void setName(String name, Locale locale) {
		setName(name, locale, LocaleUtil.getSiteDefault());
	}

	@Override
	public void setName(String name, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(name)) {
			setName(
				LocalizationUtil.updateLocalization(
					getName(), "Name", name, languageId, defaultLanguageId));
		}
		else {
			setName(
				LocalizationUtil.removeLocalization(
					getName(), "Name", languageId));
		}
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		_nameCurrentLanguageId = languageId;
	}

	@Override
	public void setNameMap(Map<Locale, String> nameMap) {
		setNameMap(nameMap, LocaleUtil.getSiteDefault());
	}

	@Override
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale) {
		if (nameMap == null) {
			return;
		}

		setName(
			LocalizationUtil.updateLocalization(
				nameMap, getName(), "Name",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(AppBuilderApp.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), AppBuilderApp.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> nameMap = getNameMap();

		for (Map.Entry<Locale, String> entry : nameMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(
			new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getName();

		if (xml == null) {
			return "";
		}

		Locale defaultLocale = LocaleUtil.getSiteDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		Locale defaultLocale = LocaleUtil.fromLanguageId(
			getDefaultLanguageId());

		Locale[] availableLocales = LocaleUtil.fromLanguageIds(
			getAvailableLanguageIds());

		Locale defaultImportLocale = LocalizationUtil.getDefaultImportLocale(
			AppBuilderApp.class.getName(), getPrimaryKey(), defaultLocale,
			availableLocales);

		prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {

		Locale defaultLocale = LocaleUtil.getSiteDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String name = getName(defaultLocale);

		if (Validator.isNull(name)) {
			setName(getName(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setName(getName(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public AppBuilderApp toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, AppBuilderApp>
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
		AppBuilderAppImpl appBuilderAppImpl = new AppBuilderAppImpl();

		appBuilderAppImpl.setUuid(getUuid());
		appBuilderAppImpl.setAppBuilderAppId(getAppBuilderAppId());
		appBuilderAppImpl.setGroupId(getGroupId());
		appBuilderAppImpl.setCompanyId(getCompanyId());
		appBuilderAppImpl.setUserId(getUserId());
		appBuilderAppImpl.setUserName(getUserName());
		appBuilderAppImpl.setCreateDate(getCreateDate());
		appBuilderAppImpl.setModifiedDate(getModifiedDate());
		appBuilderAppImpl.setDdmStructureId(getDdmStructureId());
		appBuilderAppImpl.setDdmStructureLayoutId(getDdmStructureLayoutId());
		appBuilderAppImpl.setDeDataListViewId(getDeDataListViewId());
		appBuilderAppImpl.setName(getName());
		appBuilderAppImpl.setStatus(getStatus());

		appBuilderAppImpl.resetOriginalValues();

		return appBuilderAppImpl;
	}

	@Override
	public int compareTo(AppBuilderApp appBuilderApp) {
		long primaryKey = appBuilderApp.getPrimaryKey();

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

		if (!(obj instanceof AppBuilderApp)) {
			return false;
		}

		AppBuilderApp appBuilderApp = (AppBuilderApp)obj;

		long primaryKey = appBuilderApp.getPrimaryKey();

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
		AppBuilderAppModelImpl appBuilderAppModelImpl = this;

		appBuilderAppModelImpl._originalUuid = appBuilderAppModelImpl._uuid;

		appBuilderAppModelImpl._originalGroupId =
			appBuilderAppModelImpl._groupId;

		appBuilderAppModelImpl._setOriginalGroupId = false;

		appBuilderAppModelImpl._originalCompanyId =
			appBuilderAppModelImpl._companyId;

		appBuilderAppModelImpl._setOriginalCompanyId = false;

		appBuilderAppModelImpl._setModifiedDate = false;

		appBuilderAppModelImpl._originalDdmStructureId =
			appBuilderAppModelImpl._ddmStructureId;

		appBuilderAppModelImpl._setOriginalDdmStructureId = false;

		appBuilderAppModelImpl._originalStatus = appBuilderAppModelImpl._status;

		appBuilderAppModelImpl._setOriginalStatus = false;

		appBuilderAppModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<AppBuilderApp> toCacheModel() {
		AppBuilderAppCacheModel appBuilderAppCacheModel =
			new AppBuilderAppCacheModel();

		appBuilderAppCacheModel.uuid = getUuid();

		String uuid = appBuilderAppCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			appBuilderAppCacheModel.uuid = null;
		}

		appBuilderAppCacheModel.appBuilderAppId = getAppBuilderAppId();

		appBuilderAppCacheModel.groupId = getGroupId();

		appBuilderAppCacheModel.companyId = getCompanyId();

		appBuilderAppCacheModel.userId = getUserId();

		appBuilderAppCacheModel.userName = getUserName();

		String userName = appBuilderAppCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			appBuilderAppCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			appBuilderAppCacheModel.createDate = createDate.getTime();
		}
		else {
			appBuilderAppCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			appBuilderAppCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			appBuilderAppCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		appBuilderAppCacheModel.ddmStructureId = getDdmStructureId();

		appBuilderAppCacheModel.ddmStructureLayoutId =
			getDdmStructureLayoutId();

		appBuilderAppCacheModel.deDataListViewId = getDeDataListViewId();

		appBuilderAppCacheModel.name = getName();

		String name = appBuilderAppCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			appBuilderAppCacheModel.name = null;
		}

		appBuilderAppCacheModel.status = getStatus();

		return appBuilderAppCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<AppBuilderApp, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<AppBuilderApp, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AppBuilderApp, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((AppBuilderApp)this));
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
		Map<String, Function<AppBuilderApp, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<AppBuilderApp, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AppBuilderApp, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((AppBuilderApp)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, AppBuilderApp>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private String _uuid;
	private String _originalUuid;
	private long _appBuilderAppId;
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
	private long _ddmStructureId;
	private long _originalDdmStructureId;
	private boolean _setOriginalDdmStructureId;
	private long _ddmStructureLayoutId;
	private long _deDataListViewId;
	private String _name;
	private String _nameCurrentLanguageId;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _columnBitmask;
	private AppBuilderApp _escapedModel;

}