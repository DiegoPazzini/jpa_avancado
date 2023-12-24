# jpa_avançado

O projeto em questão é uma aplicação Java que utiliza a tecnologia JPA (Java Persistence API) para persistência de dados em um banco de dados relacional. O foco principal é o gerenciamento de informações relacionadas a carros, marcas e acessórios automotivos.

O código está estruturado em pacotes que representam diferentes camadas da aplicação:

com.pazzini.domain: Contém as classes de domínio que representam entidades do sistema, como Carro, Marca e Acessorio. Essas classes são mapeadas para tabelas no banco de dados.

com.pazzini.dao: Agrupa interfaces e implementações de Data Access Objects (DAOs) responsáveis pela interação com o banco de dados. Os DAOs fornecem métodos para cadastrar e recuperar informações das entidades.

com.pazzini.test: Contém classes de teste JUnit, como CarroTest, que validam o correto funcionamento das operações de persistência.

Funcionalidades Principais:

Cadastro de Carros: Permite o cadastro de carros, associando-os a marcas e acessórios.

Cadastro de Marcas: Possibilita o registro de marcas de veículos, especificando um código e modelo.

Cadastro de Acessórios: Permite a inclusão de acessórios automotivos, indicando código, classificação e detalhes técnicos.

Relacionamentos entre Entidades: Utiliza relacionamentos como "muitos para muitos" entre carros e acessórios, e "um para muitos" entre marcas e carros.

Estrutura do Código:

com.pazzini.domain: Contém as entidades e suas configurações de mapeamento JPA.

com.pazzini.dao: Contém interfaces e implementações de DAOs responsáveis pela interação com o banco de dados.

com.pazzini.test: Classes de teste que validam as operações de persistência.

Execução dos Testes:

Os testes são realizados usando JUnit, garantindo a integridade e o correto funcionamento das operações de persistência.

Instruções para Execução:

Configure um banco de dados compatível com JPA (por exemplo, MySQL, PostgreSQL) e ajuste as configurações de persistência no arquivo persistence.xml.

Execute os testes unitários presentes em com.pazzini.test para verificar o funcionamento da aplicação.

## Skills utilizadas:
<div style="display: inline_block"><br>
   <img align="center" alt="Spring" height="50" width="50" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/spring/spring-original.svg">
  <img align="center" alt="Spring" height="60" width="60" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg">
