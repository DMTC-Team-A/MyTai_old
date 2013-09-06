package jp.jagaimo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Pair;
import android.view.View;

/**
 * 設定の読み書きや便利メソッドを提供する。
 */
public class App {

    //region ページ遷移系
    /**
     * ページ遷移する。
     * @param thisPage 今のページ
     * @param destPage 行き先ページのClass
     */
    public static void Transition(final Activity thisPage, final Class destPage) {
        Intent intent = new Intent(thisPage, destPage);
        thisPage.startActivity(intent);
    }

    /**
     * 指定したViewがクリックされたら指定したページに飛ぶようにする。
     *
     * @param viewId   ViewのID
     * @param destPage 行き先ページのClass
     * @param page     元のページ
     */
    public static void SetTransition(final int viewId, final Class destPage, final Activity page) {
        page.findViewById(viewId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Transition(page, destPage);
            }
        });
    }

    /**
     * ViewのIDと行き先ページのClassのペアのリストを渡してページ遷移を設定する。
     *
     * @param pairs ViewのIDと行き先ページのClassのペアのリスト
     * @param page  　元のページ
     */
    public static void SetTransition(final Iterable<Pair<Integer, Class>> pairs, final Activity page) {
        for (final Pair<Integer, Class> pair : pairs) {
            SetTransition(pair.first, pair.second, page);
        }
    }
    //endregion

    public static Settings Settings;

    public static void Initialize(Context context) {
        //コンテキストが必要なもの
        App.Settings = new Settings(context);
    }

    private App() {
    }

    public static class UserData {
        private String name;
        private int age;
        private float height;
        private float baseWeight;
        private Pair<Integer, Integer> time;

        public UserData(String name, int age, float height, float baseWeight, int hour, int minute) {
            this.name = name;
            this.age = age;
            this.height = height;
            this.baseWeight = baseWeight;
            this.time = Pair.create(hour, minute);
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public float getHeight() {
            return height;
        }

        public float getBaseWeight() {
            return baseWeight;
        }

        public Pair<Integer, Integer> getTime() {
            return time;
        }
    }

    public static class Settings {
        private static final String PREF_NAME = "Name";
        private static final String PREF_AGE = "Age";
        private static final String PREF_HEIGHT = "Height";
        private static final String PREF_BASE_WIDTH = "BaseWidth";
        private static final String PREF_HOUR = "Hour";
        private static final String PREF_MINUTE = "Minute";

        private SharedPreferences prefs;

        private Settings(Context context) {
            prefs = PreferenceManager.getDefaultSharedPreferences(context);
        }

        public void setSettings(String name, int age, float height, float baseWeight, int hour, int minute) {
            SharedPreferences.Editor editor = prefs.edit();

            editor.putString(PREF_NAME, name);
            editor.putInt(PREF_AGE, age);
            editor.putFloat(PREF_HEIGHT, height);
            editor.putFloat(PREF_BASE_WIDTH, baseWeight);
            editor.putInt(PREF_HOUR, hour);
            editor.putInt(PREF_MINUTE, minute);
            editor.commit();
        }

        public UserData getSettings() {
            return new UserData(
                    prefs.getString(PREF_NAME, ""),
                    prefs.getInt(PREF_AGE, -1),
                    prefs.getFloat(PREF_HEIGHT, -1),
                    prefs.getFloat(PREF_BASE_WIDTH, -1),
                    prefs.getInt(PREF_HOUR, -1),
                    prefs.getInt(PREF_MINUTE, -1)
            );
        }
    }
}
