package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.demo.model.FgBackStackC;
import com.example.demo.model.FgDynamicA;
import com.example.demo.model.FgDynamicB;

public class MainBackStack extends AppCompatActivity {
    //khai báo 2 lớp để quản lý các fragment
    private FragmentManager manager;
    private FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.back_stack_main);
        manager= getSupportFragmentManager();//tạo
    }
    //tạo 1 phương thức add chung vì các nút tương đối là giống nhau
    private void add(Fragment fg, String tag, String name){
    //fg: fragment nói chung, tag: khi tạo fg sẽ có đuôi, khi add backstack cần cái đuôi để add vào,
        // name: có popA, nó nhảy về popA thì cần có tên
        transaction = manager.beginTransaction();//đầu tiên luôn phải tạo transaction để bắt đầu các phiên
        transaction.add(R.id.frame,fg,tag);//add fg vào frame, có thêm thuộc tính khác là tag
        transaction.addToBackStack(name);
        transaction.commit();
    }

    public void addA(View view) {
        FgDynamicA fg=new FgDynamicA();
        add(fg, "fragA", "fa");
    }
    public void addB(View view) {
        FgDynamicB fg=new FgDynamicB();
        add(fg, "fragB", "fb");
    }
    public void addC(View view) {
        FgBackStackC fg=new FgBackStackC();
        add(fg, "fragC", "fc");
    }
    //remove nói chung, khi muốn xóa thì xóa cái nào, đó là fragment
    // nên ta truyền tham số là fg và 1 cái đuôi tag
    private void remove(Fragment fg,String tag) {
        transaction = manager.beginTransaction();//gọi bắt đầu 1 tran
        fg = manager.findFragmentByTag(tag);//gọi fg ra bằng manager theo tag
        transaction.remove(fg);//gọi xóa, remove cái fg vừa tìm đđc
        transaction.commit();
    }

    //viết các lệnh xóa cụ thể cho các nút bên xml
    public void removeA(View view) {
        FgDynamicA fg = new FgDynamicA();//có cái fragmentA
        remove(fg, "fragA");//gọi cái remove, vì phải xóa A nên có tag được đặt trên add là fragA
    }

    public void removeB(View view) {
        FgDynamicB fg = new FgDynamicB();
        remove(fg, "fragB");
    }

    public void removeC(View view) {
        FgBackStackC fg = new FgBackStackC();
        remove(fg, "fragC");
    }

    //viết cho nút back, thực chất chỉ cần gọi popBackStack
        public void back(View view) {
        manager.popBackStack();
    }

    //viết cho popA, thực chất cx chỉ cần gọi popBackStack và thêm thuộc tính tên để phân biệt, đối số là 0
    public void popA(View view) {
        manager.popBackStack("fa",0);
    }
    //có phương thức có sẵn để gọi theo nút back của điện thoại
    // dùng onBackPressed
    @Override
    public void onBackPressed() {//nếu còn back được nghĩa là gọi getBackStackEntryCount() chưa về 0
        if (manager.getBackStackEntryCount() > 0) {
            manager.popBackStack();//thì gọi cái pop này ra
        }
        super.onBackPressed();
    }
}