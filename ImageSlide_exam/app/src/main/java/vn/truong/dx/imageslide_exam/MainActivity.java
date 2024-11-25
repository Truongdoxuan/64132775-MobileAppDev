package vn.truong.dx.imageslide_exam;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int AUTO_SCROLL_DELAY = 1000; // Thời gian delay giữa các lần tự động lướt (3 giây)
    private ViewPager2 viewPager2;
    private Handler handler;
    private Runnable autoScrollRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo ViewPager2 và Adapter
        viewPager2 = findViewById(R.id.viewPager2);
        ImageSliderAdapter adapter = new ImageSliderAdapter(getImageList());
        viewPager2.setAdapter(adapter);

        // Khởi tạo TabLayout và kết nối với ViewPager2
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            // Chỉnh sửa thêm nếu cần
        }).attach();

        // Khởi tạo Handler để tự động thay đổi trang
        handler = new Handler();

        // Tạo một Runnable để thay đổi trang sau mỗi khoảng thời gian
        autoScrollRunnable = new Runnable() {
            @Override
            public void run() {
                // Lấy chỉ số trang hiện tại
                int currentItem = viewPager2.getCurrentItem();
                int totalItemCount = viewPager2.getAdapter().getItemCount();

                // Nếu đang ở trang cuối, quay lại trang đầu
                if (currentItem == totalItemCount - 1) {
                    viewPager2.setCurrentItem(0, true);
                } else {
                    // Nếu không thì chuyển đến trang tiếp theo
                    viewPager2.setCurrentItem(currentItem + 1, true);
                }

                // Tiếp tục gọi lại Runnable sau một khoảng thời gian
                handler.postDelayed(this, AUTO_SCROLL_DELAY);
            }
        };

        // Bắt đầu tự động lướt
        handler.postDelayed(autoScrollRunnable, AUTO_SCROLL_DELAY);
    }

    // Hàm để trả về danh sách hình ảnh
    private List<Integer> getImageList() {
        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.image1);  // Đảm bảo hình ảnh có trong drawable
        imageList.add(R.drawable.image2);
        imageList.add(R.drawable.image3);
        return imageList;
    }

    // Hủy tác vụ tự động lướt khi Activity bị hủy
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null) {
            handler.removeCallbacks(autoScrollRunnable); // Ngừng tự động lướt khi Activity bị hủy
        }
    }
}
