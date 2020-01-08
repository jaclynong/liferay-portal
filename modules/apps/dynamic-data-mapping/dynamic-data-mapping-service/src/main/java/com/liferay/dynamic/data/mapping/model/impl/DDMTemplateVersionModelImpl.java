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

package com.liferay.dynamic.data.mapping.model.impl;

import com.liferay.dynamic.data.mapping.model.DDMTemplateVersion;
import com.liferay.dynamic.data.mapping.model.DDMTemplateVersionModel;
import com.liferay.dynamic.data.mapping.model.DDMTemplateVersionSoap;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
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
import com.liferay.portal.kernel.workflow.WorkflowConstants;

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
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the DDMTemplateVersion service. Represents a row in the &quot;DDMTemplateVersion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DDMTemplateVersionModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DDMTemplateVersionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DDMTemplateVersionImpl
 * @generated
 */
@JSON(strict = true)
public class DDMTemplateVersionModelImpl
	extends BaseModelImpl<DDMTemplateVersion>
	implements DDMTemplateVersionModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ddm template version model instance should use the <code>DDMTemplateVersion</code> interface instead.
	 */
	public static final String TABLE_NAME = "DDMTemplateVersion";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"ctCollectionId", Types.BIGINT},
		{"templateVersionId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"classNameId", Types.BIGINT}, {"classPK", Types.BIGINT},
		{"templateId", Types.BIGINT}, {"version", Types.VARCHAR},
		{"name", Types.CLOB}, {"description", Types.CLOB},
		{"language", Types.VARCHAR}, {"script", Types.CLOB},
		{"status", Types.INTEGER}, {"statusByUserId", Types.BIGINT},
		{"statusByUserName", Types.VARCHAR}, {"statusDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ctCollectionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("templateVersionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("classNameId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("classPK", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("templateId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("version", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("name", Types.CLOB);
		TABLE_COLUMNS_MAP.put("description", Types.CLOB);
		TABLE_COLUMNS_MAP.put("language", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("script", Types.CLOB);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("statusByUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statusByUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table DDMTemplateVersion (mvccVersion LONG default 0 not null,ctCollectionId LONG default 0 not null,templateVersionId LONG not null,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,classNameId LONG,classPK LONG,templateId LONG,version VARCHAR(75) null,name TEXT null,description TEXT null,language VARCHAR(75) null,script TEXT null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,primary key (templateVersionId, ctCollectionId))";

	public static final String TABLE_SQL_DROP = "drop table DDMTemplateVersion";

	public static final String ORDER_BY_JPQL =
		" ORDER BY ddmTemplateVersion.templateVersionId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY DDMTemplateVersion.templateVersionId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long STATUS_COLUMN_BITMASK = 1L;

	public static final long TEMPLATEID_COLUMN_BITMASK = 2L;

	public static final long VERSION_COLUMN_BITMASK = 4L;

	public static final long TEMPLATEVERSIONID_COLUMN_BITMASK = 8L;

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
	public static DDMTemplateVersion toModel(DDMTemplateVersionSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		DDMTemplateVersion model = new DDMTemplateVersionImpl();

		model.setMvccVersion(soapModel.getMvccVersion());
		model.setCtCollectionId(soapModel.getCtCollectionId());
		model.setTemplateVersionId(soapModel.getTemplateVersionId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setClassNameId(soapModel.getClassNameId());
		model.setClassPK(soapModel.getClassPK());
		model.setTemplateId(soapModel.getTemplateId());
		model.setVersion(soapModel.getVersion());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setLanguage(soapModel.getLanguage());
		model.setScript(soapModel.getScript());
		model.setStatus(soapModel.getStatus());
		model.setStatusByUserId(soapModel.getStatusByUserId());
		model.setStatusByUserName(soapModel.getStatusByUserName());
		model.setStatusDate(soapModel.getStatusDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<DDMTemplateVersion> toModels(
		DDMTemplateVersionSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<DDMTemplateVersion> models = new ArrayList<DDMTemplateVersion>(
			soapModels.length);

		for (DDMTemplateVersionSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public DDMTemplateVersionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _templateVersionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTemplateVersionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _templateVersionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DDMTemplateVersion.class;
	}

	@Override
	public String getModelClassName() {
		return DDMTemplateVersion.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DDMTemplateVersion, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DDMTemplateVersion, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DDMTemplateVersion, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((DDMTemplateVersion)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DDMTemplateVersion, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DDMTemplateVersion, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DDMTemplateVersion)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DDMTemplateVersion, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DDMTemplateVersion, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, DDMTemplateVersion>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			DDMTemplateVersion.class.getClassLoader(), DDMTemplateVersion.class,
			ModelWrapper.class);

		try {
			Constructor<DDMTemplateVersion> constructor =
				(Constructor<DDMTemplateVersion>)proxyClass.getConstructor(
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

	private static final Map<String, Function<DDMTemplateVersion, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<DDMTemplateVersion, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<DDMTemplateVersion, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<DDMTemplateVersion, Object>>();
		Map<String, BiConsumer<DDMTemplateVersion, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<DDMTemplateVersion, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion", DDMTemplateVersion::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<DDMTemplateVersion, Long>)
				DDMTemplateVersion::setMvccVersion);
		attributeGetterFunctions.put(
			"ctCollectionId", DDMTemplateVersion::getCtCollectionId);
		attributeSetterBiConsumers.put(
			"ctCollectionId",
			(BiConsumer<DDMTemplateVersion, Long>)
				DDMTemplateVersion::setCtCollectionId);
		attributeGetterFunctions.put(
			"templateVersionId", DDMTemplateVersion::getTemplateVersionId);
		attributeSetterBiConsumers.put(
			"templateVersionId",
			(BiConsumer<DDMTemplateVersion, Long>)
				DDMTemplateVersion::setTemplateVersionId);
		attributeGetterFunctions.put("groupId", DDMTemplateVersion::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<DDMTemplateVersion, Long>)
				DDMTemplateVersion::setGroupId);
		attributeGetterFunctions.put(
			"companyId", DDMTemplateVersion::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<DDMTemplateVersion, Long>)
				DDMTemplateVersion::setCompanyId);
		attributeGetterFunctions.put("userId", DDMTemplateVersion::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<DDMTemplateVersion, Long>)
				DDMTemplateVersion::setUserId);
		attributeGetterFunctions.put(
			"userName", DDMTemplateVersion::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<DDMTemplateVersion, String>)
				DDMTemplateVersion::setUserName);
		attributeGetterFunctions.put(
			"createDate", DDMTemplateVersion::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<DDMTemplateVersion, Date>)
				DDMTemplateVersion::setCreateDate);
		attributeGetterFunctions.put(
			"classNameId", DDMTemplateVersion::getClassNameId);
		attributeSetterBiConsumers.put(
			"classNameId",
			(BiConsumer<DDMTemplateVersion, Long>)
				DDMTemplateVersion::setClassNameId);
		attributeGetterFunctions.put("classPK", DDMTemplateVersion::getClassPK);
		attributeSetterBiConsumers.put(
			"classPK",
			(BiConsumer<DDMTemplateVersion, Long>)
				DDMTemplateVersion::setClassPK);
		attributeGetterFunctions.put(
			"templateId", DDMTemplateVersion::getTemplateId);
		attributeSetterBiConsumers.put(
			"templateId",
			(BiConsumer<DDMTemplateVersion, Long>)
				DDMTemplateVersion::setTemplateId);
		attributeGetterFunctions.put("version", DDMTemplateVersion::getVersion);
		attributeSetterBiConsumers.put(
			"version",
			(BiConsumer<DDMTemplateVersion, String>)
				DDMTemplateVersion::setVersion);
		attributeGetterFunctions.put("name", DDMTemplateVersion::getName);
		attributeSetterBiConsumers.put(
			"name",
			(BiConsumer<DDMTemplateVersion, String>)
				DDMTemplateVersion::setName);
		attributeGetterFunctions.put(
			"description", DDMTemplateVersion::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<DDMTemplateVersion, String>)
				DDMTemplateVersion::setDescription);
		attributeGetterFunctions.put(
			"language", DDMTemplateVersion::getLanguage);
		attributeSetterBiConsumers.put(
			"language",
			(BiConsumer<DDMTemplateVersion, String>)
				DDMTemplateVersion::setLanguage);
		attributeGetterFunctions.put("script", DDMTemplateVersion::getScript);
		attributeSetterBiConsumers.put(
			"script",
			(BiConsumer<DDMTemplateVersion, String>)
				DDMTemplateVersion::setScript);
		attributeGetterFunctions.put("status", DDMTemplateVersion::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<DDMTemplateVersion, Integer>)
				DDMTemplateVersion::setStatus);
		attributeGetterFunctions.put(
			"statusByUserId", DDMTemplateVersion::getStatusByUserId);
		attributeSetterBiConsumers.put(
			"statusByUserId",
			(BiConsumer<DDMTemplateVersion, Long>)
				DDMTemplateVersion::setStatusByUserId);
		attributeGetterFunctions.put(
			"statusByUserName", DDMTemplateVersion::getStatusByUserName);
		attributeSetterBiConsumers.put(
			"statusByUserName",
			(BiConsumer<DDMTemplateVersion, String>)
				DDMTemplateVersion::setStatusByUserName);
		attributeGetterFunctions.put(
			"statusDate", DDMTemplateVersion::getStatusDate);
		attributeSetterBiConsumers.put(
			"statusDate",
			(BiConsumer<DDMTemplateVersion, Date>)
				DDMTemplateVersion::setStatusDate);

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
	public long getCtCollectionId() {
		return _ctCollectionId;
	}

	@Override
	public void setCtCollectionId(long ctCollectionId) {
		_ctCollectionId = ctCollectionId;
	}

	@JSON
	@Override
	public long getTemplateVersionId() {
		return _templateVersionId;
	}

	@Override
	public void setTemplateVersionId(long templateVersionId) {
		_templateVersionId = templateVersionId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	@Override
	public String getClassName() {
		if (getClassNameId() <= 0) {
			return "";
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@Override
	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@JSON
	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;
	}

	@JSON
	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	@JSON
	@Override
	public long getTemplateId() {
		return _templateId;
	}

	@Override
	public void setTemplateId(long templateId) {
		_columnBitmask |= TEMPLATEID_COLUMN_BITMASK;

		if (!_setOriginalTemplateId) {
			_setOriginalTemplateId = true;

			_originalTemplateId = _templateId;
		}

		_templateId = templateId;
	}

	public long getOriginalTemplateId() {
		return _originalTemplateId;
	}

	@JSON
	@Override
	public String getVersion() {
		if (_version == null) {
			return "";
		}
		else {
			return _version;
		}
	}

	@Override
	public void setVersion(String version) {
		_columnBitmask |= VERSION_COLUMN_BITMASK;

		if (_originalVersion == null) {
			_originalVersion = _version;
		}

		_version = version;
	}

	public String getOriginalVersion() {
		return GetterUtil.getString(_originalVersion);
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
		setName(name, locale, LocaleUtil.getDefault());
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
		setNameMap(nameMap, LocaleUtil.getDefault());
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

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public String getDescription(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId);
	}

	@Override
	public String getDescription(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId, useDefault);
	}

	@Override
	public String getDescription(String languageId) {
		return LocalizationUtil.getLocalization(getDescription(), languageId);
	}

	@Override
	public String getDescription(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(
			getDescription(), languageId, useDefault);
	}

	@Override
	public String getDescriptionCurrentLanguageId() {
		return _descriptionCurrentLanguageId;
	}

	@JSON
	@Override
	public String getDescriptionCurrentValue() {
		Locale locale = getLocale(_descriptionCurrentLanguageId);

		return getDescription(locale);
	}

	@Override
	public Map<Locale, String> getDescriptionMap() {
		return LocalizationUtil.getLocalizationMap(getDescription());
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public void setDescription(String description, Locale locale) {
		setDescription(description, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setDescription(
		String description, Locale locale, Locale defaultLocale) {

		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(description)) {
			setDescription(
				LocalizationUtil.updateLocalization(
					getDescription(), "Description", description, languageId,
					defaultLanguageId));
		}
		else {
			setDescription(
				LocalizationUtil.removeLocalization(
					getDescription(), "Description", languageId));
		}
	}

	@Override
	public void setDescriptionCurrentLanguageId(String languageId) {
		_descriptionCurrentLanguageId = languageId;
	}

	@Override
	public void setDescriptionMap(Map<Locale, String> descriptionMap) {
		setDescriptionMap(descriptionMap, LocaleUtil.getDefault());
	}

	@Override
	public void setDescriptionMap(
		Map<Locale, String> descriptionMap, Locale defaultLocale) {

		if (descriptionMap == null) {
			return;
		}

		setDescription(
			LocalizationUtil.updateLocalization(
				descriptionMap, getDescription(), "Description",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@JSON
	@Override
	public String getLanguage() {
		if (_language == null) {
			return "";
		}
		else {
			return _language;
		}
	}

	@Override
	public void setLanguage(String language) {
		_language = language;
	}

	@JSON
	@Override
	public String getScript() {
		if (_script == null) {
			return "";
		}
		else {
			return _script;
		}
	}

	@Override
	public void setScript(String script) {
		_script = script;
	}

	@JSON
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

	@JSON
	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatusByUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
	}

	@JSON
	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return "";
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	@JSON
	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), DDMTemplateVersion.class.getName(),
			getPrimaryKey());
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

		Map<Locale, String> descriptionMap = getDescriptionMap();

		for (Map.Entry<Locale, String> entry : descriptionMap.entrySet()) {
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

		Locale defaultLocale = LocaleUtil.getDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		Locale defaultLocale = LocaleUtil.fromLanguageId(
			getDefaultLanguageId());

		Locale[] availableLocales = LocaleUtil.fromLanguageIds(
			getAvailableLanguageIds());

		Locale defaultImportLocale = LocalizationUtil.getDefaultImportLocale(
			DDMTemplateVersion.class.getName(), getPrimaryKey(), defaultLocale,
			availableLocales);

		prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {

		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String name = getName(defaultLocale);

		if (Validator.isNull(name)) {
			setName(getName(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setName(getName(defaultLocale), defaultLocale, defaultLocale);
		}

		String description = getDescription(defaultLocale);

		if (Validator.isNull(description)) {
			setDescription(
				getDescription(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setDescription(
				getDescription(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public DDMTemplateVersion toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, DDMTemplateVersion>
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
		DDMTemplateVersionImpl ddmTemplateVersionImpl =
			new DDMTemplateVersionImpl();

		ddmTemplateVersionImpl.setMvccVersion(getMvccVersion());
		ddmTemplateVersionImpl.setCtCollectionId(getCtCollectionId());
		ddmTemplateVersionImpl.setTemplateVersionId(getTemplateVersionId());
		ddmTemplateVersionImpl.setGroupId(getGroupId());
		ddmTemplateVersionImpl.setCompanyId(getCompanyId());
		ddmTemplateVersionImpl.setUserId(getUserId());
		ddmTemplateVersionImpl.setUserName(getUserName());
		ddmTemplateVersionImpl.setCreateDate(getCreateDate());
		ddmTemplateVersionImpl.setClassNameId(getClassNameId());
		ddmTemplateVersionImpl.setClassPK(getClassPK());
		ddmTemplateVersionImpl.setTemplateId(getTemplateId());
		ddmTemplateVersionImpl.setVersion(getVersion());
		ddmTemplateVersionImpl.setName(getName());
		ddmTemplateVersionImpl.setDescription(getDescription());
		ddmTemplateVersionImpl.setLanguage(getLanguage());
		ddmTemplateVersionImpl.setScript(getScript());
		ddmTemplateVersionImpl.setStatus(getStatus());
		ddmTemplateVersionImpl.setStatusByUserId(getStatusByUserId());
		ddmTemplateVersionImpl.setStatusByUserName(getStatusByUserName());
		ddmTemplateVersionImpl.setStatusDate(getStatusDate());

		ddmTemplateVersionImpl.resetOriginalValues();

		return ddmTemplateVersionImpl;
	}

	@Override
	public int compareTo(DDMTemplateVersion ddmTemplateVersion) {
		long primaryKey = ddmTemplateVersion.getPrimaryKey();

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

		if (!(obj instanceof DDMTemplateVersion)) {
			return false;
		}

		DDMTemplateVersion ddmTemplateVersion = (DDMTemplateVersion)obj;

		long primaryKey = ddmTemplateVersion.getPrimaryKey();

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
		DDMTemplateVersionModelImpl ddmTemplateVersionModelImpl = this;

		ddmTemplateVersionModelImpl._originalTemplateId =
			ddmTemplateVersionModelImpl._templateId;

		ddmTemplateVersionModelImpl._setOriginalTemplateId = false;

		ddmTemplateVersionModelImpl._originalVersion =
			ddmTemplateVersionModelImpl._version;

		ddmTemplateVersionModelImpl._originalStatus =
			ddmTemplateVersionModelImpl._status;

		ddmTemplateVersionModelImpl._setOriginalStatus = false;

		ddmTemplateVersionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DDMTemplateVersion> toCacheModel() {
		DDMTemplateVersionCacheModel ddmTemplateVersionCacheModel =
			new DDMTemplateVersionCacheModel();

		ddmTemplateVersionCacheModel.mvccVersion = getMvccVersion();

		ddmTemplateVersionCacheModel.ctCollectionId = getCtCollectionId();

		ddmTemplateVersionCacheModel.templateVersionId = getTemplateVersionId();

		ddmTemplateVersionCacheModel.groupId = getGroupId();

		ddmTemplateVersionCacheModel.companyId = getCompanyId();

		ddmTemplateVersionCacheModel.userId = getUserId();

		ddmTemplateVersionCacheModel.userName = getUserName();

		String userName = ddmTemplateVersionCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			ddmTemplateVersionCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			ddmTemplateVersionCacheModel.createDate = createDate.getTime();
		}
		else {
			ddmTemplateVersionCacheModel.createDate = Long.MIN_VALUE;
		}

		ddmTemplateVersionCacheModel.classNameId = getClassNameId();

		ddmTemplateVersionCacheModel.classPK = getClassPK();

		ddmTemplateVersionCacheModel.templateId = getTemplateId();

		ddmTemplateVersionCacheModel.version = getVersion();

		String version = ddmTemplateVersionCacheModel.version;

		if ((version != null) && (version.length() == 0)) {
			ddmTemplateVersionCacheModel.version = null;
		}

		ddmTemplateVersionCacheModel.name = getName();

		String name = ddmTemplateVersionCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			ddmTemplateVersionCacheModel.name = null;
		}

		ddmTemplateVersionCacheModel.description = getDescription();

		String description = ddmTemplateVersionCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			ddmTemplateVersionCacheModel.description = null;
		}

		ddmTemplateVersionCacheModel.language = getLanguage();

		String language = ddmTemplateVersionCacheModel.language;

		if ((language != null) && (language.length() == 0)) {
			ddmTemplateVersionCacheModel.language = null;
		}

		ddmTemplateVersionCacheModel.script = getScript();

		String script = ddmTemplateVersionCacheModel.script;

		if ((script != null) && (script.length() == 0)) {
			ddmTemplateVersionCacheModel.script = null;
		}

		ddmTemplateVersionCacheModel.status = getStatus();

		ddmTemplateVersionCacheModel.statusByUserId = getStatusByUserId();

		ddmTemplateVersionCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = ddmTemplateVersionCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			ddmTemplateVersionCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			ddmTemplateVersionCacheModel.statusDate = statusDate.getTime();
		}
		else {
			ddmTemplateVersionCacheModel.statusDate = Long.MIN_VALUE;
		}

		return ddmTemplateVersionCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DDMTemplateVersion, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DDMTemplateVersion, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DDMTemplateVersion, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((DDMTemplateVersion)this));
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
		Map<String, Function<DDMTemplateVersion, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<DDMTemplateVersion, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DDMTemplateVersion, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((DDMTemplateVersion)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, DDMTemplateVersion>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _mvccVersion;
	private long _ctCollectionId;
	private long _templateVersionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private long _classNameId;
	private long _classPK;
	private long _templateId;
	private long _originalTemplateId;
	private boolean _setOriginalTemplateId;
	private String _version;
	private String _originalVersion;
	private String _name;
	private String _nameCurrentLanguageId;
	private String _description;
	private String _descriptionCurrentLanguageId;
	private String _language;
	private String _script;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private long _columnBitmask;
	private DDMTemplateVersion _escapedModel;

}