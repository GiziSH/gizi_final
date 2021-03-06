package com.dsk.gizi_final;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WriteFragment extends Fragment {
    EditText et_name, et_title, et_content, et_password;
    String sname, stitle, scontent, spassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_writefragment, container, false);
        et_name = (EditText) v.findViewById(R.id.editname);
        et_title = (EditText) v.findViewById(R.id.edittitle);
        et_content = (EditText) v.findViewById(R.id.editcontent);
        et_password = (EditText) v.findViewById(R.id.password);

        // save 버튼을 눌렀을 때 생기는 일
        Button bt_save = (Button) v.findViewById(R.id.savebutton);
        bt_save.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                sname = et_name.getText().toString();
                stitle = et_title.getText().toString();
                scontent = et_content.getText().toString();
                spassword = et_password.getText().toString();

                saveDB save = new saveDB();
                save.execute("http://192.168.0.146/board_insert.php");
                WriteConfirmFragment writeConfirmFragment = new WriteConfirmFragment();
                android.support.v4.app.FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
                fragmenttransaction.replace(R.id.fragment_container, writeConfirmFragment);
                fragmenttransaction.addToBackStack(null);
                fragmenttransaction.commit();


            }
        });
        return v;
    }

    public class saveDB extends AsyncTask<String, Integer, String> {
        String data = "";

        @Override
        protected String doInBackground(String... params) {

            /* 인풋 파라메터값 생성 */
            String param = "u_name=" + sname + "&u_title=" + stitle + "&u_content=" + scontent + "&u_password=" + spassword;
            Log.e("POST", param);
            String serverURL = params[0];
            try {
                /* 서버연결 */
                URL url = new URL(serverURL);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.connect();


                /* 안드로이드 -> 서버 파라메터값 전달 */
                OutputStream outs = conn.getOutputStream();
                outs.write(param.getBytes("UTF-8"));
                outs.flush();
                outs.close();

                /* 서버 -> 안드로이드 파라메터값 전달 */
                InputStream is = null;
                BufferedReader in = null;


                is = conn.getInputStream();
                in = new BufferedReader(new InputStreamReader(is), 8 * 1024);
                String line = null;
                StringBuffer buff = new StringBuffer();
                while ((line = in.readLine()) != null) {
                    buff.append(line + "\n");
                }
                data = buff.toString().trim();
                Log.e("RECV DATA", data);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return data;
        }

        @Override
        protected void onPostExecute(String data) {
            super.onPostExecute(data);
            /* 서버에서 응답 */
            Log.e("RECV DATA", data);
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(getContext());

            if(data.equals("1"))
            {
                Log.e("RESULT","성공적으로 처리되었습니다!");
                alertBuilder
                        .setTitle("알림")
                        .setMessage("성공적으로 등록되었습니다!")
                        .setCancelable(true)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                WriteConfirmFragment writeConfirmFragment = new WriteConfirmFragment();
                                android.support.v4.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                fragmentTransaction.replace(R.id.fragment_container, writeConfirmFragment);
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();
                            }
                        });
                AlertDialog dialog = alertBuilder.create();
                dialog.show();
            }
        }
    }
}