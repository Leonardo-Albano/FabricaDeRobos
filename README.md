Imagine uma f�brica especializada na constru��o de Rob�s aut�nomos que possui quatro esteiras. 

Na primeira esteira trabalha 4 grupos de 12 funcion�rios, onde cada grupo � alocado em uma mesa de forma circular. Estes grupos produzem os componentes necess�rios para fazer os membros do rob�. Cada membro produzido � colocado na primeira esteira (circular), assim que ele fica pronto. O grupo 1 produz o bra�o esquerdo do rob�, o grupo 2 produz o bra�o direito, o grupo 3 produz a perna direita e o grupo 4 produz a perna esquerda. Cada funcion�rio por si s� � capaz de produzir o membro do rob� de forma aut�noma. 

Na segunda esteira trabalham 2 grupos de 9 funcion�rios, seguindo a mesma l�gica, com o grupo 1 sendo encarregado de produzir a carca�a do rob� e o grupo 2 encarregado da produ��o da cabe�a do rob�. Finalmente na terceira esteira, trabalham 3 grupos de 5 funcion�rios, os funcion�rios dos tr�s grupos s�o respons�veis por pegar as seguintes pe�as: o bra�o direito, o bra�o esquerdo, perna esquerda, perna direita da esteira 1, a cabe�a e corpo da esteira 2 para montar o rob�, colocando ele em uma esteira final, para ficar armazenado para a venda.

*Importante, os funcion�rios em cada mesa, utilizam as 2 ferramentas adjacentes que est�o na mesa para montar o rob�. Use uma estrat�gia para evitar deadlocks. Os funcion�rios n�o produzem o rob� de forma sequencial, ou seja, trabalham se possu�rem a posse das pe�as e ferramentas.

** N�o use as ferramentas para fazer a coleta de pe�as para a montagem do rob�, as ferramentas s�o necess�rias apenas para efetivamente montar o rob�. Use paralelismo para o funcion�rio fazer a procura de pe�as nas 2 esteiras de forma simult�nea.

Na esteira final, o objeto rob� deve conter o seguinte log: posi��o que o membro se encontrava na esteira 1, grupo e funcion�rio que fabricou o membro. Posi��o que o corpo ou a cabe�a do rob� se encontrava na esteira 2, grupo e funcion�rio que fabricou a cabe�a e o corpo. Finalmente, deve conter o grupo que montou o rob�, o funcion�rio que fez a montagem e a posi��o que ele se encontra na esteira final, pronto para a venda.  


{
  "Esteira01": {
    "tipo": "circular",
    "grupos": [
      {
        "nome": "Grupo01",
        "caracteristicas": "circular e 2 ferramentas",
        "funcionarios": 12,
        "responsabilidade": "braço esquerdo"
      },
      {
        "nome": "Grupo02",
        "caracteristicas": "circular e 2 ferramentas",
        "funcionarios": 12,
        "responsabilidade": "braço direito"
      },
      {
        "nome": "Grupo03",
        "caracteristicas": "circular e 2 ferramentas",
        "funcionarios": 12,
        "responsabilidade": "perna direita"
      },
      {
        "nome": "Grupo04",
        "caracteristicas": "circular e 2 ferramentas",
        "funcionarios": 12,
        "responsabilidade": "perna esquerda"
      }
    ]
  },
  "Esteira02": {
    "tipo": "circular",
    "grupos": [
      {
        "nome": "Grupo01",
        "caracteristicas": "circular e 2 ferramentas",
        "funcionarios": 9,
        "responsabilidade": "carcaça do robô"
      },
      {
        "nome": "Grupo02",
        "caracteristicas": "circular e 2 ferramentas",
        "funcionarios": 9,
        "responsabilidade": "cabeça do robô"
      }
    ]
  },
  "Esteira03": {
    "tipo": "circular",
    "grupos": [
      {
        "nome": "Grupo01",
        "caracteristicas": "circular e paralelismo",
        "funcionarios": 5,
        "responsabilidade": "todos os componentes e montam"
      },
      {
        "nome": "Grupo02",
        "caracteristicas": "circular e paralelismo",
        "funcionarios": 5,
        "responsabilidade": "todos os componentes e montam"
      },
      {
        "nome": "Grupo03",
        "caracteristicas": "circular e paralelismo",
        "funcionarios": 5,
        "responsabilidade": "todos os componentes e montam"
      }
    ]
  },
  "Esteira04": {
    "tipo": "log’s",
    "grupos": [
      {
        "nome": "Armazém"
      }
    ]
  }
}
