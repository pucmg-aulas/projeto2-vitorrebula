package pacote;

import java.time.LocalDate;

public class Partida {

    LocalDate data;

    Equipe equipe1;
    Equipe equipe2;

    int placarEquipe1;
    int placarEquipe2;

    public Partida(LocalDate data, Equipe equipe1, Equipe equipe2, int placarEquipe1, int placarEquipe2) {
      this.data = data;
      this.equipe1 = equipe1;
      this.equipe2 = equipe2;
      this.placarEquipe1 = placarEquipe1;
      this.placarEquipe2 = placarEquipe2;
    }

    public void registrarPlacar(int placarEquipe1, int placarEquipe2) {
      this.placarEquipe1 = placarEquipe1;
      this.placarEquipe2 = placarEquipe2;

      if (placarEquipe1 > placarEquipe2) {
        equipe1.vitorias++;
        equipe2.derrotas++;
        equipe1.pontos += 2;
        equipe2.pontos += 1;
      } else if (placarEquipe1 < placarEquipe2) {
        equipe2.vitorias++;
        equipe1.derrotas++;
        equipe2.pontos += 2;
        equipe1.pontos += 1;
      } 

      equipe1.golsMarcados += placarEquipe1;
      equipe1.golsSofridos += placarEquipe2;

      equipe2.golsMarcados += placarEquipe2;
      equipe2.golsSofridos += placarEquipe1;

    }
  }
