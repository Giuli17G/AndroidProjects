package com.example.memory2;

import android.media.MediaPlayer;

public class Suono {

  private MediaPlayer suono;
  private int id;

  public Suono(MediaPlayer suono, int id) {
     this.suono = suono;
     this.id = id;
  }

  public MediaPlayer getSuono() {
     return suono;
  }

  public int getId() {
    return id;
  }
}