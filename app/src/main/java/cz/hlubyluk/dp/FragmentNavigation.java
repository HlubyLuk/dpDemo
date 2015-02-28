package cz.hlubyluk.dp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by HlubyLuk on 28.02.15.
 */
public class FragmentNavigation extends Fragment implements View.OnClickListener {

    IClickedButton clickedButton;

    public static FragmentNavigation newInstance() {
        FragmentNavigation fragment = new FragmentNavigation();
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof IClickedButton) {
            clickedButton = (IClickedButton) activity;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation, container, false);
        LinearLayout linearLayout = (LinearLayout) view.getRootView();
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            if (linearLayout.getChildAt(i) instanceof Button) {
                linearLayout.getChildAt(i).setOnClickListener(this);
            }
        }
        return view;
    }

    @Override
    public void onClick(View view) {
        clickedButton.clicked(view);
    }
}
