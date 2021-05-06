package com.example.memory2;

import com.example.memory2.Singleton;
import com.example.memory2.Suono;
import android.widget.Button;
//import android.widget.CompoundButton;
import android.widget.Toast;
//import android.media.Suono;
import android.view.View;


public class Tessera {

  public Suono suono;
  public Boolean girata;
  public Button bottone;
  private Tessera questa;

  public Tessera(Suono suono, Boolean girata, Button bottone) {
    this.suono = suono;
    this.girata = false;
    this.bottone = bottone;
    this.questa = this;
    this.bottone.setOnClickListener(new View.onClickListener() {
      Singleton.getIstance().setTessera(this);
      bottone.setEnabled(false);
      girata = true;
    });
  }


  public static void giraTessera(Tessera t) {
    t.bottone.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        t.bottone.setEnabled(false);
        //t.girata = true;
        t.suono.start();
      }
    });
  }

  public static Boolean isTesseraGirata(Tessera t) {
    return !t.girata;
  }


  public void trovata () {
    // lancia il suono
    vittoria.start();
    }

  public void nonTrovata () {
    bottone.setEnabled(true);
    perso.start();
  }

  public Suono getSuono() {
    return suono;
  }


  @override
  public Boolean equals(Object obj) {
    Tessera tessera = (Tessera)obj;
    if(tessera.getSuono().getId() == this.suono.getId()) {
      return true;
    }
    return false;
  }

}