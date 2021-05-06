package com.example.memory2;

import com.example.memory2.Tessera;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.media.MediaPlayer;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;



public class MainActivity extends AppCompatActivity {

  Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;
  MediaPlayer cane, cavallo, gallo, gatto, toro, vittoria, perso;
  TextView textView1;
  ArrayList<Tessera> tessere = new ArrayList();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    b1 = (Button)findViewById(R.id.b1);
    b2 = (Button)findViewById(R.id.b2);
    b3 = (Button)findViewById(R.id.b3);
    b4 = (Button)findViewById(R.id.b4);
    b5 = (Button)findViewById(R.id.b5);
    b6 = (Button)findViewById(R.id.b6);
    b7 = (Button)findViewById(R.id.b7);
    b8 = (Button)findViewById(R.id.b8);
    b9 = (Button)findViewById(R.id.b9);
    b10 = (Button)findViewById(R.id.b10);

    cane = MediaPlayer.create(this, R.raw.cane);
    cavallo = MediaPlayer.create(this, R.raw.cavallo);
    gallo = MediaPlayer.create(this, R.raw.gallo);
    gatto = MediaPlayer.create(this, R.raw.gatto);
    toro = MediaPlayer.create(this, R.raw.toro);
    vittoria = MediaPlayer.create(this, R.raw.vittoria);
    perso = MediaPlayer.create(this, R.raw.perso);

    preparaIlGioco();
    //Toast.makeText(MainActivity.this, "Hai schiacciato", 10000).show();

  }


  // Ritorna un suono casuale
  private MediaPlayer ritornaSuono(ArrayList<MediaPlayer> s) {
    int r = new Random().nextInt(s.size());
    MediaPlayer suonoRandom = s.get(r);
    return suonoRandom;
  }

  // Ritorno un array di suoni casuale
  private ArrayList mescolaSuoni(MediaPlayer[] suoniArray) {
    ArrayList<MediaPlayer> suoni = new ArrayList(Arrays.asList(suoniArray));
    ArrayList<MediaPlayer> suoniDaRiempire = new ArrayList();
    // Riempio casualmente l'array di suoni
    int j = 0;
    while (suoniDaRiempire.size() != 10) {
      MediaPlayer suonoRandom = ritornaSuono(suoni);
      suoniDaRiempire.add(j, suonoRandom);
      suoni.remove(suonoRandom);
      j++;
    }
    return suoniDaRiempire;
  }

  private void preparaIlGioco() {
    MediaPlayer[] suoniArray = {cane, cane, cavallo, cavallo, gallo, gallo, gatto, gatto, toro, toro};
    ArrayList<MediaPlayer> listaSuoni = mescolaSuoni(suoniArray);

    tessere.add(new Tessera(listaSuoni.get(0), false, b1));
    tessere.add(new Tessera(listaSuoni.get(1), false, b2));
    tessere.add(new Tessera(listaSuoni.get(2), false, b3));
    tessere.add(new Tessera(listaSuoni.get(3), false, b4));
        tessere.add(new Tessera(listaSuoni.get(4), false, b5));

  }  // Fine preparaIlGioco()




}