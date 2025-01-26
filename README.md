# API INCLUDIO (Projeto Back-End)

__Foi o meu primeiro projeto "grande" que fiz sem direcionamento de alguem.__

Este projeto foi desenvolvido durante o curso de Engenharia de Software, com o objetivo de criar uma plataforma para divulgação de vagas de emprego direcionadas a pessoas autistas. O projeto visa apoiar a inclusão no mercado de trabalho, proporcionando um meio de comunicação acessível entre empresas e candidatos.

O sistema foi desenvolvido utilizando o framework Spring Boot, com foco na construção de uma API RESTful que permita a interação com o banco de dados e o gerenciamento de vagas de emprego, usuários e empresas. O back-end foi estruturado para garantir escalabilidade, segurança e desempenho.

## Tecnologias Utilizadas

- **Java**: Linguagem principal do projeto.
- **Spring Framework**: Para a construção da aplicação back-end.
  - **Spring Boot**: Facilitando a inicialização e configuração do projeto.
  - **Spring Data JPA**: Integração com o JPA para manipulação de dados.
  - **Spring Security**: Para autenticação e controle de acesso.
  - **Spring Web**: Para a criação de APIs REST.
- **Banco de Dados**:
  - **MongoDB**: Banco de dados não relacional orientado a documento utilizado para armazenar os dados.
- **Maven**: Gerenciador de dependências.

## Funcionalidades

- **Gestão de Usuários**:
  - Criação, leitura, atualização e exclusão de usuários.
  - Autenticação de usuários e controle de acesso.
- **Gestão de Vagas**:
  - Criação, leitura, atualização e exclusão de vagas de emprego.
  - Filtros para busca de vagas específicas.
- **Gestão de Empresas**:
  - Cadastro e atualização de empresas que oferecem vagas.
- **Endpoints RESTful**:
  - Exposição de endpoints para interação com as funcionalidades do sistema.

## Estrutura do Projeto

O projeto segue uma arquitetura bem organizada para facilitar a manutenção e expansão:

````
src/main/java/
|-- com.projetoextensao/.autismo
    |-- config/           # Configurações de segurança e banco de dados
    |-- controller/       # Controladores REST para gerenciar as entidades
    |-- model/            # Modelos das entidades 
    |-- exception/        # Tratamento de alguma exceções
    |-- repository/       # Interfaces para acesso aos dados
    |-- service/          # Lógica de negócios
    |-- dto/              # Objetos de transferência de dados (DTOs)
````


## Endpoints Principais

### Autenticação
- **POST /auth/login**: Realiza login do usuário e retorna um token.

### Empresa
- **POST /api/account/company/register**: Registra uma nova empresa.
- **POST /api/account/company/edit**: Edita o perfil da empresa.
- **GET /api/account/company/{id}**: Retorna os detalhes de uma empresa.

### Funcionário
- **POST /api/account/employee/register**: Registra um novo funcionário.
- **GET /api/account/employee/{id}**: Retorna os detalhes de um funcionário.

### Empregador
- **POST /api/account/employer/register**: Registra um novo empregador.
- **GET /api/account/employer/{id}**: Retorna os detalhes de um empregador.

### Feedback
- **POST /api/account/feedback**: Registra um feedback.

### Postagens
- **GET /api/account/employer/post**: Retorna todas as postagens disponíveis.


## Aprendizados

Durante o desenvolvimento deste projeto, aprendi e apliquei diversos conceitos importantes:

- Desenvolvimento de APIs RESTful com Spring Boot.
- Integração com banco de dados MongoDB.
- Implementação de controle de autenticação e autorização com Spring Security.
- Como estruturar um projeto Spring Boot para ser escalável e de fácil manutenção.
- Melhoria de boas práticas de desenvolvimento, como a criação de DTOs para transferir dados e a utilização de padrões como o Repository e o Service.

## Considerações

Este projeto foi uma experiência valiosa, tanto do ponto de vista técnico quanto social. Além de ter aprendido a desenvolver uma API completa utilizando o Spring Boot, também pude contribuir para um projeto que visa a inclusão social de pessoas autistas no mercado de trabalho. 

Através deste projeto, entendi a importância de pensar em soluções que atendam a uma diversidade de públicos, garantindo que a tecnologia possa ser usada para promover a igualdade de oportunidades.

Este aprendizado será essencial para futuros projetos na área de desenvolvimento back-end, e também reforça a relevância de criar soluções que tenham um impacto positivo na sociedade.
