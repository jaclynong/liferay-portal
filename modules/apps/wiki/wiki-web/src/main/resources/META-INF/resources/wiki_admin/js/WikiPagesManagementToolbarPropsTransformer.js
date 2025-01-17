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

import {postForm} from 'frontend-js-web';

export default function propsTransformer({
	additionalProps: {deletePagesCmd, deletePagesURL, trashEnabled},
	portletNamespace,
	...otherProps
}) {
	const deletePages = () => {
		if (
			trashEnabled ||
			confirm(
				Liferay.Language.get(
					'are-you-sure-you-want-to-delete-the-selected-entries'
				)
			)
		) {
			postForm(document[`${portletNamespace}fm`], {
				data: {
					cmd: deletePagesCmd,
				},
				url: deletePagesURL,
			});
		}
	};

	return {
		...otherProps,
		onActionButtonClick: (event, {item}) => {
			if (item?.data?.action === 'deletePages') {
				deletePages();
			}
		},
	};
}
