package com.hackingbuzz.telephonicmanagerapp;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;

//Managers can Control Hardware ...... so Telephony Manger can Control Phone Type Specfic Hardware.

public class MainActivity extends Activity {
    TextView tt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tt = (TextView) findViewById(R.id.textView);

        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        String IMEINumber = telephonyManager.getDeviceId();
        String susciberID = telephonyManager.getSubscriberId();
        String simSeralNumber = telephonyManager.getSimSerialNumber();
        String countryISO = telephonyManager.getSimCountryIso();
        String networkCountryISO = telephonyManager.getNetworkCountryIso();

        String software = telephonyManager.getDeviceSoftwareVersion();
        String voiceMailNumber = telephonyManager.getVoiceMailNumber();
        String strPhoneType = "";

        int phoneType = telephonyManager.getPhoneType();
        switch(phoneType) {
            case TelephonyManager.PHONE_TYPE_CDMA:
                strPhoneType = "CDMA";
                break;
            case TelephonyManager.PHONE_TYPE_GSM:
                strPhoneType ="GSM";
                break;
            case TelephonyManager.PHONE_TYPE_NONE:
                strPhoneType ="NONE";
                break;
        }
        Boolean roaming = telephonyManager.isNetworkRoaming();
        int networkType = telephonyManager.getNetworkType();

        String info = "Your Phone Details\n";
        info+="\nIMEI NUMBER: "+ IMEINumber;
        info+="\nSuscriberID: "+ susciberID;
        info+="\nSimSerialNumber: "+ simSeralNumber;
        info+="\nCountryISO: "+ countryISO;
        info+="\nSoftware: "+ software;
        info+="\nVoiceMailNumber: "+voiceMailNumber;
        info+="\nPhoneType: "+strPhoneType;
        info+="\nRoaming: "+roaming;
        info+="\nNetworkType: "+networkType;

        tt.setText(info);
    }
}
