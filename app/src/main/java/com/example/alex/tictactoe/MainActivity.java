package com.example.alex.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private Button bt_1;
    private Button bt_2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button newGame;
    private Button[][] board;
    private String won;
    private TextView gameText;

    private int strokeNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tictactoe_main);
        board = new Button[][]{{bt_1 = (Button) findViewById(R.id.button1),
                bt_2 = (Button) findViewById(R.id.button2),
                button3 = (Button) findViewById(R.id.button3)
        },
                {button4 = (Button) findViewById(R.id.button4),
                        button5 = (Button) findViewById(R.id.button5),
                        button6 = (Button) findViewById(R.id.button6)
                },
                {button7 = (Button) findViewById(R.id.button7),
                        button8 = (Button) findViewById(R.id.button8),
                        button9 = (Button) findViewById(R.id.button9),
                }
        };

        newGame = (Button) findViewById(R.id.button10);

    }

    @Override
    public void onClick(View view) {
        gameText = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(view.getId());
        if (Stroke(strokeNumber)) {
            button.setText("X");
            button.setClickable(false);
            strokeNumber++;
        } else {
            button.setText("O");
            button.setClickable(false);
            strokeNumber++;
        }
        if (won(board)) {
            gameText.setText(won);
            for (Button[] aBoard : board) {
                for (Button anABoard : aBoard) {
                    anABoard.setClickable(false);
                }
            }
        }
    }

    public void onClickNewGame(View view) {
        gameText = (TextView) findViewById(R.id.textView);
        gameText.setText("Идет Игра");
        for (Button[] aBoard : board) {
            for (Button anABoard : aBoard) {
                anABoard.setClickable(true);
                anABoard.setText("");
            }
        }
        strokeNumber = 1;
    }

    public boolean won(View[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ((i == 0 || i == 1 || i == 2) && j == 0) {
                    if (buttonText(board[i][j]).equals(buttonText(board[i][j + 1])) && buttonText(board[i][j + 1]).equals(buttonText(board[i][j + 2]))) {
                        if(ifCheck(board[i][j])) return true;
                        return false;
                    }
                }
                if ((j == 0 || j == 1 || j == 2) && i == 0) {
                    if (buttonText(board[i][j]).equals(buttonText(board[i + 1][j])) && buttonText(board[i + 1][j]).equals(buttonText(board[i + 2][j]))) {
                        if(ifCheck(board[i][j])) return true;
                        return false;
                    }
                }
                if (i == 0 && j == 0) {
                    if (buttonText(board[i][j]).equals(buttonText(board[i + 1][j + 1])) && buttonText(board[i + 1][j + 1]).equals(buttonText(board[i + 2][j + 2]))) {
                        if(ifCheck(board[i][j])) return true;
                        return false;
                    }
                }
                if (i == 2 && j == 0) {
                    if (buttonText(board[i][j]).equals(buttonText(board[i - 1][j + 1])) && buttonText(board[i - 1][j + 1]).equals(buttonText(board[i - 2][j + 2]))) {
                        if(ifCheck(board[i][j])) return true;
                        return false;
                    }
                }
                if (!buttonText(board[0][0]).equals("") && !buttonText(board[1][0]).equals("") && !buttonText(board[2][0]).equals("") && !buttonText(board[0][1]).equals("") && !buttonText(board[1][1]).equals("") && !buttonText(board[2][1]).equals("") && !buttonText(board[0][2]).equals("") && !buttonText(board[1][2]).equals("") && !buttonText(board[2][2]).equals("")) {
                    won = "Ничья";
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
            won = "Победил Крестик";
            return true;
        } else {
            won = "Победил Нолик";
            return true;
        }

    }

    public String buttonText(View buttonText) {
        return ((TextView) buttonText).getText().toString();
    }

    private boolean Stroke(int strokeNumber) {
        this.strokeNumber = strokeNumber;
        return strokeNumber % 2 == 0;
    }


}
