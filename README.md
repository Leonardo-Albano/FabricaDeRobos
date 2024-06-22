Fábrica de Robôs Autônomos
Estrutura da Fábrica
A fábrica possui quatro esteiras, cada uma com funções específicas na produção e montagem dos robôs autônomos.

Primeira Esteira: Produção dos Membros dos Robôs
  Funcionários: 4 grupos de 12 funcionários cada.

  Grupos e Produção:
    Grupo 1: Braço esquerdo
    Grupo 2: Braço direito
    Grupo 3: Perna direita
    Grupo 4: Perna esquerda

  Organização: Cada grupo trabalha em mesas de forma circular.

  Produção: Cada funcionário pode produzir membros de forma autônoma. Assim que um membro é produzido, ele é colocado na esteira circular.

Segunda Esteira: Produção da Carcaça e Cabeça dos Robôs

  Funcionários: 2 grupos de 9 funcionários cada.

  Grupos e Produção:
    Grupo 1: Carcaça do robô
    Grupo 2: Cabeça do robô

  Organização: Funcionam de forma semelhante à primeira esteira.

Terceira Esteira: Montagem dos Robôs

  Funcionários: 3 grupos de 5 funcionários cada.
  Organização: Funcionários utilizam as 2 ferramentas adjacentes na mesa para montar o robô.

  Tarefas:
    Pegar peças da esteira 1: Braço direito, braço esquerdo, perna direita, perna esquerda.
    Pegar peças da esteira 2: Cabeça e corpo do robô.

  Montagem:
    Não usam as ferramentas para coleta de peças.
    Utilizam ferramentas apenas para montagem.
    Funcionários buscam peças simultaneamente, utilizando paralelismo.

Esteira Final: Armazenamento dos Robôs Montados

  Registro de Log:
    Posição do membro na esteira 1.
    Grupo e funcionário que fabricou o membro.
    Posição da cabeça e corpo na esteira 2.
    Grupo e funcionário que fabricou a cabeça e o corpo.
    Grupo e funcionário que montou o robô.
    Posição do robô na esteira final, pronto para venda.

Estratégia para Evitar Deadlocks
Ferramentas Adjacentes:
Cada funcionário utiliza apenas as duas ferramentas adjacentes na mesa.
Paralelismo na Busca de Peças:
Coleta de peças da esteira 1 e esteira 2 de forma simultânea, sem uso das ferramentas.
Exemplo de Log de um Robô
Membro da Esteira 1:
Posição: 3
Grupo: 1
Funcionário: 5
Cabeça/Corpo da Esteira 2:
Posição: 2
Grupo: 2
Funcionário: 7
Montagem:
Grupo: 3
Funcionário: 2
Posição na Esteira Final: 5

Imagine uma fábrica especializada na construção de Robôs autônomos que possui quatro esteiras. 

Na primeira esteira trabalha 4 grupos de 12 funcionários, onde cada grupo é alocado em uma mesa de forma circular. Estes grupos produzem os componentes necessários para fazer os membros do robô. Cada membro produzido é colocado na primeira esteira (circular), assim que ele fica pronto. O grupo 1 produz o braço esquerdo do robô, o grupo 2 produz o braço direito, o grupo 3 produz a perna direita e o grupo 4 produz a perna esquerda. Cada funcionário por si só é capaz de produzir o membro do robô de forma autônoma. 

Na segunda esteira trabalham 2 grupos de 9 funcionários, seguindo a mesma lógica, com o grupo 1 sendo encarregado de produzir a carcaça do robô e o grupo 2 encarregado da produção da cabeça do robô. 

Finalmente na terceira esteira, trabalham 3 grupos de 5 funcionários, os funcionários dos três grupos são responsáveis por pegar as seguintes peças: o braço direito, o braço esquerdo, perna esquerda, perna direita da esteira 1, a cabeça e corpo da esteira 2 para montar o robô, colocando ele em uma esteira final, para ficar armazenado para a venda.
*Importante, os funcionários em cada mesa, utilizam as 2 ferramentas adjacentes que estão na mesa para montar o robô. Use uma estratégia para evitar deadlocks. Os funcionários não produzem o robô de forma sequencial, ou seja, trabalham se possuírem a posse das peças e ferramentas.
** Não use as ferramentas para fazer a coleta de peças para a montagem do robô, as ferramentas são necessárias apenas para efetivamente montar o robô. Use paralelismo para o funcionário fazer a procura de peças nas 2 esteiras de forma simultânea.
Na esteira final, o objeto robô deve conter o seguinte log: posição que o membro se encontrava na esteira 1, grupo e funcionário que fabricou o membro. Posição que o corpo ou a cabeça do robô se encontrava na esteira 2, grupo e funcionário que fabricou a cabeça e o corpo. Finalmente, deve conter o grupo que montou o robô, o funcionário que fez a montagem e a posição que ele se encontra na esteira final, pronto para a venda

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
