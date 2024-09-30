package com.example.socialmediatdcproject.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.socialmediatdcproject.R;

public class PostFragment extends Fragment {

    private static final String ARG_POST_TEXT = "post_text";

    public static PostFragment newInstance(String postText) {
        PostFragment fragment = new PostFragment();
        Bundle args = new Bundle();
        args.putString(ARG_POST_TEXT, postText);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post, container, false);

        // Lấy dữ liệu từ arguments
        String postText = getArguments() != null ? getArguments().getString(ARG_POST_TEXT) : "No Post";

        // Hiển thị nội dung post
        TextView textView = view.findViewById(R.id.post_content);
        textView.setText(postText);

        return view;
    }
}
