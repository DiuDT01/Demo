package com.example.demo.model;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.demo.R;

public class FgDynamicA extends Fragment {
    @Nullable
    @Override// tạo 1 view(được ánh xạ từ R.layout), trả về 1 view, hiển thị ra
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);// gọi fragment
        return view;
    }

    @Override// ánh xạ các đối tượng vào đây để thao tác với các đối tượng đó
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        //bên xml có các đối tượng là button, edittext, nên cần thao tác với những đối tượng này
        EditText tName = view.findViewById(R.id.tName);
        Button bt = view.findViewById(R.id.bt);
        //thao tác như sau gõ vào 1 tên, tích  chuột vào nút, kq viết lại là hello cái tên ví dụ là chuyển màu cái tên đó
        //hành động 2: click chuột vào enter name thì trả về ban đầu, lại xóa chữ đó đi
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = tName.getText().toString();
                tName.setText("hello "+name+"!");
                tName.setBackgroundColor(Color.BLUE);// đổi màu cái nền khi tác dụng sang màu xanh
            }
        });
        tName.setOnClickListener(new View.OnClickListener() {//lại click vào tName
            @Override
            public void onClick(View view) {
                tName.setBackgroundColor(Color.TRANSPARENT);// đổi lại màu về ban đầu
                tName.setText("");// xóa dữ liệu đi, để trắng
            }
        });

    }
}
