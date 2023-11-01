# Spring Initializr

Esse é o repositório da API T2Sdemo, feito com Spring Initializr.

## Endpoints

Existe 2 endpoints que podem ser utilizado para GET e POST:<br/>
`localhost:8080/containers`<br/>
`localhost:8080/movements`

Os mesmos podem ser utilizados para o PATCH e o DELETE, basta adicionar como parâmetro o id na rota:<br/>
`localhost:8080/containers/23`<br/>
`localhost:8080/movements/23`

### Cadastro
POST /containers <br/>
POST /movements <br/>

### Busca
GET /containers <br/>
GET /movements <br/>

### Edição
PATCH /containers/:id<br/>
PATCH /movements/:id<br/>

### Deleção
DELETE /containers/:id<br/>
DELETE /movements/:id<br/>


<h1 align="center">
  🏀 T2S - API 🏀
</h1>

<p align = "center">
Este é o backend da aplicação T2Sdemo.

<blockquote align="center">“Focada exclusivamente no Setor Portuario.”</blockquote>

##

<h2 align="center">📦 Aqui está o projeto documentado no Notion 📦</h2>
<p align="center">
  <a href="https://www.notion.so/Teste-pr-tico-processo-seletivo-428930dec1da477793908604d1b2bd29?pvs=4">Clique para ver a documentão</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</p>

##

##

<h2 align="center">💠 E aqui o Jira desenvolvido para o projeto 💠</h2>
<p align="center">
  <a href="https://jveiga.atlassian.net/jira/software/projects/T2S/boards/1">Clique para ver a sprint</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</p>


##

<h2 align="center">📺 Video gravado apresentando o desenvolvimento 📺</h2>
<p align="center">
  <a href="https://www.youtube.com/watch?v=7UlvCm6doXA&feature=youtu.be">Clique para ver</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</p>

##

<p align="center">
  <a href="#instalação">Instalação</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</p>

## Instalação

    - Clonar repositorio
    $ git clone https://github.com/jveiiga/T2Sdemo.git
    
    Sobre o Projeto 📺
    
    - Rodando API
    É necessário que você encontre o Maven em seu editor de texto, ele vai ter uma estrura de pasta parecida com essa:
    
    > Pasta principal
    > ├── 📂 Lifecycle
    > │   ├── ⚙️ clean
    > │   ├── ⚙️ validate
    > │   ├── ⚙️ compile
    > │   ├── ⚙️ test
    > │   ├── ⚙️ test-compile
    > │   ├── ⚙️ package (Ao cliquar aqui, aparecerá um ícone desses ▶️ clique nele para intalar os pacotes de dependências).
    > │   ├── ⚙️ verify
    > │   ├── ⚙️ install
    > │   ├── ⚙️ site
    > │   ├── ⚙️ deploy
    > ├── 📁 Plugins
    > ├── 📁 Dependecies
    > ├── 📁 Favorite
    > ├── 📁 Profiles
    
    - Após instalar as depêndecias do projeto é necessário encontrar o arquivo ☕️ CardapioApplication.java
      
    > Pasta principal
    > ├── 📂 src
    > │   ├── 📂 main
    > │   └──── 📂 java
    > │   └────── 📂 com
    > │   └──────── 📂 example
    > │   └────────── 📂 T2Sdemo
                        └── ☕️ T2SdemoApplication.java (Ao cliquar aqui, aparecerá um ícone desses ▶️ no canto direito superior, clique nele e o servidor será inicializado).
                        
     -Ps: anexei ao projeto o Insomnia.json que pode ser importado no Insomnia e utilizado, mas sinta-se a vontade para utilizar o de sua prefêrencia.

<p align="center">
  <a href="#endpoints">Endpoints</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</p>

##

## **Endpoints**

API CRUD de Contêiners e Movimentos. <br/>

baseUrl da API: `localhost:8080`

## 🚨 Nenhuma rota necessita de autenticação 🚨

<a href="end">Rota Container</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

## Rota para cadastro de contêiner:

`POST /containers - FORMATO DA RESPOSTA - STATUS 200 OK`

```json
{
  "id": 4,
  "client": "Shein",
  "container_number": "TEST1234567",
  "type": 20,
  "status": true,
  "category": "importação"
}
```

## Rota para buscar todos contêiners:

`GET /containers - FORMATO DA RESPOSTA - STATUS 200 OK`

```json
[
  {
   "id": 2,
   "client": "Ali Express",
   "container_number": "TEST1234567",
   "type": 20,
   "status": true,
   "category": "importação"
  },
  {
   "id": 3,
   "client": "Shopee",
   "container_number": "TEST1234567",
   "type": 20,
   "status": true,
   "category": "importação"
  },
  {
   "id": 4,
   "client": "Shein",
   "container_number": "TEST1234567",
   "type": 20,
   "status": true,
   "category": "importação"
  }
]
```

## Rota para editar um contêiner: 

`PATCH /containers/:id - FORMATO DA RESPOSTA - STATUS 200 OK`

```json
{
  "id": 1,
  "client": "Shopee",
  "container_number": "TEST1234567",
  "type": 20,
  "status": false,
  "category": "importação"
}
```

## Rota para deletar um contêiner: 

`DELETE /containers/:id - FORMATO DA RESPOSTA - STATUS 204 NO CONTENT`

```json
"No body returned for response" 
```

## 🚨 Nenhuma rota necessita de autenticação 🚨

<a href="end">Rota Movement</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

## Rota para cadastro de movimento:

`POST /movements - FORMATO DA RESPOSTA - STATUS 200 OK`

```json
{
  "id": 4,
  "container": {
  "id": 3,
  "client": "Shopee",
  "container_number": "TEST1234567",
  "type": 20,
  "status": true,
  "category": "importação"
  },
  "movementType": "reposicionamento",
  "startTimeDate": "2023-05-31T15:22:21.825",
  "endTimeDate": "2023-05-31T15:22:21.825"
}
```

## Rota para buscar todos movimentos:

`GET /movements - FORMATO DA RESPOSTA - STATUS 200 OK`

```json
[
 {
    "id": 1,
    "containerId": 2,
    "movementType": "gate in",
    "startTimeDate": "2023-05-31T13:14:25.808",
    "endTimeDate": "2023-05-31T13:14:25.808"
   },
   {
    "id": 2,
    "containerId": 3,
    "movementType": "gate in",
    "startTimeDate": "2023-05-31T13:17:29.448",
    "endTimeDate": "2023-05-31T13:17:29.448"
   },
   {
    "id": 4,
    "containerId": 3,
    "movementType": "reposicionamento",
    "startTimeDate": "2023-05-31T15:22:21.825",
    "endTimeDate": "2023-05-31T15:22:21.825"
   }
]
```

## Rota para editar um movimento: 

`PATCH /movements/:id - FORMATO DA RESPOSTA - STATUS 200 OK`

```json
{
  "id": 3,
  "container": {
	  "id": 4,
	  "client": "Shein",
	  "container_number": "TEST1234567",
	  "type": 20,
	  "status": true,
	  "category": "importação"
  },
  "movementType": "gate out",
  "startTimeDate": "2023-05-31T13:19:37.16",
  "endTimeDate": "2023-05-31T13:19:37.16"
}
```

## Rota para deletar um movimento: 

`DELETE /movements/:id - FORMATO DA RESPOSTA - STATUS 204 NO CONTENT`

```json
"No body returned for response" 
```
