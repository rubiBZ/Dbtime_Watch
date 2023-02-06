package com.example.dbtimemobile;

import static java.security.AccessController.getContext;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class AlertDetails extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_details);

        Log.d("rubi", "in AlertDetail");

        TextView textView, sndTxt;
        Button bt;
        ImageView img1, img2, img3, img4, img5;
        final Integer[] face = new Integer[1];
        textView = (TextView) findViewById(R.id.text_input);
        bt = (Button) findViewById(R.id.button3);
        img1 = (ImageView) findViewById(R.id.imageView1);
        img2 = (ImageView) findViewById(R.id.imageView2);
        img3 = (ImageView) findViewById(R.id.imageView3);
        img4 = (ImageView) findViewById(R.id.imageView4);
        img5 = (ImageView) findViewById(R.id.imageView5);
        sndTxt = (TextView) findViewById(R.id.textView2);

        findViewById(R.id.imageView1).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            public void onClick(View view) {
                textView.setVisibility((View.VISIBLE));
                bt.setVisibility((View.VISIBLE));
                face[0] = 1;
                img1.setImageResource(R.raw.mg_1bg);
                img2.setImageResource(R.raw.mg_2);
                img3.setImageResource(R.raw.mg_3);
                img4.setImageResource(R.raw.mg_4);
                img5.setImageResource(R.raw.mg_5);
                //TODO save locally time, choice and textInput
            }
        });
        findViewById(R.id.imageView2).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            public void onClick(View view) {
                textView.setVisibility((View.VISIBLE));
                bt.setVisibility((View.VISIBLE));
                face[0] = 2;
                img1.setImageResource(R.raw.mg_1);
                img2.setImageResource(R.raw.mg_2bg);
                img3.setImageResource(R.raw.mg_3);
                img4.setImageResource(R.raw.mg_4);
                img5.setImageResource(R.raw.mg_5);

                //TODO save locally time, choice and textInput
            }
        });
        findViewById(R.id.imageView3).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            public void onClick(View view) {
                textView.setVisibility((View.VISIBLE));
                bt.setVisibility((View.VISIBLE));
                face[0] = 3;
                img1.setImageResource(R.raw.mg_1);
                img2.setImageResource(R.raw.mg_2);
                img3.setImageResource(R.raw.mg_3bg);
                img4.setImageResource(R.raw.mg_4);
                img5.setImageResource(R.raw.mg_5);
                //TODO save locally time, choice and textInput
            }
        });
        findViewById(R.id.imageView4).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            public void onClick(View view) {
                textView.setVisibility((View.VISIBLE));
                bt.setVisibility((View.VISIBLE));
                face[0] = 4;
                img1.setImageResource(R.raw.mg_1);
                img2.setImageResource(R.raw.mg_2);
                img3.setImageResource(R.raw.mg_3);
                img4.setImageResource(R.raw.mg_4bg);
                img5.setImageResource(R.raw.mg_5);
                //TODO save locally time, choice and textInput
            }
        });
        findViewById(R.id.imageView5).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            public void onClick(View view) {
                textView.setVisibility((View.VISIBLE));
                bt.setVisibility((View.VISIBLE));
                face[0] = 5;
                img1.setImageResource(R.raw.mg_1);
                img2.setImageResource(R.raw.mg_2);
                img3.setImageResource(R.raw.mg_3);
                img4.setImageResource(R.raw.mg_4);
                img5.setImageResource(R.raw.mg_5bg);
                //TODO save locally time, choice and textInput
            }
        });

        /*
        public class KeyboardInputFragment extends Fragment {

            private GetInputFragment getInputFragment;

            @Override
            public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
                View view = inflater.inflate(R.layout.fragment_keyboard_input, container, false);
                final KeyboardInputFragment keyboardInputFragment = this;
                final EditText editText = view.findViewById(R.id.search_input);

                editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                        boolean handled = false;
                        if(actionId == EditorInfo.IME_ACTION_SEARCH) {
                            getInputFragment.sendResult(editText.getText().toString());
                            handled = true;
                            getActivity().getFragmentManager().beginTransaction().remove(keyboardInputFragment)
                                    .commitAllowingStateLoss();
                        }
                        return handled;
                    }
                });

                showSoftKeyboard(editText);
                return view;
            }

            public void setGetInputFragment(GetInputFragment getInputFragment) {
                this.getInputFragment = getInputFragment;
            }

            private void showSoftKeyboard(View view) {
                if(view.requestFocus()) {
                    InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    if(imm != null) {
                        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
                        imm.toggleSoftInput(0, 0);
                    } else {
                        Cat.e("Couldn't open keyboard");
                    }
                }
            }
        }

         */


        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sndTxt.setVisibility((View.VISIBLE));
                (new Handler()).postDelayed(this::yourMethod, 1000);

                //Intent i = new Intent(AlertDetails.this, MainActivity.class);
                //startActivity(i);
            }

            private void yourMethod() {
                finish();
                System.exit(0);
            }
        });
    }
}