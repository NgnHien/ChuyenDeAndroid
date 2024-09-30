package com.example.socialmediatdcproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.example.socialmediatdcproject.R;
import com.example.socialmediatdcproject.fragment.BusinessFragment;
import com.example.socialmediatdcproject.fragment.DepartmentFragment;
import com.example.socialmediatdcproject.fragment.HomeFragment;
import com.example.socialmediatdcproject.fragment.PostFragment;
import com.example.socialmediatdcproject.fragment.YouthFragment;
import com.google.android.material.navigation.NavigationView;

public class SharedActivity extends AppCompatActivity {
    protected DrawerLayout drawerLayout;
    private FrameLayout firstContentFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shared_layout);

        // Thiết lập DrawerLayout và NavigationView
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        firstContentFragment = findViewById(R.id.first_content_fragment); // Khởi tạo FrameLayout

        // Thiết kế giao diện cho avatar
        ImageView imageView = findViewById(R.id.nav_avatar_user);
        Glide.with(this)
                .load(R.drawable.avatar_user)
                .circleCrop()
                .into(imageView);

        // Xử lý sự kiện nhấn vào icon 3 gạch để mở Navigation Drawer
        ImageButton navigationButton = findViewById(R.id.icon_navigation);
        navigationButton.setOnClickListener(v -> {
            if (!drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.openDrawer(GravityCompat.START);
            } else {
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

        // Thêm item vào NavigationView
        addNavigationItems(navigationView);

        // Gán fragment home là mặc định
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            // Nạp HomeFragment vào first_content_fragment
            fragmentTransaction.replace(R.id.first_content_fragment, new HomeFragment());

            // Giả dữ liệu các post
            String[] fakePosts = {"Post 1: Hello World!", "Post 2: Welcome to the app!", "Post 3: This is a fake post!"};

            // Nạp từng PostFragment vào fragment_content_second
            for (String post : fakePosts) {
                PostFragment postFragment = PostFragment.newInstance(post);
                fragmentTransaction.add(R.id.second_content_fragment, postFragment);
            }

            fragmentTransaction.commit();
        }

        // Thiết lập sự kiện click cho icon_back
        ImageButton backButton = navigationView.getHeaderView(0).findViewById(R.id.icon_back);
        backButton.setOnClickListener(v -> drawerLayout.closeDrawer(GravityCompat.START));

    }

    private void changeFrameLayoutHeight(int height) {
        ViewGroup.LayoutParams params = firstContentFragment.getLayoutParams();
        params.height = height; // Đặt chiều cao mới
        firstContentFragment.setLayoutParams(params); // Cập nhật LayoutParams
        Log.d("Height", "changeFrameLayoutHeight: " + params.height);
    }

    private void addNavigationItems(NavigationView navigationView) {
        LinearLayout navLayout = (LinearLayout) navigationView.getHeaderView(0).findViewById(R.id.nav_container);

        // Danh sách item để thêm vào Navigation Drawer
        int[] icons = {R.drawable.icon_home, R.drawable.icon_flag, R.drawable.icon_department, R.drawable.icon_department, R.drawable.icon_department, R.drawable.icon_group, R.drawable.icon_personal};
        String[] titles = {"Trang chủ", "Phòng đào tạo", "Khoa", "Doanh nghiệp", "Đoàn thanh niên", "Câu lạc bộ - Nhóm", "Trang cá nhân"};

        // Khởi tạo FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Duyệt qua danh sách và thêm từng item
        for (int i = 0; i < icons.length; i++) {
            View itemView = LayoutInflater.from(this).inflate(R.layout.nav_item_layout, navLayout, false);
            ImageView icon = itemView.findViewById(R.id.icon);
            TextView title = itemView.findViewById(R.id.title);
            icon.setImageResource(icons[i]);
            title.setText(titles[i]);

            // Thêm sự kiện click cho mỗi item
            final int index = i; // Lưu chỉ số để sử dụng trong sự kiện click
            itemView.setOnClickListener(v -> {
                Fragment fragment = null;
                switch (index) {
                    case 0:
                        // Home
                        fragment = new HomeFragment();
                        // Đặt chiều cao nếu là trang chủ thì là 100
                        changeFrameLayoutHeight(200);
                        break;
                    case 1:
                        // Phòng đào tạo
                        fragment = new DepartmentFragment();
                        changeFrameLayoutHeight(400);
                        break;
                    case 2:
                        // Khoa
                        fragment = new DepartmentFragment();
                        changeFrameLayoutHeight(750);
                        break;
                    case 3:
                        // Doanh nghiệp
                        fragment = new BusinessFragment();
                        changeFrameLayoutHeight(400);
                        break;
                    case 4:
                        // Đoàn thanh niên
                        fragment = new YouthFragment();
                        changeFrameLayoutHeight(800);
                        break;
                    default:
                        fragment = new HomeFragment();
                        changeFrameLayoutHeight(200);
                        break;
                }

                // Thay thế nội dung của FrameLayout bằng Fragment tương ứng
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.first_content_fragment, fragment);
                fragmentTransaction.commit();

                // Đóng Navigation Drawer sau khi chọn mục
                drawerLayout.closeDrawer(GravityCompat.START);
            });

            navLayout.addView(itemView);
        }
    }

    // Xử lý khi người dùng nhấn nút Back
    @Override
    public void onBackPressed() {
        // Kiểm tra nếu Navigation Drawer đang mở thì đóng lại
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed(); // Nếu Drawer không mở thì thực hiện hành vi mặc định
        }
    }
}