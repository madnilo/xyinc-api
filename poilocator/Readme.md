# XY Inc API

   Esta é uma API do tipo RESTful. A API possui apenas um recurso, chamado POI (Point Of Interest), que basicamente representa pontos em um mapa. Neste cenário simplificado, cada coordenada (x,y) possui valores inteiros e positivos.  
  É possível cadastrar novos POI, listar os cadastrados, e obter os POI próximos a uma coordenada específica, dentro de um range. 

   Live Demo: https://xy-inc2.herokuapp.com/

### Como testar a API
- `View`: Uma view simples em html/js foi criada, para facilitar a visualização de POI cadastrados. Basta acessar pelo browser a url base da app. **Essa view usa dados do live demo no heroku.**
- `Cliente HTTP`: qualquer cliente pode ser usado.
- `Banco de Dados`: O banco de dados utilizado é o H2. É um banco de dados em memória, onde as tabelas são geradas automaticamente (por meio de ORM) a cada execução da app (e apagado cada vez que se para o servidor). Nenhuma configuração é necessária.
- `IDE`: Utilizado o Spring Tool Suite (baseado no eclipse), porém pode ser executado em outras IDEs como o intelliJ.
- `Segurança`: Spring Security está configurado com autenticação HTTP Basic, porém foi setado para deixar passar todas as requisições, e para permitir CORS.

### Rotas

Além das rotas requeridas, foram criadas duas rotas extra para facilitar o trabalho de testar a API.

| Método | Path | Descrição |
| ------ | ------ | ------ |
| GET | /points-of-interest | Lista todos os pontos de interesse cadastrados. |
| POST| /points-of-interest/new | Cadastra um novo objeto ponto de interesse. Após a criaçãouma URI é retornada no Header "Location".|
| GET | /points-of-interest/"x"/"y"/"d-max" | Obtém os pontos de interesse próximos do ponto (x,y) informado, numa distância máxima d-max.|
| GET | / | Pode ser utilizado no browser para exibir uma lista de POI cadastrados.|
| POST| /points-of-interest/populate-db | cadastra uma lista de objetos pontos de interesse. |
| GET | /points-of-interest/"id" | Obtém um ponto de interesse de id específica. |


#### Um objeto

```json
{
"nome":"Lanchonete",
"x":"27",
"y":"12"
}
```

#### Uma lista
```json
[
    {
        "nome": "Lanchonete",
        "x": 27,
        "y": 12
    },
    {
        "nome": "Posto",
        "x": 31,
        "y": 18
    },
    {
        "nome": "Joalheria",
        "x": 15,
        "y": 12
    },
    {
        "nome": "Floricultura",
        "x": 19,
        "y": 21
    },
    {
        "nome": "Pub",
        "x": 12,
        "y": 8
    },
    {
        "nome": "Supermercado",
        "x": 23,
        "y": 6
    },
    {
        "nome": "Churrascaria",
        "x": 28,
        "y": 2
    }
]
```

### Testes Automatizados
Os testes criados são baseados no software Postman, especializado no teste de APIs. Um **arquivo JSON** está incluso na pasta "resources", este arquivo pode ser **importado no Postman** e contém a suíte de testes da API. Os testes automatizados são de unidade, da modalidade caixa preta. Atuam sobre cada end point separadamente, porém podem ser criados testes co-dependentes se necessário.

##### Regras de Negócio
As camadas de serviço relacionadas as regras de negócio não foram implementadas por falta de especificação. No entanto o sistema é facilmente expansível, por adotar um modelo de camadas bem definidas.
