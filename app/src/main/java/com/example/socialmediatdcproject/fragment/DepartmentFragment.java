package com.example.socialmediatdcproject.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.socialmediatdcproject.R;

public class DepartmentFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate layout cho fragment này
        return inflater.inflate(R.layout.fragment_department, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Tìm các nút
        Button infoButton = view.findViewById(R.id.button_department_info);
        Button postButton = view.findViewById(R.id.button_department_post);
        Button memberButton = view.findViewById(R.id.button_department_member);

        // Set màu mặc định cho nút "Bài viết"
        postButton.setBackgroundTintList(ContextCompat.getColorStateList(requireContext(), R.color.defaultBlue));
        postButton.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.white));

        infoButton.setOnClickListener(v -> {
            // Tạo instance của MemberFragment
            Fragment memberFragment = new MemberFragment();

            // Lấy FragmentManager từ Activity
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            // Thay thế second_content_fragment bằng MemberFragment
            transaction.replace(R.id.second_content_fragment, memberFragment);
            transaction.addToBackStack(null); // Nếu bạn muốn người dùng có thể quay lại Fragment trước đó
            transaction.commit();

            // Cập nhật màu cho các nút
            memberButton.setBackgroundTintList(ContextCompat.getColorStateList(requireContext(), R.color.white));
            memberButton.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.defaultBlue));
            postButton.setBackgroundTintList(ContextCompat.getColorStateList(requireContext(), R.color.white));
            postButton.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.defaultBlue));
            infoButton.setBackgroundTintList(ContextCompat.getColorStateList(requireContext(), R.color.defaultBlue));
            infoButton.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.white));
        });
        postButton.setOnClickListener(v -> {
            // Tạo instance của MemberFragment
            Fragment memberFragment = new PostFragment();

            // Lấy FragmentManager từ Activity
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            // Thay thế second_content_fragment bằng MemberFragment
            transaction.replace(R.id.second_content_fragment, memberFragment);
            transaction.addToBackStack(null); // Nếu bạn muốn người dùng có thể quay lại Fragment trước đó
            transaction.commit();

            // Cập nhật màu cho các nút
            infoButton.setBackgroundTintList(ContextCompat.getColorStateList(requireContext(), R.color.white));
            infoButton.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.defaultBlue));
            memberButton.setBackgroundTintList(ContextCompat.getColorStateList(requireContext(), R.color.white));
            memberButton.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.defaultBlue));
            postButton.setBackgroundTintList(ContextCompat.getColorStateList(requireContext(), R.color.defaultBlue));
            postButton.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.white));
        });

        // Sự kiện khi nhấn vào nút memberButton
        memberButton.setOnClickListener(v -> {
            // Tạo instance của MemberFragment
            Fragment memberFragment = new MemberFragment();

            // Lấy FragmentManager từ Activity
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            // Thay thế second_content_fragment bằng MemberFragment
            transaction.replace(R.id.second_content_fragment, memberFragment);
            transaction.addToBackStack(null);
            transaction.commit();

            // Cập nhật màu cho các nút
            infoButton.setBackgroundTintList(ContextCompat.getColorStateList(requireContext(), R.color.white));
            infoButton.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.defaultBlue));
            postButton.setBackgroundTintList(ContextCompat.getColorStateList(requireContext(), R.color.white));
            postButton.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.defaultBlue));
            memberButton.setBackgroundTintList(ContextCompat.getColorStateList(requireContext(), R.color.defaultBlue));
            memberButton.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.white));
        });
    }
}
