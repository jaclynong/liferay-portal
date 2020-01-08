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

package com.liferay.journal.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.journal.model.JournalContentSearch;
import com.liferay.journal.model.JournalContentSearchModel;
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
 * The base model implementation for the JournalContentSearch service. Represents a row in the &quot;JournalContentSearch&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>JournalContentSearchModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link JournalContentSearchImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JournalContentSearchImpl
 * @generated
 */
public class JournalContentSearchModelImpl
	extends BaseModelImpl<JournalContentSearch>
	implements JournalContentSearchModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a journal content search model instance should use the <code>JournalContentSearch</code> interface instead.
	 */
	public static final String TABLE_NAME = "JournalContentSearch";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"contentSearchId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"privateLayout", Types.BOOLEAN}, {"layoutId", Types.BIGINT},
		{"portletId", Types.VARCHAR}, {"articleId", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("contentSearchId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("privateLayout", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("layoutId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("portletId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("articleId", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table JournalContentSearch (mvccVersion LONG default 0 not null,contentSearchId LONG not null primary key,groupId LONG,companyId LONG,privateLayout BOOLEAN,layoutId LONG,portletId VARCHAR(200) null,articleId VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table JournalContentSearch";

	public static final String ORDER_BY_JPQL =
		" ORDER BY journalContentSearch.contentSearchId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY JournalContentSearch.contentSearchId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long ARTICLEID_COLUMN_BITMASK = 1L;

	public static final long COMPANYID_COLUMN_BITMASK = 2L;

	public static final long GROUPID_COLUMN_BITMASK = 4L;

	public static final long LAYOUTID_COLUMN_BITMASK = 8L;

	public static final long PORTLETID_COLUMN_BITMASK = 16L;

	public static final long PRIVATELAYOUT_COLUMN_BITMASK = 32L;

	public static final long CONTENTSEARCHID_COLUMN_BITMASK = 64L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public JournalContentSearchModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _contentSearchId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setContentSearchId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _contentSearchId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return JournalContentSearch.class;
	}

	@Override
	public String getModelClassName() {
		return JournalContentSearch.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<JournalContentSearch, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<JournalContentSearch, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<JournalContentSearch, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((JournalContentSearch)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<JournalContentSearch, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<JournalContentSearch, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(JournalContentSearch)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<JournalContentSearch, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<JournalContentSearch, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, JournalContentSearch>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			JournalContentSearch.class.getClassLoader(),
			JournalContentSearch.class, ModelWrapper.class);

		try {
			Constructor<JournalContentSearch> constructor =
				(Constructor<JournalContentSearch>)proxyClass.getConstructor(
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

	private static final Map<String, Function<JournalContentSearch, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<JournalContentSearch, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<JournalContentSearch, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<JournalContentSearch, Object>>();
		Map<String, BiConsumer<JournalContentSearch, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<JournalContentSearch, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion", JournalContentSearch::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<JournalContentSearch, Long>)
				JournalContentSearch::setMvccVersion);
		attributeGetterFunctions.put(
			"contentSearchId", JournalContentSearch::getContentSearchId);
		attributeSetterBiConsumers.put(
			"contentSearchId",
			(BiConsumer<JournalContentSearch, Long>)
				JournalContentSearch::setContentSearchId);
		attributeGetterFunctions.put(
			"groupId", JournalContentSearch::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<JournalContentSearch, Long>)
				JournalContentSearch::setGroupId);
		attributeGetterFunctions.put(
			"companyId", JournalContentSearch::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<JournalContentSearch, Long>)
				JournalContentSearch::setCompanyId);
		attributeGetterFunctions.put(
			"privateLayout", JournalContentSearch::getPrivateLayout);
		attributeSetterBiConsumers.put(
			"privateLayout",
			(BiConsumer<JournalContentSearch, Boolean>)
				JournalContentSearch::setPrivateLayout);
		attributeGetterFunctions.put(
			"layoutId", JournalContentSearch::getLayoutId);
		attributeSetterBiConsumers.put(
			"layoutId",
			(BiConsumer<JournalContentSearch, Long>)
				JournalContentSearch::setLayoutId);
		attributeGetterFunctions.put(
			"portletId", JournalContentSearch::getPortletId);
		attributeSetterBiConsumers.put(
			"portletId",
			(BiConsumer<JournalContentSearch, String>)
				JournalContentSearch::setPortletId);
		attributeGetterFunctions.put(
			"articleId", JournalContentSearch::getArticleId);
		attributeSetterBiConsumers.put(
			"articleId",
			(BiConsumer<JournalContentSearch, String>)
				JournalContentSearch::setArticleId);

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
	public long getContentSearchId() {
		return _contentSearchId;
	}

	@Override
	public void setContentSearchId(long contentSearchId) {
		_contentSearchId = contentSearchId;
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
	public boolean getPrivateLayout() {
		return _privateLayout;
	}

	@Override
	public boolean isPrivateLayout() {
		return _privateLayout;
	}

	@Override
	public void setPrivateLayout(boolean privateLayout) {
		_columnBitmask |= PRIVATELAYOUT_COLUMN_BITMASK;

		if (!_setOriginalPrivateLayout) {
			_setOriginalPrivateLayout = true;

			_originalPrivateLayout = _privateLayout;
		}

		_privateLayout = privateLayout;
	}

	public boolean getOriginalPrivateLayout() {
		return _originalPrivateLayout;
	}

	@Override
	public long getLayoutId() {
		return _layoutId;
	}

	@Override
	public void setLayoutId(long layoutId) {
		_columnBitmask |= LAYOUTID_COLUMN_BITMASK;

		if (!_setOriginalLayoutId) {
			_setOriginalLayoutId = true;

			_originalLayoutId = _layoutId;
		}

		_layoutId = layoutId;
	}

	public long getOriginalLayoutId() {
		return _originalLayoutId;
	}

	@Override
	public String getPortletId() {
		if (_portletId == null) {
			return "";
		}
		else {
			return _portletId;
		}
	}

	@Override
	public void setPortletId(String portletId) {
		_columnBitmask |= PORTLETID_COLUMN_BITMASK;

		if (_originalPortletId == null) {
			_originalPortletId = _portletId;
		}

		_portletId = portletId;
	}

	public String getOriginalPortletId() {
		return GetterUtil.getString(_originalPortletId);
	}

	@Override
	public String getArticleId() {
		if (_articleId == null) {
			return "";
		}
		else {
			return _articleId;
		}
	}

	@Override
	public void setArticleId(String articleId) {
		_columnBitmask |= ARTICLEID_COLUMN_BITMASK;

		if (_originalArticleId == null) {
			_originalArticleId = _articleId;
		}

		_articleId = articleId;
	}

	public String getOriginalArticleId() {
		return GetterUtil.getString(_originalArticleId);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), JournalContentSearch.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public JournalContentSearch toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, JournalContentSearch>
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
		JournalContentSearchImpl journalContentSearchImpl =
			new JournalContentSearchImpl();

		journalContentSearchImpl.setMvccVersion(getMvccVersion());
		journalContentSearchImpl.setContentSearchId(getContentSearchId());
		journalContentSearchImpl.setGroupId(getGroupId());
		journalContentSearchImpl.setCompanyId(getCompanyId());
		journalContentSearchImpl.setPrivateLayout(isPrivateLayout());
		journalContentSearchImpl.setLayoutId(getLayoutId());
		journalContentSearchImpl.setPortletId(getPortletId());
		journalContentSearchImpl.setArticleId(getArticleId());

		journalContentSearchImpl.resetOriginalValues();

		return journalContentSearchImpl;
	}

	@Override
	public int compareTo(JournalContentSearch journalContentSearch) {
		long primaryKey = journalContentSearch.getPrimaryKey();

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

		if (!(obj instanceof JournalContentSearch)) {
			return false;
		}

		JournalContentSearch journalContentSearch = (JournalContentSearch)obj;

		long primaryKey = journalContentSearch.getPrimaryKey();

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
		JournalContentSearchModelImpl journalContentSearchModelImpl = this;

		journalContentSearchModelImpl._originalGroupId =
			journalContentSearchModelImpl._groupId;

		journalContentSearchModelImpl._setOriginalGroupId = false;

		journalContentSearchModelImpl._originalCompanyId =
			journalContentSearchModelImpl._companyId;

		journalContentSearchModelImpl._setOriginalCompanyId = false;

		journalContentSearchModelImpl._originalPrivateLayout =
			journalContentSearchModelImpl._privateLayout;

		journalContentSearchModelImpl._setOriginalPrivateLayout = false;

		journalContentSearchModelImpl._originalLayoutId =
			journalContentSearchModelImpl._layoutId;

		journalContentSearchModelImpl._setOriginalLayoutId = false;

		journalContentSearchModelImpl._originalPortletId =
			journalContentSearchModelImpl._portletId;

		journalContentSearchModelImpl._originalArticleId =
			journalContentSearchModelImpl._articleId;

		journalContentSearchModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<JournalContentSearch> toCacheModel() {
		JournalContentSearchCacheModel journalContentSearchCacheModel =
			new JournalContentSearchCacheModel();

		journalContentSearchCacheModel.mvccVersion = getMvccVersion();

		journalContentSearchCacheModel.contentSearchId = getContentSearchId();

		journalContentSearchCacheModel.groupId = getGroupId();

		journalContentSearchCacheModel.companyId = getCompanyId();

		journalContentSearchCacheModel.privateLayout = isPrivateLayout();

		journalContentSearchCacheModel.layoutId = getLayoutId();

		journalContentSearchCacheModel.portletId = getPortletId();

		String portletId = journalContentSearchCacheModel.portletId;

		if ((portletId != null) && (portletId.length() == 0)) {
			journalContentSearchCacheModel.portletId = null;
		}

		journalContentSearchCacheModel.articleId = getArticleId();

		String articleId = journalContentSearchCacheModel.articleId;

		if ((articleId != null) && (articleId.length() == 0)) {
			journalContentSearchCacheModel.articleId = null;
		}

		return journalContentSearchCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<JournalContentSearch, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<JournalContentSearch, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<JournalContentSearch, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((JournalContentSearch)this));
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
		Map<String, Function<JournalContentSearch, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<JournalContentSearch, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<JournalContentSearch, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((JournalContentSearch)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, JournalContentSearch>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _mvccVersion;
	private long _contentSearchId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private boolean _privateLayout;
	private boolean _originalPrivateLayout;
	private boolean _setOriginalPrivateLayout;
	private long _layoutId;
	private long _originalLayoutId;
	private boolean _setOriginalLayoutId;
	private String _portletId;
	private String _originalPortletId;
	private String _articleId;
	private String _originalArticleId;
	private long _columnBitmask;
	private JournalContentSearch _escapedModel;

}