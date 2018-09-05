package com.dsk.gizi_final;

import android.support.v4.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {
    /*private static String TAG = "phptest_MainActivity";

    private static final String TAG_JSON="webnautes";
    private static final String TAG_name = "name";
    private static final String TAG_line = "line";

    private TextView mTextViewResult;
    ArrayList<HashMap<String, String>> mArrayList;
    ListView mlistView;
    String mJsonString;




    public Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment2, container, false);

        mTextViewResult = (TextView)v.findViewById(R.id.textView_main_result);
        mlistView = (ListView) v.findViewById(R.id.listView_main_list);
        mArrayList = new ArrayList<>();

        GetData task = new GetData();
        task.execute("http://192.168.0.2/searchtest.php");

        return v;
    }

    private class GetData extends AsyncTask<String, Void, String>{
        ProgressDialog progressDialog;
        String errorString = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(getContext(),
                    "Please Wait", null, true, true);
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();
            mTextViewResult.setText(result);
            Log.d(TAG, "response  - " + result);

            if (result == null){

                mTextViewResult.setText(errorString);
            }
            else {

                mJsonString = result;
                showResult();
            }
        }


        @Override
        protected String doInBackground(String... params) {

            String serverURL = params[0];


            try {

                URL url = new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.connect();


                int responseStatusCode = httpURLConnection.getResponseCode();
                Log.d(TAG, "response code - " + responseStatusCode);

                InputStream inputStream;
                if(responseStatusCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                }
                else{
                    inputStream = httpURLConnection.getErrorStream();
                }


                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder sb = new StringBuilder();
                String line;

                while((line = bufferedReader.readLine()) != null){
                    sb.append(line);
                }


                bufferedReader.close();


                return sb.toString().trim();


            } catch (Exception e) {

                Log.d(TAG, "InsertData: Error ", e);
                errorString = e.toString();

                return null;
            }

        }
    }


    private void showResult(){
        try {
            JSONObject jsonObject = new JSONObject(mJsonString);
            JSONArray jsonArray = jsonObject.getJSONArray(TAG_JSON);

            for(int i=0;i<jsonArray.length();i++){

                JSONObject item = jsonArray.getJSONObject(i);


                String name = item.getString(TAG_name);
                String line = item.getString(TAG_line);
                HashMap<String, String> hashMap = new HashMap<>();


                hashMap.put(TAG_name, name);
                hashMap.put(TAG_line, line);


                mArrayList.add(hashMap);



            }
            List listtest = new ArrayList();
            for (int j=0;j<mArrayList.size();j++){

                //listtest.add(mArrayList.get(j).get("name"));
                listtest.add(mArrayList);
            }

            System.out.println(listtest);
            ListAdapter adapter = new SimpleAdapter(
                    getContext(), mArrayList, R.layout.item_list,
                    new String[]{TAG_name,TAG_line},
                    new int[]{R.id.textView_list_doornumber, R.id.textView_list_state}
            );

            mlistView.setAdapter(adapter);

        } catch (JSONException e) {

            Log.d(TAG, "showResult : ", e);
        }

    }*/

}
