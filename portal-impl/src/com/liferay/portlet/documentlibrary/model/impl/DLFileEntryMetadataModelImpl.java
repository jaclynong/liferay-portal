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

package com.liferay.portlet.documentlibrary.model.impl;

import com.liferay.document.library.kernel.model.DLFileEntryMetadata;
import com.liferay.document.library.kernel.model.DLFileEntryMetadataModel;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
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
 * The base model implementation for the DLFileEntryMetadata service. Represents a row in the &quot;DLFileEntryMetadata&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>DLFileEntryMetadataModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DLFileEntryMetadataImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DLFileEntryMetadataImpl
 * @generated
 */
public class DLFileEntryMetadataModelImpl
	extends BaseModelImpl<DLFileEntryMetadata>
	implements DLFileEntryMetadataModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a document library file entry metadata model instance should use the <code>DLFileEntryMetadata</code> interface instead.
	 */
	public static final String TABLE_NAME = "DLFileEntryMetadata";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"uuid_", Types.VARCHAR},
		{"fileEntryMetadataId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"DDMStorageId", Types.BIGINT}, {"DDMStructureId", Types.BIGINT},
		{"fileEntryId", Types.BIGINT}, {"fileVersionId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fileEntryMetadataId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("DDMStorageId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("DDMStructureId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("fileEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("fileVersionId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table DLFileEntryMetadata (mvccVersion LONG default 0 not null,uuid_ VARCHAR(75) null,fileEntryMetadataId LONG not null primary key,companyId LONG,DDMStorageId LONG,DDMStructureId LONG,fileEntryId LONG,fileVersionId LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table DLFileEntryMetadata";

	public static final String ORDER_BY_JPQL =
		" ORDER BY dlFileEntryMetadata.fileEntryMetadataId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY DLFileEntryMetadata.fileEntryMetadataId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.entity.cache.enabled.com.liferay.document.library.kernel.model.DLFileEntryMetadata"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.finder.cache.enabled.com.liferay.document.library.kernel.model.DLFileEntryMetadata"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.com.liferay.document.library.kernel.model.DLFileEntryMetadata"),
		true);

	public static final long DDMSTRUCTUREID_COLUMN_BITMASK = 1L;

	public static final long COMPANYID_COLUMN_BITMASK = 2L;

	public static final long FILEENTRYID_COLUMN_BITMASK = 4L;

	public static final long FILEVERSIONID_COLUMN_BITMASK = 8L;

	public static final long UUID_COLUMN_BITMASK = 16L;

	public static final long FILEENTRYMETADATAID_COLUMN_BITMASK = 32L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.util.PropsUtil.get(
			"lock.expiration.time.com.liferay.document.library.kernel.model.DLFileEntryMetadata"));

	public DLFileEntryMetadataModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _fileEntryMetadataId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFileEntryMetadataId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _fileEntryMetadataId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DLFileEntryMetadata.class;
	}

	@Override
	public String getModelClassName() {
		return DLFileEntryMetadata.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DLFileEntryMetadata, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DLFileEntryMetadata, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DLFileEntryMetadata, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((DLFileEntryMetadata)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DLFileEntryMetadata, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DLFileEntryMetadata, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DLFileEntryMetadata)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DLFileEntryMetadata, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DLFileEntryMetadata, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, DLFileEntryMetadata>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			DLFileEntryMetadata.class.getClassLoader(),
			DLFileEntryMetadata.class, ModelWrapper.class);

		try {
			Constructor<DLFileEntryMetadata> constructor =
				(Constructor<DLFileEntryMetadata>)proxyClass.getConstructor(
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

	private static final Map<String, Function<DLFileEntryMetadata, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<DLFileEntryMetadata, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<DLFileEntryMetadata, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<DLFileEntryMetadata, Object>>();
		Map<String, BiConsumer<DLFileEntryMetadata, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<DLFileEntryMetadata, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion", DLFileEntryMetadata::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<DLFileEntryMetadata, Long>)
				DLFileEntryMetadata::setMvccVersion);
		attributeGetterFunctions.put("uuid", DLFileEntryMetadata::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<DLFileEntryMetadata, String>)
				DLFileEntryMetadata::setUuid);
		attributeGetterFunctions.put(
			"fileEntryMetadataId", DLFileEntryMetadata::getFileEntryMetadataId);
		attributeSetterBiConsumers.put(
			"fileEntryMetadataId",
			(BiConsumer<DLFileEntryMetadata, Long>)
				DLFileEntryMetadata::setFileEntryMetadataId);
		attributeGetterFunctions.put(
			"companyId", DLFileEntryMetadata::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<DLFileEntryMetadata, Long>)
				DLFileEntryMetadata::setCompanyId);
		attributeGetterFunctions.put(
			"DDMStorageId", DLFileEntryMetadata::getDDMStorageId);
		attributeSetterBiConsumers.put(
			"DDMStorageId",
			(BiConsumer<DLFileEntryMetadata, Long>)
				DLFileEntryMetadata::setDDMStorageId);
		attributeGetterFunctions.put(
			"DDMStructureId", DLFileEntryMetadata::getDDMStructureId);
		attributeSetterBiConsumers.put(
			"DDMStructureId",
			(BiConsumer<DLFileEntryMetadata, Long>)
				DLFileEntryMetadata::setDDMStructureId);
		attributeGetterFunctions.put(
			"fileEntryId", DLFileEntryMetadata::getFileEntryId);
		attributeSetterBiConsumers.put(
			"fileEntryId",
			(BiConsumer<DLFileEntryMetadata, Long>)
				DLFileEntryMetadata::setFileEntryId);
		attributeGetterFunctions.put(
			"fileVersionId", DLFileEntryMetadata::getFileVersionId);
		attributeSetterBiConsumers.put(
			"fileVersionId",
			(BiConsumer<DLFileEntryMetadata, Long>)
				DLFileEntryMetadata::setFileVersionId);

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
	public long getFileEntryMetadataId() {
		return _fileEntryMetadataId;
	}

	@Override
	public void setFileEntryMetadataId(long fileEntryMetadataId) {
		_fileEntryMetadataId = fileEntryMetadataId;
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
	public long getDDMStorageId() {
		return _DDMStorageId;
	}

	@Override
	public void setDDMStorageId(long DDMStorageId) {
		_DDMStorageId = DDMStorageId;
	}

	@Override
	public long getDDMStructureId() {
		return _DDMStructureId;
	}

	@Override
	public void setDDMStructureId(long DDMStructureId) {
		_columnBitmask |= DDMSTRUCTUREID_COLUMN_BITMASK;

		if (!_setOriginalDDMStructureId) {
			_setOriginalDDMStructureId = true;

			_originalDDMStructureId = _DDMStructureId;
		}

		_DDMStructureId = DDMStructureId;
	}

	public long getOriginalDDMStructureId() {
		return _originalDDMStructureId;
	}

	@Override
	public long getFileEntryId() {
		return _fileEntryId;
	}

	@Override
	public void setFileEntryId(long fileEntryId) {
		_columnBitmask |= FILEENTRYID_COLUMN_BITMASK;

		if (!_setOriginalFileEntryId) {
			_setOriginalFileEntryId = true;

			_originalFileEntryId = _fileEntryId;
		}

		_fileEntryId = fileEntryId;
	}

	public long getOriginalFileEntryId() {
		return _originalFileEntryId;
	}

	@Override
	public long getFileVersionId() {
		return _fileVersionId;
	}

	@Override
	public void setFileVersionId(long fileVersionId) {
		_columnBitmask |= FILEVERSIONID_COLUMN_BITMASK;

		if (!_setOriginalFileVersionId) {
			_setOriginalFileVersionId = true;

			_originalFileVersionId = _fileVersionId;
		}

		_fileVersionId = fileVersionId;
	}

	public long getOriginalFileVersionId() {
		return _originalFileVersionId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), DLFileEntryMetadata.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DLFileEntryMetadata toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, DLFileEntryMetadata>
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
		DLFileEntryMetadataImpl dlFileEntryMetadataImpl =
			new DLFileEntryMetadataImpl();

		dlFileEntryMetadataImpl.setMvccVersion(getMvccVersion());
		dlFileEntryMetadataImpl.setUuid(getUuid());
		dlFileEntryMetadataImpl.setFileEntryMetadataId(
			getFileEntryMetadataId());
		dlFileEntryMetadataImpl.setCompanyId(getCompanyId());
		dlFileEntryMetadataImpl.setDDMStorageId(getDDMStorageId());
		dlFileEntryMetadataImpl.setDDMStructureId(getDDMStructureId());
		dlFileEntryMetadataImpl.setFileEntryId(getFileEntryId());
		dlFileEntryMetadataImpl.setFileVersionId(getFileVersionId());

		dlFileEntryMetadataImpl.resetOriginalValues();

		return dlFileEntryMetadataImpl;
	}

	@Override
	public int compareTo(DLFileEntryMetadata dlFileEntryMetadata) {
		long primaryKey = dlFileEntryMetadata.getPrimaryKey();

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

		if (!(obj instanceof DLFileEntryMetadata)) {
			return false;
		}

		DLFileEntryMetadata dlFileEntryMetadata = (DLFileEntryMetadata)obj;

		long primaryKey = dlFileEntryMetadata.getPrimaryKey();

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
		DLFileEntryMetadataModelImpl dlFileEntryMetadataModelImpl = this;

		dlFileEntryMetadataModelImpl._originalUuid =
			dlFileEntryMetadataModelImpl._uuid;

		dlFileEntryMetadataModelImpl._originalCompanyId =
			dlFileEntryMetadataModelImpl._companyId;

		dlFileEntryMetadataModelImpl._setOriginalCompanyId = false;

		dlFileEntryMetadataModelImpl._originalDDMStructureId =
			dlFileEntryMetadataModelImpl._DDMStructureId;

		dlFileEntryMetadataModelImpl._setOriginalDDMStructureId = false;

		dlFileEntryMetadataModelImpl._originalFileEntryId =
			dlFileEntryMetadataModelImpl._fileEntryId;

		dlFileEntryMetadataModelImpl._setOriginalFileEntryId = false;

		dlFileEntryMetadataModelImpl._originalFileVersionId =
			dlFileEntryMetadataModelImpl._fileVersionId;

		dlFileEntryMetadataModelImpl._setOriginalFileVersionId = false;

		dlFileEntryMetadataModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DLFileEntryMetadata> toCacheModel() {
		DLFileEntryMetadataCacheModel dlFileEntryMetadataCacheModel =
			new DLFileEntryMetadataCacheModel();

		dlFileEntryMetadataCacheModel.mvccVersion = getMvccVersion();

		dlFileEntryMetadataCacheModel.uuid = getUuid();

		String uuid = dlFileEntryMetadataCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			dlFileEntryMetadataCacheModel.uuid = null;
		}

		dlFileEntryMetadataCacheModel.fileEntryMetadataId =
			getFileEntryMetadataId();

		dlFileEntryMetadataCacheModel.companyId = getCompanyId();

		dlFileEntryMetadataCacheModel.DDMStorageId = getDDMStorageId();

		dlFileEntryMetadataCacheModel.DDMStructureId = getDDMStructureId();

		dlFileEntryMetadataCacheModel.fileEntryId = getFileEntryId();

		dlFileEntryMetadataCacheModel.fileVersionId = getFileVersionId();

		return dlFileEntryMetadataCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DLFileEntryMetadata, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DLFileEntryMetadata, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DLFileEntryMetadata, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((DLFileEntryMetadata)this));
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
		Map<String, Function<DLFileEntryMetadata, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<DLFileEntryMetadata, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DLFileEntryMetadata, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((DLFileEntryMetadata)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, DLFileEntryMetadata>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _mvccVersion;
	private String _uuid;
	private String _originalUuid;
	private long _fileEntryMetadataId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _DDMStorageId;
	private long _DDMStructureId;
	private long _originalDDMStructureId;
	private boolean _setOriginalDDMStructureId;
	private long _fileEntryId;
	private long _originalFileEntryId;
	private boolean _setOriginalFileEntryId;
	private long _fileVersionId;
	private long _originalFileVersionId;
	private boolean _setOriginalFileVersionId;
	private long _columnBitmask;
	private DLFileEntryMetadata _escapedModel;

}