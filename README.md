# Simulador de Linguagens Formais e Autômatos

Um simulador educativo desenvolvido em JavaFX para demonstrar e validar conceitos fundamentais da teoria de linguagens formais e autômatos, incluindo **Expressões Regulares** e **Gramáticas Regulares**.

## 📋 Sobre o Projeto

Este projeto foi desenvolvido como uma ferramenta educativa para auxiliar no entendimento de Linguagens Regulares e seu potencial de representação. O simulador oferece uma interface gráfica intuitiva que permite aos usuários experimentar e validar diferentes tipos de linguagens formais.

## 🚀 Funcionalidades

### 1. Simulador de Expressões Regulares
- **Validação de Expressões**: Interface para inserção e validação de expressões regulares
- **Teste de Cadeias**: Verificação se uma cadeia de entrada é aceita pela expressão regular definida
- **Símbolos Especiais**: Botões auxiliares para inserção de símbolos como `|` (ou) e `ε` (epsilon/vazio)
- **Validação em Tempo Real**: Verificação da sintaxe da expressão regular durante a digitação

### 2. Simulador de Gramáticas Regulares
- **Definição Completa de Gramática**: Interface para definir todos os componentes de uma gramática formal:
  - **V**: Conjunto de símbolos não-terminais (variáveis)
  - **T**: Conjunto de símbolos terminais
  - **P**: Conjunto de regras de produção
  - **S**: Símbolo inicial
- **Validação de Derivações**: Verificação se uma cadeia pode ser gerada pela gramática
- **Execução Passo a Passo**: Visualização detalhada do processo de derivação
- **Valores de Teste**: Botão para carregar exemplos pré-definidos

## 🏗️ Arquitetura do Projeto

### Estrutura de Diretórios
```
proj-simulador-lfa-javafx/
├── src/main/
│   ├── java/
│   │   ├── module-info.java
│   │   └── unoeste/fipp/gabryelborges/projsimuladorlfajavafx/
│   │       ├── HelloApplication.java        # Classe principal
│   │       ├── HelloController.java         # Controlador da tela inicial
│   │       ├── ExpRegViewController.java    # Controlador de expressões regulares
│   │       ├── GramRegViewController.java   # Controlador de gramáticas regulares
│   │       └── entidades/
│   │           ├── Gramatica.java          # Modelo da gramática
│   │           └── Util.java               # Utilitários para exibição de mensagens
│   └── resources/
│       └── unoeste/fipp/gabryelborges/projsimuladorlfajavafx/
│           ├── hello-view.fxml             # Interface da tela inicial
│           ├── exp-reg-view.fxml           # Interface de expressões regulares
│           └── gram-reg-view.fxml          # Interface de gramáticas regulares
```

### Componentes Principais

#### 🎯 Classe Principal (`HelloApplication`)
Responsável por inicializar a aplicação JavaFX e carregar a interface principal.

#### 🏠 Controlador Principal (`HelloController`)
Gerencia a navegação entre as diferentes funcionalidades do simulador:
- Abertura da tela de Expressões Regulares
- Abertura da tela de Gramáticas Regulares
- Preparação para funcionalidade de Autômatos (em desenvolvimento)

#### 📝 Simulador de Expressões Regulares (`ExpRegViewController`)
**Características Técnicas:**
- **Validação de Sintaxe**: Utiliza regex pattern `^[0-9a-zA-Z*+|().ε{},]+$` para validar caracteres permitidos
- **Compilação de Regex**: Usa `Pattern.compile()` e `Matcher.matches()` do Java para testar cadeias
- **Tratamento de Símbolos Especiais**: Conversão automática de `ε` (epsilon) para string vazia
- **Interface Responsiva**: Validação em tempo real com feedback visual

#### 📚 Simulador de Gramáticas Regulares (`GramRegViewController`)
**Algoritmo de Validação:**
1. **Parsing dos Componentes**: Separação dos elementos V, T, P, S por vírgulas
2. **Verificação Inicial**: Validação se o símbolo inicial pertence ao conjunto de não-terminais
3. **Processo de Derivação**: 
   - Iteração através de cada símbolo da cadeia de entrada
   - Busca por regras de produção aplicáveis
   - Verificação de continuidade da derivação
4. **Validação Final**: Confirmação de que todas as variáveis foram consumidas

**Funcionalidades Avançadas:**
- **Modo Passo a Passo**: Armazena cada regra aplicada para visualização posterior
- **Validação Rigorosa**: Verificação de completude da derivação
- **Interface Adaptativa**: Desabilitação de botões baseada no estado dos campos

#### 🔧 Modelo de Dados (`Gramatica`)
Implementa a estrutura formal de uma gramática livre de contexto:
- **Encapsulamento**: Getters e setters para todos os componentes
- **Método `podeGerar()`**: Verifica se uma variável pode gerar um símbolo específico
- **Validação de Produções**: Análise da estrutura das regras de produção

## 🛠️ Tecnologias Utilizadas

- **Java 21**: Linguagem de programação principal
- **JavaFX 21**: Framework para interface gráfica
- **Maven**: Gerenciamento de dependências e build
- **FXML**: Definição declarativa das interfaces
- **Regex API**: Processamento de expressões regulares

## ⚙️ Como Executar

### Pré-requisitos
- Java 21 ou superior
- Maven 3.8+

### Execução
```bash
# Clone o repositório
git clone <url-do-repositorio>

# Navegue até o diretório do projeto
cd proj-simulador-lfa-javafx

# Execute com Maven
mvn clean javafx:run
```

### Build
```bash
# Gerar o executável
mvn clean compile
```

## 🎯 Exemplos de Uso

### Expressões Regulares
- **Expressão**: `a*b+`
- **Entrada Válida**: `aaabbb`
- **Entrada Inválida**: `bbaaa`

### Gramáticas Regulares
- **V**: `A,B,C`
- **T**: `a,b,c`
- **P**: `A->aB,A->aC,B->bC,B->b,B->bA,C->cA,C->c`
- **S**: `A`
- **Derivação**: `abc`

## 🔍 Características Técnicas

- **Arquitetura MVC**: Separação clara entre modelo, visão e controle
- **Programação Orientada a Eventos**: Resposta a ações do usuário em tempo real
- **Validação Robusta**: Múltiplas camadas de verificação de entrada
- **Interface Responsiva**: Feedback imediato para o usuário
- **Modularidade**: Componentes independentes e reutilizáveis
