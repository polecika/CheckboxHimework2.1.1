package com.example.checkboxhimework211;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mInputMoney;
    private EditText mInputInfo;
    private Button mBtnOk;
    private CheckBox mBankCardChkBx;
    private CheckBox mMobilePhoneChkBx;
    private CheckBox mCashAddressChkBx;
    private String toastMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mInputMoney = findViewById(R.id.inputMoney);
        mInputInfo = findViewById(R.id.inputInfo);
        mBtnOk = findViewById(R.id.btnOK);
        mBankCardChkBx = findViewById(R.id.bankCardChkBx);
        mMobilePhoneChkBx = findViewById(R.id.mobilePhoneChkBx);
        mCashAddressChkBx = findViewById(R.id.cashAddressChkBx);
        mBtnOk.setEnabled(false);
        CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    switch (compoundButton.getId()) {
                        case R.id.bankCardChkBx:
                            resetCheckBoxes();
                            mBankCardChkBx.setChecked(true);
                            mInputInfo.setInputType(InputType.TYPE_CLASS_NUMBER);
                            toastMessage = "банковской картой";
                            mBtnOk.setEnabled(true);
                            break;
                        case R.id.mobilePhoneChkBx:
                            resetCheckBoxes();
                            mMobilePhoneChkBx.setChecked(true);
                            mInputInfo.setInputType(InputType.TYPE_CLASS_PHONE);
                            toastMessage = "с мобильного телефона";
                            mBtnOk.setEnabled(true);
                            break;
                        case R.id.cashAddressChkBx:
                            resetCheckBoxes();
                            mInputInfo.setInputType(InputType.TYPE_CLASS_TEXT);
                            mCashAddressChkBx.setChecked(true);
                            toastMessage = "наличными на месте";
                            mBtnOk.setEnabled(true);
                            break;
                        default:
                    }
                }
            }
        };
        mBankCardChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mMobilePhoneChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mCashAddressChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(mInputMoney.getText().toString().equals("") || mInputInfo.getText().toString().equals("")) {
                        Toast.makeText(MainActivity.this, "Одно из полей не заполнено или заполнено не верно", Toast.LENGTH_LONG).show();
                        throw new Exception("ошибка");
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Оплата " + toastMessage + " принята", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    Log.e("MainActivity",e.toString());
                }
            }
        });

    }

    private void resetCheckBoxes(){
        mBankCardChkBx.setChecked(false);
        mMobilePhoneChkBx.setChecked(false);
        mCashAddressChkBx.setChecked(false);
    }


}