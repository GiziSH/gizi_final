package com.dsk.gizi_final;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class WriteFixFragment extends Fragment {
    private Button btn_save;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_writefixfragment, container, false);

        btn_save = (Button) v.findViewById(R.id.savebutton);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* FinalConfirm finalConfirm = new FinalConfirm();
                android.support.v4.app.FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
                fragmenttransaction.replace(R.id.fragment_container, finalConfirm);
                fragmenttransaction.commit();*/
            }
        });
        return v;
    }
}
