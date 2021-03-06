/*
 *  Copyright (c) 2017.  Joe
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package com.lovejjfg.arsenal.utils;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.util.Pair;
import android.view.View;

import com.lovejjfg.arsenal.R;
import com.lovejjfg.arsenal.api.mode.ArsenalDetailInfo;
import com.lovejjfg.arsenal.api.mode.ArsenalUserInfo;
import com.lovejjfg.arsenal.ui.AboutActivity;
import com.lovejjfg.arsenal.ui.ArsenalDetailInfoActivity;
import com.lovejjfg.arsenal.ui.ArsenalListInfoFragment;
import com.lovejjfg.arsenal.ui.ArsenalSearchActivity;
import com.lovejjfg.arsenal.ui.ArsenalUserInfoActivity;

/**
 * Created by Joe on 2016/3/18.
 * Email lovejjfg@gmail.com
 */
public class JumpUtils {
    public static void jumpToUserDetail(Context context, ArsenalUserInfo info, View mView) {
        Intent intent = new Intent(context, ArsenalUserInfoActivity.class);
        intent.putExtra(ArsenalUserInfoActivity.USER_INFO, info);
        //            ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(((Activity) context), iv, "img");
        if (context instanceof Activity) {
            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(((Activity) context),
                    Pair.create(((View)mView.getParent()), context.getString(R.string.name_app_bar)),
                    Pair.create(((View)mView.getParent()), context.getString(R.string.container))
            );
            ActivityCompat.startActivity(context, intent, activityOptions.toBundle());
        } else {
            context.startActivity(intent);
        }

    }

    public static void jumpToSearchList(Context context, String tagKey) {
        Intent intent = new Intent(context, ArsenalSearchActivity.class);
        intent.putExtra(ArsenalListInfoFragment.KEY, tagKey);
        intent.putExtra(ArsenalListInfoFragment.TYPE_NAME, ArsenalListInfoFragment.TYPE_SEARCH);
        if (context instanceof Activity) {
            ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(((Activity) context));
            ActivityCompat.startActivity(context, intent, activityOptions.toBundle());
        } else {
            context.startActivity(intent);
        }
    }

    public static void jumpToSearchList(Context context, String tagName, String tagKey) {
        Intent intent = new Intent(context, ArsenalSearchActivity.class);
        intent.putExtra(ArsenalListInfoFragment.KEY, tagKey);
        intent.putExtra(ArsenalListInfoFragment.TAG_NAME, tagName);
        intent.putExtra(ArsenalListInfoFragment.TYPE_NAME, ArsenalListInfoFragment.TYPE_SEARCH_TAG);
        if (context instanceof Activity) {
            ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(((Activity) context));
            ActivityCompat.startActivity(context, intent, activityOptions.toBundle());
        } else {
            context.startActivity(intent);
        }
    }

    public static void jumpToDetail(Context context, ArsenalDetailInfo detailUrl, View mView) {
        Intent intent = new Intent(context, ArsenalDetailInfoActivity.class);
        intent.putExtra(ArsenalDetailInfoActivity.INFO, detailUrl);
        if (context instanceof Activity) {
            ActivityOptions options =
                    ActivityOptions.makeSceneTransitionAnimation(((Activity) context),
                            Pair.create(mView, context.getString(R.string.container)),
                            Pair.create(mView, context.getString(R.string.name_app_bar))
                    );
            context.startActivity(intent, options.toBundle());
        } else {
            context.startActivity(intent);
        }
    }


    public static void jumpToAbout(Context context) {
        Intent intent = new Intent(context, AboutActivity.class);
        if (context instanceof Activity) {
            ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(((Activity) context));
            ActivityCompat.startActivity(context, intent, activityOptions.toBundle());
        } else {
            context.startActivity(intent);
        }
    }

    public static void jumpToWeb(Context context, String url) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        Uri uri = Uri.parse(url);
        intent.setData(uri);
        context.startActivity(Intent.createChooser(intent, url));
    }
}
