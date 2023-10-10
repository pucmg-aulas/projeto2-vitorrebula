package pacote;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Campeonato {
    public List<Equipe> listaEquipes = new ArrayList<>();
    public List<Partida> listaPartidas = new ArrayList<>();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void cadastrarEquipe(Equipe equipe) {
      listaEquipes.add(equipe);
      listaEquipes.sort((e1, e2) -> e1.nome.compareTo(e2.nome));
      equipeCSV();
    }

    public void cadastrarPartida(Partida partida) {
      listaPartidas.add(partida);
      listaPartidas.sort((p1, p2) -> p1.data.compareTo(p2.data));
      partidaCSV();
    }

    public void equipeCSV() {
      try {
        BufferedWriter writer = new BufferedWriter(new FileWriter("equipes.csv"));
        for (Equipe equipe : listaEquipes) {
          writer.append(equipe.nome + "," + equipe.vitorias + "," + equipe.derrotas + "," + equipe.golsMarcados + ","
              + equipe.golsSofridos + "," + equipe.pontos);

          writer.append("\n");
        }
        writer.close();
      } catch (IOException e) {
        System.out.println("Erro ao salvar a equipe em equipes.csv");
      }
    }

    public void partidaCSV() {
      try {
        BufferedWriter writer = new BufferedWriter(new FileWriter("partidas.csv"));
        for (Partida partida : listaPartidas) {
          writer.append(partida.data.format(formatter) + "," + partida.equipe1.nome + "," + partida.equipe2.nome);
          if (partida.placarEquipe1 != -1 && partida.placarEquipe2 != -1) {
            writer.append("," + partida.placarEquipe1 + "," + partida.placarEquipe2 + "\n");
          } else {
            writer.append("\n");
          }
        }
        writer.close();
      } catch (IOException e) {
        System.out.println("Erro ao salvar a partida em partidas.csv");
      }
    }

    public void listarEquipes() {
      for (Equipe equipe : listaEquipes) {
        System.out.println(equipe.nome);
      }
      System.out.println();
    }

    public void listarPartidas() {
      for (Partida partida : listaPartidas) {
        System.out.println(partida.data.format(formatter) + " - " + partida.equipe1.nome + " x " + partida.equipe2.nome);
        if (partida.placarEquipe1 != -1 && partida.placarEquipe2 != -1) {
          System.out.print("Placar: " + partida.placarEquipe1 + " x " + partida.placarEquipe2);
          if (partida.placarEquipe1 > partida.placarEquipe2) {
            System.out.print(" - " + partida.equipe1.nome + " venceu\n");
          } else if (partida.placarEquipe1 < partida.placarEquipe2) {
            System.out.print(" - " + partida.equipe2.nome + " venceu\n");
          } else {
            System.out.print(" - Empate\n");
          }
        }
      }
      System.out.println();
    }

    public Equipe retornaEquipe(String nomeEquipe) {
      for (Equipe equipe : listaEquipes) {
        if (equipe.nome.equals(nomeEquipe)) {
          return equipe;
        }
      }
      return null;
    }

    public Partida retornaPartida(LocalDate data, String nomeEquipe1, String nomeEquipe2) {
      for (Partida partidaLista : listaPartidas) {
        if (partidaLista.data.equals(data) && partidaLista.equipe1.nome.equals(nomeEquipe1)
            && partidaLista.equipe2.nome.equals(nomeEquipe2)) {
          return partidaLista;
        }
      }
      return null;
    }
    
    public void tabelaClassificacao() {
      listaEquipes.sort((e1, e2) -> e2.pontos - e1.pontos);
      System.out.println("Tabela de classificação:\n");
      for (Equipe equipe : listaEquipes) {
        System.out.println(equipe.nome + " (" + (equipe.vitorias + equipe.derrotas) + " partida ) - " + equipe.pontos + " pontos, com " + equipe.vitorias + " vitórias e " + equipe.derrotas + " derrotas");
      }
      System.out.println();
    }

    public void melhorAtaqueDefesa() {
      listaEquipes.sort((e1, e2) -> e2.golsMarcados - e1.golsMarcados);
      System.out.println("Equipe com melhor ataque: " + listaEquipes.get(0).nome + " (" + listaEquipes.get(0).golsMarcados + " pontos marcados)");

      listaEquipes.sort((e1, e2) -> e1.golsSofridos - e2.golsSofridos);
      System.out.println("Equipe com melhor defesa: " + listaEquipes.get(0).nome + " (" + listaEquipes.get(0).golsSofridos + " pontos sofridos)\n");
    }
 
  }
