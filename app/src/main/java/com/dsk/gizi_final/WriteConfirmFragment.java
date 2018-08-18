package com.dsk.gizi_final;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class WriteConfirmFragment extends Fragment {
    private Button btn_fix, btn_delete, btn_commit;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_writeconfirmfragment, container, false);
        btn_fix = (Button) v.findViewById(R.id.fixbutton);
        btn_delete = (Button) v.findViewById(R.id.deletebutton);
        btn_commit = (Button) v.findViewById(R.id.commitbutton);
        btn_fix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WriteFixFragment writeFixFragment = new WriteFixFragment();
                android.support.v4.app.FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
                fragmenttransaction.replace(R.id.fragment_container, writeFixFragment);
                fragmenttransaction.commit();

            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


            }
        });

        btn_commit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


            }
        });
        return v;
    }
}
