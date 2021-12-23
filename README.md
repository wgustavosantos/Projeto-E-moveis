# UNIVERSIDADE FEDERAL DO PARÁ – UFPA<br>FACULDADE DE SISTEMAS DE INFORMAÇÃO<br>BACHARELADO EM SISTEMAS DE INFORMAÇÃO<br>Programação de Computadores II<br>Trabalho Acadêmico - Programação de Computadores 2
### Enunciado do projeto:

Tendo como base os conceitos e exemplos sobre Padrões de Projeto e Interface Gráfica em Java Swing que foram apresentados em aula, implemente um sistema com interface gráfica para gerenciamento de imóveis que estão à venda.
<br>O sistema deve permitir o cadastro de imóveis, atualização, exclusão e consulta de todos os imóveis que estão cadastrados em uma base de dados.
#### Para o cadastro de imóveis devem ser considerados os seguintes atributos:

- tipo (casa/apartamento);
- área (em m²);
- cor;
- qtd_comodos;
- endereco;
- valor;
- vendido (true/false).
#### No trabalho, devem ser considerados os seguintes padrões de projeto de software
##### Padrão DAO:
- Nas classes que fazem as operações CRUD (Create, Read, Update e Delete).
- Criar uma interface com os métodos do CRUD.
##### Padrão Singleton:
- Na classe ImovelDAO
##### Padrão Builder:
- Nas entidades
