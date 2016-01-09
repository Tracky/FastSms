package com.example.fastsms.app;

import android.content.Context;
import android.widget.TextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {
    private Context context;

    public Check(Context context) {
        this.context = context;
    }

    public boolean validationString(TextView editText) {
        String userNameString = editText.getText().toString();
        Pattern p = Pattern.compile("^[a-zA-Z]+$");
        Matcher m = p.matcher(userNameString);
        return m.matches();
    }

    public boolean validationNumbers(TextView editText) {
        String userTelString = editText.getText().toString();
        Pattern p = Pattern.compile("[0-9]{1,10}");
        Matcher m = p.matcher(userTelString);
        return m.matches();
    }
}
