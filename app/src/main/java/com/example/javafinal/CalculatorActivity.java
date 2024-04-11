package com.example.javafinal;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import com.google.android.material.button.MaterialButton;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    TextView calcDisplay, resDisplay;
    MaterialButton btnAc, btnZero, btnDot, btnEquals;
    MaterialButton btnOne, btnTwo, btnThree, btnSub;
    MaterialButton btnFour, btnFive, btnSix, btnPlus;
    MaterialButton btnSeven, btnEight, btnNine, btnMulti;
    MaterialButton btnC, btnOpenB, btnCloseB, btnDivide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        calcDisplay = findViewById(R.id.calcDisplay);
        resDisplay = findViewById(R.id.resDisplay);

        assignId(btnAc, R.id.btnAC);
        assignId(btnZero, R.id.btnZero);
        assignId(btnDot, R.id.btnDot);
        assignId(btnEquals, R.id.btnEqual);
        assignId(btnOne, R.id.btnOne);
        assignId(btnTwo, R.id.btnTwo);
        assignId(btnThree, R.id.btnThree);
        assignId(btnSub, R.id.btnSubtract);
        assignId(btnFour, R.id.btnFour);
        assignId(btnFive, R.id.btnFive);
        assignId(btnSix, R.id.btnSix);
        assignId(btnPlus, R.id.btnAdd);
        assignId(btnSeven, R.id.btnSeven);
        assignId(btnEight, R.id.btnEight);
        assignId(btnNine, R.id.btnNine);
        assignId(btnMulti, R.id.btnMult);
        assignId(btnC, R.id.btnC);
        assignId(btnOpenB, R.id.btnOpenBracket);
        assignId(btnCloseB, R.id.btnCloseBracket);
        assignId(btnDivide, R.id.btnDivide);
    }

    void assignId(MaterialButton btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MaterialButton button = (MaterialButton) v;
        String buttonText = button.getText().toString();
        String calculation = resDisplay.getText().toString();

        if (buttonText.equals("AC")) {
            calcDisplay.setText("0");
            resDisplay.setText("");
            return;
        }
        if (buttonText.equals(("="))) {
            // Evaluate the expression and update the result display
            String finalRes = getResult(calculation);
            if (!finalRes.equals("eerrr")) {
                calcDisplay.setText(finalRes);
            }
            return;
        }

        if (buttonText.equals(("C"))) {
            // Remove the last character from the calculation string
            if (!calculation.isEmpty()) {
                calculation = calculation.substring(0, calculation.length() - 1);
            }
        } else {
            // Append the button text to the calculation string
            calculation = calculation + buttonText;
        }

        // Update the result display
        resDisplay.setText(calculation);
    }


    String getResult(String data) {
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalRes = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
            return finalRes;
        }
        catch (Exception e){
            return "eerrr";
        }
    }
}