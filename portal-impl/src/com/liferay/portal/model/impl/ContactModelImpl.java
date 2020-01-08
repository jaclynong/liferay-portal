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

package com.liferay.portal.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.ContactModel;
import com.liferay.portal.kernel.model.ContactSoap;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.Validator;

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
 * The base model implementation for the Contact service. Represents a row in the &quot;Contact_&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ContactModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ContactImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactImpl
 * @generated
 */
@JSON(strict = true)
public class ContactModelImpl
	extends BaseModelImpl<Contact> implements ContactModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a contact model instance should use the <code>Contact</code> interface instead.
	 */
	public static final String TABLE_NAME = "Contact_";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"contactId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"classNameId", Types.BIGINT},
		{"classPK", Types.BIGINT}, {"accountId", Types.BIGINT},
		{"parentContactId", Types.BIGINT}, {"emailAddress", Types.VARCHAR},
		{"firstName", Types.VARCHAR}, {"middleName", Types.VARCHAR},
		{"lastName", Types.VARCHAR}, {"prefixId", Types.BIGINT},
		{"suffixId", Types.BIGINT}, {"male", Types.BOOLEAN},
		{"birthday", Types.TIMESTAMP}, {"smsSn", Types.VARCHAR},
		{"facebookSn", Types.VARCHAR}, {"jabberSn", Types.VARCHAR},
		{"skypeSn", Types.VARCHAR}, {"twitterSn", Types.VARCHAR},
		{"employeeStatusId", Types.VARCHAR}, {"employeeNumber", Types.VARCHAR},
		{"jobTitle", Types.VARCHAR}, {"jobClass", Types.VARCHAR},
		{"hoursOfOperation", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("contactId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("classNameId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("classPK", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("accountId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("parentContactId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("emailAddress", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("firstName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("middleName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lastName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("prefixId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("suffixId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("male", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("birthday", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("smsSn", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("facebookSn", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("jabberSn", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("skypeSn", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("twitterSn", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("employeeStatusId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("employeeNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("jobTitle", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("jobClass", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("hoursOfOperation", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Contact_ (mvccVersion LONG default 0 not null,contactId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,classNameId LONG,classPK LONG,accountId LONG,parentContactId LONG,emailAddress VARCHAR(254) null,firstName VARCHAR(75) null,middleName VARCHAR(75) null,lastName VARCHAR(75) null,prefixId LONG,suffixId LONG,male BOOLEAN,birthday DATE null,smsSn VARCHAR(75) null,facebookSn VARCHAR(75) null,jabberSn VARCHAR(75) null,skypeSn VARCHAR(75) null,twitterSn VARCHAR(75) null,employeeStatusId VARCHAR(75) null,employeeNumber VARCHAR(75) null,jobTitle VARCHAR(100) null,jobClass VARCHAR(75) null,hoursOfOperation VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table Contact_";

	public static final String ORDER_BY_JPQL =
		" ORDER BY contact.contactId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Contact_.contactId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.entity.cache.enabled.com.liferay.portal.kernel.model.Contact"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.finder.cache.enabled.com.liferay.portal.kernel.model.Contact"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.com.liferay.portal.kernel.model.Contact"),
		true);

	public static final long ACCOUNTID_COLUMN_BITMASK = 1L;

	public static final long CLASSNAMEID_COLUMN_BITMASK = 2L;

	public static final long CLASSPK_COLUMN_BITMASK = 4L;

	public static final long COMPANYID_COLUMN_BITMASK = 8L;

	public static final long CONTACTID_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Contact toModel(ContactSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Contact model = new ContactImpl();

		model.setMvccVersion(soapModel.getMvccVersion());
		model.setContactId(soapModel.getContactId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setClassNameId(soapModel.getClassNameId());
		model.setClassPK(soapModel.getClassPK());
		model.setAccountId(soapModel.getAccountId());
		model.setParentContactId(soapModel.getParentContactId());
		model.setEmailAddress(soapModel.getEmailAddress());
		model.setFirstName(soapModel.getFirstName());
		model.setMiddleName(soapModel.getMiddleName());
		model.setLastName(soapModel.getLastName());
		model.setPrefixId(soapModel.getPrefixId());
		model.setSuffixId(soapModel.getSuffixId());
		model.setMale(soapModel.isMale());
		model.setBirthday(soapModel.getBirthday());
		model.setSmsSn(soapModel.getSmsSn());
		model.setFacebookSn(soapModel.getFacebookSn());
		model.setJabberSn(soapModel.getJabberSn());
		model.setSkypeSn(soapModel.getSkypeSn());
		model.setTwitterSn(soapModel.getTwitterSn());
		model.setEmployeeStatusId(soapModel.getEmployeeStatusId());
		model.setEmployeeNumber(soapModel.getEmployeeNumber());
		model.setJobTitle(soapModel.getJobTitle());
		model.setJobClass(soapModel.getJobClass());
		model.setHoursOfOperation(soapModel.getHoursOfOperation());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Contact> toModels(ContactSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Contact> models = new ArrayList<Contact>(soapModels.length);

		for (ContactSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.util.PropsUtil.get(
			"lock.expiration.time.com.liferay.portal.kernel.model.Contact"));

	public ContactModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _contactId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setContactId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _contactId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Contact.class;
	}

	@Override
	public String getModelClassName() {
		return Contact.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Contact, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Contact, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Contact, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Contact)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Contact, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Contact, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Contact)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Contact, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Contact, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Contact>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Contact.class.getClassLoader(), Contact.class, ModelWrapper.class);

		try {
			Constructor<Contact> constructor =
				(Constructor<Contact>)proxyClass.getConstructor(
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

	private static final Map<String, Function<Contact, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Contact, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Contact, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Contact, Object>>();
		Map<String, BiConsumer<Contact, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Contact, ?>>();

		attributeGetterFunctions.put("mvccVersion", Contact::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion", (BiConsumer<Contact, Long>)Contact::setMvccVersion);
		attributeGetterFunctions.put("contactId", Contact::getContactId);
		attributeSetterBiConsumers.put(
			"contactId", (BiConsumer<Contact, Long>)Contact::setContactId);
		attributeGetterFunctions.put("companyId", Contact::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Contact, Long>)Contact::setCompanyId);
		attributeGetterFunctions.put("userId", Contact::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Contact, Long>)Contact::setUserId);
		attributeGetterFunctions.put("userName", Contact::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<Contact, String>)Contact::setUserName);
		attributeGetterFunctions.put("createDate", Contact::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Contact, Date>)Contact::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", Contact::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<Contact, Date>)Contact::setModifiedDate);
		attributeGetterFunctions.put("classNameId", Contact::getClassNameId);
		attributeSetterBiConsumers.put(
			"classNameId", (BiConsumer<Contact, Long>)Contact::setClassNameId);
		attributeGetterFunctions.put("classPK", Contact::getClassPK);
		attributeSetterBiConsumers.put(
			"classPK", (BiConsumer<Contact, Long>)Contact::setClassPK);
		attributeGetterFunctions.put("accountId", Contact::getAccountId);
		attributeSetterBiConsumers.put(
			"accountId", (BiConsumer<Contact, Long>)Contact::setAccountId);
		attributeGetterFunctions.put(
			"parentContactId", Contact::getParentContactId);
		attributeSetterBiConsumers.put(
			"parentContactId",
			(BiConsumer<Contact, Long>)Contact::setParentContactId);
		attributeGetterFunctions.put("emailAddress", Contact::getEmailAddress);
		attributeSetterBiConsumers.put(
			"emailAddress",
			(BiConsumer<Contact, String>)Contact::setEmailAddress);
		attributeGetterFunctions.put("firstName", Contact::getFirstName);
		attributeSetterBiConsumers.put(
			"firstName", (BiConsumer<Contact, String>)Contact::setFirstName);
		attributeGetterFunctions.put("middleName", Contact::getMiddleName);
		attributeSetterBiConsumers.put(
			"middleName", (BiConsumer<Contact, String>)Contact::setMiddleName);
		attributeGetterFunctions.put("lastName", Contact::getLastName);
		attributeSetterBiConsumers.put(
			"lastName", (BiConsumer<Contact, String>)Contact::setLastName);
		attributeGetterFunctions.put("prefixId", Contact::getPrefixId);
		attributeSetterBiConsumers.put(
			"prefixId", (BiConsumer<Contact, Long>)Contact::setPrefixId);
		attributeGetterFunctions.put("suffixId", Contact::getSuffixId);
		attributeSetterBiConsumers.put(
			"suffixId", (BiConsumer<Contact, Long>)Contact::setSuffixId);
		attributeGetterFunctions.put("male", Contact::getMale);
		attributeSetterBiConsumers.put(
			"male", (BiConsumer<Contact, Boolean>)Contact::setMale);
		attributeGetterFunctions.put("birthday", Contact::getBirthday);
		attributeSetterBiConsumers.put(
			"birthday", (BiConsumer<Contact, Date>)Contact::setBirthday);
		attributeGetterFunctions.put("smsSn", Contact::getSmsSn);
		attributeSetterBiConsumers.put(
			"smsSn", (BiConsumer<Contact, String>)Contact::setSmsSn);
		attributeGetterFunctions.put("facebookSn", Contact::getFacebookSn);
		attributeSetterBiConsumers.put(
			"facebookSn", (BiConsumer<Contact, String>)Contact::setFacebookSn);
		attributeGetterFunctions.put("jabberSn", Contact::getJabberSn);
		attributeSetterBiConsumers.put(
			"jabberSn", (BiConsumer<Contact, String>)Contact::setJabberSn);
		attributeGetterFunctions.put("skypeSn", Contact::getSkypeSn);
		attributeSetterBiConsumers.put(
			"skypeSn", (BiConsumer<Contact, String>)Contact::setSkypeSn);
		attributeGetterFunctions.put("twitterSn", Contact::getTwitterSn);
		attributeSetterBiConsumers.put(
			"twitterSn", (BiConsumer<Contact, String>)Contact::setTwitterSn);
		attributeGetterFunctions.put(
			"employeeStatusId", Contact::getEmployeeStatusId);
		attributeSetterBiConsumers.put(
			"employeeStatusId",
			(BiConsumer<Contact, String>)Contact::setEmployeeStatusId);
		attributeGetterFunctions.put(
			"employeeNumber", Contact::getEmployeeNumber);
		attributeSetterBiConsumers.put(
			"employeeNumber",
			(BiConsumer<Contact, String>)Contact::setEmployeeNumber);
		attributeGetterFunctions.put("jobTitle", Contact::getJobTitle);
		attributeSetterBiConsumers.put(
			"jobTitle", (BiConsumer<Contact, String>)Contact::setJobTitle);
		attributeGetterFunctions.put("jobClass", Contact::getJobClass);
		attributeSetterBiConsumers.put(
			"jobClass", (BiConsumer<Contact, String>)Contact::setJobClass);
		attributeGetterFunctions.put(
			"hoursOfOperation", Contact::getHoursOfOperation);
		attributeSetterBiConsumers.put(
			"hoursOfOperation",
			(BiConsumer<Contact, String>)Contact::setHoursOfOperation);

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
	public long getContactId() {
		return _contactId;
	}

	@Override
	public void setContactId(long contactId) {
		_columnBitmask = -1L;

		_contactId = contactId;
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
		_columnBitmask |= CLASSNAMEID_COLUMN_BITMASK;

		if (!_setOriginalClassNameId) {
			_setOriginalClassNameId = true;

			_originalClassNameId = _classNameId;
		}

		_classNameId = classNameId;
	}

	public long getOriginalClassNameId() {
		return _originalClassNameId;
	}

	@JSON
	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_columnBitmask |= CLASSPK_COLUMN_BITMASK;

		if (!_setOriginalClassPK) {
			_setOriginalClassPK = true;

			_originalClassPK = _classPK;
		}

		_classPK = classPK;
	}

	public long getOriginalClassPK() {
		return _originalClassPK;
	}

	@JSON
	@Override
	public long getAccountId() {
		return _accountId;
	}

	@Override
	public void setAccountId(long accountId) {
		_columnBitmask |= ACCOUNTID_COLUMN_BITMASK;

		if (!_setOriginalAccountId) {
			_setOriginalAccountId = true;

			_originalAccountId = _accountId;
		}

		_accountId = accountId;
	}

	public long getOriginalAccountId() {
		return _originalAccountId;
	}

	@JSON
	@Override
	public long getParentContactId() {
		return _parentContactId;
	}

	@Override
	public void setParentContactId(long parentContactId) {
		_parentContactId = parentContactId;
	}

	@JSON
	@Override
	public String getEmailAddress() {
		if (_emailAddress == null) {
			return "";
		}
		else {
			return _emailAddress;
		}
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	@JSON
	@Override
	public String getFirstName() {
		if (_firstName == null) {
			return "";
		}
		else {
			return _firstName;
		}
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	@JSON
	@Override
	public String getMiddleName() {
		if (_middleName == null) {
			return "";
		}
		else {
			return _middleName;
		}
	}

	@Override
	public void setMiddleName(String middleName) {
		_middleName = middleName;
	}

	@JSON
	@Override
	public String getLastName() {
		if (_lastName == null) {
			return "";
		}
		else {
			return _lastName;
		}
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	@JSON
	@Override
	public long getPrefixId() {
		return _prefixId;
	}

	@Override
	public void setPrefixId(long prefixId) {
		_prefixId = prefixId;
	}

	@JSON
	@Override
	public long getSuffixId() {
		return _suffixId;
	}

	@Override
	public void setSuffixId(long suffixId) {
		_suffixId = suffixId;
	}

	@JSON
	@Override
	public boolean getMale() {
		return _male;
	}

	@JSON
	@Override
	public boolean isMale() {
		return _male;
	}

	@Override
	public void setMale(boolean male) {
		_male = male;
	}

	@JSON
	@Override
	public Date getBirthday() {
		return _birthday;
	}

	@Override
	public void setBirthday(Date birthday) {
		_birthday = birthday;
	}

	@JSON
	@Override
	public String getSmsSn() {
		if (_smsSn == null) {
			return "";
		}
		else {
			return _smsSn;
		}
	}

	@Override
	public void setSmsSn(String smsSn) {
		_smsSn = smsSn;
	}

	@JSON
	@Override
	public String getFacebookSn() {
		if (_facebookSn == null) {
			return "";
		}
		else {
			return _facebookSn;
		}
	}

	@Override
	public void setFacebookSn(String facebookSn) {
		_facebookSn = facebookSn;
	}

	@JSON
	@Override
	public String getJabberSn() {
		if (_jabberSn == null) {
			return "";
		}
		else {
			return _jabberSn;
		}
	}

	@Override
	public void setJabberSn(String jabberSn) {
		_jabberSn = jabberSn;
	}

	@JSON
	@Override
	public String getSkypeSn() {
		if (_skypeSn == null) {
			return "";
		}
		else {
			return _skypeSn;
		}
	}

	@Override
	public void setSkypeSn(String skypeSn) {
		_skypeSn = skypeSn;
	}

	@JSON
	@Override
	public String getTwitterSn() {
		if (_twitterSn == null) {
			return "";
		}
		else {
			return _twitterSn;
		}
	}

	@Override
	public void setTwitterSn(String twitterSn) {
		_twitterSn = twitterSn;
	}

	@JSON
	@Override
	public String getEmployeeStatusId() {
		if (_employeeStatusId == null) {
			return "";
		}
		else {
			return _employeeStatusId;
		}
	}

	@Override
	public void setEmployeeStatusId(String employeeStatusId) {
		_employeeStatusId = employeeStatusId;
	}

	@JSON
	@Override
	public String getEmployeeNumber() {
		if (_employeeNumber == null) {
			return "";
		}
		else {
			return _employeeNumber;
		}
	}

	@Override
	public void setEmployeeNumber(String employeeNumber) {
		_employeeNumber = employeeNumber;
	}

	@JSON
	@Override
	public String getJobTitle() {
		if (_jobTitle == null) {
			return "";
		}
		else {
			return _jobTitle;
		}
	}

	@Override
	public void setJobTitle(String jobTitle) {
		_jobTitle = jobTitle;
	}

	@JSON
	@Override
	public String getJobClass() {
		if (_jobClass == null) {
			return "";
		}
		else {
			return _jobClass;
		}
	}

	@Override
	public void setJobClass(String jobClass) {
		_jobClass = jobClass;
	}

	@JSON
	@Override
	public String getHoursOfOperation() {
		if (_hoursOfOperation == null) {
			return "";
		}
		else {
			return _hoursOfOperation;
		}
	}

	@Override
	public void setHoursOfOperation(String hoursOfOperation) {
		_hoursOfOperation = hoursOfOperation;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Contact.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Contact toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Contact>
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
		ContactImpl contactImpl = new ContactImpl();

		contactImpl.setMvccVersion(getMvccVersion());
		contactImpl.setContactId(getContactId());
		contactImpl.setCompanyId(getCompanyId());
		contactImpl.setUserId(getUserId());
		contactImpl.setUserName(getUserName());
		contactImpl.setCreateDate(getCreateDate());
		contactImpl.setModifiedDate(getModifiedDate());
		contactImpl.setClassNameId(getClassNameId());
		contactImpl.setClassPK(getClassPK());
		contactImpl.setAccountId(getAccountId());
		contactImpl.setParentContactId(getParentContactId());
		contactImpl.setEmailAddress(getEmailAddress());
		contactImpl.setFirstName(getFirstName());
		contactImpl.setMiddleName(getMiddleName());
		contactImpl.setLastName(getLastName());
		contactImpl.setPrefixId(getPrefixId());
		contactImpl.setSuffixId(getSuffixId());
		contactImpl.setMale(isMale());
		contactImpl.setBirthday(getBirthday());
		contactImpl.setSmsSn(getSmsSn());
		contactImpl.setFacebookSn(getFacebookSn());
		contactImpl.setJabberSn(getJabberSn());
		contactImpl.setSkypeSn(getSkypeSn());
		contactImpl.setTwitterSn(getTwitterSn());
		contactImpl.setEmployeeStatusId(getEmployeeStatusId());
		contactImpl.setEmployeeNumber(getEmployeeNumber());
		contactImpl.setJobTitle(getJobTitle());
		contactImpl.setJobClass(getJobClass());
		contactImpl.setHoursOfOperation(getHoursOfOperation());

		contactImpl.resetOriginalValues();

		return contactImpl;
	}

	@Override
	public int compareTo(Contact contact) {
		int value = 0;

		if (getContactId() < contact.getContactId()) {
			value = -1;
		}
		else if (getContactId() > contact.getContactId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Contact)) {
			return false;
		}

		Contact contact = (Contact)obj;

		long primaryKey = contact.getPrimaryKey();

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
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		ContactModelImpl contactModelImpl = this;

		contactModelImpl._originalCompanyId = contactModelImpl._companyId;

		contactModelImpl._setOriginalCompanyId = false;

		contactModelImpl._setModifiedDate = false;

		contactModelImpl._originalClassNameId = contactModelImpl._classNameId;

		contactModelImpl._setOriginalClassNameId = false;

		contactModelImpl._originalClassPK = contactModelImpl._classPK;

		contactModelImpl._setOriginalClassPK = false;

		contactModelImpl._originalAccountId = contactModelImpl._accountId;

		contactModelImpl._setOriginalAccountId = false;

		contactModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Contact> toCacheModel() {
		ContactCacheModel contactCacheModel = new ContactCacheModel();

		contactCacheModel.mvccVersion = getMvccVersion();

		contactCacheModel.contactId = getContactId();

		contactCacheModel.companyId = getCompanyId();

		contactCacheModel.userId = getUserId();

		contactCacheModel.userName = getUserName();

		String userName = contactCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			contactCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			contactCacheModel.createDate = createDate.getTime();
		}
		else {
			contactCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			contactCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			contactCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		contactCacheModel.classNameId = getClassNameId();

		contactCacheModel.classPK = getClassPK();

		contactCacheModel.accountId = getAccountId();

		contactCacheModel.parentContactId = getParentContactId();

		contactCacheModel.emailAddress = getEmailAddress();

		String emailAddress = contactCacheModel.emailAddress;

		if ((emailAddress != null) && (emailAddress.length() == 0)) {
			contactCacheModel.emailAddress = null;
		}

		contactCacheModel.firstName = getFirstName();

		String firstName = contactCacheModel.firstName;

		if ((firstName != null) && (firstName.length() == 0)) {
			contactCacheModel.firstName = null;
		}

		contactCacheModel.middleName = getMiddleName();

		String middleName = contactCacheModel.middleName;

		if ((middleName != null) && (middleName.length() == 0)) {
			contactCacheModel.middleName = null;
		}

		contactCacheModel.lastName = getLastName();

		String lastName = contactCacheModel.lastName;

		if ((lastName != null) && (lastName.length() == 0)) {
			contactCacheModel.lastName = null;
		}

		contactCacheModel.prefixId = getPrefixId();

		contactCacheModel.suffixId = getSuffixId();

		contactCacheModel.male = isMale();

		Date birthday = getBirthday();

		if (birthday != null) {
			contactCacheModel.birthday = birthday.getTime();
		}
		else {
			contactCacheModel.birthday = Long.MIN_VALUE;
		}

		contactCacheModel.smsSn = getSmsSn();

		String smsSn = contactCacheModel.smsSn;

		if ((smsSn != null) && (smsSn.length() == 0)) {
			contactCacheModel.smsSn = null;
		}

		contactCacheModel.facebookSn = getFacebookSn();

		String facebookSn = contactCacheModel.facebookSn;

		if ((facebookSn != null) && (facebookSn.length() == 0)) {
			contactCacheModel.facebookSn = null;
		}

		contactCacheModel.jabberSn = getJabberSn();

		String jabberSn = contactCacheModel.jabberSn;

		if ((jabberSn != null) && (jabberSn.length() == 0)) {
			contactCacheModel.jabberSn = null;
		}

		contactCacheModel.skypeSn = getSkypeSn();

		String skypeSn = contactCacheModel.skypeSn;

		if ((skypeSn != null) && (skypeSn.length() == 0)) {
			contactCacheModel.skypeSn = null;
		}

		contactCacheModel.twitterSn = getTwitterSn();

		String twitterSn = contactCacheModel.twitterSn;

		if ((twitterSn != null) && (twitterSn.length() == 0)) {
			contactCacheModel.twitterSn = null;
		}

		contactCacheModel.employeeStatusId = getEmployeeStatusId();

		String employeeStatusId = contactCacheModel.employeeStatusId;

		if ((employeeStatusId != null) && (employeeStatusId.length() == 0)) {
			contactCacheModel.employeeStatusId = null;
		}

		contactCacheModel.employeeNumber = getEmployeeNumber();

		String employeeNumber = contactCacheModel.employeeNumber;

		if ((employeeNumber != null) && (employeeNumber.length() == 0)) {
			contactCacheModel.employeeNumber = null;
		}

		contactCacheModel.jobTitle = getJobTitle();

		String jobTitle = contactCacheModel.jobTitle;

		if ((jobTitle != null) && (jobTitle.length() == 0)) {
			contactCacheModel.jobTitle = null;
		}

		contactCacheModel.jobClass = getJobClass();

		String jobClass = contactCacheModel.jobClass;

		if ((jobClass != null) && (jobClass.length() == 0)) {
			contactCacheModel.jobClass = null;
		}

		contactCacheModel.hoursOfOperation = getHoursOfOperation();

		String hoursOfOperation = contactCacheModel.hoursOfOperation;

		if ((hoursOfOperation != null) && (hoursOfOperation.length() == 0)) {
			contactCacheModel.hoursOfOperation = null;
		}

		return contactCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Contact, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Contact, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Contact, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Contact)this));
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
		Map<String, Function<Contact, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Contact, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Contact, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Contact)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Contact>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _mvccVersion;
	private long _contactId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _classNameId;
	private long _originalClassNameId;
	private boolean _setOriginalClassNameId;
	private long _classPK;
	private long _originalClassPK;
	private boolean _setOriginalClassPK;
	private long _accountId;
	private long _originalAccountId;
	private boolean _setOriginalAccountId;
	private long _parentContactId;
	private String _emailAddress;
	private String _firstName;
	private String _middleName;
	private String _lastName;
	private long _prefixId;
	private long _suffixId;
	private boolean _male;
	private Date _birthday;
	private String _smsSn;
	private String _facebookSn;
	private String _jabberSn;
	private String _skypeSn;
	private String _twitterSn;
	private String _employeeStatusId;
	private String _employeeNumber;
	private String _jobTitle;
	private String _jobClass;
	private String _hoursOfOperation;
	private long _columnBitmask;
	private Contact _escapedModel;

}