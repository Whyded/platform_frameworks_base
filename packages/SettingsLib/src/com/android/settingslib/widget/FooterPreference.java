/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settingslib.widget;

import android.content.Context;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceViewHolder;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.widget.TextView;

import com.android.settingslib.R;

/**
 * A custom preference acting as "footer" of a page. It has a field for icon and text. It is added
 * to screen as the last preference.
 */
public class FooterPreference extends Preference {

    static final int ORDER_FOOTER = Integer.MAX_VALUE - 1;
    static final String KEY_FOOTER = "footer_preference";

    public FooterPreference(Context context, AttributeSet attrs) {
        super(context, attrs, TypedArrayUtils.getAttr(
                context, R.attr.footerPreferenceStyle, android.R.attr.preferenceStyle));
        init();
    }

    public FooterPreference(Context context) {
        this(context, null);
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        TextView title = holder.itemView.findViewById(android.R.id.title);
        title.setMovementMethod(new LinkMovementMethod());
    }

    private void init() {
        setIcon(R.drawable.ic_info_outline_24dp);
        setKey(KEY_FOOTER);
        setOrder(ORDER_FOOTER);
    }
}
