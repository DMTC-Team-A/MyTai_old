package jp.jagaimo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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

    public static void Initialize(Context context) {
        //コンテキストが必要なもの
    }

    private App() {
    }
}
