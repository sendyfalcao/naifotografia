# 📸 Naifotografia API

> Sistema de gestão de fluxo de trabalho para fotógrafos e videomakers, desenvolvido para otimizar o acompanhamento de ensaios, edições e entregas.

---

## 🚀 Sobre o Projeto
O **Naifotografia** é uma solução Backend robusta que centraliza a gestão de ensaios fotográficos. O projeto nasceu da necessidade de facilitar o WorkFlow de uma profissional do AudioVisual, viabilizando o acesso dos clientes ao status de edição, links de seleção e entrega de fotos e simulação de orçamento em uma interface única e eficiente.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 17
* **Framework:** Spring Boot 3
* **Persistência de Dados:** Spring Data JPA / Hibernate
* **Banco de Dados:** MySQL (Hospedado via Aiven Cloud)
* **Segurança:** Spring Security (em implementação)
* **Gerenciamento de Dependências:** Maven
* **Deployment:** Docker & Render

---

## ⚙️ Funcionalidades (CRUD Completo)

- [x] **Cadastro de Ensaios:** Registro de clientes, valores, datas e tipos de ensaio.
- [x] **Listagem Dinâmica:** Consulta de todos os ensaios realizados e pendentes.
- [x] **Atualização de Status:** Controle em tempo real se as fotos foram selecionadas ou se o vídeo está em fase bruta/finalizada.
- [x] **Gestão de Links:** Armazenamento centralizado de links de entrega (Google Drive e YouTube).
- [x] **Exclusão de Registros:** Manutenção da base de dados.

---

## 🌐 Link de Acesso (API Live)

A API está documentada e rodando em ambiente de produção no Render:
🔗 [Acesse a API Naifotografia](https://naifotografia-api.onrender.com/ensaios)

> **⚠️ Nota:** Como a aplicação utiliza o plano gratuito do Render, o servidor entra em modo de hibernação após um período de inatividade. Caso o link demore a carregar (30-50 segundos), é apenas o processo de **Cold Start** (inicialização do servidor).

---

## 📂 Como rodar o projeto localmente

1. Clone o repositório:
   ```bash
   git clone [https://github.com/seu-usuario/naifotografia.git](https://github.com/seu-usuario/naifotografia.git)
Configure as variáveis de ambiente no seu application.properties ou no sistema:

SPRING_DATASOURCE_URL

SPRING_DATASOURCE_USERNAME

SPRING_DATASOURCE_PASSWORD

Execute o projeto via Maven ou sua IDE de preferência.

git add .