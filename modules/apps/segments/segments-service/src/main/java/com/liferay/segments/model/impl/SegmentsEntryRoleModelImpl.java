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

package com.liferay.segments.model.impl;

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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.segments.model.SegmentsEntryRole;
import com.liferay.segments.model.SegmentsEntryRoleModel;

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
 * The base model implementation for the SegmentsEntryRole service. Represents a row in the &quot;SegmentsEntryRole&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>SegmentsEntryRoleModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SegmentsEntryRoleImpl}.
 * </p>
 *
 * @author Eduardo Garcia
 * @see SegmentsEntryRoleImpl
 * @generated
 */
public class SegmentsEntryRoleModelImpl
	extends BaseModelImpl<SegmentsEntryRole> implements SegmentsEntryRoleModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a segments entry role model instance should use the <code>SegmentsEntryRole</code> interface instead.
	 */
	public static final String TABLE_NAME = "SegmentsEntryRole";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"segmentsEntryRoleId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"segmentsEntryId", Types.BIGINT},
		{"roleId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("segmentsEntryRoleId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("segmentsEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("roleId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table SegmentsEntryRole (mvccVersion LONG default 0 not null,segmentsEntryRoleId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,segmentsEntryId LONG,roleId LONG)";

	public static final String TABLE_SQL_DROP = "drop table SegmentsEntryRole";

	public static final String ORDER_BY_JPQL =
		" ORDER BY segmentsEntryRole.segmentsEntryRoleId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY SegmentsEntryRole.segmentsEntryRoleId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long ROLEID_COLUMN_BITMASK = 1L;

	public static final long SEGMENTSENTRYID_COLUMN_BITMASK = 2L;

	public static final long SEGMENTSENTRYROLEID_COLUMN_BITMASK = 4L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public SegmentsEntryRoleModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _segmentsEntryRoleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSegmentsEntryRoleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _segmentsEntryRoleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SegmentsEntryRole.class;
	}

	@Override
	public String getModelClassName() {
		return SegmentsEntryRole.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<SegmentsEntryRole, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<SegmentsEntryRole, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SegmentsEntryRole, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((SegmentsEntryRole)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<SegmentsEntryRole, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<SegmentsEntryRole, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(SegmentsEntryRole)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<SegmentsEntryRole, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<SegmentsEntryRole, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, SegmentsEntryRole>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			SegmentsEntryRole.class.getClassLoader(), SegmentsEntryRole.class,
			ModelWrapper.class);

		try {
			Constructor<SegmentsEntryRole> constructor =
				(Constructor<SegmentsEntryRole>)proxyClass.getConstructor(
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

	private static final Map<String, Function<SegmentsEntryRole, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<SegmentsEntryRole, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<SegmentsEntryRole, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<SegmentsEntryRole, Object>>();
		Map<String, BiConsumer<SegmentsEntryRole, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<SegmentsEntryRole, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion", SegmentsEntryRole::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<SegmentsEntryRole, Long>)
				SegmentsEntryRole::setMvccVersion);
		attributeGetterFunctions.put(
			"segmentsEntryRoleId", SegmentsEntryRole::getSegmentsEntryRoleId);
		attributeSetterBiConsumers.put(
			"segmentsEntryRoleId",
			(BiConsumer<SegmentsEntryRole, Long>)
				SegmentsEntryRole::setSegmentsEntryRoleId);
		attributeGetterFunctions.put(
			"companyId", SegmentsEntryRole::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<SegmentsEntryRole, Long>)
				SegmentsEntryRole::setCompanyId);
		attributeGetterFunctions.put("userId", SegmentsEntryRole::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<SegmentsEntryRole, Long>)SegmentsEntryRole::setUserId);
		attributeGetterFunctions.put(
			"userName", SegmentsEntryRole::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<SegmentsEntryRole, String>)
				SegmentsEntryRole::setUserName);
		attributeGetterFunctions.put(
			"createDate", SegmentsEntryRole::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<SegmentsEntryRole, Date>)
				SegmentsEntryRole::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", SegmentsEntryRole::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<SegmentsEntryRole, Date>)
				SegmentsEntryRole::setModifiedDate);
		attributeGetterFunctions.put(
			"segmentsEntryId", SegmentsEntryRole::getSegmentsEntryId);
		attributeSetterBiConsumers.put(
			"segmentsEntryId",
			(BiConsumer<SegmentsEntryRole, Long>)
				SegmentsEntryRole::setSegmentsEntryId);
		attributeGetterFunctions.put("roleId", SegmentsEntryRole::getRoleId);
		attributeSetterBiConsumers.put(
			"roleId",
			(BiConsumer<SegmentsEntryRole, Long>)SegmentsEntryRole::setRoleId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	@Override
	public long getSegmentsEntryRoleId() {
		return _segmentsEntryRoleId;
	}

	@Override
	public void setSegmentsEntryRoleId(long segmentsEntryRoleId) {
		_segmentsEntryRoleId = segmentsEntryRoleId;
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
	public long getSegmentsEntryId() {
		return _segmentsEntryId;
	}

	@Override
	public void setSegmentsEntryId(long segmentsEntryId) {
		_columnBitmask |= SEGMENTSENTRYID_COLUMN_BITMASK;

		if (!_setOriginalSegmentsEntryId) {
			_setOriginalSegmentsEntryId = true;

			_originalSegmentsEntryId = _segmentsEntryId;
		}

		_segmentsEntryId = segmentsEntryId;
	}

	public long getOriginalSegmentsEntryId() {
		return _originalSegmentsEntryId;
	}

	@Override
	public long getRoleId() {
		return _roleId;
	}

	@Override
	public void setRoleId(long roleId) {
		_columnBitmask |= ROLEID_COLUMN_BITMASK;

		if (!_setOriginalRoleId) {
			_setOriginalRoleId = true;

			_originalRoleId = _roleId;
		}

		_roleId = roleId;
	}

	public long getOriginalRoleId() {
		return _originalRoleId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), SegmentsEntryRole.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SegmentsEntryRole toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, SegmentsEntryRole>
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
		SegmentsEntryRoleImpl segmentsEntryRoleImpl =
			new SegmentsEntryRoleImpl();

		segmentsEntryRoleImpl.setMvccVersion(getMvccVersion());
		segmentsEntryRoleImpl.setSegmentsEntryRoleId(getSegmentsEntryRoleId());
		segmentsEntryRoleImpl.setCompanyId(getCompanyId());
		segmentsEntryRoleImpl.setUserId(getUserId());
		segmentsEntryRoleImpl.setUserName(getUserName());
		segmentsEntryRoleImpl.setCreateDate(getCreateDate());
		segmentsEntryRoleImpl.setModifiedDate(getModifiedDate());
		segmentsEntryRoleImpl.setSegmentsEntryId(getSegmentsEntryId());
		segmentsEntryRoleImpl.setRoleId(getRoleId());

		segmentsEntryRoleImpl.resetOriginalValues();

		return segmentsEntryRoleImpl;
	}

	@Override
	public int compareTo(SegmentsEntryRole segmentsEntryRole) {
		long primaryKey = segmentsEntryRole.getPrimaryKey();

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

		if (!(obj instanceof SegmentsEntryRole)) {
			return false;
		}

		SegmentsEntryRole segmentsEntryRole = (SegmentsEntryRole)obj;

		long primaryKey = segmentsEntryRole.getPrimaryKey();

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
		SegmentsEntryRoleModelImpl segmentsEntryRoleModelImpl = this;

		segmentsEntryRoleModelImpl._setModifiedDate = false;

		segmentsEntryRoleModelImpl._originalSegmentsEntryId =
			segmentsEntryRoleModelImpl._segmentsEntryId;

		segmentsEntryRoleModelImpl._setOriginalSegmentsEntryId = false;

		segmentsEntryRoleModelImpl._originalRoleId =
			segmentsEntryRoleModelImpl._roleId;

		segmentsEntryRoleModelImpl._setOriginalRoleId = false;

		segmentsEntryRoleModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SegmentsEntryRole> toCacheModel() {
		SegmentsEntryRoleCacheModel segmentsEntryRoleCacheModel =
			new SegmentsEntryRoleCacheModel();

		segmentsEntryRoleCacheModel.mvccVersion = getMvccVersion();

		segmentsEntryRoleCacheModel.segmentsEntryRoleId =
			getSegmentsEntryRoleId();

		segmentsEntryRoleCacheModel.companyId = getCompanyId();

		segmentsEntryRoleCacheModel.userId = getUserId();

		segmentsEntryRoleCacheModel.userName = getUserName();

		String userName = segmentsEntryRoleCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			segmentsEntryRoleCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			segmentsEntryRoleCacheModel.createDate = createDate.getTime();
		}
		else {
			segmentsEntryRoleCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			segmentsEntryRoleCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			segmentsEntryRoleCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		segmentsEntryRoleCacheModel.segmentsEntryId = getSegmentsEntryId();

		segmentsEntryRoleCacheModel.roleId = getRoleId();

		return segmentsEntryRoleCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<SegmentsEntryRole, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<SegmentsEntryRole, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SegmentsEntryRole, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((SegmentsEntryRole)this));
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
		Map<String, Function<SegmentsEntryRole, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<SegmentsEntryRole, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SegmentsEntryRole, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((SegmentsEntryRole)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, SegmentsEntryRole>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _mvccVersion;
	private long _segmentsEntryRoleId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _segmentsEntryId;
	private long _originalSegmentsEntryId;
	private boolean _setOriginalSegmentsEntryId;
	private long _roleId;
	private long _originalRoleId;
	private boolean _setOriginalRoleId;
	private long _columnBitmask;
	private SegmentsEntryRole _escapedModel;

}