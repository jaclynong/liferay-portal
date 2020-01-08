/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.saml.persistence.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.saml.persistence.model.SamlSpSession;
import com.liferay.saml.persistence.model.SamlSpSessionModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the SamlSpSession service. Represents a row in the &quot;SamlSpSession&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>SamlSpSessionModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SamlSpSessionImpl}.
 * </p>
 *
 * @author Mika Koivisto
 * @see SamlSpSessionImpl
 * @generated
 */
public class SamlSpSessionModelImpl
	extends BaseModelImpl<SamlSpSession> implements SamlSpSessionModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a saml sp session model instance should use the <code>SamlSpSession</code> interface instead.
	 */
	public static final String TABLE_NAME = "SamlSpSession";

	public static final Object[][] TABLE_COLUMNS = {
		{"samlSpSessionId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"samlIdpEntityId", Types.VARCHAR}, {"samlSpSessionKey", Types.VARCHAR},
		{"assertionXml", Types.CLOB}, {"jSessionId", Types.VARCHAR},
		{"nameIdFormat", Types.VARCHAR}, {"nameIdNameQualifier", Types.VARCHAR},
		{"nameIdSPNameQualifier", Types.VARCHAR},
		{"nameIdValue", Types.VARCHAR}, {"sessionIndex", Types.VARCHAR},
		{"terminated_", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("samlSpSessionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("samlIdpEntityId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("samlSpSessionKey", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("assertionXml", Types.CLOB);
		TABLE_COLUMNS_MAP.put("jSessionId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("nameIdFormat", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("nameIdNameQualifier", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("nameIdSPNameQualifier", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("nameIdValue", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("sessionIndex", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("terminated_", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table SamlSpSession (samlSpSessionId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,samlIdpEntityId VARCHAR(1024) null,samlSpSessionKey VARCHAR(75) null,assertionXml TEXT null,jSessionId VARCHAR(200) null,nameIdFormat VARCHAR(1024) null,nameIdNameQualifier VARCHAR(1024) null,nameIdSPNameQualifier VARCHAR(1024) null,nameIdValue VARCHAR(1024) null,sessionIndex VARCHAR(75) null,terminated_ BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table SamlSpSession";

	public static final String ORDER_BY_JPQL =
		" ORDER BY samlSpSession.samlSpSessionId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY SamlSpSession.samlSpSessionId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long JSESSIONID_COLUMN_BITMASK = 1L;

	public static final long NAMEIDVALUE_COLUMN_BITMASK = 2L;

	public static final long SAMLSPSESSIONKEY_COLUMN_BITMASK = 4L;

	public static final long SESSIONINDEX_COLUMN_BITMASK = 8L;

	public static final long SAMLSPSESSIONID_COLUMN_BITMASK = 16L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public SamlSpSessionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _samlSpSessionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSamlSpSessionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _samlSpSessionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SamlSpSession.class;
	}

	@Override
	public String getModelClassName() {
		return SamlSpSession.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<SamlSpSession, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<SamlSpSession, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SamlSpSession, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((SamlSpSession)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<SamlSpSession, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<SamlSpSession, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(SamlSpSession)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<SamlSpSession, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<SamlSpSession, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, SamlSpSession>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			SamlSpSession.class.getClassLoader(), SamlSpSession.class,
			ModelWrapper.class);

		try {
			Constructor<SamlSpSession> constructor =
				(Constructor<SamlSpSession>)proxyClass.getConstructor(
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

	private static final Map<String, Function<SamlSpSession, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<SamlSpSession, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<SamlSpSession, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<SamlSpSession, Object>>();
		Map<String, BiConsumer<SamlSpSession, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<SamlSpSession, ?>>();

		attributeGetterFunctions.put(
			"samlSpSessionId", SamlSpSession::getSamlSpSessionId);
		attributeSetterBiConsumers.put(
			"samlSpSessionId",
			(BiConsumer<SamlSpSession, Long>)SamlSpSession::setSamlSpSessionId);
		attributeGetterFunctions.put("companyId", SamlSpSession::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<SamlSpSession, Long>)SamlSpSession::setCompanyId);
		attributeGetterFunctions.put("userId", SamlSpSession::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<SamlSpSession, Long>)SamlSpSession::setUserId);
		attributeGetterFunctions.put("userName", SamlSpSession::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<SamlSpSession, String>)SamlSpSession::setUserName);
		attributeGetterFunctions.put(
			"createDate", SamlSpSession::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<SamlSpSession, Date>)SamlSpSession::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", SamlSpSession::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<SamlSpSession, Date>)SamlSpSession::setModifiedDate);
		attributeGetterFunctions.put(
			"samlIdpEntityId", SamlSpSession::getSamlIdpEntityId);
		attributeSetterBiConsumers.put(
			"samlIdpEntityId",
			(BiConsumer<SamlSpSession, String>)
				SamlSpSession::setSamlIdpEntityId);
		attributeGetterFunctions.put(
			"samlSpSessionKey", SamlSpSession::getSamlSpSessionKey);
		attributeSetterBiConsumers.put(
			"samlSpSessionKey",
			(BiConsumer<SamlSpSession, String>)
				SamlSpSession::setSamlSpSessionKey);
		attributeGetterFunctions.put(
			"assertionXml", SamlSpSession::getAssertionXml);
		attributeSetterBiConsumers.put(
			"assertionXml",
			(BiConsumer<SamlSpSession, String>)SamlSpSession::setAssertionXml);
		attributeGetterFunctions.put(
			"jSessionId", SamlSpSession::getJSessionId);
		attributeSetterBiConsumers.put(
			"jSessionId",
			(BiConsumer<SamlSpSession, String>)SamlSpSession::setJSessionId);
		attributeGetterFunctions.put(
			"nameIdFormat", SamlSpSession::getNameIdFormat);
		attributeSetterBiConsumers.put(
			"nameIdFormat",
			(BiConsumer<SamlSpSession, String>)SamlSpSession::setNameIdFormat);
		attributeGetterFunctions.put(
			"nameIdNameQualifier", SamlSpSession::getNameIdNameQualifier);
		attributeSetterBiConsumers.put(
			"nameIdNameQualifier",
			(BiConsumer<SamlSpSession, String>)
				SamlSpSession::setNameIdNameQualifier);
		attributeGetterFunctions.put(
			"nameIdSPNameQualifier", SamlSpSession::getNameIdSPNameQualifier);
		attributeSetterBiConsumers.put(
			"nameIdSPNameQualifier",
			(BiConsumer<SamlSpSession, String>)
				SamlSpSession::setNameIdSPNameQualifier);
		attributeGetterFunctions.put(
			"nameIdValue", SamlSpSession::getNameIdValue);
		attributeSetterBiConsumers.put(
			"nameIdValue",
			(BiConsumer<SamlSpSession, String>)SamlSpSession::setNameIdValue);
		attributeGetterFunctions.put(
			"sessionIndex", SamlSpSession::getSessionIndex);
		attributeSetterBiConsumers.put(
			"sessionIndex",
			(BiConsumer<SamlSpSession, String>)SamlSpSession::setSessionIndex);
		attributeGetterFunctions.put(
			"terminated", SamlSpSession::getTerminated);
		attributeSetterBiConsumers.put(
			"terminated",
			(BiConsumer<SamlSpSession, Boolean>)SamlSpSession::setTerminated);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getSamlSpSessionId() {
		return _samlSpSessionId;
	}

	@Override
	public void setSamlSpSessionId(long samlSpSessionId) {
		_samlSpSessionId = samlSpSessionId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
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
	public String getSamlIdpEntityId() {
		if (_samlIdpEntityId == null) {
			return "";
		}
		else {
			return _samlIdpEntityId;
		}
	}

	@Override
	public void setSamlIdpEntityId(String samlIdpEntityId) {
		_samlIdpEntityId = samlIdpEntityId;
	}

	@Override
	public String getSamlSpSessionKey() {
		if (_samlSpSessionKey == null) {
			return "";
		}
		else {
			return _samlSpSessionKey;
		}
	}

	@Override
	public void setSamlSpSessionKey(String samlSpSessionKey) {
		_columnBitmask |= SAMLSPSESSIONKEY_COLUMN_BITMASK;

		if (_originalSamlSpSessionKey == null) {
			_originalSamlSpSessionKey = _samlSpSessionKey;
		}

		_samlSpSessionKey = samlSpSessionKey;
	}

	public String getOriginalSamlSpSessionKey() {
		return GetterUtil.getString(_originalSamlSpSessionKey);
	}

	@Override
	public String getAssertionXml() {
		if (_assertionXml == null) {
			return "";
		}
		else {
			return _assertionXml;
		}
	}

	@Override
	public void setAssertionXml(String assertionXml) {
		_assertionXml = assertionXml;
	}

	@Override
	public String getJSessionId() {
		if (_jSessionId == null) {
			return "";
		}
		else {
			return _jSessionId;
		}
	}

	@Override
	public void setJSessionId(String jSessionId) {
		_columnBitmask |= JSESSIONID_COLUMN_BITMASK;

		if (_originalJSessionId == null) {
			_originalJSessionId = _jSessionId;
		}

		_jSessionId = jSessionId;
	}

	public String getOriginalJSessionId() {
		return GetterUtil.getString(_originalJSessionId);
	}

	@Override
	public String getNameIdFormat() {
		if (_nameIdFormat == null) {
			return "";
		}
		else {
			return _nameIdFormat;
		}
	}

	@Override
	public void setNameIdFormat(String nameIdFormat) {
		_nameIdFormat = nameIdFormat;
	}

	@Override
	public String getNameIdNameQualifier() {
		if (_nameIdNameQualifier == null) {
			return "";
		}
		else {
			return _nameIdNameQualifier;
		}
	}

	@Override
	public void setNameIdNameQualifier(String nameIdNameQualifier) {
		_nameIdNameQualifier = nameIdNameQualifier;
	}

	@Override
	public String getNameIdSPNameQualifier() {
		if (_nameIdSPNameQualifier == null) {
			return "";
		}
		else {
			return _nameIdSPNameQualifier;
		}
	}

	@Override
	public void setNameIdSPNameQualifier(String nameIdSPNameQualifier) {
		_nameIdSPNameQualifier = nameIdSPNameQualifier;
	}

	@Override
	public String getNameIdValue() {
		if (_nameIdValue == null) {
			return "";
		}
		else {
			return _nameIdValue;
		}
	}

	@Override
	public void setNameIdValue(String nameIdValue) {
		_columnBitmask |= NAMEIDVALUE_COLUMN_BITMASK;

		if (_originalNameIdValue == null) {
			_originalNameIdValue = _nameIdValue;
		}

		_nameIdValue = nameIdValue;
	}

	public String getOriginalNameIdValue() {
		return GetterUtil.getString(_originalNameIdValue);
	}

	@Override
	public String getSessionIndex() {
		if (_sessionIndex == null) {
			return "";
		}
		else {
			return _sessionIndex;
		}
	}

	@Override
	public void setSessionIndex(String sessionIndex) {
		_columnBitmask |= SESSIONINDEX_COLUMN_BITMASK;

		if (_originalSessionIndex == null) {
			_originalSessionIndex = _sessionIndex;
		}

		_sessionIndex = sessionIndex;
	}

	public String getOriginalSessionIndex() {
		return GetterUtil.getString(_originalSessionIndex);
	}

	@Override
	public boolean getTerminated() {
		return _terminated;
	}

	@Override
	public boolean isTerminated() {
		return _terminated;
	}

	@Override
	public void setTerminated(boolean terminated) {
		_terminated = terminated;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), SamlSpSession.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SamlSpSession toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, SamlSpSession>
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
		SamlSpSessionImpl samlSpSessionImpl = new SamlSpSessionImpl();

		samlSpSessionImpl.setSamlSpSessionId(getSamlSpSessionId());
		samlSpSessionImpl.setCompanyId(getCompanyId());
		samlSpSessionImpl.setUserId(getUserId());
		samlSpSessionImpl.setUserName(getUserName());
		samlSpSessionImpl.setCreateDate(getCreateDate());
		samlSpSessionImpl.setModifiedDate(getModifiedDate());
		samlSpSessionImpl.setSamlIdpEntityId(getSamlIdpEntityId());
		samlSpSessionImpl.setSamlSpSessionKey(getSamlSpSessionKey());
		samlSpSessionImpl.setAssertionXml(getAssertionXml());
		samlSpSessionImpl.setJSessionId(getJSessionId());
		samlSpSessionImpl.setNameIdFormat(getNameIdFormat());
		samlSpSessionImpl.setNameIdNameQualifier(getNameIdNameQualifier());
		samlSpSessionImpl.setNameIdSPNameQualifier(getNameIdSPNameQualifier());
		samlSpSessionImpl.setNameIdValue(getNameIdValue());
		samlSpSessionImpl.setSessionIndex(getSessionIndex());
		samlSpSessionImpl.setTerminated(isTerminated());

		samlSpSessionImpl.resetOriginalValues();

		return samlSpSessionImpl;
	}

	@Override
	public int compareTo(SamlSpSession samlSpSession) {
		long primaryKey = samlSpSession.getPrimaryKey();

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

		if (!(obj instanceof SamlSpSession)) {
			return false;
		}

		SamlSpSession samlSpSession = (SamlSpSession)obj;

		long primaryKey = samlSpSession.getPrimaryKey();

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
		SamlSpSessionModelImpl samlSpSessionModelImpl = this;

		samlSpSessionModelImpl._setModifiedDate = false;

		samlSpSessionModelImpl._originalSamlSpSessionKey =
			samlSpSessionModelImpl._samlSpSessionKey;

		samlSpSessionModelImpl._originalJSessionId =
			samlSpSessionModelImpl._jSessionId;

		samlSpSessionModelImpl._originalNameIdValue =
			samlSpSessionModelImpl._nameIdValue;

		samlSpSessionModelImpl._originalSessionIndex =
			samlSpSessionModelImpl._sessionIndex;

		samlSpSessionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SamlSpSession> toCacheModel() {
		SamlSpSessionCacheModel samlSpSessionCacheModel =
			new SamlSpSessionCacheModel();

		samlSpSessionCacheModel.samlSpSessionId = getSamlSpSessionId();

		samlSpSessionCacheModel.companyId = getCompanyId();

		samlSpSessionCacheModel.userId = getUserId();

		samlSpSessionCacheModel.userName = getUserName();

		String userName = samlSpSessionCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			samlSpSessionCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			samlSpSessionCacheModel.createDate = createDate.getTime();
		}
		else {
			samlSpSessionCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			samlSpSessionCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			samlSpSessionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		samlSpSessionCacheModel.samlIdpEntityId = getSamlIdpEntityId();

		String samlIdpEntityId = samlSpSessionCacheModel.samlIdpEntityId;

		if ((samlIdpEntityId != null) && (samlIdpEntityId.length() == 0)) {
			samlSpSessionCacheModel.samlIdpEntityId = null;
		}

		samlSpSessionCacheModel.samlSpSessionKey = getSamlSpSessionKey();

		String samlSpSessionKey = samlSpSessionCacheModel.samlSpSessionKey;

		if ((samlSpSessionKey != null) && (samlSpSessionKey.length() == 0)) {
			samlSpSessionCacheModel.samlSpSessionKey = null;
		}

		samlSpSessionCacheModel.assertionXml = getAssertionXml();

		String assertionXml = samlSpSessionCacheModel.assertionXml;

		if ((assertionXml != null) && (assertionXml.length() == 0)) {
			samlSpSessionCacheModel.assertionXml = null;
		}

		samlSpSessionCacheModel.jSessionId = getJSessionId();

		String jSessionId = samlSpSessionCacheModel.jSessionId;

		if ((jSessionId != null) && (jSessionId.length() == 0)) {
			samlSpSessionCacheModel.jSessionId = null;
		}

		samlSpSessionCacheModel.nameIdFormat = getNameIdFormat();

		String nameIdFormat = samlSpSessionCacheModel.nameIdFormat;

		if ((nameIdFormat != null) && (nameIdFormat.length() == 0)) {
			samlSpSessionCacheModel.nameIdFormat = null;
		}

		samlSpSessionCacheModel.nameIdNameQualifier = getNameIdNameQualifier();

		String nameIdNameQualifier =
			samlSpSessionCacheModel.nameIdNameQualifier;

		if ((nameIdNameQualifier != null) &&
			(nameIdNameQualifier.length() == 0)) {

			samlSpSessionCacheModel.nameIdNameQualifier = null;
		}

		samlSpSessionCacheModel.nameIdSPNameQualifier =
			getNameIdSPNameQualifier();

		String nameIdSPNameQualifier =
			samlSpSessionCacheModel.nameIdSPNameQualifier;

		if ((nameIdSPNameQualifier != null) &&
			(nameIdSPNameQualifier.length() == 0)) {

			samlSpSessionCacheModel.nameIdSPNameQualifier = null;
		}

		samlSpSessionCacheModel.nameIdValue = getNameIdValue();

		String nameIdValue = samlSpSessionCacheModel.nameIdValue;

		if ((nameIdValue != null) && (nameIdValue.length() == 0)) {
			samlSpSessionCacheModel.nameIdValue = null;
		}

		samlSpSessionCacheModel.sessionIndex = getSessionIndex();

		String sessionIndex = samlSpSessionCacheModel.sessionIndex;

		if ((sessionIndex != null) && (sessionIndex.length() == 0)) {
			samlSpSessionCacheModel.sessionIndex = null;
		}

		samlSpSessionCacheModel.terminated = isTerminated();

		return samlSpSessionCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<SamlSpSession, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<SamlSpSession, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SamlSpSession, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((SamlSpSession)this));
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
		Map<String, Function<SamlSpSession, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<SamlSpSession, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SamlSpSession, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((SamlSpSession)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, SamlSpSession>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _samlSpSessionId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _samlIdpEntityId;
	private String _samlSpSessionKey;
	private String _originalSamlSpSessionKey;
	private String _assertionXml;
	private String _jSessionId;
	private String _originalJSessionId;
	private String _nameIdFormat;
	private String _nameIdNameQualifier;
	private String _nameIdSPNameQualifier;
	private String _nameIdValue;
	private String _originalNameIdValue;
	private String _sessionIndex;
	private String _originalSessionIndex;
	private boolean _terminated;
	private long _columnBitmask;
	private SamlSpSession _escapedModel;

}