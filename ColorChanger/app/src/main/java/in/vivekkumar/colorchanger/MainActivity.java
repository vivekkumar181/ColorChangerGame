package in.vivekkumar.colorchanger;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    TextView txtscore, txtscore1;
    String strscore;
    int score;
    Button buttonConfirm;
    final Handler handler_interact = new Handler();
    Button[] changingButtons = new Button[4];
    Timer timeoutTimer;
    final Random myRandom = new Random();
    GenerateTask genTask = new GenerateTask();
    final ArrayList<Object> arry1 = new ArrayList<Object>();
    Handler handler;
    LinearLayout lyt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);


        txtscore = findViewById(R.id.txtscore);
        txtscore1 = findViewById(R.id.txtscore1);
        strscore = txtscore1.getText().toString().trim();
        score = Integer.parseInt(strscore);
        changingButtons[0] = (Button) findViewById(R.id.button1);
        changingButtons[1] = (Button) findViewById(R.id.button2);
        changingButtons[2] = (Button) findViewById(R.id.button3);
        changingButtons[3] = (Button) findViewById(R.id.button4);
        lyt1 = findViewById(R.id.lyt1);

        if (!genTask.started) {
            genTask.started = true;
            timeoutTimer = new Timer();
            timeoutTimer.scheduleAtFixedRate(genTask, 0, 1000);

        } else {
            genTask.started = false;
            timeoutTimer.cancel();
        }

        final Thread animator = new Thread() {
            public void run() {
                int i = 0;
                try {
                    sleep(4000);
                    while (i < 4) {
                        sleep(50);
                        handler.sendMessage(handler.obtainMessage(i));
                        i++;
                    }
                } catch (Exception e) {

                }
            }
        };
        animator.start();
        lyt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animator.interrupt();
            }
        });
        handler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 0) {
                    timeoutTimer.cancel();
                    String totalscore = txtscore1.getText().toString().trim();

                    LayoutInflater li = LayoutInflater.from(MainActivity.this);
                    View confirmDialog = li.inflate(R.layout.dialog_confirm, null);
                    buttonConfirm = (Button) confirmDialog.findViewById(R.id.buttonConfirm);
                    TextView result = confirmDialog.findViewById(R.id.result);
                    result.setText("Your Total Score Is :" + totalscore);
                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setView(confirmDialog);
                    final AlertDialog alertDialog = alert.create();
                    alertDialog.show();
                    alertDialog.setCanceledOnTouchOutside(false);
                    buttonConfirm.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtscore1.setText("0");
                            alertDialog.cancel();
                            Intent i = new Intent(MainActivity.this, MainActivity.class);
                            startActivity(i);

                        }
                    });
                } else if (msg.what == 1) {

                } else if (msg.what == 2) {

                } else if (msg.what == 3) {

                }
            }

        };


        changingButtons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Value = txtscore.getText().toString().trim();
                animator.interrupt();
                if (Value.equals("[[0]]")) {
                    txtscore1.setText(String.valueOf(score++));
                    animator.start();
                } else {
                    String totalscore = txtscore1.getText().toString().trim();
                    timeoutTimer.cancel();
                    LayoutInflater li = LayoutInflater.from(MainActivity.this);
                    View confirmDialog = li.inflate(R.layout.dialog_confirm, null);
                    buttonConfirm = (Button) confirmDialog.findViewById(R.id.buttonConfirm);
                    TextView result = confirmDialog.findViewById(R.id.result);
                    result.setText("Your Total Score Is :" + totalscore);
                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setView(confirmDialog);
                    final AlertDialog alertDialog = alert.create();
                    alertDialog.show();
                    alertDialog.setCanceledOnTouchOutside(false);
                    buttonConfirm.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtscore1.setText("0");
                            alertDialog.cancel();
                            Intent i = new Intent(MainActivity.this, MainActivity.class);
                            startActivity(i);
                        }
                    });

                }
            }
        });

        changingButtons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Value = txtscore.getText().toString().trim();
                animator.interrupt();
                if (Value.equals("[[1]]")) {
                    txtscore1.setText(String.valueOf(score++));
                    animator.start();
                } else {
                    String totalscore = txtscore1.getText().toString().trim();
                    timeoutTimer.cancel();
                    LayoutInflater li = LayoutInflater.from(MainActivity.this);
                    View confirmDialog = li.inflate(R.layout.dialog_confirm, null);
                    buttonConfirm = (Button) confirmDialog.findViewById(R.id.buttonConfirm);
                    TextView result = confirmDialog.findViewById(R.id.result);
                    result.setText("Your Total Score Is :" + totalscore);
                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setView(confirmDialog);
                    final AlertDialog alertDialog = alert.create();
                    alertDialog.show();
                    alertDialog.setCanceledOnTouchOutside(false);
                    buttonConfirm.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtscore1.setText("0");
                            alertDialog.cancel();
                            Intent i = new Intent(MainActivity.this, MainActivity.class);
                            startActivity(i);

                        }
                    });

                }
            }
        });

        changingButtons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Value = txtscore.getText().toString().trim();
                animator.interrupt();
                if (Value.equals("[[2]]")) {
                    txtscore1.setText(String.valueOf(score++));
                    animator.start();
                } else {
                    String totalscore = txtscore1.getText().toString().trim();
                    timeoutTimer.cancel();
                    LayoutInflater li = LayoutInflater.from(MainActivity.this);
                    View confirmDialog = li.inflate(R.layout.dialog_confirm, null);
                    buttonConfirm = (Button) confirmDialog.findViewById(R.id.buttonConfirm);
                    TextView result = confirmDialog.findViewById(R.id.result);
                    result.setText("Your Total Score Is :" + totalscore);
                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setView(confirmDialog);
                    final AlertDialog alertDialog = alert.create();
                    alertDialog.show();
                    alertDialog.setCanceledOnTouchOutside(false);
                    buttonConfirm.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtscore1.setText("0");
                            alertDialog.cancel();
                            Intent i = new Intent(MainActivity.this, MainActivity.class);
                            startActivity(i);
                        }
                    });

                }
            }
        });

        changingButtons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Value = txtscore.getText().toString().trim();
                animator.interrupt();
                if (Value.equals("[[3]]")) {
                    txtscore1.setText(String.valueOf(score++));
                    animator.start();
                } else {
                    String totalscore = txtscore1.getText().toString().trim();
                    timeoutTimer.cancel();
                    LayoutInflater li = LayoutInflater.from(MainActivity.this);
                    View confirmDialog = li.inflate(R.layout.dialog_confirm, null);
                    buttonConfirm = (Button) confirmDialog.findViewById(R.id.buttonConfirm);
                    TextView result = confirmDialog.findViewById(R.id.result);
                    result.setText("Your Total Score Is :" + totalscore);
                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setView(confirmDialog);
                    final AlertDialog alertDialog = alert.create();
                    alertDialog.show();
                    alertDialog.setCanceledOnTouchOutside(false);
                    buttonConfirm.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            txtscore1.setText("0");
                            alertDialog.cancel();
                            Intent i = new Intent(MainActivity.this, MainActivity.class);
                            startActivity(i);
                        }
                    });

                }
            }
        });

    }


    class GenerateTask extends TimerTask {
        boolean started = false;

        @Override
        public void run() {
            if (started) {
                final TextView textGenerateNumber = (TextView) findViewById(R.id.txtscore);
                arry1.clear();
                for (int i = 0; i < 1; i++) {
                    ArrayList<Integer> Arry = new ArrayList<Integer>();
                    for (int k = 0; k < 1; k++) {
                        Arry.add(myRandom.nextInt(4));
                    }
                    arry1.add(Arry);
                }
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        textGenerateNumber.setText(String.valueOf(arry1));
                        if (textGenerateNumber.getText().equals("[[0]]")) {
                            changingButtons[0].setBackgroundColor(Color.GRAY);
                            changingButtons[1].setBackgroundColor(Color.BLUE);
                            changingButtons[2].setBackgroundColor(Color.RED);
                            changingButtons[3].setBackgroundColor(Color.GREEN);
                        } else if (textGenerateNumber.getText().equals("[[1]]")) {
                            changingButtons[0].setBackgroundColor(Color.YELLOW);
                            changingButtons[1].setBackgroundColor(Color.GRAY);
                            changingButtons[2].setBackgroundColor(Color.RED);
                            changingButtons[3].setBackgroundColor(Color.GREEN);
                        } else if (textGenerateNumber.getText().equals("[[2]]")) {
                            changingButtons[0].setBackgroundColor(Color.YELLOW);
                            changingButtons[1].setBackgroundColor(Color.BLUE);
                            changingButtons[2].setBackgroundColor(Color.GRAY);
                            changingButtons[3].setBackgroundColor(Color.GREEN);
                        } else if (textGenerateNumber.getText().equals("[[3]]")) {
                            changingButtons[0].setBackgroundColor(Color.YELLOW);
                            changingButtons[1].setBackgroundColor(Color.BLUE);
                            changingButtons[2].setBackgroundColor(Color.RED);
                            changingButtons[3].setBackgroundColor(Color.GRAY);
                        }
                    }
                });
            }
        }
    }
}
