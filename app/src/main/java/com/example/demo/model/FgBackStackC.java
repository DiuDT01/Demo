package com.example.demo.model;

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

public class FgBackStackC extends Fragment {
    @Nullable
    @Override// tạo 1 view(được ánh xạ từ R.layout), trả về 1 view, hiển thị ra
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c, container, false);// gọi fragment
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
        bt.setOnClickListener(new View.OnClickListener() {//bắt sự kiện cho nút
            @Override
            public void onClick(View view) {
                String name = tName.getText().toString();//lấy data khi ng dùng nhập bất cứ gì
                tName.setText("hello "+name+"!");//dè lại lên tên đấy thêm chi tiết
//để cho khác fragment A thì để nguyên màu, ko đổi, khi tích chuột thì chỉ xóa đi thôi
            }
        });
        tName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tName.setText("");
            }
        });

    }
}
