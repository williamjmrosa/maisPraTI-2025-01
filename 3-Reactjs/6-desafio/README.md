Desafio: Aplicação React consumindo a API do IMDB

Visão Geral
Você deverá criar uma aplicação em React que consuma a API do IMDB (OMDb) para permitir que usuários busquem filmes, vejam detalhes e montem uma lista de favoritos.

Funcionalidades Obrigatórias

1. Página de Busca

   * Um campo de texto para o usuário digitar o termo.
   * Exibir lista de resultados com pôster, título, ano e botão para ver detalhes.

2. Paginação

   * Permitir navegar pelas páginas de resultados.

3. Página de Detalhes

   * Exibir informações completas (diretor, elenco, sinopse, avaliação) ao clicar em um filme.

4. Lista de Favoritos

   * Botão para adicionar/remover filmes da lista de favoritos.
   * Persistir favoritos em localStorage.

5. Tratamento de Erros & Loading

   * Exibir indicador enquanto aguarda resposta e mensagens de erro quando necessário.
   
# React + Vite

This template provides a minimal setup to get React working in Vite with HMR and some ESLint rules.

Currently, two official plugins are available:

- [@vitejs/plugin-react](https://github.com/vitejs/vite-plugin-react/blob/main/packages/plugin-react) uses [Babel](https://babeljs.io/) for Fast Refresh
- [@vitejs/plugin-react-swc](https://github.com/vitejs/vite-plugin-react/blob/main/packages/plugin-react-swc) uses [SWC](https://swc.rs/) for Fast Refresh

## Expanding the ESLint configuration

If you are developing a production application, we recommend using TypeScript with type-aware lint rules enabled. Check out the [TS template](https://github.com/vitejs/vite/tree/main/packages/create-vite/template-react-ts) for information on how to integrate TypeScript and [`typescript-eslint`](https://typescript-eslint.io) in your project.