# Conversor de Moedas

Um conversor de moedas desenvolvido em **Java**, utilizando:

- [`HttpClient`](https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpClient.html) para realizar chamadas HTTP à API externa;
- Biblioteca [`Gson`](https://github.com/google/gson) para leitura e manipulação de dados JSON;
- A API pública [ExchangeRate API](https://www.exchangerate-api.com/) para obter taxas de câmbio em tempo real.

## 🔗 API Utilizada

- **URL Base:** `https://v6.exchangerate-api.com/v6/`
- Essa API fornece taxas de câmbio atualizadas com suporte a múltiplas moedas.

## 💡 Funcionalidades

- Conversão entre moedas com taxa de câmbio atualizada;
- Interface simples e objetiva;
- Comunicação via `HttpClient`;
- Análise de JSON com `Gson`.

## 📦 Requisitos

- Java 11 ou superior
- Internet ativa para consumir a API externa
- Biblioteca Gson adicionada ao projeto

🧑‍💻 Autor
Leonardo Alves Moreno

© 2025 Leonardo Alves Moreno. Todos os direitos reservados.

---
