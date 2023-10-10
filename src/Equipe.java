package pacote;

public class Equipe {
    int vitorias, derrotas, golsMarcados, golsSofridos, pontos;
    String nome;

    public Equipe(String nome, int vitorias, int derrotas, int golsMarcados, int golsSofridos, int pontos) {
      this.nome = nome;
      this.vitorias = vitorias;
      this.derrotas = derrotas;
      this.golsMarcados = golsMarcados;
      this.golsSofridos = golsSofridos;
      this.pontos = pontos;
    }

    public String getNome() {
      return this.nome;
    }
  }
