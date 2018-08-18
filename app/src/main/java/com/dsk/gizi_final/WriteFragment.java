package com.dsk.gizi_final;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.net.MalformedURLException;


public class WriteFragment extends Fragment {
    private EditText data1, data2, data3;
    private Button btn_send;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_writefragment, container, false);
        NetworkUtil.setNetworkPolicy();
        data1 = (EditText) v.findViewById(R.id.editname);
        data2 = (EditText) v.findViewById(R.id.edittitle);
        data3 = (EditText) v.findViewById(R.id.editcontent);
        btn_send = (Button) v.findViewById(R.id.savebutton);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    PHPRequest request = new PHPRequest("http://127.0.0.1/test/Data_insert.php");
                    String result = request.PhPtest(String.valueOf(data1.getText()), String.valueOf(data2.getText()), String.valueOf(data3.getText()));
                    /*if (result.equals("1")) {
                        Toast.makeText(getActivity().getApplication(), "들어감", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity().getApplication(), "안 들어감", Toast.LENGTH_SHORT).show();
                    }*/
                    WriteConfirmFragment writeConfirmFragment = new WriteConfirmFragment();
                    android.support.v4.app.FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
                    fragmenttransaction.replace(R.id.fragment_container, writeConfirmFragment);
                    fragmenttransaction.commit();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
        return v;
    }
}

