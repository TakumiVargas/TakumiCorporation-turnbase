package mcm.edu.ph.Turnbasedgame_TakumiCorporations;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    int P1HP =        5000;
    int P1MinDMG =    10;
    int P1MaxDMG =    1000;
    String P1Name  =  "Spike";

    int P2HP =        5000;
    int P2MinDMG =    10;
    int P2MaxDMG =    1000;
    String P2Name  =  "Vaughn";

    int turnNumber = 1;



    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_main);


        Button nextTurn = findViewById(R.id.btnNextTurn);

        TextView txtP2Name = findViewById(R.id.txtEnemy_name);
        TextView txtP1Name = findViewById(R.id.txtPlayer_name);
        TextView txtP1HP = findViewById(R.id.txtEnemy_hp);
        TextView txtP2HP = findViewById(R.id.txtPlayer_hp);
        TextView txtP1DMG = findViewById(R.id.txtPlayerDPT);
        TextView txtP2DMG = findViewById(R.id.txtEnemyDPT);

        txtP1Name.setText(P1Name);
        txtP2Name.setText(P2Name);
        txtP1HP.setText(String.valueOf(P1HP));
        txtP2HP.setText(String.valueOf(P2HP));
        txtP1DMG.setText(P1MinDMG+ " ~ "+P1MaxDMG);
        txtP2DMG.setText(P2MinDMG+ " ~ "+P2MaxDMG);
        nextTurn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v){
        Random randomizer = new Random();

        Button nextTurn =       findViewById(R.id.btnNextTurn);
        TextView txtP2HP =    findViewById(R.id.txtEnemy_hp);
        TextView txtP1HP =    findViewById(R.id.txtPlayer_hp);
        TextView txtCombatLog = findViewById(R.id.txtTurnLog);

        txtP2HP.setText(String.valueOf(P2HP));
        txtP1HP.setText(String.valueOf(P1HP));

        int P1DMG = randomizer.nextInt(P1MaxDMG - P1MinDMG) + P1MinDMG;
        int P2DMG = randomizer.nextInt(P2MaxDMG - P2MinDMG) + P2MinDMG;

        switch (v.getId()){
            case R.id.btnNextTurn:

                if(turnNumber%2 == 1){
                    P2HP = P2HP - P1DMG;
                    turnNumber++;
                    txtCombatLog.setText("Spike dealt " +P1DMG+ " to Vaughn ooooo thats gotta hurt");
                    txtP2HP.setText(String.valueOf(P2HP));
                    nextTurn.setText("Next Turn ("+turnNumber+ ")");
                    if (P2HP < 0){
                        txtCombatLog.setText("Spike dealt " +P1DMG+ " to Vaughn and He slaughtered Vaughn with no mercy. SPIKE WINS THE MATCH!");
                        P1HP = 5000;
                        P2HP = 5000;
                        turnNumber = 1;
                        nextTurn.setText("Reset Game");
                    }
                }
                else if(turnNumber%2 != 1){
                    P1HP = P1HP - P2DMG;
                    turnNumber++;
                    txtCombatLog.setText("Vaughn chunked Spike with " +P2DMG+ " damage. It greatly damaged Spike! ");
                    txtP1HP.setText(String.valueOf(P1HP));
                    nextTurn.setText("Next Turn ("+turnNumber+ ")");
                    if (P1HP < 0){
                        txtCombatLog.setText("Vaughn unleashes his last move and dealt " +P2DMG+ " damage to Spike. VAUGHN WINS THE MATCH!");
                        P1HP = 5000;
                        P2HP = 5000;
                        turnNumber = 1;
                        nextTurn.setText("Reset Game");
                    }
                }
                break;
            }
        }
    }