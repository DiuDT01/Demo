package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.demo.model.FgDynamicA;
import com.example.demo.model.FgDynamicB;

public class MainDynamicFg extends AppCompatActivity implements View.OnClickListener {
    // để bắt sự kiện của 2 cái nút, phải implements
    //
// trong layout có 2 button, bây giờ sẽ khai báo cho chúng ở đây 37:46
    private Button btA, btB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dynamic_main);
        btA = findViewById(R.id.btA);//ánh xạ btA, btB sang đây
        btB = findViewById(R.id.btB);
        //set cái lắng nghe sự kiện cho 2 button sau đó xuống dưới set việc tích chuột
        btA.setOnClickListener(this);
        btB.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // set việc tích chuột
        // --> có 2 lớp để quản lý: fragment manager, fragment transaction
        FragmentManager manager = getSupportFragmentManager() ;// gọi cái hàm SupportFragmentManager mục đích là,
        // mỗi 1 activity đều có 1 FragmentManager để quản lý cái layout của fragment đó
        FragmentTransaction transaction = manager.beginTransaction();
        //có 2 fragment, nên ta khai báo như sau
        Fragment fg;
        //bây giờ ta sẽ bắt 2 cái nút đó
        switch (view.getId()){
            // nếu ng dùng chon btA
            case R.id.btA:
                fg=new FgDynamicA();//thì ta sẽ tạo mới fgA
                transaction.add(R.id.frame,fg);//sau đó sẽ add fgA vào frame
                break;
            case R.id.btB://nếu ng dùng click vào nút B
                fg=new FgDynamicB();//thì ta sẽ tạo mới fgB
                transaction.add(R.id.frame,fg);//sau đó sẽ add fgB vào frame
                break;
        }
        //cuối cùng ta sẽ commit transaction
        transaction.commit();

    }
}