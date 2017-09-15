package com.example.alex.tictactoe;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.alex.tictactoe.R.string.O;
import static com.example.alex.tictactoe.R.string.X;
import static com.example.alex.tictactoe.R.string.draw;
import static com.example.alex.tictactoe.R.string.status_game;
import static com.example.alex.tictactoe.R.string.stroke_chross;
import static com.example.alex.tictactoe.R.string.stroke_zero;
import static com.example.alex.tictactoe.R.string.win_chross;
import static com.example.alex.tictactoe.R.string.win_zero;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBT_1;
    private Button mBT_2;
    private Button mBT_3;
    private Button mBT_4;
    private Button mBT_5;
    private Button mBT_6;
    private Button mBT_7;
    private Button mBT_8;
    private Button mBT_9;
    private Button[][] board;
    private int won;
    private TextView mTVGameStatus;

    private int strokeNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tictactoe_main);
        strokeNumber = getIntent().getIntExtra("strokeNumber", 0);
        initBoard();
    }

    private Button[][] initBoard() {
        board = new Button[][]{{mBT_1 = (Button) findViewById(R.id.bt_00),
                mBT_2 = (Button) findViewById(R.id.bt_01),
                mBT_3 = (Button) findViewById(R.id.bt_02)
        },
                {mBT_4 = (Button) findViewById(R.id.bt_10),
                        mBT_5 = (Button) findViewById(R.id.bt_11),
                        mBT_6 = (Button) findViewById(R.id.bt_12)
                },
                {mBT_7 = (Button) findViewById(R.id.bt_20),
                        mBT_8 = (Button) findViewById(R.id.bt_21),
                        mBT_9 = (Button) findViewById(R.id.bt_22),
                }
        };

        return board;
    }

    @Override
    public void onClick(View view) {
        mTVGameStatus = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(view.getId());

        if (Stroke(strokeNumber)) {
            button.setText(X);
            button.setClickable(false);
            mTVGameStatus.setText(stroke_zero);
            strokeNumber++;
        } else {
            button.setText(O);
            button.setClickable(false);
            mTVGameStatus.setText(stroke_chross);
            strokeNumber++;
        }
        if (won(board)) {
            mTVGameStatus.setText(won);
            for (Button[] aBoard : board) {
                for (Button anABoard : aBoard) {
                    anABoard.setClickable(false);
                }
            }
        }

    }

    public void onClickNewGame(View view) {
        mTVGameStatus = (TextView) findViewById(R.id.textView);
        mTVGameStatus.setText(status_game);
        for (Button[] aBoard : board) {
            for (Button anABoard : aBoard) {
                anABoard.setClickable(true);
                anABoard.setText("");
                anABoard.setBackgroundColor(ContextCompat.getColor(this, R.color.greenBoard));
            }
        }
        strokeNumber = getIntent().getIntExtra("strokeNumber", 0);
    }

    public boolean won(View[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ((i == 0 || i == 1 || i == 2) && j == 0) {
                    if (buttonText(board[i][j]).equals(buttonText(board[i][j + 1])) &&
                            buttonText(board[i][j + 1]).equals(buttonText(board[i][j + 2]))) {
                        if (ifCheck(board[i][j])) {
                            board[i][j].setBackgroundColor(ContextCompat.getColor(this, R.color.redBoard));
                            board[i][j+1].setBackgroundColor(ContextCompat.getColor(this, R.color.redBoard));
                            board[i][j+2].setBackgroundColor(ContextCompat.getColor(this, R.color.redBoard));
                            return true;
                        }
                        return false;
                    }
                }
                if ((j == 0 || j == 1 || j == 2) && i == 0) {
                    if (buttonText(board[i][j]).equals(buttonText(board[i + 1][j])) &&
                            buttonText(board[i + 1][j]).equals(buttonText(board[i + 2][j]))) {
                        if (ifCheck(board[i][j])) {
                            board[i][j].setBackgroundColor(ContextCompat.getColor(this, R.color.redBoard));
                            board[i+ 1][j].setBackgroundColor(ContextCompat.getColor(this, R.color.redBoard));
                            board[i+ 2][j].setBackgroundColor(ContextCompat.getColor(this, R.color.redBoard));
                            return true;
                        }
                        return false;
                    }
                }
                if (i == 0 && j == 0) {
                    if (buttonText(board[i][j]).equals(buttonText(board[i + 1][j + 1])) &&
                            buttonText(board[i + 1][j + 1]).equals(buttonText(board[i+2][j+2]))) {
                        if (ifCheck(board[i][j])) {
                            board[i][j].setBackgroundColor(ContextCompat.getColor(this, R.color.redBoard));
                            board[i+1][j+1].setBackgroundColor(ContextCompat.getColor(this, R.color.redBoard));
                            board[i+2][j+2].setBackgroundColor(ContextCompat.getColor(this, R.color.redBoard));
                            return true;
                        }
                        return false;
                    }
                }
                if (i == 2 && j == 0) {
                    if (buttonText(board[i][j]).equals(buttonText(board[i - 1][j + 1])) &&
                            buttonText(board[i - 1][j + 1]).equals(buttonText(board[i-2][j+2]))) {
                        if (ifCheck(board[i][j])) {
                            board[i][j].setBackgroundColor(ContextCompat.getColor(this, R.color.redBoard));
                            board[i-1][j+1].setBackgroundColor(ContextCompat.getColor(this, R.color.redBoard));
                            board[i-2][j+2].setBackgroundColor(ContextCompat.getColor(this, R.color.redBoard));
                            return true;
                        }
                        return false;
                    }
                }
                if (!buttonText(board[0][0]).equals("") && !buttonText(board[1][0]).equals("") &&
                        !buttonText(board[2][0]).equals("") && !buttonText(board[0][1]).equals("") &&
                        !buttonText(board[1][1]).equals("") && !buttonText(board[2][1]).equals("") &&
                        !buttonText(board[0][2]).equals("") && !buttonText(board[1][2]).equals("") &&
                        !buttonText(board[2][2]).equals("")) {
                    won = draw;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean ifCheck(View board) {
        if (buttonText(board).equals("")) {
            return false;
        } else if (buttonText(board).equals("X")) {
            won = win_chross;
            return true;
        } else {
            won = win_zero;
            return true;
        }

    }

    public String buttonText(View buttonText) {
        return ((TextView) buttonText).getText().toString();
    }

    private boolean Stroke(int strokeNumber) {
        return strokeNumber % 2 == 0;
    }
}