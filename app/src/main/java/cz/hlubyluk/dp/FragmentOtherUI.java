package cz.hlubyluk.dp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by HlubyLuk on 28.02.15.
 */
public class FragmentOtherUI extends Fragment {

    public static FragmentOtherUI newInstanc(CharSequence text) {
        FragmentOtherUI fragment = new FragmentOtherUI();
        Bundle bundle = new Bundle();
        bundle.putCharSequence("text", text);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_other_ui, container, false);
        String text = getArguments().getString("text");
        TextView textView = (TextView) view.findViewById(R.id.ouiTV);
        textView.setText(text);
        return view;
    }
}
