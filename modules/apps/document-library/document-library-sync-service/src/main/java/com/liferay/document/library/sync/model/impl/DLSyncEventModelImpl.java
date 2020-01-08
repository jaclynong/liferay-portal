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

package com.liferay.document.library.sync.model.impl;

import com.liferay.document.library.sync.model.DLSyncEvent;
import com.liferay.document.library.sync.model.DLSyncEventModel;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the DLSyncEvent service. Represents a row in the &quot;DLSyncEvent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DLSyncEventModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DLSyncEventImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DLSyncEventImpl
 * @generated
 */
public class DLSyncEventModelImpl
	extends BaseModelImpl<DLSyncEvent> implements DLSyncEventModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dl sync event model instance should use the <code>DLSyncEvent</code> interface instead.
	 */
	public static final String TABLE_NAME = "DLSyncEvent";

	public static final Object[][] TABLE_COLUMNS = {
		{"syncEventId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"modifiedTime", Types.BIGINT}, {"event", Types.VARCHAR},
		{"type_", Types.VARCHAR}, {"typePK", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("syncEventId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modifiedTime", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("event", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("type_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("typePK", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table DLSyncEvent (syncEventId LONG not null primary key,companyId LONG,modifiedTime LONG,event VARCHAR(75) null,type_ VARCHAR(75) null,typePK LONG)";

	public static final String TABLE_SQL_DROP = "drop table DLSyncEvent";

	public static final String ORDER_BY_JPQL =
		" ORDER BY dlSyncEvent.modifiedTime ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY DLSyncEvent.modifiedTime ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long MODIFIEDTIME_COLUMN_BITMASK = 1L;

	public static final long TYPEPK_COLUMN_BITMASK = 2L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public DLSyncEventModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _syncEventId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSyncEventId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _syncEventId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DLSyncEvent.class;
	}

	@Override
	public String getModelClassName() {
		return DLSyncEvent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DLSyncEvent, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DLSyncEvent, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DLSyncEvent, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((DLSyncEvent)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DLSyncEvent, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DLSyncEvent, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DLSyncEvent)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DLSyncEvent, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DLSyncEvent, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, DLSyncEvent>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			DLSyncEvent.class.getClassLoader(), DLSyncEvent.class,
			ModelWrapper.class);

		try {
			Constructor<DLSyncEvent> constructor =
				(Constructor<DLSyncEvent>)proxyClass.getConstructor(
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

	private static final Map<String, Function<DLSyncEvent, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<DLSyncEvent, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<DLSyncEvent, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<DLSyncEvent, Object>>();
		Map<String, BiConsumer<DLSyncEvent, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<DLSyncEvent, ?>>();

		attributeGetterFunctions.put(
			"syncEventId", DLSyncEvent::getSyncEventId);
		attributeSetterBiConsumers.put(
			"syncEventId",
			(BiConsumer<DLSyncEvent, Long>)DLSyncEvent::setSyncEventId);
		attributeGetterFunctions.put("companyId", DLSyncEvent::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<DLSyncEvent, Long>)DLSyncEvent::setCompanyId);
		attributeGetterFunctions.put(
			"modifiedTime", DLSyncEvent::getModifiedTime);
		attributeSetterBiConsumers.put(
			"modifiedTime",
			(BiConsumer<DLSyncEvent, Long>)DLSyncEvent::setModifiedTime);
		attributeGetterFunctions.put("event", DLSyncEvent::getEvent);
		attributeSetterBiConsumers.put(
			"event", (BiConsumer<DLSyncEvent, String>)DLSyncEvent::setEvent);
		attributeGetterFunctions.put("type", DLSyncEvent::getType);
		attributeSetterBiConsumers.put(
			"type", (BiConsumer<DLSyncEvent, String>)DLSyncEvent::setType);
		attributeGetterFunctions.put("typePK", DLSyncEvent::getTypePK);
		attributeSetterBiConsumers.put(
			"typePK", (BiConsumer<DLSyncEvent, Long>)DLSyncEvent::setTypePK);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getSyncEventId() {
		return _syncEventId;
	}

	@Override
	public void setSyncEventId(long syncEventId) {
		_syncEventId = syncEventId;
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
	public long getModifiedTime() {
		return _modifiedTime;
	}

	@Override
	public void setModifiedTime(long modifiedTime) {
		_columnBitmask = -1L;

		if (!_setOriginalModifiedTime) {
			_setOriginalModifiedTime = true;

			_originalModifiedTime = _modifiedTime;
		}

		_modifiedTime = modifiedTime;
	}

	public long getOriginalModifiedTime() {
		return _originalModifiedTime;
	}

	@Override
	public String getEvent() {
		if (_event == null) {
			return "";
		}
		else {
			return _event;
		}
	}

	@Override
	public void setEvent(String event) {
		_event = event;
	}

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

	@Override
	public long getTypePK() {
		return _typePK;
	}

	@Override
	public void setTypePK(long typePK) {
		_columnBitmask |= TYPEPK_COLUMN_BITMASK;

		if (!_setOriginalTypePK) {
			_setOriginalTypePK = true;

			_originalTypePK = _typePK;
		}

		_typePK = typePK;
	}

	public long getOriginalTypePK() {
		return _originalTypePK;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), DLSyncEvent.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DLSyncEvent toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, DLSyncEvent>
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
		DLSyncEventImpl dlSyncEventImpl = new DLSyncEventImpl();

		dlSyncEventImpl.setSyncEventId(getSyncEventId());
		dlSyncEventImpl.setCompanyId(getCompanyId());
		dlSyncEventImpl.setModifiedTime(getModifiedTime());
		dlSyncEventImpl.setEvent(getEvent());
		dlSyncEventImpl.setType(getType());
		dlSyncEventImpl.setTypePK(getTypePK());

		dlSyncEventImpl.resetOriginalValues();

		return dlSyncEventImpl;
	}

	@Override
	public int compareTo(DLSyncEvent dlSyncEvent) {
		int value = 0;

		if (getModifiedTime() < dlSyncEvent.getModifiedTime()) {
			value = -1;
		}
		else if (getModifiedTime() > dlSyncEvent.getModifiedTime()) {
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

		if (!(obj instanceof DLSyncEvent)) {
			return false;
		}

		DLSyncEvent dlSyncEvent = (DLSyncEvent)obj;

		long primaryKey = dlSyncEvent.getPrimaryKey();

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
		DLSyncEventModelImpl dlSyncEventModelImpl = this;

		dlSyncEventModelImpl._originalModifiedTime =
			dlSyncEventModelImpl._modifiedTime;

		dlSyncEventModelImpl._setOriginalModifiedTime = false;

		dlSyncEventModelImpl._originalTypePK = dlSyncEventModelImpl._typePK;

		dlSyncEventModelImpl._setOriginalTypePK = false;

		dlSyncEventModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DLSyncEvent> toCacheModel() {
		DLSyncEventCacheModel dlSyncEventCacheModel =
			new DLSyncEventCacheModel();

		dlSyncEventCacheModel.syncEventId = getSyncEventId();

		dlSyncEventCacheModel.companyId = getCompanyId();

		dlSyncEventCacheModel.modifiedTime = getModifiedTime();

		dlSyncEventCacheModel.event = getEvent();

		String event = dlSyncEventCacheModel.event;

		if ((event != null) && (event.length() == 0)) {
			dlSyncEventCacheModel.event = null;
		}

		dlSyncEventCacheModel.type = getType();

		String type = dlSyncEventCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			dlSyncEventCacheModel.type = null;
		}

		dlSyncEventCacheModel.typePK = getTypePK();

		return dlSyncEventCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DLSyncEvent, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DLSyncEvent, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DLSyncEvent, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((DLSyncEvent)this));
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
		Map<String, Function<DLSyncEvent, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<DLSyncEvent, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DLSyncEvent, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((DLSyncEvent)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, DLSyncEvent>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _syncEventId;
	private long _companyId;
	private long _modifiedTime;
	private long _originalModifiedTime;
	private boolean _setOriginalModifiedTime;
	private String _event;
	private String _type;
	private long _typePK;
	private long _originalTypePK;
	private boolean _setOriginalTypePK;
	private long _columnBitmask;
	private DLSyncEvent _escapedModel;

}