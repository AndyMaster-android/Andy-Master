package com.example.andymaster.Android_Tetorials.A_Check_Box;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.amrdeveloper.codeview.CodeView;
import com.example.andymaster.Modelclasses.GoSyntaxManager;
import com.example.andymaster.R;

public class checkbox_java extends Fragment {
    CodeView mCodeView ;
    GoSyntaxManager goSyntaxManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String java_code = "package example.Andymaster.com.checkbox;  \n" +
                "  \n" +
                "import android.support.v7.app.AppCompatActivity;  \n" +
                "import android.os.Bundle;  \n" +
                "import android.view.View;  \n" +
                "import android.widget.Button;  \n" +
                "import android.widget.CheckBox;  \n" +
                "import android.widget.Toast;  \n" +
                "  \n" +
                "public class MainActivity extends AppCompatActivity {  \n" +
                "    CheckBox pizza,coffe,burger;  \n" +
                "    Button buttonOrder;  \n" +
                "    @Override  \n" +
                "    protected void onCreate(Bundle savedInstanceState) {  \n" +
                "        super.onCreate(savedInstanceState);  \n" +
                "        setContentView(R.layout.activity_main);  \n" +
                "        addListenerOnButtonClick();  \n" +
                "    }  \n" +
                "    public void addListenerOnButtonClick(){  \n" +
                "        //Getting instance of CheckBoxes and Button from the activty_main.xml file  \n" +
                "        pizza=(CheckBox)findViewById(R.id.checkBox);  \n" +
                "        coffe=(CheckBox)findViewById(R.id.checkBox2);  \n" +
                "        burger=(CheckBox)findViewById(R.id.checkBox3);  \n" +
                "        buttonOrder=(Button)findViewById(R.id.button);  \n" +
                "  \n" +
                "        //Applying the Listener on the Button click  \n" +
                "        buttonOrder.setOnClickListener(new View.OnClickListener(){  \n" +
                "  \n" +
                "            @Override  \n" +
                "            public void onClick(View view) {  \n" +
                "                int totalamount=0;  \n" +
                "                StringBuilder result=new StringBuilder();  \n" +
                "                result.append(\"Selected Items:\");  \n" +
                "                if(pizza.isChecked()){  \n" +
                "                    result.append(\"\\nPizza 100Rs\");  \n" +
                "                    totalamount+=100;  \n" +
                "                }  \n" +
                "                if(coffe.isChecked()){  \n" +
                "                    result.append(\"\\nCoffe 50Rs\");  \n" +
                "                    totalamount+=50;  \n" +
                "                }  \n" +
                "                if(burger.isChecked()){  \n" +
                "                    result.append(\"\\nBurger 120Rs\");  \n" +
                "                    totalamount+=120;  \n" +
                "                }  \n" +
                "                result.append(\"\\nTotal: \"+totalamount+\"Rs\");  \n" +
                "                //Displaying the message on the toast  \n" +
                "                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();  \n" +
                "            }  \n" +
                "  \n" +
                "        });  \n" +
                "    }  \n" +
                "}  ";

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_button_java, container, false);
        mCodeView = view.findViewById(R.id.codeView);
        GoSyntaxManager.applyMonokaiTheme(getContext(), mCodeView);
        mCodeView.setText(java_code);
        mCodeView.cancelLongPress();
        mCodeView.cancelPendingInputEvents();
        return view;
    }
}
