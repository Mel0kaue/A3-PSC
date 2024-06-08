<h1>Sistema empréstimo de ferramentas</h1>

<h3>
  Tecnologias utilizadas:
</h4>

<div valign="top"><br>
  <img align="center" alt="gusdev-Java" height="50" width="50" src="https://raw.githubusercontent.com/tandpfun/skill-icons/de91fca307a83d75fc5b1f6ce24540454acead41/icons/Java-Dark.svg" />
   <img align="center" alt="gusdev-sql" height="50" width="50" src="https://raw.githubusercontent.com/tandpfun/skill-icons/de91fca307a83d75fc5b1f6ce24540454acead41/icons/MySQL-Dark.svg"/>
  <img align="center" alt="gusdev-Git" height="50" width="50" src="https://raw.githubusercontent.com/tandpfun/skill-icons/de91fca307a83d75fc5b1f6ce24540454acead41/icons/Git.svg"/>
</div>

<br/>

<h2>Objetivo</h2>

<p>Projeto para a UC de programação do curso de Análise e Desenvolvimento de Sistemas. O Sistema de Gerenciamento de Empréstimo de Ferramentas consiste em auxiliar no controle e organização do empréstimo de ferramentas. Este sistema oferece um conjunto de funcionalidades que permitem registrar informações detalhadas sobre as ferramentas, monitorar quem as pegou emprestadas, gerenciar as datas de empréstimo e gerar relatórios úteis para acompanhamento e análise. A seguir, uma descrição detalhada das principais funcionalidades e componentes do sistema:</p>

 <br/>

<h1>Principais funcionalidades</h1>

- <h4>func001: CRUD de Amigos - cadastrar, ler, atualizar e deletar amigos do bd</h4>
  <p>Essas operações permitem um controle completo sobre o cadastro e gerenciamento de amigo no sistema.</p>

- <h4>func002: CRUD de Ferramentas - cadastrar, selecionar, atualizar e deletar do bd</h4>
  <p>Essas operações permitem um controle completo sobre o cadastro e gerenciamento de ferramenta no sistema.</p>

- <h4>func003: CRUD de Empréstimos - cadastrar, selecionar, atualizar e deletar do bd</h4>
    <p>Essas operações permitem um controle completo sobre o cadastro e gerenciamento de empréstimos no sistema.</p>

- <h4>func004: Locação de Ferramentas</h4>
    <p>Essa operação permite registrar um empréstimo de uma ou mais ferramenta para um amigo</p>

- <h4>func005: Relatórios</h4>
    <p>Apresenta relatórios sobre as ferramentas cadastradas, empréstimos ativos, os empréstimos concluídos e o histórico de empréstimos de cada amigo. Além disso, o sistema também identifica os amigos que mais emprestaram ferramentas.</p>

  <br/>

<h1>Requisitos Funcionais</h1>

- <p>RF002 - Cadastrar amigo com nome e telefone.</p>
- <p>RF001 - Cadastrar ferramentas com nome, marca e custo de aquisição.</p>
- <p>RF003 - O sistema deve ter um relatório com todas as ferramentas cadastradas e o valor total gasto nelas.</p>
- <p>RF004 - O sistema deve ter um relatório com todos os amigos cadastrados incluindo nome e telefone</p>
- <p>RF005 - O sistema deve ter um relatório com todos os amigos que mais fazem empréstimos.</p>
- <p>RF006 - Registrar o empréstimo da(s) ferramentas(s) ao amigo, incluindo a data de empréstimo e devolução.</p>
- <p>RF007 - Mostrar relatório de todos os empréstimos ativos.</p>
- <p>RF008 - Mostrar relatório de todos os empréstimos realizados.</p>

  <br/>

<h1>Rodar o projeto</h1>
<h3>Pré-requisitos</h3>
<h3>Antes de rodaro projeto, verifique se você tem os seguintes softwares instalados:</h3>

- <h3><a href="https://www.oracle.com/br/java/technologies/downloads/#jdk21-windows">Java Development Kit (JDK) 21</a></h3>

- <h3><a href="https://dev.mysql.com/downloads/mysql/">Banco MySQL Server</a></h3>

- <h3><a href="https://maven.apache.org/download.cgi">Apache Maven</a></h3>

  <!-- <br/> -->

<h3>Configurando o Projeto</h3>

### <p>1 - Clone o repositório para sua máquina local:</p>
- <p>git clone https://github.com/Mel0kaue/SistemaDeEmprestimo.git</p>
- <p>cd SistemaDeEmprestimo</p>

### <p>2 - Configurando BD</p>
- <p>Usuário: root</p>
- <p>Senha: Unisul@1520</p>

### <p>3 - Crie em seu banco de dados uma database chamada: bd_a3</p>
- <p>Scripts usados no mySQL estão no arquivo banco.sql</p>
