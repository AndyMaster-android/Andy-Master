package com.example.andymaster.Android_Tetorials.A_ProgressBar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.amrdeveloper.codeview.CodeView;
import com.example.andymaster.Modelclasses.GoSyntaxManager;
import com.example.andymaster.R;

public class ProgressBar_java extends Fragment {
    CodeView mCodeView ;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String java_code = "package com.example.andymaster.ProgressBar;\n" +
                "\n" +
                "import androidx.appcompat.app.AppCompatActivity;\n" +
                "\n" +
                "import android.annotation.SuppressLint;\n" +
                "import android.app.ProgressDialog;\n" +
                "import android.content.Intent;\n" +
                "import android.os.Bundle;\n" +
                "import android.os.Handler;\n" +
                "import android.view.View;\n" +
                "import android.widget.Button;\n" +
                "\n" +
                "\n" +
                "public class ProgressBar_output extends AppCompatActivity {\n" +
                "\n" +
                "    AppCompatButton btnStartProgress;\n" +
                "    ProgressDialog progressBar;\n" +
                "    private int progressBarStatus = 0;\n"+
                "addListenerOnButton();\n"+
                " public void addListenerOnButton() {\n" +
                "\n" +
                "        btnStartProgress =  findViewById(R.id.btnStartProgress);\n" +
                "        btnStartProgress.setOnClickListener(\n" +
                "                new View.OnClickListener() {\n" +
                "\n" +
                "                    @Override\n" +
                "                    public void onClick(View v) {\n" +
                "\n" +
                "                        // prepare for a progress bar dialog\n" +
                "                        progressBar = new ProgressDialog(v.getContext());\n" +
                "                        progressBar.setCancelable(true);\n" +
                "                        progressBar.setMessage(\"File downloading ...\");\n" +
                "                        progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);\n" +
                "                        progressBar.setProgress(0);\n" +
                "                        progressBar.setMax(100);\n" +
                "                        progressBar.show();\n" +
                "\n" +
                "                        //reset progress bar status\n" +
                "                        progressBarStatus = 0;\n" +
                "\n" +
                "                        //reset filesize\n" +
                "                        fileSize = 0;\n" +
                "\n" +
                "                        new Thread(new Runnable() {\n" +
                "                            public void run() {\n" +
                "                                while (progressBarStatus < 100) {\n" +
                "\n" +
                "                                    // process some tasks\n" +
                "                                    progressBarStatus = doSomeTasks();\n" +
                "\n" +
                "                                    // your computer is too fast, sleep 1 second\n" +
                "                                    try {\n" +
                "                                        Thread.sleep(1000);\n" +
                "                                    } catch (InterruptedException e) {\n" +
                "                                        e.printStackTrace();\n" +
                "                                    }\n" +
                "\n" +
                "                                    // Update the progress bar\n" +
                "                                    progressBarHandler.post(new Runnable() {\n" +
                "                                        public void run() {\n" +
                "                                            progressBar.setProgress(progressBarStatus);\n" +
                "                                        }\n" +
                "                                    });\n" +
                "                                }\n" +
                "\n" +
                "                                // ok, file is downloaded,\n" +
                "                                if (progressBarStatus >= 100) {\n" +
                "\n" +
                "                                    // sleep 2 seconds, so that you can see the 100%\n" +
                "                                    try {\n" +
                "                                        Thread.sleep(2000);\n" +
                "                                    } catch (InterruptedException e) {\n" +
                "                                        e.printStackTrace();\n" +
                "                                    }\n" +
                "\n" +
                "                                    // close the progress bar dialog\n" +
                "                                    progressBar.dismiss();\n" +
                "                                }\n" +
                "                            }\n" +
                "                        }).start();\n" +
                "\n" +
                "                    }\n" +
                "\n" +
                "                });\n" +
                "\n" +
                "    }\n" +
                "\n" +
                "    // file download simulator... a really simple\n" +
                "    public int doSomeTasks() {\n" +
                "\n" +
                "        while (fileSize <= 1000000) {\n" +
                "\n" +
                "            fileSize++;\n" +
                "\n" +
                "            if (fileSize == 100000) {\n" +
                "                return 10;\n" +
                "            } else if (fileSize == 200000) {\n" +
                "                return 20;\n" +
                "            } else if (fileSize == 300000) {\n" +
                "                return 30;\n" +
                "            }\n" +
                "            // ...add your own\n" +
                "\n" +
                "        }\n" +
                "\n" +
                "        return 100;\n" +
                "\n" +
                "    }";

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
