package com.karacasoft.customlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddItemActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE = "com.karacasoft.customlistview.AddItemActivity.extraTitle";
    public static final String EXTRA_DESCRIPTION = "com.karacasoft.customlistview.AddItemActivity.extraDescription";

    private EditText edtTitle;
    private EditText edtDesc;

    private Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        edtTitle = (EditText) findViewById(R.id.edtTitle);
        edtDesc = (EditText) findViewById(R.id.edtDesc);

        btnOK = (Button) findViewById(R.id.btnOK);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString(EXTRA_TITLE, edtTitle.getText().toString());
                bundle.putString(EXTRA_DESCRIPTION, edtDesc.getText().toString());

                Intent i = new Intent();
                i.putExtras(bundle);
                setResult(RESULT_OK, i);

                finish();
            }
        });

    }
}
