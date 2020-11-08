//package br.com.mhbp.coursera.algorithmic.toolbox.week5;

import java.util.*;


class EditDistance {

  //editing, distance
  public static int EditDistance(String A, String B) {
    int[][] dp = new int [A.length() + 1][B.length() + 1];

    for (int i = 0; i < A.length() + 1; i++) {
      dp[i][0] = i;
    }

    for (int i = 0; i < B.length() + 1; i++) {
      dp[0][i] = i;
    }


//    print(dp);

    int min;

    // min d[i][j - 1] or d[i - 1][j] or d[i - 1][j - 1]
    for (int k = 1; k < B.length() + 1; k++) {
      for (int i = 1; i < A.length() + 1; i++) {
                        /* left */           /* up */                  /* left upper diagonal*/
        int cmp = 0;

        if (A.charAt(i - 1) == B.charAt(k - 1)) {
//        if ( i < A.length() && k < B.length() && A.charAt(i) == B.charAt(k)) {
          dp [i][k] = dp[i -1][k - 1];
        } else {
          dp [i][k] = Math.min(dp[i][k - 1] ,  Math.min(dp[i - 1][k],  dp[i -1][k - 1]) ) + 1;
        }

//        print(dp);
      }
    }

//    print(dp);
    //write your code here
    return dp[A.length()][B.length()];
  }

  private static void print(int[][] dp) {
    System.out.println();
    System.out.println();
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j< dp[0].length; j++)
        System.out.print(dp[i][j] + " ");
      System.out.println();
    }
    System.out.println();
    System.out.println();
  }

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }


}




























/*

0 1 2 3 4 5
1 1 2 3 4 4
2 1 2 3 4 4               => minha resposta errada
3 2 1 2 3 4
4 3 2 1 2 3
5 4 3 2 1 2


0 1 2 3 4 5
1 1	2 3	4 4
2 [2]2 3 4 5
3 3	2 3	4 5
4 4	3 2	3 4
5 5	4 3	2 3


  ""  s  h o r t
""
  0   1  2 3 4 5

p 1   1

o 2   2

r 3

t 4

s 5



Rua Joaquim Floriano, 871 , Itaim Bibi , Sao Paulo, SP CEP: 04534-013
Telefone: (11) 3889-9852



Dr Marcelo Vinicius


Nome Fantasia: CLINICA DE ACUPUNTURA SANTA HELENA
Razão Social: JGHJ SERVICOS MEDICOS SOCIEDADE SIMPLES LTDA
CNPJ: 26.243.136/0001-16
Tipo de Estabelecimento: Consultório/ Clínica, Serviço de Diagnóstico e Terapia
Endereço: RUA DOUTOR ALCEU DE CAMPOS RODRIGUES 46 CONJ 104
Bairro: VL. NOVA CONCEICAO
Município: SAO PAULO
UF: SP
CEP: 04544-000
Telefone: 11 - 50822456
 */




























